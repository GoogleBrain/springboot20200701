package cn.k.springboot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/helloworld")
    public String helloWorld(String name){
        System.out.println(name);

        return "当前时间>>>>>"+new Date();
    }
}
