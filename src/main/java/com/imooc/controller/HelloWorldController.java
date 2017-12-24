package com.imooc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hh on 2017/9/30.
 */
@RestController
public class HelloWorldController {

    @RequestMapping
    public String hello(){
        return "hello,world";
    }
}
