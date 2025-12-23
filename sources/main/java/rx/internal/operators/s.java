package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.b;
import rx.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s implements b.j0 {

    /* renamed from: a, reason: collision with root package name */
    final rx.b f53462a;

    /* renamed from: b, reason: collision with root package name */
    final long f53463b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f53464c;

    /* renamed from: d, reason: collision with root package name */
    final rx.h f53465d;

    /* renamed from: e, reason: collision with root package name */
    final rx.b f53466e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f53467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53468b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.d f53469c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.s$a$a, reason: collision with other inner class name */
        class C1048a implements rx.d {
            C1048a() {
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                a.this.f53468b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                a.this.f53468b.unsubscribe();
                a.this.f53469c.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                a.this.f53468b.unsubscribe();
                a.this.f53469c.onError(th);
            }
        }

        a(AtomicBoolean atomicBoolean, rx.subscriptions.b bVar, rx.d dVar) {
            this.f53467a = atomicBoolean;
            this.f53468b = bVar;
            this.f53469c = dVar;
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f53467a.compareAndSet(false, true)) {
                this.f53468b.d();
                rx.b bVar = s.this.f53466e;
                if (bVar == null) {
                    this.f53469c.onError(new TimeoutException());
                } else {
                    bVar.G0(new C1048a());
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.b f53472a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f53473b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.d f53474c;

        b(rx.subscriptions.b bVar, AtomicBoolean atomicBoolean, rx.d dVar) {
            this.f53472a = bVar;
            this.f53473b = atomicBoolean;
            this.f53474c = dVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f53472a.a(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f53473b.compareAndSet(false, true)) {
                this.f53472a.unsubscribe();
                this.f53474c.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            if (!this.f53473b.compareAndSet(false, true)) {
                rx.plugins.c.I(th);
            } else {
                this.f53472a.unsubscribe();
                this.f53474c.onError(th);
            }
        }
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        dVar.a(bVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        h.a a6 = this.f53465d.a();
        bVar.a(a6);
        a6.e(new a(atomicBoolean, bVar, dVar), this.f53463b, this.f53464c);
        this.f53462a.G0(new b(bVar, atomicBoolean, dVar));
    }

    public s(rx.b bVar, long j6, TimeUnit timeUnit, rx.h hVar, rx.b bVar2) {
        this.f53462a = bVar;
        this.f53463b = j6;
        this.f53464c = timeUnit;
        this.f53465d = hVar;
        this.f53466e = bVar2;
    }
}
