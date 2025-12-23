package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.analytics.pro.d;
import java.util.Map;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class ws implements com.bytedance.sdk.component.qv.j.j.cw {

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n f29086j;

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        Context context;
        n nVar = this.f29086j;
        if (nVar == null || (context = this.xt) == null) {
            jVar.xt(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.rn.m.j(context, nVar);
        jVar.j(map2);
        return true;
    }
}
