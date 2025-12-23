package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.e;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.o1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public enum InternalObservableUtils {
    ;

    public static final h LONG_COUNTER = new h();
    public static final f OBJECT_EQUALS = new f();
    public static final q TO_ARRAY = new q();
    static final o RETURNS_VOID = new o();
    public static final g COUNTER = new g();
    static final e ERROR_EXTRACTOR = new e();
    public static final rx.functions.b<Throwable> ERROR_NOT_IMPLEMENTED = new rx.functions.b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        @Override // rx.functions.b
        public void call(Throwable th) {
            throw new OnErrorNotImplementedException(th);
        }
    };
    public static final e.b<Boolean, Object> IS_EMPTY = new o1(rx.internal.util.n.b(), true);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T, R> implements rx.functions.q<R, T, R> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.c<R, ? super T> f54084a;

        @Override // rx.functions.q
        public R call(R r5, T t5) {
            this.f54084a.call(r5, t5);
            return r5;
        }

        public a(rx.functions.c<R, ? super T> cVar) {
            this.f54084a = cVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements rx.functions.p<Object, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final Object f54085a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            Object obj2 = this.f54085a;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }

        public b(Object obj) {
            this.f54085a = obj;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d implements rx.functions.p<Object, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final Class<?> f54086a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f54086a.isInstance(obj));
        }

        public d(Class<?> cls) {
            this.f54086a = cls;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e implements rx.functions.p<Notification<?>, Throwable> {
        @Override // rx.functions.p
        public Throwable call(Notification<?> notification) {
            return notification.g();
        }

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f implements rx.functions.q<Object, Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.q
        public Boolean call(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g implements rx.functions.q<Integer, Object, Integer> {
        @Override // rx.functions.q
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }

        g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h implements rx.functions.q<Long, Object, Long> {
        @Override // rx.functions.q
        public Long call(Long l6, Object obj) {
            return Long.valueOf(l6.longValue() + 1);
        }

        h() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class i implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> f54087a;

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return this.f54087a.call(eVar.c3(InternalObservableUtils.RETURNS_VOID));
        }

        public i(rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> pVar) {
            this.f54087a = pVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class j<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.e<T> f54088a;

        /* renamed from: b, reason: collision with root package name */
        private final int f54089b;

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f54088a.v4(this.f54089b);
        }

        j(rx.e<T> eVar, int i6) {
            this.f54088a = eVar;
            this.f54089b = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class k<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final TimeUnit f54090a;

        /* renamed from: b, reason: collision with root package name */
        private final rx.e<T> f54091b;

        /* renamed from: c, reason: collision with root package name */
        private final long f54092c;

        /* renamed from: d, reason: collision with root package name */
        private final rx.h f54093d;

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f54091b.A4(this.f54092c, this.f54090a, this.f54093d);
        }

        k(rx.e<T> eVar, long j6, TimeUnit timeUnit, rx.h hVar) {
            this.f54090a = timeUnit;
            this.f54091b = eVar;
            this.f54092c = j6;
            this.f54093d = hVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class l<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final rx.e<T> f54094a;

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f54094a.u4();
        }

        l(rx.e<T> eVar) {
            this.f54094a = eVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class m<T> implements rx.functions.o<rx.observables.c<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final long f54095a;

        /* renamed from: b, reason: collision with root package name */
        private final TimeUnit f54096b;

        /* renamed from: c, reason: collision with root package name */
        private final rx.h f54097c;

        /* renamed from: d, reason: collision with root package name */
        private final int f54098d;

        /* renamed from: e, reason: collision with root package name */
        private final rx.e<T> f54099e;

        @Override // rx.functions.o, java.util.concurrent.Callable
        public rx.observables.c<T> call() {
            return this.f54099e.x4(this.f54098d, this.f54095a, this.f54096b, this.f54097c);
        }

        m(rx.e<T> eVar, int i6, long j6, TimeUnit timeUnit, rx.h hVar) {
            this.f54095a = j6;
            this.f54096b = timeUnit;
            this.f54097c = hVar;
            this.f54098d = i6;
            this.f54099e = eVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class n implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> f54100a;

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return this.f54100a.call(eVar.c3(InternalObservableUtils.ERROR_EXTRACTOR));
        }

        public n(rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
            this.f54100a = pVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class p<T, R> implements rx.functions.p<rx.e<T>, rx.e<R>> {

        /* renamed from: a, reason: collision with root package name */
        final rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> f54101a;

        /* renamed from: b, reason: collision with root package name */
        final rx.h f54102b;

        @Override // rx.functions.p
        public rx.e<R> call(rx.e<T> eVar) {
            return this.f54101a.call(eVar).I3(this.f54102b);
        }

        public p(rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar, rx.h hVar) {
            this.f54101a = pVar;
            this.f54102b = hVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class q implements rx.functions.p<List<? extends rx.e<?>>, rx.e<?>[]> {
        @Override // rx.functions.p
        public rx.e<?>[] call(List<? extends rx.e<?>> list) {
            return (rx.e[]) list.toArray(new rx.e[list.size()]);
        }

        q() {
        }
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar) {
        return new l(eVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class o implements rx.functions.p<Object, Void> {
        @Override // rx.functions.p
        public Void call(Object obj) {
            return null;
        }

        o() {
        }
    }

    public static <T, R> rx.functions.q<R, T, R> createCollectorCaller(rx.functions.c<R, ? super T> cVar) {
        return new a(cVar);
    }

    public static rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> createRepeatDematerializer(rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> pVar) {
        return new i(pVar);
    }

    public static <T, R> rx.functions.p<rx.e<T>, rx.e<R>> createReplaySelectorAndObserveOn(rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar, rx.h hVar) {
        return new p(pVar, hVar);
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar, int i6) {
        return new j(eVar, i6);
    }

    public static rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> createRetryDematerializer(rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
        return new n(pVar);
    }

    public static rx.functions.p<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static rx.functions.p<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar, long j6, TimeUnit timeUnit, rx.h hVar) {
        return new k(eVar, j6, timeUnit, hVar);
    }

    public static <T> rx.functions.o<rx.observables.c<T>> createReplaySupplier(rx.e<T> eVar, int i6, long j6, TimeUnit timeUnit, rx.h hVar) {
        return new m(eVar, i6, j6, timeUnit, hVar);
    }
}
