package com.scau.service.gitlab;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationEvent;

public class GitLabPushDataEvent extends ApplicationEvent {

    private JSONObject pushData;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public GitLabPushDataEvent(Object source, JSONObject pushData) {
        super(source);
        this.pushData = pushData;
    }

    public JSONObject getPushData(){
        return pushData;
    }

}
