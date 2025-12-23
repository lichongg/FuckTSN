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
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j2<T, K, V> implements e.b<rx.observables.d<K, V>, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends K> f53009a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends V> f53010b;

    /* renamed from: c, reason: collision with root package name */
    final int f53011c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f53012d;

    /* renamed from: e, reason: collision with root package name */
    final rx.functions.p<rx.functions.b<Object>, Map<K, Object>> f53013e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f53014a;

        a(d dVar) {
            this.f53014a = dVar;
        }

        @Override // rx.functions.a
        public void call() {
            this.f53014a.g();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<K, V> implements rx.functions.b<e<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        final Queue<e<K, V>> f53016a;

        @Override // rx.functions.b
        public void call(e<K, V> eVar) {
            this.f53016a.offer(eVar);
        }

        b(Queue<e<K, V>> queue) {
            this.f53016a = queue;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final d<?, ?, ?> f53017a;

        @Override // rx.g
        public void request(long j6) {
            this.f53017a.G(j6);
        }

        public c(d<?, ?, ?> dVar) {
            this.f53017a = dVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d<T, K, V> extends rx.l<T> {

        /* renamed from: q, reason: collision with root package name */
        static final Object f53018q = new Object();

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super rx.observables.d<K, V>> f53019a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends K> f53020b;

        /* renamed from: c, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends V> f53021c;

        /* renamed from: d, reason: collision with root package name */
        final int f53022d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f53023e;

        /* renamed from: f, reason: collision with root package name */
        final Map<K, e<K, V>> f53024f;

        /* renamed from: g, reason: collision with root package name */
        final Queue<e<K, V>> f53025g = new ConcurrentLinkedQueue();

        /* renamed from: h, reason: collision with root package name */
        final c f53026h;

        /* renamed from: i, reason: collision with root package name */
        final Queue<e<K, V>> f53027i;

        /* renamed from: j, reason: collision with root package name */
        final rx.internal.producers.a f53028j;

        /* renamed from: k, reason: collision with root package name */
        final AtomicBoolean f53029k;

        /* renamed from: l, reason: collision with root package name */
        final AtomicLong f53030l;

        /* renamed from: m, reason: collision with root package name */
        final AtomicInteger f53031m;

        /* renamed from: n, reason: collision with root package name */
        Throwable f53032n;

        /* renamed from: o, reason: collision with root package name */
        volatile boolean f53033o;

        /* renamed from: p, reason: collision with root package name */
        final AtomicInteger f53034p;

        void A() {
            if (this.f53034p.getAndIncrement() != 0) {
                return;
            }
            Queue<e<K, V>> queue = this.f53025g;
            rx.l<? super rx.observables.d<K, V>> lVar = this.f53019a;
            int i6 = 1;
            while (!s(this.f53033o, queue.isEmpty(), lVar, queue)) {
                long j6 = this.f53030l.get();
                boolean z5 = j6 == Long.MAX_VALUE;
                long j7 = 0;
                while (j6 != 0) {
                    boolean z6 = this.f53033o;
                    e<K, V> poll = queue.poll();
                    boolean z7 = poll == null;
                    if (s(z6, z7, lVar, queue)) {
                        return;
                    }
                    if (z7) {
                        break;
                    }
                    lVar.onNext(poll);
                    j6--;
                    j7--;
                }
                if (j7 != 0) {
                    if (!z5) {
                        this.f53030l.addAndGet(j7);
                    }
                    this.f53028j.request(-j7);
                }
                i6 = this.f53034p.addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
            }
        }

        public void G(long j6) {
            if (j6 >= 0) {
                rx.internal.operators.a.b(this.f53030l, j6);
                A();
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
        }

        public void g() {
            if (this.f53029k.compareAndSet(false, true) && this.f53031m.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        public void j(K k6) {
            if (k6 == null) {
                k6 = (K) f53018q;
            }
            if (this.f53024f.remove(k6) == null || this.f53031m.decrementAndGet() != 0) {
                return;
            }
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53033o) {
                return;
            }
            Iterator<e<K, V>> it = this.f53024f.values().iterator();
            while (it.hasNext()) {
                it.next().A7();
            }
            this.f53024f.clear();
            Queue<e<K, V>> queue = this.f53027i;
            if (queue != null) {
                queue.clear();
            }
            this.f53033o = true;
            this.f53031m.decrementAndGet();
            A();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53033o) {
                rx.plugins.c.I(th);
                return;
            }
            this.f53032n = th;
            this.f53033o = true;
            this.f53031m.decrementAndGet();
            A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53033o) {
                return;
            }
            Queue<?> queue = this.f53025g;
            rx.l<? super rx.observables.d<K, V>> lVar = this.f53019a;
            try {
                K call = this.f53020b.call(t5);
                Object obj = call != null ? call : f53018q;
                e eVar = this.f53024f.get(obj);
                if (eVar == null) {
                    if (this.f53029k.get()) {
                        return;
                    }
                    eVar = e.z7(call, this.f53022d, this, this.f53023e);
                    this.f53024f.put(obj, eVar);
                    this.f53031m.getAndIncrement();
                    queue.offer(eVar);
                    A();
                }
                try {
                    eVar.onNext(this.f53021c.call(t5));
                    if (this.f53027i == null) {
                        return;
                    }
                    while (true) {
                        e<K, V> poll = this.f53027i.poll();
                        if (poll == null) {
                            return;
                        } else {
                            poll.A7();
                        }
                    }
                } catch (Throwable th) {
                    unsubscribe();
                    B(lVar, queue, th);
                }
            } catch (Throwable th2) {
                unsubscribe();
                B(lVar, queue, th2);
            }
        }

        boolean s(boolean z5, boolean z6, rx.l<? super rx.observables.d<K, V>> lVar, Queue<?> queue) {
            if (!z5) {
                return false;
            }
            Throwable th = this.f53032n;
            if (th != null) {
                B(lVar, queue, th);
                return true;
            }
            if (!z6) {
                return false;
            }
            this.f53019a.onCompleted();
            return true;
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53028j.c(gVar);
        }

        public d(rx.l<? super rx.observables.d<K, V>> lVar, rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, int i6, boolean z5, Map<K, e<K, V>> map, Queue<e<K, V>> queue) {
            this.f53019a = lVar;
            this.f53020b = pVar;
            this.f53021c = pVar2;
            this.f53022d = i6;
            this.f53023e = z5;
            rx.internal.producers.a aVar = new rx.internal.producers.a();
            this.f53028j = aVar;
            aVar.request(i6);
            this.f53026h = new c(this);
            this.f53029k = new AtomicBoolean();
            this.f53030l = new AtomicLong();
            this.f53031m = new AtomicInteger(1);
            this.f53034p = new AtomicInteger();
            this.f53024f = map;
            this.f53027i = queue;
        }

        void B(rx.l<? super rx.observables.d<K, V>> lVar, Queue<?> queue, Throwable th) {
            queue.clear();
            ArrayList arrayList = new ArrayList(this.f53024f.values());
            this.f53024f.clear();
            Queue<e<K, V>> queue2 = this.f53027i;
            if (queue2 != null) {
                queue2.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onError(th);
            }
            lVar.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<K, T> extends rx.observables.d<K, T> {

        /* renamed from: c, reason: collision with root package name */
        final f<T, K> f53035c;

        public static <T, K> e<K, T> z7(K k6, int i6, d<?, K, T> dVar, boolean z5) {
            return new e<>(k6, new f(i6, dVar, k6, z5));
        }

        public void A7() {
            this.f53035c.d();
        }

        public void onError(Throwable th) {
            this.f53035c.e(th);
        }

        public void onNext(T t5) {
            this.f53035c.f(t5);
        }

        protected e(K k6, f<T, K> fVar) {
            super(k6, fVar);
            this.f53035c = fVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f<T, K> extends AtomicInteger implements rx.g, rx.m, e.a<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: a, reason: collision with root package name */
        final K f53036a;

        /* renamed from: c, reason: collision with root package name */
        final d<?, K, T> f53038c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f53039d;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f53041f;

        /* renamed from: g, reason: collision with root package name */
        Throwable f53042g;

        /* renamed from: b, reason: collision with root package name */
        final Queue<Object> f53037b = new ConcurrentLinkedQueue();

        /* renamed from: h, reason: collision with root package name */
        final AtomicBoolean f53043h = new AtomicBoolean();

        /* renamed from: i, reason: collision with root package name */
        final AtomicReference<rx.l<? super T>> f53044i = new AtomicReference<>();

        /* renamed from: j, reason: collision with root package name */
        final AtomicBoolean f53045j = new AtomicBoolean();

        /* renamed from: e, reason: collision with root package name */
        final AtomicLong f53040e = new AtomicLong();

        public void d() {
            this.f53041f = true;
            b();
        }

        boolean a(boolean z5, boolean z6, rx.l<? super T> lVar, boolean z7) {
            if (this.f53043h.get()) {
                this.f53037b.clear();
                this.f53038c.j(this.f53036a);
                return true;
            }
            if (!z5) {
                return false;
            }
            if (z7) {
                if (!z6) {
                    return false;
                }
                Throwable th = this.f53042g;
                if (th != null) {
                    lVar.onError(th);
                } else {
                    lVar.onCompleted();
                }
                return true;
            }
            Throwable th2 = this.f53042g;
            if (th2 != null) {
                this.f53037b.clear();
                lVar.onError(th2);
                return true;
            }
            if (!z6) {
                return false;
            }
            lVar.onCompleted();
            return true;
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Queue<Object> queue = this.f53037b;
            boolean z5 = this.f53039d;
            rx.l<? super T> lVar = this.f53044i.get();
            int i6 = 1;
            while (true) {
                if (lVar != null) {
                    if (a(this.f53041f, queue.isEmpty(), lVar, z5)) {
                        return;
                    }
                    long j6 = this.f53040e.get();
                    boolean z6 = j6 == Long.MAX_VALUE;
                    long j7 = 0;
                    while (j6 != 0) {
                        boolean z7 = this.f53041f;
                        Object poll = queue.poll();
                        boolean z8 = poll == null;
                        if (a(z7, z8, lVar, z5)) {
                            return;
                        }
                        if (z8) {
                            break;
                        }
                        lVar.onNext((Object) v.e(poll));
                        j6--;
                        j7--;
                    }
                    if (j7 != 0) {
                        if (!z6) {
                            this.f53040e.addAndGet(j7);
                        }
                        this.f53038c.f53028j.request(-j7);
                    }
                }
                i6 = addAndGet(-i6);
                if (i6 == 0) {
                    return;
                }
                if (lVar == null) {
                    lVar = this.f53044i.get();
                }
            }
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            if (!this.f53045j.compareAndSet(false, true)) {
                lVar.onError(new IllegalStateException("Only one Subscriber allowed!"));
                return;
            }
            lVar.add(this);
            lVar.setProducer(this);
            this.f53044i.lazySet(lVar);
            b();
        }

        public void e(Throwable th) {
            this.f53042g = th;
            this.f53041f = true;
            b();
        }

        public void f(T t5) {
            if (t5 == null) {
                this.f53042g = new NullPointerException();
                this.f53041f = true;
            } else {
                this.f53037b.offer(v.j(t5));
            }
            b();
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f53043h.get();
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j6);
            }
            if (j6 != 0) {
                rx.internal.operators.a.b(this.f53040e, j6);
                b();
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f53043h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f53038c.j(this.f53036a);
            }
        }

        public f(int i6, d<?, K, T> dVar, K k6, boolean z5) {
            this.f53038c = dVar;
            this.f53036a = k6;
            this.f53039d = z5;
        }
    }

    public j2(rx.functions.p<? super T, ? extends K> pVar) {
        this(pVar, rx.internal.util.n.c(), rx.internal.util.j.f54163d, false, null);
    }

    public j2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2) {
        this(pVar, pVar2, rx.internal.util.j.f54163d, false, null);
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super rx.observables.d<K, V>> lVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map<K, Object> call;
        if (this.f53013e == null) {
            call = new ConcurrentHashMap<>();
            concurrentLinkedQueue = null;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            try {
                call = this.f53013e.call(new b(concurrentLinkedQueue));
            } catch (Throwable th) {
                rx.exceptions.a.f(th, lVar);
                rx.l<? super T> d6 = rx.observers.h.d();
                d6.unsubscribe();
                return d6;
            }
        }
        d dVar = new d(lVar, this.f53009a, this.f53010b, this.f53011c, this.f53012d, call, concurrentLinkedQueue);
        lVar.add(rx.subscriptions.f.a(new a(dVar)));
        lVar.setProducer(dVar.f53026h);
        return dVar;
    }

    public j2(rx.functions.p<? super T, ? extends K> pVar, rx.functions.p<? super T, ? extends V> pVar2, int i6, boolean z5, rx.functions.p<rx.functions.b<Object>, Map<K, Object>> pVar3) {
        this.f53009a = pVar;
        this.f53010b = pVar2;
        this.f53011c = i6;
        this.f53012d = z5;
        this.f53013e = pVar3;
    }
}
