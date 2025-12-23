package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BlockingCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class g<T> extends a<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Thread f49203d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final n1 f49204e;

    public g(@NotNull kotlin.coroutines.i iVar, @NotNull Thread thread, @Nullable n1 n1Var) {
        super(iVar, true, true);
        this.f49203d = thread;
        this.f49204e = n1Var;
    }

    @Override // kotlinx.coroutines.l2
    protected boolean N0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T A1() {
        long j6;
        kotlin.n1 n1Var;
        b b6 = c.b();
        if (b6 != null) {
            b6.d();
        }
        try {
            n1 n1Var2 = this.f49204e;
            d0 d0Var = null;
            if (n1Var2 != null) {
                n1.B(n1Var2, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    n1 n1Var3 = this.f49204e;
                    if (n1Var3 != null) {
                        j6 = n1Var3.J();
                    } else {
                        j6 = Long.MAX_VALUE;
                    }
                    if (!isCompleted()) {
                        b b7 = c.b();
                        if (b7 != null) {
                            b7.c(this, j6);
                            n1Var = kotlin.n1.f44123a;
                        } else {
                            n1Var = null;
                        }
                        if (n1Var == null) {
                            LockSupport.parkNanos(this, j6);
                        }
                    } else {
                        n1 n1Var4 = this.f49204e;
                        if (n1Var4 != null) {
                            n1.u(n1Var4, false, 1, null);
                        }
                        T t5 = (T) m2.h(H0());
                        if (t5 instanceof d0) {
                            d0Var = (d0) t5;
                        }
                        if (d0Var == null) {
                            return t5;
                        }
                        throw d0Var.f48476a;
                    }
                } catch (Throwable th) {
                    n1 n1Var5 = this.f49204e;
                    if (n1Var5 != null) {
                        n1.u(n1Var5, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            h0(interruptedException);
            throw interruptedException;
        } finally {
            b b8 = c.b();
            if (b8 != null) {
                b8.h();
            }
        }
    }

    @Override // kotlinx.coroutines.l2
    protected void e0(@Nullable Object obj) {
        kotlin.n1 n1Var;
        if (!kotlin.jvm.internal.g0.g(Thread.currentThread(), this.f49203d)) {
            Thread thread = this.f49203d;
            b b6 = c.b();
            if (b6 != null) {
                b6.g(thread);
                n1Var = kotlin.n1.f44123a;
            } else {
                n1Var = null;
            }
            if (n1Var == null) {
                LockSupport.unpark(thread);
            }
        }
    }
}
