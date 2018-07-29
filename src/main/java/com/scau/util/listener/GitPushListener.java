package com.scau.util.listener;

import com.alibaba.fastjson.JSONObject;
import com.scau.service.gitlab.GitLabPushDataEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class GitPushListener implements ApplicationListener<GitLabPushDataEvent> {

    @Override
    public void onApplicationEvent(GitLabPushDataEvent event) {
        if(event instanceof GitLabPushDataEvent){
            JSONObject push = event.getPushData();
            System.out.println(push);
        }
    }
}
