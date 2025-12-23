package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class VideoEncoderInfoImpl extends EncoderInfoImpl implements VideoEncoderInfo {
    private final MediaCodecInfo.VideoCapabilities mVideoCapabilities;

    @NonNull
    public static VideoEncoderInfoImpl from(@NonNull VideoEncoderConfig videoEncoderConfig) throws InvalidConfigException {
        return new VideoEncoderInfoImpl(EncoderInfoImpl.findCodecAndGetCodecInfo(videoEncoderConfig), videoEncoderConfig.getMimeType());
    }

    @NonNull
    private static IllegalArgumentException toIllegalArgumentException(@NonNull Throwable th) {
        return th instanceof IllegalArgumentException ? (IllegalArgumentException) th : new IllegalArgumentException(th);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoCapabilities.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoCapabilities.getBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedHeights() {
        return this.mVideoCapabilities.getSupportedHeights();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedHeightsFor(int i6) {
        try {
            return this.mVideoCapabilities.getSupportedHeightsFor(i6);
        } catch (Throwable th) {
            throw toIllegalArgumentException(th);
        }
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedWidths() {
        return this.mVideoCapabilities.getSupportedWidths();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedWidthsFor(int i6) {
        try {
            return this.mVideoCapabilities.getSupportedWidthsFor(i6);
        } catch (Throwable th) {
            throw toIllegalArgumentException(th);
        }
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoCapabilities.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int i6, int i7) {
        return this.mVideoCapabilities.isSizeSupported(i6, i7);
    }

    VideoEncoderInfoImpl(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.mCodecCapabilities.getVideoCapabilities();
        Objects.requireNonNull(videoCapabilities);
        this.mVideoCapabilities = videoCapabilities;
    }
}
