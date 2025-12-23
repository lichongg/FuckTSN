package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.EncoderProfilesProxy;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy extends EncoderProfilesProxy.ImmutableEncoderProfilesProxy {
    private final List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles;
    private final int defaultDurationSeconds;
    private final int recommendedFileFormat;
    private final List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncoderProfilesProxy.ImmutableEncoderProfilesProxy) {
            EncoderProfilesProxy.ImmutableEncoderProfilesProxy immutableEncoderProfilesProxy = (EncoderProfilesProxy.ImmutableEncoderProfilesProxy) obj;
            if (this.defaultDurationSeconds == immutableEncoderProfilesProxy.getDefaultDurationSeconds() && this.recommendedFileFormat == immutableEncoderProfilesProxy.getRecommendedFileFormat() && this.audioProfiles.equals(immutableEncoderProfilesProxy.getAudioProfiles()) && this.videoProfiles.equals(immutableEncoderProfilesProxy.getVideoProfiles())) {
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

    @Override // androidx.camera.core.impl.EncoderProfilesProxy
    public int getDefaultDurationSeconds() {
        return this.defaultDurationSeconds;
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
        return ((((((this.defaultDurationSeconds ^ 1000003) * 1000003) ^ this.recommendedFileFormat) * 1000003) ^ this.audioProfiles.hashCode()) * 1000003) ^ this.videoProfiles.hashCode();
    }

    public String toString() {
        return "ImmutableEncoderProfilesProxy{defaultDurationSeconds=" + this.defaultDurationSeconds + ", recommendedFileFormat=" + this.recommendedFileFormat + ", audioProfiles=" + this.audioProfiles + ", videoProfiles=" + this.videoProfiles + "}";
    }

    AutoValue_EncoderProfilesProxy_ImmutableEncoderProfilesProxy(int i6, int i7, List<EncoderProfilesProxy.AudioProfileProxy> list, List<EncoderProfilesProxy.VideoProfileProxy> list2) {
        this.defaultDurationSeconds = i6;
        this.recommendedFileFormat = i7;
        if (list != null) {
            this.audioProfiles = list;
            if (list2 != null) {
                this.videoProfiles = list2;
                return;
            }
            throw new NullPointerException("Null videoProfiles");
        }
        throw new NullPointerException("Null audioProfiles");
    }
}
