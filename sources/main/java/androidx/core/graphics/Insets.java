package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class Insets {

    @NonNull
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;

    /* renamed from: top, reason: collision with root package name */
    public final int f836top;

    @NonNull
    public static Insets of(int i6, int i7, int i8, int i9) {
        return (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) ? NONE : new Insets(i6, i7, i8, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.f836top == insets.f836top;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static android.graphics.Insets of(int i6, int i7, int i8, int i9) {
            return android.graphics.Insets.of(i6, i7, i8, i9);
        }
    }

    @NonNull
    public static Insets add(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(insets.left + insets2.left, insets.f836top + insets2.f836top, insets.right + insets2.right, insets.bottom + insets2.bottom);
    }

    @NonNull
    public static Insets max(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(Math.max(insets.left, insets2.left), Math.max(insets.f836top, insets2.f836top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom));
    }

    @NonNull
    public static Insets min(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(Math.min(insets.left, insets2.left), Math.min(insets.f836top, insets2.f836top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom));
    }

    @NonNull
    public static Insets subtract(@NonNull Insets insets, @NonNull Insets insets2) {
        return of(insets.left - insets2.left, insets.f836top - insets2.f836top, insets.right - insets2.right, insets.bottom - insets2.bottom);
    }

    public int hashCode() {
        return (((((this.left * 31) + this.f836top) * 31) + this.right) * 31) + this.bottom;
    }

    @NonNull
    @RequiresApi(29)
    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.of(this.left, this.f836top, this.right, this.bottom);
    }

    @NonNull
    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.f836top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    private Insets(int i6, int i7, int i8, int i9) {
        this.left = i6;
        this.f836top = i7;
        this.right = i8;
        this.bottom = i9;
    }

    @NonNull
    public static Insets of(@NonNull Rect rect) {
        return of(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NonNull
    @RequiresApi(api = 29)
    public static Insets toCompatInsets(@NonNull android.graphics.Insets insets) {
        int i6;
        int i7;
        int i8;
        int i9;
        i6 = insets.left;
        i7 = insets.top;
        i8 = insets.right;
        i9 = insets.bottom;
        return of(i6, i7, i8, i9);
    }

    @NonNull
    @Deprecated
    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Insets wrap(@NonNull android.graphics.Insets insets) {
        return toCompatInsets(insets);
    }
}
