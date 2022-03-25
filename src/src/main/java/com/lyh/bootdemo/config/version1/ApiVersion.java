package com.lyh.bootdemo.config.version1;

import java.lang.annotation.*;

/**
 *
 *
 *
 *
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:03
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiVersion {
    // 定义接口的版本号
    String value() default "";

    String serviceName() default "";

}
