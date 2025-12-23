package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class m3<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final int f53184a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f53185a;

        a(b bVar) {
            this.f53185a = bVar;
        }

        @Override // rx.g
        public void request(long j6) {
            this.f53185a.g(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> implements rx.functions.p<Object, T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53187a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicLong f53188b = new AtomicLong();

        /* renamed from: c, reason: collision with root package name */
        final ArrayDeque<Object> f53189c = new ArrayDeque<>();

        /* renamed from: d, reason: collision with root package name */
        final int f53190d;

        void g(long j6) {
            if (j6 > 0) {
                rx.internal.operators.a.h(this.f53188b, j6, this.f53189c, this.f53187a, this);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            rx.internal.operators.a.e(this.f53188b, this.f53189c, this.f53187a, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53189c.clear();
            this.f53187a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53189c.size() == this.f53190d) {
                this.f53189c.poll();
            }
            this.f53189c.offer(v.j(t5));
        }

        public b(rx.l<? super T> lVar, int i6) {
            this.f53187a = lVar;
            this.f53190d = i6;
        }

        @Override // rx.functions.p
        public T call(Object obj) {
            return (T) v.e(obj);
        }
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f53184a);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }

    public m3(int i6) {
        if (i6 >= 0) {
            this.f53184a = i6;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }
}
