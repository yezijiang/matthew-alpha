package com.matthew.designPattern.chainOfResponsibility;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-09 14:51
 */
public class Client {
    public static void main(String[] args) {
        Approver temeLeader,financeVp,ministor,primeMinistor;
        temeLeader = new Director("部长");
        financeVp = new VicePresident("副总裁");
        ministor = new President("总裁");
        primeMinistor = new Congress("董事会");

        temeLeader.setSuccessor(financeVp);
        financeVp.setSuccessor(ministor);
        ministor.setSuccessor(primeMinistor);
        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000,10001,"购买倚天剑");
        temeLeader.processRequest(pr1);

        PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");
        temeLeader.processRequest(pr2);

        PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");
        temeLeader.processRequest(pr3);

        PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");
        temeLeader.processRequest(pr4);
        /**
         * 如果增加一个具体类或者增加一个经理角色，需要编写一个新的具体处理类mananger。
         * 由于链的处理过程由客户端负责，增阿基新的处理类，对原有类库没有任何影响，
         */
    }
}
