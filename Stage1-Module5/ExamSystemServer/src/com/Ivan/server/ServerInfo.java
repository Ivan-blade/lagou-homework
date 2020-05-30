package com.Ivan.server;

import com.Ivan.model.Point;
import com.Ivan.model.Title;
import com.Ivan.model.User;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author 夏殿千歌序
 * @date 2020/5/30 9:30
 * @description
 */
public class ServerInfo {

    public static List<User> getUsers() {
        ObjectInputStream fisUsers = null;
        List<User> listUsers = null;
        try {
            fisUsers = new ObjectInputStream(new FileInputStream("f:/temp/temp/temp/Users.txt"));
            listUsers = (List<User>) fisUsers.readObject();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fisUsers.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listUsers;
    }

    public static List<Point> getPoints() {
        ObjectInputStream fisPoints = null;
        List<Point> listPoints = null;
        try {
            fisPoints = new ObjectInputStream(new FileInputStream("f:/temp/temp/temp/Points.txt"));
            listPoints = (List<Point>) fisPoints.readObject();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != fisPoints) fisPoints.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listPoints;
    }

    public static List<Title> getTitles() {
        ObjectInputStream fisTitles = null;
        List<Title> listTitles = null;
        try {
            fisTitles = new ObjectInputStream(new FileInputStream("f:/temp/temp/temp/Titles.txt"));
            listTitles = (List<Title>) fisTitles.readObject();
        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fisTitles.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listTitles;
    }
}
