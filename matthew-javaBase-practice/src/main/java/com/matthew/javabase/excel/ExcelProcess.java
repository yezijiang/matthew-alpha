package com.matthew.javabase.excel;

import com.matthew.javabase.juc.People;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class ExcelProcess {
    public static AtomicReference<People> peopleAtomicReference = new AtomicReference<People>();
    public static void main(String[] args) throws IOException {

        FileReader fr=new FileReader("/Users/matthew/IdeaProjects/githubProjects/matthew-alpha/matthew-javaBase-practice/src/main/java/com/matthew/javabase/io/steel2的副本.txt");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        String[] arrs=null;





        People xiaoGao = new People(55,"xiaoGao");
        peopleAtomicReference.set(xiaoGao);
        System.out.println(peopleAtomicReference.get().getNickName());
        System.out.println(peopleAtomicReference.get().getWeight());
        xiaoGao.setNickName("xixi");
        System.out.println(peopleAtomicReference.get().getNickName());
        System.out.println(peopleAtomicReference.get().getWeight());
        People xiaoMa = new People(60,"xiaoMa");
        peopleAtomicReference.compareAndSet(xiaoGao,xiaoMa);
        System.out.println(peopleAtomicReference.get().getNickName());
        /**
         * 有效的注释隔离
         */



        while ((line=br.readLine())!=null) {
            log.info(line);
        }
        br.close();
        fr.close();
    }
}
