package androidx.camera.core.impl.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class TransformUtils {
    public static final RectF NORMALIZED_RECT = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    @NonNull
    public static Matrix getNormalizedToBuffer(@NonNull Rect rect) {
        return getNormalizedToBuffer(new RectF(rect));
    }

    @NonNull
    public static Matrix getRectToRect(@NonNull RectF rectF, @NonNull RectF rectF2, int i6) {
        return getRectToRect(rectF, rectF2, i6, false);
    }

    public static boolean isAspectRatioMatchingWithRoundingError(@NonNull Size size, @NonNull Size size2) {
        return isAspectRatioMatchingWithRoundingError(size, false, size2, false);
    }

    @NonNull
    public static Rect sizeToRect(@NonNull Size size) {
        return sizeToRect(size, 0, 0);
    }

    @NonNull
    public static RectF sizeToRectF(@NonNull Size size) {
        return sizeToRectF(size, 0, 0);
    }

    @NonNull
    public static Matrix getExifTransform(int i6, int i7, int i8) {
        Matrix matrix = new Matrix();
        float f6 = i7;
        float f7 = i8;
        RectF rectF = new RectF(0.0f, 0.0f, f6, f7);
        RectF rectF2 = NORMALIZED_RECT;
        Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
        matrix.setRectToRect(rectF, rectF2, scaleToFit);
        switch (i6) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(270.0f);
                rectF = new RectF(0.0f, 0.0f, f7, f6);
                break;
            case 6:
                matrix.postRotate(90.0f);
                rectF = new RectF(0.0f, 0.0f, f7, f6);
                break;
            case 7:
                matrix.postScale(-1.0f, 1.0f);
                matrix.postRotate(90.0f);
                rectF = new RectF(0.0f, 0.0f, f7, f6);
                break;
            case 8:
                matrix.postRotate(270.0f);
                rectF = new RectF(0.0f, 0.0f, f7, f6);
                break;
        }
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.postConcat(matrix2);
        return matrix;
    }

    @NonNull
    public static Matrix getNormalizedToBuffer(@NonNull RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(NORMALIZED_RECT, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    @NonNull
    public static Matrix getRectToRect(@NonNull RectF rectF, @NonNull RectF rectF2, int i6, boolean z5) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        matrix.postRotate(i6);
        if (z5) {
            matrix.postScale(-1.0f, 1.0f);
        }
        matrix.postConcat(getNormalizedToBuffer(rectF2));
        return matrix;
    }

    public static boolean hasCropping(@NonNull Rect rect, @NonNull Size size) {
        return (rect.left == 0 && rect.top == 0 && rect.width() == size.getWidth() && rect.height() == size.getHeight()) ? false : true;
    }

    public static boolean is90or270(int i6) {
        if (i6 == 90 || i6 == 270) {
            return true;
        }
        if (i6 == 0 || i6 == 180) {
            return false;
        }
        throw new IllegalArgumentException("Invalid rotation degrees: " + i6);
    }

    public static boolean isAspectRatioMatchingWithRoundingError(@NonNull Size size, boolean z5, @NonNull Size size2, boolean z6) {
        float width;
        float width2;
        float width3;
        float width4;
        if (z5) {
            width = size.getWidth() / size.getHeight();
            width2 = width;
        } else {
            width = (size.getWidth() + 1.0f) / (size.getHeight() - 1.0f);
            width2 = (size.getWidth() - 1.0f) / (size.getHeight() + 1.0f);
        }
        if (z6) {
            width3 = size2.getWidth() / size2.getHeight();
            width4 = width3;
        } else {
            width3 = (size2.getWidth() - 1.0f) / (size2.getHeight() + 1.0f);
            width4 = (size2.getWidth() + 1.0f) / (size2.getHeight() - 1.0f);
        }
        return width >= width3 && width4 >= width2;
    }

    @NonNull
    public static Size rectToSize(@NonNull Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    @NonNull
    public static String rectToString(@NonNull Rect rect) {
        return String.format(Locale.US, "%s(%dx%d)", rect, Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
    }

    @NonNull
    public static float[] rectToVertices(@NonNull RectF rectF) {
        float f6 = rectF.left;
        float f7 = rectF.top;
        float f8 = rectF.right;
        float f9 = rectF.bottom;
        return new float[]{f6, f7, f8, f7, f8, f9, f6, f9};
    }

    @NonNull
    public static Size reverseSize(@NonNull Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    @NonNull
    public static SizeF reverseSizeF(@NonNull SizeF sizeF) {
        return new SizeF(sizeF.getHeight(), sizeF.getWidth());
    }

    @NonNull
    public static RectF rotateRect(@NonNull RectF rectF, int i6) {
        Preconditions.checkArgument(i6 % 90 == 0, "Invalid rotation degrees: " + i6);
        return is90or270(within360(i6)) ? new RectF(0.0f, 0.0f, rectF.height(), rectF.width()) : rectF;
    }

    @NonNull
    public static Size rotateSize(@NonNull Size size, int i6) {
        Preconditions.checkArgument(i6 % 90 == 0, "Invalid rotation degrees: " + i6);
        return is90or270(within360(i6)) ? reverseSize(size) : size;
    }

    @NonNull
    public static Rect sizeToRect(@NonNull Size size, int i6, int i7) {
        return new Rect(i6, i7, size.getWidth() + i6, size.getHeight() + i7);
    }

    @NonNull
    public static RectF sizeToRectF(@NonNull Size size, int i6, int i7) {
        return new RectF(i6, i7, i6 + size.getWidth(), i7 + size.getHeight());
    }

    @NonNull
    public static Matrix updateSensorToBufferTransform(@NonNull Matrix matrix, @NonNull Rect rect) {
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate(-rect.left, -rect.top);
        return matrix2;
    }

    @NonNull
    public static RectF verticesToRect(@NonNull float[] fArr) {
        return new RectF(min(fArr[0], fArr[2], fArr[4], fArr[6]), min(fArr[1], fArr[3], fArr[5], fArr[7]), max(fArr[0], fArr[2], fArr[4], fArr[6]), max(fArr[1], fArr[3], fArr[5], fArr[7]));
    }

    public static int within360(int i6) {
        return ((i6 % 360) + 360) % 360;
    }

    private TransformUtils() {
    }

    @NonNull
    public static Size getRotatedSize(@NonNull Rect rect, int i6) {
        return rotateSize(rectToSize(rect), i6);
    }

    public static float max(float f6, float f7, float f8, float f9) {
        return Math.max(Math.max(f6, f7), Math.max(f8, f9));
    }

    public static float min(float f6, float f7, float f8, float f9) {
        return Math.min(Math.min(f6, f7), Math.min(f8, f9));
    }

    @NonNull
    public static float[] sizeToVertices(@NonNull Size size) {
        return new float[]{0.0f, 0.0f, size.getWidth(), 0.0f, size.getWidth(), size.getHeight(), 0.0f, size.getHeight()};
    }
}
