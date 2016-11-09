package com.matthew.designPattern.prototype;

import java.io.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-11 14:15
 */
public class WeeklyLog implements Serializable{
    public String name;
    public int weekNum;//第几周
    public String content;
    public Attachment attachment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    /**
     * 实现cloneable 实现了浅复制
     * @return

    public WeeklyLog clone(){
        Object obj = null;
        try {
            obj = super.clone();
            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制");
            return null;
        }
    }
     */
    public WeeklyLog deepclone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //读取开始序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog)ois.readObject();
    }
}
