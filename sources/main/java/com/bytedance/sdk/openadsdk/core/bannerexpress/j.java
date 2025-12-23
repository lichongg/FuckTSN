package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
class j extends FrameLayout {
    protected com.bytedance.sdk.openadsdk.s.j.xt.j.cw ae;
    protected NativeExpressView cw;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f27975g;

    /* renamed from: j, reason: collision with root package name */
    protected final Context f27976j;

    /* renamed from: m, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.j f27977m;
    protected String oq;

    /* renamed from: r, reason: collision with root package name */
    protected n f27978r;
    protected int tl;
    protected com.bytedance.sdk.openadsdk.i.cw.cw.xt up;
    protected NativeExpressView xt;

    private ObjectAnimator xt(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.j.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                j.this.f27975g = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return ofFloat;
    }

    protected void j() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f27976j, this.f27978r, this.up, this.oq);
        this.xt = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void cw() {
        NativeExpressView nativeExpressView = this.cw;
        if (nativeExpressView != null) {
            nativeExpressView.i();
        }
    }

    public NativeExpressView getCurView() {
        return this.xt;
    }

    public NativeExpressView getNextView() {
        return this.cw;
    }

    protected void m() {
        if (this.f27975g || this.cw == null || this.xt == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(j(this.xt)).with(xt(this.cw));
        animatorSet.setDuration(this.tl).start();
        ed.j((View) this.cw, 0);
        this.f27975g = true;
        NativeExpressView nativeExpressView = this.xt;
        this.xt = this.cw;
        this.cw = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.cw.jy();
            this.cw = null;
        }
    }

    public void r() {
        NativeExpressView nativeExpressView = this.xt;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.xt.jy();
            this.xt = null;
        }
        NativeExpressView nativeExpressView2 = this.cw;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.cw.jy();
            this.cw = null;
        }
    }

    public void setDuration(int i6) {
        this.tl = i6;
    }

    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar) {
        this.f27977m = jVar;
        NativeExpressView nativeExpressView = this.xt;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.j() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.j.2
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
                public void j(View view, int i6) {
                    j jVar2 = j.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar3 = jVar2.f27977m;
                    if (jVar3 != null) {
                        jVar3.j(jVar2, i6);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
                public void j(View view, String str, int i6) {
                    j jVar2 = j.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar3 = jVar2.f27977m;
                    if (jVar3 != null) {
                        jVar3.j(jVar2, str, i6);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
                public void j(View view, float f6, float f7) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).tj()) {
                        j.this.j(f6, f7);
                    }
                    j jVar2 = j.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar3 = jVar2.f27977m;
                    if (jVar3 != null) {
                        jVar3.j(jVar2, f6, f7);
                    }
                }
            });
        }
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.s.j.xt.j.cw cwVar) {
        this.ae = cwVar;
    }

    public void up() {
        NativeExpressView nativeExpressView = this.xt;
        if (nativeExpressView != null) {
            nativeExpressView.i();
        }
    }

    public j(Context context, n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        super(context);
        this.oq = "banner_ad";
        this.f27976j = context;
        this.f27978r = nVar;
        this.up = xtVar;
        j();
    }

    public void j(n nVar, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f27976j, nVar, xtVar, this.oq);
        this.cw = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.j() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.j.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, int i6) {
                j jVar = j.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.j jVar2 = jVar.f27977m;
                if (jVar2 != null) {
                    jVar2.j(jVar, i6);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.j
            public void j(View view, float f6, float f7) {
                j.this.j(f6, f7);
                j.this.m();
            }
        });
        ed.j((View) this.cw, 8);
        addView(this.cw, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean xt() {
        return this.cw != null;
    }

    protected void j(float f6, float f7) {
        int cw = ed.cw(this.f27976j, f6);
        int cw2 = ed.cw(this.f27976j, f7);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(cw, cw2);
        }
        layoutParams.width = cw;
        layoutParams.height = cw2;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator j(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }
}
