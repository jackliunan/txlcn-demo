package com.wondersgroup.controller;


import com.wondersgroup.entity.User;
import com.wondersgroup.service.demo.DemoService;
import com.wondersgroup.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    UserService userService;

    @Autowired
    DemoService demoService;

    @RequestMapping(method = RequestMethod.POST, value = "/h")
    public List<User> hello() {
        return userService.selectLibrarian();
    }


    @RequestMapping(method = RequestMethod.POST, value = "/insert")
    public String insert(@RequestParam("value") String value, @RequestParam(value = "ex", required = false) String exFlag) {
        return demoService.execute(value, exFlag);
    }
}
