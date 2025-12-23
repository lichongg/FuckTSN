package com.bytedance.sdk.component.qv.xt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\Downloads\app\classes4.dex */
public @interface j {
    String j() default "";
}
