package com.matthew.spring.aop.partjdk;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-05-10 9:46
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        System.out.println("模拟删除topic记录："+topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void removeForum(int forumId){
        System.out.println("模拟删除forum记录:"+forumId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
