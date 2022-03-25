package com.lyh.bootdemo.config.version3;

import java.lang.annotation.*;

/**
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:03
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AppVersion3 {

    String minVersion() default "0.0.0";
    String maxVersion() default "999.999.999";
}
