package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\Downloads\app\classes8.dex */
public @interface Nonnull {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Checker implements TypeQualifierValidator<Nonnull> {
        @Override // javax.annotation.meta.TypeQualifierValidator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public When a(Nonnull nonnull, Object obj) {
            return obj == null ? When.NEVER : When.ALWAYS;
        }
    }

    When when() default When.ALWAYS;
}
