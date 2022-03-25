package com.lyh.bootdemo.service;

import org.springframework.stereotype.Service;

/**
 * Description：
 *
 * @author ： Mr. Liu YiHuan
 * @date : 2021/6/9.16:16
 */
@Service
public class TestService {

    public String a() {
        return "支持版本 appVersions = {\"0.0.1\",\"0.0.2\"}";
    }


    public String b() {
        return "支持版本 appVersions = {\"0.0.3\",\"0.0.4\"}";
    }
}
