package com.matthew.spring.aop.sourceCode;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-10-29 15:12
 */
public class TestBean {
    private String testStr="testStr";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
    public void test(){
        System.out.println("test");
    }
}
