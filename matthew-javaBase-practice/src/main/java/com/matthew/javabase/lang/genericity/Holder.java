package com.matthew.javabase.lang.genericity;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-25 11:02
 */
public class Holder<T> {
    private T leftHandHolder;
    private T rightHandHolder;
    private T bagHolder;
    private Holder(T leftHandHolder,T rightHandHolder,T bagHolder){
        this.leftHandHolder = leftHandHolder;
        this.rightHandHolder = rightHandHolder;
        this.bagHolder = bagHolder;
    }
    public T getLeftHandHolder() {
        return leftHandHolder;
    }

    public void setLeftHandHolder(T leftHandHolder) {
        this.leftHandHolder = leftHandHolder;
    }

    public T getRightHandHolder() {
        return rightHandHolder;
    }

    public void setRightHandHolder(T rightHandHolder) {
        this.rightHandHolder = rightHandHolder;
    }

    public T getBagHolder() {
        return bagHolder;
    }

    public void setBagHolder(T bagHolder) {
        this.bagHolder = bagHolder;
    }

    public static void main(String[] args) {
        Gun ak =new Gun("AK");
        Gun m = new Gun("m");
        Gun Handgun = new Gun("Handgun");
        Holder<Gun> holder = new Holder<Gun>(ak,m,Handgun);
        holder.getLeftHandHolder().shut();
    }


}

class Gun{
    String name;
    public Gun(String name){
        this.name= name;
    }
    public void shut(){
        System.out.println(name+"dudududu~~~~~~~");
    }
}