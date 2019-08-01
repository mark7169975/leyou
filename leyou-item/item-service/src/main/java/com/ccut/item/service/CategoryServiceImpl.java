package com.ccut.item.service;

import com.ccut.item.mapper.CategoryMapper;
import com.ccut.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CategoryService
 * @Description: TODO Category商品分类业务层实现
 * @Author: Mark
 * @Date: 2019/7/30 10:33
 * @version: V1.0
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 根据parentId查询子类目
     *
     * @param pid
     * @return List<Category>
     */
    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return categoryMapper.select(category);
    }
}
