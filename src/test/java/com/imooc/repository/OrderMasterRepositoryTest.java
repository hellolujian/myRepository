package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * Created by hh on 2017/9/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    private final String OPENID="110110";

    @Test
    public void testFindByBuyerOpenid() throws Exception {

        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderMaster> result=  orderMasterRepository.findByBuyerOpenid(OPENID,pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());
        System.out.println(result.getTotalElements());
    }

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("lujian");
        orderMaster.setBuyerPhone("18852852189");
        orderMaster.setBuyerAddress("江苏大学");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}