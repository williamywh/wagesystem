package com.scau.test.JobCategoriesTest;

import com.scau.entity.*;
import com.scau.service.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class JobCategoriesServiceImplTest extends JobCategoriesDaoTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JobCategoriesService jobCategoriesService;

    @Test
    public void findEmployeeByName1(){
        String list = jobCategoriesService.findJobCategoriesDept();
        System.out.println(list.toString());
    }
}
