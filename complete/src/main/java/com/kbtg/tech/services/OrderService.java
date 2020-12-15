package com.kbtg.tech.services;

import java.io.IOException;

import com.kbtg.tech.dto.Order;
import com.kbtg.tech.repositories.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class OrderService {

    private String url = "https://dev-kpaymentgateway-services.kasikornbank.com/card/v2/charge";
    private String pKey = "skey_test_1nOxF19iQM1qIfeyFFWs1F9plaKHqibaH";

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private OkHttpClient client = new OkHttpClient();

    @Autowired
    private OrdersRepository ordersRepository;

    public String confirm (String token) {

        //TODO: Bonus point, please help me to create a unique reference_order per each order.

        String referenceOrder = "INV12345671111112";

        try {

            String jsonReq = "{\"token\":\""+ token + "\"," + 
                             "\"mode\":\"token\"," + 
                             "\"currency\":\"THB\"," +
                             "\"amount\":\"199\"," + 
                             "\"description\":\"\"," + 
                             "\"reference_order\":\"" + referenceOrder + "\"," + 
                             "\"source_type\":\"card\"}";

            Order order = new Order();
            order.setReference_order(referenceOrder);
            order.setReq_param(jsonReq);
            order.setStatus("Pending");
            
            RequestBody body = RequestBody.create(JSON, jsonReq);
            Request request = new Request.Builder().header("x-api-key", pKey).url(url).post(body).build();
            Response response = client.newCall(request).execute();
            String resp = response.body().string();

            if (resp != null && resp.contains("error")) {
                order.setResp_param(resp);
                order.setStatus("Failed");
            } else {
                order.setResp_param(resp);
                order.setStatus("completed");
            }

            ordersRepository.save(order);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return referenceOrder;
    }
    
}
