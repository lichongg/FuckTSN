package rx.internal.operators;

import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j3<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.h f53046a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<T> f53047b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f53048c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53049a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f53050b;

        /* renamed from: c, reason: collision with root package name */
        final h.a f53051c;

        /* renamed from: d, reason: collision with root package name */
        rx.e<T> f53052d;

        /* renamed from: e, reason: collision with root package name */
        Thread f53053e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.j3$a$a, reason: collision with other inner class name */
        class C1037a implements rx.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.g f53054a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.internal.operators.j3$a$a$a, reason: collision with other inner class name */
            class C1038a implements rx.functions.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ long f53056a;

                C1038a(long j6) {
                    this.f53056a = j6;
                }

                @Override // rx.functions.a
                public void call() {
                    C1037a.this.f53054a.request(this.f53056a);
                }
            }

            C1037a(rx.g gVar) {
                this.f53054a = gVar;
            }

            @Override // rx.g
            public void request(long j6) {
                if (a.this.f53053e != Thread.currentThread()) {
                    a aVar = a.this;
                    if (aVar.f53050b) {
                        aVar.f53051c.d(new C1038a(j6));
                        return;
                    }
                }
                this.f53054a.request(j6);
            }
        }

        @Override // rx.functions.a
        public void call() {
            rx.e<T> eVar = this.f53052d;
            this.f53052d = null;
            this.f53053e = Thread.currentThread();
            eVar.J6(this);
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f53049a.onCompleted();
            } finally {
                this.f53051c.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f53049a.onError(th);
            } finally {
                this.f53051c.unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53049a.onNext(t5);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f53049a.setProducer(new C1037a(gVar));
        }

        a(rx.l<? super T> lVar, boolean z5, h.a aVar, rx.e<T> eVar) {
            this.f53049a = lVar;
            this.f53050b = z5;
            this.f53051c = aVar;
            this.f53052d = eVar;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        h.a a6 = this.f53046a.a();
        a aVar = new a(lVar, this.f53048c, a6, this.f53047b);
        lVar.add(aVar);
        lVar.add(a6);
        a6.d(aVar);
    }

    public j3(rx.e<T> eVar, rx.h hVar, boolean z5) {
        this.f53046a = hVar;
        this.f53047b = eVar;
        this.f53048c = z5;
    }
}
