package rx.schedulers;

import androidx.camera.view.p;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.schedulers.j;
import rx.internal.schedulers.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicReference<c> f54469d = new AtomicReference<>();

    /* renamed from: a, reason: collision with root package name */
    private final h f54470a;

    /* renamed from: b, reason: collision with root package name */
    private final h f54471b;

    /* renamed from: c, reason: collision with root package name */
    private final h f54472c;

    synchronized void i() {
        try {
            Object obj = this.f54470a;
            if (obj instanceof j) {
                ((j) obj).shutdown();
            }
            Object obj2 = this.f54471b;
            if (obj2 instanceof j) {
                ((j) obj2).shutdown();
            }
            Object obj3 = this.f54472c;
            if (obj3 instanceof j) {
                ((j) obj3).shutdown();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    synchronized void k() {
        try {
            Object obj = this.f54470a;
            if (obj instanceof j) {
                ((j) obj).start();
            }
            Object obj2 = this.f54471b;
            if (obj2 instanceof j) {
                ((j) obj2).start();
            }
            Object obj3 = this.f54472c;
            if (obj3 instanceof j) {
                ((j) obj3).start();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static h b(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    private static c c() {
        while (true) {
            AtomicReference<c> atomicReference = f54469d;
            c cVar = atomicReference.get();
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            if (p.a(atomicReference, null, cVar2)) {
                return cVar2;
            }
            cVar2.i();
        }
    }

    public static h d() {
        return rx.internal.schedulers.f.f54026a;
    }

    public static void g() {
        c andSet = f54469d.getAndSet(null);
        if (andSet != null) {
            andSet.i();
        }
    }

    public static d l() {
        return new d();
    }

    public static h m() {
        return m.f54074a;
    }

    private c() {
        rx.plugins.g f6 = rx.plugins.f.c().f();
        h g6 = f6.g();
        if (g6 != null) {
            this.f54470a = g6;
        } else {
            this.f54470a = rx.plugins.g.a();
        }
        h i6 = f6.i();
        if (i6 != null) {
            this.f54471b = i6;
        } else {
            this.f54471b = rx.plugins.g.c();
        }
        h j6 = f6.j();
        if (j6 != null) {
            this.f54472c = j6;
        } else {
            this.f54472c = rx.plugins.g.e();
        }
    }

    public static h a() {
        return rx.plugins.c.E(c().f54470a);
    }

    public static h e() {
        return rx.plugins.c.J(c().f54471b);
    }

    public static h f() {
        return rx.plugins.c.K(c().f54472c);
    }

    public static void h() {
        c c6 = c();
        c6.i();
        synchronized (c6) {
            rx.internal.schedulers.d.f54020d.shutdown();
        }
    }

    public static void j() {
        c c6 = c();
        c6.k();
        synchronized (c6) {
            rx.internal.schedulers.d.f54020d.start();
        }
    }
}
