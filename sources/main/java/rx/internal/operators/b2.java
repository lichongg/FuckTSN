package rx.internal.operators;

import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b2<T, U> implements e.b<T, T>, rx.functions.q<U, U, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends U> f52582a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.q<? super U, ? super U, Boolean> f52583b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        U f52584a;

        /* renamed from: b, reason: collision with root package name */
        boolean f52585b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.l f52586c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52586c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52586c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52586c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            try {
                U call = b2.this.f52582a.call(t5);
                U u5 = this.f52584a;
                this.f52584a = call;
                if (!this.f52585b) {
                    this.f52585b = true;
                    this.f52586c.onNext(t5);
                    return;
                }
                try {
                    if (b2.this.f52583b.call(u5, call).booleanValue()) {
                        request(1L);
                    } else {
                        this.f52586c.onNext(t5);
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, this.f52586c, call);
                }
            } catch (Throwable th2) {
                rx.exceptions.a.g(th2, this.f52586c, t5);
            }
        }
    }

    public b2(rx.functions.p<? super T, ? extends U> pVar) {
        this.f52582a = pVar;
        this.f52583b = this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final b2<?, ?> f52588a = new b2<>(rx.internal.util.n.c());

        b() {
        }
    }

    public static <T> b2<T, T> a() {
        return (b2<T, T>) b.f52588a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.q
    public Boolean call(U u5, U u6) {
        return Boolean.valueOf(u5 == u6 || (u5 != null && u5.equals(u6)));
    }

    public b2(rx.functions.q<? super U, ? super U, Boolean> qVar) {
        this.f52582a = rx.internal.util.n.c();
        this.f52583b = qVar;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
