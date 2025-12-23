package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.cw.oq;
import com.bytedance.sdk.component.utils.f;
import com.stub.StubApp;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ShakeAnimationView extends LinearLayout {
    private TextView ae;
    private TextView cw;

    /* renamed from: g, reason: collision with root package name */
    private LinearLayout f25966g;

    /* renamed from: j, reason: collision with root package name */
    public int f25967j;

    /* renamed from: m, reason: collision with root package name */
    private TextView f25968m;
    private oq oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f25969r;
    private j tl;
    private f up;
    private TextView xt;

    /* renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.f25969r != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new xt(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.f25969r.startAnimation(rotateAnimation);
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
                ShakeAnimationView.this.f25969r.startAnimation(rotateAnimation);
            }
        }
    }

    public interface j {
        void j(boolean z5);
    }

    private static class xt implements Interpolator {
        private xt() {
        }

        /* synthetic */ xt(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            return f6 <= 0.25f ? (f6 * (-2.0f)) + 0.5f : f6 <= 0.5f ? (f6 * 4.0f) - 1.0f : f6 <= 0.75f ? (f6 * (-4.0f)) + 3.0f : (f6 * 2.0f) - 1.5f;
        }
    }

    public LinearLayout getShakeLayout() {
        return this.f25966g;
    }

    protected void j(Context context, View view) {
        addView(view);
        this.f25966g = (LinearLayout) findViewById(2097610727);
        this.f25969r = (ImageView) findViewById(2097610725);
        this.xt = (TextView) findViewById(2097610724);
        this.cw = (TextView) findViewById(2097610726);
        this.f25968m = (TextView) findViewById(2097610723);
        this.ae = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f25966g.setBackground(gradientDrawable);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        f fVar = this.up;
        if (fVar != null) {
            if (z5) {
                fVar.j(this.f25967j);
            } else {
                fVar.xt(this.f25967j);
            }
        }
    }

    public void setOnShakeViewListener(j jVar) {
        this.tl = jVar;
    }

    public ShakeAnimationView(Context context, View view, oq oqVar, boolean z5, int i6) {
        super(context);
        this.oq = oqVar;
        this.qv = z5;
        this.f25967j = i6;
        j(context, view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.up == null) {
                this.up = new f(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 1, this.qv);
            }
            this.up.j(new f.j() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.f.j
                public void j(int i6) {
                    boolean j6 = ShakeAnimationView.this.up != null ? ShakeAnimationView.this.up.j() : false;
                    if (i6 == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.tl != null) {
                        ShakeAnimationView.this.tl.j(j6);
                    }
                }
            });
            if (this.oq != null) {
                this.up.j(r0.j());
                this.up.cw(this.oq.ae());
                this.up.cw(this.oq.xt());
                this.up.up(this.oq.r());
                this.up.xt(this.oq.cw());
                this.up.m(this.oq.up());
                this.up.j(this.oq.m());
                this.up.xt(this.oq.tl());
                this.up.j(this.f25967j);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.up;
        if (fVar != null) {
            fVar.xt(this.f25967j);
        }
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f25968m.setVisibility(8);
            this.ae.setVisibility(8);
        } else {
            this.f25968m.setText(str);
        }
    }

    public void j() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }
}
