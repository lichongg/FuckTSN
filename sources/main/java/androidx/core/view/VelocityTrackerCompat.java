package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class VelocityTrackerCompat {
    private static Map<VelocityTracker, VelocityTrackerFallback> sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(34)
    private static class Api34Impl {
        @DoNotInline
        static float getAxisVelocity(VelocityTracker velocityTracker, int i6, int i7) {
            return velocityTracker.getAxisVelocity(i6, i7);
        }

        @DoNotInline
        static float getAxisVelocity(VelocityTracker velocityTracker, int i6) {
            return velocityTracker.getAxisVelocity(i6);
        }

        private Api34Impl() {
        }

        @DoNotInline
        static boolean isAxisSupported(VelocityTracker velocityTracker, int i6) {
            return velocityTracker.isAxisSupported(i6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface VelocityTrackableMotionEventAxis {
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i6, float f6) {
        velocityTracker.computeCurrentVelocity(i6, f6);
        VelocityTrackerFallback fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            fallbackTrackerOrNull.computeCurrentVelocity(i6, f6);
        }
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i6) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(velocityTracker, i6);
        }
        if (i6 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i6 == 1) {
            return velocityTracker.getYVelocity();
        }
        VelocityTrackerFallback fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            return fallbackTrackerOrNull.getAxisVelocity(i6);
        }
        return 0.0f;
    }

    @Nullable
    private static VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker velocityTracker) {
        return sFallbackTrackers.get(velocityTracker);
    }

    public static boolean isAxisSupported(@NonNull VelocityTracker velocityTracker, int i6) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.isAxisSupported(velocityTracker, i6) : i6 == 26 || i6 == 0 || i6 == 1;
    }

    private static void removeFallbackForTracker(VelocityTracker velocityTracker) {
        sFallbackTrackers.remove(velocityTracker);
    }

    private VelocityTrackerCompat() {
    }

    public static void addMovement(@NonNull VelocityTracker velocityTracker, @NonNull MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!sFallbackTrackers.containsKey(velocityTracker)) {
                sFallbackTrackers.put(velocityTracker, new VelocityTrackerFallback());
            }
            sFallbackTrackers.get(velocityTracker).addMovement(motionEvent);
        }
    }

    public static void clear(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.clear();
        removeFallbackForTracker(velocityTracker);
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i6) {
        return velocityTracker.getXVelocity(i6);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i6) {
        return velocityTracker.getYVelocity(i6);
    }

    public static void recycle(@NonNull VelocityTracker velocityTracker) {
        velocityTracker.recycle();
        removeFallbackForTracker(velocityTracker);
    }

    public static void computeCurrentVelocity(@NonNull VelocityTracker velocityTracker, int i6) {
        computeCurrentVelocity(velocityTracker, i6, Float.MAX_VALUE);
    }

    public static float getAxisVelocity(@NonNull VelocityTracker velocityTracker, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(velocityTracker, i6, i7);
        }
        if (i6 == 0) {
            return velocityTracker.getXVelocity(i7);
        }
        if (i6 == 1) {
            return velocityTracker.getYVelocity(i7);
        }
        return 0.0f;
    }
}
