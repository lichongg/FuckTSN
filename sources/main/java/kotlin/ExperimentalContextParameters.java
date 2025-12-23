package kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.RequiresOptIn;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = "2.2")
@MustBeDocumented
@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "The API is related to the experimental feature \"context parameters\" (see KEEP-367) and may be changed or removed in any future release.")
@Documented
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: D:\Downloads\app\classes8.dex */
public @interface ExperimentalContextParameters {
}
