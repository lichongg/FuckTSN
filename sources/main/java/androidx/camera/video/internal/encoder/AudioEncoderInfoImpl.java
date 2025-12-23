package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class AudioEncoderInfoImpl extends EncoderInfoImpl implements AudioEncoderInfo {
    private final MediaCodecInfo.AudioCapabilities mAudioCapabilities;

    @NonNull
    public static AudioEncoderInfoImpl from(@NonNull AudioEncoderConfig audioEncoderConfig) throws InvalidConfigException {
        return new AudioEncoderInfoImpl(EncoderInfoImpl.findCodecAndGetCodecInfo(audioEncoderConfig), audioEncoderConfig.getMimeType());
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderInfo
    @NonNull
    public Range<Integer> getBitrateRange() {
        return this.mAudioCapabilities.getBitrateRange();
    }

    AudioEncoderInfoImpl(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.mCodecCapabilities.getAudioCapabilities();
        Objects.requireNonNull(audioCapabilities);
        this.mAudioCapabilities = audioCapabilities;
    }
}
