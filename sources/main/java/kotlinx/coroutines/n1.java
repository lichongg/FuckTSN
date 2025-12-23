package kotlinx.coroutines;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class n1 extends m0 {

    /* renamed from: a, reason: collision with root package name */
    private long f49396a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f49397b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private kotlin.collections.m<d1<?>> f49398c;

    public boolean O() {
        return false;
    }

    public static /* synthetic */ void B(n1 n1Var, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        n1Var.z(z5);
    }

    public static /* synthetic */ void u(n1 n1Var, boolean z5, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i6 & 1) != 0) {
            z5 = false;
        }
        n1Var.t(z5);
    }

    private final long v(boolean z5) {
        if (z5) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1L;
    }

    public final boolean D() {
        return this.f49396a >= v(true);
    }

    public final boolean I() {
        kotlin.collections.m<d1<?>> mVar = this.f49398c;
        if (mVar != null) {
            return mVar.isEmpty();
        }
        return true;
    }

    public final boolean N() {
        d1<?> v5;
        kotlin.collections.m<d1<?>> mVar = this.f49398c;
        if (mVar == null || (v5 = mVar.v()) == null) {
            return false;
        }
        v5.run();
        return true;
    }

    public final boolean isActive() {
        return this.f49396a > 0;
    }

    public final void t(boolean z5) {
        long v5 = this.f49396a - v(z5);
        this.f49396a = v5;
        if (v5 <= 0 && this.f49397b) {
            shutdown();
        }
    }

    public final void w(@NotNull d1<?> d1Var) {
        kotlin.collections.m<d1<?>> mVar = this.f49398c;
        if (mVar == null) {
            mVar = new kotlin.collections.m<>();
            this.f49398c = mVar;
        }
        mVar.addLast(d1Var);
    }

    protected long x() {
        kotlin.collections.m<d1<?>> mVar = this.f49398c;
        return (mVar == null || mVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void z(boolean z5) {
        this.f49396a += v(z5);
        if (z5) {
            return;
        }
        this.f49397b = true;
    }

    protected boolean C() {
        return I();
    }

    public long J() {
        if (!N()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public final m0 limitedParallelism(int i6) {
        kotlinx.coroutines.internal.t.a(i6);
        return this;
    }

    public void shutdown() {
    }
}
