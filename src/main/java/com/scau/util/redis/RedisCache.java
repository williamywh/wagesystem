package com.scau.util.redis;


import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.scau.entity.Employee;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.cache.Cache;
import java.util.*;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {

    private final  ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public RedisCache(final String id){
        if(id == null){
            throw new IllegalArgumentException("Cache include  an required id");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
//        JedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
        JedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()),
                SerializeUtil.serialize(value));
    }

    @Override
    public Object getObject(Object key) {
        Object value =  SerializeUtil.unserialize(JedisUtil.getJedis().get(
                SerializeUtil.serialize(key.toString())));
//        System.out.println(value);
        return value;

    }

    @Override
    public Object removeObject(Object key) {
        return JedisUtil.getJedis().expire(SerializeUtil.serialize(key.toString()),0);
    }

    @Override
    public void clear() {
        JedisUtil.getJedis().flushDB();
    }

    @Override
    public int getSize() {
        return Integer.valueOf(JedisUtil.getJedis().dbSize().toString());
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
