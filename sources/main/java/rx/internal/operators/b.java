package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import rx.Notification;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> implements Iterable<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f52571a;

        a(rx.e eVar) {
            this.f52571a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            C1028b c1028b = new C1028b();
            this.f52571a.e3().r5(c1028b);
            return c1028b;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.internal.operators.b$b, reason: collision with other inner class name */
    static final class C1028b<T> extends rx.l<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        final Semaphore f52572a = new Semaphore(0);

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference<Notification<? extends T>> f52573b = new AtomicReference<>();

        /* renamed from: c, reason: collision with root package name */
        Notification<? extends T> f52574c;

        @Override // rx.f
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onNext(Notification<? extends T> notification) {
            if (this.f52573b.getAndSet(notification) == null) {
                this.f52572a.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<? extends T> notification = this.f52574c;
            if (notification != null && notification.l()) {
                throw rx.exceptions.a.c(this.f52574c.g());
            }
            Notification<? extends T> notification2 = this.f52574c;
            if ((notification2 == null || !notification2.k()) && this.f52574c == null) {
                try {
                    this.f52572a.acquire();
                    Notification<? extends T> andSet = this.f52573b.getAndSet(null);
                    this.f52574c = andSet;
                    if (andSet.l()) {
                        throw rx.exceptions.a.c(this.f52574c.g());
                    }
                } catch (InterruptedException e6) {
                    unsubscribe();
                    Thread.currentThread().interrupt();
                    this.f52574c = Notification.d(e6);
                    throw rx.exceptions.a.c(e6);
                }
            }
            return !this.f52574c.k();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        C1028b() {
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() && this.f52574c.m()) {
                T h6 = this.f52574c.h();
                this.f52574c = null;
                return h6;
            }
            throw new NoSuchElementException();
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }
    }

    public static <T> Iterable<T> a(rx.e<? extends T> eVar) {
        return new a(eVar);
    }

    private b() {
        throw new IllegalStateException("No instances!");
    }
}
