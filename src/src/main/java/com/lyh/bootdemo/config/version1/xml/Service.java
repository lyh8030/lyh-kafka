package com.lyh.bootdemo.config.version1.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Description：
 *
 * @author ： Mr. Liu YiHuan
 * @date : 2021/6/9.14:47
 */
public class Service {

    @JacksonXmlProperty(localName = "serviceName")
    private String serviceName;

    @JacksonXmlElementWrapper(localName = "mappings")
    @JacksonXmlProperty(localName = "mapping")
    private List<Mapping> mapping;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<Mapping> getMapping() {
        return mapping;
    }

    public void setMapping(List<Mapping> mapping) {
        this.mapping = mapping;
    }



}