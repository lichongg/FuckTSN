package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class t<T, R> extends rx.l<T> {

    /* renamed from: e, reason: collision with root package name */
    static final int f53509e = 0;

    /* renamed from: f, reason: collision with root package name */
    static final int f53510f = 1;

    /* renamed from: g, reason: collision with root package name */
    static final int f53511g = 2;

    /* renamed from: h, reason: collision with root package name */
    static final int f53512h = 3;

    /* renamed from: a, reason: collision with root package name */
    protected final rx.l<? super R> f53513a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f53514b;

    /* renamed from: c, reason: collision with root package name */
    protected R f53515c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicInteger f53516d = new AtomicInteger();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final t<?, ?> f53517a;

        @Override // rx.g
        public void request(long j6) {
            this.f53517a.s(j6);
        }

        public a(t<?, ?> tVar) {
            this.f53517a = tVar;
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f53515c = null;
        this.f53513a.onError(th);
    }

    final void A() {
        rx.l<? super R> lVar = this.f53513a;
        lVar.add(this);
        lVar.setProducer(new a(this));
    }

    protected final void g() {
        this.f53513a.onCompleted();
    }

    protected final void j(R r5) {
        rx.l<? super R> lVar = this.f53513a;
        do {
            int i6 = this.f53516d.get();
            if (i6 == 2 || i6 == 3 || lVar.isUnsubscribed()) {
                return;
            }
            if (i6 == 1) {
                lVar.onNext(r5);
                if (!lVar.isUnsubscribed()) {
                    lVar.onCompleted();
                }
                this.f53516d.lazySet(3);
                return;
            }
            this.f53515c = r5;
        } while (!this.f53516d.compareAndSet(0, 2));
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f53514b) {
            j(this.f53515c);
        } else {
            g();
        }
    }

    final void s(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j6);
        }
        if (j6 != 0) {
            rx.l<? super R> lVar = this.f53513a;
            do {
                int i6 = this.f53516d.get();
                if (i6 == 1 || i6 == 3 || lVar.isUnsubscribed()) {
                    return;
                }
                if (i6 == 2) {
                    if (this.f53516d.compareAndSet(2, 3)) {
                        lVar.onNext(this.f53515c);
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        lVar.onCompleted();
                        return;
                    }
                    return;
                }
            } while (!this.f53516d.compareAndSet(0, 1));
        }
    }

    public t(rx.l<? super R> lVar) {
        this.f53513a = lVar;
    }

    public final void B(rx.e<? extends T> eVar) {
        A();
        eVar.J6(this);
    }

    @Override // rx.l, rx.observers.a
    public final void setProducer(rx.g gVar) {
        gVar.request(Long.MAX_VALUE);
    }
}
