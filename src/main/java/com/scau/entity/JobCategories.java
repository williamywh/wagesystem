package com.scau.entity;

public class JobCategories {
    private Integer j_id;
    private String title;
    private String dept;
    private Integer base_wage;
    private String classn;


    public JobCategories(){

    }

    public JobCategories(String title, String dept, Integer base_wage, String classn) {
        this.title = title;
        this.dept = dept;
        this.base_wage = base_wage;
        this.classn = classn;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(Integer j_id) {
        this.j_id = j_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getBase_wage() {
        return base_wage;
    }

    public void setBase_wage(Integer base_wage) {
        this.base_wage = base_wage;
    }

    public String getClassn() {
        return classn;
    }

    public void setClassn(String classn) {
        this.classn = classn;
    }
    @Override
    public String toString() {
        return "JobCategories{" +
                "j_id=" + j_id +
                ", title='" + title + '\'' +
                ", dept='" + dept + '\'' +
                ", base_wage=" + base_wage +
                ", classn='" + classn + '\'' +
                '}';
    }
}
