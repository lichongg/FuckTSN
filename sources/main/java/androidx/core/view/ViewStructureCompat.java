package androidx.core.view;

import android.os.Build;
import android.view.ViewStructure;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class ViewStructureCompat {
    private final Object mWrappedObj;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void setClassName(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        @DoNotInline
        static void setContentDescription(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        @DoNotInline
        static void setDimens(ViewStructure viewStructure, int i6, int i7, int i8, int i9, int i10, int i11) {
            viewStructure.setDimens(i6, i7, i8, i9, i10, i11);
        }

        @DoNotInline
        static void setText(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    @NonNull
    @RequiresApi(23)
    public static ViewStructureCompat toViewStructureCompat(@NonNull ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setClassName(n0.a(this.mWrappedObj), str);
        }
    }

    public void setContentDescription(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setContentDescription(n0.a(this.mWrappedObj), charSequence);
        }
    }

    public void setDimens(int i6, int i7, int i8, int i9, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setDimens(n0.a(this.mWrappedObj), i6, i7, i8, i9, i10, i11);
        }
    }

    public void setText(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.setText(n0.a(this.mWrappedObj), charSequence);
        }
    }

    @NonNull
    @RequiresApi(23)
    public ViewStructure toViewStructure() {
        return n0.a(this.mWrappedObj);
    }

    private ViewStructureCompat(@NonNull ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }
}
