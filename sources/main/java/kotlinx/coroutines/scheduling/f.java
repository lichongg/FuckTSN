package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f extends t1 implements k, Executor {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f49491g = AtomicIntegerFieldUpdater.newUpdater(f.class, "inFlightTasks");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final d f49492b;

    /* renamed from: c, reason: collision with root package name */
    private final int f49493c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f49494d;

    /* renamed from: e, reason: collision with root package name */
    private final int f49495e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final ConcurrentLinkedQueue<Runnable> f49496f = new ConcurrentLinkedQueue<>();

    @Volatile
    private volatile int inFlightTasks;

    @Override // kotlinx.coroutines.m0
    public void dispatch(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        u(runnable, false);
    }

    @Override // kotlinx.coroutines.m0
    public void dispatchYield(@NotNull kotlin.coroutines.i iVar, @NotNull Runnable runnable) {
        u(runnable, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        u(runnable, false);
    }

    private final void u(Runnable runnable, boolean z5) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f49491g;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f49493c) {
                this.f49492b.x(runnable, this, z5);
                return;
            }
            this.f49496f.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f49493c) {
                return;
            } else {
                runnable = this.f49496f.poll();
            }
        } while (runnable != null);
    }

    @Override // kotlinx.coroutines.t1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher");
    }

    @Override // kotlinx.coroutines.scheduling.k
    public void o() {
        Runnable poll = this.f49496f.poll();
        if (poll != null) {
            this.f49492b.x(poll, this, true);
            return;
        }
        f49491g.decrementAndGet(this);
        Runnable poll2 = this.f49496f.poll();
        if (poll2 == null) {
            return;
        }
        u(poll2, true);
    }

    @Override // kotlinx.coroutines.scheduling.k
    public int q() {
        return this.f49495e;
    }

    @Override // kotlinx.coroutines.m0
    @NotNull
    public String toString() {
        String str = this.f49494d;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f49492b + ']';
    }

    public f(@NotNull d dVar, int i6, @Nullable String str, int i7) {
        this.f49492b = dVar;
        this.f49493c = i6;
        this.f49494d = str;
        this.f49495e = i7;
    }

    @Override // kotlinx.coroutines.t1
    @NotNull
    public Executor t() {
        return this;
    }
}
