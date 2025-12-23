package com.bytedance.sdk.openadsdk.core.mi;

import com.bytedance.sdk.openadsdk.core.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.openadsdk.az.j {
    private com.bytedance.sdk.openadsdk.az.r up() {
        String m6 = com.bytedance.sdk.openadsdk.core.tl.j.m();
        m6.getClass();
        switch (m6) {
            case "2g":
                return com.bytedance.sdk.openadsdk.az.r.TYPE_2G;
            case "3g":
                return com.bytedance.sdk.openadsdk.az.r.TYPE_3G;
            case "4g":
                return com.bytedance.sdk.openadsdk.az.r.TYPE_4G;
            case "5g":
                return com.bytedance.sdk.openadsdk.az.r.TYPE_5G;
            case "wifi":
                return com.bytedance.sdk.openadsdk.az.r.TYPE_WIFI;
            default:
                return com.bytedance.sdk.openadsdk.az.r.TYPE_UNKNOWN;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.az.j
    public boolean cw() {
        return super.cw();
    }

    @Override // com.bytedance.sdk.openadsdk.az.j
    public com.bytedance.sdk.openadsdk.az.r r() {
        return up();
    }

    @Override // com.bytedance.sdk.openadsdk.az.j
    public boolean xt() {
        return oq.i().up();
    }
}
