package com.bytedance.sdk.component.j;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class az {

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, Object> f26477j = new ConcurrentHashMap();

    public static az j() {
        return new az();
    }

    public az j(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f26477j.put(str, obj);
        }
        return this;
    }

    public String xt() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.f26477j.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private az() {
    }
}
