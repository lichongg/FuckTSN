package androidx.camera.core.resolutionselector;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ResolutionStrategy {
    public static final int FALLBACK_RULE_CLOSEST_HIGHER = 2;
    public static final int FALLBACK_RULE_CLOSEST_HIGHER_THEN_LOWER = 1;
    public static final int FALLBACK_RULE_CLOSEST_LOWER = 4;
    public static final int FALLBACK_RULE_CLOSEST_LOWER_THEN_HIGHER = 3;
    public static final int FALLBACK_RULE_NONE = 0;

    @NonNull
    public static final ResolutionStrategy HIGHEST_AVAILABLE_STRATEGY = new ResolutionStrategy();

    @Nullable
    private Size mBoundSize;
    private int mFallbackRule;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ResolutionFallbackRule {
    }

    private ResolutionStrategy() {
        this.mBoundSize = null;
        this.mFallbackRule = 0;
    }

    @Nullable
    public Size getBoundSize() {
        return this.mBoundSize;
    }

    public int getFallbackRule() {
        return this.mFallbackRule;
    }

    public ResolutionStrategy(@NonNull Size size, int i6) {
        this.mBoundSize = size;
        this.mFallbackRule = i6;
    }
}
