package com.cashbang.orderserviceapi.facade.dto;

/**
 * @Author: huangdj
 * @Date: 2021/1/8
 */
public class OrderDTO {

    private String orderId;

    private Double privice;

    private String orderAddress;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getPrivice() {
        return privice;
    }

    public void setPrivice(Double privice) {
        this.privice = privice;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }
}
