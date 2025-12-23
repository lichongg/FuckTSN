package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.r.g;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.p;

/* loaded from: D:\Downloads\app\classes4.dex */
public class CircleLongPressView extends FrameLayout {
    private ImageView cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f25882j;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f25883m;

    /* renamed from: r, reason: collision with root package name */
    private TextView f25884r;
    private RingProgressView up;
    private ImageView xt;

    private void m() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.cw, "scaleX", 1.0f, 0.9f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.cw, "scaleY", 1.0f, 0.9f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f25883m.setDuration(800L);
        this.f25883m.playTogether(ofFloat, ofFloat2);
    }

    private void up() {
        FrameLayout frameLayout = new FrameLayout(this.f25882j);
        this.up = new RingProgressView(this.f25882j);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) tl.j(this.f25882j, 95.0f), (int) tl.j(this.f25882j, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.up, layoutParams);
        this.xt = new ImageView(this.f25882j);
        int j6 = p.j(this.f25882j, 60.0f);
        this.xt.setImageDrawable(g.j(1, null, null, new int[]{j6, j6}, Integer.valueOf(p.j(this.f25882j, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) tl.j(this.f25882j, 75.0f), (int) tl.j(this.f25882j, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.xt, layoutParams2);
        this.cw = new ImageView(this.f25882j);
        int j7 = p.j(this.f25882j, 50.0f);
        this.cw.setImageDrawable(g.j(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{j7, j7}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) tl.j(this.f25882j, 63.0f), (int) tl.j(this.f25882j, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.cw, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.f25882j);
        this.f25884r = textView;
        textView.setTextColor(-1);
        this.f25884r.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.f25884r, layoutParams4);
    }

    public void cw() {
        this.up.j();
    }

    public void j() {
        this.f25883m.start();
    }

    public void r() {
        this.up.xt();
        this.up.cw();
    }

    public void setGuideText(String str) {
        this.f25884r.setText(str);
    }

    public void xt() {
        this.f25883m.cancel();
    }

    public CircleLongPressView(Context context) {
        super(context);
        this.f25883m = new AnimatorSet();
        this.f25882j = context;
        up();
        m();
    }
}
