package com.bytedance.sdk.openadsdk.av;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.mi;
import com.bytedance.sdk.openadsdk.core.v;
import com.kuaishou.weapon.p0.g;
import com.umeng.analytics.pro.bi;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static String f27626j;

    public static void j(JSONObject jSONObject) {
        try {
            float f6 = 0.0f;
            float f7 = com.bytedance.sdk.openadsdk.core.rn.r.j() == null ? 0.0f : com.bytedance.sdk.openadsdk.core.rn.r.j().f30062j;
            if (com.bytedance.sdk.openadsdk.core.rn.r.j() != null) {
                f6 = com.bytedance.sdk.openadsdk.core.rn.r.j().xt;
            }
            jSONObject.put("latitude", f7);
            jSONObject.put("longitude", f6);
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    public static void xt(JSONObject jSONObject) {
        try {
            jSONObject.put("imei", kt.ae());
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    public static String r() {
        return "";
    }

    private static String up() {
        if (TextUtils.isEmpty(f27626j)) {
            String ae = kt.ae();
            if (!TextUtils.isEmpty(ae)) {
                f27626j = up.xt(ae);
            }
        }
        return f27626j;
    }

    public static void cw() {
        com.bytedance.sdk.openadsdk.core.p.cw.j().xt();
    }

    public static void xt(Context context, JSONObject jSONObject) {
        try {
            JSONArray j6 = mi.j(context);
            if (j6 != null) {
                jSONObject.put("app_list", j6);
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    public static void j(com.bytedance.sdk.openadsdk.i.cw.cw.r rVar, List<String> list) {
        if (rVar.j()) {
            list.add(g.f36048h);
            list.add(g.f36047g);
        }
    }

    public static void xt() {
        com.bytedance.sdk.openadsdk.core.rn.r.j();
    }

    public static void j(JSONObject jSONObject, int i6) {
        if (com.bytedance.sdk.openadsdk.core.rn.r.j() != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("latitude", r5.f30062j);
                jSONObject2.put("longitude", r5.xt);
                jSONObject.put("geo", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    public static String j() {
        if (oq.i().w().r()) {
            return kt.oq();
        }
        return null;
    }

    public static void j(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("udid", kt.ae());
            jSONObject.put(bi.A, kt.f());
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public static boolean j(String str) {
        return mi.j(str);
    }

    public static void j(Context context) {
        if ((v.xt().to() & 8) != 0) {
            return;
        }
        j.j(context);
    }
}
