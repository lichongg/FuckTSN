package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.functions.p;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k extends rx.h implements rx.m {

    /* renamed from: d, reason: collision with root package name */
    static final rx.m f54052d = new c();

    /* renamed from: e, reason: collision with root package name */
    static final rx.m f54053e = rx.subscriptions.f.e();

    /* renamed from: a, reason: collision with root package name */
    private final rx.h f54054a;

    /* renamed from: b, reason: collision with root package name */
    private final rx.f<rx.e<rx.b>> f54055b;

    /* renamed from: c, reason: collision with root package name */
    private final rx.m f54056c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements p<g, rx.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.a f54057a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.schedulers.k$a$a, reason: collision with other inner class name */
        class C1067a implements b.j0 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f54059a;

            C1067a(g gVar) {
                this.f54059a = gVar;
            }

            @Override // rx.functions.b
            public void call(rx.d dVar) {
                dVar.a(this.f54059a);
                this.f54059a.call(a.this.f54057a, dVar);
            }
        }

        a(h.a aVar) {
            this.f54057a = aVar;
        }

        @Override // rx.functions.p
        public rx.b call(g gVar) {
            return rx.b.p(new C1067a(gVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends h.a {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f54061a = new AtomicBoolean();

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.a f54062b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.f f54063c;

        b(h.a aVar, rx.f fVar) {
            this.f54062b = aVar;
            this.f54063c = fVar;
        }

        @Override // rx.h.a
        public rx.m d(rx.functions.a aVar) {
            e eVar = new e(aVar);
            this.f54063c.onNext(eVar);
            return eVar;
        }

        @Override // rx.h.a
        public rx.m e(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            d dVar = new d(aVar, j6, timeUnit);
            this.f54063c.onNext(dVar);
            return dVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54061a.get();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f54061a.compareAndSet(false, true)) {
                this.f54062b.unsubscribe();
                this.f54063c.onCompleted();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        private final rx.functions.a f54065a;

        /* renamed from: b, reason: collision with root package name */
        private final long f54066b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f54067c;

        @Override // rx.internal.schedulers.k.g
        protected rx.m b(h.a aVar, rx.d dVar) {
            return aVar.e(new f(this.f54065a, dVar), this.f54066b, this.f54067c);
        }

        public d(rx.functions.a aVar, long j6, TimeUnit timeUnit) {
            this.f54065a = aVar;
            this.f54066b = j6;
            this.f54067c = timeUnit;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        private final rx.functions.a f54068a;

        @Override // rx.internal.schedulers.k.g
        protected rx.m b(h.a aVar, rx.d dVar) {
            return aVar.d(new f(this.f54068a, dVar));
        }

        public e(rx.functions.a aVar) {
            this.f54068a = aVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        private rx.d f54069a;

        /* renamed from: b, reason: collision with root package name */
        private rx.functions.a f54070b;

        @Override // rx.functions.a
        public void call() {
            try {
                this.f54070b.call();
            } finally {
                this.f54069a.onCompleted();
            }
        }

        public f(rx.functions.a aVar, rx.d dVar) {
            this.f54070b = aVar;
            this.f54069a = dVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class g extends AtomicReference<rx.m> implements rx.m {
        protected abstract rx.m b(h.a aVar, rx.d dVar);

        public g() {
            super(k.f54052d);
        }

        @Override // rx.m
        public void unsubscribe() {
            rx.m mVar;
            rx.m mVar2 = k.f54053e;
            do {
                mVar = get();
                if (mVar == k.f54053e) {
                    return;
                }
            } while (!compareAndSet(mVar, mVar2));
            if (mVar != k.f54052d) {
                mVar.unsubscribe();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(h.a aVar, rx.d dVar) {
            rx.m mVar;
            rx.m mVar2 = get();
            if (mVar2 != k.f54053e && mVar2 == (mVar = k.f54052d)) {
                rx.m b6 = b(aVar, dVar);
                if (!compareAndSet(mVar, b6)) {
                    b6.unsubscribe();
                }
            }
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements rx.m {
        @Override // rx.m
        public boolean isUnsubscribed() {
            return false;
        }

        c() {
        }

        @Override // rx.m
        public void unsubscribe() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.h
    public h.a a() {
        h.a a6 = this.f54054a.a();
        rx.internal.operators.g y7 = rx.internal.operators.g.y7();
        rx.observers.f fVar = new rx.observers.f(y7);
        Object c32 = y7.c3(new a(a6));
        b bVar = new b(a6, fVar);
        this.f54055b.onNext(c32);
        return bVar;
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f54056c.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f54056c.unsubscribe();
    }

    public k(p<rx.e<rx.e<rx.b>>, rx.b> pVar, rx.h hVar) {
        this.f54054a = hVar;
        rx.subjects.c y7 = rx.subjects.c.y7();
        this.f54055b = new rx.observers.f(y7);
        this.f54056c = pVar.call(y7.N3()).n0();
    }
}
