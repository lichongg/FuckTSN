package com.bytedance.sdk.openadsdk.ats;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\Downloads\app\classes4.dex */
public @interface ATSApi {
    String value() default "";
}
