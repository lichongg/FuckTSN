package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tl.cw;
import com.bytedance.sdk.openadsdk.g.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class BaseSaasEnvelope extends RelativeLayout {
    private AnimatorSet cw;

    /* renamed from: j, reason: collision with root package name */
    private View f28466j;
    private ImageView xt;

    private View xt(Context context) {
        String up = uf.up(getContext());
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = ed.cw(context, 80.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        textView.setText("关联后" + up + "将获取你的抖音头像和昵称");
        textView.setTextColor(Color.parseColor("#AAFFFFFF"));
        return textView;
    }

    public abstract void j();

    protected void j(Context context, String str, RelativeLayout relativeLayout) {
        View j6 = j(context, str);
        this.f28466j = j6;
        relativeLayout.addView(j6);
        relativeLayout.addView(xt(context));
        this.f28466j.setTag(67108864, 2917);
        addView(j(context, relativeLayout));
        ImageView imageView = new ImageView(context);
        this.xt = imageView;
        imageView.setImageResource(kt.up(context, "tt_saas_close"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = ed.cw(context, 25.0f);
        addView(this.xt, layoutParams);
    }

    public void setOnButtonClickListener(final View.OnClickListener onClickListener) {
        View view = this.f28466j;
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseSaasEnvelope.this.xt();
                onClickListener.onClick(view2);
            }
        });
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.xt;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public BaseSaasEnvelope(Context context) {
        super(context);
    }

    public void xt() {
        AnimatorSet animatorSet = this.cw;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.cw = null;
        }
    }

    private View j(Context context, String str) {
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ed.cw(context, 166.0f), ed.cw(context, 40.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = ed.cw(context, 26.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#9D301A"));
        textView.setTypeface(null, 1);
        int cw = ed.cw(context, 40.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f6 = cw;
        gradientDrawable.setCornerRadii(new float[]{f6, f6, f6, f6, f6, f6, f6, f6});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#F2AC5F"), Color.parseColor("#FFEECC")});
        textView.setBackground(gradientDrawable);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "scaleX", 1.0f, 1.05f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(800L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, "scaleY", 1.0f, 1.05f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.cw = animatorSet;
        animatorSet.play(ofFloat).with(ofFloat2);
        this.cw.start();
        return textView;
    }

    protected RelativeLayout j(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ed.cw(getContext(), 301.0f), ed.cw(getContext(), 344.0f));
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(2114387464);
        return relativeLayout;
    }

    private View j(Context context, View view) {
        ImageView imageView = new ImageView(context);
        xt.j(cw.j("saas_reward_title.webp")).j(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.setMargins(0, 0, 0, ed.cw(context, 20.0f));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
