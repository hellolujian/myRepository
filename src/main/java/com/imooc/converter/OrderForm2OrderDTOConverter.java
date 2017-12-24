package com.imooc.converter;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import net.sf.json.JSONArray;

import java.util.List;

/**
 * Created by hh on 2017/9/17.
 */
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        JSONArray jsonArray;
        try {

            jsonArray= JSONArray.fromObject(orderForm.getItems());

        }catch (Exception e){
            throw new SellException(ResultEnum.PARAM_ERROR2);
        }
        List<OrderDetail> orderDetailList = JSONArray.toList(jsonArray,OrderDetail.class);
        //List<OrderDetail> orderDetailList = new ArrayList<>();
        //OrderDetail orderDetail = new OrderDetail();
        //orderDetail.setOrderId("dsfsd");
        //orderDetail.setProductQuantity(2);
        //orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
