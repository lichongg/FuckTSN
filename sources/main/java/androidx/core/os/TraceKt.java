package androidx.core.os;

import android.os.Trace;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class TraceKt {
    @Deprecated(message = "Use androidx.tracing.Trace instead", replaceWith = @ReplaceWith(expression = "trace(sectionName, block)", imports = {"androidx.tracing.trace"}))
    public static final <T> T trace(@NotNull String str, @NotNull Function0<? extends T> function0) {
        Trace.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            d0.d(1);
            Trace.endSection();
            d0.c(1);
        }
    }
}
