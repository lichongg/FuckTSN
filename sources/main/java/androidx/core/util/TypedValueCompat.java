package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ComplexDimensionUnit {
    }

    public static float dpToPx(float f6, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f6, displayMetrics);
    }

    public static float pxToDp(float f6, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f6, displayMetrics);
    }

    public static float pxToSp(float f6, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f6, displayMetrics);
    }

    public static float spToPx(float f6, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f6, displayMetrics);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float deriveDimension(int i6, float f6, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i6, f6, displayMetrics);
        }
    }

    public static float deriveDimension(int i6, float f6, @NonNull DisplayMetrics displayMetrics) {
        float f7;
        float f8;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i6, f6, displayMetrics);
        }
        if (i6 == 0) {
            return f6;
        }
        if (i6 == 1) {
            float f9 = displayMetrics.density;
            if (f9 == 0.0f) {
                return 0.0f;
            }
            return f6 / f9;
        }
        if (i6 == 2) {
            float f10 = displayMetrics.scaledDensity;
            if (f10 == 0.0f) {
                return 0.0f;
            }
            return f6 / f10;
        }
        if (i6 == 3) {
            float f11 = displayMetrics.xdpi;
            if (f11 == 0.0f) {
                return 0.0f;
            }
            f7 = f6 / f11;
            f8 = INCHES_PER_PT;
        } else {
            if (i6 == 4) {
                float f12 = displayMetrics.xdpi;
                if (f12 == 0.0f) {
                    return 0.0f;
                }
                return f6 / f12;
            }
            if (i6 != 5) {
                throw new IllegalArgumentException("Invalid unitToConvertTo " + i6);
            }
            float f13 = displayMetrics.xdpi;
            if (f13 == 0.0f) {
                return 0.0f;
            }
            f7 = f6 / f13;
            f8 = INCHES_PER_MM;
        }
        return f7 / f8;
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i6) {
        return i6 & 15;
    }

    private TypedValueCompat() {
    }
}
