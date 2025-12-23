package com.bytedance.msdk.core.qv;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.oq;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f24676j;

    /* renamed from: m, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24677m;

    /* renamed from: r, reason: collision with root package name */
    private xt f24678r;
    private boolean xt = false;
    private boolean cw = false;
    private boolean up = false;

    public static j j() {
        if (f24676j == null) {
            synchronized (j.class) {
                try {
                    if (f24676j == null) {
                        f24676j = new j();
                    }
                } finally {
                }
            }
        }
        return f24676j;
    }

    public boolean cw() {
        return this.xt;
    }

    public void m() {
        this.up = true;
    }

    public void xt() {
        this.xt = true;
    }

    public Function<SparseArray<Object>, Object> ae() {
        return this.f24677m;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String cw(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L9
            r1.<init>(r3)     // Catch: org.json.JSONException -> L9
            goto Lb
        L9:
        La:
            r1 = r0
        Lb:
            org.json.JSONObject r3 = r2.xt(r1)
            if (r3 == 0) goto L16
            java.lang.String r3 = r3.toString()
            return r3
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.qv.j.cw(java.lang.String):java.lang.String");
    }

    public boolean r() {
        return this.cw;
    }

    public void up() {
        xt xtVar = this.f24678r;
        if (xtVar != null) {
            xtVar.j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String xt(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L9
            r1.<init>(r3)     // Catch: org.json.JSONException -> L9
            goto Lb
        L9:
        La:
            r1 = r0
        Lb:
            org.json.JSONObject r3 = r2.j(r1)
            if (r3 == 0) goto L16
            java.lang.String r3 = r3.toString()
            return r3
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.qv.j.xt(java.lang.String):java.lang.String");
    }

    private j() {
    }

    public JSONObject xt(JSONObject jSONObject) {
        String ff = oq.i().ff();
        if (TextUtils.isEmpty(ff)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("waterfall_ab_version", ff);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        if (jSONObject.has("waterfall_ab_version")) {
            String optString = jSONObject.optString("waterfall_ab_version");
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put("waterfall_ab_version", ff);
                return jSONObject;
            }
            jSONObject.put("waterfall_ab_version", optString + "," + ff);
            return jSONObject;
        }
        jSONObject.put("waterfall_ab_version", ff);
        return jSONObject;
    }

    public void j(boolean z5) {
        this.cw = z5;
    }

    public boolean j(String str, int i6, boolean z5) {
        return z5 || j(str) || com.bytedance.msdk.core.xt.xt().j(str, i6, 101) != null;
    }

    public boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("200000000".equals(str)) {
            return true;
        }
        return str.matches("^1[0-9]{8}$");
    }

    public void j(xt xtVar) {
        this.f24678r = xtVar;
    }

    public void j(int i6, String str) {
        xt xtVar = this.f24678r;
        if (xtVar != null) {
            xtVar.j(i6, str);
        }
    }

    public void j(Function<SparseArray<Object>, Object> function) {
        this.f24677m = function;
    }

    public JSONObject j(JSONObject jSONObject) {
        String ff = oq.i().ff();
        if (TextUtils.isEmpty(ff)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_ab_version", ff);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        if (jSONObject.has("app_ab_version")) {
            String optString = jSONObject.optString("app_ab_version");
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put("app_ab_version", ff);
                return jSONObject;
            }
            jSONObject.put("app_ab_version", optString + "," + ff);
            return jSONObject;
        }
        jSONObject.put("app_ab_version", ff);
        return jSONObject;
    }
}
