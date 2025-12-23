package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.r;
import com.bytedance.sdk.component.adexpress.r.tl;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class SlideUpView extends RelativeLayout {
    private AnimatorSet ae;
    private ImageView cw;

    /* renamed from: g, reason: collision with root package name */
    private AnimatorSet f25982g;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f25983j;

    /* renamed from: m, reason: collision with root package name */
    private AnimatorSet f25984m;
    private String oq;
    private int qv;

    /* renamed from: r, reason: collision with root package name */
    private TextView f25985r;
    private AnimatorSet tl;
    private TextView up;
    private ImageView xt;

    public SlideUpView(Context context) {
        super(context);
        this.f25984m = new AnimatorSet();
        this.ae = new AnimatorSet();
        this.tl = new AnimatorSet();
        this.f25982g = new AnimatorSet();
        this.qv = 100;
        j(context);
    }

    public void cw() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f25983j, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f25983j, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f25983j, "translationY", 0.0f, tl.j(getContext(), -this.qv));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) tl.j(getContext(), this.qv));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.cw != null) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.cw.getLayoutParams();
                    layoutParams.height = num.intValue();
                    SlideUpView.this.cw.setLayoutParams(layoutParams);
                }
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.cw, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.cw, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.xt, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.xt, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.xt, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.xt, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.xt, "translationY", 0.0f, tl.j(getContext(), -this.qv));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.ae.setDuration(50L);
        this.f25982g.setDuration(1500L);
        this.tl.setDuration(50L);
        this.ae.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.tl.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.f25982g.playTogether(ofFloat3, ofInt, ofFloat10);
        this.f25984m.playSequentially(this.tl, this.f25982g, this.ae);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.f25984m;
    }

    protected void j(Context context) {
        if (context == null) {
            context = r.getContext();
        }
        if ("5".equals(this.oq)) {
            addView(com.bytedance.sdk.component.adexpress.cw.j.m(context));
            this.qv = (int) (this.qv * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.cw.j.up(context));
        }
        this.f25983j = (ImageView) findViewById(2097610734);
        this.xt = (ImageView) findViewById(2097610735);
        this.f25985r = (TextView) findViewById(2097610730);
        this.cw = (ImageView) findViewById(2097610733);
        this.up = (TextView) findViewById(2097610731);
    }

    public void setGuideText(String str) {
        TextView textView = this.f25985r;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.up != null) {
            if (TextUtils.isEmpty(str)) {
                this.up.setText("");
            } else {
                this.up.setText(str);
            }
        }
    }

    public void xt() {
        try {
            AnimatorSet animatorSet = this.f25984m;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.tl;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.ae;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.f25982g;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e6) {
            vl.cw(e6.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xt();
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.f25984m = new AnimatorSet();
        this.ae = new AnimatorSet();
        this.tl = new AnimatorSet();
        this.f25982g = new AnimatorSet();
        this.qv = 100;
        setClipChildren(false);
        this.oq = str;
        j(context);
    }

    public void j() {
        cw();
        this.f25984m.start();
        this.f25984m.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.f25984m.start();
                    }
                }, 200L);
            }
        });
    }
}
