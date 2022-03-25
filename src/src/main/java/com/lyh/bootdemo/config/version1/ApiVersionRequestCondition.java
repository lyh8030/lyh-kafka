package com.lyh.bootdemo.config.version1;

import com.lyh.bootdemo.config.version1.xml.App2CmssVersionMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:04
 **/
public class ApiVersionRequestCondition implements RequestCondition<ApiVersionRequestCondition> {
    /**
     * 用于获取header中的版本号的key
     */
    public static final String VERSION_PARAM = "appVersion";
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * header中的版本号
     */
    private String version;


    /**
     * ServletWebServerApplicationContext初始化后
     * <p>
     * ApiVersionHandlerMapping 会构造所有的 ApiVersionRequestCondition
     *
     * @param version
     */
    public ApiVersionRequestCondition(String version) {
        this.version = version;
    }

    public ApiVersionRequestCondition(String version, String serviceName) {
        this.version = version;
        this.serviceName = serviceName;
    }

    @Override
    public ApiVersionRequestCondition combine(ApiVersionRequestCondition other) {
        //多个 ApiVersionRequestCondition 都满足时，如何确定一个唯一的
        //这里取新版的
        return this.version.compareTo(other.version) >= 0 ? this : other;
    }

    @Override
    public ApiVersionRequestCondition getMatchingCondition(HttpServletRequest request) {
        String appVersion = request.getHeader(VERSION_PARAM);
        //通过映射获取app对应的 apiVersion
        try {
            String apiVersion = App2CmssVersionMapping.MAPPING.get(this.serviceName).get(appVersion);
            if (apiVersion.equals(this.version)) {
                // return ，则表示匹配，
                // 这个 this是 ApiVersionHandlerMapping 通过 handlerType 或 method 获取其方法注解构建的
                return this;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * 排序，优先匹配原则，
     *
     * @param other
     * @param request
     * @return
     */
    @Override
    public int compareTo(ApiVersionRequestCondition other, HttpServletRequest request) {
        //TODO ，排序，优先匹配原则，暂时以版本越新越优先
        return this.version.compareTo(other.version);
    }

    public String getVersion() {
        return version;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String toString() {
        return "ApiVersionRequestCondition{" +
                "serviceName='" + serviceName + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}