package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n+ 2 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n1#1,118:1\n38#2:119\n49#2:120\n60#2:121\n71#2:122\n*S KotlinDebug\n*F\n+ 1 Drawable.kt\nandroidx/core/graphics/drawable/DrawableKt\n*L\n66#1:119\n66#1:120\n66#1:121\n66#1:122\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class DrawableKt {
    @NotNull
    public static final Bitmap toBitmap(@NotNull Drawable drawable, @Px int i6, @Px int i7, @Nullable Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                return (i6 == bitmapDrawable.getBitmap().getWidth() && i7 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i6, i7, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i8 = bounds.left;
        int i9 = bounds.top;
        int i10 = bounds.right;
        int i11 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, config);
        drawable.setBounds(0, 0, i6, i7);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i8, i9, i10, i11);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i6, int i7, Bitmap.Config config, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = drawable.getIntrinsicWidth();
        }
        if ((i8 & 2) != 0) {
            i7 = drawable.getIntrinsicHeight();
        }
        if ((i8 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i6, i7, config);
    }

    @Nullable
    public static final Bitmap toBitmapOrNull(@NotNull Drawable drawable, @Px int i6, @Px int i7, @Nullable Bitmap.Config config) {
        if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null) {
            return null;
        }
        return toBitmap(drawable, i6, i7, config);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i6, int i7, Bitmap.Config config, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = drawable.getIntrinsicWidth();
        }
        if ((i8 & 2) != 0) {
            i7 = drawable.getIntrinsicHeight();
        }
        if ((i8 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i6, i7, config);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i6, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i6 = drawable.getBounds().left;
        }
        if ((i10 & 2) != 0) {
            i7 = drawable.getBounds().top;
        }
        if ((i10 & 4) != 0) {
            i8 = drawable.getBounds().right;
        }
        if ((i10 & 8) != 0) {
            i9 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i6, i7, i8, i9);
    }

    public static final void updateBounds(@NotNull Drawable drawable, @Px int i6, @Px int i7, @Px int i8, @Px int i9) {
        drawable.setBounds(i6, i7, i8, i9);
    }
}
