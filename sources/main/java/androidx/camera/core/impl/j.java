package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import java.util.Collections;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class j {
    public static boolean e(CameraInternal cameraInternal) {
        return true;
    }

    @NonNull
    public static LinkedHashSet c(CameraInternal cameraInternal) {
        return new LinkedHashSet(Collections.singleton(cameraInternal));
    }

    @NonNull
    public static CameraControl a(CameraInternal cameraInternal) {
        return cameraInternal.getCameraControlInternal();
    }

    @NonNull
    public static CameraInfo b(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfoInternal();
    }

    @NonNull
    public static CameraConfig d(CameraInternal cameraInternal) {
        return CameraConfigs.emptyConfig();
    }

    public static boolean f(CameraInternal cameraInternal) {
        if (cameraInternal.getCameraInfo().getLensFacing() == 0) {
            return true;
        }
        return false;
    }

    public static void g(CameraInternal cameraInternal, boolean z5) {
    }

    public static void h(CameraInternal cameraInternal, @Nullable CameraConfig cameraConfig) {
    }
}
