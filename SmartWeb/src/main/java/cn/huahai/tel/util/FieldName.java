package cn.huahai.tel.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义字段名
 * @author Niu Li
 * @since 2017/2/23
 * 
 * 2018/6/11 借鉴
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface FieldName {
    String value() default "";
    boolean Ignore() default false;
}
