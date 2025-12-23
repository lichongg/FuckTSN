package rx.observables;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.p;
import rx.internal.operators.v;
import rx.internal.util.n;
import rx.l;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class b<T> {

    /* renamed from: b, reason: collision with root package name */
    static final Object f54349b = new Object();

    /* renamed from: c, reason: collision with root package name */
    static final Object f54350c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final Object f54351d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final rx.e<? extends T> f54352a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f54353a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f54354b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54355c;

        a(CountDownLatch countDownLatch, AtomicReference atomicReference, rx.functions.b bVar) {
            this.f54353a = countDownLatch;
            this.f54354b = atomicReference;
            this.f54355c = bVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54353a.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54354b.set(th);
            this.f54353a.countDown();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54355c.call(t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.observables.b$b, reason: collision with other inner class name */
    class C1072b implements Iterable<T> {
        C1072b() {
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return b.this.h();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f54358a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f54359b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicReference f54360c;

        c(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f54358a = countDownLatch;
            this.f54359b = atomicReference;
            this.f54360c = atomicReference2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54358a.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54359b.set(th);
            this.f54358a.countDown();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54360c.set(t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable[] f54362a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f54363b;

        d(Throwable[] thArr, CountDownLatch countDownLatch) {
            this.f54362a = thArr;
            this.f54363b = countDownLatch;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54363b.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54362a[0] = th;
            this.f54363b.countDown();
        }

        @Override // rx.f
        public void onNext(T t5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f54365a;

        e(BlockingQueue blockingQueue) {
            this.f54365a = blockingQueue;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54365a.offer(v.b());
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54365a.offer(v.c(th));
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54365a.offer(v.j(t5));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f54367a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.g[] f54368b;

        f(BlockingQueue blockingQueue, rx.g[] gVarArr) {
            this.f54367a = blockingQueue;
            this.f54368b = gVarArr;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54367a.offer(v.b());
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54367a.offer(v.c(th));
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54367a.offer(v.j(t5));
        }

        @Override // rx.l
        public void onStart() {
            this.f54367a.offer(b.f54349b);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f54368b[0] = gVar;
            this.f54367a.offer(b.f54350c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f54370a;

        g(BlockingQueue blockingQueue) {
            this.f54370a = blockingQueue;
        }

        @Override // rx.functions.a
        public void call() {
            this.f54370a.offer(b.f54351d);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements rx.functions.b<Throwable> {
        h() {
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements rx.f<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54373a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f54374b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f54375c;

        i(rx.functions.b bVar, rx.functions.b bVar2, rx.functions.a aVar) {
            this.f54373a = bVar;
            this.f54374b = bVar2;
            this.f54375c = aVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f54375c.call();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54374b.call(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f54373a.call(t5);
        }
    }

    private T a(rx.e<? extends T> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        rx.internal.util.d.a(countDownLatch, eVar.r5(new c(countDownLatch, atomicReference2, atomicReference)));
        if (atomicReference2.get() != null) {
            rx.exceptions.a.c((Throwable) atomicReference2.get());
        }
        return (T) atomicReference.get();
    }

    public static <T> b<T> g(rx.e<? extends T> eVar) {
        return new b<>(eVar);
    }

    public Iterable<T> A() {
        return new C1072b();
    }

    public T b() {
        return a(this.f54352a.X1());
    }

    public T c(p<? super T, Boolean> pVar) {
        return a(this.f54352a.Y1(pVar));
    }

    public T d(T t5) {
        return a(this.f54352a.c3(n.c()).Z1(t5));
    }

    public T e(T t5, p<? super T, Boolean> pVar) {
        return a(this.f54352a.V1(pVar).c3(n.c()).Z1(t5));
    }

    public void f(rx.functions.b<? super T> bVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        rx.internal.util.d.a(countDownLatch, this.f54352a.r5(new a(countDownLatch, atomicReference, bVar)));
        if (atomicReference.get() != null) {
            rx.exceptions.a.c((Throwable) atomicReference.get());
        }
    }

    public Iterator<T> h() {
        return rx.internal.operators.f.a(this.f54352a);
    }

    public T i() {
        return a(this.f54352a.W2());
    }

    public T j(p<? super T, Boolean> pVar) {
        return a(this.f54352a.X2(pVar));
    }

    public T k(T t5) {
        return a(this.f54352a.c3(n.c()).Y2(t5));
    }

    public T l(T t5, p<? super T, Boolean> pVar) {
        return a(this.f54352a.V1(pVar).c3(n.c()).Y2(t5));
    }

    public Iterable<T> m() {
        return rx.internal.operators.b.a(this.f54352a);
    }

    public Iterable<T> n(T t5) {
        return rx.internal.operators.c.a(this.f54352a, t5);
    }

    public Iterable<T> o() {
        return rx.internal.operators.d.a(this.f54352a);
    }

    public T p() {
        return a(this.f54352a.Q4());
    }

    public T q(p<? super T, Boolean> pVar) {
        return a(this.f54352a.R4(pVar));
    }

    public T r(T t5) {
        return a(this.f54352a.c3(n.c()).S4(t5));
    }

    public T s(T t5, p<? super T, Boolean> pVar) {
        return a(this.f54352a.V1(pVar).c3(n.c()).S4(t5));
    }

    public void t() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = {null};
        rx.internal.util.d.a(countDownLatch, this.f54352a.r5(new d(thArr, countDownLatch)));
        Throwable th = thArr[0];
        if (th != null) {
            rx.exceptions.a.c(th);
        }
    }

    public void u(rx.f<? super T> fVar) {
        Object poll;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        m r5 = this.f54352a.r5(new e(linkedBlockingQueue));
        do {
            try {
                try {
                    poll = linkedBlockingQueue.poll();
                    if (poll == null) {
                        poll = linkedBlockingQueue.take();
                    }
                } catch (InterruptedException e6) {
                    Thread.currentThread().interrupt();
                    fVar.onError(e6);
                    r5.unsubscribe();
                    return;
                }
            } catch (Throwable th) {
                r5.unsubscribe();
                throw th;
            }
        } while (!v.a(fVar, poll));
        r5.unsubscribe();
    }

    public void v(l<? super T> lVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        rx.g[] gVarArr = {null};
        f fVar = new f(linkedBlockingQueue, gVarArr);
        lVar.add(fVar);
        lVar.add(rx.subscriptions.f.a(new g(linkedBlockingQueue)));
        this.f54352a.r5(fVar);
        while (!lVar.isUnsubscribed()) {
            try {
                try {
                    Object poll = linkedBlockingQueue.poll();
                    if (poll == null) {
                        poll = linkedBlockingQueue.take();
                    }
                    if (lVar.isUnsubscribed() || poll == f54351d) {
                        break;
                    }
                    if (poll == f54349b) {
                        lVar.onStart();
                    } else if (poll == f54350c) {
                        lVar.setProducer(gVarArr[0]);
                    } else if (v.a(lVar, poll)) {
                        fVar.unsubscribe();
                        return;
                    }
                } catch (InterruptedException e6) {
                    Thread.currentThread().interrupt();
                    lVar.onError(e6);
                    fVar.unsubscribe();
                    return;
                }
            } finally {
                fVar.unsubscribe();
            }
        }
    }

    public void w(rx.functions.b<? super T> bVar) {
        y(bVar, new h(), rx.functions.m.a());
    }

    public void y(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar) {
        u(new i(bVar, bVar2, aVar));
    }

    public Future<T> z() {
        return rx.internal.operators.e.a(this.f54352a);
    }

    private b(rx.e<? extends T> eVar) {
        this.f54352a = eVar;
    }

    public void x(rx.functions.b<? super T> bVar, rx.functions.b<? super Throwable> bVar2) {
        y(bVar, bVar2, rx.functions.m.a());
    }
}
