package com.bytedance.sdk.component.oq.j;

import com.bytedance.sdk.component.oq.qv;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements Comparable<cw>, Runnable {

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicInteger f26620j = new AtomicInteger(0);
    public static boolean xt = false;
    public final Runnable cw;

    /* renamed from: r, reason: collision with root package name */
    private m f26623r;
    private long tl;
    private boolean up = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f26622m = true;
    private final long ae = System.currentTimeMillis();

    /* renamed from: g, reason: collision with root package name */
    private int f26621g = 0;
    private int oq = 0;

    public cw(Runnable runnable) {
        this.cw = runnable;
    }

    private void cw(boolean z5) {
        m mVar = this.f26623r;
        if (mVar != null) {
            mVar.j(this, z5);
        }
    }

    public void j(m mVar) {
        this.f26623r = mVar;
    }

    public void xt() {
        this.tl = System.currentTimeMillis() - this.ae;
    }

    Runnable j() {
        return this.cw;
    }

    public int r() {
        return this.f26621g;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|1|(13:3|4|5|6|7|(1:9)(1:40)|10|(1:14)|15|16|17|18|(1:36)(2:20|(2:26|(2:28|29)(4:(1:31)(1:35)|32|33|34))(1:24)))(1:45)|44|7|(0)(0)|10|(2:12|14)|15|16|17|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
    
        r2 = new java.lang.Object[1];
        r2[r15] = r0;
        r3 = r16;
        com.bytedance.sdk.component.utils.vl.xt(r3, r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r19 = this;
            r1 = r19
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            int r3 = r2.getPriority()
            java.lang.Runnable r0 = r1.cw
            boolean r4 = r0 instanceof com.bytedance.sdk.component.oq.g
            r5 = 1
            r6 = 0
            java.lang.String r7 = "BizRunnable"
            if (r4 == 0) goto L32
            r4 = r0
            com.bytedance.sdk.component.oq.g r4 = (com.bytedance.sdk.component.oq.g) r4
            int r0 = r4.getPriority()
            r8 = 10
            int r0 = java.lang.Math.min(r0, r8)
            r2.setPriority(r0)     // Catch: java.lang.Throwable -> L27
            r8 = r4
            r4 = r0
            goto L34
        L27:
            r0 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r5]
            r8[r6] = r0
            com.bytedance.sdk.component.utils.vl.xt(r7, r8)
        L2f:
            r8 = r4
            r4 = r3
            goto L34
        L32:
            r4 = 0
            goto L2f
        L34:
            com.bytedance.sdk.component.oq.qv r0 = com.bytedance.sdk.component.oq.qv.xt
            boolean r9 = r0.kt()
            if (r9 == 0) goto L5c
            java.util.concurrent.ThreadPoolExecutor r10 = r0.g()
            int r10 = r10.getActiveCount()
            java.util.concurrent.ThreadPoolExecutor r0 = r0.oq()
            int r0 = r0.getActiveCount()
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = r1.tl
            long r13 = r11 - r13
            r16 = r7
            r15 = 0
            long r6 = r1.ae
            long r13 = r13 - r6
            r6 = r0
            goto L64
        L5c:
            r16 = r7
            r15 = 0
            r11 = 0
            r13 = r11
            r6 = 0
            r10 = 0
        L64:
            java.lang.Runnable r0 = r1.cw
            r0.run()
            long r17 = java.lang.System.currentTimeMillis()
            long r17 = r17 - r11
            boolean r0 = r1.up
            if (r0 != 0) goto L7d
            int r0 = r1.f26621g
            r7 = 2
            if (r0 != r7) goto L7d
            java.util.concurrent.atomic.AtomicInteger r0 = com.bytedance.sdk.component.oq.j.cw.f26620j
            r0.decrementAndGet()
        L7d:
            r2.setPriority(r3)     // Catch: java.lang.Throwable -> L83
            r3 = r16
            goto L8d
        L83:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r15] = r0
            r3 = r16
            com.bytedance.sdk.component.utils.vl.xt(r3, r2)
        L8d:
            r1.cw(r15)
            if (r9 != 0) goto L93
            goto Ld0
        L93:
            boolean r0 = r1.j(r13)
            if (r0 != 0) goto La3
            com.bytedance.sdk.component.oq.qv r0 = com.bytedance.sdk.component.oq.qv.xt
            long r11 = r0.mi()
            int r0 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            if (r0 <= 0) goto Ld0
        La3:
            java.lang.Class<com.bytedance.sdk.component.r.cw> r0 = com.bytedance.sdk.component.r.cw.class
            java.lang.Object r0 = com.bytedance.sdk.openadsdk.ats.AutoService.j(r0)
            com.bytedance.sdk.component.r.cw r0 = (com.bytedance.sdk.component.r.cw) r0
            if (r0 != 0) goto Lb3
            java.lang.String r0 = "IEvent service is null"
            com.bytedance.sdk.component.utils.vl.xt(r3, r0)
            return
        Lb3:
            if (r8 == 0) goto Lc2
            java.lang.String r2 = r8.getName()
        Lb9:
            r7 = r4
            r9 = r6
            r8 = r10
            r4 = r17
            r10 = r0
            r6 = r2
            r2 = r13
            goto Lcd
        Lc2:
            java.lang.Runnable r2 = r1.cw
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            goto Lb9
        Lcd:
            r1.j(r2, r4, r6, r7, r8, r9, r10)
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.oq.j.cw.run():void");
    }

    public void xt(boolean z5) {
        this.f26622m = z5;
    }

    private boolean j(long j6) {
        return this.oq == 1 ? j6 > qv.xt.i() : j6 > qv.xt.w();
    }

    public boolean cw() {
        return this.f26622m;
    }

    private void j(long j6, long j7, String str, int i6, int i7, int i8, com.bytedance.sdk.component.r.cw cwVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.ae);
            jSONObject.put("is_wrap", this.cw instanceof cw);
            jSONObject.put("is_oom", xt);
            jSONObject.put("pool_wait_time", j6);
            jSONObject.put("priority", i6);
            jSONObject.put("wait_in_queue", this.tl);
            jSONObject.put("pool_type", this.f26621g);
            jSONObject.put("origin_pool_type", this.oq);
            jSONObject.put("run_cost", j7);
            jSONObject.put("task_name", str);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, Thread.currentThread().getName());
            qv qvVar = qv.xt;
            jSONObject.put("little_active_count", i7);
            jSONObject.put("big_active_count", i8);
            jSONObject.put("is_crash", qvVar.ws());
            jSONObject.put("auto_size", com.bytedance.sdk.component.oq.ae.up());
            jSONObject.put("pri_task_in_little", f26620j.get());
            jSONObject.put("core_count", qvVar.tl());
            jSONObject.put("max_pool_size", qvVar.qv());
            jSONObject.put("use_little_pool", qvVar.av());
        } catch (Exception unused) {
        }
        cwVar.j("task_run_cost", jSONObject);
    }

    public cw(Runnable runnable, m mVar) {
        this.cw = runnable;
        this.f26623r = mVar;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(cw cwVar) {
        Class<?> cls = this.cw.getClass();
        Class<?> cls2 = cwVar.cw.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.cw;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = cwVar.cw;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void j(boolean z5) {
        this.up = z5;
    }

    public void j(int i6) {
        int i7 = this.f26621g;
        if (i7 == 0) {
            this.oq = i6;
        } else {
            this.oq = i7;
        }
        this.f26621g = i6;
    }
}
