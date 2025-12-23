package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/ChannelAsFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n1#2:177\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class e<T> extends kotlinx.coroutines.flow.internal.d<T> {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f48860f = AtomicIntegerFieldUpdater.newUpdater(e.class, "consumed");

    @Volatile
    private volatile int consumed;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlinx.coroutines.channels.b0<T> f48861d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f48862e;

    public /* synthetic */ e(kotlinx.coroutines.channels.b0 b0Var, boolean z5, kotlin.coroutines.i iVar, int i6, BufferOverflow bufferOverflow, int i7, kotlin.jvm.internal.v vVar) {
        this(b0Var, z5, (i7 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : iVar, (i7 & 8) != 0 ? -3 : i6, (i7 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    private final void n() {
        if (this.f48862e && f48860f.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once");
        }
    }

    @Override // kotlinx.coroutines.flow.internal.d, kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        if (this.f48909b != -3) {
            Object collect = super.collect(jVar, eVar);
            return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
        }
        n();
        Object e6 = l.e(jVar, this.f48861d, this.f48862e, eVar);
        return e6 == kotlin.coroutines.intrinsics.a.l() ? e6 : n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected String f() {
        return "channel=" + this.f48861d;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @Nullable
    protected Object h(@NotNull kotlinx.coroutines.channels.z<? super T> zVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object e6 = l.e(new kotlinx.coroutines.flow.internal.u(zVar), this.f48861d, this.f48862e, eVar);
        return e6 == kotlin.coroutines.intrinsics.a.l() ? e6 : n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected kotlinx.coroutines.flow.internal.d<T> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return new e(this.f48861d, this.f48862e, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    public i<T> j() {
        return new e(this.f48861d, this.f48862e, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    public kotlinx.coroutines.channels.b0<T> m(@NotNull r0 r0Var) {
        n();
        if (this.f48909b == -3) {
            return this.f48861d;
        }
        return super.m(r0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull kotlinx.coroutines.channels.b0<? extends T> b0Var, boolean z5, @NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        super(iVar, i6, bufferOverflow);
        this.f48861d = b0Var;
        this.f48862e = z5;
        this.consumed = 0;
    }
}
