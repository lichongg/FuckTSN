package com.bytedance.sdk.openadsdk.core.i.j;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private String f29138j;
    private Context xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, Context context) {
        iVar.j("closeView", (com.bytedance.sdk.component.j.up<?, ?>) new j("closeView", context));
    }

    public j(String str, Context context) {
        this.f29138j = str;
        this.xt = context;
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.f29138j;
        str.getClass();
        if (!str.equals("closeView")) {
            return jSONObject2;
        }
        Context context = this.xt;
        if (context != null) {
            ((Activity) context).finish();
            jSONObject2.put("success", true);
            return jSONObject2;
        }
        jSONObject2.put("success", false);
        return jSONObject2;
    }
}
