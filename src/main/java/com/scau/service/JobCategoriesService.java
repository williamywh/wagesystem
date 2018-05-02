package com.scau.service;

import com.scau.entity.*;
import java.util.*;

public interface JobCategoriesService {
    String findJobCategoriesDept();
    void insertJobCategories(JobCategories jobCategories);
}
