## 对象间的联动--观察者模式
####观察者模式概述
Observer Pattern定义对象之间的一种一对多依赖关系，使得每当一个对象发生改变时，其相关依赖对象皆得到通知并被自动更新。观察者模式的别名包括订阅-发布模式、源-监听模式，观察者模式通常包括观察目标和观察者两个继承层次结构，其结构图如下：
![观察者模式结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\observer_001.jpg)
观察者模式结构图包含了如下几个角色：

- Subject(目标)：目标又称为主题，它是指被观察的对象。在目标中定义了观察者集合，一个观察目标可以接受任意数量的观察者来观察。
- ConcreteSubject(具体目标)：具体目标是目标类的子类，当它的状态发生改变时，向它的各个观察者发出通知；同时它还实现在目标类中定义的抽象业务逻辑方法。
- Observer(观察者)：观察者将对观察目标的改变做出反应，观察者一般定义为接口。该接口声明了更新数据的方法update，因此又被成为抽象观察者。
- ContreteObserver(具体观察者)：在具体观察者中维护一个指向具体目标对象的引用，它存储了具体观察者的有关状态。
**相关代码**在 com.matthew.designPattern.observer中

####完整解决方案
为了实现对象之间的联通，使用观察者模式来进行多人联机对战游戏的设计：
![多人联机对战游戏结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\observer_002.jpg)
综合上面的游戏结构图，看到目标类都定持有多个observer，有时Observer需要使用目标类。
**相关代码**在 com.matthew.designPattern.observer中

####JDK对观察者模式的支持
观察者模式在java语言中的地位非常重要，在JDK的java.util包中，提供了Observable类和Observer接口，他们构成了JDK对观察者模式的支持，如下图
![JDK提供的Observable类及Observer接口结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\observer_003.jpg)

- **Observer接口**：在java.util.Observer接口中只声明了一个方法，当观察目标的状态发生变化时该方法将会被调用，当调用观察目标类Observable的notifyObservers()方法时，将执行观察者类中的update()方法。
- **Observable类**：java.util.Observable类充当观察目标类，在Observable中定义了一个向量Vector来存储观察者对象。

#### 观察者模式和java事件处理
JDK1.0及更早的版本的事件模型是职责链模式，但是这种模式不适合复杂的系统，因此在随后的版本中，事件处理模型采用基于观察者模式的委派事件模型（Delegation DEM）,即一个java组件所引发的事件不是由对象自己负责处理，而是委派给独立的事件处理对象负责。

在DEM模型中，事件的发布者成为事件源（even source），而订阅者称为事件监听器（Event listener），在这个过程中还可以通过事件对象（even object）来传递与事件相关的信息。以按钮点击为例，其事件处理流程如下：

- 用户在GUI中点击一个按钮，将触发一个事件，JVM将产生一个相应的ActionEven类型的事件对象，此按钮是事件源对象。
- 将ActioEvent事件传递个事件监听对象，提供一个ActionListener的实现类（如MyActionHandler），并实现接口中声明的抽象事件处理方法actionPerformed()，对发生事件做出相应处理。
- 开发人员将ActionListener接口的实现类（如MyActionHandler）对象注册到按钮中，可以通过按钮类的addActionListener()方法来实现注册；
- JVM在触发事件时将调用按钮的fireXXX()方法，在该方法内部将调用注册到按钮中的事件处理对象的actionPerformed()方法，实现对事件的处理。

使用类似的方法，我们可以自定义GUI组件：
![自定义登录组件结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\observer_004.jpg)
**观察者模式和MVC**：在当前流行的MVC架构中也应用了观察者模式，其中model可对应观察者模式中的观察目标，而试图view队形观察者，控制器可以充当两者之间的中介者。
####观察者模式总结
**主要优点**：

- 观察者模式可以实现表示层和数据逻辑层的分离，定义了稳定的消息传递机制，并抽象了更新接口，使得有各种不同的表示层充当具体的观察者角色
- 可以再观察目标和观察者之间建了一个抽象的耦合，观察目标只需要维持一个抽象观察者的集合，无需了解其具体的观察者。
- 支持广播通信，观察目标会向所有已注册的观察对象发送通知。
- 满足‘开闭原则’，增加新的观察目标也很方便。

**主要缺点：**

- 如果一个观察目标对象有很多直接和间接观察者，将所有的观察者都通知到会花费很多时间。
- 如果在观察者和观察目标之间存在循环依赖，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
- 观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。

**使用场景：**

- 一个抽象有两个方面，其中一个方面依赖另一个方面，将者两个方面封装在独立的对象中使他们可以各自独立地改变和复用。
- 一个对象的改变将导致一个或多个其他对象也发生改变，而并不知道具体有多少对象将发生改变，也不知道这些对象是谁。

