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

#### 透明装饰模式与半透明装饰模式
装饰模式虽好但是存在一个问题，如果客户端希望单独调用具体装饰类新增的方法时存在一些问题。如下面的例子：
![文件对象功能增加实例结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\decorator_003.gif)
代码片段如下：

    Document doc; //使用抽象构件类型定义 
    doc = new PurchaseRequest(); 
    Approver newDoc; //使用具体装饰类型定义 
    newDoc = new Approver(doc); 
    newDoc.display();//调用原有业务方法 
    newDoc.approve();//调用新增业务方法
使用具体装饰类型声明，会导致客户端无法调用新增业务方法approve()，因为在抽象构建类Document中没有对approve()方法的声明。

- 透明装饰模式
在透明装饰模式中，要求客户端完全针对抽象编程，透明装饰模式可以让客户端透明的使用装饰之前的对象和装饰之后的对象，此外，还可以对一个已装饰过的对象进行多次装饰，得到更为复杂、功能更为强大的对象。
- 半透明装饰模式
透明装饰模式设计难度大，而且有时我们需要单独的条用新增的业务方法。那么是有个具体类型声明就是半透明装饰模式。代码如下

    ....
    Document doc;//使用抽象构件类型定义
    doc= new PurchaseRequest();
    Approver newDoc;//使用具体装饰类型定义
    newDoc = new Approver(doc);
    ....
    
半透明装饰模式可以给系统带来更多的灵活性，设计相对简单，但是其最大的缺点在于不能实现对同一个对象的多次装饰，而且客户端需要有区别地对待装饰之前的对象和装饰之后的对象。
####装饰模式注意事项
在使用装饰模式时，需要注意的问题：

- 尽量保持装饰类的接口与被装饰类的接口相同，即我们应该尽量使用透明装饰模式。
- 尽量保持具体构件类ConcreteComponent是一个"轻"类。
- 如果只有一具体构件类，那么抽象装饰类可以作为该具体构件的直接子类。如下图
![没有抽象构件类的装饰](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\decorator_004.gif)

####装饰模式总结
装饰模式降低了系统的耦合度，可以动态增加或删除对象的职责，并使得需要装饰的具体构件类和具体装饰类可以独立变化。装饰模式应用广泛，比如javaI/O包。
**主要优点：**

- 对于扩展一个类的功能，装饰模式比继承模式更加灵活，不糊导致类的个数急剧增加。
- 可以通过一个动态的方式增加一个对象的功能，
- 可以对一个对象进行多次装饰。
- 具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装饰类。
**主要求点：**

- 使用装饰模式进行系统设计时将会产生很多小对象。而且因为这些排错较为困难。
**使用场景**

在以下情况下可考虑试用装是模式：

- 在不影响其他对象的情况下，动态、透明的为单个对象添加职责。
- 当不能采用继承方式对系统进行扩展或者继承不利于系统扩展或维护时。（一、系统中存在大量独立的扩展，为支持每一个扩展或扩展之间的组合会产生大量的子类，二，类定义为不能被继承） 