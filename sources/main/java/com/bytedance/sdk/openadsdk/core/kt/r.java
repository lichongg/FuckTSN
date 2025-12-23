package com.bytedance.sdk.openadsdk.core.kt;

import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.rn.f;

@ATS(single = true, value = {"embed_applog"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements com.bytedance.sdk.component.r.xt {
    @Override // com.bytedance.sdk.component.r.xt
    @ATSMethod(1)
    public String j() {
        return com.bytedance.sdk.openadsdk.core.m.j().cw();
    }

    @Override // com.bytedance.sdk.component.r.xt
    @ATSMethod(2)
    public String xt() {
        return f.j(false);
    }

    @Override // com.bytedance.sdk.component.r.xt
    @ATSMethod(3)
    public byte[] j(byte[] bArr, int i6) {
        return com.bytedance.sdk.openadsdk.l.xt.j(bArr, i6);
    }
}
