package androidx.camera.core.impl;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class n0 {
    @NonNull
    public static CameraSelector a(UseCaseConfig useCaseConfig) {
        return (CameraSelector) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR);
    }

    @Nullable
    public static CameraSelector b(UseCaseConfig useCaseConfig, @Nullable CameraSelector cameraSelector) {
        return (CameraSelector) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
    }

    @NonNull
    public static CaptureConfig.OptionUnpacker c(UseCaseConfig useCaseConfig) {
        return (CaptureConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    @Nullable
    public static CaptureConfig.OptionUnpacker d(UseCaseConfig useCaseConfig, @Nullable CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
    }

    @NonNull
    public static UseCaseConfigFactory.CaptureType e(UseCaseConfig useCaseConfig) {
        return (UseCaseConfigFactory.CaptureType) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_TYPE);
    }

    @NonNull
    public static CaptureConfig f(UseCaseConfig useCaseConfig) {
        return (CaptureConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
    }

    @Nullable
    public static CaptureConfig g(UseCaseConfig useCaseConfig, @Nullable CaptureConfig captureConfig) {
        return (CaptureConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
    }

    @NonNull
    public static SessionConfig h(UseCaseConfig useCaseConfig) {
        return (SessionConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
    }

    @Nullable
    public static SessionConfig i(UseCaseConfig useCaseConfig, @Nullable SessionConfig sessionConfig) {
        return (SessionConfig) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
    }

    @NonNull
    public static SessionConfig.OptionUnpacker j(UseCaseConfig useCaseConfig) {
        return (SessionConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
    }

    @Nullable
    public static SessionConfig.OptionUnpacker k(UseCaseConfig useCaseConfig, @Nullable SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
    }

    public static int l(UseCaseConfig useCaseConfig) {
        return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY)).intValue();
    }

    public static int m(UseCaseConfig useCaseConfig, int i6) {
        return ((Integer) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i6))).intValue();
    }

    @NonNull
    public static Range n(UseCaseConfig useCaseConfig) {
        return (Range) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE);
    }

    @Nullable
    public static Range o(UseCaseConfig useCaseConfig, @Nullable Range range) {
        return (Range) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_TARGET_FRAME_RATE, range);
    }

    public static boolean p(UseCaseConfig useCaseConfig, boolean z5) {
        return ((Boolean) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_HIGH_RESOLUTION_DISABLED, Boolean.valueOf(z5))).booleanValue();
    }

    public static boolean q(UseCaseConfig useCaseConfig, boolean z5) {
        return ((Boolean) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z5))).booleanValue();
    }
}
