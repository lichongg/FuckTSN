package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a2<T, U> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends U> f52508a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        Set<U> f52509a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52510b;

        @Override // rx.f
        public void onCompleted() {
            this.f52509a = null;
            this.f52510b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52509a = null;
            this.f52510b.onError(th);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52510b = lVar2;
            this.f52509a = new HashSet();
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52509a.add(a2.this.f52508a.call(t5))) {
                this.f52510b.onNext(t5);
            } else {
                request(1L);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final a2<?, ?> f52512a = new a2<>(rx.internal.util.n.c());

        b() {
        }
    }

    public static <T> a2<T, T> a() {
        return (a2<T, T>) b.f52512a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    public a2(rx.functions.p<? super T, ? extends U> pVar) {
        this.f52508a = pVar;
    }
}
