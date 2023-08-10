package com.matthew.javabase.java8.domain;

import com.google.common.base.Objects;
import lombok.Data;

/**
 * @author : matthew
 * @description :
 * @date : 2021/11/11 上午11:09
 **/
@Data
public class Artist {
    //艺术家的名字（例如“甲壳虫乐队”）
    private String name;
    //乐队成员（例如“约翰 · 列侬”）
    private String members;
    //乐队来自哪里
    private String origin;
    //专辑中的一支曲目
    private Track track;
    //专辑
    private Album album;

    public Boolean isFrom(String from){
        return Objects.equal(origin,from);
    }
}
