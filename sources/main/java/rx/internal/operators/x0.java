package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class x0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f53776a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.q<T, T, T> f53777b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f53778a;

        a(b bVar) {
            this.f53778a = bVar;
        }

        @Override // rx.g
        public void request(long j6) {
            this.f53778a.g(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends rx.l<T> {

        /* renamed from: e, reason: collision with root package name */
        static final Object f53780e = new Object();

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53781a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.q<T, T, T> f53782b;

        /* renamed from: c, reason: collision with root package name */
        T f53783c = (T) f53780e;

        /* renamed from: d, reason: collision with root package name */
        boolean f53784d;

        void g(long j6) {
            if (j6 >= 0) {
                if (j6 != 0) {
                    request(Long.MAX_VALUE);
                }
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53784d) {
                return;
            }
            this.f53784d = true;
            T t5 = this.f53783c;
            if (t5 == f53780e) {
                this.f53781a.onError(new NoSuchElementException());
            } else {
                this.f53781a.onNext(t5);
                this.f53781a.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53784d) {
                rx.plugins.c.I(th);
            } else {
                this.f53784d = true;
                this.f53781a.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53784d) {
                return;
            }
            T t6 = this.f53783c;
            if (t6 == f53780e) {
                this.f53783c = t5;
                return;
            }
            try {
                this.f53783c = this.f53782b.call(t6, t5);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }

        public b(rx.l<? super T> lVar, rx.functions.q<T, T, T> qVar) {
            this.f53781a = lVar;
            this.f53782b = qVar;
            request(0L);
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, this.f53777b);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        this.f53776a.J6(bVar);
    }

    public x0(rx.e<T> eVar, rx.functions.q<T, T, T> qVar) {
        this.f53776a = eVar;
        this.f53777b = qVar;
    }
}
