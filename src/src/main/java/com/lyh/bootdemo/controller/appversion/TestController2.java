package com.lyh.bootdemo.controller.appversion;

import com.lyh.bootdemo.config.version2.AppVersion2;
import com.lyh.bootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查看 RequestMappingHandlerMapping::isHandler 方法判断
 * <p>
 * '@RestController 有 @Controller 注解
 * '@PostMapping和@GetMapping 有 @RequestMapping 注解
 * <p>
 * 方法实现参考 https://blog.csdn.net/sinat_29508581/article/details/89392831
 * 源码解析参考 https://www.jianshu.com/p/fd4a61c47b86
 *
 * @author ： Mr. Liu YiHuan
 * @date : 2021/6/7.20:47
 */
//@RestController("/lyh2")
public class TestController2 {

    @Autowired
    TestService service;

    @AppVersion2(appVersions = {"0.0.1","0.0.2"})
    @PostMapping(value = "get2/user")
    public String a() {
        return service.a();
    }


    @AppVersion2(appVersions = {"0.0.3","0.0.4"})
    @PostMapping(value = "get2/user")
    public String b() {
        return  service.b();
    }

}
