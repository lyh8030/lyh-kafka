package com.lyh.bootdemo.config.version2;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author : Liu YiHuan
 * @date: 2021/6/8 23:04
 **/
public class ApiVersionRequestCondition2 implements RequestCondition<ApiVersionRequestCondition2> {
    /**
     * 用于获取header中的版本号的key
     */
    public static final String VERSION_PARAM = "appVersion";
    /**
     *
     */
    private String[] appVersions;


    /**
     * ServletWebServerApplicationContext初始化后
     * <p>
     * ApiVersionHandlerMapping 会构造所有的 ApiVersionRequestCondition
     *
     * @param appVersions 支持的app版本集合
     */
    public ApiVersionRequestCondition2(String[] appVersions) {
        this.appVersions = appVersions;
    }


    @Override
    public ApiVersionRequestCondition2 combine(ApiVersionRequestCondition2 other) {
        //多个 ApiVersionRequestCondition 都满足时，如何确定一个唯一的
        //这里取支持的版本多的
        return this.appVersions.length - other.appVersions.length >= 0 ? this : other;
    }

    @Override
    public ApiVersionRequestCondition2 getMatchingCondition(HttpServletRequest request) {

        String appVersion = request.getHeader(VERSION_PARAM);
        if (Arrays.stream(appVersions).anyMatch(x -> x.equals(appVersion))) {
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
    public int compareTo(ApiVersionRequestCondition2 other, HttpServletRequest request) {
        //TODO ，排序，数组越长表示支持版本越多，越优先
        return this.appVersions.length - other.appVersions.length;
    }

    public String[] getAppVersions() {
        return appVersions;
    }

    public void setAppVersions(String[] appVersions) {
        this.appVersions = appVersions;
    }

    @Override
    public String toString() {
        return "ApiVersionRequestCondition2{" +
                "appVersions=" + Arrays.toString(appVersions) +
                '}';
    }
}