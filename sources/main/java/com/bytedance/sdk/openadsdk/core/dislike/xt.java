package com.bytedance.sdk.openadsdk.core.dislike;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static com.bytedance.sdk.openadsdk.core.dislike.j.cw f28912j;
    private static com.bytedance.sdk.openadsdk.core.dislike.j.r xt;

    public static void j() {
        if (xt == null) {
            xt = new com.bytedance.sdk.openadsdk.core.dislike.j.r() { // from class: com.bytedance.sdk.openadsdk.core.dislike.xt.1
                @Override // com.bytedance.sdk.openadsdk.core.dislike.j.r
                public int j(Context context, float f6) {
                    return ed.cw(context, f6);
                }
            };
        }
        if (f28912j == null) {
            f28912j = new com.bytedance.sdk.openadsdk.core.dislike.j.cw() { // from class: com.bytedance.sdk.openadsdk.core.dislike.xt.2
                @Override // com.bytedance.sdk.openadsdk.core.dislike.j.cw
                public void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, m mVar) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(xtVar, mVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.j.cw
                public void j(Context context, com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, String str) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.j(xtVar.cw(), xtVar.r(), xtVar.ae(), str);
                }
            };
        }
        com.bytedance.sdk.openadsdk.core.dislike.j.j.j(f28912j, xt);
    }
}
