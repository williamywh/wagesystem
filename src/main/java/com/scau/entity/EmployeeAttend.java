package com.scau.entity;

public class EmployeeAttend {
    private int cs_id;
    private int e_id;
    private String e_name;
    private int ot_days;
    private int absent_days;
    private int leave_days;
    private int year;
    private int month;
    private int work_days;

    public int getCs_id() {
        return cs_id;
    }

    public void setCs_id(int cs_id) {
        this.cs_id = cs_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getOt_days() {
        return ot_days;
    }

    public void setOt_days(int ot_days) {
        this.ot_days = ot_days;
    }

    public int getAbsent_days() {
        return absent_days;
    }

    public void setAbsent_days(int absent_days) {
        this.absent_days = absent_days;
    }

    public int getLeave_days() {
        return leave_days;
    }

    public void setLeave_days(int leave_days) {
        this.leave_days = leave_days;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWork_days() {
        return work_days;
    }

    public void setWork_days(int work_days) {
        this.work_days = work_days;
    }

    @Override
    public String toString() {
        return "EmployeeAttend{" +
                "cs_id=" + cs_id +
                ", e_id=" + e_id +
                ", e_name=" + e_name +
                ", ot_days=" + ot_days +
                ", absent_days=" + absent_days +
                ", leave_days=" + leave_days +
                ", year=" + year +
                ", month=" + month +
                ", work_days=" + work_days +
                '}';
    }
}
