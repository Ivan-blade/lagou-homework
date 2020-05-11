package com.Ivan.task04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 夏殿千歌序
 * @date 2020/5/10 19:05
 * @description
 */
public class Manager {

    private List<Student> list = new ArrayList<>();
    public Scanner sc = new Scanner(System.in);

    // 提示输入基本信息，如果学号没有重复添加信息到集合，否则提示学号存在
    public void insert() {
        System.out.println("please input the sno of the student");
        String sno = sc.next();
        System.out.println("please input the name of the student");
        String name = sc.next();
        System.out.println("please input the age of the student");
        int age = sc.nextInt();
        if(find(sno) == null) {
            list.add(new Student(sno,name,age));
            System.out.println("add info successfully !");
        } else {
            System.out.println("sno exists!");
        }
        isContinue();
    }

    // 根据学号返回学生对象用于删查改
    public Student find(String sno) {
        for(Student s : list) {
            if (sno.equals(s.getSno())) return s;
        }
        return null;
    }

    // 存不存在不影响删除
    public void delete() {
        System.out.println("please input the sno of student:");
        String sno = sc.next();
        list.remove(find(sno));
        System.out.println("delete info successfully!");
        isContinue();
    }

    // 如果学号存在，返回对象，否则显示对象不存在，太惨了对象不存在。。。
    public void select() {
        System.out.println("please input the sno of student:");
        String sno = sc.next();
        Student student = find(sno);
        System.out.println(student == null ? "there is no student own the sno" : student.toString());
        isContinue();
    }

    // 如果学号存在，选择后更改信息，如果不存在，提醒
    public void update() {
        System.out.println("please input the sno of student:");
        String sno = sc.next();
        Student cur = find(sno);
        if(cur == null) {
            System.out.println("sno does not exist!");
        } else {
            System.out.println("please input the num of info you want to change:");
            System.out.println("1.sno   2.name  3.age");
            int temp = sc.nextInt();
            switch (temp) {
                case 1: {
                    System.out.println("please input the sno of student:");
                    String upSno = sc.nextLine();
                    cur.setSno(upSno);
                    System.out.println("sno update succuessfully!");
                }
                ;
                break;
                case 2: {
                    System.out.println("please input the name of student:");
                    String upName = sc.nextLine();
                    cur.setName(upName);
                    System.out.println("name update succuessfully!");
                }
                ;
                break;
                case 3: {
                    System.out.println("please input the age of student:");
                    int upAge = sc.nextInt();
                    cur.setAge(upAge);
                    System.out.println("age update succuessfully!");
                }
                ;
                break;
                default: {
                    System.out.println("invaild input!");
                    update();
                }
            }
        }
        isContinue();
    }

    // 第一次进入展示页面
    public void enter() {
        System.out.println("----------------------------------------");
        System.out.println("welcome to management system of students");
        display();
    }

    // 展示菜单
    public void display() {
        System.out.println("----------------------------------------");
        System.out.println("the functions are as follows:");
        System.out.println("1.add the info of student");
        System.out.println("2.delete the info of student");
        System.out.println("3.search the info of student");
        System.out.println("4.change the info of student");
        System.out.println("5.show all info of students");
        System.out.println("6.exit");
        choose();
    }

    // 菜单功能选择
    public void choose() {
        System.out.println("please input a number to choose function:");
        int temp = sc.nextInt();
        switch (temp) {
            case 1: insert();break;
            case 2: delete();break;
            case 3: select();break;
            case 4: update();break;
            case 5: {
                stuShow();
                isContinue();
            }break;
            case 6: System.exit(0);break;
            default: {
                System.out.println("invalid input! try to input again!");
                isContinue();
            }
        }
    }

    // 显示所有学生信息
    public void stuShow() {
        for(Student s : list) {
            System.out.println(s.toString());
        }
    }

    // 选择是否继续操作
    public void isContinue() {
        System.out.println("do you want to continue?(y/n)");
        String temp = sc.next();
        if("y".equals(temp)) display();
        else System.exit(0);
    }

}
