package androidx.camera.core.internal;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ViewPorts {
    private static RectF correctStartOrEnd(boolean z5, @IntRange(from = 0, to = 359) int i6, RectF rectF, RectF rectF2) {
        boolean z6 = false;
        boolean z7 = i6 == 0 && !z5;
        boolean z8 = i6 == 90 && z5;
        if (z7 || z8) {
            return rectF2;
        }
        boolean z9 = i6 == 0 && z5;
        boolean z10 = i6 == 270 && !z5;
        if (z9 || z10) {
            return flipHorizontally(rectF2, rectF.centerX());
        }
        boolean z11 = i6 == 90 && !z5;
        boolean z12 = i6 == 180 && z5;
        if (z11 || z12) {
            return flipVertically(rectF2, rectF.centerY());
        }
        boolean z13 = i6 == 180 && !z5;
        if (i6 == 270 && z5) {
            z6 = true;
        }
        if (z13 || z6) {
            return flipHorizontally(flipVertically(rectF2, rectF.centerY()), rectF.centerX());
        }
        throw new IllegalArgumentException("Invalid argument: mirrored " + z5 + " rotation " + i6);
    }

    private static float flipX(float f6, float f7) {
        return (f7 + f7) - f6;
    }

    private static float flipY(float f6, float f7) {
        return (f7 + f7) - f6;
    }

    @NonNull
    @SuppressLint({"SwitchIntDef"})
    public static RectF getScaledRect(@NonNull RectF rectF, @NonNull Rational rational, int i6, boolean z5, int i7, @IntRange(from = 0, to = 359) int i8) {
        if (i6 == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, rational.getNumerator(), rational.getDenominator());
        if (i6 == 0) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        } else if (i6 == 1) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
        } else {
            if (i6 != 2) {
                throw new IllegalStateException("Unexpected scale type: " + i6);
            }
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return correctStartOrEnd(shouldMirrorStartAndEnd(z5, i7), i8, rectF, rectF3);
    }

    private static boolean shouldMirrorStartAndEnd(boolean z5, int i6) {
        return z5 ^ (i6 == 1);
    }

    private static RectF flipHorizontally(RectF rectF, float f6) {
        return new RectF(flipX(rectF.right, f6), rectF.top, flipX(rectF.left, f6), rectF.bottom);
    }

    private static RectF flipVertically(RectF rectF, float f6) {
        return new RectF(rectF.left, flipY(rectF.bottom, f6), rectF.right, flipY(rectF.top, f6));
    }

    private ViewPorts() {
    }

    @NonNull
    public static Map<UseCase, Rect> calculateViewPortRects(@NonNull Rect rect, boolean z5, @NonNull Rational rational, @IntRange(from = 0, to = 359) int i6, int i7, int i8, @NonNull Map<UseCase, StreamSpec> map) {
        boolean z6;
        if (rect.width() > 0 && rect.height() > 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkArgument(z6, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap hashMap = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry<UseCase, StreamSpec> entry : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, entry.getValue().getResolution().getWidth(), entry.getValue().getResolution().getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            hashMap.put(entry.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF scaledRect = getScaledRect(rectF2, ImageUtil.getRotatedAspectRatio(i6, rational), i7, z5, i8, i6);
        HashMap hashMap2 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry2 : hashMap.entrySet()) {
            ((Matrix) entry2.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, scaledRect);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            hashMap2.put((UseCase) entry2.getKey(), rect2);
        }
        return hashMap2;
    }
}
