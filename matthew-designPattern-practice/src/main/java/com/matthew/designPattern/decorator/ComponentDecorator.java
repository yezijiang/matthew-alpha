package com.matthew.designPattern.decorator;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 11:22
 */
public class ComponentDecorator extends Component {
    private Component component;//维持对抽象构件类型对象的引用。

    public ComponentDecorator(Component component){//注入抽闲构件类型的引用
        this.component = component;
    }
    @Override
    public void display() {
        component.display();
    }
}
