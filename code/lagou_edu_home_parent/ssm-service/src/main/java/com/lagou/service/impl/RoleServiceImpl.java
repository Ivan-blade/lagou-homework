package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }


    @Override
    public List<Integer> findMenuByRoleId(Integer roleid) {
        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(roleid);

        return menuByRoleId;
    }

    @Override
    public List<ResourceCategory> findResourceListByRoleId(Integer roleId) {

        // 获取资源分类列表
        List<ResourceCategory> cateList = roleMapper.findResourceCategory(roleId);
        // 获取所有资源列表
        List<Resource> resList = roleMapper.findResource(roleId);
        // 两层for循环将资源categoryId与资源分类id对应的加入到资源分类列表中到resourceList中
        for(ResourceCategory rc : cateList) {
            List<Resource> temp = null;
            if(rc.getResourceList() != null) temp = new ArrayList<>(rc.getResourceList());
            else temp = new ArrayList<>();
            for(Resource r : resList) {
                if(r.getCategoryId().equals(rc.getId())) temp.add(r);
            }
            rc.setResourceList(temp);
        }
        return cateList;
    }

    @Override
    public void roleContextMenu(RoleMenuVo roleMenuVo) {

        //1. 清空中间表的关联关系
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        //2. 为角色分配菜单

        for (Integer mid : roleMenuVo.getMenuIdList()) {

            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());

            //封装数据
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);

            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");


            roleMapper.roleContextMenu(role_menu_relation);
        }

    }


    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {
        //1. 清空中间表的关联关系
        roleMapper.deleteResourceContextMenu(roleResourceVo.getRoleId());

        //2. 为角色分配菜单

        for (Integer rid : roleResourceVo.getResourceIdList()) {

            RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
            roleResourceRelation.setResourceId(rid);
            roleResourceRelation.setRoleId(roleResourceVo.getRoleId());

            //封装数据
            Date date = new Date();
            roleResourceRelation.setCreatedTime(date);
            roleResourceRelation.setUpdatedTime(date);

            roleResourceRelation.setCreatedBy("Ivan");
            roleResourceRelation.setUpdatedBy("Ivan");


            roleMapper.roleContextResource(roleResourceRelation);
        }
    }

    @Override
    public void deleteRole(Integer roleid) {

        // 调用根据roleid清空中间表关联关系
        roleMapper.deleteRoleContextMenu(roleid);

        roleMapper.deleteRole(roleid);
    }
}
