package rx;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;
import rx.exceptions.CompositeException;
import rx.h;
import rx.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    static final b f52262b = new b(new k(), false);

    /* renamed from: c, reason: collision with root package name */
    static final b f52263c = new b(new v(), false);

    /* renamed from: a, reason: collision with root package name */
    private final j0 f52264a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f52265a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.b$a$a, reason: collision with other inner class name */
        class C1012a extends rx.l<Object> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.d f52266a;

            C1012a(rx.d dVar) {
                this.f52266a = dVar;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f52266a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f52266a.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
            }
        }

        a(rx.e eVar) {
            this.f52265a = eVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            C1012a c1012a = new C1012a(dVar);
            dVar.a(c1012a);
            this.f52265a.J6(c1012a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a0<T> implements i.t<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.o f52268a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.k f52270a;

            a(rx.k kVar) {
                this.f52270a = kVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52270a.b(mVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.d
            public void onCompleted() {
                try {
                    Object call = a0.this.f52268a.call();
                    if (call == null) {
                        this.f52270a.onError(new NullPointerException("The value supplied is null"));
                    } else {
                        this.f52270a.d(call);
                    }
                } catch (Throwable th) {
                    this.f52270a.onError(th);
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                this.f52270a.onError(th);
            }
        }

        a0(rx.functions.o oVar) {
            this.f52268a = oVar;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            b.this.G0(new a(kVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.b$b, reason: collision with other inner class name */
    static class C1013b implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.i f52272a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.b$b$a */
        class a extends rx.k<Object> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.d f52273b;

            a(rx.d dVar) {
                this.f52273b = dVar;
            }

            @Override // rx.k
            public void d(Object obj) {
                this.f52273b.onCompleted();
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f52273b.onError(th);
            }
        }

        C1013b(rx.i iVar) {
            this.f52272a = iVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            a aVar = new a(dVar);
            dVar.a(aVar);
            this.f52272a.j0(aVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b0<T> implements rx.functions.o<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f52275a;

        b0(Object obj) {
            this.f52275a = obj;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public T call() {
            return (T) this.f52275a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f52277a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f52278b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimeUnit f52279c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.d f52280a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h.a f52281b;

            a(rx.d dVar, h.a aVar) {
                this.f52280a = dVar;
                this.f52281b = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                try {
                    this.f52280a.onCompleted();
                } finally {
                    this.f52281b.unsubscribe();
                }
            }
        }

        c(rx.h hVar, long j6, TimeUnit timeUnit) {
            this.f52277a = hVar;
            this.f52278b = j6;
            this.f52279c = timeUnit;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            dVar.a(cVar);
            if (cVar.isUnsubscribed()) {
                return;
            }
            h.a a6 = this.f52277a.a();
            cVar.b(a6);
            a6.e(new a(dVar, a6), this.f52278b, this.f52279c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c0 implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f52283a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.d f52285a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$c0$a$a, reason: collision with other inner class name */
            class C1014a implements rx.functions.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ rx.m f52287a;

                /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
                /* renamed from: rx.b$c0$a$a$a, reason: collision with other inner class name */
                class C1015a implements rx.functions.a {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ h.a f52289a;

                    C1015a(h.a aVar) {
                        this.f52289a = aVar;
                    }

                    @Override // rx.functions.a
                    public void call() {
                        try {
                            C1014a.this.f52287a.unsubscribe();
                        } finally {
                            this.f52289a.unsubscribe();
                        }
                    }
                }

                C1014a(rx.m mVar) {
                    this.f52287a = mVar;
                }

                @Override // rx.functions.a
                public void call() {
                    h.a a6 = c0.this.f52283a.a();
                    a6.d(new C1015a(a6));
                }
            }

            a(rx.d dVar) {
                this.f52285a = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52285a.a(rx.subscriptions.f.a(new C1014a(mVar)));
            }

            @Override // rx.d
            public void onCompleted() {
                this.f52285a.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                this.f52285a.onError(th);
            }
        }

        c0(rx.h hVar) {
            this.f52283a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            b.this.G0(new a(dVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.o f52291a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f52292b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52293c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f52294d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            rx.m f52295a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f52296b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ Object f52297c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ rx.d f52298d;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$d$a$a, reason: collision with other inner class name */
            class C1016a implements rx.functions.a {
                C1016a() {
                }

                @Override // rx.functions.a
                public void call() {
                    a.this.b();
                }
            }

            a(AtomicBoolean atomicBoolean, Object obj, rx.d dVar) {
                this.f52296b = atomicBoolean;
                this.f52297c = obj;
                this.f52298d = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52295a = mVar;
                this.f52298d.a(rx.subscriptions.f.a(new C1016a()));
            }

            void b() {
                this.f52295a.unsubscribe();
                if (this.f52296b.compareAndSet(false, true)) {
                    try {
                        d.this.f52293c.call(this.f52297c);
                    } catch (Throwable th) {
                        rx.plugins.c.I(th);
                    }
                }
            }

            @Override // rx.d
            public void onCompleted() {
                if (d.this.f52294d && this.f52296b.compareAndSet(false, true)) {
                    try {
                        d.this.f52293c.call(this.f52297c);
                    } catch (Throwable th) {
                        this.f52298d.onError(th);
                        return;
                    }
                }
                this.f52298d.onCompleted();
                if (d.this.f52294d) {
                    return;
                }
                b();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (d.this.f52294d && this.f52296b.compareAndSet(false, true)) {
                    try {
                        d.this.f52293c.call(this.f52297c);
                    } catch (Throwable th2) {
                        th = new CompositeException(Arrays.asList(th, th2));
                    }
                }
                this.f52298d.onError(th);
                if (d.this.f52294d) {
                    return;
                }
                b();
            }
        }

        d(rx.functions.o oVar, rx.functions.p pVar, rx.functions.b bVar, boolean z5) {
            this.f52291a = oVar;
            this.f52292b = pVar;
            this.f52293c = bVar;
            this.f52294d = z5;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            try {
                Object call = this.f52291a.call();
                try {
                    b bVar = (b) this.f52292b.call(call);
                    if (bVar != null) {
                        bVar.G0(new a(new AtomicBoolean(), call, dVar));
                        return;
                    }
                    try {
                        this.f52293c.call(call);
                        dVar.a(rx.subscriptions.f.e());
                        dVar.onError(new NullPointerException("The completable supplied is null"));
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        dVar.a(rx.subscriptions.f.e());
                        dVar.onError(new CompositeException(Arrays.asList(new NullPointerException("The completable supplied is null"), th)));
                    }
                } catch (Throwable th2) {
                    try {
                        this.f52293c.call(call);
                        rx.exceptions.a.e(th2);
                        dVar.a(rx.subscriptions.f.e());
                        dVar.onError(th2);
                    } catch (Throwable th3) {
                        rx.exceptions.a.e(th2);
                        rx.exceptions.a.e(th3);
                        dVar.a(rx.subscriptions.f.e());
                        dVar.onError(new CompositeException(Arrays.asList(th2, th3)));
                    }
                }
            } catch (Throwable th4) {
                dVar.a(rx.subscriptions.f.e());
                dVar.onError(th4);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d0 implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f52301a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f52302a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.b f52303b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ rx.d f52304c;

            a(AtomicBoolean atomicBoolean, rx.subscriptions.b bVar, rx.d dVar) {
                this.f52302a = atomicBoolean;
                this.f52303b = bVar;
                this.f52304c = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52303b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                if (this.f52302a.compareAndSet(false, true)) {
                    this.f52303b.unsubscribe();
                    this.f52304c.onCompleted();
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (!this.f52302a.compareAndSet(false, true)) {
                    rx.plugins.c.I(th);
                } else {
                    this.f52303b.unsubscribe();
                    this.f52304c.onError(th);
                }
            }
        }

        d0(Iterable iterable) {
            this.f52301a = iterable;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            dVar.a(bVar);
            try {
                Iterator it = this.f52301a.iterator();
                if (it == null) {
                    dVar.onError(new NullPointerException("The iterator returned is null"));
                    return;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                a aVar = new a(atomicBoolean, bVar, dVar);
                boolean z5 = true;
                while (!atomicBoolean.get() && !bVar.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            if (z5) {
                                dVar.onCompleted();
                                return;
                            }
                            return;
                        }
                        if (atomicBoolean.get() || bVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            b bVar2 = (b) it.next();
                            if (bVar2 == null) {
                                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                if (!atomicBoolean.compareAndSet(false, true)) {
                                    rx.plugins.c.I(nullPointerException);
                                    return;
                                } else {
                                    bVar.unsubscribe();
                                    dVar.onError(nullPointerException);
                                    return;
                                }
                            }
                            if (atomicBoolean.get() || bVar.isUnsubscribed()) {
                                return;
                            }
                            bVar2.G0(aVar);
                            z5 = false;
                        } catch (Throwable th) {
                            if (!atomicBoolean.compareAndSet(false, true)) {
                                rx.plugins.c.I(th);
                                return;
                            } else {
                                bVar.unsubscribe();
                                dVar.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        if (!atomicBoolean.compareAndSet(false, true)) {
                            rx.plugins.c.I(th2);
                            return;
                        } else {
                            bVar.unsubscribe();
                            dVar.onError(th2);
                            return;
                        }
                    }
                }
            } catch (Throwable th3) {
                dVar.onError(th3);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f52306a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable[] f52307b;

        e(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f52306a = countDownLatch;
            this.f52307b = thArr;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f52306a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f52307b[0] = th;
            this.f52306a.countDown();
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e0 implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.o f52309a;

        e0(rx.functions.o oVar) {
            this.f52309a = oVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            try {
                b bVar = (b) this.f52309a.call();
                if (bVar != null) {
                    bVar.G0(dVar);
                } else {
                    dVar.a(rx.subscriptions.f.e());
                    dVar.onError(new NullPointerException("The completable returned is null"));
                }
            } catch (Throwable th) {
                dVar.a(rx.subscriptions.f.e());
                dVar.onError(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f52310a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable[] f52311b;

        f(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f52310a = countDownLatch;
            this.f52311b = thArr;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f52310a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f52311b[0] = th;
            this.f52310a.countDown();
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f0 implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.o f52313a;

        f0(rx.functions.o oVar) {
            this.f52313a = oVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
            try {
                th = (Throwable) this.f52313a.call();
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                th = new NullPointerException("The error supplied is null");
            }
            dVar.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f52314a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f52315b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimeUnit f52316c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f52317d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.b f52319a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h.a f52320b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ rx.d f52321c;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$g$a$a, reason: collision with other inner class name */
            class C1017a implements rx.functions.a {
                C1017a() {
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f52321c.onCompleted();
                    } finally {
                        a.this.f52320b.unsubscribe();
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$g$a$b, reason: collision with other inner class name */
            class C1018b implements rx.functions.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Throwable f52324a;

                C1018b(Throwable th) {
                    this.f52324a = th;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f52321c.onError(this.f52324a);
                    } finally {
                        a.this.f52320b.unsubscribe();
                    }
                }
            }

            a(rx.subscriptions.b bVar, h.a aVar, rx.d dVar) {
                this.f52319a = bVar;
                this.f52320b = aVar;
                this.f52321c = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52319a.a(mVar);
                this.f52321c.a(this.f52319a);
            }

            @Override // rx.d
            public void onCompleted() {
                rx.subscriptions.b bVar = this.f52319a;
                h.a aVar = this.f52320b;
                C1017a c1017a = new C1017a();
                g gVar = g.this;
                bVar.a(aVar.e(c1017a, gVar.f52315b, gVar.f52316c));
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (!g.this.f52317d) {
                    this.f52321c.onError(th);
                    return;
                }
                rx.subscriptions.b bVar = this.f52319a;
                h.a aVar = this.f52320b;
                C1018b c1018b = new C1018b(th);
                g gVar = g.this;
                bVar.a(aVar.e(c1018b, gVar.f52315b, gVar.f52316c));
            }
        }

        g(rx.h hVar, long j6, TimeUnit timeUnit, boolean z5) {
            this.f52314a = hVar;
            this.f52315b = j6;
            this.f52316c = timeUnit;
            this.f52317d = z5;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            h.a a6 = this.f52314a.a();
            bVar.a(a6);
            b.this.G0(new a(bVar, a6, dVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g0 implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f52326a;

        g0(Throwable th) {
            this.f52326a = th;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
            dVar.onError(this.f52326a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements rx.functions.b<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52327a;

        h(rx.functions.b bVar) {
            this.f52327a = bVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f52327a.call(Notification.d(th));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h0 implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52329a;

        h0(rx.functions.a aVar) {
            this.f52329a = aVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.a aVar = new rx.subscriptions.a();
            dVar.a(aVar);
            try {
                this.f52329a.call();
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onCompleted();
            } catch (Throwable th) {
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onError(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements rx.functions.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52330a;

        i(rx.functions.b bVar) {
            this.f52330a = bVar;
        }

        @Override // rx.functions.a
        public void call() {
            this.f52330a.call(Notification.b());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class i0 implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f52332a;

        i0(Callable callable) {
            this.f52332a = callable;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.a aVar = new rx.subscriptions.a();
            dVar.a(aVar);
            try {
                this.f52332a.call();
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onCompleted();
            } catch (Throwable th) {
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onError(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52333a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52334b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52335c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52336d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52337e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.d f52339a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$j$a$a, reason: collision with other inner class name */
            class C1019a implements rx.functions.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ rx.m f52341a;

                C1019a(rx.m mVar) {
                    this.f52341a = mVar;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        j.this.f52337e.call();
                    } catch (Throwable th) {
                        rx.plugins.c.I(th);
                    }
                    this.f52341a.unsubscribe();
                }
            }

            a(rx.d dVar) {
                this.f52339a = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                try {
                    j.this.f52336d.call(mVar);
                    this.f52339a.a(rx.subscriptions.f.a(new C1019a(mVar)));
                } catch (Throwable th) {
                    mVar.unsubscribe();
                    this.f52339a.a(rx.subscriptions.f.e());
                    this.f52339a.onError(th);
                }
            }

            @Override // rx.d
            public void onCompleted() {
                try {
                    j.this.f52333a.call();
                    this.f52339a.onCompleted();
                    try {
                        j.this.f52334b.call();
                    } catch (Throwable th) {
                        rx.plugins.c.I(th);
                    }
                } catch (Throwable th2) {
                    this.f52339a.onError(th2);
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                try {
                    j.this.f52335c.call(th);
                } catch (Throwable th2) {
                    th = new CompositeException(Arrays.asList(th, th2));
                }
                this.f52339a.onError(th);
                try {
                    j.this.f52334b.call();
                } catch (Throwable th3) {
                    rx.plugins.c.I(th3);
                }
            }
        }

        j(rx.functions.a aVar, rx.functions.a aVar2, rx.functions.b bVar, rx.functions.b bVar2, rx.functions.a aVar3) {
            this.f52333a = aVar;
            this.f52334b = aVar2;
            this.f52335c = bVar;
            this.f52336d = bVar2;
            this.f52337e = aVar3;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            b.this.G0(new a(dVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface j0 extends rx.functions.b<rx.d> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class k implements j0 {
        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
            dVar.onCompleted();
        }

        k() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface k0 extends rx.functions.p<rx.d, rx.d> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l implements rx.functions.b<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52343a;

        l(rx.functions.a aVar) {
            this.f52343a = aVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f52343a.call();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface l0 extends rx.functions.p<b, b> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class m implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f52345a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable[] f52346b;

        m(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f52345a = countDownLatch;
            this.f52346b = thArr;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f52345a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f52346b[0] = th;
            this.f52345a.countDown();
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class n implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f52348a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable[] f52349b;

        n(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f52348a = countDownLatch;
            this.f52349b = thArr;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f52348a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f52349b[0] = th;
            this.f52348a.countDown();
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class o implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k0 f52351a;

        o(k0 k0Var) {
            this.f52351a = k0Var;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            try {
                b.this.G0(rx.plugins.c.C(this.f52351a).call(dVar));
            } catch (NullPointerException e6) {
                throw e6;
            } catch (Throwable th) {
                throw b.C0(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class p implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f52353a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ h.a f52355a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.d f52356b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ rx.internal.util.m f52357c;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$p$a$a, reason: collision with other inner class name */
            class C1020a implements rx.functions.a {
                C1020a() {
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f52356b.onCompleted();
                    } finally {
                        a.this.f52357c.unsubscribe();
                    }
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$p$a$b, reason: collision with other inner class name */
            class C1021b implements rx.functions.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Throwable f52360a;

                C1021b(Throwable th) {
                    this.f52360a = th;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f52356b.onError(this.f52360a);
                    } finally {
                        a.this.f52357c.unsubscribe();
                    }
                }
            }

            a(h.a aVar, rx.d dVar, rx.internal.util.m mVar) {
                this.f52355a = aVar;
                this.f52356b = dVar;
                this.f52357c = mVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52357c.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                this.f52355a.d(new C1020a());
            }

            @Override // rx.d
            public void onError(Throwable th) {
                this.f52355a.d(new C1021b(th));
            }
        }

        p(rx.h hVar) {
            this.f52353a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.internal.util.m mVar = new rx.internal.util.m();
            h.a a6 = this.f52353a.a();
            mVar.a(a6);
            dVar.a(mVar);
            b.this.G0(new a(a6, dVar, mVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class q implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f52362a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.d f52364a;

            a(rx.d dVar) {
                this.f52364a = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52364a.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                this.f52364a.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                boolean z5;
                try {
                    z5 = ((Boolean) q.this.f52362a.call(th)).booleanValue();
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    th = new CompositeException(Arrays.asList(th, th2));
                    z5 = false;
                }
                if (z5) {
                    this.f52364a.onCompleted();
                } else {
                    this.f52364a.onError(th);
                }
            }
        }

        q(rx.functions.p pVar) {
            this.f52362a = pVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            b.this.G0(new a(dVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class r implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f52366a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.d f52368a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.e f52369b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.b$r$a$a, reason: collision with other inner class name */
            class C1022a implements rx.d {
                C1022a() {
                }

                @Override // rx.d
                public void a(rx.m mVar) {
                    a.this.f52369b.b(mVar);
                }

                @Override // rx.d
                public void onCompleted() {
                    a.this.f52368a.onCompleted();
                }

                @Override // rx.d
                public void onError(Throwable th) {
                    a.this.f52368a.onError(th);
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                try {
                    b bVar = (b) r.this.f52366a.call(th);
                    if (bVar == null) {
                        this.f52368a.onError(new CompositeException(Arrays.asList(th, new NullPointerException("The completable returned is null"))));
                    } else {
                        bVar.G0(new C1022a());
                    }
                } catch (Throwable th2) {
                    this.f52368a.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }

            a(rx.d dVar, rx.subscriptions.e eVar) {
                this.f52368a = dVar;
                this.f52369b = eVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52369b.b(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                this.f52368a.onCompleted();
            }
        }

        r(rx.functions.p pVar) {
            this.f52366a = pVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.e eVar = new rx.subscriptions.e();
            dVar.a(eVar);
            b.this.G0(new a(dVar, eVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class s implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.c f52372a;

        s(rx.subscriptions.c cVar) {
            this.f52372a = cVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f52372a.b(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f52372a.unsubscribe();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            rx.plugins.c.I(th);
            this.f52372a.unsubscribe();
            b.u(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class t implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        boolean f52374a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52375b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.c f52376c;

        t(rx.functions.a aVar, rx.subscriptions.c cVar) {
            this.f52375b = aVar;
            this.f52376c = cVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f52376c.b(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f52374a) {
                return;
            }
            this.f52374a = true;
            try {
                this.f52375b.call();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            rx.plugins.c.I(th);
            this.f52376c.unsubscribe();
            b.u(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class u implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        boolean f52378a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.a f52379b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.c f52380c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52381d;

        u(rx.functions.a aVar, rx.subscriptions.c cVar, rx.functions.b bVar) {
            this.f52379b = aVar;
            this.f52380c = cVar;
            this.f52381d = bVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f52380c.b(mVar);
        }

        void b(Throwable th) {
            try {
                this.f52381d.call(th);
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f52378a) {
                return;
            }
            this.f52378a = true;
            try {
                this.f52379b.call();
                this.f52380c.unsubscribe();
            } catch (Throwable th) {
                b(th);
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            if (this.f52378a) {
                rx.plugins.c.I(th);
                b.u(th);
            } else {
                this.f52378a = true;
                b(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class v implements j0 {
        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
        }

        v() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class w implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b[] f52383a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f52384a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.b f52385b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ rx.d f52386c;

            a(AtomicBoolean atomicBoolean, rx.subscriptions.b bVar, rx.d dVar) {
                this.f52384a = atomicBoolean;
                this.f52385b = bVar;
                this.f52386c = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f52385b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                if (this.f52384a.compareAndSet(false, true)) {
                    this.f52385b.unsubscribe();
                    this.f52386c.onCompleted();
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (!this.f52384a.compareAndSet(false, true)) {
                    rx.plugins.c.I(th);
                } else {
                    this.f52385b.unsubscribe();
                    this.f52386c.onError(th);
                }
            }
        }

        w(b[] bVarArr) {
            this.f52383a = bVarArr;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            dVar.a(bVar);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            a aVar = new a(atomicBoolean, bVar, dVar);
            for (b bVar2 : this.f52383a) {
                if (bVar.isUnsubscribed()) {
                    return;
                }
                if (bVar2 == null) {
                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                    if (!atomicBoolean.compareAndSet(false, true)) {
                        rx.plugins.c.I(nullPointerException);
                        return;
                    } else {
                        bVar.unsubscribe();
                        dVar.onError(nullPointerException);
                        return;
                    }
                }
                if (atomicBoolean.get() || bVar.isUnsubscribed()) {
                    return;
                }
                bVar2.G0(aVar);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class x implements rx.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.l f52388a;

        x(rx.l lVar) {
            this.f52388a = lVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f52388a.add(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f52388a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f52388a.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class y implements j0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f52390a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.d f52392a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h.a f52393b;

            a(rx.d dVar, h.a aVar) {
                this.f52392a = dVar;
                this.f52393b = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                try {
                    b.this.G0(this.f52392a);
                } finally {
                    this.f52393b.unsubscribe();
                }
            }
        }

        y(rx.h hVar) {
            this.f52390a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            h.a a6 = this.f52390a.a();
            a6.d(new a(dVar, a6));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class z<T> implements e.a<T> {
        z() {
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            b.this.H0(lVar);
        }
    }

    protected b(j0 j0Var) {
        this.f52264a = rx.plugins.c.F(j0Var);
    }

    public static <R> b K0(rx.functions.o<R> oVar, rx.functions.p<? super R, ? extends b> pVar, rx.functions.b<? super R> bVar) {
        return L0(oVar, pVar, bVar, true);
    }

    public static b Q(rx.e<? extends b> eVar, int i6) {
        return S(eVar, i6, false);
    }

    public static b V(rx.e<? extends b> eVar, int i6) {
        return S(eVar, i6, true);
    }

    public static b l(rx.e<? extends b> eVar) {
        return m(eVar, 2);
    }

    public final <T> void H0(rx.l<T> lVar) {
        I0(lVar, true);
    }

    public final b s(long j6, TimeUnit timeUnit, rx.h hVar) {
        return t(j6, timeUnit, hVar, false);
    }

    public final b w0(long j6, TimeUnit timeUnit, rx.h hVar) {
        return y0(j6, timeUnit, hVar, null);
    }

    static NullPointerException C0(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b H(rx.functions.b<rx.c> bVar) {
        return p(new rx.internal.operators.j(bVar));
    }

    public static b Y() {
        b bVar = f52263c;
        j0 F = rx.plugins.c.F(bVar.f52264a);
        return F == bVar.f52264a ? bVar : new b(F, false);
    }

    public static b i() {
        b bVar = f52262b;
        j0 F = rx.plugins.c.F(bVar.f52264a);
        return F == bVar.f52264a ? bVar : new b(F, false);
    }

    public final <T> rx.e<T> D0() {
        return rx.e.I6(new z());
    }

    public final Throwable L() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new m(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            countDownLatch.await();
            return thArr[0];
        } catch (InterruptedException e6) {
            throw rx.exceptions.a.c(e6);
        }
    }

    public final void g() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new e(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            Throwable th = thArr[0];
            if (th != null) {
                rx.exceptions.a.c(th);
                return;
            }
            return;
        }
        try {
            countDownLatch.await();
            Throwable th2 = thArr[0];
            if (th2 != null) {
                rx.exceptions.a.c(th2);
            }
        } catch (InterruptedException e6) {
            throw rx.exceptions.a.c(e6);
        }
    }

    public final rx.m n0() {
        rx.subscriptions.c cVar = new rx.subscriptions.c();
        G0(new s(cVar));
        return cVar;
    }

    public final void q0(rx.d dVar) {
        if (!(dVar instanceof rx.observers.d)) {
            dVar = new rx.observers.d(dVar);
        }
        G0(dVar);
    }

    public final b x(rx.functions.b<Notification<Object>> bVar) {
        if (bVar != null) {
            return z(rx.functions.m.a(), new h(bVar), new i(bVar), rx.functions.m.a(), rx.functions.m.a());
        }
        throw new IllegalArgumentException("onNotification is null");
    }

    protected b(j0 j0Var, boolean z5) {
        this.f52264a = z5 ? rx.plugins.c.F(j0Var) : j0Var;
    }

    public static b A0(long j6, TimeUnit timeUnit, rx.h hVar) {
        g0(timeUnit);
        g0(hVar);
        return p(new c(hVar, j6, timeUnit));
    }

    public static b D(Throwable th) {
        g0(th);
        return p(new g0(th));
    }

    public static b E(rx.functions.o<? extends Throwable> oVar) {
        g0(oVar);
        return p(new f0(oVar));
    }

    public static b F(rx.functions.a aVar) {
        g0(aVar);
        return p(new h0(aVar));
    }

    public static b G(Callable<?> callable) {
        g0(callable);
        return p(new i0(callable));
    }

    public static b I(Future<?> future) {
        g0(future);
        return J(rx.e.v2(future));
    }

    private <T> void I0(rx.l<T> lVar, boolean z5) {
        g0(lVar);
        if (z5) {
            try {
                lVar.onStart();
            } catch (NullPointerException e6) {
                throw e6;
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                Throwable L = rx.plugins.c.L(th);
                rx.plugins.c.I(L);
                throw C0(L);
            }
        }
        G0(new x(lVar));
        rx.plugins.c.N(lVar);
    }

    public static b J(rx.e<?> eVar) {
        g0(eVar);
        return p(new a(eVar));
    }

    public static b K(rx.i<?> iVar) {
        g0(iVar);
        return p(new C1013b(iVar));
    }

    public static <R> b L0(rx.functions.o<R> oVar, rx.functions.p<? super R, ? extends b> pVar, rx.functions.b<? super R> bVar, boolean z5) {
        g0(oVar);
        g0(pVar);
        g0(bVar);
        return p(new d(oVar, pVar, bVar, z5));
    }

    public static b O(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new rx.internal.operators.r(iterable));
    }

    public static b P(rx.e<? extends b> eVar) {
        return S(eVar, Integer.MAX_VALUE, false);
    }

    public static b R(b... bVarArr) {
        g0(bVarArr);
        if (bVarArr.length == 0) {
            return i();
        }
        if (bVarArr.length == 1) {
            return bVarArr[0];
        }
        return p(new rx.internal.operators.o(bVarArr));
    }

    protected static b S(rx.e<? extends b> eVar, int i6, boolean z5) {
        g0(eVar);
        if (i6 >= 1) {
            return p(new rx.internal.operators.n(eVar, i6, z5));
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i6);
    }

    public static b T(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new rx.internal.operators.q(iterable));
    }

    public static b U(rx.e<? extends b> eVar) {
        return S(eVar, Integer.MAX_VALUE, true);
    }

    public static b W(b... bVarArr) {
        g0(bVarArr);
        return p(new rx.internal.operators.p(bVarArr));
    }

    public static b a(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new d0(iterable));
    }

    public static b b(b... bVarArr) {
        g0(bVarArr);
        if (bVarArr.length == 0) {
            return i();
        }
        if (bVarArr.length == 1) {
            return bVarArr[0];
        }
        return p(new w(bVarArr));
    }

    static <T> T g0(T t5) {
        t5.getClass();
        return t5;
    }

    public static b k(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new rx.internal.operators.m(iterable));
    }

    public static b m(rx.e<? extends b> eVar, int i6) {
        g0(eVar);
        if (i6 >= 1) {
            return p(new rx.internal.operators.k(eVar, i6));
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i6);
    }

    public static b n(b... bVarArr) {
        g0(bVarArr);
        if (bVarArr.length == 0) {
            return i();
        }
        if (bVarArr.length == 1) {
            return bVarArr[0];
        }
        return p(new rx.internal.operators.l(bVarArr));
    }

    public static b p(j0 j0Var) {
        g0(j0Var);
        try {
            return new b(j0Var);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            rx.plugins.c.I(th);
            throw C0(th);
        }
    }

    public static b q(rx.functions.o<? extends b> oVar) {
        g0(oVar);
        return p(new e0(oVar));
    }

    static void u(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static b z0(long j6, TimeUnit timeUnit) {
        return A0(j6, timeUnit, rx.schedulers.c.a());
    }

    public final b A(rx.functions.b<? super rx.m> bVar) {
        return z(bVar, rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a());
    }

    public final b B(rx.functions.a aVar) {
        return z(rx.functions.m.a(), new l(aVar), aVar, rx.functions.m.a(), rx.functions.m.a());
    }

    public final <R> R B0(rx.functions.p<? super b, R> pVar) {
        return pVar.call(this);
    }

    public final b C(rx.functions.a aVar) {
        return z(rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), aVar);
    }

    public final <T> rx.i<T> E0(rx.functions.o<? extends T> oVar) {
        g0(oVar);
        return rx.i.n(new a0(oVar));
    }

    public final <T> rx.i<T> F0(T t5) {
        g0(t5);
        return E0(new b0(t5));
    }

    public final void G0(rx.d dVar) {
        g0(dVar);
        try {
            rx.plugins.c.D(this, this.f52264a).call(dVar);
        } catch (NullPointerException e6) {
            throw e6;
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            Throwable B = rx.plugins.c.B(th);
            rx.plugins.c.I(B);
            throw C0(B);
        }
    }

    public final b J0(rx.h hVar) {
        g0(hVar);
        return p(new c0(hVar));
    }

    public final Throwable M(long j6, TimeUnit timeUnit) {
        g0(timeUnit);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new n(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            if (countDownLatch.await(j6, timeUnit)) {
                return thArr[0];
            }
            rx.exceptions.a.c(new TimeoutException());
            return null;
        } catch (InterruptedException e6) {
            throw rx.exceptions.a.c(e6);
        }
    }

    public final b N(k0 k0Var) {
        g0(k0Var);
        return p(new o(k0Var));
    }

    public final b X(b bVar) {
        g0(bVar);
        return R(this, bVar);
    }

    public final b Z(rx.h hVar) {
        g0(hVar);
        return p(new p(hVar));
    }

    public final b a0() {
        return b0(rx.internal.util.n.b());
    }

    public final b b0(rx.functions.p<? super Throwable, Boolean> pVar) {
        g0(pVar);
        return p(new q(pVar));
    }

    public final b c(b bVar) {
        g0(bVar);
        return b(this, bVar);
    }

    public final b c0(rx.functions.p<? super Throwable, ? extends b> pVar) {
        g0(pVar);
        return p(new r(pVar));
    }

    public final b d(b bVar) {
        return o(bVar);
    }

    public final b d0() {
        return J(D0().g4());
    }

    public final <T> rx.e<T> e(rx.e<T> eVar) {
        g0(eVar);
        return eVar.y1(D0());
    }

    public final b e0(long j6) {
        return J(D0().h4(j6));
    }

    public final <T> rx.i<T> f(rx.i<T> iVar) {
        g0(iVar);
        return iVar.r(D0());
    }

    public final b f0(rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> pVar) {
        g0(pVar);
        return J(D0().k4(pVar));
    }

    public final boolean h(long j6, TimeUnit timeUnit) {
        Throwable th;
        g0(timeUnit);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new f(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            Throwable th2 = thArr[0];
            if (th2 != null) {
                rx.exceptions.a.c(th2);
            }
            return true;
        }
        try {
            boolean await = countDownLatch.await(j6, timeUnit);
            if (await && (th = thArr[0]) != null) {
                rx.exceptions.a.c(th);
            }
            return await;
        } catch (InterruptedException e6) {
            throw rx.exceptions.a.c(e6);
        }
    }

    public final b h0() {
        return J(D0().C4());
    }

    public final b i0(long j6) {
        return J(D0().D4(j6));
    }

    public final b j(l0 l0Var) {
        return (b) B0(l0Var);
    }

    public final b j0(rx.functions.q<Integer, Throwable, Boolean> qVar) {
        return J(D0().E4(qVar));
    }

    public final b k0(rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
        return J(D0().F4(pVar));
    }

    public final b l0(b bVar) {
        g0(bVar);
        return n(bVar, this);
    }

    public final <T> rx.e<T> m0(rx.e<T> eVar) {
        g0(eVar);
        return D0().o5(eVar);
    }

    public final b o(b bVar) {
        g0(bVar);
        return n(this, bVar);
    }

    public final rx.m o0(rx.functions.a aVar) {
        g0(aVar);
        rx.subscriptions.c cVar = new rx.subscriptions.c();
        G0(new t(aVar, cVar));
        return cVar;
    }

    public final rx.m p0(rx.functions.a aVar, rx.functions.b<? super Throwable> bVar) {
        g0(aVar);
        g0(bVar);
        rx.subscriptions.c cVar = new rx.subscriptions.c();
        G0(new u(aVar, cVar, bVar));
        return cVar;
    }

    public final b r(long j6, TimeUnit timeUnit) {
        return t(j6, timeUnit, rx.schedulers.c.a(), false);
    }

    public final <T> void r0(rx.l<T> lVar) {
        lVar.onStart();
        if (!(lVar instanceof rx.observers.e)) {
            lVar = new rx.observers.e(lVar);
        }
        I0(lVar, false);
    }

    public final b s0(rx.h hVar) {
        g0(hVar);
        return p(new y(hVar));
    }

    public final b t(long j6, TimeUnit timeUnit, rx.h hVar, boolean z5) {
        g0(timeUnit);
        g0(hVar);
        return p(new g(hVar, j6, timeUnit, z5));
    }

    public final b u0(long j6, TimeUnit timeUnit) {
        return y0(j6, timeUnit, rx.schedulers.c.a(), null);
    }

    public final b v(rx.functions.a aVar) {
        return z(rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), aVar, rx.functions.m.a());
    }

    public final b v0(long j6, TimeUnit timeUnit, b bVar) {
        g0(bVar);
        return y0(j6, timeUnit, rx.schedulers.c.a(), bVar);
    }

    public final b w(rx.functions.a aVar) {
        return z(rx.functions.m.a(), rx.functions.m.a(), aVar, rx.functions.m.a(), rx.functions.m.a());
    }

    public final b x0(long j6, TimeUnit timeUnit, rx.h hVar, b bVar) {
        g0(bVar);
        return y0(j6, timeUnit, hVar, bVar);
    }

    public final b y(rx.functions.b<? super Throwable> bVar) {
        return z(rx.functions.m.a(), bVar, rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a());
    }

    public final b y0(long j6, TimeUnit timeUnit, rx.h hVar, b bVar) {
        g0(timeUnit);
        g0(hVar);
        return p(new rx.internal.operators.s(this, j6, timeUnit, hVar, bVar));
    }

    protected final b z(rx.functions.b<? super rx.m> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar, rx.functions.a aVar2, rx.functions.a aVar3) {
        g0(bVar);
        g0(bVar2);
        g0(aVar);
        g0(aVar2);
        g0(aVar3);
        return p(new j(aVar, aVar2, bVar2, bVar, aVar3));
    }

    public final rx.observers.a<Void> t0() {
        l5.a g6 = l5.a.g(Long.MAX_VALUE);
        r0(g6);
        return g6;
    }
}
