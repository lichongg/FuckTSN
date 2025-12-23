package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final int f52886a;

    /* renamed from: b, reason: collision with root package name */
    final boolean f52887b;

    /* renamed from: c, reason: collision with root package name */
    final T f52888c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private int f52889a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52890b;

        a(rx.l lVar) {
            this.f52890b = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            int i6 = this.f52889a;
            h2 h2Var = h2.this;
            if (i6 <= h2Var.f52886a) {
                if (h2Var.f52887b) {
                    this.f52890b.onNext(h2Var.f52888c);
                    this.f52890b.onCompleted();
                    return;
                }
                this.f52890b.onError(new IndexOutOfBoundsException(h2.this.f52886a + " is out of bounds"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52890b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            int i6 = this.f52889a;
            this.f52889a = i6 + 1;
            if (i6 == h2.this.f52886a) {
                this.f52890b.onNext(t5);
                this.f52890b.onCompleted();
                unsubscribe();
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f52890b.setProducer(new b(gVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends AtomicBoolean implements rx.g {
        private static final long serialVersionUID = 1;

        /* renamed from: a, reason: collision with root package name */
        final rx.g f52892a;

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j6 <= 0 || !compareAndSet(false, true)) {
                return;
            }
            this.f52892a.request(Long.MAX_VALUE);
        }

        public b(rx.g gVar) {
            this.f52892a = gVar;
        }
    }

    public h2(int i6) {
        this(i6, null, false);
    }

    public h2(int i6, T t5) {
        this(i6, t5, true);
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        lVar.add(aVar);
        return aVar;
    }

    private h2(int i6, T t5, boolean z5) {
        if (i6 >= 0) {
            this.f52886a = i6;
            this.f52888c = t5;
            this.f52887b = z5;
        } else {
            throw new IndexOutOfBoundsException(i6 + " is out of bounds");
        }
    }
}
