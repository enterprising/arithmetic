package net.tanpeng.catshengspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: peng.tan
 * @create: 2020/03/29 23:53
 * RestController 注解的意思就是 Controller 里面的方法都以 json 格式输出，不用再写什么 jackjson 配置的了
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
