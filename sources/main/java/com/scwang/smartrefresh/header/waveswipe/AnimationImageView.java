package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.view.animation.Animation;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AnimationImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Animation.AnimationListener f37213a;

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f37213a = animationListener;
    }

    public AnimationImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f37213a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f37213a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }
}
