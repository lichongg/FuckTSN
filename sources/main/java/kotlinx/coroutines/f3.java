package kotlinx.coroutines;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nThreadContextElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,288:1\n266#1:289\n1#2:290\n*S KotlinDebug\n*F\n+ 1 ThreadContextElement.kt\nkotlinx/coroutines/ThreadContextElementKt\n*L\n287#1:289\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f3 {
    private static final Object d(ThreadLocal<?> threadLocal, kotlin.coroutines.e<? super kotlin.n1> eVar) {
        kotlin.jvm.internal.d0.e(3);
        throw null;
    }

    private static final Object f(ThreadLocal<?> threadLocal, kotlin.coroutines.e<? super Boolean> eVar) {
        kotlin.jvm.internal.d0.e(3);
        throw null;
    }

    @NotNull
    public static final <T> e3<T> a(@NotNull ThreadLocal<T> threadLocal, T t5) {
        return new kotlinx.coroutines.internal.z0(t5, threadLocal);
    }

    public static /* synthetic */ e3 b(ThreadLocal threadLocal, Object obj, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            obj = threadLocal.get();
        }
        return a(threadLocal, obj);
    }

    @Nullable
    public static final Object c(@NotNull ThreadLocal<?> threadLocal, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        if (eVar.getContext().get(new kotlinx.coroutines.internal.a1(threadLocal)) != null) {
            return kotlin.n1.f44123a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + eVar.getContext()).toString());
    }

    @Nullable
    public static final Object e(@NotNull ThreadLocal<?> threadLocal, @NotNull kotlin.coroutines.e<? super Boolean> eVar) {
        boolean z5;
        if (eVar.getContext().get(new kotlinx.coroutines.internal.a1(threadLocal)) != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        return kotlin.coroutines.jvm.internal.a.a(z5);
    }
}
