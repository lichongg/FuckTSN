package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ColorDrawableKt {
    @NotNull
    public static final ColorDrawable toDrawable(@ColorInt int i6) {
        return new ColorDrawable(i6);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final ColorDrawable toDrawable(@NotNull Color color) {
        int argb;
        argb = color.toArgb();
        return new ColorDrawable(argb);
    }
}
