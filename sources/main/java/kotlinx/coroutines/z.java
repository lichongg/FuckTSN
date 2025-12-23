package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class z<T> extends l2 implements y<T> {
    public z(@Nullable e2 e2Var) {
        super(true);
        K0(e2Var);
    }

    @Override // kotlinx.coroutines.l2
    public boolean D0() {
        return true;
    }

    @Override // kotlinx.coroutines.y
    public boolean c(@NotNull Throwable th) {
        return T0(new d0(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.x0
    @NotNull
    public kotlinx.coroutines.selects.g<T> L() {
        kotlinx.coroutines.selects.g<T> gVar = (kotlinx.coroutines.selects.g<T>) B0();
        kotlin.jvm.internal.g0.n(gVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return gVar;
    }

    @Override // kotlinx.coroutines.x0
    public T d() {
        return (T) v0();
    }

    @Override // kotlinx.coroutines.x0
    @Nullable
    public Object f(@NotNull kotlin.coroutines.e<? super T> eVar) {
        Object f02 = f0(eVar);
        kotlin.coroutines.intrinsics.a.l();
        return f02;
    }

    @Override // kotlinx.coroutines.y
    public boolean p(T t5) {
        return T0(t5);
    }
}
