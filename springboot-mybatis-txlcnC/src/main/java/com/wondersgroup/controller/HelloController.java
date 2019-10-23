package com.wondersgroup.controller;


import com.wondersgroup.entity.User;
import com.wondersgroup.service.demo.DemoService;
import com.wondersgroup.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @Autowired
    private DemoService demoService;

    @GetMapping("/rpc")
    public String rpc(@RequestParam("value") String value) {
        return demoService.rpc(value);
    }
}
