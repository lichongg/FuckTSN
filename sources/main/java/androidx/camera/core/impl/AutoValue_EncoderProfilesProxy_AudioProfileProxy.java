package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.EncoderProfilesProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_EncoderProfilesProxy_AudioProfileProxy extends EncoderProfilesProxy.AudioProfileProxy {
    private final int bitrate;
    private final int channels;
    private final int codec;
    private final String mediaType;
    private final int profile;
    private final int sampleRate;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncoderProfilesProxy.AudioProfileProxy) {
            EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = (EncoderProfilesProxy.AudioProfileProxy) obj;
            if (this.codec == audioProfileProxy.getCodec() && this.mediaType.equals(audioProfileProxy.getMediaType()) && this.bitrate == audioProfileProxy.getBitrate() && this.sampleRate == audioProfileProxy.getSampleRate() && this.channels == audioProfileProxy.getChannels() && this.profile == audioProfileProxy.getProfile()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getChannels() {
        return this.channels;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getCodec() {
        return this.codec;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    @NonNull
    public String getMediaType() {
        return this.mediaType;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProxy.AudioProfileProxy
    public int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return ((((((((((this.codec ^ 1000003) * 1000003) ^ this.mediaType.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channels) * 1000003) ^ this.profile;
    }

    public String toString() {
        return "AudioProfileProxy{codec=" + this.codec + ", mediaType=" + this.mediaType + ", bitrate=" + this.bitrate + ", sampleRate=" + this.sampleRate + ", channels=" + this.channels + ", profile=" + this.profile + "}";
    }

    AutoValue_EncoderProfilesProxy_AudioProfileProxy(int i6, String str, int i7, int i8, int i9, int i10) {
        this.codec = i6;
        if (str != null) {
            this.mediaType = str;
            this.bitrate = i7;
            this.sampleRate = i8;
            this.channels = i9;
            this.profile = i10;
            return;
        }
        throw new NullPointerException("Null mediaType");
    }
}
