package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z3<T, U> implements e.b<rx.e<T>, T> {

    /* renamed from: b, reason: collision with root package name */
    static final Object f53928b = new Object();

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.o<? extends rx.e<? extends U>> f53929a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, U> extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        final b<T, U> f53930a;

        /* renamed from: b, reason: collision with root package name */
        boolean f53931b;

        @Override // rx.f
        public void onCompleted() {
            if (this.f53931b) {
                return;
            }
            this.f53931b = true;
            this.f53930a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53930a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u5) {
            if (this.f53931b) {
                return;
            }
            this.f53931b = true;
            this.f53930a.H();
        }

        public a(b<T, U> bVar) {
            this.f53930a = bVar;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T, U> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f53932a;

        /* renamed from: b, reason: collision with root package name */
        final Object f53933b = new Object();

        /* renamed from: c, reason: collision with root package name */
        rx.f<T> f53934c;

        /* renamed from: d, reason: collision with root package name */
        rx.e<T> f53935d;

        /* renamed from: e, reason: collision with root package name */
        boolean f53936e;

        /* renamed from: f, reason: collision with root package name */
        List<Object> f53937f;

        /* renamed from: g, reason: collision with root package name */
        final rx.subscriptions.e f53938g;

        /* renamed from: h, reason: collision with root package name */
        final rx.functions.o<? extends rx.e<? extends U>> f53939h;

        void A(T t5) {
            rx.f<T> fVar = this.f53934c;
            if (fVar != null) {
                fVar.onNext(t5);
            }
        }

        void B(Throwable th) {
            rx.f<T> fVar = this.f53934c;
            this.f53934c = null;
            this.f53935d = null;
            if (fVar != null) {
                fVar.onError(th);
            }
            this.f53932a.onError(th);
            unsubscribe();
        }

        void G() {
            rx.f<T> fVar = this.f53934c;
            if (fVar != null) {
                fVar.onCompleted();
            }
            j();
            this.f53932a.onNext(this.f53935d);
        }

        void H() {
            synchronized (this.f53933b) {
                try {
                    if (this.f53936e) {
                        if (this.f53937f == null) {
                            this.f53937f = new ArrayList();
                        }
                        this.f53937f.add(z3.f53928b);
                        return;
                    }
                    List<Object> list = this.f53937f;
                    this.f53937f = null;
                    boolean z5 = true;
                    this.f53936e = true;
                    boolean z6 = true;
                    while (true) {
                        try {
                            s(list);
                            if (z6) {
                                G();
                                z6 = false;
                            }
                            try {
                                synchronized (this.f53933b) {
                                    try {
                                        List<Object> list2 = this.f53937f;
                                        this.f53937f = null;
                                        if (list2 == null) {
                                            this.f53936e = false;
                                            return;
                                        } else {
                                            if (this.f53932a.isUnsubscribed()) {
                                                synchronized (this.f53933b) {
                                                    this.f53936e = false;
                                                }
                                                return;
                                            }
                                            list = list2;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        z5 = false;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (!z5) {
                                                synchronized (this.f53933b) {
                                                    this.f53936e = false;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z5 = false;
                        }
                    }
                } finally {
                }
            }
        }

        void g() {
            rx.f<T> fVar = this.f53934c;
            this.f53934c = null;
            this.f53935d = null;
            if (fVar != null) {
                fVar.onCompleted();
            }
            this.f53932a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f53933b) {
                try {
                    if (this.f53936e) {
                        if (this.f53937f == null) {
                            this.f53937f = new ArrayList();
                        }
                        this.f53937f.add(v.b());
                        return;
                    }
                    List<Object> list = this.f53937f;
                    this.f53937f = null;
                    this.f53936e = true;
                    try {
                        s(list);
                        g();
                    } catch (Throwable th) {
                        B(th);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this.f53933b) {
                try {
                    if (this.f53936e) {
                        this.f53937f = Collections.singletonList(v.c(th));
                        return;
                    }
                    this.f53937f = null;
                    this.f53936e = true;
                    B(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            synchronized (this.f53933b) {
                try {
                    if (this.f53936e) {
                        if (this.f53937f == null) {
                            this.f53937f = new ArrayList();
                        }
                        this.f53937f.add(t5);
                        return;
                    }
                    List<Object> list = this.f53937f;
                    this.f53937f = null;
                    boolean z5 = true;
                    this.f53936e = true;
                    boolean z6 = true;
                    while (true) {
                        try {
                            s(list);
                            if (z6) {
                                A(t5);
                                z6 = false;
                            }
                            try {
                                synchronized (this.f53933b) {
                                    try {
                                        List<Object> list2 = this.f53937f;
                                        this.f53937f = null;
                                        if (list2 == null) {
                                            this.f53936e = false;
                                            return;
                                        } else {
                                            if (this.f53932a.isUnsubscribed()) {
                                                synchronized (this.f53933b) {
                                                    this.f53936e = false;
                                                }
                                                return;
                                            }
                                            list = list2;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        z5 = false;
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (!z5) {
                                                synchronized (this.f53933b) {
                                                    this.f53936e = false;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z5 = false;
                        }
                    }
                } finally {
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void s(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == z3.f53928b) {
                    G();
                } else if (v.g(obj)) {
                    B(v.d(obj));
                    return;
                } else {
                    if (v.f(obj)) {
                        g();
                        return;
                    }
                    A(obj);
                }
            }
        }

        public b(rx.l<? super rx.e<T>> lVar, rx.functions.o<? extends rx.e<? extends U>> oVar) {
            this.f53932a = new rx.observers.g(lVar);
            rx.subscriptions.e eVar = new rx.subscriptions.e();
            this.f53938g = eVar;
            this.f53939h = oVar;
            add(eVar);
        }

        void j() {
            rx.subjects.i y7 = rx.subjects.i.y7();
            this.f53934c = y7;
            this.f53935d = y7;
            try {
                rx.e<? extends U> call = this.f53939h.call();
                a aVar = new a(this);
                this.f53938g.b(aVar);
                call.J6(aVar);
            } catch (Throwable th) {
                this.f53932a.onError(th);
                unsubscribe();
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        b bVar = new b(lVar, this.f53929a);
        lVar.add(bVar);
        bVar.H();
        return bVar;
    }

    public z3(rx.functions.o<? extends rx.e<? extends U>> oVar) {
        this.f53929a = oVar;
    }
}
