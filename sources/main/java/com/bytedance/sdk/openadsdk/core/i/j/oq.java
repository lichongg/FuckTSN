package com.bytedance.sdk.openadsdk.core.i.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends com.bytedance.sdk.component.j.up<JSONObject, JSONObject> {

    /* renamed from: j, reason: collision with root package name */
    private n f29149j;
    private List<JSONObject> xt;

    public static void j(com.bytedance.sdk.component.j.i iVar, n nVar, List<JSONObject> list) {
        iVar.j("getAdsData", (com.bytedance.sdk.component.j.up<?, ?>) new oq(nVar, list));
    }

    public oq(n nVar, List<JSONObject> list) {
        this.f29149j = nVar;
        this.xt = list;
    }

    @Override // com.bytedance.sdk.component.j.up
    @Nullable
    public JSONObject j(@NonNull JSONObject jSONObject, @NonNull com.bytedance.sdk.component.j.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        int optInt = jSONObject != null ? jSONObject.optInt("ads_num", 3) : -1;
        if (optInt < 0) {
            optInt = 3;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("creatives", new JSONArray().put(this.f29149j.tv()));
        jSONObject2.put("firstRes", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        List<JSONObject> list = this.xt;
        if (list != null && list.size() > 0) {
            if (optInt > this.xt.size()) {
                optInt = this.xt.size();
            }
            int min = Math.min(optInt, 3);
            for (int i6 = 0; i6 < min; i6++) {
                jSONArray.put(i6, this.xt.get(i6));
            }
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("creatives", jSONArray);
        jSONObject2.put("secondRes", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("data", jSONObject2);
        return jSONObject5;
    }
}
