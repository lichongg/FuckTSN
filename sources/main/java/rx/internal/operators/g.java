package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g<T> extends rx.subjects.f<T, T> {

    /* renamed from: d, reason: collision with root package name */
    static final rx.f f52799d = new a();

    /* renamed from: b, reason: collision with root package name */
    final c<T> f52800b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f52801c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final c<T> f52802a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                b.this.f52802a.set(g.f52799d);
            }
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            boolean z5;
            if (!this.f52802a.a(null, lVar)) {
                lVar.onError(new IllegalStateException("Only one subscriber allowed!"));
                return;
            }
            lVar.add(rx.subscriptions.f.a(new a()));
            synchronized (this.f52802a.f52804a) {
                try {
                    c<T> cVar = this.f52802a;
                    if (cVar.f52805b) {
                        z5 = false;
                    } else {
                        z5 = true;
                        cVar.f52805b = true;
                    }
                } finally {
                }
            }
            if (!z5) {
                return;
            }
            while (true) {
                Object poll = this.f52802a.f52806c.poll();
                if (poll != null) {
                    v.a(this.f52802a.get(), poll);
                } else {
                    synchronized (this.f52802a.f52804a) {
                        try {
                            if (this.f52802a.f52806c.isEmpty()) {
                                this.f52802a.f52805b = false;
                                return;
                            }
                        } finally {
                        }
                    }
                }
            }
        }

        public b(c<T> cVar) {
            this.f52802a = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.f {
        a() {
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
        }

        @Override // rx.f
        public void onNext(Object obj) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends AtomicReference<rx.f<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;

        /* renamed from: b, reason: collision with root package name */
        boolean f52805b;

        /* renamed from: a, reason: collision with root package name */
        final Object f52804a = new Object();

        /* renamed from: c, reason: collision with root package name */
        final ConcurrentLinkedQueue<Object> f52806c = new ConcurrentLinkedQueue<>();

        c() {
        }

        boolean a(rx.f<? super T> fVar, rx.f<? super T> fVar2) {
            return compareAndSet(fVar, fVar2);
        }
    }

    private g(c<T> cVar) {
        super(new b(cVar));
        this.f52800b = cVar;
    }

    public static <T> g<T> y7() {
        return new g<>(new c());
    }

    private void z7(Object obj) {
        synchronized (this.f52800b.f52804a) {
            try {
                this.f52800b.f52806c.add(obj);
                if (this.f52800b.get() != null) {
                    c<T> cVar = this.f52800b;
                    if (!cVar.f52805b) {
                        this.f52801c = true;
                        cVar.f52805b = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!this.f52801c) {
            return;
        }
        while (true) {
            Object poll = this.f52800b.f52806c.poll();
            if (poll == null) {
                return;
            } else {
                v.a(this.f52800b.get(), poll);
            }
        }
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f52801c) {
            this.f52800b.get().onCompleted();
        } else {
            z7(v.b());
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f52801c) {
            this.f52800b.get().onError(th);
        } else {
            z7(v.c(th));
        }
    }

    @Override // rx.f
    public void onNext(T t5) {
        if (this.f52801c) {
            this.f52800b.get().onNext(t5);
        } else {
            z7(v.j(t5));
        }
    }

    @Override // rx.subjects.f
    public boolean w7() {
        boolean z5;
        synchronized (this.f52800b.f52804a) {
            z5 = this.f52800b.get() != null;
        }
        return z5;
    }
}
