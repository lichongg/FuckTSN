package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h<T> extends g<T, T> {
    public /* synthetic */ h(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.i iVar2, int i6, BufferOverflow bufferOverflow, int i7, kotlin.jvm.internal.v vVar) {
        this(iVar, (i7 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : iVar2, (i7 & 4) != 0 ? -3 : i6, (i7 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected d<T> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return new h(this.f48933d, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    public kotlinx.coroutines.flow.i<T> j() {
        return (kotlinx.coroutines.flow.i<T>) this.f48933d;
    }

    @Override // kotlinx.coroutines.flow.internal.g
    @Nullable
    protected Object r(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object collect = this.f48933d.collect(jVar, eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    public h(@NotNull kotlinx.coroutines.flow.i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2, int i6, @NotNull BufferOverflow bufferOverflow) {
        super(iVar, iVar2, i6, bufferOverflow);
    }
}
