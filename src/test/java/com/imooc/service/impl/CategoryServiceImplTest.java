package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hh on 2017/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void testFindOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void testFindAll() throws Exception {

        List<ProductCategory> productCategoryList=categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void testFindByCategoryTypeIn() throws Exception {
        List<Integer> list= Arrays.asList(1,2,3,4);
        List<ProductCategory> productCategories=categoryService.findByCategoryTypeIn(list);
        Assert.assertNotNull(productCategories);
    }

    @Test
    public void testSave() throws Exception {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryType(5);
        productCategory.setCategoryName("hahah");
        ProductCategory result=categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }


}