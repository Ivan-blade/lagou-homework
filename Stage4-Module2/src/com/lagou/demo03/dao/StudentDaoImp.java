package com.lagou.demo03.dao;

import com.lagou.demo03.bean.Student;
import com.lagou.demo03.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author apple
 * @date 2020/7/4 下午3:33
 * @description
 */
public class StudentDaoImp implements StudentDao {

    @Override
    public int studentInsert(Student student) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = DbUtil.getConnection();
            String sql = "insert into student values(null,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getUserName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setString(3, student.getBirthday());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getNote());
            i = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DbUtil.closeResource(connection,preparedStatement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return i;
        }
    }

    @Override
    public int studentDelete(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = DbUtil.getConnection();
            String sql = "delete from student where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            i = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DbUtil.closeResource(connection,preparedStatement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return i;
        }
    }

    @Override
    public Student studentSelectById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbUtil.getConnection();
            String sql = "select * from student where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int sid = resultSet.getInt("id");
                String sname = resultSet.getString("userName");
                String sgender = resultSet.getString("gender");
                String sbirthday = resultSet.getString("birthday");
                String semail = resultSet.getString("email");
                String snote = resultSet.getString("note");
                return new Student(sid,sname,sgender,sbirthday,semail,snote);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                resultSet.close();
                DbUtil.closeResource(connection,preparedStatement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Student> studentSelectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();
        try {
            connection = DbUtil.getConnection();
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int sid = resultSet.getInt("id");
                String sname = resultSet.getString("userName");
                String sgender = resultSet.getString("gender");
                String sbirthday = resultSet.getString("birthday");
                String semail = resultSet.getString("email");
                String snote = resultSet.getString("note");
                list.add(new Student(sid,sname,sgender,sbirthday,semail,snote));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                resultSet.close();
                DbUtil.closeResource(connection,preparedStatement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int studentUpdate(Student student) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = DbUtil.getConnection();
            System.out.println("implement gender:" + student.getGender());
            String sql = "update student set username = ?,gender = ?,birthday = ?,email = ?,note = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getUserName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setString(3, student.getBirthday());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getNote());
            preparedStatement.setInt(6, student.getId());
            i = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DbUtil.closeResource(connection,preparedStatement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return i;
    }
}
