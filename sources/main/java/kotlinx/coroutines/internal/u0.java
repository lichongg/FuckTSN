package kotlinx.coroutines.internal;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSynchronized.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 2 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,33:1\n20#2:34\n*S KotlinDebug\n*F\n+ 1 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n*L\n31#1:34\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u0 {
    @InternalCoroutinesApi
    public static final <T> T a(@NotNull Object obj, @NotNull Function0<? extends T> function0) {
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
}
