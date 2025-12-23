package com.bytedance.sdk.openadsdk.core.component.reward.j;

import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j f28295j = new com.bytedance.sdk.openadsdk.core.up.cw.xt(7);
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j xt = new com.bytedance.sdk.openadsdk.core.up.cw.xt(8);
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j cw = new com.bytedance.sdk.openadsdk.core.up.cw.up(7);

    /* renamed from: r, reason: collision with root package name */
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j f28297r = new com.bytedance.sdk.openadsdk.core.up.cw.up(8);
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j up = new com.bytedance.sdk.openadsdk.core.up.cw.r(7);

    /* renamed from: m, reason: collision with root package name */
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j f28296m = new com.bytedance.sdk.openadsdk.core.up.cw.r(8);
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j ae = new com.bytedance.sdk.openadsdk.core.up.cw.cw(7);
    private static final com.bytedance.sdk.openadsdk.core.up.cw.j tl = new com.bytedance.sdk.openadsdk.core.up.cw.cw(8);

    public static int j(boolean z5) {
        tl.j j6 = z5 ? tl.j() : tl.xt();
        if (!j6.ae() || !v.xt().vm()) {
            return -1;
        }
        int r5 = j6.r();
        if (r5 < 0 || r5 == 2 || r5 > 4) {
            return 1;
        }
        return r5;
    }

    public static com.bytedance.sdk.openadsdk.core.up.cw.j j(boolean z5, boolean z6) {
        if (z6) {
            return z5 ? ae : tl;
        }
        int j6 = j(z5);
        return j6 != -1 ? j6 != 0 ? j6 != 3 ? z5 ? cw : f28297r : z5 ? up : f28296m : z5 ? f28295j : xt : z5 ? ae : tl;
    }
}
