package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i6) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i6));
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i6, @IntRange(from = 0, to = 100) int i7) {
        Hct fromInt = Hct.fromInt(i6);
        fromInt.setTone(i7);
        return fromInt.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i6) {
        return getColorRoles(i6, isLightTheme(context));
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i6, @AttrRes int i7) {
        return layer(view, i6, i7, 1.0f);
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i6, boolean z5) {
        return z5 ? new ColorRoles(getColorRole(i6, 40), getColorRole(i6, 100), getColorRole(i6, 90), getColorRole(i6, 10)) : new ColorRoles(getColorRole(i6, 80), getColorRole(i6, 20), getColorRole(i6, 30), getColorRole(i6, 90));
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i6) {
        return harmonize(i6, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i6) {
        return i6 != 0 && ColorUtils.calculateLuminance(i6) > 0.5d;
    }

    static boolean isLightTheme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i6, @AttrRes int i7, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return layer(getColor(view, i6), getColor(view, i7), f6);
    }

    private static int resolveColor(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i6 = typedValue.resourceId;
        return i6 != 0 ? ContextCompat.getColor(context, i6) : typedValue.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i6 = typedValue.resourceId;
        return i6 != 0 ? ContextCompat.getColorStateList(context, i6) : ColorStateList.valueOf(typedValue.data);
    }

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i6, @IntRange(from = 0, to = 255) int i7) {
        return ColorUtils.setAlphaComponent(i6, (Color.alpha(i6) * i7) / 255);
    }

    @NonNull
    public static ColorStateList getColorStateList(@NonNull Context context, @AttrRes int i6, @NonNull ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        TypedValue resolve = MaterialAttributes.resolve(context, i6);
        if (resolve != null) {
            colorStateList2 = resolveColorStateList(context, resolve);
        } else {
            colorStateList2 = null;
        }
        if (colorStateList2 == null) {
            return colorStateList;
        }
        return colorStateList2;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@NonNull Context context, @AttrRes int i6) {
        TypedValue resolve = MaterialAttributes.resolve(context, i6);
        if (resolve == null) {
            return null;
        }
        int i7 = resolve.resourceId;
        if (i7 != 0) {
            return ContextCompat.getColorStateList(context, i7);
        }
        int i8 = resolve.data;
        if (i8 == 0) {
            return null;
        }
        return ColorStateList.valueOf(i8);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerFromSeed(@NonNull Context context, @ColorInt int i6) {
        int i7;
        if (isLightTheme(context)) {
            i7 = 94;
        } else {
            i7 = 12;
        }
        return getColorRole(i6, i7, 6);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerHighFromSeed(@NonNull Context context, @ColorInt int i6) {
        int i7;
        if (isLightTheme(context)) {
            i7 = 92;
        } else {
            i7 = 17;
        }
        return getColorRole(i6, i7, 6);
    }

    @ColorInt
    public static int harmonize(@ColorInt int i6, @ColorInt int i7) {
        return Blend.harmonize(i6, i7);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i6, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i6, str));
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i6, @IntRange(from = 0, to = 100) int i7, int i8) {
        Hct fromInt = Hct.fromInt(getColorRole(i6, i7));
        fromInt.setChroma(i8);
        return fromInt.toInt();
    }

    @ColorInt
    public static int layer(@ColorInt int i6, @ColorInt int i7, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return layer(i6, ColorUtils.setAlphaComponent(i7, Math.round(Color.alpha(i7) * f6)));
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i6, @ColorInt int i7) {
        return getColor(view.getContext(), i6, i7);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i6, @ColorInt int i7) {
        TypedValue resolve = MaterialAttributes.resolve(context, i6);
        return resolve != null ? resolveColor(context, resolve) : i7;
    }

    @ColorInt
    public static int layer(@ColorInt int i6, @ColorInt int i7) {
        return ColorUtils.compositeColors(i7, i6);
    }
}
