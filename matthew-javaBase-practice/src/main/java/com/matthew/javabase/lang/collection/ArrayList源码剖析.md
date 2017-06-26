##ArrayList源码剖析
####ArrayList简介
Array是基于数组实现的，是一个动态数组，其容量能自动增长，类似于c语言中的动态申请内存，动态增长内存。

ArrayList不是线程安全的，只能用在单线程环境下，多线程环境下可以考虑用Collection.synchronizedList(List l)函数返回一个
线程安全的ArrayList类，也可以使用Concurrent并发包下的CopyOnWriteList类。

ArrayList实现了Serializable接口，因此它支持序列化，能够通过序列化传输，实现了RandomAccess接口，支持快速随机访问，实际上就是通过下表序号进行快速访问，实现了Cloneable接口，能被克隆。

####源码剖析
    // 添加元素e    
    public boolean add(E e) {    
        // 确定ArrayList的容量大小    
        ensureCapacity(size + 1);  // Increments modCount!!    
        // 添加e到ArrayList中    
        elementData[size++] = e;    
        return true;    
    }
    // 确定ArrarList的容量。    
    // 若ArrayList的容量不足以容纳当前的全部元素，设置 新的容量=“(原始容量x3)/2 + 1”    
    public void ensureCapacity(int minCapacity) {    
        // 将“修改统计数”+1，该变量主要是用来实现fail-fast机制的    
        modCount++;    
        int oldCapacity = elementData.length;    
        // 若当前容量不足以容纳当前的元素个数，设置 新的容量=“(原始容量x3)/2 + 1”    
        if (minCapacity > oldCapacity) {    
            Object oldData[] = elementData;    
            int newCapacity = (oldCapacity * 3)/2 + 1;    
            //如果还不够，则直接将minCapacity设置为当前容量  
            if (newCapacity < minCapacity)    
                newCapacity = minCapacity;    
            elementData = Arrays.copyOf(elementData, newCapacity);    
        }    
    }

####几点总结
1. 三个构造方法。无参构造方法构造的ArrayList的容量默认为10，带有Collection参数的构造方法，将Collection转化为数组赋给Arraylistde的实现数组elementData。
2. 每次add都要添加扩容方法ensureCapacity。每次扩容为*1.5+1。当容量不足时，每次增加容量，都要将原来的元素拷贝到一个新的数组中，非常耗时，因此建议在实现知道元素数量的情况下，才使用ArrayList。
3. ArrayList的实现中大量调用了Arrays.copyof()和System.arraycopy()方法。下面看一看源码
    
    public static <T> T[] copyOf(T[] original, int newLength) {
        return (T[]) copyOf(original, newLength, original.getClass());
    } 
很明显调用了另一个copyof方法，该方法有三个参数，最后一个参数指明要转换的数据的类型，其源码如下：
    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {  
        T[] copy = ((Object)newType == (Object)Object[].class)  
            ? (T[]) new Object[newLength]  
            : (T[]) Array.newInstance(newType.getComponentType(), newLength);  
        System.arraycopy(original, 0, copy, 0,  
                         Math.min(original.length, newLength));  
        return copy;  
    }  
可以很明显的看出，该方法实际上就是在内部创建了一个长度为newLength的数据，调用System.arraycopy方法，将原数组元素复制到新的数组中。
下面来看System.arraycopy方法，被标记了native方法，调用了系统的C/C++代码，该函数实际上最终调用了C语言的memmove()函数，因此它可以保证同一个数组内元素的正确复制和移动，比一般的复制方法的实现效率要高很多，很适合用来批量处理数组。Java强烈推荐在复制大量数组元素时用该方法，以取得更高的效率。
4. 注意ArrayList的两个转化为数组的toArray()。
第一个，bject[] toArray()方法。如果直接用向下转型的方法，将整个ArrayList集合转变为指定类型的Array数组，便会抛出该异常。
第二个，<T> T[] toArray(T[] a)方法。该方法可以直接将ArrayList转换得到的Array进行整体向下转型（转型其实是在该方法的源码中实现的），且从该方法的源码中可以看出，参数a的大小不足时，内部会调用Arrays.copyOf方法，该方法内部创建一个新的数组返回，因此对该方法的常用形式如下：
    public static Integer[] vectorToArray2(ArrayList<Integer> v) {    
        Integer[] newText = (Integer[])v.toArray(new Integer[0]);    
        return newText;    
    }    
5. ArrayList基于数组实现，可以通过下标索引直接查找到指定位置的元素，因此查找效率高，时间复杂度O(1)，但是每次插入删除元素，都要大量的移动元素，删除删除的效率低。