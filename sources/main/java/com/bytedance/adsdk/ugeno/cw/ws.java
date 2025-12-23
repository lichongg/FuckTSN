package com.bytedance.adsdk.ugeno.cw;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws {
    private JSONObject cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f23623j;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, Object> f23624r;
    private JSONObject xt;

    public void j(Context context) {
        this.f23623j = context;
    }

    public void xt(JSONObject jSONObject) {
        this.cw = jSONObject;
    }

    public Context getContext() {
        return this.f23623j;
    }

    public void j(JSONObject jSONObject) {
        this.xt = jSONObject;
    }

    public Map<String, Object> xt() {
        return this.f23624r;
    }

    public JSONObject j() {
        return this.cw;
    }

    public void j(Map<String, Object> map) {
        this.f23624r = map;
    }
}
