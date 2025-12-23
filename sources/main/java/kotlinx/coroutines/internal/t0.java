package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t0 {
    @InternalCoroutinesApi
    public static final <T> T b(@NotNull Object obj, @NotNull Function0<? extends T> function0) {
        T invoke;
        synchronized (obj) {
            try {
                invoke = function0.invoke();
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

    @InternalCoroutinesApi
    public static /* synthetic */ void a() {
    }
}
