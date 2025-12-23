package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import androidx.annotation.NonNull;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class MatrixExt {
    private static final float[] sTemp = new float[16];

    private static void denormalize(float[] fArr, float f6, float f7) {
        Matrix.translateM(fArr, 0, -f6, -f7, 0.0f);
    }

    private static void normalize(float[] fArr, float f6, float f7) {
        Matrix.translateM(fArr, 0, f6, f7, 0.0f);
    }

    public static void preVerticalFlip(@NonNull float[] fArr, float f6) {
        normalize(fArr, 0.0f, f6);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        denormalize(fArr, 0.0f, f6);
    }

    public static void setRotate(@NonNull float[] fArr, float f6, float f7, float f8) {
        Matrix.setIdentityM(fArr, 0);
        preRotate(fArr, f6, f7, f8);
    }

    public static void postRotate(@NonNull float[] fArr, float f6, float f7, float f8) {
        float[] fArr2 = sTemp;
        synchronized (fArr2) {
            try {
                Matrix.setIdentityM(fArr2, 0);
                normalize(fArr2, f7, f8);
                Matrix.rotateM(fArr2, 0, f6, 0.0f, 0.0f, 1.0f);
                denormalize(fArr2, f7, f8);
                try {
                    Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
                } catch (Throwable th) {
                    th = th;
                    fArr2 = fArr2;
                    Throwable th2 = th;
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @NonNull
    public static String toString(@NonNull float[] fArr, int i6) {
        return String.format(Locale.US, "Matrix:\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f", Float.valueOf(fArr[i6]), Float.valueOf(fArr[i6 + 4]), Float.valueOf(fArr[i6 + 8]), Float.valueOf(fArr[i6 + 12]), Float.valueOf(fArr[i6 + 1]), Float.valueOf(fArr[i6 + 5]), Float.valueOf(fArr[i6 + 9]), Float.valueOf(fArr[i6 + 13]), Float.valueOf(fArr[i6 + 2]), Float.valueOf(fArr[i6 + 6]), Float.valueOf(fArr[i6 + 10]), Float.valueOf(fArr[i6 + 14]), Float.valueOf(fArr[i6 + 3]), Float.valueOf(fArr[i6 + 7]), Float.valueOf(fArr[i6 + 11]), Float.valueOf(fArr[i6 + 15]));
    }

    private MatrixExt() {
    }

    public static void preRotate(@NonNull float[] fArr, float f6, float f7, float f8) {
        normalize(fArr, f7, f8);
        Matrix.rotateM(fArr, 0, f6, 0.0f, 0.0f, 1.0f);
        denormalize(fArr, f7, f8);
    }
}
