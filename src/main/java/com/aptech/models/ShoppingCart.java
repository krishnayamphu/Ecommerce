package com.aptech.models;

public class ShoppingCart {
    int id;
    int cid;
    int pid;
    int orderStatusCode;
    int quantity;

    public ShoppingCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(int orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
