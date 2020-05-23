package com.Ivan.task01;

import java.io.Serializable;

/**
 * @author 夏殿千歌序
 * @date 2020/5/10 19:03
 * @description
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -3900927528214300301L;
    private String sno;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String sno, String name, int age) throws AgeException,SnoException {

        setSno(sno);
        setName(name);
        setAge(age);
    }

    @Override
    public String toString() {
        return "sno = " + sno +
                " name = " + name +
                " age = " + age;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) throws SnoException {
        if(sno.length() > 0 && sno.length() < 10) this.sno = sno;
        else throw new SnoException("学号长度不合理");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if(age > 0) this.age = age;
        else throw new AgeException("年龄不合理");
    }
}
