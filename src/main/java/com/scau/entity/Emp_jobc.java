package com.scau.entity;

import java.io.Serializable;

public class Emp_jobc implements Serializable {
    private static final long serialVersionUID = -1896303853274402680L;
    private Integer ej_id;
    private Integer e_id;
    private Integer j_id;

    public Emp_jobc(){

    }

    public Emp_jobc(Integer e_id, Integer j_id) {
        this.e_id = e_id;
        this.j_id = j_id;
    }

    public int getEj_id() {
        return ej_id;
    }

    public void setEj_id(Integer ej_id) {
        this.ej_id = ej_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(Integer e_id) {
        this.e_id = e_id;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    @Override
    public String toString() {
        return "Emp_jobc{" +
                "ej_id=" + ej_id +
                ", e_id=" + e_id +
                ", j_id=" + j_id +
                '}';
    }
}
