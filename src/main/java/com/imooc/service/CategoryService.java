package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by hh on 2017/9/13.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
