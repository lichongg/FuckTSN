package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.utils.kt;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class mi implements ae<WriggleGuideAnimationView> {
    private com.bytedance.sdk.component.adexpress.dynamic.cw.oq ae;
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    public int f25757j;

    /* renamed from: m, reason: collision with root package name */
    private String f25758m;

    /* renamed from: r, reason: collision with root package name */
    private DynamicBaseWidget f25759r;
    private boolean tl;
    private com.bytedance.sdk.component.adexpress.dynamic.cw.ae up;
    private WriggleGuideAnimationView xt;

    private void up() {
        int z5 = this.up.z();
        final com.bytedance.sdk.component.adexpress.dynamic.up.j dynamicClickListener = this.f25759r.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.j(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.f25758m)) {
            Context context = this.cw;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.bytedance.sdk.component.adexpress.cw.j.g(context), this.ae, this.tl, this.f25757j);
            this.xt = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.xt.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.xt.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.up.rr())) {
                    this.xt.getTopTextView().setText(kt.xt(this.cw, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.xt.getTopTextView().setText(this.up.rr());
                }
            }
        } else {
            Context context2 = this.cw;
            this.xt = new WriggleGuideAnimationView(context2, com.bytedance.sdk.component.adexpress.cw.j.g(context2), this.ae, this.tl, this.f25757j);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.xt.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.cw, z5)));
        this.xt.setLayoutParams(layoutParams);
        this.xt.setShakeText(this.up.q());
        this.xt.setClipChildren(false);
        final View wriggleProgressIv = this.xt.getWriggleProgressIv();
        this.xt.setOnShakeViewListener(new WriggleGuideAnimationView.j() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.mi.1
            @Override // com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.j
            public void j() {
                if (wriggleProgressIv != null) {
                    if (mi.this.xt != null) {
                        mi.this.xt.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        mi.this.xt.performClick();
                    }
                    if (mi.this.up == null || !mi.this.up.sm()) {
                        return;
                    }
                    mi.this.xt.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.xt.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView cw() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.xt.clearAnimation();
    }

    public mi(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, String str, com.bytedance.sdk.component.adexpress.dynamic.cw.oq oqVar, boolean z5, int i6) {
        this.cw = context;
        this.f25759r = dynamicBaseWidget;
        this.up = aeVar;
        this.f25758m = str;
        this.ae = oqVar;
        this.tl = z5;
        this.f25757j = i6;
        up();
    }
}
