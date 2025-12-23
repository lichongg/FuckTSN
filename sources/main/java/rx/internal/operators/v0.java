package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v0 implements e.a<Integer> {

    /* renamed from: a, reason: collision with root package name */
    private final int f53597a;

    /* renamed from: b, reason: collision with root package name */
    private final int f53598b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends AtomicLong implements rx.g {
        private static final long serialVersionUID = 4114392207069098388L;

        /* renamed from: a, reason: collision with root package name */
        private final rx.l<? super Integer> f53599a;

        /* renamed from: b, reason: collision with root package name */
        private final int f53600b;

        /* renamed from: c, reason: collision with root package name */
        private long f53601c;

        void a() {
            long j6 = this.f53600b + 1;
            rx.l<? super Integer> lVar = this.f53599a;
            for (long j7 = this.f53601c; j7 != j6; j7++) {
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onNext(Integer.valueOf((int) j7));
            }
            if (lVar.isUnsubscribed()) {
                return;
            }
            lVar.onCompleted();
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
        
            r12.f53601c = r4;
            r13 = addAndGet(-r9);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b(long r13) {
            /*
                r12 = this;
                int r0 = r12.f53600b
                long r0 = (long) r0
                r2 = 1
                long r0 = r0 + r2
                long r4 = r12.f53601c
                rx.l<? super java.lang.Integer> r6 = r12.f53599a
                r7 = 0
            Lc:
                r9 = r7
            Ld:
                int r11 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
                if (r11 == 0) goto L27
                int r11 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r11 == 0) goto L27
                boolean r11 = r6.isUnsubscribed()
                if (r11 == 0) goto L1c
                goto L49
            L1c:
                int r11 = (int) r4
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                r6.onNext(r11)
                long r4 = r4 + r2
                long r9 = r9 + r2
                goto Ld
            L27:
                boolean r13 = r6.isUnsubscribed()
                if (r13 == 0) goto L2e
                goto L49
            L2e:
                int r13 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r13 != 0) goto L36
                r6.onCompleted()
                return
            L36:
                long r13 = r12.get()
                int r11 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
                if (r11 != 0) goto Ld
                r12.f53601c = r4
                long r13 = -r9
                long r13 = r12.addAndGet(r13)
                int r9 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r9 != 0) goto Lc
            L49:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.v0.a.b(long):void");
        }

        a(rx.l<? super Integer> lVar, int i6, int i7) {
            this.f53599a = lVar;
            this.f53601c = i6;
            this.f53600b = i7;
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
    public void call(rx.l<? super Integer> lVar) {
        lVar.setProducer(new a(lVar, this.f53597a, this.f53598b));
    }

    public v0(int i6, int i7) {
        this.f53597a = i6;
        this.f53598b = i7;
    }
}
