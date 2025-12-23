package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class z {
    static {
        int i6 = ImageOutputConfig.INVALID_ROTATION;
    }

    public static int a(ImageOutputConfig imageOutputConfig, int i6) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_APP_TARGET_ROTATION, Integer.valueOf(i6))).intValue();
    }

    @NonNull
    public static List b(ImageOutputConfig imageOutputConfig) {
        List list = (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS);
        Objects.requireNonNull(list);
        return new ArrayList(list);
    }

    @Nullable
    public static List c(ImageOutputConfig imageOutputConfig, @Nullable List list) {
        List list2 = (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, list);
        if (list2 != null) {
            return new ArrayList(list2);
        }
        return null;
    }

    @NonNull
    public static Size d(ImageOutputConfig imageOutputConfig) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION);
    }

    @Nullable
    public static Size e(ImageOutputConfig imageOutputConfig, @Nullable Size size) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
    }

    @NonNull
    public static Size f(ImageOutputConfig imageOutputConfig) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
    }

    @Nullable
    public static Size g(ImageOutputConfig imageOutputConfig, @Nullable Size size) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, size);
    }

    public static int h(ImageOutputConfig imageOutputConfig, int i6) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_MIRROR_MODE, Integer.valueOf(i6))).intValue();
    }

    @NonNull
    public static ResolutionSelector i(ImageOutputConfig imageOutputConfig) {
        return (ResolutionSelector) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR);
    }

    @Nullable
    public static ResolutionSelector j(ImageOutputConfig imageOutputConfig, @Nullable ResolutionSelector resolutionSelector) {
        return (ResolutionSelector) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR, resolutionSelector);
    }

    @NonNull
    public static List k(ImageOutputConfig imageOutputConfig) {
        return (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS);
    }

    @Nullable
    public static List l(ImageOutputConfig imageOutputConfig, @Nullable List list) {
        return (List) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
    }

    public static int m(ImageOutputConfig imageOutputConfig) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)).intValue();
    }

    @NonNull
    public static Size n(ImageOutputConfig imageOutputConfig) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION);
    }

    @Nullable
    public static Size o(ImageOutputConfig imageOutputConfig, @Nullable Size size) {
        return (Size) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, size);
    }

    public static int p(ImageOutputConfig imageOutputConfig) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION)).intValue();
    }

    public static int q(ImageOutputConfig imageOutputConfig, int i6) {
        return ((Integer) imageOutputConfig.retrieveOption(ImageOutputConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i6))).intValue();
    }

    public static boolean r(ImageOutputConfig imageOutputConfig) {
        return imageOutputConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
    }

    public static void s(@NonNull ImageOutputConfig imageOutputConfig) {
        boolean z5;
        boolean hasTargetAspectRatio = imageOutputConfig.hasTargetAspectRatio();
        if (imageOutputConfig.getTargetResolution(null) != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (hasTargetAspectRatio && z5) {
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }
        if (imageOutputConfig.getResolutionSelector(null) != null) {
            if (hasTargetAspectRatio || z5) {
                throw new IllegalArgumentException("Cannot use setTargetResolution or setTargetAspectRatio with setResolutionSelector on the same config.");
            }
        }
    }
}
