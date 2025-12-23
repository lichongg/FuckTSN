package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PathUtils {
    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float[] approximate(Path path, float f6) {
            return path.approximate(f6);
        }
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f6) {
        float[] approximate = Api26Impl.approximate(path, f6);
        int length = approximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i6 = 1; i6 < length; i6++) {
            int i7 = i6 * 3;
            int i8 = (i6 - 1) * 3;
            float f7 = approximate[i7];
            float f8 = approximate[i7 + 1];
            float f9 = approximate[i7 + 2];
            float f10 = approximate[i8];
            float f11 = approximate[i8 + 1];
            float f12 = approximate[i8 + 2];
            if (f7 != f10 && (f8 != f11 || f9 != f12)) {
                arrayList.add(new PathSegment(new PointF(f11, f12), f10, new PointF(f8, f9), f7));
            }
        }
        return arrayList;
    }

    private PathUtils() {
    }
}
