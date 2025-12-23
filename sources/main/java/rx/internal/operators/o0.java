package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o0<T1, T2, D1, D2, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T1> f53242a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<T2> f53243b;

    /* renamed from: c, reason: collision with root package name */
    final rx.functions.p<? super T1, ? extends rx.e<D1>> f53244c;

    /* renamed from: d, reason: collision with root package name */
    final rx.functions.p<? super T2, ? extends rx.e<D2>> f53245d;

    /* renamed from: e, reason: collision with root package name */
    final rx.functions.q<? super T1, ? super rx.e<T2>, ? extends R> f53246e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends HashMap<Integer, rx.f<T2>> implements rx.m {
        private static final long serialVersionUID = -3035156013812425335L;

        /* renamed from: a, reason: collision with root package name */
        final rx.subscriptions.d f53247a;

        /* renamed from: b, reason: collision with root package name */
        final rx.l<? super R> f53248b;

        /* renamed from: c, reason: collision with root package name */
        final rx.subscriptions.b f53249c;

        /* renamed from: d, reason: collision with root package name */
        int f53250d;

        /* renamed from: e, reason: collision with root package name */
        int f53251e;

        /* renamed from: f, reason: collision with root package name */
        final Map<Integer, T2> f53252f = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        boolean f53253g;

        /* renamed from: h, reason: collision with root package name */
        boolean f53254h;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.o0$a$a, reason: collision with other inner class name */
        final class C1043a extends rx.l<D1> {

            /* renamed from: a, reason: collision with root package name */
            final int f53256a;

            /* renamed from: b, reason: collision with root package name */
            boolean f53257b = true;

            public C1043a(int i6) {
                this.f53256a = i6;
            }

            @Override // rx.f
            public void onCompleted() {
                rx.f<T2> remove;
                if (this.f53257b) {
                    this.f53257b = false;
                    synchronized (a.this) {
                        remove = a.this.g().remove(Integer.valueOf(this.f53256a));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    a.this.f53249c.f(this);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.e(th);
            }

            @Override // rx.f
            public void onNext(D1 d12) {
                onCompleted();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class b extends rx.l<T1> {
            b() {
            }

            @Override // rx.f
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this) {
                    try {
                        a aVar = a.this;
                        aVar.f53253g = true;
                        if (aVar.f53254h) {
                            arrayList = new ArrayList(a.this.g().values());
                            a.this.g().clear();
                            a.this.f53252f.clear();
                        } else {
                            arrayList = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // rx.f
            public void onNext(T1 t12) {
                int i6;
                ArrayList arrayList;
                try {
                    rx.subjects.c y7 = rx.subjects.c.y7();
                    rx.observers.f fVar = new rx.observers.f(y7);
                    synchronized (a.this) {
                        a aVar = a.this;
                        i6 = aVar.f53250d;
                        aVar.f53250d = i6 + 1;
                        aVar.g().put(Integer.valueOf(i6), fVar);
                    }
                    rx.e I6 = rx.e.I6(new b(y7, a.this.f53247a));
                    rx.e<D1> call = o0.this.f53244c.call(t12);
                    C1043a c1043a = a.this.new C1043a(i6);
                    a.this.f53249c.a(c1043a);
                    call.J6(c1043a);
                    R call2 = o0.this.f53246e.call(t12, I6);
                    synchronized (a.this) {
                        arrayList = new ArrayList(a.this.f53252f.values());
                    }
                    a.this.f53248b.onNext(call2);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        fVar.onNext(it.next());
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class c extends rx.l<D2> {

            /* renamed from: a, reason: collision with root package name */
            final int f53260a;

            /* renamed from: b, reason: collision with root package name */
            boolean f53261b = true;

            public c(int i6) {
                this.f53260a = i6;
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f53261b) {
                    this.f53261b = false;
                    synchronized (a.this) {
                        a.this.f53252f.remove(Integer.valueOf(this.f53260a));
                    }
                    a.this.f53249c.f(this);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.e(th);
            }

            @Override // rx.f
            public void onNext(D2 d22) {
                onCompleted();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class d extends rx.l<T2> {
            d() {
            }

            @Override // rx.f
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this) {
                    try {
                        a aVar = a.this;
                        aVar.f53254h = true;
                        if (aVar.f53253g) {
                            arrayList = new ArrayList(a.this.g().values());
                            a.this.g().clear();
                            a.this.f53252f.clear();
                        } else {
                            arrayList = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // rx.f
            public void onNext(T2 t22) {
                int i6;
                ArrayList arrayList;
                try {
                    synchronized (a.this) {
                        a aVar = a.this;
                        i6 = aVar.f53251e;
                        aVar.f53251e = i6 + 1;
                        aVar.f53252f.put(Integer.valueOf(i6), t22);
                    }
                    rx.e<D2> call = o0.this.f53245d.call(t22);
                    c cVar = a.this.new c(i6);
                    a.this.f53249c.a(cVar);
                    call.J6(cVar);
                    synchronized (a.this) {
                        arrayList = new ArrayList(a.this.g().values());
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((rx.f) it.next()).onNext(t22);
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        void b(Throwable th) {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(g().values());
                g().clear();
                this.f53252f.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((rx.f) it.next()).onError(th);
            }
            this.f53248b.onError(th);
            this.f53247a.unsubscribe();
        }

        void e(Throwable th) {
            synchronized (this) {
                g().clear();
                this.f53252f.clear();
            }
            this.f53248b.onError(th);
            this.f53247a.unsubscribe();
        }

        public a(rx.l<? super R> lVar) {
            this.f53248b = lVar;
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f53249c = bVar;
            this.f53247a = new rx.subscriptions.d(bVar);
        }

        void a(List<rx.f<T2>> list) {
            if (list != null) {
                Iterator<rx.f<T2>> it = list.iterator();
                while (it.hasNext()) {
                    it.next().onCompleted();
                }
                this.f53248b.onCompleted();
                this.f53247a.unsubscribe();
            }
        }

        public void f() {
            b bVar = new b();
            d dVar = new d();
            this.f53249c.a(bVar);
            this.f53249c.a(dVar);
            o0.this.f53242a.J6(bVar);
            o0.this.f53243b.J6(dVar);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53247a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f53247a.unsubscribe();
        }

        Map<Integer, rx.f<T2>> g() {
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.subscriptions.d f53264a;

        /* renamed from: b, reason: collision with root package name */
        final rx.e<T> f53265b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        final class a extends rx.l<T> {

            /* renamed from: a, reason: collision with root package name */
            final rx.l<? super T> f53266a;

            /* renamed from: b, reason: collision with root package name */
            private final rx.m f53267b;

            public a(rx.l<? super T> lVar, rx.m mVar) {
                super(lVar);
                this.f53266a = lVar;
                this.f53267b = mVar;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f53266a.onCompleted();
                this.f53267b.unsubscribe();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f53266a.onError(th);
                this.f53267b.unsubscribe();
            }

            @Override // rx.f
            public void onNext(T t5) {
                this.f53266a.onNext(t5);
            }
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            rx.m a6 = this.f53264a.a();
            a aVar = new a(lVar, a6);
            aVar.add(a6);
            this.f53265b.J6(aVar);
        }

        public b(rx.e<T> eVar, rx.subscriptions.d dVar) {
            this.f53264a = dVar;
            this.f53265b = eVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        a aVar = new a(new rx.observers.g(lVar));
        lVar.add(aVar);
        aVar.f();
    }

    public o0(rx.e<T1> eVar, rx.e<T2> eVar2, rx.functions.p<? super T1, ? extends rx.e<D1>> pVar, rx.functions.p<? super T2, ? extends rx.e<D2>> pVar2, rx.functions.q<? super T1, ? super rx.e<T2>, ? extends R> qVar) {
        this.f53242a = eVar;
        this.f53243b = eVar2;
        this.f53244c = pVar;
        this.f53245d = pVar2;
        this.f53246e = qVar;
    }
}
