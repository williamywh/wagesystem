package com.scau.dao;

import com.scau.entity.JobCategories;

import java.util.*;

public interface JobCategoriesDao {
    List<JobCategories> findJobCategoriesClassn();
    List<JobCategories> findJobCategoriesDept();
    List<JobCategories> findAllDept();
    void insertJobCategories(JobCategories jobCategories);
}
