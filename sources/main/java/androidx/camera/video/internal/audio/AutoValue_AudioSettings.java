package androidx.camera.video.internal.audio;

import androidx.annotation.IntRange;
import androidx.camera.video.internal.audio.AudioSettings;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_AudioSettings extends AudioSettings {
    private final int audioFormat;
    private final int audioSource;
    private final int channelCount;
    private final int sampleRate;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends AudioSettings.Builder {
        private Integer audioFormat;
        private Integer audioSource;
        private Integer channelCount;
        private Integer sampleRate;

        Builder() {
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        AudioSettings autoBuild() {
            String str = "";
            if (this.audioSource == null) {
                str = " audioSource";
            }
            if (this.sampleRate == null) {
                str = str + " sampleRate";
            }
            if (this.channelCount == null) {
                str = str + " channelCount";
            }
            if (this.audioFormat == null) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return new AutoValue_AudioSettings(this.audioSource.intValue(), this.sampleRate.intValue(), this.channelCount.intValue(), this.audioFormat.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        private Builder(AudioSettings audioSettings) {
            this.audioSource = Integer.valueOf(audioSettings.getAudioSource());
            this.sampleRate = Integer.valueOf(audioSettings.getSampleRate());
            this.channelCount = Integer.valueOf(audioSettings.getChannelCount());
            this.audioFormat = Integer.valueOf(audioSettings.getAudioFormat());
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioFormat(int i6) {
            this.audioFormat = Integer.valueOf(i6);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setAudioSource(int i6) {
            this.audioSource = Integer.valueOf(i6);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setChannelCount(int i6) {
            this.channelCount = Integer.valueOf(i6);
            return this;
        }

        @Override // androidx.camera.video.internal.audio.AudioSettings.Builder
        public AudioSettings.Builder setSampleRate(int i6) {
            this.sampleRate = Integer.valueOf(i6);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioSettings) {
            AudioSettings audioSettings = (AudioSettings) obj;
            if (this.audioSource == audioSettings.getAudioSource() && this.sampleRate == audioSettings.getSampleRate() && this.channelCount == audioSettings.getChannelCount() && this.audioFormat == audioSettings.getAudioFormat()) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_AudioSettings(int i6, int i7, int i8, int i9) {
        this.audioSource = i6;
        this.sampleRate = i7;
        this.channelCount = i8;
        this.audioFormat = i9;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioFormat() {
        return this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public int getAudioSource() {
        return this.audioSource;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    @IntRange(from = 1)
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    @IntRange(from = 1)
    public int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return ((((((this.audioSource ^ 1000003) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channelCount) * 1000003) ^ this.audioFormat;
    }

    @Override // androidx.camera.video.internal.audio.AudioSettings
    public AudioSettings.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "AudioSettings{audioSource=" + this.audioSource + ", sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", audioFormat=" + this.audioFormat + "}";
    }
}
