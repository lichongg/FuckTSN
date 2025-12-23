package androidx.camera.core.impl.utils;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.resolutionselector.ResolutionSelector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ResolutionSelectorUtil {
    @Nullable
    public static ResolutionSelector overrideResolutionSelectors(@Nullable ResolutionSelector resolutionSelector, @Nullable ResolutionSelector resolutionSelector2) {
        if (resolutionSelector2 == null) {
            return resolutionSelector;
        }
        if (resolutionSelector == null) {
            return resolutionSelector2;
        }
        ResolutionSelector.Builder fromResolutionSelector = ResolutionSelector.Builder.fromResolutionSelector(resolutionSelector);
        if (resolutionSelector2.getAspectRatioStrategy() != null) {
            fromResolutionSelector.setAspectRatioStrategy(resolutionSelector2.getAspectRatioStrategy());
        }
        if (resolutionSelector2.getResolutionStrategy() != null) {
            fromResolutionSelector.setResolutionStrategy(resolutionSelector2.getResolutionStrategy());
        }
        if (resolutionSelector2.getResolutionFilter() != null) {
            fromResolutionSelector.setResolutionFilter(resolutionSelector2.getResolutionFilter());
        }
        if (resolutionSelector2.getAllowedResolutionMode() != 0) {
            fromResolutionSelector.setAllowedResolutionMode(resolutionSelector2.getAllowedResolutionMode());
        }
        return fromResolutionSelector.build();
    }

    private ResolutionSelectorUtil() {
    }
}
