package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e4<T, R> implements e.a<R> {

    /* renamed from: a, reason: collision with root package name */
    final rx.e<T> f52740a;

    /* renamed from: b, reason: collision with root package name */
    final rx.e<?>[] f52741b;

    /* renamed from: c, reason: collision with root package name */
    final Iterable<rx.e<?>> f52742c;

    /* renamed from: d, reason: collision with root package name */
    final rx.functions.y<R> f52743d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> extends rx.l<T> {

        /* renamed from: f, reason: collision with root package name */
        static final Object f52744f = new Object();

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super R> f52745a;

        /* renamed from: b, reason: collision with root package name */
        final rx.functions.y<R> f52746b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceArray<Object> f52747c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicInteger f52748d;

        /* renamed from: e, reason: collision with root package name */
        boolean f52749e;

        void g(int i6) {
            if (this.f52747c.get(i6) == f52744f) {
                onCompleted();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f52749e) {
                return;
            }
            this.f52749e = true;
            unsubscribe();
            this.f52745a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f52749e) {
                rx.plugins.c.I(th);
                return;
            }
            this.f52749e = true;
            unsubscribe();
            this.f52745a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t5) {
            if (this.f52749e) {
                return;
            }
            if (this.f52748d.get() != 0) {
                request(1L);
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.f52747c;
            int length = atomicReferenceArray.length();
            atomicReferenceArray.lazySet(0, t5);
            Object[] objArr = new Object[atomicReferenceArray.length()];
            for (int i6 = 0; i6 < length; i6++) {
                objArr[i6] = atomicReferenceArray.get(i6);
            }
            try {
                this.f52745a.onNext(this.f52746b.call(objArr));
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                onError(th);
            }
        }

        void s(int i6, Object obj) {
            if (this.f52747c.getAndSet(i6, obj) == f52744f) {
                this.f52748d.decrementAndGet();
            }
        }

        public a(rx.l<? super R> lVar, rx.functions.y<R> yVar, int i6) {
            this.f52745a = lVar;
            this.f52746b = yVar;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i6 + 1);
            for (int i7 = 0; i7 <= i6; i7++) {
                atomicReferenceArray.lazySet(i7, f52744f);
            }
            this.f52747c = atomicReferenceArray;
            this.f52748d = new AtomicInteger(i6);
            request(0L);
        }

        void j(int i6, Throwable th) {
            onError(th);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            super.setProducer(gVar);
            this.f52745a.setProducer(gVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends rx.l<Object> {

        /* renamed from: a, reason: collision with root package name */
        final a<?, ?> f52750a;

        /* renamed from: b, reason: collision with root package name */
        final int f52751b;

        @Override // rx.f
        public void onCompleted() {
            this.f52750a.g(this.f52751b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f52750a.j(this.f52751b, th);
        }

        @Override // rx.f
        public void onNext(Object obj) {
            this.f52750a.s(this.f52751b, obj);
        }

        public b(a<?, ?> aVar, int i6) {
            this.f52750a = aVar;
            this.f52751b = i6;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super R> lVar) {
        int i6;
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.e<?>[] eVarArr = this.f52741b;
        int i7 = 0;
        if (eVarArr != null) {
            i6 = eVarArr.length;
        } else {
            eVarArr = new rx.e[8];
            int i8 = 0;
            for (rx.e<?> eVar : this.f52742c) {
                if (i8 == eVarArr.length) {
                    eVarArr = (rx.e[]) Arrays.copyOf(eVarArr, (i8 >> 2) + i8);
                }
                eVarArr[i8] = eVar;
                i8++;
            }
            i6 = i8;
        }
        a aVar = new a(lVar, this.f52743d, i6);
        gVar.add(aVar);
        while (i7 < i6) {
            if (gVar.isUnsubscribed()) {
                return;
            }
            int i9 = i7 + 1;
            b bVar = new b(aVar, i9);
            aVar.add(bVar);
            eVarArr[i7].J6(bVar);
            i7 = i9;
        }
        this.f52740a.J6(aVar);
    }

    public e4(rx.e<T> eVar, rx.e<?>[] eVarArr, Iterable<rx.e<?>> iterable, rx.functions.y<R> yVar) {
        this.f52740a = eVar;
        this.f52741b = eVarArr;
        this.f52742c = iterable;
        this.f52743d = yVar;
    }
}
