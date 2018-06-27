package com.matthew.designPattern.singleton;

import java.io.*;

/**
 * 防止单例在反序列化后成多例
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-01 11:56
 */
public class SingletonTest implements Serializable{

    private static final long serialVersionUID = 532062232509911558L;
    private static final SingletonTest instance = new SingletonTest();
    public static SingletonTest getInstance(){
        return instance;
    }
    private SingletonTest(){}


    /**
     * 防止单例子序列化后生成“多例”
     * @return

    private Object readResolve(){
        return instance;
    }*/
    public SingletonTest deepCopy() throws Exception{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(SingletonTest.getInstance());

        InputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        SingletonTest test = (SingletonTest)ois.readObject();
        return test;
    }

    /**
     * 打印出的地址是否一致
     * 如果注释readResolve()注释之后是否一致。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(SingletonTest.getInstance());
        try {
            System.out.println(SingletonTest.getInstance().deepCopy());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
