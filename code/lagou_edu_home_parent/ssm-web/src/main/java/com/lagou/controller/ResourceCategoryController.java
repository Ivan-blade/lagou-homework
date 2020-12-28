package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();

        return  new ResponseResult(true,200,"查询所有分类信息成功",allResourceCategory);

    }

    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(ResourceCategory resourceCategory) {

        if(resourceCategory.getId() == null){
            //调用service
            resourceCategoryService.saveResourceCategory(resourceCategory);
            ResponseResult responseResult = new ResponseResult(true, 200, "新增成功", resourceCategory);
            return responseResult;
        }else {
            resourceCategoryService.updateResourceCategory(resourceCategory);
            ResponseResult responseResult = new ResponseResult(true, 200, "修改成功", resourceCategory);
            return responseResult;
        }
    }

    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id) {

        resourceCategoryService.deleteResourceCategory(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除资源成功", null);
        return  responseResult;
    }


}
