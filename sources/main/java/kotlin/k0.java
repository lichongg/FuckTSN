package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class k0 extends j0 {
    @InlineOnly
    private static final <R> R l(Object lock, Function0<? extends R> block) {
        R invoke;
        kotlin.jvm.internal.g0.p(lock, "lock");
        kotlin.jvm.internal.g0.p(block, "block");
        synchronized (lock) {
            try {
                invoke = block.invoke();
                kotlin.jvm.internal.d0.d(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.d0.d(1);
                kotlin.jvm.internal.d0.c(1);
                throw th;
            }
        }
        kotlin.jvm.internal.d0.c(1);
        return invoke;
    }
}
