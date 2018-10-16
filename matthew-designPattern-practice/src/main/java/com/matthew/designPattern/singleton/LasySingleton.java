package com.matthew.designPattern.singleton;

/**
 * 懒汉式就是入门的单例模式了
 * 为避免多线程调用getInstance时创建多个对象使用 synchronized
 * 使用双重检查锁
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-11 10:33
 */
public class LasySingleton {
    /**
     *1+2 入门式+同步锁整个getInstance();
    private  static LasySingleton lasySingleton = null;
    private LasySingleton(){};
    public  synchronized static LasySingleton getInstance(){
        if(lasySingleton == null){
            lasySingleton = new LasySingleton();
        }
        return lasySingleton;
    }*/
    private  static LasySingleton lasySingleton = null;
    private LasySingleton(){};
    public static LasySingleton getInstance(){
        if(lasySingleton == null){
            synchronized (LasySingleton.class){
                if(lasySingleton == null){
                    lasySingleton = new LasySingleton();
                }
            }
        }
        return lasySingleton;
    }
    /**
     * 上面的double-check locking DCL不幸的是无论在优化型的编译器下还是在共享内存处理器中都不能有效的工作。
     * http://ifeve.com/doublecheckedlocking/
     * 加volitile
     */
}
