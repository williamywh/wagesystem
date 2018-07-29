package com.scau.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scau.service.gitlab.GitLabPushDataEvent;
import com.scau.util.SpringContextTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/git/webhook")
public class WebhookController {
    private static Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @RequestMapping(value="push")
    public void getPush(@RequestBody String pushData){
        new Thread(new GitWebHookThread(pushData)).start();
    }


    private class GitWebHookThread implements Runnable {
        private String pushDataStr;

        public GitWebHookThread(String pushDataStr) {
            this.pushDataStr = pushDataStr;
        }

        @Override
        public void run() {
            try {
                JSONObject pushData = JSON.parseObject(pushDataStr);
                GitLabPushDataEvent event = new GitLabPushDataEvent(this, pushData);
                SpringContextTool.getContext().publishEvent(event);
                //通过Application.publishEvent方法，我们可以将事件通知系统内所有的 ApplicationListener
            } catch (Exception e) {
                logger.error("Git lab webhook handle error!");
            }
        }
    }
}
