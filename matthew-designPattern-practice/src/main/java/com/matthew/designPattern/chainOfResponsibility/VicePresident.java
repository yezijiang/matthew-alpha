package com.matthew.designPattern.chainOfResponsibility;

/**副总裁类 审核金额小于10W的订单
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-09 14:45
 */
public class VicePresident extends Approver {
    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getAmount()<100000){
            System.out.println("vicePresident"+this.name+"审批采购单"+request.getPurpose());
        }else{
            successor.processRequest(request);
        }
    }
}
