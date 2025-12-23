package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.cw.m;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicLottie extends DynamicBaseWidgetImp {

    /* renamed from: j, reason: collision with root package name */
    String f25684j;
    tl xt;

    private DynamicLottieView getLottieView() {
        tl tlVar = this.jy;
        if (tlVar == null || tlVar.oq() == null || this.qv == null || TextUtils.isEmpty(this.f25684j)) {
            return null;
        }
        m up = this.jy.oq().up();
        String aq = up != null ? up.aq() : "";
        if (TextUtils.isEmpty(aq)) {
            return null;
        }
        String str = this.f25684j + "static/lotties/" + aq + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.qv);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.g();
        return dynamicLottieView;
    }

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, tl tlVar, String str) {
        super(context, dynamicRootView, tlVar);
        this.f25684j = str;
        this.xt = tlVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }
}
