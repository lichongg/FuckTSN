package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c4<T> implements e.b<rx.e<T>, T> {

    /* renamed from: f, reason: collision with root package name */
    static final Object f52640f = new Object();

    /* renamed from: a, reason: collision with root package name */
    final long f52641a;

    /* renamed from: b, reason: collision with root package name */
    final long f52642b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f52643c;

    /* renamed from: d, reason: collision with root package name */
    final rx.h f52644d;

    /* renamed from: e, reason: collision with root package name */
    final int f52645e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f52649a;

        /* renamed from: b, reason: collision with root package name */
        final h.a f52650b;

        /* renamed from: d, reason: collision with root package name */
        List<Object> f52652d;

        /* renamed from: e, reason: collision with root package name */
        boolean f52653e;

        /* renamed from: c, reason: collision with root package name */
        final Object f52651c = new Object();

        /* renamed from: f, reason: collision with root package name */
        volatile d<T> f52654f = d.c();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c4 f52656a;

            a(c4 c4Var) {
                this.f52656a = c4Var;
            }

            @Override // rx.functions.a
            public void call() {
                if (b.this.f52654f.f52669a == null) {
                    b.this.unsubscribe();
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.c4$b$b, reason: collision with other inner class name */
        class C1030b implements rx.functions.a {
            C1030b() {
            }

            @Override // rx.functions.a
            public void call() {
                b.this.B();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
        
            return true;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean j(java.util.List<java.lang.Object> r5) {
            /*
                r4 = this;
                r0 = 1
                if (r5 != 0) goto L4
                return r0
            L4:
                java.util.Iterator r5 = r5.iterator()
            L8:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L3d
                java.lang.Object r1 = r5.next()
                java.lang.Object r2 = rx.internal.operators.c4.f52640f
                r3 = 0
                if (r1 != r2) goto L1e
                boolean r1 = r4.G()
                if (r1 != 0) goto L8
                return r3
            L1e:
                boolean r2 = rx.internal.operators.v.g(r1)
                if (r2 == 0) goto L2c
                java.lang.Throwable r5 = rx.internal.operators.v.d(r1)
                r4.A(r5)
                goto L3d
            L2c:
                boolean r2 = rx.internal.operators.v.f(r1)
                if (r2 == 0) goto L36
                r4.g()
                goto L3d
            L36:
                boolean r1 = r4.s(r1)
                if (r1 != 0) goto L8
                return r3
            L3d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.c4.b.j(java.util.List):boolean");
        }

        public b(rx.l<? super rx.e<T>> lVar, h.a aVar) {
            this.f52649a = new rx.observers.g(lVar);
            this.f52650b = aVar;
            lVar.add(rx.subscriptions.f.a(new a(c4.this)));
        }

        void A(Throwable th) {
            rx.f<T> fVar = this.f52654f.f52669a;
            this.f52654f = this.f52654f.a();
            if (fVar != null) {
                fVar.onError(th);
            }
            this.f52649a.onError(th);
            unsubscribe();
        }

        void B() {
            boolean z5;
            List<Object> list;
            synchronized (this.f52651c) {
                try {
                    if (this.f52653e) {
                        if (this.f52652d == null) {
                            this.f52652d = new ArrayList();
                        }
                        this.f52652d.add(c4.f52640f);
                        return;
                    }
                    boolean z6 = true;
                    this.f52653e = true;
                    try {
                        if (!G()) {
                            synchronized (this.f52651c) {
                                this.f52653e = false;
                            }
                            return;
                        }
                        do {
                            try {
                                synchronized (this.f52651c) {
                                    try {
                                        list = this.f52652d;
                                        if (list == null) {
                                            this.f52653e = false;
                                            return;
                                        }
                                        this.f52652d = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        z6 = false;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                throw th;
                            } catch (Throwable th3) {
                                z5 = z6;
                                th = th3;
                                if (z5) {
                                    throw th;
                                }
                                synchronized (this.f52651c) {
                                    this.f52653e = false;
                                }
                                throw th;
                            }
                        } while (j(list));
                        synchronized (this.f52651c) {
                            this.f52653e = false;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z5 = false;
                    }
                } finally {
                }
            }
        }

        boolean G() {
            rx.f<T> fVar = this.f52654f.f52669a;
            if (fVar != null) {
                fVar.onCompleted();
            }
            if (this.f52649a.isUnsubscribed()) {
                this.f52654f = this.f52654f.a();
                unsubscribe();
                return false;
            }
            rx.subjects.i y7 = rx.subjects.i.y7();
            this.f52654f = this.f52654f.b(y7, y7);
            this.f52649a.onNext(y7);
            return true;
        }

        void H() {
            h.a aVar = this.f52650b;
            C1030b c1030b = new C1030b();
            c4 c4Var = c4.this;
            aVar.f(c1030b, 0L, c4Var.f52641a, c4Var.f52643c);
        }

        void g() {
            rx.f<T> fVar = this.f52654f.f52669a;
            this.f52654f = this.f52654f.a();
            if (fVar != null) {
                fVar.onCompleted();
            }
            this.f52649a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f52651c) {
                try {
                    if (this.f52653e) {
                        if (this.f52652d == null) {
                            this.f52652d = new ArrayList();
                        }
                        this.f52652d.add(v.b());
                        return;
                    }
                    List<Object> list = this.f52652d;
                    this.f52652d = null;
                    this.f52653e = true;
                    try {
                        j(list);
                        g();
                    } catch (Throwable th) {
                        A(th);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this.f52651c) {
                try {
                    if (this.f52653e) {
                        this.f52652d = Collections.singletonList(v.c(th));
                        return;
                    }
                    this.f52652d = null;
                    this.f52653e = true;
                    A(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            List<Object> list;
            synchronized (this.f52651c) {
                try {
                    if (this.f52653e) {
                        if (this.f52652d == null) {
                            this.f52652d = new ArrayList();
                        }
                        this.f52652d.add(t5);
                        return;
                    }
                    boolean z5 = true;
                    this.f52653e = true;
                    try {
                        if (!s(t5)) {
                            synchronized (this.f52651c) {
                                this.f52653e = false;
                            }
                            return;
                        }
                        do {
                            try {
                                synchronized (this.f52651c) {
                                    try {
                                        list = this.f52652d;
                                        if (list == null) {
                                            this.f52653e = false;
                                            return;
                                        }
                                        this.f52652d = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        z5 = false;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (!z5) {
                                                synchronized (this.f52651c) {
                                                    this.f52653e = false;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } while (j(list));
                        synchronized (this.f52651c) {
                            this.f52653e = false;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z5 = false;
                    }
                } finally {
                }
            }
        }

        boolean s(T t5) {
            d<T> d6;
            d<T> dVar = this.f52654f;
            if (dVar.f52669a == null) {
                if (!G()) {
                    return false;
                }
                dVar = this.f52654f;
            }
            dVar.f52669a.onNext(t5);
            if (dVar.f52671c == c4.this.f52645e - 1) {
                dVar.f52669a.onCompleted();
                d6 = dVar.a();
            } else {
                d6 = dVar.d();
            }
            this.f52654f = d6;
            return true;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f52659a;

        /* renamed from: b, reason: collision with root package name */
        final h.a f52660b;

        /* renamed from: c, reason: collision with root package name */
        final Object f52661c;

        /* renamed from: d, reason: collision with root package name */
        final List<a<T>> f52662d;

        /* renamed from: e, reason: collision with root package name */
        boolean f52663e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                c.this.s();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f52666a;

            b(a aVar) {
                this.f52666a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                c.this.A(this.f52666a);
            }
        }

        public c(rx.l<? super rx.e<T>> lVar, h.a aVar) {
            super(lVar);
            this.f52659a = lVar;
            this.f52660b = aVar;
            this.f52661c = new Object();
            this.f52662d = new LinkedList();
        }

        void A(a<T> aVar) {
            boolean z5;
            synchronized (this.f52661c) {
                try {
                    if (this.f52663e) {
                        return;
                    }
                    Iterator<a<T>> it = this.f52662d.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z5 = false;
                            break;
                        } else if (it.next() == aVar) {
                            it.remove();
                            z5 = true;
                            break;
                        }
                    }
                    if (z5) {
                        aVar.f52646a.onCompleted();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void j() {
            h.a aVar = this.f52660b;
            a aVar2 = new a();
            c4 c4Var = c4.this;
            long j6 = c4Var.f52642b;
            aVar.f(aVar2, j6, j6, c4Var.f52643c);
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f52661c) {
                try {
                    if (this.f52663e) {
                        return;
                    }
                    this.f52663e = true;
                    ArrayList arrayList = new ArrayList(this.f52662d);
                    this.f52662d.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).f52646a.onCompleted();
                    }
                    this.f52659a.onCompleted();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this.f52661c) {
                try {
                    if (this.f52663e) {
                        return;
                    }
                    this.f52663e = true;
                    ArrayList arrayList = new ArrayList(this.f52662d);
                    this.f52662d.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).f52646a.onError(th);
                    }
                    this.f52659a.onError(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            synchronized (this.f52661c) {
                try {
                    if (this.f52663e) {
                        return;
                    }
                    ArrayList<a> arrayList = new ArrayList(this.f52662d);
                    Iterator<a<T>> it = this.f52662d.iterator();
                    while (it.hasNext()) {
                        a<T> next = it.next();
                        int i6 = next.f52648c + 1;
                        next.f52648c = i6;
                        if (i6 == c4.this.f52645e) {
                            it.remove();
                        }
                    }
                    for (a aVar : arrayList) {
                        aVar.f52646a.onNext(t5);
                        if (aVar.f52648c == c4.this.f52645e) {
                            aVar.f52646a.onCompleted();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        a<T> g() {
            rx.subjects.i y7 = rx.subjects.i.y7();
            return new a<>(y7, y7);
        }

        void s() {
            a<T> g6 = g();
            synchronized (this.f52661c) {
                try {
                    if (this.f52663e) {
                        return;
                    }
                    this.f52662d.add(g6);
                    try {
                        this.f52659a.onNext(g6.f52647b);
                        h.a aVar = this.f52660b;
                        b bVar = new b(g6);
                        c4 c4Var = c4.this;
                        aVar.e(bVar, c4Var.f52641a, c4Var.f52643c);
                    } catch (Throwable th) {
                        onError(th);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> {

        /* renamed from: d, reason: collision with root package name */
        static final d<Object> f52668d = new d<>(null, null, 0);

        /* renamed from: a, reason: collision with root package name */
        final rx.f<T> f52669a;

        /* renamed from: b, reason: collision with root package name */
        final rx.e<T> f52670b;

        /* renamed from: c, reason: collision with root package name */
        final int f52671c;

        public static <T> d<T> c() {
            return (d<T>) f52668d;
        }

        public d<T> b(rx.f<T> fVar, rx.e<T> eVar) {
            return new d<>(fVar, eVar, 0);
        }

        public d<T> d() {
            return new d<>(this.f52669a, this.f52670b, this.f52671c + 1);
        }

        public d(rx.f<T> fVar, rx.e<T> eVar, int i6) {
            this.f52669a = fVar;
            this.f52670b = eVar;
            this.f52671c = i6;
        }

        public d<T> a() {
            return c();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.f<T> f52646a;

        /* renamed from: b, reason: collision with root package name */
        final rx.e<T> f52647b;

        /* renamed from: c, reason: collision with root package name */
        int f52648c;

        public a(rx.f<T> fVar, rx.e<T> eVar) {
            this.f52646a = new rx.observers.f(fVar);
            this.f52647b = eVar;
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        h.a a6 = this.f52644d.a();
        if (this.f52641a == this.f52642b) {
            b bVar = new b(lVar, a6);
            bVar.add(a6);
            bVar.H();
            return bVar;
        }
        c cVar = new c(lVar, a6);
        cVar.add(a6);
        cVar.s();
        cVar.j();
        return cVar;
    }

    public c4(long j6, long j7, TimeUnit timeUnit, int i6, rx.h hVar) {
        this.f52641a = j6;
        this.f52642b = j7;
        this.f52643c = timeUnit;
        this.f52645e = i6;
        this.f52644d = hVar;
    }
}
