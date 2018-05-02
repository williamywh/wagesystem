package com.scau.test.JobCategoriesTest;

import com.scau.dao.*;
import com.scau.entity.Employee;
import com.scau.entity.JobCategories;
import com.scau.test.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class JobCategoriesDaoTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobCategoriesDao jobCategoriesDao;

    @Test
    public void findJobCategoriesDept() {
        List<JobCategories> list = jobCategoriesDao.findJobCategoriesDept();
        System.out.println(list.toString());
    }

    @Test
    public void insertJobCategories() {
        JobCategories jobCategories = new JobCategories("默認","財務部",50000,"财务部长");
        jobCategoriesDao.insertJobCategories(jobCategories);
        System.out.println(jobCategories.getJ_id());
    }
}
