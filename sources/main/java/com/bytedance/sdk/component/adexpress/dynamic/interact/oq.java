package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.p;
import com.tencent.connect.common.Constants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements ae<ViewGroup> {

    /* renamed from: j, reason: collision with root package name */
    private final DynamicLottieView f25761j;
    private final FrameLayout xt;

    private void j(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -p.j(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(kt.xt(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, p.j(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText(context.getString(kt.xt(context, "tt_splash_brush_mask_hint")));
        if (aeVar != null && !TextUtils.isEmpty(aeVar.q())) {
            textView2.setText(aeVar.q());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    public oq(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, String str, String str2) {
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.f25761j = dynamicLottieView;
        dynamicLottieView.setAnimationsLoop(true);
        dynamicLottieView.setOnlyLoadNetImage(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.xt = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double zz = aeVar.zz();
        zz = zz == 0.0d ? 1.0d : zz;
        double kc = aeVar.kc();
        double d6 = kc != 0.0d ? kc : 1.0d;
        if (Constants.VIA_REPORT_TYPE_CHAT_AIO.equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/swiper_up_star.json" : str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if (!"20".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(str);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * zz), (int) (dynamicBaseWidget.getDynamicWidth() * 0.32d * d6));
            layoutParams2.gravity = 17;
            frameLayout.setLayoutParams(layoutParams2);
            return;
        }
        dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/brush_mask.json" : str);
        j(context, frameLayout, aeVar);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(context, aeVar.z() > 0 ? aeVar.z() : com.bytedance.sdk.component.adexpress.r.j() ? 0 : 120);
        frameLayout.setLayoutParams(layoutParams3);
        frameLayout.setClipChildren(false);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public ViewGroup cw() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        try {
            this.f25761j.ae();
            ViewParent parent = this.xt.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.xt);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        DynamicLottieView dynamicLottieView = this.f25761j;
        if (dynamicLottieView != null) {
            dynamicLottieView.g();
        }
    }
}
