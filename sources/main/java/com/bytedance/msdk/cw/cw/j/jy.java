package com.bytedance.msdk.cw.cw.j;

import android.text.TextUtils;
import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy implements j {
    @Override // com.bytedance.msdk.cw.cw.j.j
    public void xt(j.InterfaceC0365j interfaceC0365j) {
        interfaceC0365j.j((String) null);
    }

    @Override // com.bytedance.msdk.cw.cw.j.j
    public void j(j.InterfaceC0365j interfaceC0365j) {
        com.bytedance.msdk.cw.m.j.xt j6 = interfaceC0365j.j();
        com.bytedance.msdk.api.j.xt mi = j6.mi();
        String j7 = com.bytedance.msdk.core.az.j.j(mi.uf());
        if (!TextUtils.isEmpty(j7)) {
            mi.r(2);
            com.bytedance.msdk.core.oq.xt j8 = com.bytedance.msdk.core.az.j.j(j6.vl(), j7);
            if (j8 != null) {
                j6.j(j8);
                com.bytedance.msdk.j.up.cw.r(MediationConstant.TAG, com.bytedance.msdk.j.up.up.j(j8) + "测试工具加载广告........rit_id:" + mi.v() + " ,slot_id:" + j7);
            } else {
                com.bytedance.msdk.up.m.j(j6.mi(), (String) null, !j6.v(), j6.wq().f24631j, 81012, (Map<String, Object>) null);
                j6.j(new com.bytedance.msdk.api.xt.j(81012, com.bytedance.msdk.api.j.j(81012)));
                return;
            }
        }
        interfaceC0365j.j(interfaceC0365j.j());
    }
}
