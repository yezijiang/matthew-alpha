package com.matthew.javabase.webCrawler;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-10 17:01
 */
public interface ExtractService {
    public  List<LinkTypeData> extract(Rule rule) throws IOException;
    public void validateRule(Rule rule);
}
