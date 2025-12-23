package kotlinx.coroutines.flow;

import defpackage.H5BaseWebChromeClient;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,428:1\n1#2:429\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final s0 f49043a = new s0("NONE");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final s0 f49044b = new s0("PENDING");

    @NotNull
    public static final <T> t<T> a(T t5) {
        if (t5 == null) {
            t5 = (T) kotlinx.coroutines.flow.internal.s.f49029a;
        }
        return new i0(t5);
    }

    @NotNull
    public static final <T> i<T> d(@NotNull h0<? extends T> h0Var, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return (((i6 < 0 || i6 >= 2) && i6 != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? z.e(h0Var, iVar, i6, bufferOverflow) : h0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.lang.Object] */
    public static final <T> T e(@NotNull t<T> tVar, @NotNull Function1<? super T, ? extends T> function1) {
        ?? r02;
        do {
            r02 = (Object) tVar.getValue();
        } while (!tVar.compareAndSet(r02, function1.invoke(r02)));
        return r02;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T f(@NotNull t<T> tVar, @NotNull Function1<? super T, ? extends T> function1) {
        H5BaseWebChromeClient h5BaseWebChromeClient;
        T invoke;
        do {
            h5BaseWebChromeClient = (Object) tVar.getValue();
            invoke = function1.invoke(h5BaseWebChromeClient);
        } while (!tVar.compareAndSet(h5BaseWebChromeClient, invoke));
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(@NotNull t<T> tVar, @NotNull Function1<? super T, ? extends T> function1) {
        H5BaseWebChromeClient h5BaseWebChromeClient;
        do {
            h5BaseWebChromeClient = (Object) tVar.getValue();
        } while (!tVar.compareAndSet(h5BaseWebChromeClient, function1.invoke(h5BaseWebChromeClient)));
    }
}
