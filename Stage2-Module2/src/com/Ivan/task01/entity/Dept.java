package com.Ivan.task01.entity;

/**
 * @author apple
 * @date 2020/6/18 上午9:33
 * @description
 */
public class Dept {

    private int id;
    private String deptname;

    public Dept() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
