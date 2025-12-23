package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.OnErrorThrowable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w2<T> extends rx.observables.c<T> implements rx.m {

    /* renamed from: e, reason: collision with root package name */
    static final rx.functions.o f53708e = new a();

    /* renamed from: b, reason: collision with root package name */
    final rx.e<? extends T> f53709b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<l<T>> f53710c;

    /* renamed from: d, reason: collision with root package name */
    final rx.functions.o<? extends k<T>> f53711d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements rx.functions.o {
        @Override // rx.functions.o, java.util.concurrent.Callable
        public Object call() {
            return new o(16);
        }

        a() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b<R> implements e.a<R> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.functions.o f53712a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.p f53713b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.b<rx.m> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.l f53714a;

            a(rx.l lVar) {
                this.f53714a = lVar;
            }

            @Override // rx.functions.b
            public void call(rx.m mVar) {
                this.f53714a.add(mVar);
            }
        }

        b(rx.functions.o oVar, rx.functions.p pVar) {
            this.f53712a = oVar;
            this.f53713b = pVar;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super R> lVar) {
            try {
                rx.observables.c cVar = (rx.observables.c) this.f53712a.call();
                ((rx.e) this.f53713b.call(cVar)).r5(lVar);
                cVar.A7(new a(lVar));
            } catch (Throwable th) {
                rx.exceptions.a.f(th, lVar);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ rx.e f53716a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends rx.l<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ rx.l f53717a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(rx.l lVar, rx.l lVar2) {
                super(lVar);
                this.f53717a = lVar2;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f53717a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f53717a.onError(th);
            }

            @Override // rx.f
            public void onNext(T t5) {
                this.f53717a.onNext(t5);
            }
        }

        c(rx.e eVar) {
            this.f53716a = eVar;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            this.f53716a.J6(new a(lVar, lVar));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends rx.observables.c<T> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.observables.c f53719b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(e.a aVar, rx.observables.c cVar) {
            super(aVar);
            this.f53719b = cVar;
        }

        @Override // rx.observables.c
        public void A7(rx.functions.b<? super rx.m> bVar) {
            this.f53719b.A7(bVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class e implements rx.functions.o<k<T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f53720a;

        e(int i6) {
            this.f53720a = i6;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public k<T> call() {
            return new n(this.f53720a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class f implements rx.functions.o<k<T>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f53721a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f53722b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ rx.h f53723c;

        f(int i6, long j6, rx.h hVar) {
            this.f53721a = i6;
            this.f53722b = j6;
            this.f53723c = hVar;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public k<T> call() {
            return new m(this.f53721a, this.f53722b, this.f53723c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class g implements e.a<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f53724a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ rx.functions.o f53725b;

        g(AtomicReference atomicReference, rx.functions.o oVar) {
            this.f53724a = atomicReference;
            this.f53725b = oVar;
        }

        @Override // rx.functions.b
        public void call(rx.l<? super T> lVar) {
            l lVar2;
            while (true) {
                lVar2 = (l) this.f53724a.get();
                if (lVar2 != null) {
                    break;
                }
                l lVar3 = new l((k) this.f53725b.call());
                lVar3.s();
                if (androidx.camera.view.p.a(this.f53724a, lVar2, lVar3)) {
                    lVar2 = lVar3;
                    break;
                }
            }
            i<T> iVar = new i<>(lVar2, lVar);
            lVar2.g(iVar);
            lVar.add(iVar);
            lVar2.f53740a.a(iVar);
            lVar.setProducer(iVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class h<T> extends AtomicReference<j> implements k<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: a, reason: collision with root package name */
        j f53726a;

        /* renamed from: b, reason: collision with root package name */
        int f53727b;

        /* renamed from: c, reason: collision with root package name */
        long f53728c;

        @Override // rx.internal.operators.w2.k
        public final void a(i<T> iVar) {
            rx.l<? super T> lVar;
            j jVar;
            synchronized (iVar) {
                try {
                    if (iVar.f53734e) {
                        iVar.f53735f = true;
                        return;
                    }
                    iVar.f53734e = true;
                    while (!iVar.isUnsubscribed()) {
                        j jVar2 = (j) iVar.b();
                        if (jVar2 == null) {
                            jVar2 = e();
                            iVar.f53732c = jVar2;
                            iVar.a(jVar2.f53737b);
                        }
                        if (iVar.isUnsubscribed() || (lVar = iVar.f53731b) == null) {
                            return;
                        }
                        long j6 = iVar.get();
                        long j7 = 0;
                        while (j7 != j6 && (jVar = jVar2.get()) != null) {
                            Object h6 = h(jVar.f53736a);
                            try {
                                if (v.a(lVar, h6)) {
                                    iVar.f53732c = null;
                                    return;
                                }
                                j7++;
                                if (iVar.isUnsubscribed()) {
                                    return;
                                } else {
                                    jVar2 = jVar;
                                }
                            } catch (Throwable th) {
                                iVar.f53732c = null;
                                rx.exceptions.a.e(th);
                                iVar.unsubscribe();
                                if (v.g(h6) || v.f(h6)) {
                                    return;
                                }
                                lVar.onError(OnErrorThrowable.addValueAsLastCause(th, v.e(h6)));
                                return;
                            }
                        }
                        if (j7 != 0) {
                            iVar.f53732c = jVar2;
                            if (j6 != Long.MAX_VALUE) {
                                iVar.d(j7);
                            }
                        }
                        synchronized (iVar) {
                            try {
                                if (!iVar.f53735f) {
                                    iVar.f53734e = false;
                                    return;
                                }
                                iVar.f53735f = false;
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        final void b(j jVar) {
            this.f53726a.set(jVar);
            this.f53726a = jVar;
            this.f53727b++;
        }

        boolean f() {
            Object obj = this.f53726a.f53736a;
            return obj != null && v.f(h(obj));
        }

        boolean g() {
            Object obj = this.f53726a.f53736a;
            return obj != null && v.g(h(obj));
        }

        public h() {
            j jVar = new j(null, 0L);
            this.f53726a = jVar;
            set(jVar);
        }

        final void c(Collection<? super T> collection) {
            j e6 = e();
            while (true) {
                e6 = e6.get();
                if (e6 != null) {
                    Object h6 = h(e6.f53736a);
                    if (!v.f(h6) && !v.g(h6)) {
                        collection.add((Object) v.e(h6));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // rx.internal.operators.w2.k
        public final void complete() {
            Object d6 = d(v.b());
            long j6 = this.f53728c + 1;
            this.f53728c = j6;
            b(new j(d6, j6));
            m();
        }

        j e() {
            return get();
        }

        @Override // rx.internal.operators.w2.k
        public final void error(Throwable th) {
            Object d6 = d(v.c(th));
            long j6 = this.f53728c + 1;
            this.f53728c = j6;
            b(new j(d6, j6));
            m();
        }

        final void i() {
            j jVar = get().get();
            if (jVar != null) {
                this.f53727b--;
                k(jVar);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        final void j(int i6) {
            j jVar = get();
            while (i6 > 0) {
                jVar = jVar.get();
                i6--;
                this.f53727b--;
            }
            k(jVar);
        }

        final void k(j jVar) {
            set(jVar);
        }

        @Override // rx.internal.operators.w2.k
        public final void next(T t5) {
            Object d6 = d(v.j(t5));
            long j6 = this.f53728c + 1;
            this.f53728c = j6;
            b(new j(d6, j6));
            l();
        }

        void l() {
        }

        void m() {
        }

        Object d(Object obj) {
            return obj;
        }

        Object h(Object obj) {
            return obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class i<T> extends AtomicLong implements rx.g, rx.m {

        /* renamed from: g, reason: collision with root package name */
        static final long f53729g = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: a, reason: collision with root package name */
        final l<T> f53730a;

        /* renamed from: b, reason: collision with root package name */
        rx.l<? super T> f53731b;

        /* renamed from: c, reason: collision with root package name */
        Object f53732c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicLong f53733d = new AtomicLong();

        /* renamed from: e, reason: collision with root package name */
        boolean f53734e;

        /* renamed from: f, reason: collision with root package name */
        boolean f53735f;

        void a(long j6) {
            long j7;
            long j8;
            do {
                j7 = this.f53733d.get();
                j8 = j7 + j6;
                if (j8 < 0) {
                    j8 = Long.MAX_VALUE;
                }
            } while (!this.f53733d.compareAndSet(j7, j8));
        }

        <U> U b() {
            return (U) this.f53732c;
        }

        public long d(long j6) {
            long j7;
            long j8;
            if (j6 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j7 = get();
                if (j7 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j8 = j7 - j6;
                if (j8 < 0) {
                    throw new IllegalStateException("More produced (" + j6 + ") than requested (" + j7 + ")");
                }
            } while (!compareAndSet(j7, j8));
            return j8;
        }

        @Override // rx.g
        public void request(long j6) {
            long j7;
            long j8;
            if (j6 < 0) {
                return;
            }
            do {
                j7 = get();
                if (j7 == Long.MIN_VALUE) {
                    return;
                }
                if (j7 >= 0 && j6 == 0) {
                    return;
                }
                j8 = j7 + j6;
                if (j8 < 0) {
                    j8 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j7, j8));
            a(j6);
            this.f53730a.B(this);
            this.f53730a.f53740a.a(this);
        }

        public i(l<T> lVar, rx.l<? super T> lVar2) {
            this.f53730a = lVar;
            this.f53731b = lVar2;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f53730a.G(this);
                this.f53730a.B(this);
                this.f53731b = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface k<T> {
        void a(i<T> iVar);

        void complete();

        void error(Throwable th);

        void next(T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class l<T> extends rx.l<T> implements rx.m {

        /* renamed from: p, reason: collision with root package name */
        static final i[] f53738p = new i[0];

        /* renamed from: q, reason: collision with root package name */
        static final i[] f53739q = new i[0];

        /* renamed from: a, reason: collision with root package name */
        final k<T> f53740a;

        /* renamed from: b, reason: collision with root package name */
        boolean f53741b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f53742c;

        /* renamed from: f, reason: collision with root package name */
        volatile long f53745f;

        /* renamed from: g, reason: collision with root package name */
        long f53746g;

        /* renamed from: i, reason: collision with root package name */
        boolean f53748i;

        /* renamed from: j, reason: collision with root package name */
        boolean f53749j;

        /* renamed from: k, reason: collision with root package name */
        long f53750k;

        /* renamed from: l, reason: collision with root package name */
        long f53751l;

        /* renamed from: m, reason: collision with root package name */
        volatile rx.g f53752m;

        /* renamed from: n, reason: collision with root package name */
        List<i<T>> f53753n;

        /* renamed from: o, reason: collision with root package name */
        boolean f53754o;

        /* renamed from: d, reason: collision with root package name */
        final rx.internal.util.h<i<T>> f53743d = new rx.internal.util.h<>();

        /* renamed from: e, reason: collision with root package name */
        i<T>[] f53744e = f53738p;

        /* renamed from: h, reason: collision with root package name */
        final AtomicBoolean f53747h = new AtomicBoolean();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                if (l.this.f53742c) {
                    return;
                }
                synchronized (l.this.f53743d) {
                    try {
                        if (!l.this.f53742c) {
                            l.this.f53743d.h();
                            l.this.f53745f++;
                            l.this.f53742c = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        void A(long j6, long j7) {
            long j8 = this.f53751l;
            rx.g gVar = this.f53752m;
            long j9 = j6 - j7;
            if (j9 == 0) {
                if (j8 == 0 || gVar == null) {
                    return;
                }
                this.f53751l = 0L;
                gVar.request(j8);
                return;
            }
            this.f53750k = j6;
            if (gVar == null) {
                long j10 = j8 + j9;
                if (j10 < 0) {
                    j10 = Long.MAX_VALUE;
                }
                this.f53751l = j10;
                return;
            }
            if (j8 == 0) {
                gVar.request(j9);
            } else {
                this.f53751l = 0L;
                gVar.request(j8 + j9);
            }
        }

        void G(i<T> iVar) {
            if (this.f53742c) {
                return;
            }
            synchronized (this.f53743d) {
                try {
                    if (this.f53742c) {
                        return;
                    }
                    this.f53743d.f(iVar);
                    if (this.f53743d.c()) {
                        this.f53744e = f53738p;
                    }
                    this.f53745f++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void H() {
            i<T>[] iVarArr = this.f53744e;
            if (this.f53746g != this.f53745f) {
                synchronized (this.f53743d) {
                    try {
                        iVarArr = this.f53744e;
                        i<T>[] i6 = this.f53743d.i();
                        int length = i6.length;
                        if (iVarArr.length != length) {
                            iVarArr = new i[length];
                            this.f53744e = iVarArr;
                        }
                        System.arraycopy(i6, 0, iVarArr, 0, length);
                        this.f53746g = this.f53745f;
                    } finally {
                    }
                }
            }
            k<T> kVar = this.f53740a;
            for (i<T> iVar : iVarArr) {
                if (iVar != null) {
                    kVar.a(iVar);
                }
            }
        }

        i<T>[] j() {
            i<T>[] iVarArr;
            synchronized (this.f53743d) {
                i<T>[] i6 = this.f53743d.i();
                int length = i6.length;
                iVarArr = new i[length];
                System.arraycopy(i6, 0, iVarArr, 0, length);
            }
            return iVarArr;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f53741b) {
                return;
            }
            this.f53741b = true;
            try {
                this.f53740a.complete();
                H();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f53741b) {
                return;
            }
            this.f53741b = true;
            try {
                this.f53740a.error(th);
                H();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f53741b) {
                return;
            }
            this.f53740a.next(t5);
            H();
        }

        void s() {
            add(rx.subscriptions.f.a(new a()));
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            if (this.f53752m != null) {
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
            this.f53752m = gVar;
            B(null);
            H();
        }

        public l(k<T> kVar) {
            this.f53740a = kVar;
            request(0L);
        }

        void B(i<T> iVar) {
            long j6;
            List<i<T>> list;
            boolean z5;
            long j7;
            if (!isUnsubscribed()) {
                synchronized (this) {
                    try {
                        if (this.f53748i) {
                            if (iVar != null) {
                                List list2 = this.f53753n;
                                if (list2 == null) {
                                    list2 = new ArrayList();
                                    this.f53753n = list2;
                                }
                                list2.add(iVar);
                            } else {
                                this.f53754o = true;
                            }
                            this.f53749j = true;
                            return;
                        }
                        this.f53748i = true;
                        long j8 = this.f53750k;
                        if (iVar != null) {
                            j6 = Math.max(j8, iVar.f53733d.get());
                        } else {
                            long j9 = j8;
                            for (i<T> iVar2 : j()) {
                                if (iVar2 != null) {
                                    j9 = Math.max(j9, iVar2.f53733d.get());
                                }
                            }
                            j6 = j9;
                        }
                        A(j6, j8);
                        while (!isUnsubscribed()) {
                            synchronized (this) {
                                try {
                                    if (!this.f53749j) {
                                        this.f53748i = false;
                                        return;
                                    }
                                    this.f53749j = false;
                                    list = this.f53753n;
                                    this.f53753n = null;
                                    z5 = this.f53754o;
                                    this.f53754o = false;
                                } finally {
                                }
                            }
                            long j10 = this.f53750k;
                            if (list != null) {
                                Iterator<i<T>> it = list.iterator();
                                j7 = j10;
                                while (it.hasNext()) {
                                    j7 = Math.max(j7, it.next().f53733d.get());
                                }
                            } else {
                                j7 = j10;
                            }
                            if (z5) {
                                for (i<T> iVar3 : j()) {
                                    if (iVar3 != null) {
                                        j7 = Math.max(j7, iVar3.f53733d.get());
                                    }
                                }
                            }
                            A(j7, j10);
                        }
                    } finally {
                    }
                }
            }
        }

        boolean g(i<T> iVar) {
            iVar.getClass();
            if (this.f53742c) {
                return false;
            }
            synchronized (this.f53743d) {
                try {
                    if (this.f53742c) {
                        return false;
                    }
                    this.f53743d.a(iVar);
                    this.f53745f++;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class m<T> extends h<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: d, reason: collision with root package name */
        final rx.h f53756d;

        /* renamed from: e, reason: collision with root package name */
        final long f53757e;

        /* renamed from: f, reason: collision with root package name */
        final int f53758f;

        @Override // rx.internal.operators.w2.h
        Object d(Object obj) {
            return new rx.schedulers.f(this.f53756d.b(), obj);
        }

        @Override // rx.internal.operators.w2.h
        j e() {
            j jVar;
            long b6 = this.f53756d.b() - this.f53757e;
            j jVar2 = get();
            j jVar3 = jVar2.get();
            while (true) {
                j jVar4 = jVar3;
                jVar = jVar2;
                jVar2 = jVar4;
                if (jVar2 == null) {
                    break;
                }
                Object obj = jVar2.f53736a;
                Object h6 = h(obj);
                if (v.f(h6) || v.g(h6) || ((rx.schedulers.f) obj).a() > b6) {
                    break;
                }
                jVar3 = jVar2.get();
            }
            return jVar;
        }

        @Override // rx.internal.operators.w2.h
        Object h(Object obj) {
            return ((rx.schedulers.f) obj).b();
        }

        @Override // rx.internal.operators.w2.h
        void l() {
            j jVar;
            long b6 = this.f53756d.b() - this.f53757e;
            j jVar2 = get();
            j jVar3 = jVar2.get();
            int i6 = 0;
            while (true) {
                j jVar4 = jVar3;
                jVar = jVar2;
                jVar2 = jVar4;
                if (jVar2 != null) {
                    int i7 = this.f53727b;
                    if (i7 <= this.f53758f) {
                        if (((rx.schedulers.f) jVar2.f53736a).a() > b6) {
                            break;
                        }
                        i6++;
                        this.f53727b--;
                        jVar3 = jVar2.get();
                    } else {
                        i6++;
                        this.f53727b = i7 - 1;
                        jVar3 = jVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i6 != 0) {
                k(jVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
        
            k(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        
            return;
         */
        @Override // rx.internal.operators.w2.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m() {
            /*
                r10 = this;
                rx.h r0 = r10.f53756d
                long r0 = r0.b()
                long r2 = r10.f53757e
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                rx.internal.operators.w2$j r2 = (rx.internal.operators.w2.j) r2
                java.lang.Object r3 = r2.get()
                rx.internal.operators.w2$j r3 = (rx.internal.operators.w2.j) r3
                r4 = 0
            L16:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L3a
                int r5 = r10.f53727b
                r6 = 1
                if (r5 <= r6) goto L3a
                java.lang.Object r5 = r2.f53736a
                rx.schedulers.f r5 = (rx.schedulers.f) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L3a
                int r4 = r4 + 1
                int r3 = r10.f53727b
                int r3 = r3 - r6
                r10.f53727b = r3
                java.lang.Object r3 = r2.get()
                rx.internal.operators.w2$j r3 = (rx.internal.operators.w2.j) r3
                goto L16
            L3a:
                if (r4 == 0) goto L3f
                r10.k(r3)
            L3f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.w2.m.m():void");
        }

        public m(int i6, long j6, rx.h hVar) {
            this.f53756d = hVar;
            this.f53758f = i6;
            this.f53757e = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class n<T> extends h<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: d, reason: collision with root package name */
        final int f53759d;

        @Override // rx.internal.operators.w2.h
        void l() {
            if (this.f53727b > this.f53759d) {
                i();
            }
        }

        public n(int i6) {
            this.f53759d = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class j extends AtomicReference<j> {
        private static final long serialVersionUID = 245354315435971818L;

        /* renamed from: a, reason: collision with root package name */
        final Object f53736a;

        /* renamed from: b, reason: collision with root package name */
        final long f53737b;

        public j(Object obj, long j6) {
            this.f53736a = obj;
            this.f53737b = j6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class o<T> extends ArrayList<Object> implements k<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: a, reason: collision with root package name */
        volatile int f53760a;

        @Override // rx.internal.operators.w2.k
        public void a(i<T> iVar) {
            synchronized (iVar) {
                try {
                    if (iVar.f53734e) {
                        iVar.f53735f = true;
                        return;
                    }
                    iVar.f53734e = true;
                    while (!iVar.isUnsubscribed()) {
                        int i6 = this.f53760a;
                        Integer num = (Integer) iVar.b();
                        int intValue = num != null ? num.intValue() : 0;
                        rx.l<? super T> lVar = iVar.f53731b;
                        if (lVar == null) {
                            return;
                        }
                        long j6 = iVar.get();
                        long j7 = 0;
                        while (j7 != j6 && intValue < i6) {
                            Object obj = get(intValue);
                            try {
                                if (v.a(lVar, obj) || iVar.isUnsubscribed()) {
                                    return;
                                }
                                intValue++;
                                j7++;
                            } catch (Throwable th) {
                                rx.exceptions.a.e(th);
                                iVar.unsubscribe();
                                if (v.g(obj) || v.f(obj)) {
                                    return;
                                }
                                lVar.onError(OnErrorThrowable.addValueAsLastCause(th, v.e(obj)));
                                return;
                            }
                        }
                        if (j7 != 0) {
                            iVar.f53732c = Integer.valueOf(intValue);
                            if (j6 != Long.MAX_VALUE) {
                                iVar.d(j7);
                            }
                        }
                        synchronized (iVar) {
                            try {
                                if (!iVar.f53735f) {
                                    iVar.f53734e = false;
                                    return;
                                }
                                iVar.f53735f = false;
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public o(int i6) {
            super(i6);
        }

        @Override // rx.internal.operators.w2.k
        public void complete() {
            add(v.b());
            this.f53760a++;
        }

        @Override // rx.internal.operators.w2.k
        public void error(Throwable th) {
            add(v.c(th));
            this.f53760a++;
        }

        @Override // rx.internal.operators.w2.k
        public void next(T t5) {
            add(v.j(t5));
            this.f53760a++;
        }
    }

    public static <T> rx.observables.c<T> C7(rx.e<? extends T> eVar) {
        return G7(eVar, f53708e);
    }

    static <T> rx.observables.c<T> G7(rx.e<? extends T> eVar, rx.functions.o<? extends k<T>> oVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new w2(new g(atomicReference, oVar), eVar, atomicReference, oVar);
    }

    public static <T, U, R> rx.e<R> H7(rx.functions.o<? extends rx.observables.c<U>> oVar, rx.functions.p<? super rx.e<U>, ? extends rx.e<R>> pVar) {
        return rx.e.I6(new b(oVar, pVar));
    }

    @Override // rx.observables.c
    public void A7(rx.functions.b<? super rx.m> bVar) {
        l<T> lVar;
        while (true) {
            lVar = this.f53710c.get();
            if (lVar != null && !lVar.isUnsubscribed()) {
                break;
            }
            l<T> lVar2 = new l<>(this.f53711d.call());
            lVar2.s();
            if (androidx.camera.view.p.a(this.f53710c, lVar, lVar2)) {
                lVar = lVar2;
                break;
            }
        }
        boolean z5 = false;
        if (!lVar.f53747h.get() && lVar.f53747h.compareAndSet(false, true)) {
            z5 = true;
        }
        bVar.call(lVar);
        if (z5) {
            this.f53709b.J6(lVar);
        }
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        l<T> lVar = this.f53710c.get();
        return lVar == null || lVar.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f53710c.lazySet(null);
    }

    private w2(e.a<T> aVar, rx.e<? extends T> eVar, AtomicReference<l<T>> atomicReference, rx.functions.o<? extends k<T>> oVar) {
        super(aVar);
        this.f53709b = eVar;
        this.f53710c = atomicReference;
        this.f53711d = oVar;
    }

    public static <T> rx.observables.c<T> D7(rx.e<? extends T> eVar, int i6) {
        if (i6 == Integer.MAX_VALUE) {
            return C7(eVar);
        }
        return G7(eVar, new e(i6));
    }

    public static <T> rx.observables.c<T> E7(rx.e<? extends T> eVar, long j6, TimeUnit timeUnit, rx.h hVar) {
        return F7(eVar, j6, timeUnit, hVar, Integer.MAX_VALUE);
    }

    public static <T> rx.observables.c<T> F7(rx.e<? extends T> eVar, long j6, TimeUnit timeUnit, rx.h hVar, int i6) {
        return G7(eVar, new f(i6, timeUnit.toMillis(j6), hVar));
    }

    public static <T> rx.observables.c<T> I7(rx.observables.c<T> cVar, rx.h hVar) {
        return new d(new c(cVar.I3(hVar)), cVar);
    }
}
