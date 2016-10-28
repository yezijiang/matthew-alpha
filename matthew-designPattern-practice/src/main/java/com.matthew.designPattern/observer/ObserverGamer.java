package com.matthew.designPattern.observer;

/**抽象观察类
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-28 10:51
 */
public interface ObserverGamer {
    public String getName();
    public void setName(String name);
    public void help();
    public void beAttached(AllyControlCenter acc);
}
