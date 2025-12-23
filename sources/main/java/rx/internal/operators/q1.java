package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q1<T, TClosing> implements e.b<List<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.o<? extends rx.e<? extends TClosing>> f53374a;

    /* renamed from: b, reason: collision with root package name */
    final int f53375b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.o<rx.e<? extends TClosing>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f53376a;

        a(rx.e eVar) {
            this.f53376a = eVar;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.e<? extends TClosing> call() {
            return this.f53376a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<TClosing> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f53378a;

        b(c cVar) {
            this.f53378a = cVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53378a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53378a.onError(th);
        }

        @Override // rx.f
        public void onNext(TClosing tclosing) {
            this.f53378a.g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super List<T>> f53380a;

        /* renamed from: b, reason: collision with root package name */
        List<T> f53381b;

        /* renamed from: c, reason: collision with root package name */
        boolean f53382c;

        void g() {
            synchronized (this) {
                try {
                    if (this.f53382c) {
                        return;
                    }
                    List<T> list = this.f53381b;
                    this.f53381b = new ArrayList(q1.this.f53375b);
                    try {
                        this.f53380a.onNext(list);
                    } catch (Throwable th) {
                        unsubscribe();
                        synchronized (this) {
                            try {
                                if (this.f53382c) {
                                    return;
                                }
                                this.f53382c = true;
                                rx.exceptions.a.f(th, this.f53380a);
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this) {
                    try {
                        if (this.f53382c) {
                            return;
                        }
                        this.f53382c = true;
                        List<T> list = this.f53381b;
                        this.f53381b = null;
                        this.f53380a.onNext(list);
                        this.f53380a.onCompleted();
                        unsubscribe();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f53380a);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    if (this.f53382c) {
                        return;
                    }
                    this.f53382c = true;
                    this.f53381b = null;
                    this.f53380a.onError(th);
                    unsubscribe();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            synchronized (this) {
                try {
                    if (this.f53382c) {
                        return;
                    }
                    this.f53381b.add(t5);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(rx.l<? super List<T>> lVar) {
            this.f53380a = lVar;
            this.f53381b = new ArrayList(q1.this.f53375b);
        }
    }

    public q1(rx.functions.o<? extends rx.e<? extends TClosing>> oVar, int i6) {
        this.f53374a = oVar;
        this.f53375b = i6;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        try {
            rx.e<? extends TClosing> call = this.f53374a.call();
            c cVar = new c(new rx.observers.g(lVar));
            b bVar = new b(cVar);
            lVar.add(bVar);
            lVar.add(cVar);
            call.J6(bVar);
            return cVar;
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
            return rx.observers.h.d();
        }
    }

    public q1(rx.e<? extends TClosing> eVar, int i6) {
        this.f53374a = new a(eVar);
        this.f53375b = i6;
    }
}
