package com.matthew.javabase.virtualMachine;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-28 10:30
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF jvs= new JavaVMStackSOF();
        try{
            jvs.stackLeak();
        }catch (Throwable e){
            System.out.println(jvs.stackLength);
            throw e;
        }

    }
}
