package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y4 {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<R> implements i.t<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.i[] f53873a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.y f53874b;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.internal.operators.y4$a$a, reason: collision with other inner class name */
        class C1058a<T> extends rx.k<T> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object[] f53875b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f53876c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f53877d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ rx.k f53878e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f53879f;

            C1058a(Object[] objArr, int i6, AtomicInteger atomicInteger, rx.k kVar, AtomicBoolean atomicBoolean) {
                this.f53875b = objArr;
                this.f53876c = i6;
                this.f53877d = atomicInteger;
                this.f53878e = kVar;
                this.f53879f = atomicBoolean;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.k
            public void d(T t5) {
                this.f53875b[this.f53876c] = t5;
                if (this.f53877d.decrementAndGet() == 0) {
                    try {
                        this.f53878e.d(a.this.f53874b.call(this.f53875b));
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        onError(th);
                    }
                }
            }

            @Override // rx.k
            public void onError(Throwable th) {
                if (this.f53879f.compareAndSet(false, true)) {
                    this.f53878e.onError(th);
                } else {
                    rx.plugins.c.I(th);
                }
            }
        }

        a(rx.i[] iVarArr, rx.functions.y yVar) {
            this.f53873a = iVarArr;
            this.f53874b = yVar;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super R> kVar) {
            if (this.f53873a.length == 0) {
                kVar.onError(new NoSuchElementException("Can't zip 0 Singles."));
                return;
            }
            AtomicInteger atomicInteger = new AtomicInteger(this.f53873a.length);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            Object[] objArr = new Object[this.f53873a.length];
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            kVar.b(bVar);
            int i6 = 0;
            while (i6 < this.f53873a.length && !bVar.isUnsubscribed() && !atomicBoolean.get()) {
                rx.k<? super R> kVar2 = kVar;
                C1058a c1058a = new C1058a(objArr, i6, atomicInteger, kVar2, atomicBoolean);
                bVar.a(c1058a);
                if (bVar.isUnsubscribed() || atomicBoolean.get()) {
                    return;
                }
                this.f53873a[i6].j0(c1058a);
                i6++;
                kVar = kVar2;
            }
        }
    }

    public static <T, R> rx.i<R> a(rx.i<? extends T>[] iVarArr, rx.functions.y<? extends R> yVar) {
        return rx.i.n(new a(iVarArr, yVar));
    }

    private y4() {
        throw new IllegalStateException("No instances!");
    }
}
