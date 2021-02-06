package com.lagou.mapper;

import com.lagou.pojo.SysRegion;
import com.lagou.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author apple
 * @date 2021/2/6 下午6:02
 * @description
 */

@Mapper
@Component
public interface SysRegionDao {

    @Insert("insert into sys_region (id,region_name,region_code,region_level) values(#{id},#{regionName},#{regionCode},#{regionLevel}))")
    int insertSysRegion(SysRegion sysRegion);
}
