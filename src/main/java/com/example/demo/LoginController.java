package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by 不爱编程的程序猿
 * 2018/11/8
 */
@RestController
@RequestMapping("/loginController")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@RequestBody User user) {
        System.out.printf("用户名" + user.getUserName());
        System.out.printf("用户密码" + user.getPassword());
        return "123456";
    }

}
