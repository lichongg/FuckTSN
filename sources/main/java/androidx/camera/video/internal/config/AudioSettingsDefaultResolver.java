package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AudioSettingsDefaultResolver implements Supplier<AudioSettings> {
    private static final String TAG = "DefAudioResolver";
    private final AudioSpec mAudioSpec;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioSettings get() {
        int selectSampleRateOrNearestSupported;
        int resolveAudioSource = AudioConfigUtil.resolveAudioSource(this.mAudioSpec);
        int resolveAudioSourceFormat = AudioConfigUtil.resolveAudioSourceFormat(this.mAudioSpec);
        int channelCount = this.mAudioSpec.getChannelCount();
        if (channelCount == -1) {
            Logger.d(TAG, "Using fallback AUDIO channel count: 1");
            channelCount = 1;
        } else {
            Logger.d(TAG, "Using supplied AUDIO channel count: " + channelCount);
        }
        Range<Integer> sampleRate = this.mAudioSpec.getSampleRate();
        if (AudioSpec.SAMPLE_RATE_RANGE_AUTO.equals(sampleRate)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Using fallback AUDIO sample rate: ");
            selectSampleRateOrNearestSupported = 44100;
            sb.append(44100);
            sb.append("Hz");
            Logger.d(TAG, sb.toString());
        } else {
            selectSampleRateOrNearestSupported = AudioConfigUtil.selectSampleRateOrNearestSupported(sampleRate, channelCount, resolveAudioSourceFormat, sampleRate.getUpper().intValue());
            Logger.d(TAG, "Using AUDIO sample rate resolved from AudioSpec: " + selectSampleRateOrNearestSupported + "Hz");
        }
        return AudioSettings.builder().setAudioSource(resolveAudioSource).setAudioFormat(resolveAudioSourceFormat).setChannelCount(channelCount).setSampleRate(selectSampleRateOrNearestSupported).build();
    }

    public AudioSettingsDefaultResolver(@NonNull AudioSpec audioSpec) {
        this.mAudioSpec = audioSpec;
    }
}
