package com.beizi.ad.internal.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e implements f {

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f11666c = {0.0f, 0.0f, 0.0f, -1.0f};

    /* renamed from: d, reason: collision with root package name */
    private static final float[] f11667d = {0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: e, reason: collision with root package name */
    private static final float[] f11668e = {0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f11669f = {0.0f, -1.0f, 0.0f, 0.0f};

    /* renamed from: a, reason: collision with root package name */
    private Animation f11670a;

    /* renamed from: b, reason: collision with root package name */
    private Animation f11671b;

    private void a(Interpolator interpolator, long j6) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f11670a = alphaAnimation;
        alphaAnimation.setDuration(j6);
        this.f11670a.setInterpolator(interpolator);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.animation.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11672a;

        static {
            int[] iArr = new int[g.values().length];
            f11672a = iArr;
            try {
                iArr[g.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11672a[g.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11672a[g.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11672a[g.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation b() {
        return this.f11671b;
    }

    public e(long j6, g gVar) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        a(accelerateInterpolator, j6);
        a(a(gVar), accelerateInterpolator, j6);
    }

    private void a(float[] fArr, Interpolator interpolator, long j6) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j6);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j6);
        alphaAnimation.setInterpolator(interpolator);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.f11671b = animationSet;
    }

    private float[] a(g gVar) {
        int i6 = AnonymousClass1.f11672a[gVar.ordinal()];
        if (i6 == 1) {
            return f11666c;
        }
        if (i6 == 2) {
            return f11667d;
        }
        if (i6 == 3) {
            return f11668e;
        }
        if (i6 != 4) {
            return f11666c;
        }
        return f11669f;
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation a() {
        return this.f11670a;
    }
}
