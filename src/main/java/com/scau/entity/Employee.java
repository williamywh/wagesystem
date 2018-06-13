package com.scau.entity;

//import java.util.Date;
import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {
    private static final long serialVersionUID = -1695973853274402680L;
    private Integer e_id; //e_id
    private String e_name; //e_name
    private String gender;
    private String tel;
    private String address;
    private String password;
    private String note;
    private Date datetime;

    public Employee(){}

    public Employee(String e_name, String gender, String tel, String address, String password, String note, Date datetime) {
        this.e_name = e_name;
        this.gender = gender;
        this.tel = tel;
        this.address = address;
        this.password = password;
        this.note = note;
        this.datetime = datetime;
    }
    public Integer getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return datetime;
    }

    public void setDate(Date date) {
        this.datetime = date;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                ", date=" + datetime +
                '}';
    }
}
