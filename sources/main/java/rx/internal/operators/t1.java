package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t1<T> implements e.b<List<T>, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f53523a;

    /* renamed from: b, reason: collision with root package name */
    final long f53524b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f53525c;

    /* renamed from: d, reason: collision with root package name */
    final int f53526d;

    /* renamed from: e, reason: collision with root package name */
    final rx.h f53527e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super List<T>> f53528a;

        /* renamed from: b, reason: collision with root package name */
        final h.a f53529b;

        /* renamed from: c, reason: collision with root package name */
        List<T> f53530c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        boolean f53531d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.t1$a$a, reason: collision with other inner class name */
        class C1049a implements rx.functions.a {
            C1049a() {
            }

            @Override // rx.functions.a
            public void call() {
                a.this.g();
            }
        }

        void g() {
            synchronized (this) {
                try {
                    if (this.f53531d) {
                        return;
                    }
                    List<T> list = this.f53530c;
                    this.f53530c = new ArrayList();
                    try {
                        this.f53528a.onNext(list);
                    } catch (Throwable th) {
                        rx.exceptions.a.f(th, this);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    if (this.f53531d) {
                        return;
                    }
                    this.f53531d = true;
                    this.f53530c = null;
                    this.f53528a.onError(th);
                    unsubscribe();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            List<T> list;
            synchronized (this) {
                try {
                    if (this.f53531d) {
                        return;
                    }
                    this.f53530c.add(t5);
                    if (this.f53530c.size() == t1.this.f53526d) {
                        list = this.f53530c;
                        this.f53530c = new ArrayList();
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        this.f53528a.onNext(list);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public a(rx.l<? super List<T>> lVar, h.a aVar) {
            this.f53528a = lVar;
            this.f53529b = aVar;
        }

        void j() {
            h.a aVar = this.f53529b;
            C1049a c1049a = new C1049a();
            t1 t1Var = t1.this;
            long j6 = t1Var.f53523a;
            aVar.f(c1049a, j6, j6, t1Var.f53525c);
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f53529b.unsubscribe();
                synchronized (this) {
                    try {
                        if (this.f53531d) {
                            return;
                        }
                        this.f53531d = true;
                        List<T> list = this.f53530c;
                        this.f53530c = null;
                        this.f53528a.onNext(list);
                        this.f53528a.onCompleted();
                        unsubscribe();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f53528a);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super List<T>> f53534a;

        /* renamed from: b, reason: collision with root package name */
        final h.a f53535b;

        /* renamed from: c, reason: collision with root package name */
        final List<List<T>> f53536c = new LinkedList();

        /* renamed from: d, reason: collision with root package name */
        boolean f53537d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                b.this.s();
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.t1$b$b, reason: collision with other inner class name */
        class C1050b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f53540a;

            C1050b(List list) {
                this.f53540a = list;
            }

            @Override // rx.functions.a
            public void call() {
                b.this.g(this.f53540a);
            }
        }

        void g(List<T> list) {
            boolean z5;
            synchronized (this) {
                try {
                    if (this.f53537d) {
                        return;
                    }
                    Iterator<List<T>> it = this.f53536c.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z5 = false;
                            break;
                        } else if (it.next() == list) {
                            it.remove();
                            z5 = true;
                            break;
                        }
                    }
                    if (z5) {
                        try {
                            this.f53534a.onNext(list);
                        } catch (Throwable th) {
                            rx.exceptions.a.f(th, this);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this) {
                    try {
                        if (this.f53537d) {
                            return;
                        }
                        this.f53537d = true;
                        LinkedList linkedList = new LinkedList(this.f53536c);
                        this.f53536c.clear();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            this.f53534a.onNext((List) it.next());
                        }
                        this.f53534a.onCompleted();
                        unsubscribe();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f53534a);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this) {
                try {
                    if (this.f53537d) {
                        return;
                    }
                    this.f53537d = true;
                    this.f53536c.clear();
                    this.f53534a.onError(th);
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
                    if (this.f53537d) {
                        return;
                    }
                    Iterator<List<T>> it = this.f53536c.iterator();
                    LinkedList linkedList = null;
                    while (it.hasNext()) {
                        List<T> next = it.next();
                        next.add(t5);
                        if (next.size() == t1.this.f53526d) {
                            it.remove();
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            linkedList.add(next);
                        }
                    }
                    if (linkedList != null) {
                        Iterator it2 = linkedList.iterator();
                        while (it2.hasNext()) {
                            this.f53534a.onNext((List) it2.next());
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public b(rx.l<? super List<T>> lVar, h.a aVar) {
            this.f53534a = lVar;
            this.f53535b = aVar;
        }

        void j() {
            h.a aVar = this.f53535b;
            a aVar2 = new a();
            t1 t1Var = t1.this;
            long j6 = t1Var.f53524b;
            aVar.f(aVar2, j6, j6, t1Var.f53525c);
        }

        void s() {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                try {
                    if (this.f53537d) {
                        return;
                    }
                    this.f53536c.add(arrayList);
                    h.a aVar = this.f53535b;
                    C1050b c1050b = new C1050b(arrayList);
                    t1 t1Var = t1.this;
                    aVar.e(c1050b, t1Var.f53523a, t1Var.f53525c);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        h.a a6 = this.f53527e.a();
        rx.observers.g gVar = new rx.observers.g(lVar);
        if (this.f53523a == this.f53524b) {
            a aVar = new a(gVar, a6);
            aVar.add(a6);
            lVar.add(aVar);
            aVar.j();
            return aVar;
        }
        b bVar = new b(gVar, a6);
        bVar.add(a6);
        lVar.add(bVar);
        bVar.s();
        bVar.j();
        return bVar;
    }

    public t1(long j6, long j7, TimeUnit timeUnit, int i6, rx.h hVar) {
        this.f53523a = j6;
        this.f53524b = j7;
        this.f53525c = timeUnit;
        this.f53526d = i6;
        this.f53527e = hVar;
    }
}
