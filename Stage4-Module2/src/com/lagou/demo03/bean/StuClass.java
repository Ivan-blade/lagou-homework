package com.lagou.demo03.bean;

/**
 * @author apple
 * @date 2020/7/12 上午10:13
 * @description
 */
public class StuClass {

    private int id;
    private String name;
    private String level;
    private String masterName;
    private String location;
    private String note;

    public StuClass() {
    }

    public StuClass(String name, String level, String masterName, String location, String note) {
        this.name = name;
        this.level = level;
        this.masterName = masterName;
        this.location = location;
        this.note = note;
    }

    public StuClass(int id, String name, String level, String masterName, String location, String note) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.masterName = masterName;
        this.location = location;
        this.note = note;
    }

    @Override
    public String toString() {
        return "StuClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", masterName='" + masterName + '\'' +
                ", location='" + location + '\'' +
                ", note='" + note + '\'' +
                '}';
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
