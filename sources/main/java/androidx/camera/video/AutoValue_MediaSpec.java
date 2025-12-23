package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.MediaSpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_MediaSpec extends MediaSpec {
    private final AudioSpec audioSpec;
    private final int outputFormat;
    private final VideoSpec videoSpec;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends MediaSpec.Builder {
        private AudioSpec audioSpec;
        private Integer outputFormat;
        private VideoSpec videoSpec;

        Builder() {
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec build() {
            String str = "";
            if (this.videoSpec == null) {
                str = " videoSpec";
            }
            if (this.audioSpec == null) {
                str = str + " audioSpec";
            }
            if (this.outputFormat == null) {
                str = str + " outputFormat";
            }
            if (str.isEmpty()) {
                return new AutoValue_MediaSpec(this.videoSpec, this.audioSpec, this.outputFormat.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        AudioSpec getAudioSpec() {
            AudioSpec audioSpec = this.audioSpec;
            if (audioSpec != null) {
                return audioSpec;
            }
            throw new IllegalStateException("Property \"audioSpec\" has not been set");
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        VideoSpec getVideoSpec() {
            VideoSpec videoSpec = this.videoSpec;
            if (videoSpec != null) {
                return videoSpec;
            }
            throw new IllegalStateException("Property \"videoSpec\" has not been set");
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setAudioSpec(AudioSpec audioSpec) {
            if (audioSpec == null) {
                throw new NullPointerException("Null audioSpec");
            }
            this.audioSpec = audioSpec;
            return this;
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setVideoSpec(VideoSpec videoSpec) {
            if (videoSpec == null) {
                throw new NullPointerException("Null videoSpec");
            }
            this.videoSpec = videoSpec;
            return this;
        }

        private Builder(MediaSpec mediaSpec) {
            this.videoSpec = mediaSpec.getVideoSpec();
            this.audioSpec = mediaSpec.getAudioSpec();
            this.outputFormat = Integer.valueOf(mediaSpec.getOutputFormat());
        }

        @Override // androidx.camera.video.MediaSpec.Builder
        public MediaSpec.Builder setOutputFormat(int i6) {
            this.outputFormat = Integer.valueOf(i6);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MediaSpec) {
            MediaSpec mediaSpec = (MediaSpec) obj;
            if (this.videoSpec.equals(mediaSpec.getVideoSpec()) && this.audioSpec.equals(mediaSpec.getAudioSpec()) && this.outputFormat == mediaSpec.getOutputFormat()) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_MediaSpec(VideoSpec videoSpec, AudioSpec audioSpec, int i6) {
        this.videoSpec = videoSpec;
        this.audioSpec = audioSpec;
        this.outputFormat = i6;
    }

    @Override // androidx.camera.video.MediaSpec
    @NonNull
    public AudioSpec getAudioSpec() {
        return this.audioSpec;
    }

    @Override // androidx.camera.video.MediaSpec
    public int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.video.MediaSpec
    @NonNull
    public VideoSpec getVideoSpec() {
        return this.videoSpec;
    }

    public int hashCode() {
        return ((((this.videoSpec.hashCode() ^ 1000003) * 1000003) ^ this.audioSpec.hashCode()) * 1000003) ^ this.outputFormat;
    }

    @Override // androidx.camera.video.MediaSpec
    public MediaSpec.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "MediaSpec{videoSpec=" + this.videoSpec + ", audioSpec=" + this.audioSpec + ", outputFormat=" + this.outputFormat + "}";
    }
}
