package com.beizi.ad.internal.animation;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements f {

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f11648c = {0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: d, reason: collision with root package name */
    private static final float[] f11649d = {0.0f, 0.0f, -1.0f, 0.0f};

    /* renamed from: e, reason: collision with root package name */
    private static final float[] f11650e = {-1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f11651f = {1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: a, reason: collision with root package name */
    private Animation f11652a;

    /* renamed from: b, reason: collision with root package name */
    private Animation f11653b;

    private float[] a(g gVar) {
        int i6 = AnonymousClass1.f11654a[gVar.ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? f11648c : f11651f : f11650e : f11649d : f11648c;
    }

    private void b(float[] fArr, Interpolator interpolator, long j6) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        this.f11653b = translateAnimation;
        translateAnimation.setFillAfter(true);
        this.f11653b.setDuration(j6);
        this.f11653b.setInterpolator(interpolator);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.animation.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11654a;

        static {
            int[] iArr = new int[g.values().length];
            f11654a = iArr;
            try {
                iArr[g.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11654a[g.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11654a[g.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11654a[g.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public c(long j6, g gVar) {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        a(a(gVar), linearInterpolator, j6);
        b(a(gVar), linearInterpolator, j6);
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation b() {
        return this.f11653b;
    }

    private void a(float[] fArr, Interpolator interpolator, long j6) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        this.f11652a = translateAnimation;
        translateAnimation.setInterpolator(interpolator);
        this.f11652a.setFillAfter(true);
        this.f11652a.setDuration(j6);
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation a() {
        return this.f11652a;
    }
}
