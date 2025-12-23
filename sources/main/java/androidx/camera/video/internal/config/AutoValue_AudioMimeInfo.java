package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.AudioMimeInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_AudioMimeInfo extends AudioMimeInfo {
    private final EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile;
    private final String mimeType;
    private final int profile;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class Builder extends AudioMimeInfo.Builder {
        private EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile;
        private String mimeType;
        private Integer profile;

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder, androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo build() {
            String str = "";
            if (this.mimeType == null) {
                str = " mimeType";
            }
            if (this.profile == null) {
                str = str + " profile";
            }
            if (str.isEmpty()) {
                return new AutoValue_AudioMimeInfo(this.mimeType, this.profile.intValue(), this.compatibleAudioProfile);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.video.internal.config.AudioMimeInfo.Builder
        public AudioMimeInfo.Builder setCompatibleAudioProfile(@Nullable EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
            this.compatibleAudioProfile = audioProfileProxy;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo.Builder setMimeType(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.mimeType = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public AudioMimeInfo.Builder setProfile(int i6) {
            this.profile = Integer.valueOf(i6);
            return this;
        }

        Builder() {
        }
    }

    public boolean equals(Object obj) {
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioMimeInfo) {
            AudioMimeInfo audioMimeInfo = (AudioMimeInfo) obj;
            if (this.mimeType.equals(audioMimeInfo.getMimeType()) && this.profile == audioMimeInfo.getProfile() && ((audioProfileProxy = this.compatibleAudioProfile) != null ? audioProfileProxy.equals(audioMimeInfo.getCompatibleAudioProfile()) : audioMimeInfo.getCompatibleAudioProfile() == null)) {
                return true;
            }
        }
        return false;
    }

    private AutoValue_AudioMimeInfo(String str, int i6, @Nullable EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        this.mimeType = str;
        this.profile = i6;
        this.compatibleAudioProfile = audioProfileProxy;
    }

    @Override // androidx.camera.video.internal.config.AudioMimeInfo
    @Nullable
    public EncoderProfilesProxy.AudioProfileProxy getCompatibleAudioProfile() {
        return this.compatibleAudioProfile;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    @NonNull
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public int getProfile() {
        return this.profile;
    }

    public int hashCode() {
        int hashCode = (((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = this.compatibleAudioProfile;
        return hashCode ^ (audioProfileProxy == null ? 0 : audioProfileProxy.hashCode());
    }

    public String toString() {
        return "AudioMimeInfo{mimeType=" + this.mimeType + ", profile=" + this.profile + ", compatibleAudioProfile=" + this.compatibleAudioProfile + "}";
    }
}
