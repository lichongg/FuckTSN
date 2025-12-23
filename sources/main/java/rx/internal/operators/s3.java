package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f53500a;

    /* renamed from: b, reason: collision with root package name */
    final rx.h f53501b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private long f53502a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f53503b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f53503b = lVar2;
            this.f53502a = -1L;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53503b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53503b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            long b6 = s3.this.f53501b.b();
            long j6 = this.f53502a;
            if (j6 == -1 || b6 < j6 || b6 - j6 >= s3.this.f53500a) {
                this.f53502a = b6;
                this.f53503b.onNext(t5);
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    public s3(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f53500a = timeUnit.toMillis(j6);
        this.f53501b = hVar;
    }
}
