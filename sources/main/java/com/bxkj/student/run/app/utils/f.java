package com.bxkj.student.run.app.utils;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int f20213a = 4;

    /* renamed from: b, reason: collision with root package name */
    private static final String f20214b = "Go";

    /* renamed from: c, reason: collision with root package name */
    private static int f20215c = 4;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f20216a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f20217b;

        a(final b val$animationState, final TextView val$animationViewTv) {
            this.f20216a = val$animationState;
            this.f20217b = val$animationViewTv;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f20217b.setVisibility(8);
            this.f20216a.end();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f20216a.start();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            f.f20215c--;
            if (f.f20215c == 0) {
                this.f20217b.setText(f.f20214b);
            } else {
                this.f20217b.setText(String.valueOf(f.f20215c));
            }
            this.f20216a.a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();

        void end();

        void start();
    }

    private static <T extends TextView> void c(final T animationViewTv, final int repeatCount, b animationState) {
        int i6 = repeatCount - 1;
        f20215c = i6;
        animationViewTv.setText(String.valueOf(i6));
        animationViewTv.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.3f, 0.1f, 1.3f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setRepeatCount(f20215c);
        alphaAnimation.setRepeatCount(f20215c);
        alphaAnimation.setDuration(1000L);
        scaleAnimation.setDuration(1000L);
        scaleAnimation.setAnimationListener(new a(animationState, animationViewTv));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationViewTv.startAnimation(animationSet);
    }

    public static <T extends TextView> void d(T animationViewTv, b animationState) {
        c(animationViewTv, 4, animationState);
    }
}
