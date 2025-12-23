package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialAttributes {
    public static int resolveOrThrow(@NonNull Context context, @AttrRes int i6, @NonNull String str) {
        return resolveTypedValueOrThrow(context, i6, str).data;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull View view, @AttrRes int i6) {
        return resolveTypedValueOrThrow(view.getContext(), i6, view.getClass().getCanonicalName());
    }

    @Nullable
    public static TypedValue resolve(@NonNull Context context, @AttrRes int i6) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i6, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    @Px
    public static int resolveMinimumAccessibleTouchTarget(@NonNull Context context) {
        return resolveDimension(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int resolveOrThrow(@NonNull View view, @AttrRes int i6) {
        return resolveTypedValueOrThrow(view, i6).data;
    }

    public static boolean resolveBoolean(@NonNull Context context, @AttrRes int i6, boolean z5) {
        TypedValue resolve = resolve(context, i6);
        if (resolve != null && resolve.type == 18) {
            if (resolve.data != 0) {
                return true;
            }
            return false;
        }
        return z5;
    }

    public static boolean resolveBooleanOrThrow(@NonNull Context context, @AttrRes int i6, @NonNull String str) {
        if (resolveOrThrow(context, i6, str) != 0) {
            return true;
        }
        return false;
    }

    @Px
    public static int resolveDimension(@NonNull Context context, @AttrRes int i6, @DimenRes int i7) {
        float dimension;
        TypedValue resolve = resolve(context, i6);
        if (resolve != null && resolve.type == 5) {
            dimension = resolve.getDimension(context.getResources().getDisplayMetrics());
        } else {
            dimension = context.getResources().getDimension(i7);
        }
        return (int) dimension;
    }

    public static int resolveInteger(@NonNull Context context, @AttrRes int i6, int i7) {
        TypedValue resolve = resolve(context, i6);
        if (resolve != null && resolve.type == 16) {
            return resolve.data;
        }
        return i7;
    }

    @NonNull
    public static TypedValue resolveTypedValueOrThrow(@NonNull Context context, @AttrRes int i6, @NonNull String str) {
        TypedValue resolve = resolve(context, i6);
        if (resolve != null) {
            return resolve;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i6)));
    }
}
