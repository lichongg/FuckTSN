package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.e;
import rx.internal.producers.SingleProducer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f52703a;

    /* renamed from: b, reason: collision with root package name */
    private final T f52704b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super T> f52706a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f52707b;

        /* renamed from: c, reason: collision with root package name */
        private final T f52708c;

        /* renamed from: d, reason: collision with root package name */
        private T f52709d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f52710e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f52711f;

        @Override // rx.f
        public void onCompleted() {
            if (this.f52711f) {
                return;
            }
            if (this.f52710e) {
                this.f52706a.setProducer(new SingleProducer(this.f52706a, this.f52709d));
            } else if (this.f52707b) {
                this.f52706a.setProducer(new SingleProducer(this.f52706a, this.f52708c));
            } else {
                this.f52706a.onError(new NoSuchElementException("Sequence contains no elements"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52711f) {
                rx.plugins.c.I(th);
            } else {
                this.f52706a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52711f) {
                return;
            }
            if (!this.f52710e) {
                this.f52709d = t5;
                this.f52710e = true;
            } else {
                this.f52711f = true;
                this.f52706a.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            }
        }

        b(rx.l<? super T> lVar, boolean z5, T t5) {
            this.f52706a = lVar;
            this.f52707b = z5;
            this.f52708c = t5;
            request(2L);
        }
    }

    d3() {
        this(false, null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final d3<?> f52705a = new d3<>();

        a() {
        }
    }

    public d3(T t5) {
        this(true, t5);
    }

    public static <T> d3<T> a() {
        return (d3<T>) a.f52705a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f52703a, this.f52704b);
        lVar.add(bVar);
        return bVar;
    }

    private d3(boolean z5, T t5) {
        this.f52703a = z5;
        this.f52704b = t5;
    }
}
