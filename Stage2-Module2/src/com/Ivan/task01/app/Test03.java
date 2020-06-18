package com.Ivan.task01.app;

import com.Ivan.task01.entity.Dept;
import com.Ivan.task01.entity.Employee;
import com.Ivan.task01.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * @author apple
 * @date 2020/6/18 上午9:41
 * @description
 */
public class Test03 {

    // 需求1: 查询所有的员工信息 (不包含没有部门的员工)。
    // 一遍查询
    @Test
    public void request01() throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from employee where did is not null";

        List<Employee> list = qr.query(sql, new BeanListHandler<Employee>(Employee.class));

        for(Employee employee : list) {
            System.out.println(employee);
        }
    }

    // 需求2: 查询每个员工的 姓名, 薪资 和 所属部门名称
    @Test
    public void request02() throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 编写获取所有员工信息sql
        String sql1 = "select * from employee";

        // 执行sql获取结果
        List<Employee> list = qr.query(sql1, new BeanListHandler<Employee>(Employee.class));

        // 对每一个员工进行部门查询并对有则输出，无则提示
        for (Employee employee : list) {
            int did = employee.getDid();
            if(did != 0) employee.setDept(getDeptNameById(did,qr));
            System.out.println("员工名称：" + employee.getName()+
                    " 薪资："+ employee.getSalary()+
                    " 所属部门：" + (employee.getDept() == null ? "暂无" : employee.getDept().getDeptname()));
        }

    }

    public Dept getDeptNameById(int id,QueryRunner qr) throws SQLException {

        String sql = "select * from dept where id = ?";

        Dept dept = qr.query(sql, new BeanHandler<Dept>(Dept.class), id);

        return dept;
    }
}
