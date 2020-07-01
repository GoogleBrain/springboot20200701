package cn.k.springboot01.controller;

import cn.k.springboot01.properties.StuComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class HelloWorldController {

    @Resource
    private StuComponent stuComponent;

    @ResponseBody
    @RequestMapping("/helloworld")
    public String helloWorld(String name){
        System.out.println(name);
        System.out.println(">>>>>>>>"+stuComponent);
        return "当前时间>>>>>"+new Date();
    }
}
