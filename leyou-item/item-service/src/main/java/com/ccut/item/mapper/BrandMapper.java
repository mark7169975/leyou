package com.ccut.item.mapper;

import com.ccut.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName: BrandMapper
 * @Description: TODO
 * @Author: Mark
 * @Date: 2019/7/30 19:16
 * @version: V1.0
 */
public interface BrandMapper extends Mapper<Brand> {

    /**
     * 新增商品中间表数据
     * @param id
     * @param cid
     */
    @Insert("INSERT INTO tb_category_brand (category_id,brand_id)VALUES(#{cid},#{id})")
    void insertCategoryBrand(@Param("id") Long id,@Param("cid") Long cid);
}
