package com.ccut.item.controller;

import com.ccut.common.pojo.PageResult;
import com.ccut.item.pojo.Brand;
import com.ccut.item.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName: BrandController
 * @Description: TODO   品牌列表控制层
 * @Author: Mark
 * @Date: 2019/7/30 19:17
 * @version: V1.0
 */
@Controller
@RequestMapping("brand")
public class BrandController {
    @Autowired
    private IBrandService iBrandService;
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
        @RequestParam(value = "key",required = false) String key,
        @RequestParam(value = "page",defaultValue = "1") Integer page,
        @RequestParam(value = "rows",defaultValue = "5") Integer rows,
        @RequestParam(value = "sortBy",required = false) String sortBy,
        @RequestParam(value = "desc",required = false) Boolean desc
    ){
        PageResult<Brand> brandPageResult = iBrandService.queryBrandByPage(key, page, rows, sortBy, desc);
        if(CollectionUtils.isEmpty(brandPageResult.getItems())){
            // 400 没有找到资源
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brandPageResult);
    }

    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("cids")List<Long> cids) {
        System.out.println(brand);
        this.iBrandService.saveBrand(brand,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
