package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.embedapplog.up;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class f {
    private static volatile boolean cw = false;

    /* renamed from: j, reason: collision with root package name */
    private static volatile String f30073j = "";
    private static volatile String xt = "";

    public static String cw(com.bytedance.sdk.openadsdk.av.r rVar) {
        if (rVar == null) {
            return null;
        }
        String type = rVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, "timeout")) {
            return "timeout";
        }
        up.j j6 = rVar.j();
        return (j6 == null || TextUtils.isEmpty(j6.f24072j)) ? "error" : j6.f24072j;
    }

    public static void j(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            cw = true;
            f30073j = str;
            com.bytedance.sdk.openadsdk.tools.xt.xt(7, f30073j == null ? "" : f30073j);
            update();
        } catch (Throwable unused) {
        }
    }

    public static String xt(com.bytedance.sdk.openadsdk.av.r rVar) {
        JSONObject j6;
        if (rVar != null) {
            String type = rVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, "timeout")) {
                return "timeout";
            }
            up.j j7 = rVar.j();
            if (j7 != null && !TextUtils.isEmpty(j7.f24072j) && (j6 = j(j7)) != null) {
                return j6.toString();
            }
        }
        return "error";
    }

    private static void update() {
        if (TextUtils.isEmpty(f30073j)) {
            return;
        }
        String xt2 = com.bytedance.sdk.component.utils.j.xt(f30073j);
        com.bytedance.sdk.openadsdk.core.cw.r.j().r("app_log_oaid", f30073j);
        com.bytedance.sdk.openadsdk.core.cw.r.j().r("new_app_log_oaid", xt2);
    }

    public static void j(com.bytedance.sdk.openadsdk.av.r rVar) {
        com.bytedance.sdk.openadsdk.j.j.j.j(rVar);
        com.bytedance.sdk.openadsdk.core.live.xt.j().j(rVar);
    }

    public static up.j cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new up.j(str, false, j(com.bytedance.sdk.openadsdk.core.v.getContext()));
    }

    private static JSONObject j(up.j jVar) {
        if (jVar == null) {
            return null;
        }
        String str = jVar.f24072j;
        long j6 = jVar.cw;
        boolean z5 = jVar.xt;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(z5));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(j6));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("oaid", str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(j(com.bytedance.sdk.openadsdk.core.v.getContext())));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    private static int j(Context context) {
        String str = "com.huawei.hwid.tv";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                str = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                str = "com.huawei.hms";
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return 0;
        }
    }

    public static String j(boolean z5) {
        long j6;
        if (!TextUtils.isEmpty(f30073j)) {
            return f30073j;
        }
        if (z5 && !TextUtils.isEmpty(xt)) {
            return xt;
        }
        try {
            String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("new_app_log_oaid", (String) null);
            if (TextUtils.isEmpty(cw2)) {
                j6 = 0;
            } else {
                JSONObject jSONObject = new JSONObject(cw2);
                xt = com.bytedance.sdk.component.utils.j.cw(jSONObject.getString("value"));
                j6 = jSONObject.getLong("time");
            }
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(xt) && (z5 || System.currentTimeMillis() - j6 < 86400000)) {
            return xt;
        }
        if (!cw) {
            com.bytedance.sdk.openadsdk.core.m.j().xt();
            com.bytedance.sdk.openadsdk.i.cw.cw.r kt = com.bytedance.sdk.openadsdk.core.oq.i().kt();
            if (kt != null && !TextUtils.isEmpty(kt.vl())) {
                f30073j = kt.vl();
                update();
            }
            com.bytedance.sdk.openadsdk.tools.xt.xt(7, f30073j == null ? "" : f30073j);
        }
        if (TextUtils.isEmpty(f30073j) && !TextUtils.isEmpty(xt) && com.bytedance.sdk.openadsdk.core.oq.i().g()) {
            return xt;
        }
        return f30073j == null ? "" : f30073j;
    }
}
