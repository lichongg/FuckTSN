package cn.jiguang.h;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.umeng.analytics.pro.bi;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3012a;

    /* renamed from: b, reason: collision with root package name */
    private List<cn.jiguang.common.app.entity.b> f3013b;

    /* renamed from: c, reason: collision with root package name */
    private List<cn.jiguang.common.app.entity.d> f3014c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f3015d;

    /* renamed from: cn.jiguang.h.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f3016a = new f(null);
    }

    private f() {
        this.f3015d = new AtomicBoolean(true);
    }

    public static f a() {
        return a.f3016a;
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        if (cn.jiguang.g.a.a().g(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT)) {
            return;
        }
        this.f3015d.set(false);
        int e6 = cn.jiguang.m.b.e(context);
        int f6 = cn.jiguang.m.b.f(context);
        if (e6 > 0) {
            this.f3013b = cn.jiguang.common.app.helper.b.c(context);
        } else {
            cn.jiguang.bb.f.i("JAppRunning", "can't collect runningApp because reportRunningAppType:" + e6);
        }
        if (f6 > 0) {
            this.f3014c = cn.jiguang.common.app.helper.c.a(context, f6);
        } else {
            cn.jiguang.bb.f.i("JAppRunning", "can't collect runningProcess because reportRunningProcessType:" + f6);
        }
        List<cn.jiguang.common.app.entity.b> list = this.f3013b;
        if (list != null && !list.isEmpty()) {
            cn.jiguang.bb.f.c("JAppRunning", "collect runningAppList success");
        }
        List<cn.jiguang.common.app.entity.d> list2 = this.f3014c;
        if (list2 != null && !list2.isEmpty()) {
            cn.jiguang.bb.f.c("JAppRunning", "collect runningProcessList success");
        }
        super.c(context, str);
    }

    /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3012a = context;
        return "JAppRunning";
    }

    @Override // cn.jiguang.m.a
    protected boolean a_() {
        return cn.jiguang.m.b.k(this.f3012a, "JAppRunning");
    }

    @Override // cn.jiguang.m.a
    protected boolean c() {
        cn.jiguang.bb.f.c("JAppRunning", "for googlePlay:false");
        return cn.jiguang.g.a.a().e(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT);
    }

    @Override // cn.jiguang.m.a
    protected void a(String str, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        try {
            long j6 = optJSONObject.getLong(bi.aX);
            if (j6 == -1) {
                cn.jiguang.m.b.a(this.f3012a, "JAppRunning", false);
                return;
            }
            if (j6 == 0) {
                cn.jiguang.m.b.a(this.f3012a, "JAppRunning", true);
                return;
            }
            int optInt = optJSONObject.optInt("app_type", 0);
            int optInt2 = optJSONObject.optInt("process_type", 0);
            cn.jiguang.m.b.a(this.f3012a, "JAppRunning", true);
            cn.jiguang.m.b.a(this.f3012a, optInt);
            cn.jiguang.m.b.b(this.f3012a, optInt2);
            if (j6 > 0) {
                cn.jiguang.m.b.c(this.f3012a, "JAppRunning", j6);
            }
        } catch (JSONException e6) {
            cn.jiguang.bb.f.i("JAppRunning", "parse interval exception:" + e6.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    @Override // cn.jiguang.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void d(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            cn.jiguang.g.a r0 = cn.jiguang.g.a.a()
            r1 = 1102(0x44e, float:1.544E-42)
            boolean r0 = r0.g(r1)
            if (r0 == 0) goto Le
            goto Lc5
        Le:
            java.util.List<cn.jiguang.common.app.entity.b> r0 = r7.f3013b
            r1 = 128(0x80, float:1.8E-43)
            java.lang.String r2 = "JAppRunning"
            r3 = 0
            if (r0 == 0) goto L3e
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L3e
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.util.List<cn.jiguang.common.app.entity.b> r4 = r7.f3013b
            java.util.Iterator r4 = r4.iterator()
        L28:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r5 = r4.next()
            cn.jiguang.common.app.entity.b r5 = (cn.jiguang.common.app.entity.b) r5
            org.json.JSONObject r5 = r5.c(r1)
            if (r5 == 0) goto L28
            r0.put(r5)
            goto L28
        L3e:
            java.lang.String r0 = "there are no running app to report"
            cn.jiguang.bb.f.i(r2, r0)
            r0 = r3
        L44:
            java.util.List<cn.jiguang.common.app.entity.d> r4 = r7.f3014c
            if (r4 == 0) goto L6f
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L6f
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            java.util.List<cn.jiguang.common.app.entity.d> r5 = r7.f3014c
            java.util.Iterator r5 = r5.iterator()
        L59:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L75
            java.lang.Object r6 = r5.next()
            cn.jiguang.common.app.entity.d r6 = (cn.jiguang.common.app.entity.d) r6
            org.json.JSONObject r6 = r6.a(r1)
            if (r6 == 0) goto L59
            r4.put(r6)
            goto L59
        L6f:
            java.lang.String r1 = "there are no running process to report"
            cn.jiguang.bb.f.i(r2, r1)
            r4 = r3
        L75:
            r7.f3013b = r3
            r7.f3014c = r3
            r1 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: org.json.JSONException -> La0
            r5.<init>()     // Catch: org.json.JSONException -> La0
            r3 = 1
            if (r0 == 0) goto L92
            int r6 = r0.length()     // Catch: org.json.JSONException -> L8f
            if (r6 <= 0) goto L92
            java.lang.String r6 = "app"
            r5.put(r6, r0)     // Catch: org.json.JSONException -> L8f
            r1 = 1
            goto L92
        L8f:
            r0 = move-exception
            r3 = r5
            goto La1
        L92:
            if (r4 == 0) goto Lba
            int r0 = r4.length()     // Catch: org.json.JSONException -> L8f
            if (r0 <= 0) goto Lba
            java.lang.String r0 = "process"
            r5.put(r0, r4)     // Catch: org.json.JSONException -> L8f
            goto Lbb
        La0:
            r0 = move-exception
        La1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "package json exception:"
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            cn.jiguang.bb.f.i(r2, r0)
            r5 = r3
        Lba:
            r3 = r1
        Lbb:
            if (r3 == 0) goto Lc5
            java.lang.String r0 = "app_running"
            cn.jiguang.be.b.a(r8, r5, r0)
            super.d(r8, r9)
        Lc5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.h.f.d(android.content.Context, java.lang.String):void");
    }

    @Override // cn.jiguang.m.a
    protected boolean a(Context context, String str) {
        if (this.f3015d.get()) {
            return true;
        }
        return super.a(context, str);
    }
}
