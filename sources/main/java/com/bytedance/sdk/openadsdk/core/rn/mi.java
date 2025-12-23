package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class mi {

    /* renamed from: j, reason: collision with root package name */
    private static final String f30115j = null;
    private static long xt = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(Context context) {
        try {
            List<String> j6 = com.bytedance.sdk.openadsdk.core.p.cw.j().j(context);
            if (j6 != null && !j6.isEmpty()) {
                List<String> r5 = r(com.bytedance.sdk.openadsdk.core.xt.j().xt("install_app_string", f30115j));
                xt(j(j6));
                if (r5 != null && !r5.isEmpty()) {
                    j6.removeAll(r5);
                }
                cw(j(j6));
            }
        } catch (Exception unused) {
        }
    }

    public static JSONArray j(final Context context) {
        if (System.currentTimeMillis() - xt <= 1000) {
            return null;
        }
        xt = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.p.tl.r() || !xt() || !com.bytedance.sdk.openadsdk.core.v.xt().om() || !com.bytedance.sdk.openadsdk.core.oq.i().w().xt()) {
            return null;
        }
        com.bytedance.sdk.component.oq.ae.j(new com.bytedance.sdk.component.oq.g("getIncrementalInstallApps") { // from class: com.bytedance.sdk.openadsdk.core.rn.mi.1
            @Override // java.lang.Runnable
            public void run() {
                mi.cw(context);
            }
        }, 1);
        return j();
    }

    private static void xt(String str) {
        com.bytedance.sdk.openadsdk.core.xt.j().j("install_app_string", str);
    }

    private static List<String> r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    private static boolean xt() {
        long xt2 = com.bytedance.sdk.openadsdk.core.xt.j().xt("apptime", -1L);
        return xt2 == -1 || System.currentTimeMillis() - xt2 > 43200000;
    }

    private static void cw(String str) {
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.xt.j();
        j6.j("install_app_incremental_string", str);
        j6.j("apptime", System.currentTimeMillis());
    }

    private static JSONArray j() {
        try {
            String xt2 = com.bytedance.sdk.openadsdk.core.xt.j().xt("install_app_incremental_string", f30115j);
            if (TextUtils.isEmpty(xt2)) {
                return null;
            }
            return new JSONArray((Collection) r(xt2));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < list.size(); i6++) {
            sb.append(list.get(i6));
            if (i6 != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            j(0, 0, null);
            return false;
        }
        if (uf.xt(com.bytedance.sdk.openadsdk.core.v.getContext()) && !uf.cw(com.bytedance.sdk.openadsdk.core.v.getContext(), str)) {
            j(0, 0, null);
        }
        return false;
    }

    private static void j(final int i6, final int i7, final String str) {
        com.bytedance.sdk.openadsdk.core.kt.xt.cw().j(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.mi.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("call_api_status", i6);
                    jSONObject.put("has_actived", i7);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("call_active_api").xt(jSONObject.toString());
            }
        }, "call_active_api", true);
    }
}
