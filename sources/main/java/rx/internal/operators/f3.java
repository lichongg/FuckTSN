package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final int f52779a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Deque<Object> f52780a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f52781b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f52781b = lVar2;
            this.f52780a = new ArrayDeque();
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52781b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52781b.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(T t5) {
            if (f3.this.f52779a == 0) {
                this.f52781b.onNext(t5);
                return;
            }
            if (this.f52780a.size() == f3.this.f52779a) {
                this.f52781b.onNext(v.e(this.f52780a.removeFirst()));
            } else {
                request(1L);
            }
            this.f52780a.offerLast(v.j(t5));
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }

    public f3(int i6) {
        if (i6 >= 0) {
            this.f52779a = i6;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
