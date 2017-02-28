package com.matthew.spring.chapter3;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-09 17:40
 */
public class DependentBean {
    ResourceBean resourceBean;
    public void write(String ss) throws IOException {
        System.out.println("dependentBean:====写资源");
        resourceBean.getFos().write(ss.getBytes());
    }
    public void init() throws IOException {
        System.out.println("dependentBean:====初始化");
        resourceBean.getFos().write("DependentBean:====".getBytes());
    }
    public void destroy() throws IOException {
        System.out.println("dependentBean:==== 销毁");
        //在销毁之前，先在文件中写销毁内容
        resourceBean.getFos().write("DependentBean:====销毁===".getBytes());
    }

    public void setResourceBean(ResourceBean resourceBean) {
        this.resourceBean = resourceBean;
    }
}
