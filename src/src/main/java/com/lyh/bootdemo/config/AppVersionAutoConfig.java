package com.lyh.bootdemo.config;

import com.lyh.bootdemo.config.version3.ApiVersionHandlerMapping3;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * WebMvcConfigurerAdapter 弃用 @deprecated as of 5.0
 *
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:07
 **/
public class AppVersionAutoConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        ApiVersionHandlerMapping3 handlerMapping = new ApiVersionHandlerMapping3();
        handlerMapping.setOrder(0);
        return handlerMapping;
    }
}