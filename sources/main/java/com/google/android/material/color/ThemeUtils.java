package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public final class ThemeUtils {
    private ThemeUtils() {
    }

    public static void applyThemeOverlay(@NonNull Context context, @StyleRes int i6) {
        Resources.Theme windowDecorViewTheme;
        context.getTheme().applyStyle(i6, true);
        if ((context instanceof Activity) && (windowDecorViewTheme = getWindowDecorViewTheme((Activity) context)) != null) {
            windowDecorViewTheme.applyStyle(i6, true);
        }
    }

    @Nullable
    private static Resources.Theme getWindowDecorViewTheme(@NonNull Activity activity) {
        View peekDecorView;
        Context context;
        Window window = activity.getWindow();
        if (window != null && (peekDecorView = window.peekDecorView()) != null && (context = peekDecorView.getContext()) != null) {
            return context.getTheme();
        }
        return null;
    }
}
