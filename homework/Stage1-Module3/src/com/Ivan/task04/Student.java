package com.Ivan.task04;

/**
 * @author 夏殿千歌序
 * @date 2020/5/10 19:03
 * @description
 */
public class Student {

    private String sno;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String sno, String name, int age) {
        this.sno = sno;
        this.name = name;
        this.age = age;
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

    public void setSno(String sno) {
        this.sno = sno;
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

    public void setAge(int age) {
        this.age = age;
    }
}
