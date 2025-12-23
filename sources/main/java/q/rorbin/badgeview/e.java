package q.rorbin.badgeview;

import android.graphics.PointF;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final double f51964a = 6.283185307179586d;

    public static void a(PointF pointF, float f6, Double d6, List<PointF> list) {
        float f7;
        if (d6 != null) {
            double atan = (float) Math.atan(d6.doubleValue());
            double d7 = f6;
            float cos = (float) (Math.cos(atan) * d7);
            f7 = (float) (Math.sin(atan) * d7);
            f6 = cos;
        } else {
            f7 = 0.0f;
        }
        list.add(new PointF(pointF.x + f6, pointF.y + f7));
        list.add(new PointF(pointF.x - f6, pointF.y - f7));
    }

    public static float b(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    public static int c(PointF pointF, PointF pointF2) {
        float f6 = pointF.x;
        float f7 = pointF2.x;
        if (f6 > f7) {
            float f8 = pointF.y;
            float f9 = pointF2.y;
            if (f8 > f9) {
                return 4;
            }
            return f8 < f9 ? 1 : -1;
        }
        if (f6 >= f7) {
            return -1;
        }
        float f10 = pointF.y;
        float f11 = pointF2.y;
        if (f10 > f11) {
            return 3;
        }
        return f10 < f11 ? 2 : -1;
    }

    public static double d(double d6, int i6) {
        if (d6 < 0.0d) {
            d6 += 1.5707963267948966d;
        }
        return d6 + ((i6 - 1) * 1.5707963267948966d);
    }

    public static double e(double d6) {
        return (d6 / 6.283185307179586d) * 360.0d;
    }
}
