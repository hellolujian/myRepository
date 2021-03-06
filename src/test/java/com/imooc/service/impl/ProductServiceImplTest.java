package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by hh on 2017/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testFindOne() throws Exception {

        ProductInfo productInfo=productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void testFindUpAll() throws Exception {

        List<ProductInfo> productInfoList=productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void testFindAll() throws Exception {

        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> productInfoPage=productService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void testSave() throws Exception {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale(){
        ProductInfo productInfo = productService.onSale("123456");
        Assert.assertEquals(ProductStatusEnum.UP,productInfo.getProductStatusEnum());
    }

    @Test
    public void offSale(){
        ProductInfo productInfo = productService.offSale("123456");
        Assert.assertEquals(ProductStatusEnum.DOWN,productInfo.getProductStatusEnum());
    }
}