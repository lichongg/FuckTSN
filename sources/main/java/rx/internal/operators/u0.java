package rx.internal.operators;

import rx.exceptions.AssemblyStackTraceException;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u0<T> implements i.t<T> {

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f53566c;

    /* renamed from: a, reason: collision with root package name */
    final i.t<T> f53567a;

    /* renamed from: b, reason: collision with root package name */
    final String f53568b = s0.a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final rx.k<? super T> f53569b;

        /* renamed from: c, reason: collision with root package name */
        final String f53570c;

        @Override // rx.k
        public void d(T t5) {
            this.f53569b.d(t5);
        }

        @Override // rx.k
        public void onError(Throwable th) {
            new AssemblyStackTraceException(this.f53570c).attachTo(th);
            this.f53569b.onError(th);
        }

        public a(rx.k<? super T> kVar, String str) {
            this.f53569b = kVar;
            this.f53570c = str;
            kVar.b(this);
        }
    }

    @Override // rx.functions.b
    public void call(rx.k<? super T> kVar) {
        this.f53567a.call(new a(kVar, this.f53568b));
    }

    public u0(i.t<T> tVar) {
        this.f53567a = tVar;
    }
}
