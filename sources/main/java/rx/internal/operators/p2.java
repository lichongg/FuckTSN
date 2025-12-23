package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p2<T, R> extends rx.observables.c<R> {

    /* renamed from: b, reason: collision with root package name */
    final rx.e<? extends T> f53340b;

    /* renamed from: c, reason: collision with root package name */
    final Object f53341c;

    /* renamed from: d, reason: collision with root package name */
    final rx.functions.o<? extends rx.subjects.f<? super T, ? extends R>> f53342d;

    /* renamed from: e, reason: collision with root package name */
    final AtomicReference<rx.subjects.f<? super T, ? extends R>> f53343e;

    /* renamed from: f, reason: collision with root package name */
    final List<rx.l<? super R>> f53344f;

    /* renamed from: g, reason: collision with root package name */
    rx.l<T> f53345g;

    /* renamed from: h, reason: collision with root package name */
    rx.m f53346h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e.a<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f53347a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f53348b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f53349c;

        a(Object obj, AtomicReference atomicReference, List list) {
            this.f53347a = obj;
            this.f53348b = atomicReference;
            this.f53349c = list;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super R> lVar) {
            synchronized (this.f53347a) {
                try {
                    if (this.f53348b.get() == null) {
                        this.f53349c.add(lVar);
                    } else {
                        ((rx.subjects.f) this.f53348b.get()).J6(lVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f53350a;

        b(AtomicReference atomicReference) {
            this.f53350a = atomicReference;
        }

        @Override // rx.functions.a
        public void call() {
            synchronized (p2.this.f53341c) {
                if (p2.this.f53346h == this.f53350a.get()) {
                    p2 p2Var = p2.this;
                    rx.l<T> lVar = p2Var.f53345g;
                    p2Var.f53345g = null;
                    p2Var.f53346h = null;
                    p2Var.f53343e.set(null);
                    if (lVar != null) {
                        lVar.unsubscribe();
                    }
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends rx.l<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f53352a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f53352a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53352a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53352a.onError(th);
        }

        @Override // rx.f
        public void onNext(R r5) {
            this.f53352a.onNext(r5);
        }
    }

    public p2(rx.e<? extends T> eVar, rx.functions.o<? extends rx.subjects.f<? super T, ? extends R>> oVar) {
        this(new Object(), new AtomicReference(), new ArrayList(), eVar, oVar);
    }

    private p2(Object obj, AtomicReference<rx.subjects.f<? super T, ? extends R>> atomicReference, List<rx.l<? super R>> list, rx.e<? extends T> eVar, rx.functions.o<? extends rx.subjects.f<? super T, ? extends R>> oVar) {
        super(new a(obj, atomicReference, list));
        this.f53341c = obj;
        this.f53343e = atomicReference;
        this.f53344f = list;
        this.f53340b = eVar;
        this.f53342d = oVar;
    }

    @Override // rx.observables.c
    public void A7(rx.functions.b<? super rx.m> bVar) {
        rx.l<T> lVar;
        synchronized (this.f53341c) {
            try {
                if (this.f53345g != null) {
                    bVar.call(this.f53346h);
                    return;
                }
                rx.subjects.f<? super T, ? extends R> call = this.f53342d.call();
                this.f53345g = rx.observers.h.e(call);
                AtomicReference atomicReference = new AtomicReference();
                atomicReference.set(rx.subscriptions.f.a(new b(atomicReference)));
                this.f53346h = (rx.m) atomicReference.get();
                for (rx.l<? super R> lVar2 : this.f53344f) {
                    call.J6(new c(lVar2, lVar2));
                }
                this.f53344f.clear();
                this.f53343e.set(call);
                bVar.call(this.f53346h);
                synchronized (this.f53341c) {
                    lVar = this.f53345g;
                }
                if (lVar != null) {
                    this.f53340b.r5(lVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
