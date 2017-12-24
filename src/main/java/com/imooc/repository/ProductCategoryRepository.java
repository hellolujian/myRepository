package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hh on 2017/9/13.
 */
@Component
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**类目列表*/
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
