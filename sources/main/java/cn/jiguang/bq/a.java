package cn.jiguang.bq;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.by.d;
import cn.jiguang.bz.j;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f2504a = "ex_stat.catch.";

    /* renamed from: b, reason: collision with root package name */
    private static String f2505b = "ex_stat.catch.";

    /* renamed from: c, reason: collision with root package name */
    private Context f2506c;

    /* renamed from: cn.jiguang.bq.a$a, reason: collision with other inner class name */
    private static final class C0036a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f2510a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0036a.f2510a;
    }

    public void b() {
        long longValue = ((Long) cn.jiguang.e.b.a(this.f2506c, cn.jiguang.e.a.d())).longValue();
        if (0 == longValue) {
            longValue = System.currentTimeMillis();
            cn.jiguang.e.b.a(this.f2506c, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.d().a((cn.jiguang.e.a<Long>) Long.valueOf(longValue))});
        }
        if (System.currentTimeMillis() - longValue < 86400000) {
            f.c("ExceptMonitorManager", "it not business time, interval: 86400000");
        } else {
            d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bq.a.1
                @Override // cn.jiguang.by.b
                public void a() {
                    try {
                        synchronized (a.class) {
                            a(a.f2505b);
                            a(a.f2504a);
                            cn.jiguang.e.b.a(a.this.f2506c, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.d().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
                        }
                    } catch (Throwable th) {
                        f.i("ExceptMonitorManager", "save data error:" + th.getMessage());
                    }
                }

                private void a(String str) {
                    JSONObject a6 = j.a(str);
                    if (a6 == null || !a6.has("data")) {
                        f.c("ExceptMonitorManager", "exception not has data:" + str);
                        return;
                    }
                    f.c("ExceptMonitorManager", "start report exception monitor data:" + str);
                    cn.jiguang.be.b.a(a.this.f2506c, a6, "sdk_moniter");
                    j.d(str);
                }
            });
        }
    }

    public void a(Context context) {
        if (this.f2506c == null) {
            this.f2506c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            f2505b += cn.jiguang.bz.a.a(this.f2506c).replace(this.f2506c.getPackageName(), "");
        }
    }

    public void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.k())).booleanValue()) {
                a(TextUtils.equals(str2, "EX_ANR") ? new cn.jiguang.bs.a(context, str) : new cn.jiguang.bs.b(context, str));
            }
        } else {
            f.i("ExceptMonitorManager", "exception occurred for param is null, exType is " + str2);
        }
    }

    private void a(final cn.jiguang.br.a aVar) {
        d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.bq.a.2
            /* JADX WARN: Removed duplicated region for block: B:14:0x006c A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:5:0x0003, B:7:0x0041, B:10:0x004a, B:12:0x0066, B:14:0x006c, B:18:0x00b0, B:19:0x0073, B:23:0x0080, B:27:0x008f, B:31:0x009c, B:34:0x00a8, B:35:0x00b6, B:36:0x00c2, B:42:0x00b3, B:43:0x0054), top: B:4:0x0003, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00b3 A[SYNTHETIC] */
            @Override // cn.jiguang.by.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void a() {
                /*
                    r13 = this;
                    java.lang.Class<cn.jiguang.bq.a> r0 = cn.jiguang.bq.a.class
                    monitor-enter(r0)     // Catch: java.lang.Throwable -> Lc6
                    cn.jiguang.br.a r1 = r2     // Catch: java.lang.Throwable -> L51
                    org.json.JSONObject r1 = r1.b()     // Catch: java.lang.Throwable -> L51
                    java.lang.String r2 = "moniter_type"
                    java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r3 = "timestamp"
                    long r3 = r1.optLong(r3)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r5 = "extra"
                    org.json.JSONObject r5 = r1.optJSONObject(r5)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r6 = "sdk_type"
                    java.lang.String r5 = r5.optString(r6)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r6 = "ExceptMonitorManager"
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
                    r7.<init>()     // Catch: java.lang.Throwable -> L51
                    java.lang.String r8 = "save exception data:"
                    r7.append(r8)     // Catch: java.lang.Throwable -> L51
                    r7.append(r1)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L51
                    cn.jiguang.bb.f.c(r6, r7)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r6 = cn.jiguang.bq.a.c()     // Catch: java.lang.Throwable -> L51
                    org.json.JSONObject r6 = cn.jiguang.bz.j.a(r6)     // Catch: java.lang.Throwable -> L51
                    if (r6 == 0) goto L54
                    java.lang.String r7 = "data"
                    boolean r7 = r6.has(r7)     // Catch: java.lang.Throwable -> L51
                    if (r7 != 0) goto L4a
                    goto L54
                L4a:
                    java.lang.String r7 = "data"
                    org.json.JSONArray r7 = r6.optJSONArray(r7)     // Catch: java.lang.Throwable -> L51
                    goto L65
                L51:
                    r1 = move-exception
                    goto Lc4
                L54:
                    org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L51
                    r6.<init>()     // Catch: java.lang.Throwable -> L51
                    java.lang.String r7 = "type"
                    java.lang.String r8 = "sdk_moniter"
                    r6.put(r7, r8)     // Catch: java.lang.Throwable -> L51
                    org.json.JSONArray r7 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L51
                    r7.<init>()     // Catch: java.lang.Throwable -> L51
                L65:
                    r8 = 0
                L66:
                    int r9 = r7.length()     // Catch: java.lang.Throwable -> L51
                    if (r8 >= r9) goto Lb3
                    org.json.JSONObject r9 = r7.optJSONObject(r8)     // Catch: java.lang.Throwable -> L51
                    if (r9 != 0) goto L73
                    goto Lb0
                L73:
                    java.lang.String r10 = "moniter_type"
                    java.lang.String r10 = r9.optString(r10)     // Catch: java.lang.Throwable -> L51
                    boolean r10 = android.text.TextUtils.equals(r2, r10)     // Catch: java.lang.Throwable -> L51
                    if (r10 != 0) goto L80
                    goto Lb0
                L80:
                    java.lang.String r10 = "timestamp"
                    long r10 = r9.optLong(r10)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r12 = "extra"
                    org.json.JSONObject r9 = r9.optJSONObject(r12)     // Catch: java.lang.Throwable -> L51
                    if (r9 != 0) goto L8f
                    goto Lb0
                L8f:
                    java.lang.String r12 = "sdk_type"
                    java.lang.String r12 = r9.optString(r12)     // Catch: java.lang.Throwable -> L51
                    boolean r12 = android.text.TextUtils.equals(r5, r12)     // Catch: java.lang.Throwable -> L51
                    if (r12 != 0) goto L9c
                    goto Lb0
                L9c:
                    java.lang.String r12 = "count"
                    int r12 = r9.optInt(r12)     // Catch: java.lang.Throwable -> L51
                    boolean r10 = cn.jiguang.bz.y.a(r3, r10)     // Catch: java.lang.Throwable -> L51
                    if (r10 == 0) goto Lb0
                    java.lang.String r1 = "count"
                    int r12 = r12 + 1
                    r9.put(r1, r12)     // Catch: java.lang.Throwable -> L51
                    goto Lb6
                Lb0:
                    int r8 = r8 + 1
                    goto L66
                Lb3:
                    r7.put(r1)     // Catch: java.lang.Throwable -> L51
                Lb6:
                    java.lang.String r1 = "data"
                    r6.put(r1, r7)     // Catch: java.lang.Throwable -> L51
                    java.lang.String r1 = cn.jiguang.bq.a.c()     // Catch: java.lang.Throwable -> L51
                    cn.jiguang.bz.j.a(r1, r6)     // Catch: java.lang.Throwable -> L51
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L51
                    return
                Lc4:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L51
                    throw r1     // Catch: java.lang.Throwable -> Lc6
                Lc6:
                    r0 = move-exception
                    java.lang.String r1 = "ExceptMonitorManager"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "save data failed, "
                    r2.append(r3)
                    java.lang.String r0 = r0.getMessage()
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    cn.jiguang.bb.f.i(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bq.a.AnonymousClass2.a():void");
            }
        });
    }
}
