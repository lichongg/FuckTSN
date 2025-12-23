package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final Iterable<? extends T> f53205a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -8730475647105475802L;

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super T> f53206a;

        /* renamed from: b, reason: collision with root package name */
        private final Iterator<? extends T> f53207b;

        void a() {
            rx.l<? super T> lVar = this.f53206a;
            Iterator<? extends T> it = this.f53207b;
            while (!lVar.isUnsubscribed()) {
                try {
                    lVar.onNext(it.next());
                    if (lVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (lVar.isUnsubscribed()) {
                                return;
                            }
                            lVar.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.f(th, lVar);
                        return;
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.f(th2, lVar);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
        
            r9 = rx.internal.operators.a.i(r8, r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b(long r9) {
            /*
                r8 = this;
                rx.l<? super T> r0 = r8.f53206a
                java.util.Iterator<? extends T> r1 = r8.f53207b
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L3e
                boolean r6 = r0.isUnsubscribed()
                if (r6 == 0) goto L12
                goto L4e
            L12:
                java.lang.Object r6 = r1.next()     // Catch: java.lang.Throwable -> L39
                r0.onNext(r6)
                boolean r6 = r0.isUnsubscribed()
                if (r6 == 0) goto L20
                goto L4e
            L20:
                boolean r6 = r1.hasNext()     // Catch: java.lang.Throwable -> L34
                if (r6 != 0) goto L30
                boolean r9 = r0.isUnsubscribed()
                if (r9 != 0) goto L4e
                r0.onCompleted()
                return
            L30:
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L34:
                r9 = move-exception
                rx.exceptions.a.f(r9, r0)
                return
            L39:
                r9 = move-exception
                rx.exceptions.a.f(r9, r0)
                return
            L3e:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = rx.internal.operators.a.i(r8, r4)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
            L4e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.n0.a.b(long):void");
        }

        a(rx.l<? super T> lVar, Iterator<? extends T> it) {
            this.f53206a = lVar;
            this.f53207b = it;
        }

        @Override // rx.g
        public void request(long j6) {
            if (get() != Long.MAX_VALUE) {
                if (j6 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                    a();
                } else if (j6 > 0 && rx.internal.operators.a.b(this, j6) == 0) {
                    b(j6);
                }
            }
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        try {
            Iterator<? extends T> it = this.f53205a.iterator();
            boolean hasNext = it.hasNext();
            if (lVar.isUnsubscribed()) {
                return;
            }
            if (hasNext) {
                lVar.setProducer(new a(lVar, it));
            } else {
                lVar.onCompleted();
            }
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }

    public n0(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f53205a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }
}
