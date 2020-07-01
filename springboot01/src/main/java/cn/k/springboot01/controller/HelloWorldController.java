package cn.k.springboot01.controller;

import cn.k.springboot01.domain.User;
import cn.k.springboot01.properties.StuComponent;
import cn.k.springboot01.properties.StuComponent2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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



    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("message","123");
        return  "index";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "index";
    }

    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("⼤⽜",12,"123456");
        User user2=new User("⼩⽜",6,"123563");
        User user3=new User("纯洁的微笑",66,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }


    @GetMapping("/more")
    public String uploadMore() {
        return "uploadMore";
    }



    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    @PostMapping("/uploadMore")
    public String moreFileUpload(@RequestParam("file") MultipartFile[] files,
                                 RedirectAttributes redirectAttributes) {
        if (files.length==0) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            String end=filename.substring(filename.indexOf("."));
            filename = UUID.randomUUID()+end;
            String path = "E:/images/rotPhoto/";
            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            try {
                file.transferTo(new File(path + File.separator + filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("http://127.0.0.1:8080/images/rotPhoto/" + filename);
        }
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded all ");
        return "redirect:/uploadStatus";
    }
}
