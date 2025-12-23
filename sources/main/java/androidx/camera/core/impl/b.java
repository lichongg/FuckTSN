package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class b {
    @NonNull
    public static SessionProcessor a(CameraConfig cameraConfig) {
        return (SessionProcessor) cameraConfig.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR);
    }

    @Nullable
    public static SessionProcessor b(CameraConfig cameraConfig, @Nullable SessionProcessor sessionProcessor) {
        return (SessionProcessor) cameraConfig.retrieveOption(CameraConfig.OPTION_SESSION_PROCESSOR, sessionProcessor);
    }

    public static int c(CameraConfig cameraConfig) {
        return ((Integer) cameraConfig.retrieveOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, 0)).intValue();
    }

    @NonNull
    public static UseCaseConfigFactory d(CameraConfig cameraConfig) {
        return (UseCaseConfigFactory) cameraConfig.retrieveOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, UseCaseConfigFactory.EMPTY_INSTANCE);
    }
}
