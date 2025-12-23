package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.util.pool.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {
    private static final String G = "DecodeJob";
    private DataSource A;
    private com.bumptech.glide.load.data.d<?> B;
    private volatile com.bumptech.glide.load.engine.f C;
    private volatile boolean D;
    private volatile boolean E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private final e f15188d;

    /* renamed from: e, reason: collision with root package name */
    private final Pools.Pool<h<?>> f15189e;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.d f15192h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.c f15193i;

    /* renamed from: j, reason: collision with root package name */
    private Priority f15194j;

    /* renamed from: k, reason: collision with root package name */
    private n f15195k;

    /* renamed from: l, reason: collision with root package name */
    private int f15196l;

    /* renamed from: m, reason: collision with root package name */
    private int f15197m;

    /* renamed from: n, reason: collision with root package name */
    private j f15198n;

    /* renamed from: o, reason: collision with root package name */
    private com.bumptech.glide.load.f f15199o;

    /* renamed from: p, reason: collision with root package name */
    private b<R> f15200p;

    /* renamed from: q, reason: collision with root package name */
    private int f15201q;

    /* renamed from: r, reason: collision with root package name */
    private EnumC0158h f15202r;

    /* renamed from: s, reason: collision with root package name */
    private g f15203s;

    /* renamed from: t, reason: collision with root package name */
    private long f15204t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f15205u;

    /* renamed from: v, reason: collision with root package name */
    private Object f15206v;

    /* renamed from: w, reason: collision with root package name */
    private Thread f15207w;

    /* renamed from: x, reason: collision with root package name */
    private com.bumptech.glide.load.c f15208x;

    /* renamed from: y, reason: collision with root package name */
    private com.bumptech.glide.load.c f15209y;

    /* renamed from: z, reason: collision with root package name */
    private Object f15210z;

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.g<R> f15185a = new com.bumptech.glide.load.engine.g<>();

    /* renamed from: b, reason: collision with root package name */
    private final List<Throwable> f15186b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f15187c = com.bumptech.glide.util.pool.c.a();

    /* renamed from: f, reason: collision with root package name */
    private final d<?> f15190f = new d<>();

    /* renamed from: g, reason: collision with root package name */
    private final f f15191g = new f();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface b<R> {
        void b(GlideException glideException);

        void c(u<R> uVar, DataSource dataSource, boolean z5);

        void d(h<?> hVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class c<Z> implements i.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        private final DataSource f15214a;

        c(DataSource dataSource) {
            this.f15214a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        @NonNull
        public u<Z> a(@NonNull u<Z> uVar) {
            return h.this.x(this.f15214a, uVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d<Z> {

        /* renamed from: a, reason: collision with root package name */
        private com.bumptech.glide.load.c f15216a;

        /* renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.h<Z> f15217b;

        /* renamed from: c, reason: collision with root package name */
        private t<Z> f15218c;

        void a() {
            this.f15216a = null;
            this.f15217b = null;
            this.f15218c = null;
        }

        void b(e eVar, com.bumptech.glide.load.f fVar) {
            com.bumptech.glide.util.pool.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f15216a, new com.bumptech.glide.load.engine.e(this.f15217b, this.f15218c, fVar));
            } finally {
                this.f15218c.e();
                com.bumptech.glide.util.pool.b.e();
            }
        }

        boolean c() {
            return this.f15218c != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.h<X> hVar, t<X> tVar) {
            this.f15216a = cVar;
            this.f15217b = hVar;
            this.f15218c = tVar;
        }

        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface e {
        com.bumptech.glide.load.engine.cache.a a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f15219a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f15220b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f15221c;

        synchronized boolean b() {
            this.f15220b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f15221c = true;
            return a(false);
        }

        synchronized boolean d(boolean z5) {
            this.f15219a = true;
            return a(z5);
        }

        synchronized void e() {
            this.f15220b = false;
            this.f15219a = false;
            this.f15221c = false;
        }

        private boolean a(boolean z5) {
            return (this.f15221c || z5 || this.f15220b) && this.f15219a;
        }

        f() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.load.engine.h$h, reason: collision with other inner class name */
    private enum EnumC0158h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    private void q(String str, long j6) {
        r(str, j6, null);
    }

    public void a() {
        this.E = true;
        com.bumptech.glide.load.engine.f fVar = this.C;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15211a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f15212b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f15213c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f15213c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15213c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0158h.values().length];
            f15212b = iArr2;
            try {
                iArr2[EnumC0158h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15212b[EnumC0158h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15212b[EnumC0158h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15212b[EnumC0158h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15212b[EnumC0158h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f15211a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15211a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15211a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private void E() {
        int i6 = a.f15211a[this.f15203s.ordinal()];
        if (i6 == 1) {
            this.f15202r = n(EnumC0158h.INITIALIZE);
            this.C = m();
            C();
        } else if (i6 == 2) {
            C();
        } else {
            if (i6 == 3) {
                l();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f15203s);
        }
    }

    private void F() {
        Throwable th;
        this.f15187c.c();
        if (!this.D) {
            this.D = true;
            return;
        }
        if (this.f15186b.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.f15186b;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private int getPriority() {
        return this.f15194j.ordinal();
    }

    private <Data> u<R> j(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long b6 = com.bumptech.glide.util.g.b();
            u<R> k6 = k(data, dataSource);
            if (Log.isLoggable(G, 2)) {
                q("Decoded result " + k6, b6);
            }
            return k6;
        } finally {
            dVar.b();
        }
    }

    private <Data> u<R> k(Data data, DataSource dataSource) throws GlideException {
        return D(data, dataSource, this.f15185a.h(data.getClass()));
    }

    private void l() {
        u<R> uVar;
        if (Log.isLoggable(G, 2)) {
            r("Retrieved data", this.f15204t, "data: " + this.f15210z + ", cache key: " + this.f15208x + ", fetcher: " + this.B);
        }
        try {
            uVar = j(this.B, this.f15210z, this.A);
        } catch (GlideException e6) {
            e6.setLoggingDetails(this.f15209y, this.A);
            this.f15186b.add(e6);
            uVar = null;
        }
        if (uVar != null) {
            t(uVar, this.A, this.F);
        } else {
            C();
        }
    }

    private com.bumptech.glide.load.engine.f m() {
        int i6 = a.f15212b[this.f15202r.ordinal()];
        if (i6 == 1) {
            return new v(this.f15185a, this);
        }
        if (i6 == 2) {
            return new com.bumptech.glide.load.engine.c(this.f15185a, this);
        }
        if (i6 == 3) {
            return new y(this.f15185a, this);
        }
        if (i6 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f15202r);
    }

    private EnumC0158h n(EnumC0158h enumC0158h) {
        int i6 = a.f15212b[enumC0158h.ordinal()];
        if (i6 == 1) {
            return this.f15198n.a() ? EnumC0158h.DATA_CACHE : n(EnumC0158h.DATA_CACHE);
        }
        if (i6 == 2) {
            return this.f15205u ? EnumC0158h.FINISHED : EnumC0158h.SOURCE;
        }
        if (i6 == 3 || i6 == 4) {
            return EnumC0158h.FINISHED;
        }
        if (i6 == 5) {
            return this.f15198n.b() ? EnumC0158h.RESOURCE_CACHE : n(EnumC0158h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0158h);
    }

    @NonNull
    private com.bumptech.glide.load.f o(DataSource dataSource) {
        com.bumptech.glide.load.f fVar = this.f15199o;
        if (Build.VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z5 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f15185a.w();
        com.bumptech.glide.load.e<Boolean> eVar = com.bumptech.glide.load.resource.bitmap.u.f15664k;
        Boolean bool = (Boolean) fVar.c(eVar);
        if (bool != null && (!bool.booleanValue() || z5)) {
            return fVar;
        }
        com.bumptech.glide.load.f fVar2 = new com.bumptech.glide.load.f();
        fVar2.d(this.f15199o);
        fVar2.e(eVar, Boolean.valueOf(z5));
        return fVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(u<R> uVar, DataSource dataSource, boolean z5) {
        t tVar;
        if (uVar instanceof q) {
            ((q) uVar).initialize();
        }
        if (this.f15190f.c()) {
            uVar = t.c(uVar);
            tVar = uVar;
        } else {
            tVar = 0;
        }
        s(uVar, dataSource, z5);
        this.f15202r = EnumC0158h.ENCODE;
        try {
            if (this.f15190f.c()) {
                this.f15190f.b(this.f15188d, this.f15199o);
            }
            v();
        } finally {
            if (tVar != 0) {
                tVar.e();
            }
        }
    }

    private void v() {
        if (this.f15191g.b()) {
            z();
        }
    }

    private void w() {
        if (this.f15191g.c()) {
            z();
        }
    }

    private void z() {
        this.f15191g.e();
        this.f15190f.a();
        this.f15185a.a();
        this.D = false;
        this.f15192h = null;
        this.f15193i = null;
        this.f15199o = null;
        this.f15194j = null;
        this.f15195k = null;
        this.f15200p = null;
        this.f15202r = null;
        this.C = null;
        this.f15207w = null;
        this.f15208x = null;
        this.f15210z = null;
        this.A = null;
        this.B = null;
        this.f15204t = 0L;
        this.E = false;
        this.f15206v = null;
        this.f15186b.clear();
        this.f15189e.release(this);
    }

    boolean I() {
        EnumC0158h n6 = n(EnumC0158h.INITIALIZE);
        return n6 == EnumC0158h.RESOURCE_CACHE || n6 == EnumC0158h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void c() {
        this.f15203s = g.SWITCH_TO_SOURCE_SERVICE;
        this.f15200p.d(this);
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void d(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f15208x = cVar;
        this.f15210z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.f15209y = cVar2;
        this.F = cVar != this.f15185a.c().get(0);
        if (Thread.currentThread() != this.f15207w) {
            this.f15203s = g.DECODE_DATA;
            this.f15200p.d(this);
        } else {
            com.bumptech.glide.util.pool.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                l();
            } finally {
                com.bumptech.glide.util.pool.b.e();
            }
        }
    }

    @Override // com.bumptech.glide.util.pool.a.f
    @NonNull
    public com.bumptech.glide.util.pool.c h() {
        return this.f15187c;
    }

    h<R> p(com.bumptech.glide.d dVar, Object obj, n nVar, com.bumptech.glide.load.c cVar, int i6, int i7, Class<?> cls, Class<R> cls2, Priority priority, j jVar, Map<Class<?>, com.bumptech.glide.load.i<?>> map, boolean z5, boolean z6, boolean z7, com.bumptech.glide.load.f fVar, b<R> bVar, int i8) {
        this.f15185a.u(dVar, obj, cVar, i6, i7, jVar, cls, cls2, priority, fVar, map, z5, z6, this.f15188d);
        this.f15192h = dVar;
        this.f15193i = cVar;
        this.f15194j = priority;
        this.f15195k = nVar;
        this.f15196l = i6;
        this.f15197m = i7;
        this.f15198n = jVar;
        this.f15205u = z7;
        this.f15199o = fVar;
        this.f15200p = bVar;
        this.f15201q = i8;
        this.f15203s = g.INITIALIZE;
        this.f15206v = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bumptech.glide.util.pool.b.b("DecodeJob#run(model=%s)", this.f15206v);
        com.bumptech.glide.load.data.d<?> dVar = this.B;
        try {
            try {
                try {
                    if (this.E) {
                        u();
                        if (dVar != null) {
                            dVar.b();
                        }
                        com.bumptech.glide.util.pool.b.e();
                        return;
                    }
                    E();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.bumptech.glide.util.pool.b.e();
                } catch (com.bumptech.glide.load.engine.b e6) {
                    throw e6;
                }
            } catch (Throwable th) {
                if (Log.isLoggable(G, 3)) {
                    Objects.toString(this.f15202r);
                }
                if (this.f15202r != EnumC0158h.ENCODE) {
                    this.f15186b.add(th);
                    u();
                }
                if (!this.E) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            com.bumptech.glide.util.pool.b.e();
            throw th2;
        }
    }

    void y(boolean z5) {
        if (this.f15191g.d(z5)) {
            z();
        }
    }

    h(e eVar, Pools.Pool<h<?>> pool) {
        this.f15188d = eVar;
        this.f15189e = pool;
    }

    private void C() {
        this.f15207w = Thread.currentThread();
        this.f15204t = com.bumptech.glide.util.g.b();
        boolean z5 = false;
        while (!this.E && this.C != null && !(z5 = this.C.a())) {
            this.f15202r = n(this.f15202r);
            this.C = m();
            if (this.f15202r == EnumC0158h.SOURCE) {
                c();
                return;
            }
        }
        if ((this.f15202r == EnumC0158h.FINISHED || this.E) && !z5) {
            u();
        }
    }

    private <Data, ResourceType> u<R> D(Data data, DataSource dataSource, s<Data, ResourceType, R> sVar) throws GlideException {
        com.bumptech.glide.load.f o5 = o(dataSource);
        com.bumptech.glide.load.data.e<Data> l6 = this.f15192h.i().l(data);
        try {
            return sVar.b(l6, o5, this.f15196l, this.f15197m, new c(dataSource));
        } finally {
            l6.b();
        }
    }

    private void r(String str, long j6, String str2) {
        com.bumptech.glide.util.g.a(j6);
        Objects.toString(this.f15195k);
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(", ");
            sb.append(str2);
        }
        Thread.currentThread().getName();
    }

    private void s(u<R> uVar, DataSource dataSource, boolean z5) {
        F();
        this.f15200p.c(uVar, dataSource, z5);
    }

    private void u() {
        F();
        this.f15200p.b(new GlideException("Failed to load resource", new ArrayList(this.f15186b)));
        w();
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void b(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.a());
        this.f15186b.add(glideException);
        if (Thread.currentThread() != this.f15207w) {
            this.f15203s = g.SWITCH_TO_SOURCE_SERVICE;
            this.f15200p.d(this);
        } else {
            C();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull h<?> hVar) {
        int priority = getPriority() - hVar.getPriority();
        if (priority == 0) {
            return this.f15201q - hVar.f15201q;
        }
        return priority;
    }

    @NonNull
    <Z> u<Z> x(DataSource dataSource, @NonNull u<Z> uVar) {
        u<Z> uVar2;
        com.bumptech.glide.load.i<Z> iVar;
        EncodeStrategy encodeStrategy;
        com.bumptech.glide.load.c dVar;
        Class<?> cls = uVar.get().getClass();
        com.bumptech.glide.load.h<Z> hVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.i<Z> r5 = this.f15185a.r(cls);
            iVar = r5;
            uVar2 = r5.a(this.f15192h, uVar, this.f15196l, this.f15197m);
        } else {
            uVar2 = uVar;
            iVar = null;
        }
        if (!uVar.equals(uVar2)) {
            uVar.recycle();
        }
        if (this.f15185a.v(uVar2)) {
            hVar = this.f15185a.n(uVar2);
            encodeStrategy = hVar.b(this.f15199o);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.h hVar2 = hVar;
        if (this.f15198n.d(!this.f15185a.x(this.f15208x), dataSource, encodeStrategy)) {
            if (hVar2 != null) {
                int i6 = a.f15213c[encodeStrategy.ordinal()];
                if (i6 != 1) {
                    if (i6 == 2) {
                        dVar = new w(this.f15185a.b(), this.f15208x, this.f15193i, this.f15196l, this.f15197m, iVar, cls, this.f15199o);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    }
                } else {
                    dVar = new com.bumptech.glide.load.engine.d(this.f15208x, this.f15193i);
                }
                t c6 = t.c(uVar2);
                this.f15190f.d(dVar, hVar2, c6);
                return c6;
            }
            throw new Registry.NoResultEncoderAvailableException(uVar2.get().getClass());
        }
        return uVar2;
    }
}
