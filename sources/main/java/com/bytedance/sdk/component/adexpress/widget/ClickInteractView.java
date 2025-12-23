package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.kt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ClickInteractView extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private ImageView f25889j;
    private AnimatorSet xt;

    private void cw() {
        ImageView imageView = new ImageView(getContext());
        this.f25889j = imageView;
        imageView.setImageResource(kt.up(getContext(), "tt_white_hand"));
        int j6 = (int) tl.j(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(j6, j6);
        layoutParams.gravity = 17;
        addView(this.f25889j, layoutParams);
    }

    private void r() {
        this.xt = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f25889j, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f25889j, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat2.setDuration(2000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.xt.playTogether(ofFloat, ofFloat2);
    }

    public void j() {
        AnimatorSet animatorSet = this.xt;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void xt() {
        AnimatorSet animatorSet = this.xt;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public ClickInteractView(Context context) {
        super(context);
        cw();
        r();
    }
}
