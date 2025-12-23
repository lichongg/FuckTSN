package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.ANNOTATION_TYPE})
/* loaded from: D:\Downloads\app\classes.dex */
public @interface InverseBindingMethod {
    String attribute();

    String event() default "";

    String method() default "";

    Class type();
}
