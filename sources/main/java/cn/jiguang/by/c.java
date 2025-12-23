package cn.jiguang.by;

import android.text.TextUtils;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final ThreadGroup f2656a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f2657b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    private final String f2658c;

    /* JADX WARN: Removed duplicated region for block: B:27:0x0083 A[Catch: all -> 0x0087, TryCatch #1 {all -> 0x0087, blocks: (B:25:0x007d, B:27:0x0083, B:28:0x008b, B:30:0x0091), top: B:24:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #1 {all -> 0x0087, blocks: (B:25:0x007d, B:27:0x0083, B:28:0x008b, B:30:0x0091), top: B:24:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // java.util.concurrent.ThreadFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Thread newThread(java.lang.Runnable r13) {
        /*
            r12 = this;
            r1 = 0
            r2 = 5
            r3 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            r0.<init>()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r4 = r12.f2658c     // Catch: java.lang.Throwable -> L3f
            r0.append(r4)     // Catch: java.lang.Throwable -> L3f
            java.util.concurrent.atomic.AtomicInteger r4 = r12.f2657b     // Catch: java.lang.Throwable -> L3f
            int r4 = r4.getAndIncrement()     // Catch: java.lang.Throwable -> L3f
            r0.append(r4)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Throwable -> L3f
            java.lang.Thread r5 = new java.lang.Thread     // Catch: java.lang.Throwable -> L3f
            java.lang.ThreadGroup r6 = r12.f2656a     // Catch: java.lang.Throwable -> L3f
            r9 = 0
            r7 = r13
            r5.<init>(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3c
            boolean r13 = r5.isDaemon()     // Catch: java.lang.Throwable -> L2e
            if (r13 == 0) goto L32
            r5.setDaemon(r1)     // Catch: java.lang.Throwable -> L2e
            goto L32
        L2e:
            r0 = move-exception
            r13 = r0
            r3 = r5
            goto L42
        L32:
            int r13 = r5.getPriority()     // Catch: java.lang.Throwable -> L2e
            if (r13 == r2) goto L3b
            r5.setPriority(r2)     // Catch: java.lang.Throwable -> L2e
        L3b:
            return r5
        L3c:
            r0 = move-exception
        L3d:
            r13 = r0
            goto L42
        L3f:
            r0 = move-exception
            r7 = r13
            goto L3d
        L42:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "JThreadFactory new Thread error, "
            r0.append(r4)
            java.lang.String r13 = r13.getMessage()
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r4 = "JThreadFactory"
            cn.jiguang.bb.f.l(r4, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r13.<init>()     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = r12.f2658c     // Catch: java.lang.Throwable -> L95
            r13.append(r0)     // Catch: java.lang.Throwable -> L95
            java.util.concurrent.atomic.AtomicInteger r0 = r12.f2657b     // Catch: java.lang.Throwable -> L95
            int r0 = r0.getAndIncrement()     // Catch: java.lang.Throwable -> L95
            r13.append(r0)     // Catch: java.lang.Throwable -> L95
            java.lang.String r9 = r13.toString()     // Catch: java.lang.Throwable -> L95
            java.lang.Thread r6 = new java.lang.Thread     // Catch: java.lang.Throwable -> L95
            r8 = r7
            java.lang.ThreadGroup r7 = r12.f2656a     // Catch: java.lang.Throwable -> L95
            r10 = 0
            r6.<init>(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L95
            boolean r13 = r6.isDaemon()     // Catch: java.lang.Throwable -> L87
            if (r13 == 0) goto L8b
            r6.setDaemon(r1)     // Catch: java.lang.Throwable -> L87
            goto L8b
        L87:
            r0 = move-exception
            r13 = r0
            r3 = r6
            goto L97
        L8b:
            int r13 = r6.getPriority()     // Catch: java.lang.Throwable -> L87
            if (r13 == r2) goto Lb0
            r6.setPriority(r2)     // Catch: java.lang.Throwable -> L87
            goto Lb0
        L95:
            r0 = move-exception
            r13 = r0
        L97:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "JThreadFactory new Thread again error, "
            r0.append(r1)
            java.lang.String r13 = r13.getMessage()
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            cn.jiguang.bb.f.l(r4, r13)
            r6 = r3
        Lb0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.by.c.newThread(java.lang.Runnable):java.lang.Thread");
    }

    public c(String str) {
        ThreadGroup threadGroup;
        String lowerCase;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f2656a = threadGroup;
        if (TextUtils.isEmpty(str)) {
            lowerCase = "default";
        } else {
            lowerCase = str.toLowerCase();
        }
        this.f2658c = "jg_" + lowerCase + "_pool_thread";
    }
}
