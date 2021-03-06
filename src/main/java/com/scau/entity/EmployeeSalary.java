package com.scau.entity;

import java.io.Serializable;

public class EmployeeSalary implements Serializable {
    private static final long serialVersionUID = -1695973853274986580L;
    private Salary salary;
    private Employee employee;
    private CheckStat checkStat;
    private JobCategories jobCategories;

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CheckStat getCheckStat() {
        return checkStat;
    }

    public void setCheckStat(CheckStat checkStat) {
        this.checkStat = checkStat;
    }

    public JobCategories getJobCategories() {
        return jobCategories;
    }

    public void setJobCategories(JobCategories jobCategories) {
        this.jobCategories = jobCategories;
    }

    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "salary=" + salary +
                ", employee=" + employee +
                ", checkStat=" + checkStat +
                ", jobCategories=" + jobCategories +
                '}';
    }
}
