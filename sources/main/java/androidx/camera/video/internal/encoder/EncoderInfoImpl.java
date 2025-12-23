package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.video.internal.workaround.EncoderFinder;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class EncoderInfoImpl implements EncoderInfo {
    protected final MediaCodecInfo.CodecCapabilities mCodecCapabilities;
    private final MediaCodecInfo mMediaCodecInfo;

    @NonNull
    static MediaCodecInfo findCodecAndGetCodecInfo(@NonNull EncoderConfig encoderConfig) throws InvalidConfigException {
        MediaCodec findEncoder = new EncoderFinder().findEncoder(encoderConfig.toMediaFormat());
        MediaCodecInfo codecInfo = findEncoder.getCodecInfo();
        findEncoder.release();
        return codecInfo;
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    @NonNull
    public String getName() {
        return this.mMediaCodecInfo.getName();
    }

    EncoderInfoImpl(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        this.mMediaCodecInfo = mediaCodecInfo;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Objects.requireNonNull(capabilitiesForType);
            this.mCodecCapabilities = capabilitiesForType;
        } catch (RuntimeException e6) {
            throw new InvalidConfigException("Unable to get CodecCapabilities for mime: " + str, e6);
        }
    }
}
