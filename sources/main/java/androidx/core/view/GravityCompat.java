package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    public static void apply(int i6, int i7, int i8, @NonNull Rect rect, @NonNull Rect rect2, int i9) {
        Gravity.apply(i6, i7, i8, rect, rect2, i9);
    }

    public static void apply(int i6, int i7, int i8, @NonNull Rect rect, int i9, int i10, @NonNull Rect rect2, int i11) {
        Gravity.apply(i6, i7, i8, rect, i9, i10, rect2, i11);
    }

    private GravityCompat() {
    }

    public static void applyDisplay(int i6, @NonNull Rect rect, @NonNull Rect rect2, int i7) {
        Gravity.applyDisplay(i6, rect, rect2, i7);
    }

    public static int getAbsoluteGravity(int i6, int i7) {
        return Gravity.getAbsoluteGravity(i6, i7);
    }
}
