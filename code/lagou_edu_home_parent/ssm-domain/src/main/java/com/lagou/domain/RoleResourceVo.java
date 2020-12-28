package com.lagou.domain;

import java.util.List;

/**
 * @author apple
 * @date 2020/12/27 下午6:43
 * @description
 */
public class RoleResourceVo {

    private Integer roleId;

    private List<Integer> ResourceIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return ResourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        ResourceIdList = resourceIdList;
    }

    @Override
    public String toString() {
        return "RoleResourceVo{" +
                "roleId=" + roleId +
                ", ResourceIdList=" + ResourceIdList +
                '}';
    }
}
