package androidx.camera.core.impl;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface UseCaseConfig<T extends UseCase> extends TargetConfig<T>, UseCaseEventConfig, ImageInputConfig {
    public static final Config.Option<UseCaseConfigFactory.CaptureType> OPTION_CAPTURE_TYPE;
    public static final Config.Option<Boolean> OPTION_HIGH_RESOLUTION_DISABLED;
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED;
    public static final Config.Option<SessionConfig> OPTION_DEFAULT_SESSION_CONFIG = Config.Option.create("camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
    public static final Config.Option<CaptureConfig> OPTION_DEFAULT_CAPTURE_CONFIG = Config.Option.create("camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);
    public static final Config.Option<SessionConfig.OptionUnpacker> OPTION_SESSION_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.sessionConfigUnpacker", SessionConfig.OptionUnpacker.class);
    public static final Config.Option<CaptureConfig.OptionUnpacker> OPTION_CAPTURE_CONFIG_UNPACKER = Config.Option.create("camerax.core.useCase.captureConfigUnpacker", CaptureConfig.OptionUnpacker.class);
    public static final Config.Option<Integer> OPTION_SURFACE_OCCUPANCY_PRIORITY = Config.Option.create("camerax.core.useCase.surfaceOccupancyPriority", Integer.TYPE);
    public static final Config.Option<CameraSelector> OPTION_CAMERA_SELECTOR = Config.Option.create("camerax.core.useCase.cameraSelector", CameraSelector.class);
    public static final Config.Option<Range<Integer>> OPTION_TARGET_FRAME_RATE = Config.Option.create("camerax.core.useCase.targetFrameRate", Range.class);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Builder<T extends UseCase, C extends UseCaseConfig<T>, B> extends TargetConfig.Builder<T, B>, ExtendableBuilder<T>, UseCaseEventConfig.Builder<B> {
        @NonNull
        C getUseCaseConfig();

        @NonNull
        B setCameraSelector(@NonNull CameraSelector cameraSelector);

        @NonNull
        B setCaptureOptionUnpacker(@NonNull CaptureConfig.OptionUnpacker optionUnpacker);

        @NonNull
        B setCaptureType(@NonNull UseCaseConfigFactory.CaptureType captureType);

        @NonNull
        B setDefaultCaptureConfig(@NonNull CaptureConfig captureConfig);

        @NonNull
        B setDefaultSessionConfig(@NonNull SessionConfig sessionConfig);

        @NonNull
        B setHighResolutionDisabled(boolean z5);

        @NonNull
        B setSessionOptionUnpacker(@NonNull SessionConfig.OptionUnpacker optionUnpacker);

        @NonNull
        B setSurfaceOccupancyPriority(int i6);

        @NonNull
        B setZslDisabled(boolean z5);
    }

    @NonNull
    CameraSelector getCameraSelector();

    @Nullable
    CameraSelector getCameraSelector(@Nullable CameraSelector cameraSelector);

    @NonNull
    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker();

    @Nullable
    CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(@Nullable CaptureConfig.OptionUnpacker optionUnpacker);

    @NonNull
    UseCaseConfigFactory.CaptureType getCaptureType();

    @NonNull
    CaptureConfig getDefaultCaptureConfig();

    @Nullable
    CaptureConfig getDefaultCaptureConfig(@Nullable CaptureConfig captureConfig);

    @NonNull
    SessionConfig getDefaultSessionConfig();

    @Nullable
    SessionConfig getDefaultSessionConfig(@Nullable SessionConfig sessionConfig);

    @NonNull
    SessionConfig.OptionUnpacker getSessionOptionUnpacker();

    @Nullable
    SessionConfig.OptionUnpacker getSessionOptionUnpacker(@Nullable SessionConfig.OptionUnpacker optionUnpacker);

    int getSurfaceOccupancyPriority();

    int getSurfaceOccupancyPriority(int i6);

    @NonNull
    Range<Integer> getTargetFrameRate();

    @Nullable
    Range<Integer> getTargetFrameRate(@Nullable Range<Integer> range);

    boolean isHigResolutionDisabled(boolean z5);

    boolean isZslDisabled(boolean z5);

    static {
        Class cls = Boolean.TYPE;
        OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.useCase.zslDisabled", cls);
        OPTION_HIGH_RESOLUTION_DISABLED = Config.Option.create("camerax.core.useCase.highResolutionDisabled", cls);
        OPTION_CAPTURE_TYPE = Config.Option.create("camerax.core.useCase.captureType", UseCaseConfigFactory.CaptureType.class);
    }
}
