package com.bytedance.sdk.openadsdk.core.cw;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sdk.component.panglearmor.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.v;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private static volatile m f28840j;

    public static m j() {
        if (f28840j == null) {
            synchronized (m.class) {
                try {
                    if (f28840j == null) {
                        f28840j = new m();
                    }
                } finally {
                }
            }
        }
        return f28840j;
    }

    public com.bytedance.sdk.openadsdk.core.l.xt xt(String str) {
        int i6;
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.l.xt xtVar = new com.bytedance.sdk.openadsdk.core.l.xt();
        HashMap hashMap = new HashMap();
        try {
            xtVar.j(str.length());
            Pair<Integer, JSONObject> j6 = j().j(str, false);
            if (j6 != null) {
                JSONObject jSONObject2 = (JSONObject) j6.second;
                try {
                    Object obj = j6.first;
                    i6 = obj != null ? ((Integer) obj).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                i6 = 3;
            }
            jSONObject.put("ad_sdk_version", h.cw);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
            if (i6 != 3) {
                hashMap.put("x-ad-sdk-version", h.cw);
                hashMap.put("x-plugin-version", "7.0.1.2");
                hashMap.put("x-pglcypher", String.valueOf(i6));
            }
        } catch (Throwable unused2) {
        }
        xtVar.j(hashMap);
        xtVar.xt(jSONObject);
        return xtVar;
    }

    private Pair<Integer, JSONObject> m(String str) {
        return r(str);
    }

    public Pair<Integer, ?> cw(String str) {
        try {
            if (!TextUtils.isEmpty(str) && v.xt().ik()) {
                return j(str, "get_ad");
            }
        } catch (Throwable th) {
            vl.cw(th.getMessage());
        }
        return r(str);
    }

    public Pair<Integer, JSONObject> r(String str) {
        return new Pair<>(3, com.bytedance.sdk.component.utils.j.j(str));
    }

    public JSONObject up(String str) {
        if (!TextUtils.isEmpty(str) && g.xt()) {
            try {
                byte[] j6 = g.j().j(str.getBytes(StandardCharsets.UTF_8));
                if (j6 != null) {
                    String encodeToString = Base64.encodeToString(j6, 0);
                    if (!TextUtils.isEmpty(encodeToString)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(CrashHianalyticsData.MESSAGE, encodeToString);
                        jSONObject.put("cypher", 4);
                        return jSONObject;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.l.xt j(String str) {
        int i6;
        Object obj;
        com.bytedance.sdk.openadsdk.core.l.xt xtVar = new com.bytedance.sdk.openadsdk.core.l.xt();
        HashMap hashMap = new HashMap();
        try {
            xtVar.j(str.length());
            Pair<Integer, ?> cw = j().cw(str);
            i6 = 3;
            if (cw != null) {
                obj = cw.second;
                Object obj2 = cw.first;
                if (obj2 != null) {
                    i6 = ((Integer) obj2).intValue();
                }
            } else {
                obj = null;
            }
        } catch (Throwable unused) {
        }
        if (i6 == 4) {
            hashMap.put("x-ad-sdk-version", h.cw);
            hashMap.put("x-plugin-version", "7.0.1.2");
            hashMap.put("x-pglcypher", String.valueOf(i6));
            hashMap.put("Content-Type", "application/octet-stream");
            xtVar.j((byte[]) obj);
            xtVar.j(hashMap);
            return xtVar;
        }
        JSONObject jSONObject = (JSONObject) obj;
        jSONObject.put("ad_sdk_version", h.cw);
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.0.1.2");
        xtVar.xt(jSONObject);
        xtVar.j(hashMap);
        return xtVar;
    }

    private Pair<Integer, JSONObject> xt(String str, boolean z5) {
        JSONObject up = (TextUtils.isEmpty(str) || !g.xt()) ? null : up(str);
        if (up != null && !TextUtils.isEmpty(up.optString(CrashHianalyticsData.MESSAGE))) {
            return new Pair<>(4, up);
        }
        if (g.xt() && z5) {
            ws.j().j(3, -1L, (String) null);
        }
        return m(str);
    }

    private static String xt(byte[] bArr, String str) {
        int i6;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    byte[] xt = g.j().xt(bArr);
                    String xt2 = com.bytedance.sdk.openadsdk.core.rn.vl.xt(xt);
                    if (!TextUtils.isEmpty(xt2)) {
                        return xt2;
                    }
                    ws j6 = ws.j();
                    if (xt != null && xt.length != 0) {
                        i6 = 2;
                        j6.j(i6, -1L, str);
                        return null;
                    }
                    i6 = 1;
                    j6.j(i6, -1L, str);
                    return null;
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        return null;
    }

    public Pair<Integer, JSONObject> j(String str, boolean z5) {
        try {
            if (v.xt().ik()) {
                return xt(str, z5);
            }
        } catch (Throwable th) {
            vl.cw(th.getMessage());
        }
        return r(str);
    }

    public Pair<Integer, ?> j(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str)) {
            return m(str);
        }
        if (g.xt()) {
            bArr = g.j().j(com.bytedance.sdk.openadsdk.core.rn.vl.j(str.getBytes(StandardCharsets.UTF_8)));
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            return new Pair<>(4, bArr);
        }
        if (g.xt()) {
            ws.j().j(3, -1L, str2);
        }
        return m(str);
    }

    public static Pair<Boolean, JSONObject> j(com.bytedance.sdk.component.g.xt xtVar, String str, boolean z5) {
        if (com.bytedance.sdk.component.g.r.j.j(xtVar.cw())) {
            return new Pair<>(Boolean.FALSE, j(xtVar.oq(), str));
        }
        String r5 = xtVar.r();
        if (r5 != null && !r5.startsWith("{") && !r5.endsWith("}") && !r5.contains(CrashHianalyticsData.MESSAGE) && !r5.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, j(xtVar.oq(), str));
        }
        JSONObject jSONObject = null;
        if (r5 != null) {
            try {
                jSONObject = new JSONObject(r5);
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return new Pair<>(Boolean.TRUE, j(jSONObject, true, z5));
    }

    public static JSONObject j(JSONObject jSONObject, boolean z5, boolean z6) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String j6 = j(jSONObject, z5);
            String optString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(j6)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(j6);
            if (!z6) {
                return jSONObject2;
            }
            try {
                jSONObject2.put("auction_price", optString);
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String j(JSONObject jSONObject, boolean z5) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            if (optInt == 3) {
                return com.bytedance.sdk.component.utils.j.cw(optString);
            }
            if (optInt == 4) {
                optString = g.j().j(optString);
                if (TextUtils.isEmpty(optString) && z5) {
                    ws.j().j(1, -1L, (String) null);
                }
            }
            return optString;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject j(byte[] bArr, String str) {
        try {
            String xt = xt(bArr, str);
            if (TextUtils.isEmpty(xt)) {
                return null;
            }
            return new JSONObject(xt);
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }
}
