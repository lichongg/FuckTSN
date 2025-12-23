package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class FallbackStrategy {
    static final int FALLBACK_RULE_HIGHER = 2;
    static final int FALLBACK_RULE_HIGHER_OR_LOWER = 1;
    static final int FALLBACK_RULE_LOWER = 4;
    static final int FALLBACK_RULE_LOWER_OR_HIGHER = 3;
    static final int FALLBACK_RULE_NONE = 0;
    static final FallbackStrategy NONE = new AutoValue_FallbackStrategy_RuleStrategy(Quality.NONE, 0);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class RuleStrategy extends FallbackStrategy {
        RuleStrategy() {
            super();
        }

        @NonNull
        abstract Quality getFallbackQuality();

        abstract int getFallbackRule();
    }

    private FallbackStrategy() {
    }

    @NonNull
    public static FallbackStrategy higherQualityOrLowerThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 1);
    }

    @NonNull
    public static FallbackStrategy higherQualityThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 2);
    }

    @NonNull
    public static FallbackStrategy lowerQualityOrHigherThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 3);
    }

    @NonNull
    public static FallbackStrategy lowerQualityThan(@NonNull Quality quality) {
        return new AutoValue_FallbackStrategy_RuleStrategy(quality, 4);
    }
}
