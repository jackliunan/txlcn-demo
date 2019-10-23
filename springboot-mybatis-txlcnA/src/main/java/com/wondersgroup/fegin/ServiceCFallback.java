package com.wondersgroup.fegin;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Date: 19-2-19 下午1:53
 *
 * @author ujued
 */
@Component
public class ServiceCFallback implements ServiceCClient {

    @Override
    public String rpc(String name) {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return "fallback";
    }
}
