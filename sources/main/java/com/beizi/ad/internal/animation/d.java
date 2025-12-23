package com.beizi.ad.internal.animation;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d implements f {

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f11655c = {0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: d, reason: collision with root package name */
    private static final float[] f11656d = {0.0f, 0.0f, -1.0f, 0.0f};

    /* renamed from: e, reason: collision with root package name */
    private static final float[] f11657e = {-1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f11658f = {1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: g, reason: collision with root package name */
    private static final float[] f11659g = {0.0f, 0.0f, 0.0f, -1.0f};

    /* renamed from: h, reason: collision with root package name */
    private static final float[] f11660h = {0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: i, reason: collision with root package name */
    private static final float[] f11661i = {0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f11662j = {0.0f, -1.0f, 0.0f, 0.0f};

    /* renamed from: a, reason: collision with root package name */
    private Animation f11663a;

    /* renamed from: b, reason: collision with root package name */
    private Animation f11664b;

    private float[] a(g gVar) {
        int i6 = AnonymousClass1.f11665a[gVar.ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? f11655c : f11658f : f11657e : f11656d : f11655c;
    }

    private float[] b(g gVar) {
        int i6 = AnonymousClass1.f11665a[gVar.ordinal()];
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? f11659g : f11662j : f11661i : f11660h : f11659g;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.animation.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11665a;

        static {
            int[] iArr = new int[g.values().length];
            f11665a = iArr;
            try {
                iArr[g.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11665a[g.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11665a[g.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11665a[g.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d(long j6, g gVar) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.f11663a = a(a(gVar), accelerateInterpolator, j6);
        this.f11664b = a(b(gVar), accelerateInterpolator, j6);
    }

    private Animation a(float[] fArr, Interpolator interpolator, long j6) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j6);
        return translateAnimation;
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation b() {
        return this.f11664b;
    }

    @Override // com.beizi.ad.internal.animation.f
    public Animation a() {
        return this.f11663a;
    }
}
