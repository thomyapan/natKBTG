package com.kbtg.tech.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column
    private String reference_order;
    
	@Column
    private String req_param;
    
	@Column
    private String resp_param;
    
    @Column 
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setReference_order(String reference_order) {
        this.reference_order = reference_order;
    }

    public String getReference_order() {
        return reference_order;
    }

    public void setReq_param(String req_param) {
        this.req_param = req_param;
    }

    public String getReq_param() {
        return req_param;
    }

    public void setResp_param(String resp_param) {
        this.resp_param = resp_param;
    }

    public String getResp_param() {
        return resp_param;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
