package cn.jiguang.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.w;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e extends cn.jiguang.m.a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3213a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f3214b;

    /* renamed from: cn.jiguang.r.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f3215a = new e(null);
    }

    private e() {
    }

    public static e a() {
        return a.f3215a;
    }

    /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void e() {
        try {
            Object obj = this.f3214b.get("data");
            if (obj != null) {
                String k6 = w.k(cn.jiguang.d.a.c(obj.toString()));
                cn.jiguang.m.b.v(this.f3213a, k6);
                cn.jiguang.bb.f.c("JDeviceIds", "device ids refresh cache success, hash-ids: " + k6);
            }
        } catch (Exception e6) {
            cn.jiguang.bb.f.i("JDeviceIds", "ids encrypted failed, err: " + e6.getMessage());
        }
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3213a = context;
        return "JDeviceIds";
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        String str2;
        if (cn.jiguang.g.a.a().g(1900)) {
            return;
        }
        try {
            JSONObject a6 = cn.jiguang.x.a.a(context);
            if (a6 == null) {
                cn.jiguang.bb.f.i("JDeviceIds", "ids collect failed");
                return;
            }
            if (!a(a6)) {
                cn.jiguang.bb.f.c("JDeviceIds", "ids not changed, need not report");
                return;
            }
            try {
                str2 = cn.jiguang.d.a.b(a6.toString());
            } catch (Exception e6) {
                cn.jiguang.bb.f.i("JDeviceIds", "ids encrypted failed, err: " + e6.getMessage());
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (this.f3214b == null) {
                this.f3214b = new JSONObject();
            }
            this.f3214b.put("data", str2);
            cn.jiguang.bb.f.c("JDeviceIds", "collect success:" + this.f3214b + ", origin ids: " + a6.toString());
            super.c(context, str);
        } catch (JSONException e7) {
            cn.jiguang.bb.f.i("JDeviceIds", "packageJson exception: " + e7.getMessage());
        }
    }

    private boolean a(JSONObject jSONObject) {
        if (TextUtils.isEmpty(cn.jiguang.m.b.l(this.f3213a))) {
            cn.jiguang.bb.f.c("JDeviceIds", "ids cache is empty");
        } else {
            try {
                return !r0.equals(w.k(jSONObject.toString()));
            } catch (Exception e6) {
                cn.jiguang.bb.f.i("JDeviceIds", "[checkIdsChanged] toHash error: " + e6.getMessage());
            }
        }
        return true;
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (cn.jiguang.g.a.a().g(1900)) {
            return;
        }
        JSONObject jSONObject = this.f3214b;
        if (jSONObject == null) {
            cn.jiguang.bb.f.i("JDeviceIds", "there are no data to report");
            return;
        }
        cn.jiguang.be.b.a(context, jSONObject, "sdk_joa");
        super.d(context, str);
        e();
        cn.jiguang.bb.f.c("JDeviceIds", str + "report success, reportData: " + this.f3214b);
        this.f3214b = null;
    }
}
