package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i2<T, K, V> implements e.b<rx.observables.d<K, V>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends K> f52934a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends V> f52935b;

    /* renamed from: c, reason: collision with root package name */
    final int f52936c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f52937d;

    /* renamed from: e, reason: collision with root package name */
    final rx.functions.p<rx.functions.b<K>, Map<K, Object>> f52938e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f52939a;

        a(c cVar) {
            this.f52939a = cVar;
        }

        @Override // rx.functions.a
        public void call() {
            this.f52939a.g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final c<?, ?, ?> f52941a;

        @Override // rx.g
        public void request(long j6) {
            this.f52941a.H(j6);
        }

        public b(c<?, ?, ?> cVar) {
            this.f52941a = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c<T, K, V> extends rx.l<T> {

        /* renamed from: r, reason: collision with root package name */
        static final Object f52942r = new Object();

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.observables.d<K, V>> f52943a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends K> f52944b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends V> f52945c;

        /* renamed from: d, reason: collision with root package name */
        final int f52946d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f52947e;

        /* renamed from: f, reason: collision with root package name */
        final Map<Object, d<K, V>> f52948f;

        /* renamed from: g, reason: collision with root package name */
        final Map<Object, d<K, V>> f52949g;

        /* renamed from: h, reason: collision with root package name */
        final Queue<rx.observables.d<K, V>> f52950h = new ConcurrentLinkedQueue();

        /* renamed from: i, reason: collision with root package name */
        final b f52951i;

        /* renamed from: j, reason: collision with root package name */
        final Queue<K> f52952j;

        /* renamed from: k, reason: collision with root package name */
        final rx.internal.producers.a f52953k;

        /* renamed from: l, reason: collision with root package name */
        final AtomicBoolean f52954l;

        /* renamed from: m, reason: collision with root package name */
        final AtomicLong f52955m;

        /* renamed from: n, reason: collision with root package name */
        final AtomicInteger f52956n;

        /* renamed from: o, reason: collision with root package name */
        Throwable f52957o;

        /* renamed from: p, reason: collision with root package name */
        volatile boolean f52958p;

        /* renamed from: q, reason: collision with root package name */
        final AtomicInteger f52959q;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static class a<K> implements rx.functions.b<K> {

            /* renamed from: a, reason: collision with root package name */
            final Queue<K> f52960a;

            @Override // rx.functions.b
            public void call(K k6) {
                this.f52960a.offer(k6);
            }

            a(Queue<K> queue) {
                this.f52960a = queue;
            }
        }

        void B() {
            if (this.f52959q.getAndIncrement() != 0) {
                return;
            }
            Queue<rx.observables.d<K, V>> queue = this.f52950h;
            rx.l<? super rx.observables.d<K, V>> lVar = this.f52943a;
            int i6 = 1;
            while (!s(this.f52958p, queue.isEmpty(), lVar, queue)) {
                long j6 = this.f52955m.get();
                long j7 = 0;
                while (j7 != j6) {
                    boolean z5 = this.f52958p;
                    rx.observables.d<K, V> poll = queue.poll();
                    boolean z6 = poll == null;
                    if (s(z5, z6, lVar, queue)) {
                        return;
                    }
                    if (z6) {
                        break;
                    }
                    lVar.onNext(poll);
                    j7++;
                }
                if (j7 != 0) {
                    if (j6 != Long.MAX_VALUE) {
                        rx.internal.operators.a.i(this.f52955m, j7);
                    }
                    this.f52953k.request(j7);
                }
                i6 = this.f52959q.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }

        public void H(long j6) {
            if (j6 >= 0) {
                rx.internal.operators.a.b(this.f52955m, j6);
                B();
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
        }

        public void g() {
            if (this.f52954l.compareAndSet(false, true) && this.f52956n.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public void j(K k6) {
            if (k6 == null) {
                k6 = (K) f52942r;
            }
            if (this.f52948f.remove(k6) != null && this.f52956n.decrementAndGet() == 0) {
                unsubscribe();
            }
            if (this.f52952j != null) {
                this.f52949g.remove(k6);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52958p) {
                return;
            }
            Iterator<d<K, V>> it = this.f52948f.values().iterator();
            while (it.hasNext()) {
                it.next().A7();
            }
            this.f52948f.clear();
            if (this.f52952j != null) {
                this.f52949g.clear();
                this.f52952j.clear();
            }
            this.f52958p = true;
            this.f52956n.decrementAndGet();
            B();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52958p) {
                rx.plugins.c.I(th);
                return;
            }
            this.f52957o = th;
            this.f52958p = true;
            this.f52956n.decrementAndGet();
            B();
        }

        @Override // rx.f
        public void onNext(T t5) {
            boolean z5;
            if (this.f52958p) {
                return;
            }
            Queue<?> queue = this.f52950h;
            rx.l<? super rx.observables.d<K, V>> lVar = this.f52943a;
            try {
                K call = this.f52944b.call(t5);
                Object obj = call != null ? call : f52942r;
                d<K, V> dVar = this.f52948f.get(obj);
                if (dVar != null) {
                    z5 = false;
                } else {
                    if (this.f52954l.get()) {
                        return;
                    }
                    dVar = d.z7(call, this.f52946d, this, this.f52947e);
                    this.f52948f.put(obj, dVar);
                    if (this.f52952j != null) {
                        this.f52949g.put(obj, dVar);
                    }
                    this.f52956n.getAndIncrement();
                    z5 = true;
                }
                try {
                    dVar.onNext(this.f52945c.call(t5));
                    if (this.f52952j != null) {
                        while (true) {
                            K poll = this.f52952j.poll();
                            if (poll == null) {
                                break;
                            }
                            d<K, V> remove = this.f52949g.remove(poll);
                            if (remove != null) {
                                remove.A7();
                            }
                        }
                    }
                    if (z5) {
                        queue.offer(dVar);
                        B();
                    }
                } catch (Throwable th) {
                    unsubscribe();
                    G(lVar, queue, th);
                }
            } catch (Throwable th2) {
                unsubscribe();
                G(lVar, queue, th2);
            }
        }

        boolean s(boolean z5, boolean z6, rx.l<? super rx.observables.d<K, V>> lVar, Queue<?> queue) {
            if (!z5) {
                return false;
            }
            Throwable th = this.f52957o;
            if (th != null) {
                G(lVar, queue, th);
                return true;
            }
            if (!z6) {
                return false;
            }
            this.f52943a.onCompleted();
            return true;
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52953k.c(gVar);
        }

        public c(rx.l<? super rx.observables.d<K, V>> lVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, int i6, boolean z5, rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar3) {
            this.f52943a = lVar;
            this.f52944b = pVar;
            this.f52945c = pVar2;
            this.f52946d = i6;
            this.f52947e = z5;
            rx.internal.producers.a aVar = new rx.internal.producers.a();
            this.f52953k = aVar;
            aVar.request(i6);
            this.f52951i = new b(this);
            this.f52954l = new AtomicBoolean();
            this.f52955m = new AtomicLong();
            this.f52956n = new AtomicInteger(1);
            this.f52959q = new AtomicInteger();
            if (pVar3 == null) {
                this.f52948f = new ConcurrentHashMap();
                this.f52952j = null;
            } else {
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                this.f52952j = concurrentLinkedQueue;
                this.f52948f = A(pVar3, new a(concurrentLinkedQueue));
            }
            this.f52949g = new ConcurrentHashMap();
        }

        private Map<Object, d<K, V>> A(rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar, rx.functions.b<K> bVar) {
            return pVar.call(bVar);
        }

        void G(rx.l<? super rx.observables.d<K, V>> lVar, Queue<?> queue, Throwable th) {
            queue.clear();
            ArrayList arrayList = new ArrayList(this.f52948f.values());
            this.f52948f.clear();
            if (this.f52952j != null) {
                this.f52949g.clear();
                this.f52952j.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).onError(th);
            }
            lVar.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<K, T> extends rx.observables.d<K, T> {

        /* renamed from: c, reason: collision with root package name */
        final e<T, K> f52961c;

        public static <T, K> d<K, T> z7(K k6, int i6, c<?, K, T> cVar, boolean z5) {
            return new d<>(k6, new e(i6, cVar, k6, z5));
        }

        public void A7() {
            this.f52961c.d();
        }

        public void onError(Throwable th) {
            this.f52961c.e(th);
        }

        public void onNext(T t5) {
            this.f52961c.f(t5);
        }

        protected d(K k6, e<T, K> eVar) {
            super(k6, eVar);
            this.f52961c = eVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T, K> extends AtomicInteger implements rx.g, rx.m, e.a<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: a, reason: collision with root package name */
        final K f52962a;

        /* renamed from: c, reason: collision with root package name */
        final c<?, K, T> f52964c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f52965d;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f52967f;

        /* renamed from: g, reason: collision with root package name */
        Throwable f52968g;

        /* renamed from: b, reason: collision with root package name */
        final Queue<Object> f52963b = new ConcurrentLinkedQueue();

        /* renamed from: h, reason: collision with root package name */
        final AtomicBoolean f52969h = new AtomicBoolean();

        /* renamed from: i, reason: collision with root package name */
        final AtomicReference<rx.l<? super T>> f52970i = new AtomicReference<>();

        /* renamed from: j, reason: collision with root package name */
        final AtomicBoolean f52971j = new AtomicBoolean();

        /* renamed from: e, reason: collision with root package name */
        final AtomicLong f52966e = new AtomicLong();

        public void d() {
            this.f52967f = true;
            b();
        }

        boolean a(boolean z5, boolean z6, rx.l<? super T> lVar, boolean z7) {
            if (this.f52969h.get()) {
                this.f52963b.clear();
                this.f52964c.j(this.f52962a);
                return true;
            }
            if (!z5) {
                return false;
            }
            if (z7) {
                if (!z6) {
                    return false;
                }
                Throwable th = this.f52968g;
                if (th != null) {
                    lVar.onError(th);
                } else {
                    lVar.onCompleted();
                }
                return true;
            }
            Throwable th2 = this.f52968g;
            if (th2 != null) {
                this.f52963b.clear();
                lVar.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            lVar.onCompleted();
            return true;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            if (!this.f52971j.compareAndSet(false, true)) {
                lVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
                return;
            }
            lVar.add(this);
            lVar.setProducer(this);
            this.f52970i.lazySet(lVar);
            b();
        }

        public void e(Throwable th) {
            this.f52968g = th;
            this.f52967f = true;
            b();
        }

        public void f(T t5) {
            if (t5 == null) {
                this.f52968g = new NullPointerException();
                this.f52967f = true;
            } else {
                this.f52963b.offer(v.j(t5));
            }
            b();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f52969h.get();
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j6);
            }
            if (j6 != 0) {
                rx.internal.operators.a.b(this.f52966e, j6);
                b();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f52969h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f52964c.j(this.f52962a);
            }
        }

        public e(int i6, c<?, K, T> cVar, K k6, boolean z5) {
            this.f52964c = cVar;
            this.f52962a = k6;
            this.f52965d = z5;
        }

        void b() {
            boolean z5;
            if (getAndIncrement() == 0) {
                Queue<Object> queue = this.f52963b;
                boolean z6 = this.f52965d;
                rx.l<? super T> lVar = this.f52970i.get();
                int i6 = 1;
                while (true) {
                    if (lVar != null) {
                        if (!a(this.f52967f, queue.isEmpty(), lVar, z6)) {
                            long j6 = this.f52966e.get();
                            long j7 = 0;
                            while (j7 != j6) {
                                boolean z7 = this.f52967f;
                                Object poll = queue.poll();
                                if (poll == null) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (!a(z7, z5, lVar, z6)) {
                                    if (z5) {
                                        break;
                                    }
                                    lVar.onNext((Object) v.e(poll));
                                    j7++;
                                } else {
                                    return;
                                }
                            }
                            if (j7 != 0) {
                                if (j6 != Long.MAX_VALUE) {
                                    rx.internal.operators.a.i(this.f52966e, j7);
                                }
                                this.f52964c.f52953k.request(j7);
                            }
                        } else {
                            return;
                        }
                    }
                    i6 = addAndGet(-i6);
                    if (i6 == 0) {
                        return;
                    }
                    if (lVar == null) {
                        lVar = this.f52970i.get();
                    }
                }
            }
        }
    }

    public i2(rx.functions.p<? super T, ? extends K> pVar) {
        this(pVar, rx.internal.util.n.c(), rx.internal.util.j.f54163d, false, null);
    }

    public i2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
        this(pVar, pVar2, rx.internal.util.j.f54163d, false, null);
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.observables.d<K, V>> lVar) {
        rx.l<? super rx.observables.d<K, V>> lVar2;
        try {
            lVar2 = lVar;
        } catch (Throwable th) {
            th = th;
            lVar2 = lVar;
        }
        try {
            c cVar = new c(lVar2, this.f52934a, this.f52935b, this.f52936c, this.f52937d, this.f52938e);
            lVar2.add(rx.subscriptions.f.a(new a(cVar)));
            lVar2.setProducer(cVar.f52951i);
            return cVar;
        } catch (Throwable th2) {
            th = th2;
            rx.exceptions.a.f(th, lVar2);
            rx.l<? super T> d6 = rx.observers.h.d();
            d6.unsubscribe();
            return d6;
        }
    }

    public i2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar3) {
        this(pVar, pVar2, rx.internal.util.j.f54163d, false, pVar3);
    }

    public i2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, int i6, boolean z5, rx.functions.p<rx.functions.b<K>, Map<K, Object>> pVar3) {
        this.f52934a = pVar;
        this.f52935b = pVar2;
        this.f52936c = i6;
        this.f52937d = z5;
        this.f52938e = pVar3;
    }
}
