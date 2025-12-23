package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Notification;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<T> implements Iterable<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f52681a;

        a(rx.e eVar) {
            this.f52681a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new b(this.f52681a, new c());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        private final c<T> f52682a;

        /* renamed from: b, reason: collision with root package name */
        private final rx.e<? extends T> f52683b;

        /* renamed from: c, reason: collision with root package name */
        private T f52684c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f52685d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f52686e = true;

        /* renamed from: f, reason: collision with root package name */
        private Throwable f52687f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f52688g;

        private boolean a() {
            try {
                if (!this.f52688g) {
                    this.f52688g = true;
                    this.f52682a.j(1);
                    this.f52683b.e3().r5(this.f52682a);
                }
                Notification<? extends T> s5 = this.f52682a.s();
                if (s5.m()) {
                    this.f52686e = false;
                    this.f52684c = s5.h();
                    return true;
                }
                this.f52685d = false;
                if (s5.k()) {
                    return false;
                }
                if (!s5.l()) {
                    throw new IllegalStateException("Should not reach here");
                }
                Throwable g6 = s5.g();
                this.f52687f = g6;
                throw rx.exceptions.a.c(g6);
            } catch (InterruptedException e6) {
                this.f52682a.unsubscribe();
                Thread.currentThread().interrupt();
                this.f52687f = e6;
                throw rx.exceptions.a.c(e6);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f52687f;
            if (th != null) {
                throw rx.exceptions.a.c(th);
            }
            if (this.f52685d) {
                return !this.f52686e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th = this.f52687f;
            if (th != null) {
                throw rx.exceptions.a.c(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f52686e = true;
            return this.f52684c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }

        b(rx.e<? extends T> eVar, c<T> cVar) {
            this.f52683b = eVar;
            this.f52682a = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends rx.l<Notification<? extends T>> {

        /* renamed from: a, reason: collision with root package name */
        private final BlockingQueue<Notification<? extends T>> f52689a = new ArrayBlockingQueue(1);

        /* renamed from: b, reason: collision with root package name */
        final AtomicInteger f52690b = new AtomicInteger();

        public Notification<? extends T> s() throws InterruptedException {
            j(1);
            return this.f52689a.take();
        }

        @Override // rx.f
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onNext(Notification<? extends T> notification) {
            if (this.f52690b.getAndSet(0) == 1 || !notification.m()) {
                while (!this.f52689a.offer(notification)) {
                    Notification<? extends T> poll = this.f52689a.poll();
                    if (poll != null && !poll.m()) {
                        notification = poll;
                    }
                }
            }
        }

        void j(int i6) {
            this.f52690b.set(i6);
        }

        c() {
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

    private d() {
        throw new IllegalStateException("No instances!");
    }
}
