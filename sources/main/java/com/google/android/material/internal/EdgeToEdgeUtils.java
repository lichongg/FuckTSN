package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    public static void applyEdgeToEdge(@NonNull Window window, boolean z5) {
        applyEdgeToEdge(window, z5, null, null);
    }

    public static void applyEdgeToEdge(@NonNull Window window, boolean z5, @Nullable @ColorInt Integer num, @Nullable @ColorInt Integer num2) {
        boolean z6 = num == null || num.intValue() == 0;
        boolean z7 = num2 == null || num2.intValue() == 0;
        if (z6 || z7) {
            int color = MaterialColors.getColor(window.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
            if (z6) {
                num = Integer.valueOf(color);
            }
            if (z7) {
                num2 = Integer.valueOf(color);
            }
        }
        WindowCompat.setDecorFitsSystemWindows(window, !z5);
        int statusBarColor = getStatusBarColor(window.getContext(), z5);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z5);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        setLightStatusBar(window, isUsingLightSystemBar(statusBarColor, MaterialColors.isColorLight(num.intValue())));
        setLightNavigationBar(window, isUsingLightSystemBar(navigationBarColor, MaterialColors.isColorLight(num2.intValue())));
    }

    @TargetApi(21)
    private static int getNavigationBarColor(Context context, boolean z5) {
        if (z5 && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(MaterialColors.getColor(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (z5) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    @TargetApi(21)
    private static int getStatusBarColor(Context context, boolean z5) {
        if (z5 && Build.VERSION.SDK_INT < 23) {
            return ColorUtils.setAlphaComponent(MaterialColors.getColor(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (z5) {
            return 0;
        }
        return MaterialColors.getColor(context, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private EdgeToEdgeUtils() {
    }

    private static boolean isUsingLightSystemBar(int i6, boolean z5) {
        if (!MaterialColors.isColorLight(i6)) {
            if (i6 != 0 || !z5) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static void setLightNavigationBar(@NonNull Window window, boolean z5) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z5);
    }

    public static void setLightStatusBar(@NonNull Window window, boolean z5) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(z5);
    }
}
