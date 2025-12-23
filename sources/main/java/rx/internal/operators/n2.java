package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n2<T> implements e.b<Notification<T>, T> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f53213a;

        a(c cVar) {
            this.f53213a = cVar;
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 > 0) {
                this.f53213a.s(j6);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c<T> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super Notification<T>> f53216a;

        /* renamed from: b, reason: collision with root package name */
        private volatile Notification<T> f53217b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f53218c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f53219d;

        /* renamed from: e, reason: collision with root package name */
        private final AtomicLong f53220e = new AtomicLong();

        private void j() {
            synchronized (this) {
                try {
                    if (this.f53218c) {
                        this.f53219d = true;
                        return;
                    }
                    this.f53218c = true;
                    AtomicLong atomicLong = this.f53220e;
                    while (!this.f53216a.isUnsubscribed()) {
                        Notification<T> notification = this.f53217b;
                        if (notification != null && atomicLong.get() > 0) {
                            this.f53217b = null;
                            this.f53216a.onNext(notification);
                            if (this.f53216a.isUnsubscribed()) {
                                return;
                            }
                            this.f53216a.onCompleted();
                            return;
                        }
                        synchronized (this) {
                            try {
                                if (!this.f53219d) {
                                    this.f53218c = false;
                                    return;
                                }
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        private void g() {
            long j6;
            AtomicLong atomicLong = this.f53220e;
            do {
                j6 = atomicLong.get();
                if (j6 == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j6, j6 - 1));
        }

        @Override // rx.f
        public void onNext(T t5) {
            this.f53216a.onNext(Notification.e(t5));
            g();
        }

        @Override // rx.l
        public void onStart() {
            request(0L);
        }

        void s(long j6) {
            rx.internal.operators.a.b(this.f53220e, j6);
            request(j6);
            j();
        }

        c(rx.l<? super Notification<T>> lVar) {
            this.f53216a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f53217b = Notification.b();
            j();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f53217b = Notification.d(th);
            rx.plugins.c.I(th);
            j();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final n2<Object> f53215a = new n2<>();

        b() {
        }
    }

    public static <T> n2<T> a() {
        return (n2<T>) b.f53215a;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super Notification<T>> lVar) {
        c cVar = new c(lVar);
        lVar.add(cVar);
        lVar.setProducer(new a(cVar));
        return cVar;
    }

    n2() {
    }
}
