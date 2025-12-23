package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.n0;
import rx.internal.util.ExceptionsUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k0<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<? extends T> f53074a;

    /* renamed from: b, reason: collision with root package name */
    final rx.functions.p<? super T, ? extends Iterable<? extends R>> f53075b;

    /* renamed from: c, reason: collision with root package name */
    final int f53076c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements rx.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f53077a;

        a(b bVar) {
            this.f53077a = bVar;
        }

        @Override // rx.g
        public void request(long j6) {
            this.f53077a.s(j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T, R> extends rx.l<T> {

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f53079a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends Iterable<? extends R>> f53080b;

        /* renamed from: c, reason: collision with root package name */
        final long f53081c;

        /* renamed from: d, reason: collision with root package name */
        final Queue<Object> f53082d;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f53086h;

        /* renamed from: i, reason: collision with root package name */
        long f53087i;

        /* renamed from: j, reason: collision with root package name */
        Iterator<? extends R> f53088j;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference<Throwable> f53083e = new AtomicReference<>();

        /* renamed from: g, reason: collision with root package name */
        final AtomicInteger f53085g = new AtomicInteger();

        /* renamed from: f, reason: collision with root package name */
        final AtomicLong f53084f = new AtomicLong();

        @Override // rx.f
        public void onCompleted() {
            this.f53086h = true;
            j();
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00d7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0012 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00ce A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void j() {
            /*
                Method dump skipped, instructions count: 216
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.k0.b.j():void");
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!ExceptionsUtils.addThrowable(this.f53083e, th)) {
                rx.plugins.c.I(th);
            } else {
                this.f53086h = true;
                j();
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53082d.offer(v.j(t5))) {
                j();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }

        void s(long j6) {
            if (j6 > 0) {
                rx.internal.operators.a.b(this.f53084f, j6);
                j();
            } else {
                if (j6 >= 0) {
                    return;
                }
                throw new IllegalStateException("n >= 0 required but it was " + j6);
            }
        }

        public b(rx.l<? super R> lVar, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar, int i6) {
            this.f53079a = lVar;
            this.f53080b = pVar;
            if (i6 == Integer.MAX_VALUE) {
                this.f53081c = Long.MAX_VALUE;
                this.f53082d = new rx.internal.util.atomic.e(rx.internal.util.j.f54163d);
            } else {
                this.f53081c = i6 - (i6 >> 2);
                if (rx.internal.util.unsafe.n0.f()) {
                    this.f53082d = new rx.internal.util.unsafe.z(i6);
                } else {
                    this.f53082d = new rx.internal.util.atomic.d(i6);
                }
            }
            request(i6);
        }

        boolean g(boolean z5, boolean z6, rx.l<?> lVar, Queue<?> queue) {
            if (lVar.isUnsubscribed()) {
                queue.clear();
                this.f53088j = null;
                return true;
            }
            if (z5) {
                if (this.f53083e.get() != null) {
                    Throwable terminate = ExceptionsUtils.terminate(this.f53083e);
                    unsubscribe();
                    queue.clear();
                    this.f53088j = null;
                    lVar.onError(terminate);
                    return true;
                }
                if (z6) {
                    lVar.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T, R> implements e.a<R> {

        /* renamed from: a, reason: collision with root package name */
        final T f53089a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.p<? super T, ? extends Iterable<? extends R>> f53090b;

        @Override // rx.functions.b
        public void call(rx.l<? super R> lVar) {
            try {
                Iterator<? extends R> it = this.f53090b.call(this.f53089a).iterator();
                if (it.hasNext()) {
                    lVar.setProducer(new n0.a(lVar, it));
                } else {
                    lVar.onCompleted();
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, lVar, this.f53089a);
            }
        }

        public c(T t5, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar) {
            this.f53089a = t5;
            this.f53090b = pVar;
        }
    }

    public static <T, R> rx.e<R> a(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar, int i6) {
        return eVar instanceof rx.internal.util.k ? rx.e.I6(new c(((rx.internal.util.k) eVar).y7(), pVar)) : rx.e.I6(new k0(eVar, pVar, i6));
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        b bVar = new b(lVar, this.f53075b, this.f53076c);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        this.f53074a.J6(bVar);
    }

    protected k0(rx.e<? extends T> eVar, rx.functions.p<? super T, ? extends Iterable<? extends R>> pVar, int i6) {
        this.f53074a = eVar;
        this.f53075b = pVar;
        this.f53076c = i6;
    }
}
