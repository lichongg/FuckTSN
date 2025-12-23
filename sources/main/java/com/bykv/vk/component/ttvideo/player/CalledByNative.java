package com.bykv.vk.component.ttvideo.player;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: D:\Downloads\app\classes3.dex */
public @interface CalledByNative {
    String value() default "";
}
