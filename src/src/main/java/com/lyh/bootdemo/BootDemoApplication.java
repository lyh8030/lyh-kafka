package com.lyh.bootdemo;

import com.lyh.bootdemo.config.version3.EnableAppVersion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAppVersion
public class BootDemoApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BootDemoApplication.class, args);
    }

}
