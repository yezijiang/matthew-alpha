package com.matthew.springboot.chapterFour.controller;

import com.matthew.springboot.chapterFour.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-20 11:08
 */
@Controller
public class AsyncController {
    @Autowired
    PushService pushService;
    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall(){
        return pushService.getAsyncUpdate();
    }
}
