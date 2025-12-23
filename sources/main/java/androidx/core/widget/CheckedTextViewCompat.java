package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CheckedTextViewCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @Nullable
        static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintList();
        }

        @Nullable
        static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintMode();
        }

        static void setCheckMarkTintList(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void setCheckMarkTintMode(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    private CheckedTextViewCompat() {
    }

    @Nullable
    public static Drawable getCheckMarkDrawable(@NonNull CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkDrawable();
    }

    @Nullable
    public static ColorStateList getCheckMarkTintList(@NonNull CheckedTextView checkedTextView) {
        return Api21Impl.getCheckMarkTintList(checkedTextView);
    }

    @Nullable
    public static PorterDuff.Mode getCheckMarkTintMode(@NonNull CheckedTextView checkedTextView) {
        return Api21Impl.getCheckMarkTintMode(checkedTextView);
    }

    public static void setCheckMarkTintList(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
        Api21Impl.setCheckMarkTintList(checkedTextView, colorStateList);
    }

    public static void setCheckMarkTintMode(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
        Api21Impl.setCheckMarkTintMode(checkedTextView, mode);
    }
}
