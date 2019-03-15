package com.matthew.springboot.chapterFour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2019-02-20 9:18
 */
@Controller
public class SseController {
    @RequestMapping(value = "/push",produces = "text/event-stream")
    public @ResponseBody String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" +r.nextInt()+"\n\n";

    }

}
