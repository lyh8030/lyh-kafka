package com.lyh.bootdemo.config.version1.xml;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:16
 **/

public class App2CmssVersionMapping {
    private App2CmssVersionMapping() {
    }

    /**
     * TODO , 怎么维护 url同 版本映射的映射
     */

    public static Map<String, Map<String, String>> MAPPING;

    static {
        MAPPING = new HashMap<>();
        //app版本同cmss版本映射
        HashMap<String, String> login = new HashMap<>(8);
        login.put("0.0.1", "0.0.1");
        login.put("0.0.2", "0.0.1");
        login.put("0.0.3", "0.0.1");
        MAPPING.put("login", login);

        HashMap<String, String> register = new HashMap<>(8);
        register.put("0.0.1", "0.0.1");
        register.put("0.0.2", "0.0.2");
        register.put("0.0.3", "0.0.2");
        MAPPING.put("login", register);

        HashMap<String, String> test = new HashMap<>(8);
        test.put("0.0.1", "0.0.1");
        test.put("0.0.2", "0.0.2");
        test.put("0.0.3", "0.0.2");
        test.put("0.0.4", "0.0.3");
        //多版本匹配处理，参考 combine 方法
        test.put("0.0.5", "0.0.1");
        MAPPING.put("test", test);

        HashMap<String, String> TEST = new HashMap<>(8);
        TEST.put("0.0.1", "0.0.1");
        TEST.put("0.0.2", "0.0.2");
        MAPPING.put("TEST", TEST);

    }

}
