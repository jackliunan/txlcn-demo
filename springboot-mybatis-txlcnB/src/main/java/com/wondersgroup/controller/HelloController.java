package com.wondersgroup.controller;


import com.wondersgroup.entity.User;
import com.wondersgroup.service.demo.DemoService;
import com.wondersgroup.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    UserService userService;

    @Autowired
    private DemoService demoService;

    @RequestMapping(method = RequestMethod.POST, value = "/h")
    public List<User> hello() {
        return userService.selectLibrarian();
    }


    @GetMapping("/rpc")
    public String rpc(@RequestParam("value") String value, HttpServletRequest servletRequest) {
        return demoService.rpc(value);
    }
}
