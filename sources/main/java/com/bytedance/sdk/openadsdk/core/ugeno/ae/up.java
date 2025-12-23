package com.bytedance.sdk.openadsdk.core.ugeno.ae;

import com.bytedance.sdk.openadsdk.core.v.xt;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    public interface j {
        void j(JSONObject jSONObject);
    }

    public static void j(com.bytedance.sdk.openadsdk.core.ugeno.m.j jVar, j jVar2) {
        if (jVar == null) {
            if (jVar2 != null) {
                jVar2.j(null);
            }
        } else {
            j(jVar.cw(), jVar.j(), jVar.xt(), jVar2);
        }
    }

    public static void j(String str, String str2, String str3, final j jVar) {
        JSONObject j6 = com.bytedance.sdk.openadsdk.core.ugeno.ae.j().j(str2, str3);
        if (j6 == null) {
            com.bytedance.sdk.openadsdk.core.v.xt.j(str, str2, str3, new xt.InterfaceC0490xt() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ae.up.1
                @Override // com.bytedance.sdk.openadsdk.core.v.xt.InterfaceC0490xt
                public void j(JSONObject jSONObject) {
                    j jVar2 = j.this;
                    if (jVar2 != null) {
                        jVar2.j(jSONObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.v.xt.InterfaceC0490xt
                public void j() {
                    j jVar2 = j.this;
                    if (jVar2 != null) {
                        jVar2.j(null);
                    }
                }
            });
        } else if (jVar != null) {
            jVar.j(j6);
        }
    }
}
