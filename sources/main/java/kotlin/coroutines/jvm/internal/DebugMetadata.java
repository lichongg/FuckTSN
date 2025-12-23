package kotlin.coroutines.jvm.internal;

import com.kuaishou.weapon.p0.t;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public @interface DebugMetadata {
    @JvmName(name = "c")
    String c() default "";

    @JvmName(name = "f")
    String f() default "";

    @JvmName(name = "i")
    int[] i() default {};

    @JvmName(name = t.f36143d)
    int[] l() default {};

    @JvmName(name = t.f36152m)
    String m() default "";

    @JvmName(name = "n")
    String[] n() default {};

    @JvmName(name = "nl")
    int[] nl() default {};

    @JvmName(name = "s")
    String[] s() default {};

    @JvmName(name = "v")
    int v() default 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        @SinceKotlin(version = "2.2")
        public static /* synthetic */ void a() {
        }
    }
}
