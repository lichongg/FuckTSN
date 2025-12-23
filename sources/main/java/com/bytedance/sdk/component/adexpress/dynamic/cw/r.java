package com.bytedance.sdk.component.adexpress.dynamic.cw;

import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public String cw;

    /* renamed from: j, reason: collision with root package name */
    public List<j> f25630j;

    /* renamed from: r, reason: collision with root package name */
    public String f25631r;
    public String xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        public int f25632j;
        public JSONObject xt;
    }

    public static r j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        r rVar = new r();
        String optString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    j jVar = new j();
                    jVar.f25632j = optJSONObject.optInt("id");
                    jVar.xt = new JSONObject(optJSONObject.optString("componentLayout"));
                    arrayList.add(jVar);
                }
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
        rVar.f25630j = arrayList;
        rVar.xt = jSONObject.optString("diff_data");
        rVar.cw = jSONObject.optString("style_diff");
        rVar.f25631r = jSONObject.optString("tag_diff");
        return rVar;
    }
}
