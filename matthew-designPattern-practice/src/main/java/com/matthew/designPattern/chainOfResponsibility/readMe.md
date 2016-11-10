##请求的链式处理-职责链模式
####责任链模式概述
很多情况下，在一个系统中可以处理某个请求的对象不止一个，常见的职责链式是直线型，可以使一个树形结构或者一个环。
**职责链模式：**（chain of responsibility pattern）:避免请求发送者与接受者耦合在一起，让多个对象都有可能接受请求，将这些请求连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。职责链模式是一种对象行为模式。
职责链模式结构的核心在于引进了一个抽象处理者。
![职责链模式结构图](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-designPattern-practice\src\main\webapp\webstatic\images\chain_001.gif)
