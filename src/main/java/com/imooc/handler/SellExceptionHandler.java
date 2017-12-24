package com.imooc.handler;

import com.imooc.VO.ResultVO;
import com.imooc.exception.SellException;
import com.imooc.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hh on 2017/9/29.
 */
@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }
}
