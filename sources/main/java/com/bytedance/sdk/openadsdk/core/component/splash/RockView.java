package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ff;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class RockView extends LinearLayout {
    private TextView cw;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f28543j;
    private TextView xt;

    private static class j implements Interpolator {
        private j() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return f6 <= 0.25f ? (f6 * (-2.0f)) + 0.5f : f6 <= 0.5f ? (f6 * 4.0f) - 1.0f : f6 <= 0.75f ? (f6 * (-4.0f)) + 3.0f : (f6 * 2.0f) - 1.5f;
        }
    }

    private View j(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 17;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        OvalShape ovalShape = new OvalShape();
        int cw = ed.cw(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(cw);
        shapeDrawable.setIntrinsicWidth(cw);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.f28543j = imageView;
        imageView.setId(2114387572);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        Drawable cw2 = kt.cw(context, "tt_splash_rock");
        if (cw2 != null) {
            this.f28543j.setImageDrawable(cw2);
        } else {
            com.bytedance.sdk.openadsdk.g.xt.j(com.bytedance.sdk.openadsdk.core.tl.cw.j("splash_rock.png")).j(this.f28543j);
        }
        this.f28543j.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.f28543j);
        TextView textView = new TextView(context);
        this.xt = textView;
        textView.setId(2114387570);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.xt.setSingleLine();
        this.xt.setText(kt.j(context, "tt_splash_rock_top"));
        this.xt.setTextColor(-1);
        this.xt.setTextSize(14.0f);
        this.xt.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.xt);
        TextView textView2 = new TextView(context);
        this.cw = textView2;
        textView2.setId(2114387569);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.topMargin = ed.cw(context, 12.0f);
        this.cw.setLayoutParams(layoutParams5);
        this.cw.setText(kt.j(context, "tt_splash_rock_desc"));
        this.cw.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.cw.setTextColor(-1);
        linearLayout.addView(this.cw);
        return linearLayout;
    }

    private void xt(Context context) {
        if (context == null) {
            context = v.getContext();
        }
        View j6 = j(context);
        if (j6 == null) {
            return;
        }
        addView(j6);
    }

    public RockView(Context context) {
        super(context);
        xt(context);
    }

    public void j(ff ffVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.xt;
        if (textView != null) {
            textView.setText(ffVar.qv());
            this.xt.setTextSize(2, ffVar.jy().xt());
        }
        TextView textView2 = this.cw;
        if (textView2 != null) {
            textView2.setText(ffVar.xt());
            this.cw.setTextSize(2, ffVar.vl().xt());
            this.cw.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void j() {
        if (this.f28543j != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new j());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.f28543j.startAnimation(rotateAnimation);
                        }
                    }, 250L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.f28543j.startAnimation(rotateAnimation);
        }
    }
}
