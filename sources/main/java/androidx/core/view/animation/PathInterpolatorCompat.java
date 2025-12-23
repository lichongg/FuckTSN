package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PathInterpolatorCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        @DoNotInline
        static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f6, float f7) {
            return new PathInterpolator(f6, f7);
        }

        private Api21Impl() {
        }

        @DoNotInline
        static Interpolator createPathInterpolator(float f6, float f7, float f8, float f9) {
            return new PathInterpolator(f6, f7, f8, f9);
        }
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f6, float f7) {
        return Api21Impl.createPathInterpolator(f6, f7);
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(float f6, float f7, float f8, float f9) {
        return Api21Impl.createPathInterpolator(f6, f7, f8, f9);
    }
}
