package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CursorWindowCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(28)
    static class Api28Impl {
        @DoNotInline
        static CursorWindow createCursorWindow(String str, long j6) {
            return new CursorWindow(str, j6);
        }

        private Api28Impl() {
        }
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j6) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.createCursorWindow(str, j6) : new CursorWindow(str);
    }

    private CursorWindowCompat() {
    }
}
