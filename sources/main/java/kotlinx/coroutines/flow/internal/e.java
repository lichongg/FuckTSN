package kotlinx.coroutines.flow.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.u0;
import kotlinx.coroutines.internal.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,245:1\n95#2,5:246\n*S KotlinDebug\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlowKt\n*L\n226#1:246,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    @NotNull
    public static final <T> d<T> b(@NotNull kotlinx.coroutines.flow.i<? extends T> iVar) {
        d<T> dVar = iVar instanceof d ? (d) iVar : null;
        if (dVar == null) {
            return new h(iVar, null, 0, null, 14, null);
        }
        return dVar;
    }

    public static /* synthetic */ Object d(kotlin.coroutines.i iVar, Object obj, Object obj2, Function2 function2, kotlin.coroutines.e eVar, int i6, Object obj3) {
        if ((i6 & 4) != 0) {
            obj2 = y0.b(iVar);
        }
        return c(iVar, obj, obj2, function2, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.j<T> e(kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.i iVar) {
        return jVar instanceof u ? true : jVar instanceof r ? jVar : new x(jVar, iVar);
    }

    @Nullable
    public static final <T, V> Object c(@NotNull kotlin.coroutines.i iVar, V v5, @NotNull Object obj, @NotNull Function2<? super V, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        Object c6 = y0.c(iVar, obj);
        try {
            Object invoke = ((Function2) u0.q(function2, 2)).invoke(v5, new v(eVar, iVar));
            y0.a(iVar, c6);
            if (invoke == kotlin.coroutines.intrinsics.a.l()) {
                kotlin.coroutines.jvm.internal.e.c(eVar);
            }
            return invoke;
        } catch (Throwable th) {
            y0.a(iVar, c6);
            throw th;
        }
    }
}
