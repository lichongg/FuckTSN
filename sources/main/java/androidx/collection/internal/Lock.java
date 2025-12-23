package androidx.collection.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Lock {
    public final <T> T synchronizedImpl(@NotNull Function0<? extends T> block) {
        T invoke;
        g0.p(block, "block");
        synchronized (this) {
            try {
                invoke = block.invoke();
                d0.d(1);
            } catch (Throwable th) {
                d0.d(1);
                d0.c(1);
                throw th;
            }
        }
        d0.c(1);
        return invoke;
    }
}
