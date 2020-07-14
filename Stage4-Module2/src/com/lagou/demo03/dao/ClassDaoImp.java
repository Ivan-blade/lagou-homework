package com.lagou.demo03.dao;

import com.lagou.demo03.bean.StuClass;
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
public class ClassDaoImp implements ClassDao {

    @Override
    public int classInsert(StuClass stuClass) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = DbUtil.getConnection();
            String sql = "insert into class values(null,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stuClass.getName());
            preparedStatement.setString(2, stuClass.getLevel());
            preparedStatement.setString(3, stuClass.getMasterName());
            preparedStatement.setString(4, stuClass.getLocation());
            preparedStatement.setString(5, stuClass.getNote());
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
    public int classDelete(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = DbUtil.getConnection();
            String sql = "delete from class where id = ?";
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
    public StuClass classSelectById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbUtil.getConnection();
            String sql = "select * from class where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int cid = resultSet.getInt("id");
                String cname = resultSet.getString("name");
                String level = resultSet.getString("level");
                String masterName = resultSet.getString("masterName");
                String location = resultSet.getString("location");
                String note = resultSet.getString("note");

                return new StuClass(cid,cname,level,masterName,location,note);
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
    public List<StuClass> classSelectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<StuClass> list = new ArrayList<>();
        try {
            connection = DbUtil.getConnection();
            String sql = "select * from class";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int cid = resultSet.getInt("id");
                String cname = resultSet.getString("name");
                String level = resultSet.getString("level");
                String masterName = resultSet.getString("masterName");
                String location = resultSet.getString("location");
                String note = resultSet.getString("note");
                list.add(new StuClass(cid,cname,level,masterName,location,note));
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
    public int classUpdate(StuClass stuClass) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;
        try {
            connection = DbUtil.getConnection();
            String sql = "update class set name = ?,level = ?,masterName = ?,location = ?,note = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, stuClass.getName());
            preparedStatement.setString(2, stuClass.getLevel());
            preparedStatement.setString(3, stuClass.getMasterName());
            preparedStatement.setString(4, stuClass.getLocation());
            preparedStatement.setString(5, stuClass.getNote());
            preparedStatement.setInt(6, stuClass.getId());
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
