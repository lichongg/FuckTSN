package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.QualityRatioToResolutionsTable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_QualityRatioToResolutionsTable_QualityRatio extends QualityRatioToResolutionsTable.QualityRatio {
    private final int aspectRatio;
    private final Quality quality;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof QualityRatioToResolutionsTable.QualityRatio) {
            QualityRatioToResolutionsTable.QualityRatio qualityRatio = (QualityRatioToResolutionsTable.QualityRatio) obj;
            if (this.quality.equals(qualityRatio.getQuality()) && this.aspectRatio == qualityRatio.getAspectRatio()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    @NonNull
    Quality getQuality() {
        return this.quality;
    }

    public int hashCode() {
        return ((this.quality.hashCode() ^ 1000003) * 1000003) ^ this.aspectRatio;
    }

    public String toString() {
        return "QualityRatio{quality=" + this.quality + ", aspectRatio=" + this.aspectRatio + "}";
    }

    AutoValue_QualityRatioToResolutionsTable_QualityRatio(Quality quality, int i6) {
        if (quality != null) {
            this.quality = quality;
            this.aspectRatio = i6;
            return;
        }
        throw new NullPointerException("Null quality");
    }
}
