package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class f {
    public static int b(CameraInfo cameraInfo) {
        return -1;
    }

    public static boolean d(CameraInfo cameraInfo, @NonNull FocusMeteringAction focusMeteringAction) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean e(CameraInfo cameraInfo) {
        return false;
    }

    @ExperimentalZeroShutterLag
    public static boolean f(CameraInfo cameraInfo) {
        return false;
    }

    @FloatRange(from = 0.0d, fromInclusive = false)
    public static float a(CameraInfo cameraInfo) {
        return 1.0f;
    }

    @NonNull
    public static Set c(CameraInfo cameraInfo) {
        return Collections.EMPTY_SET;
    }
}
