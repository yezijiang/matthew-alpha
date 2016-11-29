package com.matthew.javabase.virtualMachine;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-07-28 14:39
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK= null;
    public void isAlive(){
        System.out.println("hi i'm still alive.: )");
    }
    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("fizalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK == null){
            System.out.println("OMG i'm dead :(");
        }else{
            SAVE_HOOK.isAlive();
        }
        //下面这段代码完全一样但是自救失败
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK == null){
            System.out.println("OMG i'm dead :(");
        }else {
            SAVE_HOOK.isAlive();
        }

    }
}
