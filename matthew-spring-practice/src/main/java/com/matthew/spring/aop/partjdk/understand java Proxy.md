## 深入理解java proxy机制

#### 简介

动态代理其实就是`java.lang.reflect.Proxy`类动态的根据你指定的所有接口生成一个class byte，
该class会继承Proxy类，并实现你指定的所有接口，然后再利用你指定的classloader将calss byte加载
系统，最后生成一个类的对象，并初始化该对象的一些值，如invocationHandler,以即所有的接口对应的
Method成员。初始化之后该对象返回给调用的客户端，这样客户端拿到的就是一个实现你所有接口的Proxy
对象。
#### 简单实现
如文件夹内代码

 - 业务接口类 ForumService
 - 业务实现类 ForumServiceImpl
 - 业务代理类 PerformanceHandler
 - 客户端应用 TestForumService
 
其中分析其中的test代码

    ForumService target = new ForumServiceImpl();//希望被代理的业务类
    PerformanceHandler handler = new PerformanceHandler(target);
    ForumService proxy = (ForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    proxy.removeForum(10);
当客户端调用Proxy时，它只会调InvocationHandler的invoke接口，真正的调用关系如下
proxy.remove()->invocationHandler.invoke()->ForumServiceImpl.remove();
但是proxy到底是怎样一个对象呢，如下分析一下：

#### 深入分析
通过`System.out.println(proxy.getClass().getName());`看到这个proxy的类型是com.sun.proxy.$Proxy0。我们在写两个方法
把这个类打印出来打印的内容如下：
    
    com.sun.proxy.$Proxy0
    com.sun.proxy.$Proxy0 extends java.lang.reflect.Proxy implements com.matthew.spring.aop.partjdk.ForumService
    {
        java.lang.reflect.Method m1;
        java.lang.reflect.Method m2;
        java.lang.reflect.Method m3;
        java.lang.reflect.Method m4;
        java.lang.reflect.Method m0;
    
        boolean equals(java.lang.Object);
        java.lang.String toString();
        int hashCode();
        void removeForum(int);
        void removeTopic(int);
    }
显然Proxy.newProxyInstance方法会做以下几件事：
1. 根据传入的第二个参数interfaces动态生成一个类，实现interfaces中的接口，该例中Forumservice中的remove*方法。并且继承
了Proxy类，重写了hashcode,toString,equals等三个方法。具体实现可参看ProxyGenerator.generateProxyClass();
2. 通过传入的第一个参数classloader将刚生成的类加载到jvm中。
3. 利用第三个参数，调用$Proxy(InvocationHandler)构造函数创建，