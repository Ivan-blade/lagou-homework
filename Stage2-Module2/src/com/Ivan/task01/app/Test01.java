package com.Ivan.task01.app;

import com.Ivan.task01.entity.Account;
import com.Ivan.task01.utils.DateUtils;
import com.Ivan.task01.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author apple
 * @date 2020/6/18 上午8:42
 * @description
 * 按照步骤 实现卡号：1122334455向55443332211转账5000元的操作
 * a) 使用连接池创建QueryRunner对象；
 * b) 判断转出方是否有足够余额，如果不足，提示信息：”余额不足！”，并结束程序；
 * c) 通过卡号 进行转账的操作；
 * d) 转账结束后, 将转入、转出记录分别写入到Transaction表中。
 */
public class Test01 {

    @Test
    public void request() throws SQLException {
        // 获取连接
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 编写查询语句
        String sql1 = "select balance from account where card = ?";

        // 获取查询对象
        Account account = qr.query(sql1,new BeanHandler<Account>(Account.class),"1122334455");

        // 如果余额充足进行转账操作，否则提示余额不足并退出
        if(account.getBalance() > 5000) {

            // 编写转账sql并执行
            String sql2 = "update account set balance = balance - 5000 where card = ?";
            String sql3 = "update account set balance = balance + 5000 where card = ?";
            int res2 = qr.update(sql2,"1122334455");
            int res3 = qr.update(sql3,"55443332211");

            // 编写转出记录sql并执行
            String sql4 = "insert into transaction values(?,?,?,?,?)";
            Object[] params1 = {null,"1122334455","转出",5000, DateUtils.getDateFormart()};
            qr.update(sql4,params1);

            // 编写转入记录sql并执行
            String sql5 = "insert into transaction values(?,?,?,?,?)";
            Object[] params2 = {null,"55443332211","转入",5000,DateUtils.getDateFormart()};
            qr.update(sql5,params2);

            System.out.println("转账完成！");

        } else {
            System.out.println("余额不足！");
            return;
        }
    }
}
