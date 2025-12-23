package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i6 = (int) (length / 0.002f);
        int i7 = i6 + 1;
        this.mX = new float[i7];
        this.mY = new float[i7];
        float[] fArr = new float[2];
        for (int i8 = 0; i8 < i7; i8++) {
            pathMeasure.getPosTan((i8 * length) / i6, fArr, null);
            this.mX[i8] = fArr[0];
            this.mY[i8] = fArr[1];
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f6) {
        if (f6 <= 0.0f) {
            return 0.0f;
        }
        if (f6 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i6 = 0;
        while (length - i6 > 1) {
            int i7 = (i6 + length) / 2;
            if (f6 < this.mX[i7]) {
                length = i7;
            } else {
                i6 = i7;
            }
        }
        float[] fArr = this.mX;
        float f7 = fArr[length];
        float f8 = fArr[i6];
        float f9 = f7 - f8;
        if (f9 == 0.0f) {
            return this.mY[i6];
        }
        float f10 = (f6 - f8) / f9;
        float[] fArr2 = this.mY;
        float f11 = fArr2[i6];
        return f11 + (f10 * (fArr2[length] - f11));
    }

    private static Path createCubic(float f6, float f7, float f8, float f9) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f6, f7, f8, f9, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f6, float f7) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f6, f7, 1.0f, 1.0f);
        return path;
    }

    PathInterpolatorApi14(float f6, float f7) {
        this(createQuad(f6, f7));
    }

    PathInterpolatorApi14(float f6, float f7, float f8, float f9) {
        this(createCubic(f6, f7, f8, f9));
    }
}
