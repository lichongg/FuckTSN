package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f52722a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f52723b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicReference f52724c;

        a(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f52722a = countDownLatch;
            this.f52723b = atomicReference;
            this.f52724c = atomicReference2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f52722a.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            androidx.camera.view.p.a(this.f52723b, null, th);
            this.f52722a.countDown();
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f52724c.set(t5);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<T> implements Future<T> {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f52725a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f52726b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.m f52727c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicReference f52728d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicReference f52729e;

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            this.f52726b.await();
            return a();
        }

        b(CountDownLatch countDownLatch, rx.m mVar, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f52726b = countDownLatch;
            this.f52727c = mVar;
            this.f52728d = atomicReference;
            this.f52729e = atomicReference2;
        }

        private T a() throws ExecutionException {
            Throwable th = (Throwable) this.f52728d.get();
            if (th != null) {
                throw new ExecutionException("Observable onError", th);
            }
            if (this.f52725a) {
                throw new CancellationException("Subscription unsubscribed");
            }
            return (T) this.f52729e.get();
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z5) {
            if (this.f52726b.getCount() <= 0) {
                return false;
            }
            this.f52725a = true;
            this.f52727c.unsubscribe();
            this.f52726b.countDown();
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f52725a;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f52726b.getCount() == 0;
        }

        @Override // java.util.concurrent.Future
        public T get(long j6, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            if (this.f52726b.await(j6, timeUnit)) {
                return a();
            }
            throw new TimeoutException("Timed out after " + timeUnit.toMillis(j6) + "ms waiting for underlying Observable.");
        }
    }

    public static <T> Future<T> a(rx.e<? extends T> eVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        return new b(countDownLatch, eVar.Q4().r5(new a(countDownLatch, atomicReference2, atomicReference)), atomicReference2, atomicReference);
    }

    private e() {
        throw new IllegalStateException("No instances!");
    }
}
