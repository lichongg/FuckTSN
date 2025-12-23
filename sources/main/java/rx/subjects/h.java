package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;
import rx.internal.operators.v;
import rx.subjects.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class h<T> extends f<T, T> {

    /* renamed from: b, reason: collision with root package name */
    private final g<T> f54565b;

    /* renamed from: c, reason: collision with root package name */
    private final h.a f54566c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.b<g.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f54567a;

        a(g gVar) {
            this.f54567a = gVar;
        }

        @Override // rx.functions.b
        public void call(g.c<T> cVar) {
            cVar.e(this.f54567a.c());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements rx.functions.a {
        b() {
        }

        @Override // rx.functions.a
        public void call() {
            h.this.z7();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f54569a;

        c(Throwable th) {
            this.f54569a = th;
        }

        @Override // rx.functions.a
        public void call() {
            h.this.A7(this.f54569a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f54571a;

        d(Object obj) {
            this.f54571a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.a
        public void call() {
            h.this.B7(this.f54571a);
        }
    }

    public static <T> h<T> y7(rx.schedulers.d dVar) {
        g gVar = new g();
        a aVar = new a(gVar);
        gVar.f54549d = aVar;
        gVar.f54550e = aVar;
        return new h<>(gVar, gVar, dVar);
    }

    void A7(Throwable th) {
        g<T> gVar = this.f54565b;
        if (gVar.f54547b) {
            for (g.c<T> cVar : gVar.h(v.c(th))) {
                cVar.onError(th);
            }
        }
    }

    void B7(T t5) {
        for (g.c<T> cVar : this.f54565b.e()) {
            cVar.onNext(t5);
        }
    }

    public void C7(long j6) {
        this.f54566c.e(new b(), j6, TimeUnit.MILLISECONDS);
    }

    public void D7(Throwable th, long j6) {
        this.f54566c.e(new c(th), j6, TimeUnit.MILLISECONDS);
    }

    public void E7(T t5, long j6) {
        this.f54566c.e(new d(t5), j6, TimeUnit.MILLISECONDS);
    }

    @Override // rx.f
    public void onCompleted() {
        C7(0L);
    }

    @Override // rx.f
    public void onError(Throwable th) {
        D7(th, 0L);
    }

    @Override // rx.f
    public void onNext(T t5) {
        E7(t5, 0L);
    }

    @Override // rx.subjects.f
    public boolean w7() {
        return this.f54565b.e().length > 0;
    }

    void z7() {
        g<T> gVar = this.f54565b;
        if (gVar.f54547b) {
            for (g.c<T> cVar : gVar.h(v.b())) {
                cVar.onCompleted();
            }
        }
    }

    protected h(e.a<T> aVar, g<T> gVar, rx.schedulers.d dVar) {
        super(aVar);
        this.f54565b = gVar;
        this.f54566c = dVar.a();
    }
}
