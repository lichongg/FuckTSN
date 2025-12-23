package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nThreadPoolDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadPoolDispatcher.kt\nkotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class k3 {
    @DelicateCoroutinesApi
    @NotNull
    public static final t1 b(final int i6, @NotNull final String str) {
        if (i6 >= 1) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return v1.d(Executors.newScheduledThreadPool(i6, new ThreadFactory() { // from class: kotlinx.coroutines.j3
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread c6;
                    c6 = k3.c(i6, str, atomicInteger, runnable);
                    return c6;
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i6 + " specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread c(int i6, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i6 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }
}
