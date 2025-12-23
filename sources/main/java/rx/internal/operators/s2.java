package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class s2<T> implements e.b<T, T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.functions.b<? super T> f53492a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicLong f53493a;

        a(AtomicLong atomicLong) {
            this.f53493a = atomicLong;
        }

        @Override // rx.g
        public void request(long j6) {
            rx.internal.operators.a.b(this.f53493a, j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        boolean f53495a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.l f53496b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicLong f53497c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, rx.l lVar2, AtomicLong atomicLong) {
            super(lVar);
            this.f53496b = lVar2;
            this.f53497c = atomicLong;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53495a) {
                return;
            }
            this.f53495a = true;
            this.f53496b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53495a) {
                rx.plugins.c.I(th);
            } else {
                this.f53495a = true;
                this.f53496b.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53495a) {
                return;
            }
            if (this.f53497c.get() > 0) {
                this.f53496b.onNext(t5);
                this.f53497c.decrementAndGet();
                return;
            }
            rx.functions.b<? super T> bVar = s2.this.f53492a;
            if (bVar != null) {
                try {
                    bVar.call(t5);
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, this, t5);
                }
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    s2() {
        this(null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c {

        /* renamed from: a, reason: collision with root package name */
        static final s2<Object> f53499a = new s2<>();

        c() {
        }
    }

    public s2(rx.functions.b<? super T> bVar) {
        this.f53492a = bVar;
    }

    public static <T> s2<T> a() {
        return (s2<T>) c.f53499a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super T> lVar) {
        AtomicLong atomicLong = new AtomicLong();
        lVar.setProducer(new a(atomicLong));
        return new b(lVar, lVar, atomicLong);
    }
}
