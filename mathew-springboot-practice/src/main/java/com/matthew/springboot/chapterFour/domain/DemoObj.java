package com.matthew.springboot.chapterFour.domain;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-19 9:19
 */
public class DemoObj {
    private Long id;
    private String name;

    public DemoObj() {
    }

    public DemoObj(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
