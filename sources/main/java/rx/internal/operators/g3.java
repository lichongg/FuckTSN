package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final long f52849a;

    /* renamed from: b, reason: collision with root package name */
    final rx.h f52850b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private Deque<rx.schedulers.f<T>> f52851a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52852b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52852b = lVar2;
            this.f52851a = new ArrayDeque();
        }

        private void g(long j6) {
            long j7 = j6 - g3.this.f52849a;
            while (!this.f52851a.isEmpty()) {
                rx.schedulers.f<T> first = this.f52851a.getFirst();
                if (first.a() >= j7) {
                    return;
                }
                this.f52851a.removeFirst();
                this.f52852b.onNext(first.b());
            }
        }

        @Override // rx.f
        public void onCompleted() {
            g(g3.this.f52850b.b());
            this.f52852b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52852b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            long b6 = g3.this.f52850b.b();
            g(b6);
            this.f52851a.offerLast(new rx.schedulers.f<>(b6, t5));
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    public g3(long j6, TimeUnit timeUnit, rx.h hVar) {
        this.f52849a = timeUnit.toMillis(j6);
        this.f52850b = hVar;
    }
}
