package com.matthew.designPattern.chainOfResponsibility;

/**
 * 采购单：
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-09 14:24
 */
public class PurchaseRequest {
    private int number;//采购单编号
    private double amount;//采购金额
    private String purpose;//采购目的

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public PurchaseRequest( double amount, int number,String purpose) {
        this.number = number;
        this.amount = amount;
        this.purpose = purpose;
    }
}
