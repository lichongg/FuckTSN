package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.FallbackStrategy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_FallbackStrategy_RuleStrategy extends FallbackStrategy.RuleStrategy {
    private final Quality fallbackQuality;
    private final int fallbackRule;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FallbackStrategy.RuleStrategy) {
            FallbackStrategy.RuleStrategy ruleStrategy = (FallbackStrategy.RuleStrategy) obj;
            if (this.fallbackQuality.equals(ruleStrategy.getFallbackQuality()) && this.fallbackRule == ruleStrategy.getFallbackRule()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    @NonNull
    Quality getFallbackQuality() {
        return this.fallbackQuality;
    }

    @Override // androidx.camera.video.FallbackStrategy.RuleStrategy
    int getFallbackRule() {
        return this.fallbackRule;
    }

    public int hashCode() {
        return ((this.fallbackQuality.hashCode() ^ 1000003) * 1000003) ^ this.fallbackRule;
    }

    public String toString() {
        return "RuleStrategy{fallbackQuality=" + this.fallbackQuality + ", fallbackRule=" + this.fallbackRule + "}";
    }

    AutoValue_FallbackStrategy_RuleStrategy(Quality quality, int i6) {
        if (quality != null) {
            this.fallbackQuality = quality;
            this.fallbackRule = i6;
            return;
        }
        throw new NullPointerException("Null fallbackQuality");
    }
}
