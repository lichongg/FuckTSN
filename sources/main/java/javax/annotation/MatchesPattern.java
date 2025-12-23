package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TypeQualifier(applicableTo = String.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: D:\Downloads\app\classes8.dex */
public @interface MatchesPattern {
    int flags() default 0;

    @RegEx
    String value();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Checker implements TypeQualifierValidator<MatchesPattern> {
        @Override // javax.annotation.meta.TypeQualifierValidator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public When a(MatchesPattern matchesPattern, Object obj) {
            if (Pattern.compile(matchesPattern.value(), matchesPattern.flags()).matcher((String) obj).matches()) {
                return When.ALWAYS;
            }
            return When.NEVER;
        }
    }
}
