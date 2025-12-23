package com.bytedance.sdk.openadsdk.oq.j;

import com.bytedance.sdk.component.j.i;
import com.bytedance.sdk.openadsdk.core.rn;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private WeakReference<rn> f31803j;

    public static void j(i iVar, rn rnVar) {
        iVar.j("startVideoTransform", (com.bytedance.sdk.component.j.up<?, ?>) new m(rnVar));
    }

    public m(rn rnVar) {
        this.f31803j = new WeakReference<>(rnVar);
    }

    @Override // com.bytedance.sdk.component.j.up
    public JSONObject j(JSONObject jSONObject, com.bytedance.sdk.component.j.m mVar) throws Exception {
        rn rnVar;
        JSONObject optJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<rn> weakReference = this.f31803j;
        if (weakReference != null && weakReference.get() != null && jSONObject != null && (rnVar = this.f31803j.get()) != null && (optJSONObject = jSONObject.optJSONObject("videoInfo")) != null) {
            rnVar.j((float) optJSONObject.optDouble("toX"), (float) optJSONObject.optDouble("toY"), (float) optJSONObject.optDouble("pivotX"), (float) optJSONObject.optDouble("pivotY"), jSONObject.optInt("duration"));
        }
        return jSONObject2;
    }
}
