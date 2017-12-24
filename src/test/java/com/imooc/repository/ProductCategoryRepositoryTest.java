package com.imooc.repository;

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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRespository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=productCategoryRespository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    //@Transactional表示不把测试数据插入到数据库中
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(4);
        ProductCategory result = productCategoryRespository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest(){

        List<Integer> list= Arrays.asList(2,3,4);
        List<ProductCategory> result =productCategoryRespository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }


}