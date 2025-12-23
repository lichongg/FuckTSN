package com.bytedance.adsdk.lottie.r;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes3.dex */
class kt {

    /* renamed from: j, reason: collision with root package name */
    private static final Interpolator f23505j = new LinearInterpolator();
    private static SparseArray<WeakReference<Interpolator>> xt;

    private static SparseArray<WeakReference<Interpolator>> j() {
        if (xt == null) {
            xt = new SparseArray<>();
        }
        return xt;
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0263 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.bytedance.adsdk.lottie.m.j<T> xt(com.bytedance.adsdk.lottie.m r24, android.util.JsonReader r25, float r26, com.bytedance.adsdk.lottie.r.nd<T> r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.r.kt.xt(com.bytedance.adsdk.lottie.m, android.util.JsonReader, float, com.bytedance.adsdk.lottie.r.nd):com.bytedance.adsdk.lottie.m.j");
    }

    kt() {
    }

    private static WeakReference<Interpolator> j(int i6) {
        WeakReference<Interpolator> weakReference;
        synchronized (kt.class) {
            weakReference = j().get(i6);
        }
        return weakReference;
    }

    private static void j(int i6, WeakReference<Interpolator> weakReference) {
        synchronized (kt.class) {
            xt.put(i6, weakReference);
        }
    }

    static <T> com.bytedance.adsdk.lottie.m.j<T> j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, float f6, nd<T> ndVar, boolean z5, boolean z6) throws IOException {
        if (z5 && z6) {
            return xt(mVar, jsonReader, f6, ndVar);
        }
        if (z5) {
            return j(mVar, jsonReader, f6, ndVar);
        }
        return j(jsonReader, f6, ndVar);
    }

    private static <T> com.bytedance.adsdk.lottie.m.j<T> j(com.bytedance.adsdk.lottie.m mVar, JsonReader jsonReader, float f6, nd<T> ndVar) throws IOException {
        Interpolator j6;
        jsonReader.beginObject();
        PointF pointF = null;
        PointF pointF2 = null;
        T t5 = null;
        T t6 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z5 = false;
        float f7 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "e":
                    t5 = ndVar.xt(jsonReader, f6);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z5 = false;
                        break;
                    } else {
                        z5 = true;
                        break;
                    }
                case "i":
                    pointF2 = mi.xt(jsonReader, 1.0f);
                    break;
                case "o":
                    pointF = mi.xt(jsonReader, 1.0f);
                    break;
                case "s":
                    t6 = ndVar.xt(jsonReader, f6);
                    break;
                case "t":
                    f7 = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointF4 = mi.xt(jsonReader, f6);
                    break;
                case "to":
                    pointF3 = mi.xt(jsonReader, f6);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z5) {
            t5 = t6;
        } else if (pointF != null && pointF2 != null) {
            j6 = j(pointF, pointF2);
            com.bytedance.adsdk.lottie.m.j<T> jVar = new com.bytedance.adsdk.lottie.m.j<>(mVar, t6, t5, j6, f7, null);
            jVar.tl = pointF3;
            jVar.f23336g = pointF4;
            return jVar;
        }
        j6 = f23505j;
        com.bytedance.adsdk.lottie.m.j<T> jVar2 = new com.bytedance.adsdk.lottie.m.j<>(mVar, t6, t5, j6, f7, null);
        jVar2.tl = pointF3;
        jVar2.f23336g = pointF4;
        return jVar2;
    }

    private static Interpolator j(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.lottie.up.tl.xt(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.lottie.up.tl.xt(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.lottie.up.tl.xt(pointF2.x, -1.0f, 1.0f);
        float xt2 = com.bytedance.adsdk.lottie.up.tl.xt(pointF2.y, -100.0f, 100.0f);
        pointF2.y = xt2;
        int j6 = com.bytedance.adsdk.lottie.up.g.j(pointF.x, pointF.y, pointF2.x, xt2);
        WeakReference<Interpolator> j7 = com.bytedance.adsdk.lottie.up.j() ? null : j(j6);
        Interpolator interpolator = j7 != null ? j7.get() : null;
        if (j7 != null && interpolator != null) {
            return interpolator;
        }
        try {
            linearInterpolator = com.bytedance.adsdk.lottie.i.j(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e6) {
            if ("The Path cannot loop back on itself.".equals(e6.getMessage())) {
                linearInterpolator = com.bytedance.adsdk.lottie.i.j(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
            } else {
                linearInterpolator = new LinearInterpolator();
            }
        }
        if (!com.bytedance.adsdk.lottie.up.j()) {
            try {
                j(j6, (WeakReference<Interpolator>) new WeakReference(linearInterpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return linearInterpolator;
    }

    private static <T> com.bytedance.adsdk.lottie.m.j<T> j(JsonReader jsonReader, float f6, nd<T> ndVar) throws IOException {
        return new com.bytedance.adsdk.lottie.m.j<>(ndVar.xt(jsonReader, f6));
    }
}
