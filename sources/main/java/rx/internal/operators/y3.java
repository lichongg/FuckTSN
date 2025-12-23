package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y3<T, U> implements e.b<rx.e<T>, T> {

    /* renamed from: b, reason: collision with root package name */
    static final Object f53864b = new Object();

    /* renamed from: a, reason: collision with root package name */
    final rx.e<U> f53865a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, U> extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        final b<T> f53866a;

        @Override // rx.f
        public void onCompleted() {
            this.f53866a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53866a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u5) {
            this.f53866a.H();
        }

        public a(b<T> bVar) {
            this.f53866a = bVar;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f53867a;

        /* renamed from: b, reason: collision with root package name */
        final Object f53868b = new Object();

        /* renamed from: c, reason: collision with root package name */
        rx.f<T> f53869c;

        /* renamed from: d, reason: collision with root package name */
        rx.e<T> f53870d;

        /* renamed from: e, reason: collision with root package name */
        boolean f53871e;

        /* renamed from: f, reason: collision with root package name */
        List<Object> f53872f;

        void A(T t5) {
            rx.f<T> fVar = this.f53869c;
            if (fVar != null) {
                fVar.onNext(t5);
            }
        }

        void B(Throwable th) {
            rx.f<T> fVar = this.f53869c;
            this.f53869c = null;
            this.f53870d = null;
            if (fVar != null) {
                fVar.onError(th);
            }
            this.f53867a.onError(th);
            unsubscribe();
        }

        void G() {
            rx.f<T> fVar = this.f53869c;
            if (fVar != null) {
                fVar.onCompleted();
            }
            j();
            this.f53867a.onNext(this.f53870d);
        }

        void H() {
            synchronized (this.f53868b) {
                try {
                    if (this.f53871e) {
                        if (this.f53872f == null) {
                            this.f53872f = new ArrayList();
                        }
                        this.f53872f.add(y3.f53864b);
                        return;
                    }
                    List<Object> list = this.f53872f;
                    this.f53872f = null;
                    boolean z5 = true;
                    this.f53871e = true;
                    boolean z6 = true;
                    while (true) {
                        try {
                            s(list);
                            if (z6) {
                                G();
                                z6 = false;
                            }
                            try {
                                synchronized (this.f53868b) {
                                    try {
                                        List<Object> list2 = this.f53872f;
                                        this.f53872f = null;
                                        if (list2 == null) {
                                            this.f53871e = false;
                                            return;
                                        } else {
                                            if (this.f53867a.isUnsubscribed()) {
                                                synchronized (this.f53868b) {
                                                    this.f53871e = false;
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
                                                synchronized (this.f53868b) {
                                                    this.f53871e = false;
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
            rx.f<T> fVar = this.f53869c;
            this.f53869c = null;
            this.f53870d = null;
            if (fVar != null) {
                fVar.onCompleted();
            }
            this.f53867a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f53868b) {
                try {
                    if (this.f53871e) {
                        if (this.f53872f == null) {
                            this.f53872f = new ArrayList();
                        }
                        this.f53872f.add(v.b());
                        return;
                    }
                    List<Object> list = this.f53872f;
                    this.f53872f = null;
                    this.f53871e = true;
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
            synchronized (this.f53868b) {
                try {
                    if (this.f53871e) {
                        this.f53872f = Collections.singletonList(v.c(th));
                        return;
                    }
                    this.f53872f = null;
                    this.f53871e = true;
                    B(th);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            synchronized (this.f53868b) {
                try {
                    if (this.f53871e) {
                        if (this.f53872f == null) {
                            this.f53872f = new ArrayList();
                        }
                        this.f53872f.add(t5);
                        return;
                    }
                    List<Object> list = this.f53872f;
                    this.f53872f = null;
                    boolean z5 = true;
                    this.f53871e = true;
                    boolean z6 = true;
                    while (true) {
                        try {
                            s(list);
                            if (z6) {
                                A(t5);
                                z6 = false;
                            }
                            try {
                                synchronized (this.f53868b) {
                                    try {
                                        List<Object> list2 = this.f53872f;
                                        this.f53872f = null;
                                        if (list2 == null) {
                                            this.f53871e = false;
                                            return;
                                        } else {
                                            if (this.f53867a.isUnsubscribed()) {
                                                synchronized (this.f53868b) {
                                                    this.f53871e = false;
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
                                                synchronized (this.f53868b) {
                                                    this.f53871e = false;
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
                if (obj == y3.f53864b) {
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

        public b(rx.l<? super rx.e<T>> lVar) {
            this.f53867a = new rx.observers.g(lVar);
        }

        void j() {
            rx.subjects.i y7 = rx.subjects.i.y7();
            this.f53869c = y7;
            this.f53870d = y7;
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        b bVar = new b(lVar);
        a aVar = new a(bVar);
        lVar.add(bVar);
        lVar.add(aVar);
        bVar.H();
        this.f53865a.J6(aVar);
        return bVar;
    }

    public y3(rx.e<U> eVar) {
        this.f53865a = eVar;
    }
}
