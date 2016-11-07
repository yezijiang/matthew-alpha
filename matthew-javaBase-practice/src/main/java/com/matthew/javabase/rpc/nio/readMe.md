##RPC框架几行代码就够了
代码来源于梁飞的blog，核心代码是RpcFramework这个类，RpcFramework提供暴露服务和引用服务两个方法，然后定义服务接口和实现，
服务器端：rpcProvider暴露调用rpcFramework类，暴露服务，
客服端：rpcConsumer引用服务，传入接口，调用的方式，传入的参数

**nio版**

- 增加了序列化和反序列化的工具类SerializableUtil
- 封装了请求体RpcTransactionBody
- 将io变更为nio
