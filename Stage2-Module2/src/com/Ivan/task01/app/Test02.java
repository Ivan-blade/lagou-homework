package com.Ivan.task01.app;

import com.Ivan.task01.entity.Phone;
import com.Ivan.task01.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * @author apple
 * @date 2020/6/18 上午9:19
 * @description
 */
public class Test02 {

    // 需求1:  查询价格高于2000元，生产日期是2019年之前的所有手机
    @Test
    public void request01() throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from phone where price > 2000 and prodate < '2019'";

        List<Phone> list = qr.query(sql, new BeanListHandler<Phone>(Phone.class));

        for(Phone phone : list) {
            System.out.println(phone);
        }
    }

    // 需求2:  查询所有颜色是白色的手机信息
    @Test
    public void request02() throws SQLException {

        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        String sql = "select * from phone where color = ?";

        List<Phone> list = qr.query(sql, new BeanListHandler<Phone>(Phone.class), "白色");

        for(Phone phone : list) {
            System.out.println(list);
        }
    }
}
