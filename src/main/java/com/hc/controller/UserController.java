package com.hc.controller;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Log4j
public class UserController {

    @RequestMapping("/add")
    public String add(Model model) {
        return "user/add";
    }

    @RequestMapping("/update")
    public String update(Model model) {
        return "user/update";
    }

    @RequestMapping("/detail")
    public String detail(Model model) {
        return "user/detail";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        return "user/list";
    }

    @PostMapping("/login")
    public String login(String username, String userpwd, Model model) {
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, userpwd);
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) { //用户名不存在
            model.addAttribute("msg", "用户名错误");
            log.info(e.getMessage());
            return "login";
        } catch (IncorrectCredentialsException e) { //用户名不存在
            model.addAttribute("msg", "密码错误");
            log.info(e.getMessage());
            return "login";
        }
    }

}
