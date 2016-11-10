package com.matthew.designPattern.chainOfResponsibility;

/** 主任类 审核金额小于5W的采购单
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-09 14:43
 */
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<50000){
            System.out.println("director："+this.name+"审批采购单："+request.getPurpose());
        }else{
            successor.processRequest(request);
        }
    }
}
