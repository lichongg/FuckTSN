package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f38359a;

    /* renamed from: b, reason: collision with root package name */
    public int f38360b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f38361c;

    /* renamed from: d, reason: collision with root package name */
    public String f38362d;

    /* renamed from: e, reason: collision with root package name */
    public String f38363e;

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f38359a);
            jSONObject.put("error_code", String.valueOf(this.f38360b));
            jSONObject.put("error_msg", this.f38361c);
            jSONObject.put("real_device_plan", this.f38362d);
            jSONObject.put("device_plans", this.f38363e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar.f38363e = jSONObject.optString("device_plans", null);
            dVar.f38362d = jSONObject.optString("real_device_plan", null);
            dVar.f38361c = jSONObject.optString("error_msg", null);
            dVar.f38359a = jSONObject.optString("ah_plan_type", null);
            String optString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(optString)) {
                dVar.f38360b = -1;
                return dVar;
            }
            dVar.f38360b = Integer.parseInt(optString);
            return dVar;
        } catch (Throwable th) {
            vl.j(th);
            return dVar;
        }
    }

    public String b() {
        return d().toString();
    }
}
