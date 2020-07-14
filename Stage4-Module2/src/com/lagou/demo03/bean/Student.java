package com.lagou.demo03.bean;

public class Student {

    private int id;
    private String userName;
    private String gender;
    private String birthday;
    private String email;
    private String note;

    public Student() {
    }

    public Student(String userName, String gender, String birthday, String email, String note) {
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.note = note;
    }

    public Student(int id, String userName, String gender, String birthday, String email, String note) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.email = email;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
