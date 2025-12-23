package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.PublishedApi;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class d extends t1 {

    /* renamed from: b, reason: collision with root package name */
    private final int f49486b;

    /* renamed from: c, reason: collision with root package name */
    private final int f49487c;

    /* renamed from: d, reason: collision with root package name */
    private final long f49488d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f49489e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private CoroutineScheduler f49490f;

    public /* synthetic */ d(int i6, int i7, long j6, String str, int i8, v vVar) {
        this(i6, i7, j6, (i8 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ m0 v(d dVar, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
        }
        if ((i7 & 1) != 0) {
            i6 = 16;
        }
        return dVar.u(i6);
    }

    private final CoroutineScheduler w() {
        return new CoroutineScheduler(this.f49486b, this.f49487c, this.f49488d, this.f49489e);
    }

    @Override // kotlinx.coroutines.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f49490f.close();
    }

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            runnable2 = runnable;
        } catch (RejectedExecutionException unused) {
            runnable2 = runnable;
        }
        try {
            CoroutineScheduler.n(this.f49490f, runnable2, null, false, 6, null);
        } catch (RejectedExecutionException unused2) {
            v0.f49663g.dispatch(iVar, runnable2);
        }
    }

    @Override // kotlinx.coroutines.m0
    public void dispatchYield(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            runnable2 = runnable;
        } catch (RejectedExecutionException unused) {
            runnable2 = runnable;
        }
        try {
            CoroutineScheduler.n(this.f49490f, runnable2, null, true, 2, null);
        } catch (RejectedExecutionException unused2) {
            v0.f49663g.dispatchYield(iVar, runnable2);
        }
    }

    @Override // kotlinx.coroutines.t1
    @NotNull
    public Executor t() {
        return this.f49490f;
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        return super.toString() + "[scheduler = " + this.f49490f + ']';
    }

    @NotNull
    public final m0 u(int i6) {
        if (i6 > 0) {
            return new f(this, i6, null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i6).toString());
    }

    public final void x(@NotNull Runnable runnable, @NotNull k kVar, boolean z5) {
        try {
            this.f49490f.m(runnable, kVar, z5);
        } catch (RejectedExecutionException unused) {
            v0.f49663g.W(this.f49490f.f(runnable, kVar));
        }
    }

    @NotNull
    public final m0 z(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i6).toString());
        }
        if (i6 <= this.f49486b) {
            return new f(this, i6, null, 0);
        }
        throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f49486b + "), but have " + i6).toString());
    }

    public d(int i6, int i7, long j6, @NotNull String str) {
        this.f49486b = i6;
        this.f49487c = i7;
        this.f49488d = j6;
        this.f49489e = str;
        this.f49490f = w();
    }

    public /* synthetic */ d(int i6, int i7, String str, int i8, v vVar) {
        this((i8 & 1) != 0 ? n.f49509c : i6, (i8 & 2) != 0 ? n.f49510d : i7, (i8 & 4) != 0 ? n.f49507a : str);
    }

    public d(int i6, int i7, @NotNull String str) {
        this(i6, i7, n.f49511e, str);
    }

    public /* synthetic */ d(int i6, int i7, int i8, v vVar) {
        this((i8 & 1) != 0 ? n.f49509c : i6, (i8 & 2) != 0 ? n.f49510d : i7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ d(int i6, int i7) {
        this(i6, i7, n.f49511e, null, 8, null);
    }
}
