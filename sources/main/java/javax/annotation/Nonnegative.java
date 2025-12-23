package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\Downloads\app\classes8.dex */
public @interface Nonnegative {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        @Override // javax.annotation.meta.TypeQualifierValidator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public When a(Nonnegative nonnegative, Object obj) {
            if (!(obj instanceof Number)) {
                return When.NEVER;
            }
            Number number = (Number) obj;
            return (!(number instanceof Long) ? !(!(number instanceof Double) ? !(!(number instanceof Float) ? number.intValue() < 0 : number.floatValue() < 0.0f) : number.doubleValue() < 0.0d) : number.longValue() < 0) ? When.ALWAYS : When.NEVER;
        }
    }

    When when() default When.ALWAYS;
}
