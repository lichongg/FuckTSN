package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.exceptions.CompositeException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<rx.b> f53192a;

    /* renamed from: b, reason: collision with root package name */
    final int f53193b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f53194c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends rx.l<rx.b> {

        /* renamed from: a, reason: collision with root package name */
        final rx.d f53195a;

        /* renamed from: c, reason: collision with root package name */
        final boolean f53197c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f53198d;

        /* renamed from: b, reason: collision with root package name */
        final rx.subscriptions.b f53196b = new rx.subscriptions.b();

        /* renamed from: g, reason: collision with root package name */
        final AtomicInteger f53201g = new AtomicInteger(1);

        /* renamed from: f, reason: collision with root package name */
        final AtomicBoolean f53200f = new AtomicBoolean();

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference<Queue<Throwable>> f53199e = new AtomicReference<>();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.n$a$a, reason: collision with other inner class name */
        class C1042a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            rx.m f53202a;

            /* renamed from: b, reason: collision with root package name */
            boolean f53203b;

            C1042a() {
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f53202a = mVar;
                a.this.f53196b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                if (this.f53203b) {
                    return;
                }
                this.f53203b = true;
                a.this.f53196b.f(this.f53202a);
                a.this.B();
                if (a.this.f53198d) {
                    return;
                }
                a.this.request(1L);
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (this.f53203b) {
                    rx.plugins.c.I(th);
                    return;
                }
                this.f53203b = true;
                a.this.f53196b.f(this.f53202a);
                a.this.s().offer(th);
                a.this.B();
                a aVar = a.this;
                if (!aVar.f53197c || aVar.f53198d) {
                    return;
                }
                a.this.request(1L);
            }
        }

        @Override // rx.f
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.b bVar) {
            if (this.f53198d) {
                return;
            }
            this.f53201g.getAndIncrement();
            bVar.G0(new C1042a());
        }

        void B() {
            Queue<Throwable> queue;
            if (this.f53201g.decrementAndGet() != 0) {
                if (this.f53197c || (queue = this.f53199e.get()) == null || queue.isEmpty()) {
                    return;
                }
                Throwable a6 = n.a(queue);
                if (this.f53200f.compareAndSet(false, true)) {
                    this.f53195a.onError(a6);
                    return;
                } else {
                    rx.plugins.c.I(a6);
                    return;
                }
            }
            Queue<Throwable> queue2 = this.f53199e.get();
            if (queue2 == null || queue2.isEmpty()) {
                this.f53195a.onCompleted();
                return;
            }
            Throwable a7 = n.a(queue2);
            if (this.f53200f.compareAndSet(false, true)) {
                this.f53195a.onError(a7);
            } else {
                rx.plugins.c.I(a7);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53198d) {
                return;
            }
            this.f53198d = true;
            B();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53198d) {
                rx.plugins.c.I(th);
                return;
            }
            s().offer(th);
            this.f53198d = true;
            B();
        }

        Queue<Throwable> s() {
            Queue<Throwable> queue = this.f53199e.get();
            if (queue != null) {
                return queue;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            return androidx.camera.view.p.a(this.f53199e, null, concurrentLinkedQueue) ? concurrentLinkedQueue : this.f53199e.get();
        }

        public a(rx.d dVar, int i6, boolean z5) {
            this.f53195a = dVar;
            this.f53197c = z5;
            if (i6 == Integer.MAX_VALUE) {
                request(Long.MAX_VALUE);
            } else {
                request(i6);
            }
        }
    }

    public static Throwable a(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable poll = queue.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.size() == 1 ? (Throwable) arrayList.get(0) : new CompositeException(arrayList);
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f53193b, this.f53194c);
        dVar.a(aVar);
        this.f53192a.J6(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(rx.e<? extends rx.b> eVar, int i6, boolean z5) {
        this.f53192a = eVar;
        this.f53193b = i6;
        this.f53194c = z5;
    }
}
