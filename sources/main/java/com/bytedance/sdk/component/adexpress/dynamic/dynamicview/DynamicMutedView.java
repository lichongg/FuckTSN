package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.r.g;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.xt {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean r() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        ImageView imageView = new ImageView(context);
        this.az = imageView;
        imageView.setTag(5);
        addView(this.az, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().l()) {
            this.az.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xt
    public void setSoundMute(boolean z5) {
        int up;
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            if (z5) {
                up = kt.up(getContext(), "tt_reward_full_mute");
            } else {
                up = kt.up(getContext(), "tt_reward_full_unmute");
            }
        } else if (z5) {
            up = kt.up(getContext(), "tt_mute");
        } else {
            up = kt.up(getContext(), "tt_unmute");
        }
        ((ImageView) this.az).setImageResource(up);
        if (((ImageView) this.az).getDrawable() != null) {
            ((ImageView) this.az).getDrawable().setAutoMirrored(true);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        super.tl();
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.az).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.ws.xt);
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            Drawable j6 = com.bytedance.sdk.component.adexpress.r.r.j(getContext(), this.vl);
            if (j6 != null) {
                ((ImageView) this.az).setBackground(j6);
                return true;
            }
            return true;
        }
        ((ImageView) this.az).setBackgroundDrawable(g.j(0, Integer.valueOf(this.vl.l()), new int[]{this.tl / 2}, null, null, null));
        return true;
    }
}
