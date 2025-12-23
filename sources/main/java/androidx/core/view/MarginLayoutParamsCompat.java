package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes.dex */
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    @Deprecated
    public static int getLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        int layoutDirection = marginLayoutParams.getLayoutDirection();
        if (layoutDirection != 0 && layoutDirection != 1) {
            return 0;
        }
        return layoutDirection;
    }

    @Deprecated
    public static int getMarginEnd(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    @Deprecated
    public static int getMarginStart(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    @Deprecated
    public static boolean isMarginRelative(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    @Deprecated
    public static void resolveLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.resolveLayoutDirection(i6);
    }

    @Deprecated
    public static void setLayoutDirection(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.setLayoutDirection(i6);
    }

    @Deprecated
    public static void setMarginEnd(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.setMarginEnd(i6);
    }

    @Deprecated
    public static void setMarginStart(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i6) {
        marginLayoutParams.setMarginStart(i6);
    }
}
