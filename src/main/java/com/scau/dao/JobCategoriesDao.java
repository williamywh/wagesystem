package com.scau.dao;

import com.scau.entity.JobCategories;

import java.util.*;

public interface JobCategoriesDao {
    List<JobCategories> findJobCategoriesDept();
    void insertJobCategories(JobCategories jobCategories);
}
