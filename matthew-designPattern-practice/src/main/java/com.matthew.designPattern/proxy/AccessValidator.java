package com.matthew.designPattern.proxy;

/**
 * 身份验证类，业务类，提供方法验证用户身份。
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 17:09
 */
public class AccessValidator {
    public boolean validate(String userId){
        System.out.println("验证登录开始");
        return true;
    }
}
