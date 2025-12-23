package kotlinx.coroutines.flow;

import java.util.List;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class v<T> implements h0<T>, c<T>, kotlinx.coroutines.flow.internal.p<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final e2 f49170a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ h0<T> f49171b;

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> a() {
        return this.f49171b.a();
    }

    @Override // kotlinx.coroutines.flow.x, kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<?> eVar) {
        return this.f49171b.collect(jVar, eVar);
    }

    @Override // kotlinx.coroutines.flow.h0
    public T getValue() {
        return this.f49171b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull h0<? extends T> h0Var, @Nullable e2 e2Var) {
        this.f49170a = e2Var;
        this.f49171b = h0Var;
    }

    @Override // kotlinx.coroutines.flow.internal.p
    @NotNull
    public i<T> e(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return j0.d(this, iVar, i6, bufferOverflow);
    }
}
