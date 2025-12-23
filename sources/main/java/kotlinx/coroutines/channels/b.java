package kotlinx.coroutines.channels;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    public static /* synthetic */ c0 b(r0 r0Var, kotlin.coroutines.i iVar, int i6, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        if ((i7 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i7 & 8) != 0) {
            function1 = null;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        return a(r0Var, iVar, i6, coroutineStart2, function1, function2);
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final <E> c0<E> a(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, n1> function1, @NotNull Function2<? super c<E>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        a aVar;
        kotlin.coroutines.i e6 = l0.e(r0Var, iVar);
        j d6 = m.d(i6, null, null, 6, null);
        if (coroutineStart.isLazy()) {
            aVar = new v(e6, d6, function2);
        } else {
            aVar = new a(e6, d6, true);
        }
        if (function1 != null) {
            ((l2) aVar).k(function1);
        }
        ((kotlinx.coroutines.a) aVar).z1(coroutineStart, aVar, function2);
        return (c0<E>) aVar;
    }
}
