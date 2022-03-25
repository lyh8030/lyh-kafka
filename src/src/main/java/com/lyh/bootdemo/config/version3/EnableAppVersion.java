package com.lyh.bootdemo.config.version3;

import com.lyh.bootdemo.config.AppVersionAutoConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 是否开启AppVersion注解
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AppVersionAutoConfig.class)
public @interface EnableAppVersion {
}
