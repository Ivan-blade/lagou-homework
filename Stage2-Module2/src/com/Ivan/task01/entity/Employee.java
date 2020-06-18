package com.Ivan.task01.entity;

import java.util.Date;

/**
 * @author apple
 * @date 2020/6/18 上午9:34
 * @description
 */
public class Employee {

    private int id;
    private String name;
    private double age;
    private String sax;
    private double salary;
    private Date empdate;
    private int did;
    private Dept dept;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getSax() {
        return sax;
    }

    public void setSax(String sax) {
        this.sax = sax;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getEmpdate() {
        return empdate;
    }

    public void setEmpdate(Date empdate) {
        this.empdate = empdate;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sax='" + sax + '\'' +
                ", salary=" + salary +
                ", empdate=" + empdate +
                ", did=" + did +
                ", dept=" + dept +
                '}';
    }
}
