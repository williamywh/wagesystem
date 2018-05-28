package com.scau.entity;

public class Check_allow {
    private int ca_id;
    private int cs_id;
    private int al_id;

    public int getCa_id() {
        return ca_id;
    }

    public void setCa_id(int ca_id) {
        this.ca_id = ca_id;
    }

    public int getCs_id() {
        return cs_id;
    }

    public void setCs_id(int cs_id) {
        this.cs_id = cs_id;
    }

    public int getAl_id() {
        return al_id;
    }

    public void setAl_id(int al_id) {
        this.al_id = al_id;
    }

    @Override
    public String toString() {
        return "Check_allow{" +
                "ca_id=" + ca_id +
                ", cs_id=" + cs_id +
                ", al_id=" + al_id +
                '}';
    }
}
