package com.ccut.item.service;

import com.ccut.item.pojo.Category;

import java.util.List;

/**
 * @ClassName: ICategoryService
 * @Description: TODO Category商品分类业务层接口
 * @Author: Mark
 * @Date: 2019/7/30 10:35
 * @version: V1.0
 */
public interface ICategoryService {
    /**
     *通过pid查询商品
     * @param pid
     * @return
     */
    List<Category>  queryCategoryByPid(Long pid);
}
