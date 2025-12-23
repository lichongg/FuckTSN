package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.header.flyrefresh.FlyView;
import com.scwang.smartrefresh.header.flyrefresh.MountanScenceView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import m2.e;
import m2.g;
import m2.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FlyRefreshHeader extends FalsifyHeader implements e {

    /* renamed from: b, reason: collision with root package name */
    private FlyView f36909b;

    /* renamed from: c, reason: collision with root package name */
    private AnimatorSet f36910c;

    /* renamed from: d, reason: collision with root package name */
    private MountanScenceView f36911d;

    /* renamed from: e, reason: collision with root package name */
    private h f36912e;

    /* renamed from: f, reason: collision with root package name */
    private g f36913f;

    /* renamed from: g, reason: collision with root package name */
    private float f36914g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f36915h;

    /* renamed from: i, reason: collision with root package name */
    private int f36916i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FlyRefreshHeader.this.y(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f36909b != null) {
                FlyRefreshHeader.this.f36909b.setRotationY(180.0f);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnimatorListenerAdapter f36919a;

        c(AnimatorListenerAdapter animatorListenerAdapter) {
            this.f36919a = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (FlyRefreshHeader.this.f36912e != null) {
                FlyRefreshHeader.this.f36912e.h0(true);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.f36919a;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f36909b != null) {
                FlyRefreshHeader.this.f36909b.setRotationY(0.0f);
            }
        }
    }

    public FlyRefreshHeader(Context context) {
        super(context);
        this.f36915h = false;
        this.f36916i = 0;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.f
    public boolean j() {
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        MountanScenceView mountanScenceView;
        if (iArr.length <= 0 || (mountanScenceView = this.f36911d) == null) {
            return;
        }
        mountanScenceView.setPrimaryColor(iArr[0]);
    }

    public void z() {
        A(null);
    }

    public void A(AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.f36909b == null || !this.f36915h || this.f36912e == null) {
            return;
        }
        AnimatorSet animatorSet = this.f36910c;
        if (animatorSet != null) {
            animatorSet.end();
            this.f36909b.clearAnimation();
        }
        this.f36915h = false;
        this.f36912e.B(0);
        int i6 = -this.f36909b.getRight();
        int i7 = -com.scwang.smartrefresh.layout.util.c.b(10.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        FlyView flyView = this.f36909b;
        float f6 = i6;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(flyView, "translationX", flyView.getTranslationX(), f6);
        FlyView flyView2 = this.f36909b;
        float f7 = i7;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(flyView2, "translationY", flyView2.getTranslationY(), f7);
        ofFloat2.setInterpolator(com.scwang.smartrefresh.header.flyrefresh.a.a(0.1f, 1.0f));
        FlyView flyView3 = this.f36909b;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(flyView3, "rotation", flyView3.getRotation(), 0.0f);
        FlyView flyView4 = this.f36909b;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView4, "rotationX", flyView4.getRotationX(), 30.0f);
        ofFloat3.setInterpolator(new AccelerateInterpolator());
        FlyView flyView5 = this.f36909b;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(flyView5, "scaleX", flyView5.getScaleX(), 0.9f);
        FlyView flyView6 = this.f36909b;
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ObjectAnimator.ofFloat(flyView6, "scaleY", flyView6.getScaleY(), 0.9f));
        animatorSet2.addListener(new b());
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(800L);
        animatorSet3.setInterpolator(new DecelerateInterpolator());
        animatorSet3.playTogether(ObjectAnimator.ofFloat(this.f36909b, "translationX", f6, 0.0f), ObjectAnimator.ofFloat(this.f36909b, "translationY", f7, 0.0f), ObjectAnimator.ofFloat(this.f36909b, "rotationX", 30.0f, 0.0f), ObjectAnimator.ofFloat(this.f36909b, "scaleX", 0.9f, 1.0f), ObjectAnimator.ofFloat(this.f36909b, "scaleY", 0.9f, 1.0f));
        animatorSet3.setStartDelay(100L);
        animatorSet3.addListener(new c(animatorListenerAdapter));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f36910c = animatorSet4;
        animatorSet4.playSequentially(animatorSet2, animatorSet3);
        this.f36910c.start();
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.f
    public int d(h hVar, boolean z5) {
        if (this.f36915h) {
            z();
        }
        return super.d(hVar, z5);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.e
    public void g(float f6, int i6, int i7, int i8) {
        if (this.f36915h) {
            return;
        }
        y(f6, i6, i7, i8);
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.f
    public void q(g gVar, int i6, int i7) {
        this.f36913f = gVar;
        this.f36912e = gVar.c();
    }

    public void setUpFlyView(FlyView flyView) {
        this.f36909b = flyView;
    }

    public void setUpMountanScenceView(MountanScenceView mountanScenceView) {
        this.f36911d = mountanScenceView;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.e
    public void w(h hVar, int i6, int i7) {
        this.f36913f.b(0);
        float f6 = this.f36914g;
        if (f6 > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f6, 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.addUpdateListener(new a());
            ofFloat.start();
            this.f36914g = 0.0f;
        }
        if (this.f36909b == null || this.f36915h) {
            return;
        }
        AnimatorSet animatorSet = this.f36910c;
        if (animatorSet != null) {
            animatorSet.end();
            this.f36909b.clearAnimation();
        }
        this.f36915h = true;
        hVar.h0(false);
        int width = ((View) this.f36912e).getWidth() - this.f36909b.getLeft();
        int i8 = ((-(this.f36909b.getTop() - this.f36916i)) * 2) / 3;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f36909b, "translationX", 0.0f, width);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f36909b, "translationY", 0.0f, i8);
        ofFloat3.setInterpolator(com.scwang.smartrefresh.header.flyrefresh.a.a(0.7f, 1.0f));
        FlyView flyView = this.f36909b;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView, "rotation", flyView.getRotation(), 0.0f);
        ofFloat4.setInterpolator(new DecelerateInterpolator());
        FlyView flyView2 = this.f36909b;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(flyView2, "rotationX", flyView2.getRotationX(), 50.0f);
        ofFloat5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(800L);
        FlyView flyView3 = this.f36909b;
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(flyView3, "scaleX", flyView3.getScaleX(), 0.5f);
        FlyView flyView4 = this.f36909b;
        animatorSet2.playTogether(ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ObjectAnimator.ofFloat(flyView4, "scaleY", flyView4.getScaleY(), 0.5f));
        this.f36910c = animatorSet2;
        animatorSet2.start();
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.e
    public void y(float f6, int i6, int i7, int i8) {
        if (i6 < 0) {
            if (this.f36916i <= 0) {
                return;
            }
            i6 = 0;
            f6 = 0.0f;
        }
        this.f36916i = i6;
        this.f36914g = f6;
        MountanScenceView mountanScenceView = this.f36911d;
        if (mountanScenceView != null) {
            mountanScenceView.d(f6);
            this.f36911d.postInvalidate();
        }
        FlyView flyView = this.f36909b;
        if (flyView != null) {
            int i9 = i7 + i8;
            if (i9 > 0) {
                flyView.setRotation((i6 * (-45.0f)) / i9);
            } else {
                flyView.setRotation(f6 * (-45.0f));
            }
        }
    }

    public void B(MountanScenceView mountanScenceView, FlyView flyView) {
        setUpFlyView(flyView);
        setUpMountanScenceView(mountanScenceView);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f36909b = null;
        this.f36912e = null;
        this.f36913f = null;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36915h = false;
        this.f36916i = 0;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f36915h = false;
        this.f36916i = 0;
    }

    @RequiresApi(21)
    public FlyRefreshHeader(Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f36915h = false;
        this.f36916i = 0;
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.f
    public void h(h hVar, int i6, int i7) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, m2.f
    public void i(float f6, int i6, int i7) {
    }

    @Override // com.scwang.smartrefresh.layout.header.FalsifyHeader, n2.f
    public void x(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }
}
