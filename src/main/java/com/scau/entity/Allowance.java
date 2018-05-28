package com.scau.entity;

import java.sql.Date;

public class Allowance {
    private int al_id;
    private String ot_type;
    private Date day;
    private int subsidy;

    public int getAl_id() {
        return al_id;
    }

    public void setAl_id(int al_id) {
        this.al_id = al_id;
    }

    public String getOt_type() {
        return ot_type;
    }

    public void setOt_type(String ot_type) {
        this.ot_type = ot_type;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(int subsidy) {
        this.subsidy = subsidy;
    }

    @Override
    public String toString() {
        return "Allowance{" +
                "al_id=" + al_id +
                ", ot_type='" + ot_type + '\'' +
                ", day=" + day +
                ", subsidy=" + subsidy +
                '}';
    }
}
