package com.lyh.bootdemo.config.version2;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 这个类没有啥问题了
 *
 *
 *
 *
 */
public class ApiVersionHandlerMapping2 extends RequestMappingHandlerMapping {


    /**
     *
     * getMappingForMethod --  createRequestMappingInfo（handlerType）-- getCustomTypeCondition
     *
     *   -- createRequestMappingInfo(requestMapping, condition)
     *
     *
     * 自定义 RequestCondition，这个方法父类实现就是空的，属于个模板方法，留待子类实现的
     *
     * @param handlerType ，使用了@Controller、@RequestMapping注解的类，包括@RestController
     * @return
     */
    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        //判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition2 condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, AppVersion2.class));
        return condition;
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
// 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition2 condition = buildFrom(AnnotationUtils.findAnnotation(method, AppVersion2.class));

        return condition;
    }

    /**
     * 获取ApiVersion注解的value，构建ApiVersionRequestCondition对象，
     *
     * @param appVersion2
     * @return
     */
    private ApiVersionRequestCondition2 buildFrom(AppVersion2 appVersion2) {
        return appVersion2 == null ? null : new ApiVersionRequestCondition2(appVersion2.appVersions());
    }
}