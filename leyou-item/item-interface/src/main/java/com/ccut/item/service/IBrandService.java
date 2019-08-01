package com.ccut.item.service;

import com.ccut.common.pojo.PageResult;
import com.ccut.item.pojo.Brand;

import java.util.List;

/**
 * @ClassName: IBrandService
 * @Description: TODO   品牌列表业务层接口
 * @Author: Mark
 * @Date: 2019/7/30 18:58
 * @version: V1.0
 */
public interface IBrandService {

    /**
     * 分页查询商品品牌
     * @param key
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @return
     */
    PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc);

    /**
     * 添加品牌
     * @param brand
     * @param cids
     */
    void saveBrand(Brand brand, List<Long> cids);
}
