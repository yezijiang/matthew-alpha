##LinkedList源码剖析
####LinkedList简介
LinkedList是基于双向循环列表实现的，除了可以当做链表来操作外，它还可以当做栈，队列和双端队列来使用。
LinkedList同样是线程不安全的，只在单线程下适合使用。
####LinkedList源码剖析（jdk1.7）
todo
####几点总结
1. 从源码中很明显可以看出，LinkedList的实现是基于双向循环链表的，且头结点中不存放数据;
![Linkedlist数据结构](file:///F:\yaoyaohao\workspaceIdea\matthew-alpha\matthew-javaBase-practice\src\main\webapp\webstatic\images\linkedlist_001.jpg)
2. 注意两个不同的构造方法。无参构造方法直接建立一个仅包含head节点的空链表，包含Collection的构造方法，先调用无参构造方法建立一个空链表，而后将Collection中的数据加入到链表的尾部后面。
3. 在查找和删除某元素时，源码中都划分为该元素为null和不为null两种情况来处理，LinkedList中允许元素为null。
4. LinkedList是基于链表实现的，因此不存在容量不足的问题，所以这里没有扩容的方法。
5. 注意源码中的Entry<E> entry(int index)方法。该方法返回双向链表中指定位置处的节点，而链表中是没有下标索引的，要指定位置出的元素，就要遍历该链表，从源码的实现中，我们看到这里有一个加速动作。源码中先将index与长度size的一半比较，如果index<size/2，就只从位置0往后遍历到位置index处，而如果index>size/2，就只从位置size往前遍历到位置index处。这样可以减少一部分不必要的遍历，从而提高一定的效率（实际上效率还是很低）。
6. 注意链表类对应的数据结构Entry。如下;
    // 双向链表的节点所对应的数据结构。    
    // 包含3部分：上一节点，下一节点，当前节点值。    
    private static class Entry<E> {    
        // 当前节点所包含的值    
        E element;    
        // 下一个节点    
        Entry<E> next;    
        // 上一个节点    
        Entry<E> previous;    
      
        /**   
         * 链表节点的构造函数。   
         * 参数说明：   
         *   element  —— 节点所包含的数据   
         *   next      —— 下一个节点   
         *   previous —— 上一个节点   
         */   
        Entry(E element, Entry<E> next, Entry<E> previous) {    
            this.element = element;    
            this.next = next;    
            this.previous = previous;    
        }    
    }

7. LinkedList是基于链表实现的，因此插入删除效率高，查找效率低（虽然有一个加速动作）。
8. 要注意源码中还实现了栈和队列的操作方法，因此也可以作为栈、队列和双端队列来使用。