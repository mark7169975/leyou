package com.ccut.item.service;

import com.ccut.common.pojo.PageResult;
import com.ccut.item.mapper.BrandMapper;
import com.ccut.item.pojo.Brand;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName: BrandService
 * @Description: TODO   品牌列表的业务层实现
 * @Author: Mark
 * @Date: 2019/7/30 19:36
 * @version: V1.0
 */
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {

        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        //判断key是否为空
        if (StringUtils.isNotBlank(key)) {
            //模糊查询name或者查询开头字母
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        //是否根据sortBy字段排序
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }
        //添加分页条件
        PageHelper.startPage(page, rows);
        List<Brand> brandList = brandMapper.selectByExample(example);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brandList);

        return new PageResult<>(brandPageInfo.getTotal(),brandPageInfo.getPageNum(),brandPageInfo.getList());
    }

    @Override
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        this.brandMapper.insert(brand);
        cids.forEach(cid->{
            this.brandMapper.insertCategoryBrand(brand.getId(),cid);
        });
    }
}
