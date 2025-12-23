package com.google.auto.value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: D:\Downloads\app\classes5.dex */
public @interface AutoOneOf {
    Class<? extends Enum<?>> value();
}
