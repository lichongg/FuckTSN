package androidx.camera.video.internal.config;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class AudioEncoderConfigDefaultResolver implements Supplier<AudioEncoderConfig> {
    private static final int AUDIO_BITRATE_BASE = 156000;
    private static final int AUDIO_CHANNEL_COUNT_BASE = 2;
    private static final int AUDIO_SAMPLE_RATE_BASE = 48000;
    private static final String TAG = "AudioEncCfgDefaultRslvr";
    private final int mAudioProfile;
    private final AudioSettings mAudioSettings;
    private final AudioSpec mAudioSpec;
    private final Timebase mInputTimeBase;
    private final String mMimeType;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioEncoderConfig get() {
        Range<Integer> bitrate = this.mAudioSpec.getBitrate();
        Logger.d(TAG, "Using fallback AUDIO bitrate");
        return AudioEncoderConfig.builder().setMimeType(this.mMimeType).setProfile(this.mAudioProfile).setInputTimebase(this.mInputTimeBase).setChannelCount(this.mAudioSettings.getChannelCount()).setSampleRate(this.mAudioSettings.getSampleRate()).setBitrate(AudioConfigUtil.scaleAndClampBitrate(AUDIO_BITRATE_BASE, this.mAudioSettings.getChannelCount(), 2, this.mAudioSettings.getSampleRate(), AUDIO_SAMPLE_RATE_BASE, bitrate)).build();
    }

    public AudioEncoderConfigDefaultResolver(@NonNull String str, int i6, @NonNull Timebase timebase, @NonNull AudioSpec audioSpec, @NonNull AudioSettings audioSettings) {
        this.mMimeType = str;
        this.mAudioProfile = i6;
        this.mInputTimeBase = timebase;
        this.mAudioSpec = audioSpec;
        this.mAudioSettings = audioSettings;
    }
}
