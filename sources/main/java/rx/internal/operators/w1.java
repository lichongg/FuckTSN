package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w1<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f53692a;

    /* renamed from: b, reason: collision with root package name */
    final TimeUnit f53693b;

    /* renamed from: c, reason: collision with root package name */
    final rx.h f53694c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final b<T> f53695a;

        /* renamed from: b, reason: collision with root package name */
        final rx.l<?> f53696b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f53697c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ h.a f53698d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rx.observers.g f53699e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.w1$a$a, reason: collision with other inner class name */
        class C1053a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f53701a;

            C1053a(int i6) {
                this.f53701a = i6;
            }

            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                aVar.f53695a.b(this.f53701a, aVar.f53699e, aVar.f53696b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.subscriptions.e eVar, h.a aVar, rx.observers.g gVar) {
            super(lVar);
            this.f53697c = eVar;
            this.f53698d = aVar;
            this.f53699e = gVar;
            this.f53695a = new b<>();
            this.f53696b = this;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53695a.c(this.f53699e, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53699e.onError(th);
            unsubscribe();
            this.f53695a.a();
        }

        @Override // rx.f
        public void onNext(T t5) {
            int d6 = this.f53695a.d(t5);
            rx.subscriptions.e eVar = this.f53697c;
            h.a aVar = this.f53698d;
            C1053a c1053a = new C1053a(d6);
            w1 w1Var = w1.this;
            eVar.b(aVar.e(c1053a, w1Var.f53692a, w1Var.f53693b));
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        int f53703a;

        /* renamed from: b, reason: collision with root package name */
        T f53704b;

        /* renamed from: c, reason: collision with root package name */
        boolean f53705c;

        /* renamed from: d, reason: collision with root package name */
        boolean f53706d;

        /* renamed from: e, reason: collision with root package name */
        boolean f53707e;

        public synchronized void a() {
            this.f53703a++;
            this.f53704b = null;
            this.f53705c = false;
        }

        public void b(int i6, rx.l<T> lVar, rx.l<?> lVar2) {
            synchronized (this) {
                if (!this.f53707e && this.f53705c && i6 == this.f53703a) {
                    T t5 = this.f53704b;
                    this.f53704b = null;
                    this.f53705c = false;
                    this.f53707e = true;
                    try {
                        lVar.onNext(t5);
                        synchronized (this) {
                            try {
                                if (this.f53706d) {
                                    lVar.onCompleted();
                                } else {
                                    this.f53707e = false;
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, lVar2, t5);
                    }
                }
            }
        }

        public void c(rx.l<T> lVar, rx.l<?> lVar2) {
            synchronized (this) {
                try {
                    if (this.f53707e) {
                        this.f53706d = true;
                        return;
                    }
                    T t5 = this.f53704b;
                    boolean z5 = this.f53705c;
                    this.f53704b = null;
                    this.f53705c = false;
                    this.f53707e = true;
                    if (z5) {
                        try {
                            lVar.onNext(t5);
                        } catch (Throwable th) {
                            rx.exceptions.a.g(th, lVar2, t5);
                            return;
                        }
                    }
                    lVar.onCompleted();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public synchronized int d(T t5) {
            int i6;
            this.f53704b = t5;
            this.f53705c = true;
            i6 = this.f53703a + 1;
            this.f53703a = i6;
            return i6;
        }

        b() {
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        h.a a6 = this.f53694c.a();
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        gVar.add(a6);
        gVar.add(eVar);
        return new a(lVar, eVar, a6, gVar);
    }

    public w1(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f53692a = j6;
        this.f53693b = timeUnit;
        this.f53694c = hVar;
    }
}
