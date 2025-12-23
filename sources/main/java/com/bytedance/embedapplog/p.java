package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bi;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class p extends l {

    /* renamed from: m, reason: collision with root package name */
    private final rn f24030m;
    private final Context up;

    p(Context context, rn rnVar) {
        super(true, false);
        this.up = context;
        this.f24030m = rnVar;
    }

    @Override // com.bytedance.embedapplog.l
    @SuppressLint({"MissingPermission"})
    protected boolean j(JSONObject jSONObject) {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", ri.cw());
        jSONObject.put(bi.F, Build.BRAND);
        jSONObject.put(bi.H, Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.f24030m.nd() ? j(this.up) : this.f24030m.n());
        return true;
    }

    private static String j(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                str = Build.getSerial();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
            str = Build.SERIAL;
        }
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) ? "" : str;
    }
}
