package com.matthew.designPattern.chainOfResponsibility;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-09 14:23
 */
public abstract class Approver {
    protected Approver successor;
    protected String name;//审批中姓名

    public Approver(String name) {
        this.name = name;
    }
    //设置后继者
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }
    public abstract void processRequest(PurchaseRequest request);
}
