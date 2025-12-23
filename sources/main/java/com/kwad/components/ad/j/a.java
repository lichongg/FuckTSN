package com.kwad.components.ad.j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private View Bw;
    private Button Bx;
    private Button By;
    private View GD;
    private Runnable LD;
    private boolean LE = false;

    @Nullable
    private Animator kv;

    private static Animator d(View view, long j6) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j6);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    public final void nF() {
        this.LE = true;
    }

    private void initView() {
        this.Bx = (Button) this.GD.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.By = (Button) this.GD.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.Bw = this.GD.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void je() {
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.Bw.getHeight();
        int width = this.Bw.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.kv == null) {
            Animator a6 = a(this.By, this.Bx, width, height, 1600L, 200L);
            this.kv = a6;
            a6.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.j.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.LE) {
                        return;
                    }
                    if (a.this.LD == null) {
                        a.this.LD = new Runnable() { // from class: com.kwad.components.ad.j.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bw.a(a.this.LD, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.kv.isStarted());
        if (!this.kv.isStarted()) {
            com.kwad.sdk.core.d.c.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.kv.start();
        }
        this.LE = false;
    }

    public final void nE() {
        Animator animator = this.kv;
        if (animator != null) {
            animator.cancel();
            this.kv.removeAllListeners();
            this.LE = true;
        }
        Runnable runnable = this.LD;
        if (runnable != null) {
            bw.c(runnable);
            this.LD = null;
        }
    }

    public a(View view) {
        this.GD = view;
        initView();
    }

    private static Animator a(final View view, View view2, int i6, int i7, long j6, long j7) {
        Animator d6 = d(view, 200L);
        float f6 = i6;
        float f7 = i7;
        Animator a6 = a(view2, f6, f7, 200L);
        a6.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.j.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator d7 = d(view2, 200L);
        Animator a7 = a(view, f6, f7, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(d6, a6, ofFloat, d7, a7);
        return animatorSet;
    }

    public final void kZ() {
        nE();
    }

    private static Animator a(final View view, float f6, final float f7, long j6) {
        final float f8 = f6 / f7;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f7);
        ofFloat.setDuration(j6);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.j.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f9 = f8 * floatValue;
                float f10 = f7;
                if (f10 != 0.0f) {
                    float f11 = (floatValue / f10) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f11);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f9;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }
}
