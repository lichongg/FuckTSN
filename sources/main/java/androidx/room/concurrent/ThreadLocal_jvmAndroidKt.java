package androidx.room.concurrent;

import kotlin.coroutines.i;
import kotlin.jvm.internal.g0;
import kotlinx.coroutines.f3;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ThreadLocal_jvmAndroidKt {
    @NotNull
    public static final <T> i.b asContextElement(@NotNull ThreadLocal<T> threadLocal, T t5) {
        g0.p(threadLocal, "<this>");
        return f3.a(threadLocal, t5);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static /* synthetic */ void ThreadLocal$annotations() {
    }
}
