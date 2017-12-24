package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.BuyerService;
import com.imooc.service.OrderService;
import org.hibernate.dialect.lock.SelectLockingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hh on 2017/9/18.
 */
@Service
public class BuyerServiceImpl implements BuyerService {

    private static final Logger log = LoggerFactory.getLogger(BuyerServiceImpl.class);

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO==null){
            log.error("【取消订单】查不到该订单，OrderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO==null){
            return null;
        }
        if(!orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【查询订单】订单的openid不一致");
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
