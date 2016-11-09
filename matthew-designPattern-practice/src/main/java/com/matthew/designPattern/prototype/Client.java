package com.matthew.designPattern.prototype;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-11 14:20
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WeeklyLog log_previous  = new WeeklyLog();
        log_previous.setName("tom");
        log_previous.setWeekNum(42);
        log_previous.setContent("日志内容");

        Attachment attachment = new Attachment();
        attachment.setName("附件一");

        log_previous.setAttachment(attachment);
        WeeklyLog log_new = log_previous.deepclone();
        System.out.println(log_previous== log_new);
        System.out.println(log_previous.getName() == log_new.getName());
        System.out.println(log_previous.getName());
        System.out.println(log_new.getName());
        System.out.println(log_previous.getAttachment() == log_new.getAttachment());


    }
}
