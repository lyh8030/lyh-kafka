package com.lyh.bootdemo.config.version2;

import java.lang.annotation.*;

/**
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:03
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AppVersion2 {

    String[] appVersions() default {};
}
