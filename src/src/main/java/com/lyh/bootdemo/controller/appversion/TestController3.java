package com.lyh.bootdemo.controller.appversion;

import com.lyh.bootdemo.config.version3.AppVersion3;
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
@RestController("/lyh3")
public class TestController3 {

    @Autowired
    TestService service;

    //    @AppVersion3(maxVersion = "0.0.2",minVersion = "0.0.1")
    @AppVersion3
    @PostMapping(value = "get3/user")
    public String a() {
        return "@AppVersion3(maxVersion = \"0.0.2\",minVersion = \"0.0.1\")";
    }


    //    @AppVersion3(maxVersion = "0.0.5",minVersion = "0.0.3")
    @AppVersion3
    @PostMapping(value = "get3/user")
    public String b() {
        return "@AppVersion3(maxVersion = \"0.0.5\",minVersion = \"0.0.3\")";
    }

}
