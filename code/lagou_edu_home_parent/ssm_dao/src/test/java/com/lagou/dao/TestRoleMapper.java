package com.lagou.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//基本是固定写法
@ContextConfiguration("classpath:applicationContext_dao.xml") //告诉spring的测试环境，xml在哪个位置
@RunWith(SpringJUnit4ClassRunner.class) //这个类是spring自己写的，扩展了junit的运行环境。 在里面还兼备了创建工厂的逻辑
public class TestRoleMapper {

    @Autowired
    private RoleMapper roleMapper;


    @Test
    public void test01() throws JsonProcessingException {
        List<ResourceCategory> categoryList = roleMapper.findRoleHaveResourceCate(1);

        List<Resource> resourceList = roleMapper.findRoleHaveResource(1);

        for (ResourceCategory category : categoryList) {
            for (Resource resource : resourceList) {
                if(category.getId() == resource.getCategoryId()){
                    category.getResourceList().add(resource);
                }
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categoryList);

        System.out.println(json);

//        for (ResourceCategory category : list) {
//            Integer id = category.getId();
//            List<Resource> resourceList = roleMapper.findResourceByCateId(id);
//            category.setResourceList(resourceList);
//        }
//
//        ObjectMapper mapper = new ObjectMapper();
//        String s = mapper.writeValueAsString(list);
//        System.out.println(s);
    }



}
