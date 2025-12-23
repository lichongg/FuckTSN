package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.live.view.DoubleColorBallAnimationView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g extends xt {
    private DoubleColorBallAnimationView az;
    LinearLayout jy;
    private ImageView ws;

    public void cw() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.az;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.cw();
            this.jy.setVisibility(8);
        }
    }

    public void xt() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.az;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.xt();
            this.jy.setVisibility(0);
        }
    }

    public g(TTBaseVideoActivity tTBaseVideoActivity, n nVar, boolean z5) {
        super(tTBaseVideoActivity, nVar, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.xt
    public void j() {
        super.j();
        this.ws = new ImageView(this.xt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.ws.setAdjustViewBounds(true);
        this.ws.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ws.setLayoutParams(layoutParams);
        this.ae.addView(this.ws);
        View view = new View(this.xt);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ae.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.xt);
        this.jy = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.xt);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText(kt.j(this.xt, "tt_reward_live_grant"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.az = new DoubleColorBallAnimationView(this.xt);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ed.cw(this.xt, 60.0f), ed.cw(this.xt, 60.0f));
        layoutParams3.gravity = 17;
        this.az.setLayoutParams(layoutParams3);
        this.jy.addView(this.az);
        this.jy.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.jy.setLayoutParams(layoutParams4);
        this.ae.addView(this.jy);
        this.jy.setVisibility(8);
        String xt = ln.xt(this.cw);
        if (!TextUtils.isEmpty(xt)) {
            com.bytedance.sdk.openadsdk.g.xt.j(xt).j(this.ae.getWidth()).xt(this.ae.getHeight()).j(this.ws);
        }
    }
}
