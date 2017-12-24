package com.imooc.converter;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hh on 2017/9/17.
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(OrderMaster orderMaster : orderMasterList){
            OrderDTO orderDTO = convert(orderMaster);
            orderDTOList.add(orderDTO);

        }
        return orderDTOList;
    }
}
