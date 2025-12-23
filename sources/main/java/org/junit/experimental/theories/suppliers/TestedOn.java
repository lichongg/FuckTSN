package org.junit.experimental.theories.suppliers;

import g5.a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.experimental.theories.ParametersSuppliedBy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.PARAMETER})
@ParametersSuppliedBy(a.class)
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\Downloads\app\classes7.dex */
public @interface TestedOn {
    int[] ints();
}
