package com.scau.test.CheckstatTest;

import com.scau.dao.*;
import com.scau.entity.*;
import com.scau.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckstatDaoTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CheckStatDao checkStatDao;

    @Test
    public void findAllByPage() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", 0);
        map.put("size", 2);
        List<CheckStat> list = checkStatDao.findAllByPage(map);
        System.out.println(list.size());
    }

    @Test
    public void findAll() {
        List<CheckStat> list = checkStatDao.findAll();
        System.out.println(list.size());
        System.out.println(list.get(0).toString());
    }
}
