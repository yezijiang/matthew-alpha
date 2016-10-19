## 扩展系统功能-装饰模式
#### 概述
装饰者模式（decorator pattren）：动态的给一个对象增加一些额外的职责，就增加对象功能来说，装饰者模式比生成子类实现更为灵活。通常定义一个抽象装饰类，将具体的装饰类作为其子类：
![装饰模式结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\decorator_001.gif)
在装饰模式结构图中包含一下几个角色：

- Component（抽象构建）：它是具体构件和抽象装饰器的共同父类，声明了再具体构件中实现的业务方法，他的引入可以是客户端以一致的方式处理未被装饰的对象以及装饰后的对象，实现客户端的透明操作。
- ConcreteComponent（具体构件）：装饰器可以给它增加额外的职责。
- Decorator（抽象装饰类）：用于给具体构件增加职责，具体的职责在其子类中实现，它维护一个指向抽象构件对象的引用（被装饰构件），通过该引用可以调用装饰之前构件对象的方法，并通过其子类扩展该方法，已达到装饰的目的。
- ContreteDecoratorA(具体装饰类)
由于在抽象装饰类Decorator中注入的是Component类型的对象，那么可以将一个具体构件对象注入，或者将一个已经装饰多的decorator子类的对象再注入进行多次装饰。
> **思考**
是否在装饰模式中找出两个独立变化的维度？是比较装饰模式和桥接模式的相同之处和不同之处？

相同之处：

 - 都是对多重继承的改造。避免产生大量的子类。
不同之处：
  
- 装饰模式是在具体化角色固定而，抽象化维度可能发生变化时所采用的。

#### 完整解决方案
  ![图形界面构件结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\decorator_002.gif)
其中，Component充当抽象类构件，其子类Window、TextBox、ListBox充当具体构件类，Componnet类的另一个子类ComponentDecorator充当抽象装饰类。