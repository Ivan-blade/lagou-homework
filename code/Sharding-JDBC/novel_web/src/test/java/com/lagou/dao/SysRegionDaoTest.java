package com.lagou.dao;

import com.lagou.NovelApplication;
import com.lagou.mapper.SysRegionDao;
import com.lagou.pojo.SysRegion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author apple
 * @date 2021/2/6 下午6:05
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NovelApplication.class)
public class SysRegionDaoTest {

    @Autowired
    private SysRegionDao sysRegionDao;

    @Test
    public void insertSysRegionTest() {

        SysRegion sysRegion = new SysRegion();
        sysRegion.setId(1231411241L);
        sysRegion.setRegionName("ninth area");
        sysRegion.setRegionCode("blue");
        sysRegion.setRegionLevel(14721472L);
        sysRegionDao.insertSysRegion(sysRegion);
    }
}
