package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static b f48104a;

    @Nullable
    public static final b b() {
        return f48104a;
    }

    public static final void f(@Nullable b bVar) {
        f48104a = bVar;
    }

    @InlineOnly
    private static final long a() {
        b b6 = b();
        if (b6 != null) {
            return b6.a();
        }
        return System.currentTimeMillis();
    }

    @InlineOnly
    private static final long c() {
        b b6 = b();
        if (b6 != null) {
            return b6.b();
        }
        return System.nanoTime();
    }

    @InlineOnly
    private static final void d(Object obj, long j6) {
        kotlin.n1 n1Var;
        b b6 = b();
        if (b6 != null) {
            b6.c(obj, j6);
            n1Var = kotlin.n1.f44123a;
        } else {
            n1Var = null;
        }
        if (n1Var == null) {
            LockSupport.parkNanos(obj, j6);
        }
    }

    @InlineOnly
    private static final void e() {
        b b6 = b();
        if (b6 != null) {
            b6.d();
        }
    }

    @InlineOnly
    private static final void g() {
        b b6 = b();
        if (b6 != null) {
            b6.e();
        }
    }

    @InlineOnly
    private static final void h() {
        b b6 = b();
        if (b6 != null) {
            b6.f();
        }
    }

    @InlineOnly
    private static final void i(Thread thread) {
        kotlin.n1 n1Var;
        b b6 = b();
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

    @InlineOnly
    private static final void j() {
        b b6 = b();
        if (b6 != null) {
            b6.h();
        }
    }

    @InlineOnly
    private static final Runnable k(Runnable runnable) {
        Runnable i6;
        b b6 = b();
        if (b6 != null && (i6 = b6.i(runnable)) != null) {
            return i6;
        }
        return runnable;
    }
}
