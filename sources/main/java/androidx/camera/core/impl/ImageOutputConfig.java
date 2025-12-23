package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface ImageOutputConfig extends ReadableConfig {
    public static final int INVALID_ROTATION = -1;
    public static final Config.Option<Integer> OPTION_APP_TARGET_ROTATION;
    public static final Config.Option<List<Size>> OPTION_CUSTOM_ORDERED_RESOLUTIONS;
    public static final Config.Option<Size> OPTION_DEFAULT_RESOLUTION;
    public static final Config.Option<Size> OPTION_MAX_RESOLUTION;
    public static final Config.Option<Integer> OPTION_MIRROR_MODE;
    public static final Config.Option<ResolutionSelector> OPTION_RESOLUTION_SELECTOR;
    public static final Config.Option<List<Pair<Integer, Size[]>>> OPTION_SUPPORTED_RESOLUTIONS;
    public static final Config.Option<Integer> OPTION_TARGET_ASPECT_RATIO = Config.Option.create("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
    public static final Config.Option<Size> OPTION_TARGET_RESOLUTION;
    public static final Config.Option<Integer> OPTION_TARGET_ROTATION;
    public static final int ROTATION_NOT_SPECIFIED = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Builder<B> {
        @NonNull
        B setCustomOrderedResolutions(@NonNull List<Size> list);

        @NonNull
        B setDefaultResolution(@NonNull Size size);

        @NonNull
        B setMaxResolution(@NonNull Size size);

        @NonNull
        B setMirrorMode(int i6);

        @NonNull
        B setResolutionSelector(@NonNull ResolutionSelector resolutionSelector);

        @NonNull
        B setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list);

        @NonNull
        B setTargetAspectRatio(int i6);

        @NonNull
        B setTargetResolution(@NonNull Size size);

        @NonNull
        B setTargetRotation(int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OptionalRotationValue {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationDegreesValue {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationValue {
    }

    int getAppTargetRotation(int i6);

    @NonNull
    List<Size> getCustomOrderedResolutions();

    @Nullable
    List<Size> getCustomOrderedResolutions(@Nullable List<Size> list);

    @NonNull
    Size getDefaultResolution();

    @Nullable
    Size getDefaultResolution(@Nullable Size size);

    @NonNull
    Size getMaxResolution();

    @Nullable
    Size getMaxResolution(@Nullable Size size);

    int getMirrorMode(int i6);

    @NonNull
    ResolutionSelector getResolutionSelector();

    @Nullable
    ResolutionSelector getResolutionSelector(@Nullable ResolutionSelector resolutionSelector);

    @NonNull
    List<Pair<Integer, Size[]>> getSupportedResolutions();

    @Nullable
    List<Pair<Integer, Size[]>> getSupportedResolutions(@Nullable List<Pair<Integer, Size[]>> list);

    int getTargetAspectRatio();

    @NonNull
    Size getTargetResolution();

    @Nullable
    Size getTargetResolution(@Nullable Size size);

    int getTargetRotation();

    int getTargetRotation(int i6);

    boolean hasTargetAspectRatio();

    static {
        Class cls = Integer.TYPE;
        OPTION_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.targetRotation", cls);
        OPTION_APP_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.appTargetRotation", cls);
        OPTION_MIRROR_MODE = Config.Option.create("camerax.core.imageOutput.mirrorMode", cls);
        OPTION_TARGET_RESOLUTION = Config.Option.create("camerax.core.imageOutput.targetResolution", Size.class);
        OPTION_DEFAULT_RESOLUTION = Config.Option.create("camerax.core.imageOutput.defaultResolution", Size.class);
        OPTION_MAX_RESOLUTION = Config.Option.create("camerax.core.imageOutput.maxResolution", Size.class);
        OPTION_SUPPORTED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.supportedResolutions", List.class);
        OPTION_RESOLUTION_SELECTOR = Config.Option.create("camerax.core.imageOutput.resolutionSelector", ResolutionSelector.class);
        OPTION_CUSTOM_ORDERED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.customOrderedResolutions", List.class);
    }
}
