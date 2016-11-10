package com.matthew.designPattern.chainOfResponsibility;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-09 14:48
 */
public class President extends Approver {
    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<500000){
            System.out.println("president"+this.name+"审批采购单"+request.getPurpose());
        }else{
            this.successor.processRequest(request);
        }
    }
}
