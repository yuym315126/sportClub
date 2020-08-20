package com.sport.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: voter
 * @description: 自定义注解 标记dto属性 对应的pojo
 * @author:
 * @create: 2020-07-16 12:06
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BeanCopyField {
    String value() ;
}
