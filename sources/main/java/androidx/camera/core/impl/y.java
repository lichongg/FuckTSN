package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class y {
    @NonNull
    public static DynamicRange a(ImageInputConfig imageInputConfig) {
        return (DynamicRange) Preconditions.checkNotNull((DynamicRange) imageInputConfig.retrieveOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED));
    }

    public static int b(ImageInputConfig imageInputConfig) {
        return ((Integer) imageInputConfig.retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    public static boolean c(ImageInputConfig imageInputConfig) {
        return imageInputConfig.containsOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE);
    }
}
