package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.l;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class c<T> extends f<T, T> {

    /* renamed from: b, reason: collision with root package name */
    final b<T> f54501b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends AtomicLong implements rx.g, m, rx.f<T> {
        private static final long serialVersionUID = 6451806817170721536L;

        /* renamed from: a, reason: collision with root package name */
        final b<T> f54502a;

        /* renamed from: b, reason: collision with root package name */
        final l<? super T> f54503b;

        /* renamed from: c, reason: collision with root package name */
        long f54504c;

        @Override // rx.m
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f54502a.e(this);
            }
        }

        public a(b<T> bVar, l<? super T> lVar) {
            this.f54502a = bVar;
            this.f54503b = lVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // rx.f
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.f54503b.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f54503b.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t5) {
            long j6 = get();
            if (j6 != Long.MIN_VALUE) {
                long j7 = this.f54504c;
                if (j6 != j7) {
                    this.f54504c = j7 + 1;
                    this.f54503b.onNext(t5);
                } else {
                    unsubscribe();
                    this.f54503b.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
                }
            }
        }

        @Override // rx.g
        public void request(long j6) {
            long j7;
            if (rx.internal.operators.a.j(j6)) {
                do {
                    j7 = get();
                    if (j7 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j7, rx.internal.operators.a.a(j7, j6)));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends AtomicReference<a<T>[]> implements e.a<T>, rx.f<T> {

        /* renamed from: b, reason: collision with root package name */
        static final a[] f54505b = new a[0];

        /* renamed from: c, reason: collision with root package name */
        static final a[] f54506c = new a[0];
        private static final long serialVersionUID = -7568940796666027140L;

        /* renamed from: a, reason: collision with root package name */
        Throwable f54507a;

        @Override // rx.functions.b
        public void call(l<? super T> lVar) {
            a<T> aVar = new a<>(this, lVar);
            lVar.add(aVar);
            lVar.setProducer(aVar);
            if (d(aVar)) {
                if (aVar.isUnsubscribed()) {
                    e(aVar);
                }
            } else {
                Throwable th = this.f54507a;
                if (th != null) {
                    lVar.onError(th);
                } else {
                    lVar.onCompleted();
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            for (a<T> aVar : getAndSet(f54506c)) {
                aVar.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f54507a = th;
            ArrayList arrayList = null;
            for (a<T> aVar : getAndSet(f54506c)) {
                try {
                    aVar.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }

        public b() {
            lazySet(f54505b);
        }

        boolean d(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f54506c) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        void e(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr != f54506c && aVarArr != f54505b) {
                    int length = aVarArr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            if (aVarArr[i6] == aVar) {
                                break;
                            } else {
                                i6++;
                            }
                        } else {
                            i6 = -1;
                            break;
                        }
                    }
                    if (i6 >= 0) {
                        if (length == 1) {
                            aVarArr2 = f54505b;
                        } else {
                            a[] aVarArr3 = new a[length - 1];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i6);
                            System.arraycopy(aVarArr, i6 + 1, aVarArr3, i6, (length - i6) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // rx.f
        public void onNext(T t5) {
            for (a<T> aVar : get()) {
                aVar.onNext(t5);
            }
        }
    }

    public static <T> c<T> y7() {
        return new c<>(new b());
    }

    public boolean A7() {
        return this.f54501b.get() == b.f54506c && this.f54501b.f54507a == null;
    }

    public boolean B7() {
        return this.f54501b.get() == b.f54506c && this.f54501b.f54507a != null;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f54501b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54501b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54501b.onNext(t5);
    }

    @Override // rx.subjects.f
    public boolean w7() {
        return this.f54501b.get().length != 0;
    }

    public Throwable z7() {
        if (this.f54501b.get() == b.f54506c) {
            return this.f54501b.f54507a;
        }
        return null;
    }

    protected c(b<T> bVar) {
        super(bVar);
        this.f54501b = bVar;
    }
}
