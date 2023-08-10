package com.matthew.javabase.java8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : matthew
 * @description :
 * @date : 2021/11/11 上午11:10
 **/
@Data
@AllArgsConstructor
public class Track {
    private String name;
    private Integer length;
}
