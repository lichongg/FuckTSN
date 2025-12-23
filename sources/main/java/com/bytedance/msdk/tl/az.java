package com.bytedance.msdk.tl;

import com.bytedance.sdk.openadsdk.ats.AutoService;

/* loaded from: D:\Downloads\app\classes3.dex */
public class az {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f25207j = true;

    public static byte[] j(byte[] bArr, int i6) {
        com.bytedance.sdk.component.r.xt xtVar = (com.bytedance.sdk.component.r.xt) AutoService.j(com.bytedance.sdk.component.r.xt.class);
        return xtVar != null ? xtVar.j(bArr, i6) : new byte[0];
    }

    static {
        try {
            com.bytedance.sdk.openadsdk.l.m.j("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError unused) {
            f25207j = false;
        }
    }

    public static boolean j() {
        com.bytedance.msdk.j.up.cw.xt("TMe", "applogSOLoadSuccess = " + f25207j);
        return f25207j;
    }
}
