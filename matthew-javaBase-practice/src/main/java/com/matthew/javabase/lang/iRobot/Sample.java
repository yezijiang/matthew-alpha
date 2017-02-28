package com.matthew.javabase.lang.iRobot;

import com.eastrobot.ask.sdk.*;
import com.eastrobot.ask.utils.Constant;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-27 15:28
 */
public class Sample {
    public static void main(String[] args) throws MalformedURLException,
            IOException {
        String appKey = "请填写";
        String appSecret = "请填写";
        String question = "请填写";
        String exampleFile = "请填写";

        //智能问答
        AskRequest askRequest = new AskRequest(appKey, appSecret, question,
                Constant.SENIOR_TYPE, null, Constant.WEIXIN_PLATFORM);
        AskService askService = CloudServiceFactory.getInstance()
                .createAskService();
        askService.init(null);
        AskResponse askResponse = null;
        try {
            askResponse = askService.ask(askRequest);
        } catch (CloudNotInitializedException e) {
            e.printStackTrace();
        }

        //语音合成
        SynthRequest synthRequest = new SynthRequest(appKey, appSecret, null,
                question);
        SynthService synthService = CloudServiceFactory.getInstance()
                .createSynthService();
        synthService.init(null);
        SynthResponse synthResponse = null;
        try {
            synthResponse = synthService.synth(synthRequest);
        } catch (CloudNotInitializedException e) {
            e.printStackTrace();
        }

        //语音识别
        File file = new File(exampleFile);
        byte[] data = FileUtils.readFileToByteArray(file);
        RecogRequest recogRequest = new RecogRequest(appKey, appSecret, null,
                data);
        RecogService recogService = CloudServiceFactory.getInstance()
                .createRecogService();
        recogService.init(null);
        RecogResponse recogResponse = null;
        try {
            recogResponse = recogService.recog(recogRequest);
        } catch (CloudNotInitializedException e) {
            e.printStackTrace();
        }
    }
}