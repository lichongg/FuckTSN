package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class y0<T> extends a<T> implements x0<T> {
    public y0(@NotNull kotlin.coroutines.i iVar, boolean z5) {
        super(iVar, true, z5);
    }

    static /* synthetic */ <T> Object A1(y0<T> y0Var, kotlin.coroutines.e<? super T> eVar) {
        Object f02 = y0Var.f0(eVar);
        kotlin.coroutines.intrinsics.a.l();
        return f02;
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public kotlinx.coroutines.selects.g<T> L() {
        kotlinx.coroutines.selects.g<T> gVar = (kotlinx.coroutines.selects.g<T>) B0();
        kotlin.jvm.internal.g0.n(gVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return gVar;
    }

    @Override // kotlinx.coroutines.x0
    public T d() {
        return (T) v0();
    }

    @Override // kotlinx.coroutines.x0
    @Nullable
    public Object f(@NotNull kotlin.coroutines.e<? super T> eVar) {
        return A1(this, eVar);
    }
}
