package com.amayadream.qiandao.common.annotation;

import java.lang.annotation.*;

/**
 * 本注解用于只有ADMIN才能调用的控制器上, 便于切面扫描
 * @author :  Amayadream
 * @date :  2017.03.15 17:00
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdminOnly {

    String desc() default "本注解用于只有管理人员才能调用的控制器上, 便于切面扫描...";

}
