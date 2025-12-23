package org.junit.experimental.categories;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.validator.ValidateWith;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@ValidateWith(b.class)
/* loaded from: D:\Downloads\app\classes7.dex */
public @interface Category {
    Class<?>[] value();
}
