package rx.internal.operators;

import defpackage.H5BaseWebChromeClient;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l0<T> implements e.a<T> {

    /* renamed from: a, reason: collision with root package name */
    final T[] f53130a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = 3534218984725836979L;

        /* renamed from: a, reason: collision with root package name */
        final rx.l<? super T> f53131a;

        /* renamed from: b, reason: collision with root package name */
        final T[] f53132b;

        /* renamed from: c, reason: collision with root package name */
        int f53133c;

        void a() {
            rx.l<? super T> lVar = this.f53131a;
            for (H5BaseWebChromeClient h5BaseWebChromeClient : this.f53132b) {
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onNext(h5BaseWebChromeClient);
            }
            if (lVar.isUnsubscribed()) {
                return;
            }
            lVar.onCompleted();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        
            r10.f53133c = r3;
            r11 = addAndGet(r6);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b(long r11) {
            /*
                r10 = this;
                rx.l<? super T> r0 = r10.f53131a
                T[] r1 = r10.f53132b
                int r2 = r1.length
                int r3 = r10.f53133c
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r8 == 0) goto L2f
                if (r3 == r2) goto L2f
                boolean r8 = r0.isUnsubscribed()
                if (r8 == 0) goto L17
                goto L42
            L17:
                r8 = r1[r3]
                r0.onNext(r8)
                int r3 = r3 + 1
                if (r3 != r2) goto L2a
                boolean r11 = r0.isUnsubscribed()
                if (r11 != 0) goto L42
                r0.onCompleted()
                return
            L2a:
                r8 = 1
                long r11 = r11 - r8
                long r6 = r6 - r8
                goto La
            L2f:
                long r11 = r10.get()
                long r11 = r11 + r6
                int r8 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f53133c = r3
                long r11 = r10.addAndGet(r6)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L42:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.l0.a.b(long):void");
        }

        @Override // rx.g
        public void request(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j6);
            }
            if (j6 == Long.MAX_VALUE) {
                if (rx.internal.operators.a.b(this, j6) == 0) {
                    a();
                }
            } else {
                if (j6 == 0 || rx.internal.operators.a.b(this, j6) != 0) {
                    return;
                }
                b(j6);
            }
        }

        public a(rx.l<? super T> lVar, T[] tArr) {
            this.f53131a = lVar;
            this.f53132b = tArr;
        }
    }

    @Override // rx.functions.b
    public void call(rx.l<? super T> lVar) {
        lVar.setProducer(new a(lVar, this.f53130a));
    }

    public l0(T[] tArr) {
        this.f53130a = tArr;
    }
}
