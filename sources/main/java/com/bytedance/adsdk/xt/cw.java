package com.bytedance.adsdk.xt;

import com.bytedance.adsdk.ugeno.r.j;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw implements com.bytedance.adsdk.ugeno.r.j {

    static class j implements j.InterfaceC0323j {

        /* renamed from: j, reason: collision with root package name */
        private com.bytedance.adsdk.xt.xt.j f23945j;
        private String xt;

        public static j j(String str) {
            return new j(str);
        }

        @Override // com.bytedance.adsdk.ugeno.r.j.InterfaceC0323j
        public Object j(JSONObject jSONObject) {
            com.bytedance.adsdk.xt.xt.j jVar = this.f23945j;
            if (jVar == null) {
                return this.xt;
            }
            Object j6 = jVar.j(jSONObject);
            return j6 instanceof String ? j6 : j6 instanceof com.bytedance.adsdk.xt.xt.j.j ? String.valueOf(qv.j((com.bytedance.adsdk.xt.xt.j.j) j6)) : String.valueOf(j6);
        }

        private j(String str) {
            this.xt = str;
            this.f23945j = com.bytedance.adsdk.xt.xt.j.j(str);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.r.j
    public j.InterfaceC0323j j(String str) {
        return j.j(str);
    }
}
