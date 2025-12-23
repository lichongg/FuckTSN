package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AudioEncoderConfigAudioProfileResolver implements Supplier<AudioEncoderConfig> {
    private static final String TAG = "AudioEncAdPrflRslvr";
    private final int mAudioProfile;
    private final EncoderProfilesProxy.AudioProfileProxy mAudioProfileProxy;
    private final AudioSettings mAudioSettings;
    private final AudioSpec mAudioSpec;
    private final Timebase mInputTimebase;
    private final String mMimeType;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioEncoderConfig get() {
        Logger.d(TAG, "Using resolved AUDIO bitrate from AudioProfile");
        return AudioEncoderConfig.builder().setMimeType(this.mMimeType).setProfile(this.mAudioProfile).setInputTimebase(this.mInputTimebase).setChannelCount(this.mAudioSettings.getChannelCount()).setSampleRate(this.mAudioSettings.getSampleRate()).setBitrate(AudioConfigUtil.scaleAndClampBitrate(this.mAudioProfileProxy.getBitrate(), this.mAudioSettings.getChannelCount(), this.mAudioProfileProxy.getChannels(), this.mAudioSettings.getSampleRate(), this.mAudioProfileProxy.getSampleRate(), this.mAudioSpec.getBitrate())).build();
    }

    public AudioEncoderConfigAudioProfileResolver(@NonNull String str, int i6, @NonNull Timebase timebase, @NonNull AudioSpec audioSpec, @NonNull AudioSettings audioSettings, @NonNull EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        this.mMimeType = str;
        this.mAudioProfile = i6;
        this.mInputTimebase = timebase;
        this.mAudioSpec = audioSpec;
        this.mAudioSettings = audioSettings;
        this.mAudioProfileProxy = audioProfileProxy;
    }
}
