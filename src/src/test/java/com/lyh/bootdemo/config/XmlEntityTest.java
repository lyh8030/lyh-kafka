package com.lyh.bootdemo.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lyh.bootdemo.config.version1.xml.XmlEntity;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Description：
 *
 * @author ： Mr. Liu YiHuan
 * @date : 2021/6/9.14:25
 */
class XmlEntityTest {
    String xmlStr = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
            "<services>\n" +
            "    <service>\n" +
            "        <serviceName>test</serviceName>\n" +
            "        <mappings>\n" +
            "            <mapping>\n" +
            "                <appVersion>0.0.1</appVersion>\n" +
            "                <apiVersion>0.0.1</apiVersion>\n" +
            "            </mapping>\n" +
            "            <mapping>\n" +
            "                <appVersion>0.0.2</appVersion>\n" +
            "                <apiVersion>0.0.2</apiVersion>\n" +
            "            </mapping>\n" +
            "            <mapping>\n" +
            "                <appVersion>0.0.3</appVersion>\n" +
            "                <apiVersion>0.0.2</apiVersion>\n" +
            "            </mapping>\n" +
            "            <mapping>\n" +
            "                <appVersion>0.0.4</appVersion>\n" +
            "                <apiVersion>0.0.3</apiVersion>\n" +
            "            </mapping>\n" +
            "            <mapping>\n" +
            "                <appVersion>0.0.5</appVersion>\n" +
            "                <apiVersion>0.0.4</apiVersion>\n" +
            "            </mapping>\n" +
            "        </mappings>\n" +
            "    </service>\n" +
            "</services>";

    @Test
    public void test() throws IOException {


        ObjectMapper OBJECT_MAPPER = new XmlMapper();
        // 字段为null，自动忽略，不再序列化
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        XmlEntity xmlEntity = OBJECT_MAPPER.readValue(xmlStr, XmlEntity.class);

        // 美化输出的 xml 字符串
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        // 字段为null，自动忽略，不再序列化
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        System.out.println(OBJECT_MAPPER.writeValueAsString(xmlEntity));


    }

}