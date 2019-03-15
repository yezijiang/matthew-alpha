package com.matthew.javabase.lombok;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-03-01 11:20
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SysUserEntity {
    private String userId;
    private String userName;
    private int age;
    private String sex;
}
