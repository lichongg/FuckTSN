package com.google.errorprone.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
/* loaded from: D:\Downloads\app\classes5.dex */
public @interface RestrictedApi {
    String allowedOnPath() default "";

    Class<? extends Annotation>[] allowlistAnnotations() default {};

    Class<? extends Annotation>[] allowlistWithWarningAnnotations() default {};

    String explanation();

    String link();
}
