package com.kwad.components.ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bm;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private Animator xC;
    private Animator xD;
    private Animator xE;
    private bm xH;
    private bm xI;
    private View xw;
    private View xx;
    private View xy;
    private View xz;
    private final long xt = 1600;
    private final long xu = 3000;
    private final long xv = 5000;
    private boolean xA = false;
    private boolean xB = false;
    private Animator xF = null;
    private long xG = 3000;
    private Interpolator xJ = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
    private m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        private boolean xK = false;

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.xA = true;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j6, long j7) {
            super.onMediaPlayProgress(j6, j7);
            if (j7 >= b.this.xG && !this.xK) {
                this.xK = true;
                b.this.je();
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.xA = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.xA = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.xF != null && !b.this.xF.isRunning()) {
                b.this.xF.start();
                b.a(b.this, (Animator) null);
            }
        }
    };

    static /* synthetic */ View b(b bVar, View view) {
        bVar.xx = null;
        return null;
    }

    static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.xF = null;
        return null;
    }

    static /* synthetic */ View c(b bVar, View view) {
        bVar.xy = null;
        return null;
    }

    static /* synthetic */ View d(b bVar, View view) {
        bVar.xz = null;
        return null;
    }

    private View jd() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void je() {
        this.xC = b(this.xw, 1600L);
        this.xD = a(this.xy, this.xz);
        this.xE = c(this.xw, 1600L);
        this.xC.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.r(b.this.xx);
                b.b(b.this, (View) null);
                if (!b.this.xB) {
                    b bVar = b.this;
                    bVar.a(bVar.xD);
                }
            }
        });
        this.xD.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.xE);
                b.r(b.this.xy);
                b.r(b.this.xz);
                b.c(b.this, (View) null);
                b.d(b.this, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }
        });
        this.xE.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.xE);
            }
        });
        a(this.xC);
    }

    private Animator q(View view) {
        if (this.xH == null || this.xI == null) {
            jc();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", -(com.kwad.sdk.c.a.a.getScreenHeight(getContext()) + ((this.xI.getHeight() + this.xH.getHeight()) / 2)));
        float RF = this.xI.RF() / this.xH.RF();
        float RG = this.xI.RG() / this.xH.RG();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, RF);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, RG);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000L);
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat, ofFloat4);
        animatorSet.setInterpolator(this.xJ);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    private Animator c(View view, long j6) {
        Animator b6 = b(view, 1600L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(b6, ofFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    private void jc() {
        this.xH = new bm(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_start));
        this.xI = new bm(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rE.a(this.jE);
        FrameLayout T = this.tm.rE.kY().T(getContext());
        this.xw = T;
        if (T.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.ksad_reward_play_layout)).addView(this.xw, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.xH.getHeight();
        ViewGroup viewGroup = (FrameLayout) findViewById(R.id.ksad_root_container);
        View jd = jd();
        this.xx = jd;
        viewGroup.addView(jd, -1, -1);
        View a6 = a(R.drawable.ksad_image_player_sweep1, viewGroup);
        this.xy = a6;
        viewGroup.addView(a6, layoutParams);
        View a7 = a(R.drawable.ksad_image_player_sweep2, viewGroup);
        this.xz = a7;
        viewGroup.addView(a7, layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        jc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.xw = null;
        com.kwad.components.ad.reward.m.b kY = this.tm.rE.kY();
        if (kY != null) {
            kY.release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.xA = true;
        Animator animator = this.xD;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.xC;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.xE;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.tm.rE.b(this.jE);
    }

    static /* synthetic */ boolean b(b bVar, boolean z5) {
        bVar.xB = true;
        return true;
    }

    private View a(@DrawableRes int i6, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i6));
        return imageView;
    }

    private Animator b(View view, long j6) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.xx;
        if (view2 != null) {
            animatorSet.playTogether(ofFloat, ofFloat2, ObjectAnimator.ofFloat(view2, "alpha", 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        animatorSet.setDuration(j6);
        animatorSet.setInterpolator(this.xJ);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull Animator animator) {
        if (!this.xA) {
            animator.start();
        } else {
            this.xF = animator;
        }
    }

    private Animator a(View view, View view2) {
        Animator q5 = q(view);
        Animator q6 = q(view2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        ofFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, q6);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(q5, animatorSet);
        return animatorSet2;
    }
}
