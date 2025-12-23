package com.bytedance.sdk.openadsdk.core.qv;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    public static com.bytedance.sdk.openadsdk.core.qv.xt.cw j(Context context, n nVar, String str, boolean z5) {
        return new com.bytedance.sdk.openadsdk.core.qv.cw.ae(context, nVar, str, z5);
    }

    public static com.bytedance.sdk.openadsdk.core.qv.xt.cw j(Context context, String str, n nVar, String str2) {
        return new com.bytedance.sdk.openadsdk.core.qv.cw.g(context, str, nVar, str2, uf.f(nVar));
    }

    public static com.bytedance.sdk.openadsdk.core.qv.xt.r xt(Context context, n nVar, String str, boolean z5) {
        if (uf.xt(context)) {
            return new com.bytedance.sdk.openadsdk.core.qv.cw.r(context, nVar, str, z5);
        }
        return new com.bytedance.sdk.openadsdk.core.qv.cw.j(context, nVar, str, z5);
    }
}
