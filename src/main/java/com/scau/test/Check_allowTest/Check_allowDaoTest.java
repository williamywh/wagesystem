package com.scau.test.Check_allowTest;

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

public class Check_allowDaoTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Check_allowDao check_allowDao;

    @Test
    public void findAllByPage() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start", 0);
        map.put("size", 2);
        List<Check_allow> list = check_allowDao.findAllByPage(map);
        System.out.println(list.size());
    }

    @Test
    public void findAll() {
        List<Check_allow> list = check_allowDao.findAll();
        System.out.println(list.size());
        System.out.println(list.get(0).toString());
    }


}
