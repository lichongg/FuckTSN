package androidx.camera.core.resolutionselector;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AspectRatioStrategy {
    public static final int FALLBACK_RULE_AUTO = 1;
    public static final int FALLBACK_RULE_NONE = 0;
    private final int mFallbackRule;
    private final int mPreferredAspectRatio;

    @NonNull
    public static final AspectRatioStrategy RATIO_4_3_FALLBACK_AUTO_STRATEGY = new AspectRatioStrategy(0, 1);

    @NonNull
    public static final AspectRatioStrategy RATIO_16_9_FALLBACK_AUTO_STRATEGY = new AspectRatioStrategy(1, 1);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AspectRatioFallbackRule {
    }

    public int getFallbackRule() {
        return this.mFallbackRule;
    }

    public int getPreferredAspectRatio() {
        return this.mPreferredAspectRatio;
    }

    public AspectRatioStrategy(int i6, int i7) {
        this.mPreferredAspectRatio = i6;
        this.mFallbackRule = i7;
    }
}
