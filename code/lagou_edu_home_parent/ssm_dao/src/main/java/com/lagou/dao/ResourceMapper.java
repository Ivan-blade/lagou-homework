package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

public interface ResourceMapper {


    public List<Resource> findAllResource(ResourceVo resourceVo);


    void saveResource(Resource resource);

    void updateResource(Resource resource);

    void deleteResource(Integer id);
}
