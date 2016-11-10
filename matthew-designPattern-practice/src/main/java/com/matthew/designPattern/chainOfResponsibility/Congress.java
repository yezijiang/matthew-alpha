package com.matthew.designPattern.chainOfResponsibility;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-09 14:50
 */
public class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("召开董事会审批采购单："+request.getPurpose());
    }
}
