package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class BackpressureDrainManager extends AtomicLong implements rx.g {
    private static final long serialVersionUID = 2826241102729529449L;
    final a actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean accept(Object obj);

        void e(Throwable th);

        Object peek();

        Object poll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r1 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if (r5.peek() == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
    
        if (get() != Long.MAX_VALUE) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        if (r2 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r1 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
    
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r9 == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        if (r2 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0072, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006d, code lost:
    
        if (r1 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006f, code lost:
    
        if (r2 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0047, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0075, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007c, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007d, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0030, code lost:
    
        if (r2 == 0) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void drain() {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.emitting     // Catch: java.lang.Throwable -> L7
            if (r0 == 0) goto La
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L7
            return
        L7:
            r0 = move-exception
            goto L96
        La:
            r0 = 1
            r13.emitting = r0     // Catch: java.lang.Throwable -> L7
            boolean r1 = r13.terminated     // Catch: java.lang.Throwable -> L7
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L7
            long r2 = r13.get()
            r4 = 0
            rx.internal.util.BackpressureDrainManager$a r5 = r13.actual     // Catch: java.lang.Throwable -> L33
        L17:
            r6 = 0
        L18:
            r7 = 0
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 > 0) goto L20
            if (r1 == 0) goto L3c
        L20:
            if (r1 == 0) goto L36
            java.lang.Object r10 = r5.peek()     // Catch: java.lang.Throwable -> L33
            if (r10 != 0) goto L30
            java.lang.Throwable r1 = r13.exception     // Catch: java.lang.Throwable -> L2e
            r5.e(r1)     // Catch: java.lang.Throwable -> L2e
            return
        L2e:
            r1 = move-exception
            goto L8b
        L30:
            if (r9 != 0) goto L36
            goto L3c
        L33:
            r1 = move-exception
            r0 = 0
            goto L8b
        L36:
            java.lang.Object r9 = r5.poll()     // Catch: java.lang.Throwable -> L33
            if (r9 != 0) goto L7e
        L3c:
            monitor-enter(r13)     // Catch: java.lang.Throwable -> L33
            boolean r1 = r13.terminated     // Catch: java.lang.Throwable -> L75
            java.lang.Object r2 = r5.peek()     // Catch: java.lang.Throwable -> L75
            if (r2 == 0) goto L47
            r2 = 1
            goto L48
        L47:
            r2 = 0
        L48:
            long r9 = r13.get()     // Catch: java.lang.Throwable -> L75
            r11 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 != 0) goto L61
            if (r2 != 0) goto L5f
            if (r1 != 0) goto L5f
            r13.emitting = r4     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L5d
            return
        L5d:
            r1 = move-exception
            goto L7c
        L5f:
            r2 = r11
            goto L73
        L61:
            int r3 = -r6
            long r9 = (long) r3
            long r9 = r13.addAndGet(r9)     // Catch: java.lang.Throwable -> L75
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L6d
            if (r2 != 0) goto L72
        L6d:
            if (r1 == 0) goto L78
            if (r2 == 0) goto L72
            goto L78
        L72:
            r2 = r9
        L73:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L75
            goto L17
        L75:
            r1 = move-exception
            r0 = 0
            goto L7c
        L78:
            r13.emitting = r4     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L5d
            return
        L7c:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L5d
            throw r1     // Catch: java.lang.Throwable -> L2e
        L7e:
            boolean r7 = r5.accept(r9)     // Catch: java.lang.Throwable -> L33
            if (r7 == 0) goto L85
            return
        L85:
            r7 = 1
            long r2 = r2 - r7
            int r6 = r6 + 1
            goto L18
        L8b:
            if (r0 != 0) goto L95
            monitor-enter(r13)
            r13.emitting = r4     // Catch: java.lang.Throwable -> L92
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L92
            goto L95
        L92:
            r0 = move-exception
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L92
            throw r0
        L95:
            throw r1
        L96:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> L7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.BackpressureDrainManager.drain():void");
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // rx.g
    public void request(long j6) {
        boolean z5;
        long j7;
        if (j6 == 0) {
            return;
        }
        while (true) {
            long j8 = get();
            boolean z6 = true;
            z5 = j8 == 0;
            if (j8 == Long.MAX_VALUE) {
                break;
            }
            if (j6 == Long.MAX_VALUE) {
                j7 = j6;
            } else {
                j7 = j8 <= Long.MAX_VALUE - j6 ? j8 + j6 : Long.MAX_VALUE;
                z6 = z5;
            }
            if (compareAndSet(j8, j7)) {
                z5 = z6;
                break;
            }
        }
        if (z5) {
            drain();
        }
    }

    public void terminate(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
    }

    public BackpressureDrainManager(a aVar) {
        this.actual = aVar;
    }

    public void terminateAndDrain(Throwable th) {
        if (this.terminated) {
            return;
        }
        this.exception = th;
        this.terminated = true;
        drain();
    }
}
