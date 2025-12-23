package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<T> extends rx.l<Notification<? extends T>> implements Iterator<T> {

        /* renamed from: d, reason: collision with root package name */
        static final int f52752d = (rx.internal.util.j.f54163d * 3) / 4;

        /* renamed from: a, reason: collision with root package name */
        private final BlockingQueue<Notification<? extends T>> f52753a = new LinkedBlockingQueue();

        /* renamed from: b, reason: collision with root package name */
        private Notification<? extends T> f52754b;

        /* renamed from: c, reason: collision with root package name */
        private int f52755c;

        private Notification<? extends T> j() {
            try {
                Notification<? extends T> poll = this.f52753a.poll();
                return poll != null ? poll : this.f52753a.take();
            } catch (InterruptedException e6) {
                unsubscribe();
                throw rx.exceptions.a.c(e6);
            }
        }

        @Override // rx.f
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onNext(Notification<? extends T> notification) {
            this.f52753a.offer(notification);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f52754b == null) {
                this.f52754b = j();
                int i6 = this.f52755c + 1;
                this.f52755c = i6;
                if (i6 >= f52752d) {
                    request(i6);
                    this.f52755c = 0;
                }
            }
            if (this.f52754b.l()) {
                throw rx.exceptions.a.c(this.f52754b.g());
            }
            return !this.f52754b.k();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52753a.offer(Notification.d(th));
        }

        @Override // rx.l
        public void onStart() {
            request(rx.internal.util.j.f54163d);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T h6 = this.f52754b.h();
                this.f52754b = null;
                return h6;
            }
            throw new NoSuchElementException();
        }

        @Override // rx.f
        public void onCompleted() {
        }
    }

    public static <T> Iterator<T> a(rx.e<? extends T> eVar) {
        a aVar = new a();
        eVar.e3().r5(aVar);
        return aVar;
    }

    private f() {
        throw new IllegalStateException("No instances!");
    }
}
