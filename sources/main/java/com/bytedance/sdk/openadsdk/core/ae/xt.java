package com.bytedance.sdk.openadsdk.core.ae;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private int f27953j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f27954r;
    private int xt;

    public int cw() {
        return this.cw;
    }

    public int j() {
        return this.f27953j;
    }

    public int xt() {
        return this.xt;
    }

    public void cw(int i6) {
        this.cw = i6;
    }

    public void j(int i6) {
        this.f27953j = i6;
    }

    public boolean r() {
        return this.f27954r;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", xt());
            jSONObject.put("log_level", j());
            jSONObject.put("max_size", cw());
            jSONObject.put("is_open", r());
        } catch (JSONException e6) {
            vl.j(e6);
        }
        return jSONObject.toString();
    }

    public void xt(int i6) {
        this.xt = i6;
    }

    public static xt j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return j(new JSONObject(str));
        } catch (JSONException e6) {
            vl.xt("CLogConfig", "parse failed:".concat(String.valueOf(e6)));
            return null;
        }
    }

    public static xt j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xt xtVar = new xt();
        xtVar.xt(jSONObject.optInt("expire_days"));
        xtVar.j(jSONObject.optInt("log_level"));
        xtVar.cw(jSONObject.optInt("max_size"));
        xtVar.j(jSONObject.optBoolean("is_open"));
        return xtVar;
    }

    public void j(boolean z5) {
        this.f27954r = z5;
    }
}
