package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.core.util.Supplier;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class VideoEncoderConfigDefaultResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncCfgDefaultRslvr";
    private static final int VIDEO_BITRATE_BASE = 14000000;
    private static final int VIDEO_BIT_DEPTH_BASE = 8;
    private static final int VIDEO_FRAME_RATE_BASE = 30;
    static final int VIDEO_FRAME_RATE_FIXED_DEFAULT = 30;
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final VideoSpec mVideoSpec;
    private static final Size VIDEO_SIZE_BASE = new Size(PredefinedCaptureConfigurations.f35648o, PredefinedCaptureConfigurations.f35647n);
    private static final Range<Integer> VALID_FRAME_RATE_RANGE = new Range<>(1, 60);

    private int resolveFrameRate() {
        Range<Integer> range = this.mExpectedFrameRateRange;
        Range<Integer> range2 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        int intValue = !Objects.equals(range, range2) ? VALID_FRAME_RATE_RANGE.clamp(this.mExpectedFrameRateRange.getUpper()).intValue() : 30;
        Logger.d(TAG, String.format("Default resolved frame rate: %dfps. [Expected operating range: %s]", Integer.valueOf(intValue), Objects.equals(this.mExpectedFrameRateRange, range2) ? this.mExpectedFrameRateRange : "<UNSPECIFIED>"));
        return intValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public VideoEncoderConfig get() {
        int resolveFrameRate = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + resolveFrameRate + "fps");
        Range<Integer> bitrate = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using fallback VIDEO bitrate");
        int bitDepth = this.mDynamicRange.getBitDepth();
        int width = this.mSurfaceSize.getWidth();
        Size size = VIDEO_SIZE_BASE;
        int scaleAndClampBitrate = VideoConfigUtil.scaleAndClampBitrate(VIDEO_BITRATE_BASE, bitDepth, 8, resolveFrameRate, 30, width, size.getWidth(), this.mSurfaceSize.getHeight(), size.getHeight(), bitrate);
        int dynamicRangeToCodecProfileLevelForMime = DynamicRangeUtil.dynamicRangeToCodecProfileLevelForMime(this.mMimeType, this.mDynamicRange);
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(scaleAndClampBitrate).setFrameRate(resolveFrameRate).setProfile(dynamicRangeToCodecProfileLevelForMime).setDataSpace(VideoConfigUtil.mimeAndProfileToEncoderDataSpace(this.mMimeType, dynamicRangeToCodecProfileLevelForMime)).build();
    }

    public VideoEncoderConfigDefaultResolver(@NonNull String str, @NonNull Timebase timebase, @NonNull VideoSpec videoSpec, @NonNull Size size, @NonNull DynamicRange dynamicRange, @NonNull Range<Integer> range) {
        this.mMimeType = str;
        this.mInputTimebase = timebase;
        this.mVideoSpec = videoSpec;
        this.mSurfaceSize = size;
        this.mDynamicRange = dynamicRange;
        this.mExpectedFrameRateRange = range;
    }
}
