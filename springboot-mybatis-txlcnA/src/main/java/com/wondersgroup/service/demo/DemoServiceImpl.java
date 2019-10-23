package com.wondersgroup.service.demo;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.wondersgroup.entity.Demo;
import com.wondersgroup.fegin.ServiceCClient;
import com.wondersgroup.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Objects;

/**
 * Description:
 * Date: 2018/12/25
 *
 * @author ujued
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    DemoMapper demoMapper;
    @Autowired
    ServiceCClient serviceCClient;
    @Autowired
    RestTemplate restTemplate;

    @Override
    @LcnTransaction
    @Transactional
    public String execute(String value, String exFlag) {
        // step1. call remote ServiceD

        String dResp = restTemplate.getForObject("http://txlcn-demo-spring-service-b/hello/rpc?value=" + value, String.class);

        // step2. call remote ServiceE
        String eResp = serviceCClient.rpc(value);

        // step3. execute local transaction
        Demo demo = new Demo();
        demo.setGroupId(TracingContext.tracing().groupId());
        demo.setDemoField(value);
        demo.setCreateTime(new Date());
        demo.setAppName(Transactions.getApplicationId());
        demoMapper.save(demo);

        // 置异常标志，DTX 回滚
        if (Objects.nonNull(exFlag)) {
            throw new IllegalStateException("by exFlag");
        }

        return dResp + " > " + eResp + " > " + "ok-service-a";
    }
}
