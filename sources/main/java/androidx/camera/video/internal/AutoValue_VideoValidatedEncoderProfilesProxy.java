package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_VideoValidatedEncoderProfilesProxy extends VideoValidatedEncoderProfilesProxy {
    private final List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles;
    private final EncoderProfilesProxy.AudioProfileProxy defaultAudioProfile;
    private final int defaultDurationSeconds;
    private final EncoderProfilesProxy.VideoProfileProxy defaultVideoProfile;
    private final int recommendedFileFormat;
    private final List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;

    public boolean equals(Object obj) {
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy;
        if (obj == this) {
            return true;
        }
        if (obj instanceof VideoValidatedEncoderProfilesProxy) {
            VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy = (VideoValidatedEncoderProfilesProxy) obj;
            if (this.defaultDurationSeconds == videoValidatedEncoderProfilesProxy.getDefaultDurationSeconds() && this.recommendedFileFormat == videoValidatedEncoderProfilesProxy.getRecommendedFileFormat() && this.audioProfiles.equals(videoValidatedEncoderProfilesProxy.getAudioProfiles()) && this.videoProfiles.equals(videoValidatedEncoderProfilesProxy.getVideoProfiles()) && ((audioProfileProxy = this.defaultAudioProfile) != null ? audioProfileProxy.equals(videoValidatedEncoderProfilesProxy.getDefaultAudioProfile()) : videoValidatedEncoderProfilesProxy.getDefaultAudioProfile() == null) && this.defaultVideoProfile.equals(videoValidatedEncoderProfilesProxy.getDefaultVideoProfile())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    @NonNull
    public List<EncoderProfilesProxy.AudioProfileProxy> getAudioProfiles() {
        return this.audioProfiles;
    }

    @Override // androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy
    @Nullable
    public EncoderProfilesProxy.AudioProfileProxy getDefaultAudioProfile() {
        return this.defaultAudioProfile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getDefaultDurationSeconds() {
        return this.defaultDurationSeconds;
    }

    @Override // androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy
    @NonNull
    public EncoderProfilesProxy.VideoProfileProxy getDefaultVideoProfile() {
        return this.defaultVideoProfile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getRecommendedFileFormat() {
        return this.recommendedFileFormat;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    @NonNull
    public List<EncoderProfilesProxy.VideoProfileProxy> getVideoProfiles() {
        return this.videoProfiles;
    }

    public int hashCode() {
        int hashCode = (((((((this.defaultDurationSeconds ^ 1000003) * 1000003) ^ this.recommendedFileFormat) * 1000003) ^ this.audioProfiles.hashCode()) * 1000003) ^ this.videoProfiles.hashCode()) * 1000003;
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = this.defaultAudioProfile;
        return ((hashCode ^ (audioProfileProxy == null ? 0 : audioProfileProxy.hashCode())) * 1000003) ^ this.defaultVideoProfile.hashCode();
    }

    public String toString() {
        return "VideoValidatedEncoderProfilesProxy{defaultDurationSeconds=" + this.defaultDurationSeconds + ", recommendedFileFormat=" + this.recommendedFileFormat + ", audioProfiles=" + this.audioProfiles + ", videoProfiles=" + this.videoProfiles + ", defaultAudioProfile=" + this.defaultAudioProfile + ", defaultVideoProfile=" + this.defaultVideoProfile + "}";
    }

    AutoValue_VideoValidatedEncoderProfilesProxy(int i6, int i7, List<EncoderProfilesProxy.AudioProfileProxy> list, List<EncoderProfilesProxy.VideoProfileProxy> list2, @Nullable EncoderProfilesProxy.AudioProfileProxy audioProfileProxy, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        this.defaultDurationSeconds = i6;
        this.recommendedFileFormat = i7;
        if (list != null) {
            this.audioProfiles = list;
            if (list2 != null) {
                this.videoProfiles = list2;
                this.defaultAudioProfile = audioProfileProxy;
                if (videoProfileProxy != null) {
                    this.defaultVideoProfile = videoProfileProxy;
                    return;
                }
                throw new NullPointerException("Null defaultVideoProfile");
            }
            throw new NullPointerException("Null videoProfiles");
        }
        throw new NullPointerException("Null audioProfiles");
    }
}
