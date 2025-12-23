package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialResources {
    private static final float FONT_SCALE_1_3 = 1.3f;
    private static final float FONT_SCALE_2_0 = 2.0f;

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i6) {
        int resourceId;
        ColorStateList colorStateList;
        return (!typedArray.hasValue(i6) || (resourceId = typedArray.getResourceId(i6, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? typedArray.getColorStateList(i6) : colorStateList;
    }

    private static int getComplexUnit(TypedValue typedValue) {
        int complexUnit;
        if (Build.VERSION.SDK_INT < 22) {
            return typedValue.data & 15;
        }
        complexUnit = typedValue.getComplexUnit();
        return complexUnit;
    }

    public static int getDimensionPixelSize(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i6, int i7) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i6, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i6, i7);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i7);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static int getUnscaledTextSize(@NonNull Context context, @StyleRes int i6, int i7) {
        if (i6 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i6, R.styleable.TextAppearance);
            TypedValue typedValue = new TypedValue();
            boolean value = obtainStyledAttributes.getValue(R.styleable.TextAppearance_android_textSize, typedValue);
            obtainStyledAttributes.recycle();
            if (value) {
                return getComplexUnit(typedValue) == 2 ? Math.round(TypedValue.complexToFloat(typedValue.data) * context.getResources().getDisplayMetrics().density) : TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            }
        }
        return i7;
    }

    private MaterialResources() {
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i6) {
        int resourceId;
        Drawable drawable;
        if (typedArray.hasValue(i6) && (resourceId = typedArray.getResourceId(i6, 0)) != 0 && (drawable = AppCompatResources.getDrawable(context, resourceId)) != null) {
            return drawable;
        }
        return typedArray.getDrawable(i6);
    }

    public static float getFontScale(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    @StyleableRes
    static int getIndexWithValue(@NonNull TypedArray typedArray, @StyleableRes int i6, @StyleableRes int i7) {
        if (typedArray.hasValue(i6)) {
            return i6;
        }
        return i7;
    }

    @Nullable
    public static TextAppearance getTextAppearance(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i6) {
        int resourceId;
        if (typedArray.hasValue(i6) && (resourceId = typedArray.getResourceId(i6, 0)) != 0) {
            return new TextAppearance(context, resourceId);
        }
        return null;
    }

    public static boolean isFontScaleAtLeast1_3(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= FONT_SCALE_1_3) {
            return true;
        }
        return false;
    }

    public static boolean isFontScaleAtLeast2_0(@NonNull Context context) {
        if (context.getResources().getConfiguration().fontScale >= FONT_SCALE_2_0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @NonNull TintTypedArray tintTypedArray, @StyleableRes int i6) {
        int resourceId;
        ColorStateList colorStateList;
        return (!tintTypedArray.hasValue(i6) || (resourceId = tintTypedArray.getResourceId(i6, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(context, resourceId)) == null) ? tintTypedArray.getColorStateList(i6) : colorStateList;
    }
}
