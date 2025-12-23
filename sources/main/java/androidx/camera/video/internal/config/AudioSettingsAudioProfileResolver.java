package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AudioSettingsAudioProfileResolver implements Supplier<AudioSettings> {
    private static final String TAG = "AudioSrcAdPrflRslvr";
    private final EncoderProfilesProxy.AudioProfileProxy mAudioProfile;
    private final AudioSpec mAudioSpec;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioSettings get() {
        int resolveAudioSource = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int resolveAudioSourceFormat = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int channelCount = this.mAudioSpec.getChannelCount();
        Range<Integer> sampleRate = this.mAudioSpec.getSampleRate();
        int channels = this.mAudioProfile.getChannels();
        if (channelCount == -1) {
            Logger.d(TAG, "Resolved AUDIO channel count from AudioProfile: " + channels);
            channelCount = channels;
        } else {
            Logger.d(TAG, "Media spec AUDIO channel count overrides AudioProfile [AudioProfile channel count: " + channels + ", Resolved Channel Count: " + channelCount + "]");
        }
        int sampleRate2 = this.mAudioProfile.getSampleRate();
        int selectSampleRateOrNearestSupported = AudioConfigUtil.selectSampleRateOrNearestSupported(sampleRate, channelCount, resolveAudioSourceFormat, sampleRate2);
        Logger.d(TAG, "Using resolved AUDIO sample rate or nearest supported from AudioProfile: " + selectSampleRateOrNearestSupported + "Hz. [AudioProfile sample rate: " + sampleRate2 + "Hz]");
        return AudioSettings.builder().setAudioSource(resolveAudioSource).setAudioFormat(resolveAudioSourceFormat).setChannelCount(channelCount).setSampleRate(selectSampleRateOrNearestSupported).build();
    }

    public AudioSettingsAudioProfileResolver(@NonNull AudioSpec audioSpec, @NonNull EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        this.mAudioSpec = audioSpec;
        this.mAudioProfile = audioProfileProxy;
    }
}
