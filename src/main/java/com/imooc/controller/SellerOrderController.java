package com.imooc.controller;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by hh on 2017/9/20.
 */

@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {

    private final static Logger log= LoggerFactory.getLogger(SellerOrderController.class);

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "4") Integer size
                             ){
        PageRequest pageRequest = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        Map<String,Object> map = new HashMap<>();
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        ModelAndView modelAndView = new ModelAndView("order/list",map);
        return modelAndView;
        //OrderDTO orderDTO = new OrderDTO();
    }

    /**取消订单*/
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "orderId") String orderId,
                               Map<String ,Object> map){

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        }catch (SellException e){
            log.error("【卖家端取消订单】发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success");
    }

    /**订单详情*/
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO=orderService.findOne(orderId);
        }catch (SellException e){
            log.error("【卖家端查询订单详情】发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }

    /**完结订单*/
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String,Object> map){

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e){
            log.error("【卖家端完结订单】发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);

    }
}
