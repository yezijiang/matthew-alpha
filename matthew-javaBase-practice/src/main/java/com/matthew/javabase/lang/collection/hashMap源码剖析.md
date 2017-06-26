##HashMap源码剖析
####HashMap简介
hashmap是基于哈希表实现的，底层数据结构为数组加单向链表。
hashmap是非线程安全的，只是用于单线程环境下，多线程环境可以采用concurrent并发包下的concurrentHashMap。
####HashMap源码剖析
