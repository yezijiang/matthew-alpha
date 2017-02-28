package com.matthew.javabase.lang;

import java.io.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-24 11:56
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        User user2=null;
        user.setUserName("akg");
        user.setPassword("123");
        System.out.println("read before serializable");
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());

        try {
            ObjectOutputStream os =  new ObjectOutputStream(new FileOutputStream("F:/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            user.setUserName("森海塞尔");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:/user.txt"));
            user2 = (User) ois.readObject(); // 从流中读取User的数据
            ois.close();
            System.out.println("read from serializable");
            System.out.println(user2.getUserName());
            System.out.println(user2.getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
