package com.beizi.ad.internal.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private Animation f11646a;

    /* renamed from: b, reason: collision with root package name */
    private Animation f11647b;

    private void a(Interpolator interpolator, long j6) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f11646a = alphaAnimation;
        alphaAnimation.setDuration(j6);
        this.f11646a.setInterpolator(interpolator);
    }

    private void b(Interpolator interpolator, long j6) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f11647b = alphaAnimation;
        alphaAnimation.setDuration(j6);
        this.f11647b.setInterpolator(interpolator);
    }

    public b(long j6) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        a(accelerateInterpolator, j6);
        b(accelerateInterpolator, j6);
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation a() {
        return this.f11646a;
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation b() {
        return this.f11647b;
    }
}
