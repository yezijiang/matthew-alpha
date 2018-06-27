package com.matthew.javabase.lang.keyword;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.CyclicBarrier;

/**
 * 讨论循环中标签的作用
 * continue和break可以改变循环的执行流程，但多重循环中，这两个语句都无法直接从内层魂环跳转到外层循环。
 * 因此java发明了带标签的continue和break语句，
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-08-24 11:37
 */
public class CycleMark {
    private void runNoMark(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print("("+i+","+j+")");
            }
            System.out.println();
        }
    }
    private void runSingelMark(){
        outer:for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(j==5) continue outer;
                System.out.print("("+i+","+j+")");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CycleMark cycleMark = new CycleMark();
        cycleMark.runSingelMark();
    }

}
