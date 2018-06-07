package com.scau.service;

import com.scau.entity.*;
import java.util.*;

public interface JobCategoriesService {
    String findJobCategoriesDept();
    String findJobCategoriesClassn();
    List<JobCategories> findAllDept();
    void insertJobCategories(JobCategories jobCategories);
}
