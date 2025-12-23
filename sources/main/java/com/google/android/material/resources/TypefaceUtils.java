package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class TypefaceUtils {
    @Nullable
    public static Typeface maybeCopyWithFontWeightAdjustment(@NonNull Context context, @NonNull Typeface typeface) {
        return maybeCopyWithFontWeightAdjustment(context.getResources().getConfiguration(), typeface);
    }

    @Nullable
    public static Typeface maybeCopyWithFontWeightAdjustment(@NonNull Configuration configuration, @NonNull Typeface typeface) {
        int i6;
        int i7;
        int weight;
        int i8;
        Typeface create;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        i6 = configuration.fontWeightAdjustment;
        if (i6 == Integer.MAX_VALUE) {
            return null;
        }
        i7 = configuration.fontWeightAdjustment;
        if (i7 == 0 || typeface == null) {
            return null;
        }
        weight = typeface.getWeight();
        i8 = configuration.fontWeightAdjustment;
        create = Typeface.create(typeface, MathUtils.clamp(weight + i8, 1, 1000), typeface.isItalic());
        return create;
    }

    private TypefaceUtils() {
    }
}
