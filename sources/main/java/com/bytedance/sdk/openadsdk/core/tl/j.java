package com.bytedance.sdk.openadsdk.core.tl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.stub.StubApp;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private static String cw;

    /* renamed from: j, reason: collision with root package name */
    private static volatile String f30511j;
    private static volatile String xt;

    public static String cw() {
        return "7.0.1.2";
    }

    public static String j() {
        return "open_news";
    }

    public static String xt() {
        return "1371";
    }

    public static int cw(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e6) {
            vl.j(e6);
            return 0;
        }
    }

    public static String j(Context context) {
        try {
        } catch (Throwable th) {
            vl.xt("getApplicationName:", th);
        }
        if (f30511j != null) {
            return f30511j;
        }
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        if (applicationInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && bundle.keySet() != null) {
            for (String str : bundle.keySet()) {
                if (str != null && str.toLowerCase().contains("channel")) {
                    Object obj = bundle.get(str);
                    jSONObject.putOpt(str, obj != null ? obj.toString() : "");
                }
            }
        }
        f30511j = jSONObject.toString();
        return f30511j;
    }

    @HungeonFlag
    public static String tl() {
        try {
            if (!TextUtils.isEmpty(cw)) {
                return cw;
            }
            String cw2 = com.bytedance.sdk.openadsdk.core.cw.r.j().cw("app_sha1", 2592000000L);
            cw = cw2;
            if (!TextUtils.isEmpty(cw2)) {
                return cw;
            }
            String j6 = com.bytedance.sdk.component.utils.cw.j(v.getContext());
            cw = j6;
            if (!j(j6)) {
                return "";
            }
            cw = cw.toUpperCase(Locale.getDefault());
            com.bytedance.sdk.openadsdk.core.cw.r.j().r("app_sha1", cw);
            return cw;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String xt(Context context) {
        if (xt != null) {
            return xt;
        }
        try {
            PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
            xt = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Exception unused) {
        }
        return xt;
    }

    public static String ae() {
        return kt.cw();
    }

    public static String m() {
        return ws.ae(v.getContext());
    }

    public static String r() {
        return uf.qv();
    }

    public static String up() {
        return oq.i().v();
    }

    private static boolean j(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split(":")) != null && split.length >= 20) {
            for (String str2 : split) {
                if (!"00".equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
