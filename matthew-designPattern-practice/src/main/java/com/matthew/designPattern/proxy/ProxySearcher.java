package com.matthew.designPattern.proxy;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-20 17:05
 */
public class ProxySearcher implements Searcher {
    private RealSearcher searcher = new RealSearcher();//维持一个对真实主题的引用
    private AccessValidator validator;
    private Logger logger;
    @Override
    public String doSearch(String userId, String keyword) {
        //如果身份验证成功，则执行查询
        if(this.validate(userId)){
            String result = searcher.doSearch(userId,keyword);//调用真实主题对象的查询方法。
            this.log(userId,keyword);//记录查询日志
            return  result;
        }
        return null;
    }
    public boolean validate(String userId){
        validator = new AccessValidator();
        return validator.validate(userId);
    }
    public void log(String userId, String keyword){
        logger = new Logger();
        logger.log(userId,keyword);
    }
}
