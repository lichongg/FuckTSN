package kotlinx.coroutines.flow.internal;

import kotlin.n1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u<T> implements kotlinx.coroutines.flow.j<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final c0<T> f49034a;

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object T = this.f49034a.T(t5, eVar);
        return T == kotlin.coroutines.intrinsics.a.l() ? T : n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull c0<? super T> c0Var) {
        this.f49034a = c0Var;
    }
}
