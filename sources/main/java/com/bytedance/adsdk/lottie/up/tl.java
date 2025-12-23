package com.bytedance.adsdk.lottie.up;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.model.xt.ws;
import com.bytedance.component.sdk.annotation.FloatRange;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private static final PointF f23561j = new PointF();

    public static float j(float f6, float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8) {
        return f6 + (f8 * (f7 - f6));
    }

    private static int xt(int i6, int i7) {
        int i8 = i6 / i7;
        return (((i6 ^ i7) >= 0) || i6 % i7 == 0) ? i8 : i8 - 1;
    }

    public static boolean cw(float f6, float f7, float f8) {
        return f6 >= f7 && f6 <= f8;
    }

    public static int j(int i6, int i7, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return (int) (i6 + (f6 * (i7 - i6)));
    }

    public static PointF j(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float xt(float f6, float f7, float f8) {
        return Math.max(f7, Math.min(f8, f6));
    }

    public static void j(ws wsVar, Path path) {
        Path path2;
        path.reset();
        PointF j6 = wsVar.j();
        path.moveTo(j6.x, j6.y);
        f23561j.set(j6.x, j6.y);
        int i6 = 0;
        while (i6 < wsVar.cw().size()) {
            com.bytedance.adsdk.lottie.model.j jVar = wsVar.cw().get(i6);
            PointF j7 = jVar.j();
            PointF xt = jVar.xt();
            PointF cw = jVar.cw();
            PointF pointF = f23561j;
            if (j7.equals(pointF) && xt.equals(cw)) {
                path.lineTo(cw.x, cw.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(j7.x, j7.y, xt.x, xt.y, cw.x, cw.y);
            }
            pointF.set(cw.x, cw.y);
            i6++;
            path = path2;
        }
        Path path3 = path;
        if (wsVar.xt()) {
            path3.close();
        }
    }

    static int j(float f6, float f7) {
        return j((int) f6, (int) f7);
    }

    private static int j(int i6, int i7) {
        return i6 - (i7 * xt(i6, i7));
    }

    public static int j(int i6, int i7, int i8) {
        return Math.max(i7, Math.min(i8, i6));
    }
}
