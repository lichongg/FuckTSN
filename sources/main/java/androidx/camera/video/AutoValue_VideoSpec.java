package androidx.camera.video;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.video.VideoSpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_VideoSpec extends VideoSpec {
    private final int aspectRatio;
    private final Range<Integer> bitrate;
    private final Range<Integer> frameRate;
    private final QualitySelector qualitySelector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends VideoSpec.Builder {
        private Integer aspectRatio;
        private Range<Integer> bitrate;
        private Range<Integer> frameRate;
        private QualitySelector qualitySelector;

        Builder() {
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec build() {
            String str = "";
            if (this.qualitySelector == null) {
                str = " qualitySelector";
            }
            if (this.frameRate == null) {
                str = str + " frameRate";
            }
            if (this.bitrate == null) {
                str = str + " bitrate";
            }
            if (this.aspectRatio == null) {
                str = str + " aspectRatio";
            }
            if (str.isEmpty()) {
                return new AutoValue_VideoSpec(this.qualitySelector, this.frameRate, this.bitrate, this.aspectRatio.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setBitrate(Range<Integer> range) {
            if (range == null) {
                throw new NullPointerException("Null bitrate");
            }
            this.bitrate = range;
            return this;
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setFrameRate(Range<Integer> range) {
            if (range == null) {
                throw new NullPointerException("Null frameRate");
            }
            this.frameRate = range;
            return this;
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        public VideoSpec.Builder setQualitySelector(QualitySelector qualitySelector) {
            if (qualitySelector == null) {
                throw new NullPointerException("Null qualitySelector");
            }
            this.qualitySelector = qualitySelector;
            return this;
        }

        private Builder(VideoSpec videoSpec) {
            this.qualitySelector = videoSpec.getQualitySelector();
            this.frameRate = videoSpec.getFrameRate();
            this.bitrate = videoSpec.getBitrate();
            this.aspectRatio = Integer.valueOf(videoSpec.getAspectRatio());
        }

        @Override // androidx.camera.video.VideoSpec.Builder
        VideoSpec.Builder setAspectRatio(int i6) {
            this.aspectRatio = Integer.valueOf(i6);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoSpec) {
            VideoSpec videoSpec = (VideoSpec) obj;
            if (this.qualitySelector.equals(videoSpec.getQualitySelector()) && this.frameRate.equals(videoSpec.getFrameRate()) && this.bitrate.equals(videoSpec.getBitrate()) && this.aspectRatio == videoSpec.getAspectRatio()) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_VideoSpec(QualitySelector qualitySelector, Range<Integer> range, Range<Integer> range2, int i6) {
        this.qualitySelector = qualitySelector;
        this.frameRate = range;
        this.bitrate = range2;
        this.aspectRatio = i6;
    }

    @Override // androidx.camera.video.VideoSpec
    int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    @NonNull
    public Range<Integer> getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.VideoSpec
    @NonNull
    public Range<Integer> getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.video.VideoSpec
    @NonNull
    public QualitySelector getQualitySelector() {
        return this.qualitySelector;
    }

    public int hashCode() {
        return ((((((this.qualitySelector.hashCode() ^ 1000003) * 1000003) ^ this.frameRate.hashCode()) * 1000003) ^ this.bitrate.hashCode()) * 1000003) ^ this.aspectRatio;
    }

    @Override // androidx.camera.video.VideoSpec
    public VideoSpec.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "VideoSpec{qualitySelector=" + this.qualitySelector + ", frameRate=" + this.frameRate + ", bitrate=" + this.bitrate + ", aspectRatio=" + this.aspectRatio + "}";
    }
}
