## 不兼容结构的协调--适配器模式
我国的家庭用电220V,而一般的笔记本电脑是20V,如何让20C的笔记本能够在220V的电压下工作？答案是引入一个电源适配器（AC Adapter）,俗称电源适配器。
####适配器模式概述
与电源适配器相似，在适配器模式中引入称为适配器的包装类，适配器的实现就是把客户类的请求转化为对适配者的相应接口的调用。
适配器模式（Adapter Pattern）：将一个接口转换成客户希望的另一个借口，使接口不兼容的那些类可以一起作，其别名为包装器（wrapper）。根据适配器类和适配者的关系不同，适配器模式可以分为两种：

- 对象适配器 在对象适配器模式中，适配器与适配者之间是关联关系；
- 类适配器  在类适配模式中，适配器与适配者是继承关系

![对象适配器模式结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\adapter_001.jpg)
####对象适配器模式结构

- target(目标抽象类)：目标头像类定义客户所需要接口。
- Adapter(适配器类)：适配器可以调用适配者，作为一个转换器，对Adaptee和Target进行适配。
- Adaptee(适配者类)：提供功能的已存在的接口，这个接口需要适配，它包含了客户希望使用的业务方法，但是和接口参数不搭。

#### 对象适配器
![算法重用结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\adapter_002.jpg)
在图中，ScoreOperation接口充当抽象目标，QuickSort和BinarySearch类充当适配者，OperationAdapter充当适配器。

#### 类适配器
类适配器模式和对象适配器模式的最大区别在于适配器和适配者的关系，对象适配器模式中adapter和adaptee之前是关联关系，而类适配器模式中adapter和adaptee是结合才能关系如下图
![类适配器模式结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\adapter_003.jpg)
如图 类适配器就是adapter类实现了抽象目标接口Target，并继承了Adaptee类。
####### 缺省适配器
缺省适配器模式：当不需要一个接口提供的所有方法时，可设计一个抽象类实现该接口，并为接口的每个实现提供一个默认，那么该抽象类的子类可以选择性的覆盖父类的某些方法来实现需求，它适用于不想使用接口中所有的方法的情况，又称为单接口适配器模式。
#### 适配器模式总结
**主要优点：**

- 使目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无需修改原有结构。
- 增加类的透明性和复用性，
- 灵活性和扩展性都很好，通过配置文件，可以很灵活的更换adapter，
- 尤其对象适配器可以把多个不同的适配者适配到同一个目标。
- 可以适配一个适配者的子类，由于adapter和adaptee的关联关系，根据“里氏代换原则”adaptee的子类也可以通过该适配器进行适配。

**主要缺点：**

- 类适配器：对于java、c#不支持多重集成的语言，一次只能适配一个适配者类，不能同时适配多个适配者。
- 类适配器：适配者不能为最终类。
