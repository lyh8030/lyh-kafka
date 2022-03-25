package com.lyh.bootdemo.config.version3;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 这个类没有啥问题了
 */
@SuppressWarnings("all")
public class ApiVersionHandlerMapping3 extends RequestMappingHandlerMapping {


    /**
     * getMappingForMethod --  createRequestMappingInfo（handlerType）-- getCustomTypeCondition
     * <p>
     * -- createRequestMappingInfo(requestMapping, condition)
     * <p>
     * <p>
     * 自定义 RequestCondition，这个方法父类实现就是空的，属于个模板方法，留待子类实现的
     *
     * @param handlerType ，使用了@Controller、@RequestMapping注解的类，包括@RestController
     * @return
     */
    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        //判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition3 condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, AppVersion3.class));
        return condition;
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition3 condition = buildFrom(AnnotationUtils.findAnnotation(method, AppVersion3.class));

        return condition;
    }

    /**
     * 获取ApiVersion注解的value，构建ApiVersionRequestCondition对象，
     *
     * @param appVersion3
     * @return
     */
    private ApiVersionRequestCondition3 buildFrom(AppVersion3 appVersion3) {
        return appVersion3 == null ? null : new ApiVersionRequestCondition3(appVersion3.minVersion(), appVersion3.maxVersion());
    }
}