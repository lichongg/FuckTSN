package rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.i;
import rx.internal.operators.e;
import rx.internal.util.d;
import rx.k;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final i<? extends T> f54490a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.singles.a$a, reason: collision with other inner class name */
    class C1077a extends k<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f54491b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f54492c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicReference f54493d;

        C1077a(AtomicReference atomicReference, CountDownLatch countDownLatch, AtomicReference atomicReference2) {
            this.f54491b = atomicReference;
            this.f54492c = countDownLatch;
            this.f54493d = atomicReference2;
        }

        @Override // rx.k
        public void d(T t5) {
            this.f54491b.set(t5);
            this.f54492c.countDown();
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f54493d.set(th);
            this.f54492c.countDown();
        }
    }

    public static <T> a<T> a(i<? extends T> iVar) {
        return new a<>(iVar);
    }

    public Future<T> b() {
        return e.a(this.f54490a.z0());
    }

    public T c() {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        d.a(countDownLatch, this.f54490a.j0(new C1077a(atomicReference, countDownLatch, atomicReference2)));
        Throwable th = (Throwable) atomicReference2.get();
        if (th == null) {
            return (T) atomicReference.get();
        }
        throw rx.exceptions.a.c(th);
    }

    private a(i<? extends T> iVar) {
        this.f54490a = iVar;
    }
}
