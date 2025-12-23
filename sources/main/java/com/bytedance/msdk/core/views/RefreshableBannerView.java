package com.bytedance.msdk.core.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.bytedance.msdk.j.up.cw;

/* loaded from: D:\Downloads\app\classes3.dex */
public class RefreshableBannerView extends FrameLayout {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private boolean f24760j;

    /* renamed from: m, reason: collision with root package name */
    private j f24761m;

    /* renamed from: r, reason: collision with root package name */
    private final Rect f24762r;
    private final ViewTreeObserver.OnScrollChangedListener up;
    private boolean xt;

    public interface j {
        void j(boolean z5);
    }

    public void setVisibilityChangeListener(j jVar) {
        this.f24761m = jVar;
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.f24760j = true;
        this.xt = true;
        this.cw = true;
        this.f24762r = new Rect();
        this.up = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
                refreshableBannerView.xt = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.f24762r);
                RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
                refreshableBannerView2.j(refreshableBannerView2.xt);
            }
        };
    }

    @UiThread
    public void j(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RefreshableBannerView.this.getChildCount() > 1) {
                        RefreshableBannerView.this.removeViewAt(0);
                        cw.j("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
                    }
                }
            });
            duration.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.up);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.up);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        boolean z5;
        super.onWindowVisibilityChanged(i6);
        if (i6 == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f24760j = z5;
        j(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z5) {
        boolean z6 = this.f24760j && this.xt;
        if (z5) {
            if (!z6 || this.cw) {
                return;
            }
            this.cw = true;
            j jVar = this.f24761m;
            if (jVar != null) {
                jVar.j(true);
                return;
            }
            return;
        }
        if (z6 || !this.cw) {
            return;
        }
        this.cw = false;
        j jVar2 = this.f24761m;
        if (jVar2 != null) {
            jVar2.j(false);
        }
    }
}
