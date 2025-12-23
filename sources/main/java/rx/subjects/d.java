package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.l;
import rx.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class d<T> extends rx.subjects.f<T, T> {

    /* renamed from: c, reason: collision with root package name */
    private static final Object[] f54508c = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    final e<T> f54509b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a<T> {
        void a(b<T> bVar);

        void complete();

        Throwable error();

        void error(Throwable th);

        boolean isComplete();

        boolean isEmpty();

        T last();

        void next(T t5);

        int size();

        T[] toArray(T[] tArr);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> extends AtomicInteger implements rx.g, m {
        private static final long serialVersionUID = -5006209596735204567L;

        /* renamed from: a, reason: collision with root package name */
        final l<? super T> f54510a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicLong f54511b = new AtomicLong();

        /* renamed from: c, reason: collision with root package name */
        final e<T> f54512c;

        /* renamed from: d, reason: collision with root package name */
        int f54513d;

        /* renamed from: e, reason: collision with root package name */
        int f54514e;

        /* renamed from: f, reason: collision with root package name */
        Object f54515f;

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f54510a.isUnsubscribed();
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 > 0) {
                rx.internal.operators.a.b(this.f54511b, j6);
                this.f54512c.f54535a.a(this);
            } else {
                if (j6 >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n >= required but it was " + j6);
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f54512c.f(this);
        }

        public b(l<? super T> lVar, e<T> eVar) {
            this.f54510a = lVar;
            this.f54512c = eVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f54516a;

        /* renamed from: b, reason: collision with root package name */
        final long f54517b;

        /* renamed from: c, reason: collision with root package name */
        final rx.h f54518c;

        /* renamed from: d, reason: collision with root package name */
        volatile a<T> f54519d;

        /* renamed from: e, reason: collision with root package name */
        a<T> f54520e;

        /* renamed from: f, reason: collision with root package name */
        int f54521f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f54522g;

        /* renamed from: h, reason: collision with root package name */
        Throwable f54523h;

        @Override // rx.subjects.d.a
        public void error(Throwable th) {
            b();
            this.f54523h = th;
            this.f54522g = true;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;

            /* renamed from: a, reason: collision with root package name */
            final T f54524a;

            /* renamed from: b, reason: collision with root package name */
            final long f54525b;

            public a(T t5, long j6) {
                this.f54524a = t5;
                this.f54525b = j6;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
        
            if (r10 != r5) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
        
            if (r2.isUnsubscribed() == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
        
            r3 = r17.f54522g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
        
            if (r7.get() != null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
        
            if (r3 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        
            if (r12 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
        
            r18.f54515f = null;
            r1 = r17.f54523h;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
        
            if (r1 == null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007f, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0082, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0069, code lost:
        
            r18.f54515f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x006b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
        
            if (r10 == 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
        
            if (r5 == Long.MAX_VALUE) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
        
            rx.internal.operators.a.i(r18.f54511b, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
        
            r18.f54515f = r7;
            r4 = r18.addAndGet(-r4);
         */
        @Override // rx.subjects.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(rx.subjects.d.b<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r1.getAndIncrement()
                if (r2 == 0) goto Lc
                goto La2
            Lc:
                rx.l<? super T> r2 = r1.f54510a
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.f54511b
                long r5 = r5.get()
                java.lang.Object r7 = r1.f54515f
                rx.subjects.d$c$a r7 = (rx.subjects.d.c.a) r7
                r8 = 0
                if (r7 != 0) goto L21
                rx.subjects.d$c$a r7 = r0.c()
            L21:
                r10 = r8
            L22:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L61
                boolean r15 = r2.isUnsubscribed()
                if (r15 == 0) goto L31
                r1.f54515f = r13
                return
            L31:
                boolean r15 = r0.f54522g
                java.lang.Object r16 = r7.get()
                r3 = r16
                rx.subjects.d$c$a r3 = (rx.subjects.d.c.a) r3
                if (r3 != 0) goto L40
                r16 = 1
                goto L42
            L40:
                r16 = 0
            L42:
                if (r15 == 0) goto L54
                if (r16 == 0) goto L54
                r1.f54515f = r13
                java.lang.Throwable r1 = r0.f54523h
                if (r1 == 0) goto L50
                r2.onError(r1)
                return
            L50:
                r2.onCompleted()
                return
            L54:
                if (r16 == 0) goto L57
                goto L61
            L57:
                T r7 = r3.f54524a
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r3
                goto L22
            L61:
                if (r14 != 0) goto L87
                boolean r3 = r2.isUnsubscribed()
                if (r3 == 0) goto L6c
                r1.f54515f = r13
                return
            L6c:
                boolean r3 = r0.f54522g
                java.lang.Object r14 = r7.get()
                if (r14 != 0) goto L75
                r12 = 1
            L75:
                if (r3 == 0) goto L87
                if (r12 == 0) goto L87
                r1.f54515f = r13
                java.lang.Throwable r1 = r0.f54523h
                if (r1 == 0) goto L83
                r2.onError(r1)
                return
            L83:
                r2.onCompleted()
                return
            L87:
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L99
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r3 == 0) goto L99
                java.util.concurrent.atomic.AtomicLong r3 = r1.f54511b
                rx.internal.operators.a.i(r3, r10)
            L99:
                r1.f54515f = r7
                int r3 = -r4
                int r4 = r1.addAndGet(r3)
                if (r4 != 0) goto Lf
            La2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.d.c.a(rx.subjects.d$b):void");
        }

        void b() {
            long b6 = this.f54518c.b() - this.f54517b;
            a<T> aVar = this.f54519d;
            a<T> aVar2 = aVar;
            while (true) {
                a<T> aVar3 = aVar2.get();
                if (aVar3 == null || aVar3.f54525b > b6) {
                    break;
                } else {
                    aVar2 = aVar3;
                }
            }
            if (aVar != aVar2) {
                this.f54519d = aVar2;
            }
        }

        a<T> c() {
            long b6 = this.f54518c.b() - this.f54517b;
            a<T> aVar = this.f54519d;
            while (true) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null || aVar2.f54525b > b6) {
                    break;
                }
                aVar = aVar2;
            }
            return aVar;
        }

        @Override // rx.subjects.d.a
        public boolean isComplete() {
            return this.f54522g;
        }

        @Override // rx.subjects.d.a
        public void next(T t5) {
            a<T> aVar;
            long b6 = this.f54518c.b();
            a<T> aVar2 = new a<>(t5, b6);
            this.f54520e.set(aVar2);
            this.f54520e = aVar2;
            long j6 = b6 - this.f54517b;
            int i6 = this.f54521f;
            a<T> aVar3 = this.f54519d;
            if (i6 == this.f54516a) {
                aVar = aVar3.get();
            } else {
                i6++;
                aVar = aVar3;
            }
            while (true) {
                a<T> aVar4 = aVar.get();
                if (aVar4 == null || aVar4.f54525b > j6) {
                    break;
                }
                i6--;
                aVar = aVar4;
            }
            this.f54521f = i6;
            if (aVar != aVar3) {
                this.f54519d = aVar;
            }
        }

        @Override // rx.subjects.d.a
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (a<T> aVar = c().get(); aVar != null; aVar = aVar.get()) {
                arrayList.add(aVar.f54524a);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        public c(int i6, long j6, rx.h hVar) {
            this.f54516a = i6;
            a<T> aVar = new a<>(null, 0L);
            this.f54520e = aVar;
            this.f54519d = aVar;
            this.f54517b = j6;
            this.f54518c = hVar;
        }

        @Override // rx.subjects.d.a
        public void complete() {
            b();
            this.f54522g = true;
        }

        @Override // rx.subjects.d.a
        public boolean isEmpty() {
            if (c().get() == null) {
                return true;
            }
            return false;
        }

        @Override // rx.subjects.d.a
        public T last() {
            a<T> c6 = c();
            while (true) {
                a<T> aVar = c6.get();
                if (aVar != null) {
                    c6 = aVar;
                } else {
                    return c6.f54524a;
                }
            }
        }

        @Override // rx.subjects.d.a
        public int size() {
            a<T> aVar = c().get();
            int i6 = 0;
            while (aVar != null && i6 != Integer.MAX_VALUE) {
                aVar = aVar.get();
                i6++;
            }
            return i6;
        }

        @Override // rx.subjects.d.a
        public Throwable error() {
            return this.f54523h;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: rx.subjects.d$d, reason: collision with other inner class name */
    static final class C1079d<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f54526a;

        /* renamed from: b, reason: collision with root package name */
        volatile a<T> f54527b;

        /* renamed from: c, reason: collision with root package name */
        a<T> f54528c;

        /* renamed from: d, reason: collision with root package name */
        int f54529d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f54530e;

        /* renamed from: f, reason: collision with root package name */
        Throwable f54531f;

        @Override // rx.subjects.d.a
        public void complete() {
            this.f54530e = true;
        }

        @Override // rx.subjects.d.a
        public void error(Throwable th) {
            this.f54531f = th;
            this.f54530e = true;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: rx.subjects.d$d$a */
        static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;

            /* renamed from: a, reason: collision with root package name */
            final T f54532a;

            public a(T t5) {
                this.f54532a = t5;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
        
            if (r10 != r5) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
        
            if (r2.isUnsubscribed() == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
        
            r3 = r17.f54530e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0070, code lost:
        
            if (r7.get() != null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
        
            if (r3 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
        
            if (r12 == false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
        
            r18.f54515f = null;
            r1 = r17.f54531f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:
        
            if (r1 == null) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0081, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0084, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0067, code lost:
        
            r18.f54515f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0069, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0087, code lost:
        
            if (r10 == 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0090, code lost:
        
            if (r5 == Long.MAX_VALUE) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0092, code lost:
        
            rx.internal.operators.a.i(r18.f54511b, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
        
            r18.f54515f = r7;
            r4 = r18.addAndGet(-r4);
         */
        @Override // rx.subjects.d.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(rx.subjects.d.b<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r1.getAndIncrement()
                if (r2 == 0) goto Lc
                goto La0
            Lc:
                rx.l<? super T> r2 = r1.f54510a
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.f54511b
                long r5 = r5.get()
                java.lang.Object r7 = r1.f54515f
                rx.subjects.d$d$a r7 = (rx.subjects.d.C1079d.a) r7
                r8 = 0
                if (r7 != 0) goto L1f
                rx.subjects.d$d$a<T> r7 = r0.f54527b
            L1f:
                r10 = r8
            L20:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L5f
                boolean r15 = r2.isUnsubscribed()
                if (r15 == 0) goto L2f
                r1.f54515f = r13
                return
            L2f:
                boolean r15 = r0.f54530e
                java.lang.Object r16 = r7.get()
                r3 = r16
                rx.subjects.d$d$a r3 = (rx.subjects.d.C1079d.a) r3
                if (r3 != 0) goto L3e
                r16 = 1
                goto L40
            L3e:
                r16 = 0
            L40:
                if (r15 == 0) goto L52
                if (r16 == 0) goto L52
                r1.f54515f = r13
                java.lang.Throwable r1 = r0.f54531f
                if (r1 == 0) goto L4e
                r2.onError(r1)
                return
            L4e:
                r2.onCompleted()
                return
            L52:
                if (r16 == 0) goto L55
                goto L5f
            L55:
                T r7 = r3.f54532a
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r3
                goto L20
            L5f:
                if (r14 != 0) goto L85
                boolean r3 = r2.isUnsubscribed()
                if (r3 == 0) goto L6a
                r1.f54515f = r13
                return
            L6a:
                boolean r3 = r0.f54530e
                java.lang.Object r14 = r7.get()
                if (r14 != 0) goto L73
                r12 = 1
            L73:
                if (r3 == 0) goto L85
                if (r12 == 0) goto L85
                r1.f54515f = r13
                java.lang.Throwable r1 = r0.f54531f
                if (r1 == 0) goto L81
                r2.onError(r1)
                return
            L81:
                r2.onCompleted()
                return
            L85:
                int r3 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r3 == 0) goto L97
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r3 == 0) goto L97
                java.util.concurrent.atomic.AtomicLong r3 = r1.f54511b
                rx.internal.operators.a.i(r3, r10)
            L97:
                r1.f54515f = r7
                int r3 = -r4
                int r4 = r1.addAndGet(r3)
                if (r4 != 0) goto Lf
            La0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.d.C1079d.a(rx.subjects.d$b):void");
        }

        @Override // rx.subjects.d.a
        public boolean isComplete() {
            return this.f54530e;
        }

        @Override // rx.subjects.d.a
        public boolean isEmpty() {
            return this.f54527b.get() == null;
        }

        @Override // rx.subjects.d.a
        public T last() {
            a<T> aVar = this.f54527b;
            while (true) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    return aVar.f54532a;
                }
                aVar = aVar2;
            }
        }

        @Override // rx.subjects.d.a
        public void next(T t5) {
            a<T> aVar = new a<>(t5);
            this.f54528c.set(aVar);
            this.f54528c = aVar;
            int i6 = this.f54529d;
            if (i6 == this.f54526a) {
                this.f54527b = this.f54527b.get();
            } else {
                this.f54529d = i6 + 1;
            }
        }

        @Override // rx.subjects.d.a
        public int size() {
            a<T> aVar = this.f54527b.get();
            int i6 = 0;
            while (aVar != null && i6 != Integer.MAX_VALUE) {
                aVar = aVar.get();
                i6++;
            }
            return i6;
        }

        @Override // rx.subjects.d.a
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (a<T> aVar = this.f54527b.get(); aVar != null; aVar = aVar.get()) {
                arrayList.add(aVar.f54532a);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        public C1079d(int i6) {
            this.f54526a = i6;
            a<T> aVar = new a<>(null);
            this.f54528c = aVar;
            this.f54527b = aVar;
        }

        @Override // rx.subjects.d.a
        public Throwable error() {
            return this.f54531f;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e<T> extends AtomicReference<b<T>[]> implements e.a<T>, rx.f<T> {

        /* renamed from: b, reason: collision with root package name */
        static final b[] f54533b = new b[0];

        /* renamed from: c, reason: collision with root package name */
        static final b[] f54534c = new b[0];
        private static final long serialVersionUID = 5952362471246910544L;

        /* renamed from: a, reason: collision with root package name */
        final a<T> f54535a;

        @Override // rx.functions.b
        public void call(l<? super T> lVar) {
            b<T> bVar = new b<>(lVar, this);
            lVar.add(bVar);
            lVar.setProducer(bVar);
            if (d(bVar) && bVar.isUnsubscribed()) {
                f(bVar);
            } else {
                this.f54535a.a(bVar);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            a<T> aVar = this.f54535a;
            aVar.complete();
            for (b<T> bVar : getAndSet(f54534c)) {
                aVar.a(bVar);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            a<T> aVar = this.f54535a;
            aVar.error(th);
            ArrayList arrayList = null;
            for (b<T> bVar : getAndSet(f54534c)) {
                try {
                    aVar.a(bVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }

        @Override // rx.f
        public void onNext(T t5) {
            a<T> aVar = this.f54535a;
            aVar.next(t5);
            for (b<T> bVar : get()) {
                aVar.a(bVar);
            }
        }

        public e(a<T> aVar) {
            this.f54535a = aVar;
            lazySet(f54533b);
        }

        boolean d(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr == f54534c) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        boolean e() {
            if (get() == f54534c) {
                return true;
            }
            return false;
        }

        void f(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr != f54534c && bVarArr != f54533b) {
                    int length = bVarArr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            if (bVarArr[i6] == bVar) {
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
                            bVarArr2 = f54533b;
                        } else {
                            b[] bVarArr3 = new b[length - 1];
                            System.arraycopy(bVarArr, 0, bVarArr3, 0, i6);
                            System.arraycopy(bVarArr, i6 + 1, bVarArr3, i6, (length - i6) - 1);
                            bVarArr2 = bVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(bVarArr, bVarArr2));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        final int f54536a;

        /* renamed from: b, reason: collision with root package name */
        volatile int f54537b;

        /* renamed from: c, reason: collision with root package name */
        final Object[] f54538c;

        /* renamed from: d, reason: collision with root package name */
        Object[] f54539d;

        /* renamed from: e, reason: collision with root package name */
        int f54540e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f54541f;

        /* renamed from: g, reason: collision with root package name */
        Throwable f54542g;

        @Override // rx.subjects.d.a
        public void complete() {
            this.f54541f = true;
        }

        @Override // rx.subjects.d.a
        public void error(Throwable th) {
            if (this.f54541f) {
                rx.plugins.c.I(th);
            } else {
                this.f54542g = th;
                this.f54541f = true;
            }
        }

        @Override // rx.subjects.d.a
        public void a(b<T> bVar) {
            long j6;
            if (bVar.getAndIncrement() != 0) {
                return;
            }
            l<? super T> lVar = bVar.f54510a;
            int i6 = this.f54536a;
            int i7 = 1;
            do {
                long j7 = bVar.f54511b.get();
                Object[] objArr = (Object[]) bVar.f54515f;
                if (objArr == null) {
                    objArr = this.f54538c;
                }
                int i8 = bVar.f54514e;
                int i9 = bVar.f54513d;
                long j8 = 0;
                while (true) {
                    if (j8 == j7) {
                        j6 = 0;
                        break;
                    }
                    if (lVar.isUnsubscribed()) {
                        bVar.f54515f = null;
                        return;
                    }
                    j6 = 0;
                    boolean z5 = this.f54541f;
                    boolean z6 = i9 == this.f54537b;
                    if (z5 && z6) {
                        bVar.f54515f = null;
                        Throwable th = this.f54542g;
                        if (th != null) {
                            lVar.onError(th);
                            return;
                        } else {
                            lVar.onCompleted();
                            return;
                        }
                    }
                    if (z6) {
                        break;
                    }
                    if (i8 == i6) {
                        objArr = (Object[]) objArr[i8];
                        i8 = 0;
                    }
                    lVar.onNext(objArr[i8]);
                    j8++;
                    i8++;
                    i9++;
                }
                if (j8 == j7) {
                    if (lVar.isUnsubscribed()) {
                        bVar.f54515f = null;
                        return;
                    }
                    boolean z7 = this.f54541f;
                    boolean z8 = i9 == this.f54537b;
                    if (z7 && z8) {
                        bVar.f54515f = null;
                        Throwable th2 = this.f54542g;
                        if (th2 != null) {
                            lVar.onError(th2);
                            return;
                        } else {
                            lVar.onCompleted();
                            return;
                        }
                    }
                }
                if (j8 != j6 && j7 != Long.MAX_VALUE) {
                    rx.internal.operators.a.i(bVar.f54511b, j8);
                }
                bVar.f54513d = i9;
                bVar.f54514e = i8;
                bVar.f54515f = objArr;
                i7 = bVar.addAndGet(-i7);
            } while (i7 != 0);
        }

        @Override // rx.subjects.d.a
        public boolean isComplete() {
            return this.f54541f;
        }

        @Override // rx.subjects.d.a
        public boolean isEmpty() {
            return this.f54537b == 0;
        }

        @Override // rx.subjects.d.a
        public T last() {
            int i6 = this.f54537b;
            if (i6 == 0) {
                return null;
            }
            Object[] objArr = this.f54538c;
            int i7 = this.f54536a;
            while (i6 >= i7) {
                objArr = (Object[]) objArr[i7];
                i6 -= i7;
            }
            return (T) objArr[i6 - 1];
        }

        @Override // rx.subjects.d.a
        public void next(T t5) {
            if (this.f54541f) {
                return;
            }
            int i6 = this.f54540e;
            Object[] objArr = this.f54539d;
            if (i6 == objArr.length - 1) {
                Object[] objArr2 = new Object[objArr.length];
                objArr2[0] = t5;
                this.f54540e = 1;
                objArr[i6] = objArr2;
                this.f54539d = objArr2;
            } else {
                objArr[i6] = t5;
                this.f54540e = i6 + 1;
            }
            this.f54537b++;
        }

        @Override // rx.subjects.d.a
        public int size() {
            return this.f54537b;
        }

        @Override // rx.subjects.d.a
        public T[] toArray(T[] tArr) {
            int i6 = this.f54537b;
            if (tArr.length < i6) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i6));
            }
            Object[] objArr = this.f54538c;
            int i7 = this.f54536a;
            int i8 = 0;
            while (true) {
                int i9 = i8 + i7;
                if (i9 >= i6) {
                    break;
                }
                System.arraycopy(objArr, 0, tArr, i8, i7);
                objArr = objArr[i7];
                i8 = i9;
            }
            System.arraycopy(objArr, 0, tArr, i8, i6 - i8);
            if (tArr.length > i6) {
                tArr[i6] = null;
            }
            return tArr;
        }

        public f(int i6) {
            this.f54536a = i6;
            Object[] objArr = new Object[i6 + 1];
            this.f54538c = objArr;
            this.f54539d = objArr;
        }

        @Override // rx.subjects.d.a
        public Throwable error() {
            return this.f54542g;
        }
    }

    static <T> d<T> A7() {
        return new d<>(new e(new C1079d(Integer.MAX_VALUE)));
    }

    static <T> d<T> B7() {
        return new d<>(new e(new c(Integer.MAX_VALUE, Long.MAX_VALUE, rx.schedulers.c.d())));
    }

    public static <T> d<T> C7(int i6) {
        return new d<>(new e(new C1079d(i6)));
    }

    public static <T> d<T> E7(long j6, TimeUnit timeUnit, int i6, rx.h hVar) {
        return new d<>(new e(new c(i6, timeUnit.toMillis(j6), hVar)));
    }

    public static <T> d<T> y7() {
        return z7(16);
    }

    public static <T> d<T> z7(int i6) {
        if (i6 > 0) {
            return new d<>(new e(new f(i6)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + i6);
    }

    public Throwable F7() {
        if (this.f54509b.e()) {
            return this.f54509b.f54535a.error();
        }
        return null;
    }

    public T G7() {
        return this.f54509b.f54535a.last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] H7() {
        Object[] objArr = f54508c;
        Object[] I7 = I7(objArr);
        return I7 == objArr ? new Object[0] : I7;
    }

    public T[] I7(T[] tArr) {
        return this.f54509b.f54535a.toArray(tArr);
    }

    public boolean J7() {
        return !this.f54509b.f54535a.isEmpty();
    }

    public boolean K7() {
        return this.f54509b.e() && this.f54509b.f54535a.error() == null;
    }

    public boolean L7() {
        return this.f54509b.e() && this.f54509b.f54535a.error() != null;
    }

    public int N7() {
        return this.f54509b.f54535a.size();
    }

    int O7() {
        return this.f54509b.get().length;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f54509b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f54509b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t5) {
        this.f54509b.onNext(t5);
    }

    @Override // rx.subjects.f
    public boolean w7() {
        return this.f54509b.get().length != 0;
    }

    d(e<T> eVar) {
        super(eVar);
        this.f54509b = eVar;
    }

    public static <T> d<T> D7(long j6, TimeUnit timeUnit, rx.h hVar) {
        return E7(j6, timeUnit, Integer.MAX_VALUE, hVar);
    }

    public boolean M7() {
        return J7();
    }
}
