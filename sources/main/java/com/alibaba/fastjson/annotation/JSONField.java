package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\Downloads\app\classes2.dex */
public @interface JSONField {
    String[] alternateNames() default {};

    boolean deserialize() default true;

    Class<?> deserializeUsing() default Void.class;

    String format() default "";

    boolean jsonDirect() default false;

    String label() default "";

    String name() default "";

    int ordinal() default 0;

    Feature[] parseFeatures() default {};

    boolean serialize() default true;

    Class<?> serializeUsing() default Void.class;

    SerializerFeature[] serialzeFeatures() default {};

    boolean unwrapped() default false;
}
