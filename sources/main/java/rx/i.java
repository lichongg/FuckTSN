package rx;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import rx.annotations.Experimental;
import rx.e;
import rx.functions.v;
import rx.functions.w;
import rx.functions.x;
import rx.functions.y;
import rx.h;
import rx.internal.operators.a5;
import rx.internal.operators.b5;
import rx.internal.operators.c5;
import rx.internal.operators.d5;
import rx.internal.operators.h4;
import rx.internal.operators.i4;
import rx.internal.operators.j4;
import rx.internal.operators.k4;
import rx.internal.operators.l4;
import rx.internal.operators.m4;
import rx.internal.operators.n4;
import rx.internal.operators.o4;
import rx.internal.operators.p4;
import rx.internal.operators.q4;
import rx.internal.operators.r4;
import rx.internal.operators.s4;
import rx.internal.operators.t4;
import rx.internal.operators.u4;
import rx.internal.operators.v4;
import rx.internal.operators.w4;
import rx.internal.operators.x4;
import rx.internal.operators.y4;
import rx.internal.operators.z4;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i<T> {

    /* renamed from: a, reason: collision with root package name */
    final t<T> f52442a;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f52443a;

        a(x xVar) {
            this.f52443a = xVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52443a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52444b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52445c;

        b(rx.functions.b bVar, rx.functions.b bVar2) {
            this.f52444b = bVar;
            this.f52445c = bVar2;
        }

        @Override // rx.k
        public final void d(T t5) {
            try {
                this.f52445c.call(t5);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.k
        public final void onError(Throwable th) {
            try {
                this.f52444b.call(th);
            } finally {
                unsubscribe();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends rx.k<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.f f52447b;

        c(rx.f fVar) {
            this.f52447b = fVar;
        }

        @Override // rx.k
        public void d(T t5) {
            this.f52447b.onNext(t5);
            this.f52447b.onCompleted();
        }

        @Override // rx.k
        public void onError(Throwable th) {
            this.f52447b.onError(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements t<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f52449a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.k f52451a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ h.a f52452b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: rx.i$d$a$a, reason: collision with other inner class name */
            class C1024a extends rx.k<T> {
                C1024a() {
                }

                @Override // rx.k
                public void d(T t5) {
                    try {
                        a.this.f52451a.d(t5);
                    } finally {
                        a.this.f52452b.unsubscribe();
                    }
                }

                @Override // rx.k
                public void onError(Throwable th) {
                    try {
                        a.this.f52451a.onError(th);
                    } finally {
                        a.this.f52452b.unsubscribe();
                    }
                }
            }

            a(rx.k kVar, h.a aVar) {
                this.f52451a = kVar;
                this.f52452b = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                C1024a c1024a = new C1024a();
                this.f52451a.b(c1024a);
                i.this.j0(c1024a);
            }
        }

        d(rx.h hVar) {
            this.f52449a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            h.a a6 = this.f52449a.a();
            kVar.b(a6);
            a6.d(new a(kVar, a6));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements rx.functions.o<i<T>> {
        e() {
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public i<T> call() {
            return i.y(new TimeoutException());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements rx.functions.b<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52456a;

        f(rx.functions.b bVar) {
            this.f52456a = bVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f52456a.call(th);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements rx.functions.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52458a;

        g(rx.functions.b bVar) {
            this.f52458a = bVar;
        }

        @Override // rx.functions.b
        public void call(T t5) {
            this.f52458a.call(Notification.e(t5));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements rx.functions.b<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.b f52460a;

        h(rx.functions.b bVar) {
            this.f52460a = bVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f52460a.call(Notification.d(th));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.i$i, reason: collision with other inner class name */
    static class C1025i implements t<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callable f52462a;

        C1025i(Callable callable) {
            this.f52462a = callable;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            try {
                ((i) this.f52462a.call()).j0(kVar);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                kVar.onError(th);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements t<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.h f52463a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.k<T> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.k f52465b;

            a(rx.k kVar) {
                this.f52465b = kVar;
            }

            @Override // rx.k
            public void d(T t5) {
                this.f52465b.d(t5);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f52465b.onError(th);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements rx.functions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.k f52467a;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            class a implements rx.functions.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ h.a f52469a;

                a(h.a aVar) {
                    this.f52469a = aVar;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        b.this.f52467a.unsubscribe();
                    } finally {
                        this.f52469a.unsubscribe();
                    }
                }
            }

            b(rx.k kVar) {
                this.f52467a = kVar;
            }

            @Override // rx.functions.a
            public void call() {
                h.a a6 = j.this.f52463a.a();
                a6.d(new a(a6));
            }
        }

        j(rx.h hVar) {
            this.f52463a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            a aVar = new a(kVar);
            kVar.b(rx.subscriptions.f.a(new b(aVar)));
            i.this.j0(aVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class k implements t<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f52471a;

        k(Throwable th) {
            this.f52471a = th;
        }

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            kVar.onError(this.f52471a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class l implements t<T> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.k<i<? extends T>> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ rx.k f52473b;

            a(rx.k kVar) {
                this.f52473b = kVar;
            }

            @Override // rx.k
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void d(i<? extends T> iVar) {
                iVar.j0(this.f52473b);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f52473b.onError(th);
            }
        }

        l() {
        }

        @Override // rx.functions.b
        public void call(rx.k<? super T> kVar) {
            a aVar = new a(kVar);
            kVar.b(aVar);
            i.this.j0(aVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class m<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.q f52475a;

        m(rx.functions.q qVar) {
            this.f52475a = qVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52475a.call(objArr[0], objArr[1]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class n<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.r f52476a;

        n(rx.functions.r rVar) {
            this.f52476a = rVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52476a.call(objArr[0], objArr[1], objArr[2]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class o<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.s f52477a;

        o(rx.functions.s sVar) {
            this.f52477a = sVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52477a.call(objArr[0], objArr[1], objArr[2], objArr[3]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class p<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.t f52478a;

        p(rx.functions.t tVar) {
            this.f52478a = tVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52478a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class q<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.u f52479a;

        q(rx.functions.u uVar) {
            this.f52479a = uVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52479a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class r<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f52480a;

        r(v vVar) {
            this.f52480a = vVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52480a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class s<R> implements y<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f52481a;

        s(w wVar) {
            this.f52481a = wVar;
        }

        @Override // rx.functions.y
        public R call(Object... objArr) {
            return (R) this.f52481a.call(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface t<T> extends rx.functions.b<rx.k<? super T>> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface u<T, R> extends rx.functions.p<i<T>, i<R>> {
    }

    protected i(t<T> tVar) {
        this.f52442a = rx.plugins.c.H(tVar);
    }

    public static <T, Resource> i<T> D0(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends i<? extends T>> pVar, rx.functions.b<? super Resource> bVar) {
        return E0(oVar, pVar, bVar, false);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> i<R> I0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, i<? extends T7> iVar7, v<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> vVar) {
        return y4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7}, new r(vVar));
    }

    public static <T1, T2, T3, T4, T5, T6, R> i<R> J0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, rx.functions.u<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> uVar) {
        return y4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6}, new q(uVar));
    }

    public static <T1, T2, T3, T4, T5, R> i<R> K0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, rx.functions.t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> tVar) {
        return y4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5}, new p(tVar));
    }

    public static <T1, T2, T3, T4, R> i<R> L0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, rx.functions.s<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> sVar) {
        return y4.a(new i[]{iVar, iVar2, iVar3, iVar4}, new o(sVar));
    }

    public static <T1, T2, T3, R> i<R> M0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, rx.functions.r<? super T1, ? super T2, ? super T3, ? extends R> rVar) {
        return y4.a(new i[]{iVar, iVar2, iVar3}, new n(rVar));
    }

    public static <T1, T2, R> i<R> N0(i<? extends T1> iVar, i<? extends T2> iVar2, rx.functions.q<? super T1, ? super T2, ? extends R> qVar) {
        return y4.a(new i[]{iVar, iVar2}, new m(qVar));
    }

    public final rx.m A0(rx.l<? super T> lVar) {
        return B0(lVar, true);
    }

    public final i<T> s0(long j6, TimeUnit timeUnit) {
        return v0(j6, timeUnit, null, rx.schedulers.c.a());
    }

    public final i<T> t0(long j6, TimeUnit timeUnit, rx.h hVar) {
        return v0(j6, timeUnit, null, hVar);
    }

    private rx.m B0(rx.l<? super T> lVar, boolean z5) {
        if (z5) {
            try {
                lVar.onStart();
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                try {
                    lVar.onError(rx.plugins.c.Q(th));
                    return rx.subscriptions.f.e();
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.plugins.c.Q(runtimeException);
                    throw runtimeException;
                }
            }
        }
        rx.plugins.c.T(this, this.f52442a).call(q4.a(lVar));
        return rx.plugins.c.S(lVar);
    }

    public static <T> i<T> C(Future<? extends T> future) {
        return n(new o4(future, 0L, null));
    }

    public static <T> i<T> D(Future<? extends T> future, long j6, TimeUnit timeUnit) {
        if (timeUnit != null) {
            return n(new o4(future, j6, timeUnit));
        }
        throw new NullPointerException("unit is null");
    }

    public static <T, Resource> i<T> E0(rx.functions.o<Resource> oVar, rx.functions.p<? super Resource, ? extends i<? extends T>> pVar, rx.functions.b<? super Resource> bVar, boolean z5) {
        if (oVar == null) {
            throw new NullPointerException("resourceFactory is null");
        }
        if (pVar == null) {
            throw new NullPointerException("singleFactory is null");
        }
        if (bVar != null) {
            return n(new v4(oVar, pVar, bVar, z5));
        }
        throw new NullPointerException("disposeAction is null");
    }

    public static <T> i<T> F(Callable<? extends T> callable) {
        return n(new m4(callable));
    }

    public static <T> i<T> G(rx.functions.b<rx.j<T>> bVar) {
        if (bVar != null) {
            return n(new n4(bVar));
        }
        throw new NullPointerException("producer is null");
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> i<R> G0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, i<? extends T7> iVar7, i<? extends T8> iVar8, i<? extends T9> iVar9, x<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> xVar) {
        return y4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8, iVar9}, new a(xVar));
    }

    static <T> i<? extends T>[] H(Iterable<? extends i<? extends T>> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return (i[]) collection.toArray(new i[collection.size()]);
        }
        i<? extends T>[] iVarArr = new i[8];
        int i6 = 0;
        for (i<? extends T> iVar : iterable) {
            if (i6 == iVarArr.length) {
                i<? extends T>[] iVarArr2 = new i[(i6 >> 2) + i6];
                System.arraycopy(iVarArr, 0, iVarArr2, 0, i6);
                iVarArr = iVarArr2;
            }
            iVarArr[i6] = iVar;
            i6++;
        }
        if (iVarArr.length == i6) {
            return iVarArr;
        }
        i<? extends T>[] iVarArr3 = new i[i6];
        System.arraycopy(iVarArr, 0, iVarArr3, 0, i6);
        return iVarArr3;
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> i<R> H0(i<? extends T1> iVar, i<? extends T2> iVar2, i<? extends T3> iVar3, i<? extends T4> iVar4, i<? extends T5> iVar5, i<? extends T6> iVar6, i<? extends T7> iVar7, i<? extends T8> iVar8, w<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> wVar) {
        return y4.a(new i[]{iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7, iVar8}, new s(wVar));
    }

    public static <T> i<T> V(i<? extends i<? extends T>> iVar) {
        return iVar instanceof rx.internal.util.l ? ((rx.internal.util.l) iVar).R0(rx.internal.util.n.c()) : n(new l());
    }

    private static <T> rx.e<T> a(i<T> iVar) {
        return rx.e.I6(new d5(iVar.f52442a));
    }

    public static <T> i<T> n(t<T> tVar) {
        return new i<>(tVar);
    }

    public static <T> i<T> o(Callable<i<T>> callable) {
        return n(new C1025i(callable));
    }

    public static <T> i<T> y(Throwable th) {
        return n(new k(th));
    }

    public final rx.b A(rx.functions.p<? super T, ? extends rx.b> pVar) {
        return rx.b.p(new rx.internal.operators.i(this, pVar));
    }

    @Experimental
    public final i<T> C0(rx.h hVar) {
        return n(new j(hVar));
    }

    public final <R> i<R> J(e.b<? extends R, ? super T> bVar) {
        return n(new q4(this.f52442a, bVar));
    }

    public final <R> i<R> K(rx.functions.p<? super T, ? extends R> pVar) {
        return n(new u4(this, pVar));
    }

    public final i<T> Z(rx.h hVar) {
        if (this instanceof rx.internal.util.l) {
            return ((rx.internal.util.l) this).S0(hVar);
        }
        if (hVar != null) {
            return n(new r4(this.f52442a, hVar));
        }
        throw new NullPointerException("scheduler is null");
    }

    public final i<T> a0(i<? extends T> iVar) {
        return new i<>(x4.b(this, iVar));
    }

    public final i<T> b0(rx.functions.p<Throwable, ? extends i<? extends T>> pVar) {
        return new i<>(x4.a(this, pVar));
    }

    @Experimental
    public final <R> i<R> c(Class<R> cls) {
        return K(new w4(cls));
    }

    public final i<T> c0(rx.functions.p<Throwable, ? extends T> pVar) {
        return n(new s4(this.f52442a, pVar));
    }

    public final rx.m i0(rx.f<? super T> fVar) {
        if (fVar != null) {
            return j0(new c(fVar));
        }
        throw new NullPointerException("observer is null");
    }

    public final rx.m j0(rx.k<? super T> kVar) {
        if (kVar == null) {
            throw new IllegalArgumentException("te is null");
        }
        try {
            rx.plugins.c.T(this, this.f52442a).call(kVar);
            return rx.plugins.c.S(kVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            try {
                kVar.onError(rx.plugins.c.Q(th));
                return rx.subscriptions.f.b();
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.plugins.c.Q(runtimeException);
                throw runtimeException;
            }
        }
    }

    public final rx.m k0(rx.l<? super T> lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        lVar.onStart();
        return !(lVar instanceof rx.observers.e) ? B0(new rx.observers.e(lVar), false) : B0(lVar, true);
    }

    public final rx.m m0(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        }
        if (bVar2 != null) {
            return j0(new b(bVar2, bVar));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    public final i<T> n0(rx.h hVar) {
        return this instanceof rx.internal.util.l ? ((rx.internal.util.l) this).S0(hVar) : n(new d(hVar));
    }

    public final i<T> o0(rx.b bVar) {
        return n(new z4(this.f52442a, bVar));
    }

    public final <E> i<T> p0(rx.e<? extends E> eVar) {
        return n(new a5(this.f52442a, eVar));
    }

    public final i<T> q(long j6, TimeUnit timeUnit, rx.h hVar) {
        return n(new h4(this.f52442a, j6, timeUnit, hVar));
    }

    public final <E> i<T> q0(i<? extends E> iVar) {
        return n(new b5(this.f52442a, iVar));
    }

    public final i<T> s(rx.functions.a aVar) {
        return n(new i4(this, aVar));
    }

    public final i<T> t(rx.functions.b<Notification<? extends T>> bVar) {
        if (bVar != null) {
            return n(new j4(this, new g(bVar), new h(bVar)));
        }
        throw new IllegalArgumentException("onNotification is null");
    }

    public final i<T> u(rx.functions.b<Throwable> bVar) {
        if (bVar != null) {
            return n(new j4(this, rx.functions.m.a(), new f(bVar)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    public final i<T> v(rx.functions.a aVar) {
        return n(new k4(this.f52442a, aVar));
    }

    public final i<T> v0(long j6, TimeUnit timeUnit, i<? extends T> iVar, rx.h hVar) {
        if (iVar == null) {
            iVar = o(new e());
        }
        return n(new c5(this.f52442a, j6, timeUnit, hVar, iVar.f52442a));
    }

    public final i<T> w(rx.functions.b<? super T> bVar) {
        if (bVar != null) {
            return n(new j4(this, bVar, rx.functions.m.a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    public final i<T> x(rx.functions.a aVar) {
        return n(new l4(this.f52442a, aVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> i<R> z(rx.functions.p<? super T, ? extends i<? extends R>> pVar) {
        return this instanceof rx.internal.util.l ? ((rx.internal.util.l) this).R0(pVar) : V(K(pVar));
    }

    @Deprecated
    protected i(e.a<T> aVar) {
        this.f52442a = rx.plugins.c.H(new p4(aVar));
    }

    public static <T> i<T> E(Future<? extends T> future, rx.h hVar) {
        return C(future).n0(hVar);
    }

    public static <R> i<R> F0(Iterable<? extends i<?>> iterable, y<? extends R> yVar) {
        return y4.a(H(iterable), yVar);
    }

    public static <T> i<T> I(T t5) {
        return rx.internal.util.l.P0(t5);
    }

    public static <T> rx.e<T> L(rx.e<? extends i<? extends T>> eVar) {
        return M(eVar, Integer.MAX_VALUE);
    }

    public static <T> rx.e<T> M(rx.e<? extends i<? extends T>> eVar, int i6) {
        return (rx.e<T>) eVar.q2(rx.internal.util.n.c(), false, i6);
    }

    public static <T> rx.e<T> N(i<? extends T> iVar, i<? extends T> iVar2) {
        return rx.e.j3(a(iVar), a(iVar2));
    }

    public static <T> rx.e<T> O(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3) {
        return rx.e.k3(a(iVar), a(iVar2), a(iVar3));
    }

    public static <T> rx.e<T> P(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4) {
        return rx.e.l3(a(iVar), a(iVar2), a(iVar3), a(iVar4));
    }

    public static <T> rx.e<T> Q(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5) {
        return rx.e.m3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5));
    }

    public static <T> rx.e<T> R(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6) {
        return rx.e.n3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6));
    }

    public static <T> rx.e<T> S(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7) {
        return rx.e.o3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7));
    }

    public static <T> rx.e<T> T(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8) {
        return rx.e.p3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8));
    }

    public static <T> rx.e<T> U(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8, i<? extends T> iVar9) {
        return rx.e.q3(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8), a(iVar9));
    }

    public static <T> rx.e<T> W(rx.e<? extends i<? extends T>> eVar) {
        return M(eVar, Integer.MAX_VALUE);
    }

    public static <T> rx.e<T> X(rx.e<? extends i<? extends T>> eVar, int i6) {
        return (rx.e<T>) eVar.q2(rx.internal.util.n.c(), true, i6);
    }

    public static <T> rx.e<T> e(i<? extends T> iVar, i<? extends T> iVar2) {
        return rx.e.v0(a(iVar), a(iVar2));
    }

    public static <T> rx.e<T> f(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3) {
        return rx.e.w0(a(iVar), a(iVar2), a(iVar3));
    }

    public static <T> rx.e<T> g(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4) {
        return rx.e.x0(a(iVar), a(iVar2), a(iVar3), a(iVar4));
    }

    public static <T> rx.e<T> h(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5) {
        return rx.e.y0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5));
    }

    public static <T> rx.e<T> i(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6) {
        return rx.e.z0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6));
    }

    public static <T> rx.e<T> j(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7) {
        return rx.e.A0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7));
    }

    public static <T> rx.e<T> k(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8) {
        return rx.e.B0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8));
    }

    public static <T> rx.e<T> l(i<? extends T> iVar, i<? extends T> iVar2, i<? extends T> iVar3, i<? extends T> iVar4, i<? extends T> iVar5, i<? extends T> iVar6, i<? extends T> iVar7, i<? extends T> iVar8, i<? extends T> iVar9) {
        return rx.e.C0(a(iVar), a(iVar2), a(iVar3), a(iVar4), a(iVar5), a(iVar6), a(iVar7), a(iVar8), a(iVar9));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> rx.e<R> B(rx.functions.p<? super T, ? extends rx.e<? extends R>> pVar) {
        return rx.e.h3(a(K(pVar)));
    }

    public final <T2, R> i<R> O0(i<? extends T2> iVar, rx.functions.q<? super T, ? super T2, ? extends R> qVar) {
        return N0(this, iVar, qVar);
    }

    public final rx.e<T> Y(i<? extends T> iVar) {
        return N(this, iVar);
    }

    public final i<T> b() {
        return z0().e0(1).D6();
    }

    public <R> i<R> d(u<? super T, ? extends R> uVar) {
        return (i) uVar.call(this);
    }

    public final i<T> d0() {
        return z0().C4().D6();
    }

    public final i<T> e0(long j6) {
        return z0().D4(j6).D6();
    }

    public final i<T> f0(rx.functions.q<Integer, Throwable, Boolean> qVar) {
        return z0().E4(qVar).D6();
    }

    public final i<T> g0(rx.functions.p<rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
        return z0().F4(pVar).D6();
    }

    public final rx.m h0() {
        return m0(rx.functions.m.a(), rx.functions.m.b());
    }

    public final rx.m l0(rx.functions.b<? super T> bVar) {
        return m0(bVar, rx.functions.m.b());
    }

    public final rx.e<T> m(i<? extends T> iVar) {
        return e(this, iVar);
    }

    public final i<T> p(long j6, TimeUnit timeUnit) {
        return q(j6, timeUnit, rx.schedulers.c.a());
    }

    public final i<T> r(rx.e<?> eVar) {
        eVar.getClass();
        return n(new t4(this, eVar));
    }

    public final i<T> u0(long j6, TimeUnit timeUnit, i<? extends T> iVar) {
        return v0(j6, timeUnit, iVar, rx.schedulers.c.a());
    }

    public final <R> R w0(rx.functions.p<? super i<T>, R> pVar) {
        return pVar.call(this);
    }

    public final rx.singles.a<T> x0() {
        return rx.singles.a.a(this);
    }

    public final rx.b y0() {
        return rx.b.K(this);
    }

    public final rx.e<T> z0() {
        return a(this);
    }

    public final rx.observers.a<T> r0() {
        l5.a g6 = l5.a.g(Long.MAX_VALUE);
        k0(g6);
        return g6;
    }
}
