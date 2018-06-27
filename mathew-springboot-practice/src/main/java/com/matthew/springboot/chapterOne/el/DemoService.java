package com.matthew.springboot.chapterOne.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2018-05-14 15:46
 */
@Service
public class DemoService {

    @Value("其他类的属性")//注入普通的字符串
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }

}
