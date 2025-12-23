package com.bytedance.msdk.m.xt;

import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends com.bytedance.sdk.openadsdk.core.wq.r {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw f25196j;

    public tl(com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar) {
        this.f25196j = cwVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wq.r
    public <T> T applyFunction(int i6, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i6 == -99999986) {
            return (T) j().sparseArray();
        }
        return null;
    }

    public PluginValueSet j() {
        Map<String, String> hashMap;
        int i6;
        String str;
        String str2;
        String str3;
        String str4;
        e a6 = e.a();
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar = this.f25196j;
        if (cwVar != null) {
            hashMap = cwVar.j();
        } else {
            hashMap = new HashMap<>();
        }
        a6.f(8468, hashMap);
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar2 = this.f25196j;
        if (cwVar2 != null) {
            i6 = cwVar2.up();
        } else {
            i6 = 0;
        }
        a6.e(8469, i6);
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar3 = this.f25196j;
        String str5 = "";
        if (cwVar3 == null) {
            str = "";
        } else {
            str = cwVar3.cw();
        }
        a6.g(8470, str);
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar4 = this.f25196j;
        if (cwVar4 == null) {
            str2 = "";
        } else {
            str2 = cwVar4.r();
        }
        a6.g(8471, str2);
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar5 = this.f25196j;
        if (cwVar5 == null) {
            str3 = "";
        } else {
            str3 = cwVar5.xt();
        }
        a6.g(8472, str3);
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar6 = this.f25196j;
        if (cwVar6 == null) {
            str4 = "";
        } else {
            str4 = cwVar6.m();
        }
        a6.g(8473, str4);
        com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.cw cwVar7 = this.f25196j;
        if (cwVar7 != null) {
            str5 = cwVar7.ae();
        }
        a6.g(8474, str5);
        return a6.k();
    }
}
