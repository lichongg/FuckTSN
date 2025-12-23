package com.google.errorprone.annotations.concurrent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Deprecated
/* loaded from: D:\Downloads\app\classes5.dex */
public @interface LockMethod {
    String[] value();
}
