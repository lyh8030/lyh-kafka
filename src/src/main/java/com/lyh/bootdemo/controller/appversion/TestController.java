package com.lyh.bootdemo.controller.appversion;

import com.lyh.bootdemo.config.version1.ApiVersion;
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
//@RestController("/lyh")
public class TestController {

    @ApiVersion(value = "0.0.1", serviceName = "test")
    @PostMapping(value = "test/version")
    public String a() {
        return "1个字段";
    }


    @ApiVersion(value = "0.0.2", serviceName = "test")
    @PostMapping(value = "test/version")
    public String b() {
        return "2个字段";
    }

    @ApiVersion(value = "0.0.3", serviceName = "test")
    @PostMapping(value = "test/version")
    public String c() {
        return "ojbk-0.0.3";
    }

    @ApiVersion(value = "0.0.4", serviceName = "test")
    @PostMapping(value = "test/version")
    public String d() {
        return "ojbk-0.0.4";
    }

    @ApiVersion(value = "0.0.1", serviceName = "TEST")
    @PostMapping(value = "/TEST/version")
    public String A() {
        return "OJBK-0.0.1";
    }

    @ApiVersion(value = "0.0.2", serviceName = "TEST")
    @PostMapping(value = "/TEST/version")
    public String B() {
        return "OJBK-0.0.2";
    }
}
