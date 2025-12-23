package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends i<ClickSlideUpShakeView> implements az {
    private void j(com.bytedance.sdk.component.adexpress.dynamic.cw.oq oqVar, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, boolean z5, int i6) {
        this.f25724j = new ClickSlideUpShakeView(this.xt, oqVar, z5, i6);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.xt, 300.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.xt, aeVar.z() > 0 ? aeVar.z() : com.bytedance.sdk.component.adexpress.r.j() ? 0 : 120);
        this.f25724j.setLayoutParams(layoutParams);
        this.f25724j.setClipChildren(false);
        this.f25724j.setSlideText(this.f25725r.q());
        SlideUpView slideUpView = this.f25724j;
        if (slideUpView instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) slideUpView).setShakeText(this.f25725r.ya());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.f25724j).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.j() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.m.1
                    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.j
                    public void j(boolean z6) {
                        if (m.this.cw.getDynamicClickListener() != null) {
                            m.this.cw.getDynamicClickListener().j(z6, m.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.cw.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.az
    public void up() {
        if (this.f25724j.getParent() != null) {
            ((ViewGroup) this.f25724j.getParent()).setVisibility(8);
        }
    }

    public m(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, com.bytedance.sdk.component.adexpress.dynamic.cw.oq oqVar, boolean z5, int i6) {
        super(context, dynamicBaseWidget, aeVar);
        this.xt = context;
        this.f25725r = aeVar;
        this.cw = dynamicBaseWidget;
        j(oqVar, aeVar, z5, i6);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.i
    protected void r() {
    }
}
