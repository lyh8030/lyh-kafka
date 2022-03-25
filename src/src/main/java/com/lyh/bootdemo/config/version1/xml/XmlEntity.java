package com.lyh.bootdemo.config.version1.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Description：
 *
 * @author ： Mr. Liu YiHuan
 * @date : 2021/6/9.13:45
 */
@JacksonXmlRootElement(localName = "services")
public class XmlEntity {


    private Service service;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


}
