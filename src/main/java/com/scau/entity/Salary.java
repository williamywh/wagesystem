package com.scau.entity;

import java.io.Serializable;

public class Salary implements Serializable {
    private static final long serialVersionUID = -1695973853523122680L;
    private Integer id;

    private Integer e_id;

    private Integer cs_id;

    private Integer sum;

    public Salary() {
    }

    public Salary(Integer id, Integer e_id, Integer cs_id, Integer sum) {
        this.id = id;
        this.e_id = e_id;
        this.cs_id = cs_id;
        this.sum = sum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public Integer getCs_id() {
        return cs_id;
    }

    public void setCs_id(Integer cs_id) {
        this.cs_id = cs_id;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", e_id=" + e_id +
                ", cs_id=" + cs_id +
                ", sum=" + sum +
                '}';
    }
}
