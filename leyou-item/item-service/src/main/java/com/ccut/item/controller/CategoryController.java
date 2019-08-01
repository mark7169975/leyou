package com.ccut.item.controller;

import com.ccut.item.pojo.Category;
import com.ccut.item.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName: CategoryController
 * @Description: TODO Category商品分类控制层
 * @Author: Mark
 * @Date: 2019/7/30 10:32
 * @version: V1.0
 */
@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam(value ="pid",defaultValue ="0")Long pid) {
        if(pid == null || pid  <0){
            // 返回400,参数不合法
            return ResponseEntity.badRequest().build();
        }
        List<Category> categoryList = iCategoryService.queryCategoryByPid(pid);
        if(CollectionUtils.isEmpty(categoryList)){
            // 返回404 资源未找到
            return ResponseEntity.notFound().build();
        }
        //200: 查询成功
        return ResponseEntity.ok(categoryList);
    }
}
