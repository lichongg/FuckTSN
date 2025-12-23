package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class BitmapKt {
    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull Point point) {
        int i6;
        int width = bitmap.getWidth();
        int i7 = point.x;
        return i7 >= 0 && i7 < width && (i6 = point.y) >= 0 && i6 < bitmap.getHeight();
    }

    @NotNull
    public static final Bitmap createBitmap(int i6, int i7, @NotNull Bitmap.Config config) {
        return Bitmap.createBitmap(i6, i7, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i6, int i7, Bitmap.Config config, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i6, i7, config);
    }

    @NotNull
    public static final Bitmap applyCanvas(@NotNull Bitmap bitmap, @NotNull Function1<? super Canvas, n1> function1) {
        function1.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(@NotNull Bitmap bitmap, @NotNull PointF pointF) {
        float f6 = pointF.x;
        if (f6 < 0.0f || f6 >= bitmap.getWidth()) {
            return false;
        }
        float f7 = pointF.y;
        return f7 >= 0.0f && f7 < ((float) bitmap.getHeight());
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @NotNull
    public static final Bitmap createBitmap(int i6, int i7, @NotNull Bitmap.Config config, boolean z5, @NotNull ColorSpace colorSpace) {
        Bitmap createBitmap;
        createBitmap = Bitmap.createBitmap(i6, i7, config, z5, colorSpace);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z5 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i6, i7, z5);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i6, int i7, Bitmap.Config config, boolean z5, ColorSpace colorSpace, int i8, Object obj) {
        Bitmap createBitmap;
        ColorSpace.Named named;
        if ((i8 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i8 & 8) != 0) {
            z5 = true;
        }
        if ((i8 & 16) != 0) {
            named = ColorSpace.Named.SRGB;
            colorSpace = ColorSpace.get(named);
        }
        createBitmap = Bitmap.createBitmap(i6, i7, config, z5, colorSpace);
        return createBitmap;
    }

    public static final int get(@NotNull Bitmap bitmap, int i6, int i7) {
        return bitmap.getPixel(i6, i7);
    }

    @NotNull
    public static final Bitmap scale(@NotNull Bitmap bitmap, int i6, int i7, boolean z5) {
        return Bitmap.createScaledBitmap(bitmap, i6, i7, z5);
    }

    public static final void set(@NotNull Bitmap bitmap, int i6, int i7, @ColorInt int i8) {
        bitmap.setPixel(i6, i7, i8);
    }
}
