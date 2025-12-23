package com.bytedance.msdk.cw.tl;

import android.content.Context;
import com.bytedance.sdk.gromore.j.j.ae.cw.ae;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.m mVar, boolean z5) {
        com.bytedance.sdk.openadsdk.mediation.xt.xt.xt l6;
        if (jVar != null && (l6 = jVar.l()) != null && l6.oq() == null) {
            com.bytedance.msdk.j.up.cw.r("TMe", "使用聚合信息流广告自渲染模版混用场景时，需设置MediationNativeToBannerListener监听回调否则会影响相关功能使用，具体可以参考接入文档，若不能及时设置，建议修改瀑布流配置为模版信息流广告暂不进行混用。");
        }
        new com.bytedance.sdk.gromore.j.j.ae.r.up(context, jVar, mVar, z5).j();
    }

    public static void xt(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar) {
        new ae(context, jVar, rVar).j();
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.cw cwVar, boolean z5) {
        new com.bytedance.sdk.gromore.j.j.ae.r.m(context, jVar, cwVar, z5).j();
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.xt xtVar) {
        new com.bytedance.sdk.gromore.j.j.ae.xt.cw(context, jVar, xtVar).j();
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.ae aeVar) {
        new com.bytedance.sdk.gromore.j.j.ae.up.cw(context, jVar, aeVar).j();
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.gromore.j.j.j.j jVar2, boolean z5) {
        new com.bytedance.sdk.gromore.j.j.ae.j.cw(context, jVar, jVar2, z5).j();
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.gromore.j.j jVar2, com.bytedance.sdk.openadsdk.tj.j.xt.j.j jVar3, boolean z5) {
        com.bytedance.sdk.gromore.j.j.ae.m.cw cwVar = new com.bytedance.sdk.gromore.j.j.ae.m.cw(context, jVar, jVar3, z5);
        if (jVar2 != null && jVar2.g() != 0) {
            cwVar.j(jVar2.g());
        } else {
            cwVar.j();
        }
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.mediation.xt.xt.j jVar, com.bytedance.sdk.openadsdk.tj.j.xt.j.r rVar) {
        new com.bytedance.sdk.gromore.j.j.ae.cw.cw(context, jVar, rVar).j();
    }
}
