package cn.k.springboot01.controller;

import cn.k.springboot01.properties.StuComponent;
import cn.k.springboot01.properties.StuComponent2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class HelloWorldController {

    @Resource
    private StuComponent stuComponent;

    @Resource
    private StuComponent2 stuComponent2;

    @ResponseBody
    @RequestMapping("/helloworld")
    public String helloWorld(String name){
        System.out.println("请求参数值："+name);
        System.out.println("获取配置文件值："+stuComponent);
        System.out.println("获取配置文件值2："+stuComponent2);
        return "当前时间>>>>>"+new Date();
    }
}
