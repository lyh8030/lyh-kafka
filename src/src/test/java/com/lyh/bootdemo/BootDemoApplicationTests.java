package com.lyh.bootdemo;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

class BootDemoApplicationTests {

    @Test
    void contextLoads() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
    }

}
