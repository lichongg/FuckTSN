package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ExtendedCameraConfigProviderStore {
    private static final Object LOCK = new Object();

    @GuardedBy("LOCK")
    private static final Map<Object, CameraConfigProvider> CAMERA_CONFIG_PROVIDERS = new HashMap();

    public static void addConfig(@NonNull Object obj, @NonNull CameraConfigProvider cameraConfigProvider) {
        synchronized (LOCK) {
            CAMERA_CONFIG_PROVIDERS.put(obj, cameraConfigProvider);
        }
    }

    public static void clear() {
        synchronized (LOCK) {
            CAMERA_CONFIG_PROVIDERS.clear();
        }
    }

    @NonNull
    public static CameraConfigProvider getConfigProvider(@NonNull Object obj) {
        CameraConfigProvider cameraConfigProvider;
        synchronized (LOCK) {
            cameraConfigProvider = CAMERA_CONFIG_PROVIDERS.get(obj);
        }
        return cameraConfigProvider == null ? CameraConfigProvider.EMPTY : cameraConfigProvider;
    }

    private ExtendedCameraConfigProviderStore() {
    }
}
