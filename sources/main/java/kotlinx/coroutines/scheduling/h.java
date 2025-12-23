package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h extends t1 {

    /* renamed from: b, reason: collision with root package name */
    private final int f49498b;

    /* renamed from: c, reason: collision with root package name */
    private final int f49499c;

    /* renamed from: d, reason: collision with root package name */
    private final long f49500d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f49501e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private CoroutineScheduler f49502f;

    public h() {
        this(0, 0, 0L, null, 15, null);
    }

    public final synchronized void x(long j6) {
        this.f49502f.A(j6);
    }

    public final synchronized void z() {
        this.f49502f.A(1000L);
        this.f49502f = u();
    }

    public /* synthetic */ h(int i6, int i7, long j6, String str, int i8, v vVar) {
        this((i8 & 1) != 0 ? n.f49509c : i6, (i8 & 2) != 0 ? n.f49510d : i7, (i8 & 4) != 0 ? n.f49511e : j6, (i8 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    private final CoroutineScheduler u() {
        return new CoroutineScheduler(this.f49498b, this.f49499c, this.f49500d, this.f49501e);
    }

    @Override // kotlinx.coroutines.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f49502f.close();
    }

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        CoroutineScheduler.n(this.f49502f, runnable, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.m0
    public void dispatchYield(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        CoroutineScheduler.n(this.f49502f, runnable, null, true, 2, null);
    }

    @Override // kotlinx.coroutines.t1
    @NotNull
    public Executor t() {
        return this.f49502f;
    }

    public final void v(@NotNull Runnable runnable, @NotNull k kVar, boolean z5) {
        this.f49502f.m(runnable, kVar, z5);
    }

    public final void w() {
        z();
    }

    public h(int i6, int i7, long j6, @NotNull String str) {
        this.f49498b = i6;
        this.f49499c = i7;
        this.f49500d = j6;
        this.f49501e = str;
        this.f49502f = u();
    }
}
