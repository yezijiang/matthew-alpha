package com.matthew.designPattern.decorator;

/**窗体类：具体构件类
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 11:04
 */
public class Window extends Component{
    @Override
    public void display() {
        System.out.println("显示窗体");
    }
}
