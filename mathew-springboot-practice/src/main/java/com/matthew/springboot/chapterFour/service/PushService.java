package com.matthew.springboot.chapterFour.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-20 11:12
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;
    public DeferredResult<String> getAsyncUpdate(){
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }
    @Scheduled(fixedDelay = 10000)
    public void refresh(){
        if(deferredResult != null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
