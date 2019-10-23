package com.wondersgroup.fegin;


import com.quick2.framework.beans.common.StateResp;
import com.wondersgroup.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "txlcn-demo-spring-service-b")
public interface HelloFegin {

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    StateResp<User> update(@RequestBody User user);

}
