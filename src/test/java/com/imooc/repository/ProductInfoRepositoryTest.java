package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hh on 2017/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testSave(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result=productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByProductStatus() throws Exception {

        List<ProductInfo> productInfoList=productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}