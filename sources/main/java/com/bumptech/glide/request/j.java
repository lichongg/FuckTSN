package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.request.target.o;
import com.bumptech.glide.request.target.p;
import com.bumptech.glide.util.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j<R> implements e, o, i {
    private static final String E = "Glide";

    @GuardedBy("requestLock")
    private int A;

    @GuardedBy("requestLock")
    private boolean B;

    @Nullable
    private RuntimeException C;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f16175a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f16176b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f16177c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final g<R> f16178d;

    /* renamed from: e, reason: collision with root package name */
    private final RequestCoordinator f16179e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f16180f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.d f16181g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private final Object f16182h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<R> f16183i;

    /* renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.request.a<?> f16184j;

    /* renamed from: k, reason: collision with root package name */
    private final int f16185k;

    /* renamed from: l, reason: collision with root package name */
    private final int f16186l;

    /* renamed from: m, reason: collision with root package name */
    private final Priority f16187m;

    /* renamed from: n, reason: collision with root package name */
    private final p<R> f16188n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private final List<g<R>> f16189o;

    /* renamed from: p, reason: collision with root package name */
    private final com.bumptech.glide.request.transition.g<? super R> f16190p;

    /* renamed from: q, reason: collision with root package name */
    private final Executor f16191q;

    /* renamed from: r, reason: collision with root package name */
    @GuardedBy("requestLock")
    private u<R> f16192r;

    /* renamed from: s, reason: collision with root package name */
    @GuardedBy("requestLock")
    private k.d f16193s;

    /* renamed from: t, reason: collision with root package name */
    @GuardedBy("requestLock")
    private long f16194t;

    /* renamed from: u, reason: collision with root package name */
    private volatile com.bumptech.glide.load.engine.k f16195u;

    /* renamed from: v, reason: collision with root package name */
    @GuardedBy("requestLock")
    private a f16196v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f16197w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f16198x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f16199y;

    /* renamed from: z, reason: collision with root package name */
    @GuardedBy("requestLock")
    private int f16200z;
    private static final String D = "Request";
    private static final boolean F = Log.isLoggable(D, 2);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private j(Context context, com.bumptech.glide.d dVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, com.bumptech.glide.request.a<?> aVar, int i6, int i7, Priority priority, p<R> pVar, @Nullable g<R> gVar, @Nullable List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.k kVar, com.bumptech.glide.request.transition.g<? super R> gVar2, Executor executor) {
        this.f16175a = F ? String.valueOf(super.hashCode()) : null;
        this.f16176b = com.bumptech.glide.util.pool.c.a();
        this.f16177c = obj;
        this.f16180f = context;
        this.f16181g = dVar;
        this.f16182h = obj2;
        this.f16183i = cls;
        this.f16184j = aVar;
        this.f16185k = i6;
        this.f16186l = i7;
        this.f16187m = priority;
        this.f16188n = pVar;
        this.f16178d = gVar;
        this.f16189o = list;
        this.f16179e = requestCoordinator;
        this.f16195u = kVar;
        this.f16190p = gVar2;
        this.f16191q = executor;
        this.f16196v = a.PENDING;
        if (this.C == null && dVar.g().b(c.d.class)) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> j<R> w(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class<R> cls, com.bumptech.glide.request.a<?> aVar, int i6, int i7, Priority priority, p<R> pVar, g<R> gVar, @Nullable List<g<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.k kVar, com.bumptech.glide.request.transition.g<? super R> gVar2, Executor executor) {
        return new j<>(context, dVar, obj, obj2, cls, aVar, i6, i7, priority, pVar, gVar, list, requestCoordinator, kVar, gVar2, executor);
    }

    @Override // com.bumptech.glide.request.i
    public void b(GlideException glideException) {
        x(glideException, 5);
    }

    @GuardedBy("requestLock")
    private void i() {
        if (this.B) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean j() {
        RequestCoordinator requestCoordinator = this.f16179e;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.f16179e;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.f16179e;
        return requestCoordinator == null || requestCoordinator.d(this);
    }

    @GuardedBy("requestLock")
    private Drawable n() {
        if (this.f16197w == null) {
            Drawable I = this.f16184j.I();
            this.f16197w = I;
            if (I == null && this.f16184j.H() > 0) {
                this.f16197w = r(this.f16184j.H());
            }
        }
        return this.f16197w;
    }

    @GuardedBy("requestLock")
    private Drawable o() {
        if (this.f16199y == null) {
            Drawable J = this.f16184j.J();
            this.f16199y = J;
            if (J == null && this.f16184j.K() > 0) {
                this.f16199y = r(this.f16184j.K());
            }
        }
        return this.f16199y;
    }

    @GuardedBy("requestLock")
    private Drawable p() {
        if (this.f16198x == null) {
            Drawable P = this.f16184j.P();
            this.f16198x = P;
            if (P == null && this.f16184j.Q() > 0) {
                this.f16198x = r(this.f16184j.Q());
            }
        }
        return this.f16198x;
    }

    @GuardedBy("requestLock")
    private boolean q() {
        RequestCoordinator requestCoordinator = this.f16179e;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    @GuardedBy("requestLock")
    private Drawable r(@DrawableRes int i6) {
        return com.bumptech.glide.load.resource.drawable.a.a(this.f16181g, i6, this.f16184j.V() != null ? this.f16184j.V() : this.f16180f.getTheme());
    }

    private static int t(int i6, float f6) {
        return i6 == Integer.MIN_VALUE ? i6 : Math.round(f6 * i6);
    }

    @GuardedBy("requestLock")
    private void u() {
        RequestCoordinator requestCoordinator = this.f16179e;
        if (requestCoordinator != null) {
            requestCoordinator.g(this);
        }
    }

    @GuardedBy("requestLock")
    private void v() {
        RequestCoordinator requestCoordinator = this.f16179e;
        if (requestCoordinator != null) {
            requestCoordinator.b(this);
        }
    }

    private void x(GlideException glideException, int i6) {
        boolean z5;
        this.f16176b.c();
        synchronized (this.f16177c) {
            try {
                glideException.setOrigin(this.C);
                int h6 = this.f16181g.h();
                if (h6 <= i6) {
                    Objects.toString(this.f16182h);
                    if (h6 <= 4) {
                        glideException.logRootCauses(E);
                    }
                }
                this.f16193s = null;
                this.f16196v = a.FAILED;
                boolean z6 = true;
                this.B = true;
                try {
                    List<g<R>> list = this.f16189o;
                    if (list != null) {
                        Iterator<g<R>> it = list.iterator();
                        z5 = false;
                        while (it.hasNext()) {
                            z5 |= it.next().a(glideException, this.f16182h, this.f16188n, q());
                        }
                    } else {
                        z5 = false;
                    }
                    g<R> gVar = this.f16178d;
                    if (gVar == null || !gVar.a(glideException, this.f16182h, this.f16188n, q())) {
                        z6 = false;
                    }
                    if (!(z5 | z6)) {
                        z();
                    }
                    this.B = false;
                    u();
                } catch (Throwable th) {
                    this.B = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean a() {
        boolean z5;
        synchronized (this.f16177c) {
            z5 = this.f16196v == a.COMPLETE;
        }
        return z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.i
    public void c(u<?> uVar, DataSource dataSource, boolean z5) {
        this.f16176b.c();
        u<?> uVar2 = null;
        try {
            synchronized (this.f16177c) {
                try {
                    this.f16193s = null;
                    if (uVar == null) {
                        b(new GlideException("Expected to receive a Resource<R> with an object of " + this.f16183i + " inside, but instead got null."));
                        return;
                    }
                    Object obj = uVar.get();
                    try {
                        if (obj != null && this.f16183i.isAssignableFrom(obj.getClass())) {
                            if (l()) {
                                y(uVar, obj, dataSource, z5);
                                return;
                            }
                            this.f16192r = null;
                            this.f16196v = a.COMPLETE;
                            this.f16195u.l(uVar);
                        }
                        this.f16192r = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.f16183i);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(uVar);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        b(new GlideException(sb.toString()));
                        this.f16195u.l(uVar);
                    } catch (Throwable th) {
                        uVar2 = uVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (uVar2 != null) {
                this.f16195u.l(uVar2);
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.f16177c) {
            try {
                i();
                this.f16176b.c();
                a aVar = this.f16196v;
                a aVar2 = a.CLEARED;
                if (aVar == aVar2) {
                    return;
                }
                m();
                u<R> uVar = this.f16192r;
                if (uVar != null) {
                    this.f16192r = null;
                } else {
                    uVar = null;
                }
                if (j()) {
                    this.f16188n.g(p());
                }
                this.f16196v = aVar2;
                if (uVar != null) {
                    this.f16195u.l(uVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.target.o
    public void d(int i6, int i7) {
        Priority priority;
        com.bumptech.glide.load.engine.j G;
        Map<Class<?>, com.bumptech.glide.load.i<?>> W;
        boolean j02;
        boolean e02;
        com.bumptech.glide.load.f M;
        boolean c02;
        boolean Y;
        boolean X;
        boolean L;
        Executor executor;
        j<R> jVar = this;
        jVar.f16176b.c();
        Object obj = jVar.f16177c;
        synchronized (obj) {
            try {
                try {
                    boolean z5 = F;
                    if (z5) {
                        jVar.s("Got onSizeReady in " + com.bumptech.glide.util.g.a(jVar.f16194t));
                    }
                    if (jVar.f16196v == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        jVar.f16196v = aVar;
                        float U = jVar.f16184j.U();
                        jVar.f16200z = t(i6, U);
                        jVar.A = t(i7, U);
                        if (z5) {
                            jVar.s("finished setup for calling load in " + com.bumptech.glide.util.g.a(jVar.f16194t));
                        }
                        try {
                            com.bumptech.glide.load.engine.k kVar = jVar.f16195u;
                            com.bumptech.glide.d dVar = jVar.f16181g;
                            try {
                                Object obj2 = jVar.f16182h;
                                com.bumptech.glide.load.c T = jVar.f16184j.T();
                                try {
                                    int i8 = jVar.f16200z;
                                    int i9 = jVar.A;
                                    Class<?> S = jVar.f16184j.S();
                                    Class<R> cls = jVar.f16183i;
                                    try {
                                        priority = jVar.f16187m;
                                        G = jVar.f16184j.G();
                                        W = jVar.f16184j.W();
                                        j02 = jVar.f16184j.j0();
                                        e02 = jVar.f16184j.e0();
                                        M = jVar.f16184j.M();
                                        c02 = jVar.f16184j.c0();
                                        Y = jVar.f16184j.Y();
                                        X = jVar.f16184j.X();
                                        L = jVar.f16184j.L();
                                        executor = jVar.f16191q;
                                        jVar = obj;
                                    } catch (Throwable th) {
                                        th = th;
                                        jVar = obj;
                                    }
                                    try {
                                        jVar.f16193s = kVar.g(dVar, obj2, T, i8, i9, S, cls, priority, G, W, j02, e02, M, c02, Y, X, L, jVar, executor);
                                        if (jVar.f16196v != aVar) {
                                            jVar.f16193s = null;
                                        }
                                        if (z5) {
                                            jVar.s("finished onSizeReady in " + com.bumptech.glide.util.g.a(jVar.f16194t));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    jVar = obj;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                jVar = obj;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            jVar = obj;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    jVar = obj;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean e() {
        boolean z5;
        synchronized (this.f16177c) {
            z5 = this.f16196v == a.CLEARED;
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean f(e eVar) {
        int i6;
        int i7;
        Object obj;
        Class<R> cls;
        com.bumptech.glide.request.a<?> aVar;
        Priority priority;
        int size;
        int i8;
        int i9;
        Object obj2;
        Class<R> cls2;
        com.bumptech.glide.request.a<?> aVar2;
        Priority priority2;
        int size2;
        if (!(eVar instanceof j)) {
            return false;
        }
        synchronized (this.f16177c) {
            try {
                i6 = this.f16185k;
                i7 = this.f16186l;
                obj = this.f16182h;
                cls = this.f16183i;
                aVar = this.f16184j;
                priority = this.f16187m;
                List<g<R>> list = this.f16189o;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        j jVar = (j) eVar;
        synchronized (jVar.f16177c) {
            try {
                i8 = jVar.f16185k;
                i9 = jVar.f16186l;
                obj2 = jVar.f16182h;
                cls2 = jVar.f16183i;
                aVar2 = jVar.f16184j;
                priority2 = jVar.f16187m;
                List<g<R>> list2 = jVar.f16189o;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        return i6 == i8 && i7 == i9 && l.c(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
    }

    @Override // com.bumptech.glide.request.i
    public Object g() {
        this.f16176b.c();
        return this.f16177c;
    }

    @Override // com.bumptech.glide.request.e
    public void h() {
        synchronized (this.f16177c) {
            try {
                i();
                this.f16176b.c();
                this.f16194t = com.bumptech.glide.util.g.b();
                if (this.f16182h == null) {
                    if (l.w(this.f16185k, this.f16186l)) {
                        this.f16200z = this.f16185k;
                        this.A = this.f16186l;
                    }
                    x(new GlideException("Received null model"), o() == null ? 5 : 3);
                    return;
                }
                a aVar = this.f16196v;
                a aVar2 = a.RUNNING;
                if (aVar == aVar2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (aVar == a.COMPLETE) {
                    c(this.f16192r, DataSource.MEMORY_CACHE, false);
                    return;
                }
                a aVar3 = a.WAITING_FOR_SIZE;
                this.f16196v = aVar3;
                if (l.w(this.f16185k, this.f16186l)) {
                    d(this.f16185k, this.f16186l);
                } else {
                    this.f16188n.q(this);
                }
                a aVar4 = this.f16196v;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && k()) {
                    this.f16188n.j(p());
                }
                if (F) {
                    s("finished run method in " + com.bumptech.glide.util.g.a(this.f16194t));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z5;
        synchronized (this.f16177c) {
            z5 = this.f16196v == a.COMPLETE;
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z5;
        synchronized (this.f16177c) {
            try {
                a aVar = this.f16196v;
                z5 = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
            } finally {
            }
        }
        return z5;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.f16177c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("requestLock")
    private void m() {
        i();
        this.f16176b.c();
        this.f16188n.b(this);
        k.d dVar = this.f16193s;
        if (dVar != null) {
            dVar.a();
            this.f16193s = null;
        }
    }

    @GuardedBy("requestLock")
    private void y(u<R> uVar, R r5, DataSource dataSource, boolean z5) {
        boolean z6;
        boolean q5 = q();
        this.f16196v = a.COMPLETE;
        this.f16192r = uVar;
        if (this.f16181g.h() <= 3) {
            r5.getClass();
            Objects.toString(dataSource);
            Objects.toString(this.f16182h);
            com.bumptech.glide.util.g.a(this.f16194t);
        }
        boolean z7 = true;
        this.B = true;
        try {
            List<g<R>> list = this.f16189o;
            if (list != null) {
                Iterator<g<R>> it = list.iterator();
                z6 = false;
                while (it.hasNext()) {
                    R r6 = r5;
                    DataSource dataSource2 = dataSource;
                    z6 |= it.next().c(r6, this.f16182h, this.f16188n, dataSource2, q5);
                    r5 = r6;
                    dataSource = dataSource2;
                }
            } else {
                z6 = false;
            }
            R r7 = r5;
            DataSource dataSource3 = dataSource;
            g<R> gVar = this.f16178d;
            if (gVar == null || !gVar.c(r7, this.f16182h, this.f16188n, dataSource3, q5)) {
                z7 = false;
            }
            if (!(z7 | z6)) {
                this.f16188n.h(r7, this.f16190p.a(dataSource3, q5));
            }
            this.B = false;
            v();
        } catch (Throwable th) {
            this.B = false;
            throw th;
        }
    }

    @GuardedBy("requestLock")
    private void z() {
        Drawable drawable;
        if (!k()) {
            return;
        }
        if (this.f16182h == null) {
            drawable = o();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = n();
        }
        if (drawable == null) {
            drawable = p();
        }
        this.f16188n.o(drawable);
    }

    private void s(String str) {
    }
}
