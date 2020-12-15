package com.kbtg.tech.controllers;

import com.kbtg.tech.services.OrderService;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
     
@Controller
public class CheckOutController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value="/Checkout")
    public String checkout() {
        return "checkout";
    }

    @PostMapping(value="/Confirm")
    public String confirm(@RequestParam Map<String, String> body, String name, Model model) {
        String chargeNo = orderService.confirm(body.get("token"));
        model.addAttribute("chargeNo", chargeNo);
        return "confirm";
    }

}
