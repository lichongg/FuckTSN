package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import r1.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class c {

    /* renamed from: l, reason: collision with root package name */
    private static final String f33446l = "c";

    /* renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f33447a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f33448b;

    /* renamed from: c, reason: collision with root package name */
    private final o1.a f33449c;

    /* renamed from: d, reason: collision with root package name */
    private d f33450d;

    /* renamed from: i, reason: collision with root package name */
    private final q1.c f33455i;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Future<d>> f33451e = new ConcurrentHashMap(16);

    /* renamed from: f, reason: collision with root package name */
    private final List<d> f33452f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final JSONArray f33453g = new JSONArray();

    /* renamed from: h, reason: collision with root package name */
    private final List<String> f33454h = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    private String f33456j = "";

    /* renamed from: k, reason: collision with root package name */
    private long f33457k = 1;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0094 A[LOOP:0: B:2:0x0004->B:13:0x0094, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.g.d b(java.util.concurrent.ExecutorService r12, java.util.List<java.lang.String> r13, java.lang.String r14, o1.c r15) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r5 = 0
        L4:
            int r0 = r13.size()
            if (r5 >= r0) goto L9a
            java.lang.Object r0 = r13.get(r5)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L86
            com.huawei.hms.framework.network.grs.g.a r3 = new com.huawei.hms.framework.network.grs.g.a
            android.content.Context r7 = r11.f33448b
            com.huawei.hms.framework.network.grs.GrsBaseInfo r9 = r11.f33447a
            r6 = r11
            r8 = r14
            r10 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            java.util.concurrent.Callable r14 = r3.g()
            java.util.concurrent.Future r14 = r12.submit(r14)
            java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> r15 = r6.f33451e
            r15.put(r4, r14)
            r15 = 1
            long r3 = r6.f33457k     // Catch: java.lang.InterruptedException -> L61 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.TimeoutException -> L66 java.util.concurrent.CancellationException -> L7e
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.InterruptedException -> L61 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.TimeoutException -> L66 java.util.concurrent.CancellationException -> L7e
            java.lang.Object r14 = r14.get(r3, r0)     // Catch: java.lang.InterruptedException -> L61 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.TimeoutException -> L66 java.util.concurrent.CancellationException -> L7e
            com.huawei.hms.framework.network.grs.g.d r14 = (com.huawei.hms.framework.network.grs.g.d) r14     // Catch: java.lang.InterruptedException -> L61 java.util.concurrent.ExecutionException -> L63 java.util.concurrent.TimeoutException -> L66 java.util.concurrent.CancellationException -> L7e
            if (r14 == 0) goto L5e
            boolean r0 = r14.D()     // Catch: java.lang.InterruptedException -> L4a java.util.concurrent.ExecutionException -> L4d java.util.concurrent.TimeoutException -> L5a java.util.concurrent.CancellationException -> L5c
            if (r0 != 0) goto L51
            boolean r0 = r14.B()     // Catch: java.lang.InterruptedException -> L4a java.util.concurrent.ExecutionException -> L4d java.util.concurrent.TimeoutException -> L5a java.util.concurrent.CancellationException -> L5c
            if (r0 == 0) goto L5e
            goto L51
        L4a:
            r0 = move-exception
            r2 = r14
            goto L6e
        L4d:
            r0 = move-exception
            r15 = r0
            r2 = r14
            goto L76
        L51:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.g.c.f33446l     // Catch: java.lang.InterruptedException -> L4a java.util.concurrent.ExecutionException -> L4d java.util.concurrent.TimeoutException -> L5a java.util.concurrent.CancellationException -> L5c
            java.lang.String r2 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.i(r0, r2)     // Catch: java.lang.InterruptedException -> L4a java.util.concurrent.ExecutionException -> L4d java.util.concurrent.TimeoutException -> L5a java.util.concurrent.CancellationException -> L5c
            r2 = r14
            goto L8a
        L5a:
            r2 = r14
            goto L66
        L5c:
            r2 = r14
            goto L7e
        L5e:
            r2 = r14
        L5f:
            r15 = 0
            goto L8a
        L61:
            r0 = move-exception
            goto L6e
        L63:
            r0 = move-exception
            r15 = r0
            goto L76
        L66:
            java.lang.String r14 = com.huawei.hms.framework.network.grs.g.c.f33446l
            java.lang.String r15 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.w(r14, r15)
            goto L5f
        L6e:
            java.lang.String r14 = com.huawei.hms.framework.network.grs.g.c.f33446l
            java.lang.String r3 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.w(r14, r3, r0)
            goto L8a
        L76:
            java.lang.String r14 = com.huawei.hms.framework.network.grs.g.c.f33446l
            java.lang.String r0 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.w(r14, r0, r15)
            goto L5f
        L7e:
            java.lang.String r14 = com.huawei.hms.framework.network.grs.g.c.f33446l
            java.lang.String r0 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.i(r14, r0)
            goto L8a
        L86:
            r6 = r11
            r8 = r14
            r10 = r15
            goto L5f
        L8a:
            if (r15 == 0) goto L94
            java.lang.String r12 = com.huawei.hms.framework.network.grs.g.c.f33446l
            java.lang.String r13 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.v(r12, r13)
            goto L9b
        L94:
            int r5 = r5 + 1
            r14 = r8
            r15 = r10
            goto L4
        L9a:
            r6 = r11
        L9b:
            com.huawei.hms.framework.network.grs.g.d r12 = r11.g(r2)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.c.b(java.util.concurrent.ExecutorService, java.util.List, java.lang.String, o1.c):com.huawei.hms.framework.network.grs.g.d");
    }

    public synchronized void d(d dVar) {
        try {
            this.f33452f.add(dVar);
            d dVar2 = this.f33450d;
            if (dVar2 == null || (!dVar2.D() && !this.f33450d.B())) {
                if (dVar.C()) {
                    Logger.i(f33446l, "GRS server open 503 limiting strategy.");
                    r1.d.b(this.f33447a.getGrsParasKey(true, true, this.f33448b), new d.a(dVar.z(), SystemClock.elapsedRealtime()));
                    return;
                }
                if (dVar.B()) {
                    Logger.i(f33446l, "GRS server open 304 Not Modified.");
                }
                if (!dVar.D() && !dVar.B()) {
                    Logger.v(f33446l, "grsResponseResult has exception so need return");
                    return;
                }
                this.f33450d = dVar;
                this.f33449c.d(this.f33447a, dVar, this.f33448b, this.f33455i);
                for (Map.Entry<String, Future<d>> entry : this.f33451e.entrySet()) {
                    if (!entry.getKey().equals(dVar.A()) && !entry.getValue().isCancelled()) {
                        Logger.i(f33446l, "future cancel");
                        entry.getValue().cancel(true);
                    }
                }
                return;
            }
            Logger.v(f33446l, "grsResponseResult is ok");
        } catch (Throwable th) {
            throw th;
        }
    }

    private void e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        String grsReqParamJoint = this.f33447a.getGrsReqParamJoint(false, false, j(), this.f33448b);
        if (!TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.f33454h.add(sb.toString());
    }

    private d g(d dVar) {
        String str;
        String str2;
        for (Map.Entry<String, Future<d>> entry : this.f33451e.entrySet()) {
            if (dVar != null && (dVar.D() || dVar.B())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e6) {
                e = e6;
                str = f33446l;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(f33446l, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e7) {
                e = e7;
                str = f33446l;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(f33446l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    private void h() {
        q1.d a6 = p1.a.a(this.f33448b);
        if (a6 == null) {
            Logger.w(f33446l, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        f(a6);
        List<String> a7 = a6.a();
        if (a7 == null || a7.size() <= 0) {
            Logger.v(f33446l, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (a7.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String e6 = a6.e();
        if (a7.size() > 0) {
            for (String str : a7) {
                if (str.startsWith(JPushConstants.HTTPS_PRE)) {
                    e(e6, str);
                } else {
                    Logger.w(f33446l, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.v(f33446l, "request to GRS server url is {%s}", this.f33454h);
    }

    private void i() {
        String grsParasKey = this.f33447a.getGrsParasKey(true, true, this.f33448b);
        this.f33456j = this.f33449c.b().a(grsParasKey + "ETag", "");
    }

    private String j() {
        com.huawei.hms.framework.network.grs.f.b a6 = com.huawei.hms.framework.network.grs.f.b.a(this.f33448b.getPackageName());
        u1.a d6 = a6 != null ? a6.d() : null;
        if (d6 == null) {
            return "";
        }
        String a7 = d6.a();
        Logger.v(f33446l, "get appName from local assets is{%s}", a7);
        return a7;
    }

    public d a(ExecutorService executorService, String str, o1.c cVar) {
        if (this.f33454h.isEmpty()) {
            return null;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d b6 = b(executorService, this.f33454h, str, cVar);
        Logger.i(f33446l, "use 2.0 interface return http's code is：{%d}", Integer.valueOf(b6 == null ? 0 : b6.f()));
        e.b(new ArrayList(this.f33452f), SystemClock.elapsedRealtime() - elapsedRealtime, this.f33453g, this.f33448b);
        this.f33452f.clear();
        return b6;
    }

    public String c() {
        return this.f33456j;
    }

    public c(q1.c cVar, o1.a aVar) {
        this.f33455i = cVar;
        this.f33447a = cVar.c();
        this.f33448b = cVar.a();
        this.f33449c = aVar;
        h();
        i();
    }

    public void f(q1.d dVar) {
    }
}
