package com.matthew.javabase.multiply;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-08-04 11:41
 */
public class MutilThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos= threadMXBean.dumpAllThreads(false,false);
        for(ThreadInfo threadInfo:threadInfos){
            System.out.println(""+"] "+threadInfo.getLockName());
        }
    }
}
