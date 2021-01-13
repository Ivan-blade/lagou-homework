package com.lagou.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagou.domain.Menu;
import com.lagou.domain.Resource;
import com.lagou.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("classpath:applicationContext_dao.xml") //告诉spring的测试环境，xml在哪个位置
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserMapper {

    @Autowired
    private UserMapper mapper;

    @Test
    public void testFindUserRelationRoleById(){

        List<Role> roleList = mapper.findUserRelationRoleById(100030011);

        for (Role role : roleList) {
            System.out.println(role.getId()+" "+ role.getName());
        }
    }


    @Test
    public void testFindParentMenuByRoleId() throws JsonProcessingException {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        //list.add(1);

        List<Menu> menuList = mapper.findParentMenuByRoleId(list);
        for (Menu menu : menuList) {
            List<Menu> subMenu = mapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }

        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(menuList);
        System.out.println(s);
    }

    /**
     * 获取角色拥有的资源分类数据
     * */
    @Test
    public void findResourceByRoleId() throws JsonProcessingException {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        //list.add(1);

        List<Resource> resourceList = mapper.findResourceByRoleId(list);
        for (Resource resource : resourceList) {
            //System.out.println(resource.getId()+" " + resource.getName());
        }

        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(resourceList);
        System.out.println(s);
    }
}
