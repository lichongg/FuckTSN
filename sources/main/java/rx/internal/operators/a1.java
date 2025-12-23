package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a1<T> implements i.t<T> {

    /* renamed from: a, reason: collision with root package name */
    private final rx.e<T> f52502a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private boolean f52503a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f52504b;

        /* renamed from: c, reason: collision with root package name */
        private T f52505c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.k f52506d;

        a(rx.k kVar) {
            this.f52506d = kVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52503a) {
                return;
            }
            if (this.f52504b) {
                this.f52506d.d(this.f52505c);
            } else {
                this.f52506d.onError(new NoSuchElementException("Observable emitted no items"));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52506d.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (!this.f52504b) {
                this.f52504b = true;
                this.f52505c = t5;
            } else {
                this.f52503a = true;
                this.f52506d.onError(new IllegalArgumentException("Observable emitted too many elements"));
                unsubscribe();
            }
        }

        @Override // rx.l
        public void onStart() {
            request(2L);
        }
    }

    public static <T> a1<T> a(rx.e<T> eVar) {
        return new a1<>(eVar);
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        this.f52502a.J6(aVar);
    }

    public a1(rx.e<T> eVar) {
        this.f52502a = eVar;
    }
}
