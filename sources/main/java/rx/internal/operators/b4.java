package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b4<T, U, V> implements e.b<rx.e<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends U> f52591a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super U, ? extends rx.e<? extends V>> f52592b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<U> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f52593a;

        a(c cVar) {
            this.f52593a = cVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52593a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52593a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u5) {
            this.f52593a.g(u5);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class c extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.e<T>> f52597a;

        /* renamed from: b, reason: collision with root package name */
        final rx.subscriptions.b f52598b;

        /* renamed from: c, reason: collision with root package name */
        final Object f52599c = new Object();

        /* renamed from: d, reason: collision with root package name */
        final List<b<T>> f52600d = new LinkedList();

        /* renamed from: e, reason: collision with root package name */
        boolean f52601e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<V> {

            /* renamed from: a, reason: collision with root package name */
            boolean f52603a = true;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f52604b;

            a(b bVar) {
                this.f52604b = bVar;
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f52603a) {
                    this.f52603a = false;
                    c.this.s(this.f52604b);
                    c.this.f52598b.f(this);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                c.this.onError(th);
            }

            @Override // rx.f
            public void onNext(V v5) {
                onCompleted();
            }
        }

        public c(rx.l<? super rx.e<T>> lVar, rx.subscriptions.b bVar) {
            this.f52597a = new rx.observers.g(lVar);
            this.f52598b = bVar;
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this.f52599c) {
                    if (!this.f52601e) {
                        this.f52601e = true;
                        ArrayList arrayList = new ArrayList(this.f52600d);
                        this.f52600d.clear();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).f52595a.onCompleted();
                        }
                        this.f52597a.onCompleted();
                    }
                }
                this.f52598b.unsubscribe();
            } catch (Throwable th) {
                this.f52598b.unsubscribe();
                throw th;
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                synchronized (this.f52599c) {
                    if (!this.f52601e) {
                        this.f52601e = true;
                        ArrayList arrayList = new ArrayList(this.f52600d);
                        this.f52600d.clear();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((b) it.next()).f52595a.onError(th);
                        }
                        this.f52597a.onError(th);
                    }
                }
                this.f52598b.unsubscribe();
            } catch (Throwable th2) {
                this.f52598b.unsubscribe();
                throw th2;
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            synchronized (this.f52599c) {
                try {
                    if (this.f52601e) {
                        return;
                    }
                    Iterator it = new ArrayList(this.f52600d).iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f52595a.onNext(t5);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void s(b<T> bVar) {
            boolean z5;
            synchronized (this.f52599c) {
                try {
                    if (this.f52601e) {
                        return;
                    }
                    Iterator<b<T>> it = this.f52600d.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z5 = false;
                            break;
                        } else if (it.next() == bVar) {
                            it.remove();
                            z5 = true;
                            break;
                        }
                    }
                    if (z5) {
                        bVar.f52595a.onCompleted();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void g(U u5) {
            b<T> j6 = j();
            synchronized (this.f52599c) {
                try {
                    if (this.f52601e) {
                        return;
                    }
                    this.f52600d.add(j6);
                    this.f52597a.onNext(j6.f52596b);
                    try {
                        rx.e<? extends V> call = b4.this.f52592b.call(u5);
                        a aVar = new a(j6);
                        this.f52598b.a(aVar);
                        call.J6(aVar);
                    } catch (Throwable th) {
                        onError(th);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        b<T> j() {
            rx.subjects.i y7 = rx.subjects.i.y7();
            return new b<>(y7, y7);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.f<T> f52595a;

        /* renamed from: b, reason: collision with root package name */
        final rx.e<T> f52596b;

        public b(rx.f<T> fVar, rx.e<T> eVar) {
            this.f52595a = new rx.observers.f(fVar);
            this.f52596b = eVar;
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        lVar.add(bVar);
        c cVar = new c(lVar, bVar);
        a aVar = new a(cVar);
        bVar.a(cVar);
        bVar.a(aVar);
        this.f52591a.J6(aVar);
        return cVar;
    }

    public b4(rx.e<? extends U> eVar, rx.functions.p<? super U, ? extends rx.e<? extends V>> pVar) {
        this.f52591a = eVar;
        this.f52592b = pVar;
    }
}
