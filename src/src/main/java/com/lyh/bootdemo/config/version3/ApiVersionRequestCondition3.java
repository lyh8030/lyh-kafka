package com.lyh.bootdemo.config.version3;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:04
 **/
public class ApiVersionRequestCondition3 implements RequestCondition<ApiVersionRequestCondition3> {
    /**
     * 用于获取header中的版本号的key
     */
    public static final String VERSION_PARAM = "appVersion";
    private String minVersion;
    private String maxVersion;


    /**
     * ServletWebServerApplicationContext初始化后
     * <p>
     * ApiVersionHandlerMapping 会构造所有的 ApiVersionRequestCondition
     */
    public ApiVersionRequestCondition3(String minVersion, String maxVersion) {
        this.minVersion = minVersion;
        this.maxVersion = maxVersion;
    }


    @Override
    public ApiVersionRequestCondition3 combine(ApiVersionRequestCondition3 other) {
        //多个 ApiVersionRequestCondition 都满足时，如何确定一个唯一的
        //这里取 范围跨度大的
        return this.maxVersion.compareTo(this.minVersion) >= other.maxVersion.compareTo(other.minVersion) ? this : other;
    }

    @Override
    public ApiVersionRequestCondition3 getMatchingCondition(HttpServletRequest request) {

        String appVersion = request.getHeader(VERSION_PARAM);

        if (contains(this.maxVersion, this.minVersion, appVersion)) {
            return this;
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
    public int compareTo(ApiVersionRequestCondition3 other, HttpServletRequest request) {
        return this.maxVersion.compareTo(this.minVersion) - other.maxVersion.compareTo(other.minVersion);
    }


    public String getMinVersion() {
        return minVersion;
    }

    public void setMinVersion(String minVersion) {
        this.minVersion = minVersion;
    }

    public String getMaxVersion() {
        return maxVersion;
    }

    public void setMaxVersion(String maxVersion) {
        this.maxVersion = maxVersion;
    }

    @Override
    public String toString() {
        return "ApiVersionRequestCondition3{" +
                "minVersion='" + minVersion + '\'' +
                ", maxVersion='" + maxVersion + '\'' +
                '}';
    }

    private boolean contains(String maxVersion, String minVersion, String version) {
        return version.compareTo(minVersion) >= 0 && version.compareTo(maxVersion) <= 0;

    }

}