package com.imooc.dataobject.mapper;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by hh on 2017/9/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void testInsertByMap() throws Exception {

        Map map = new HashMap<>();
        map.put("categoryName","haoci");
        map.put("categoryType",9);
        productCategoryMapper.insertByMap(map);
    }

    @Test
    public void testInsertByObject() throws Exception {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("buhaochi");
        productCategory.setCategoryType(23);
        productCategoryMapper.insertByObject(productCategory);
    }

    @Test
    public void testFindByCategoryType() throws Exception {

        ProductCategory productCategory = productCategoryMapper.findByCategoryType(23);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void testFindByCategoryName() throws Exception {

        List<ProductCategory> productCategoryList = productCategoryMapper.findByCategoryName("爸妈最爱");
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void testUpdateByCategoryType(){
        int result = productCategoryMapper.updateByCategoryType("爸妈最爱",23);
        Assert.assertEquals(1,result);
    }

    @Test
    public void testUpdateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("hahah");
        productCategory.setCategoryType(5);
        int result = productCategoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void testDeleteByCategoryType(){
        int result = productCategoryMapper.deleteByCategoryType(9);
        Assert.assertEquals(1,result);
    }
}