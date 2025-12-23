package androidx.camera.video.internal.workaround;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class VideoEncoderInfoWrapper implements VideoEncoderInfo {
    private static final int HEIGHT_4KDCI = 2160;
    private static final String TAG = "VideoEncoderInfoWrapper";
    private static final int WIDTH_4KDCI = 4096;
    private final Set<Size> mExtraSupportedSizes;
    private final Range<Integer> mSupportedHeights;
    private final Range<Integer> mSupportedWidths;
    private final VideoEncoderInfo mVideoEncoderInfo;

    @NonNull
    public static VideoEncoderInfo from(@NonNull VideoEncoderInfo videoEncoderInfo, @Nullable Size size) {
        if (videoEncoderInfo instanceof VideoEncoderInfoWrapper) {
            return videoEncoderInfo;
        }
        if (DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class) == null) {
            if (size == null || videoEncoderInfo.isSizeSupported(size.getWidth(), size.getHeight())) {
                return videoEncoderInfo;
            }
            Logger.w(TAG, String.format("Detected that the device does not support a size %s that should be valid in widths/heights = %s/%s", size, videoEncoderInfo.getSupportedWidths(), videoEncoderInfo.getSupportedHeights()));
        }
        return new VideoEncoderInfoWrapper(videoEncoderInfo, size);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    @NonNull
    public String getName() {
        return this.mVideoEncoderInfo.getName();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoEncoderInfo.getSupportedBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedHeights() {
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedHeightsFor(int i6) {
        Preconditions.checkArgument(this.mSupportedWidths.contains((Range<Integer>) Integer.valueOf(i6)) && i6 % this.mVideoEncoderInfo.getWidthAlignment() == 0, "Not supported width: " + i6 + " which is not in " + this.mSupportedWidths + " or can not be divided by alignment " + this.mVideoEncoderInfo.getWidthAlignment());
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedWidths() {
        return this.mSupportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedWidthsFor(int i6) {
        Preconditions.checkArgument(this.mSupportedHeights.contains((Range<Integer>) Integer.valueOf(i6)) && i6 % this.mVideoEncoderInfo.getHeightAlignment() == 0, "Not supported height: " + i6 + " which is not in " + this.mSupportedHeights + " or can not be divided by alignment " + this.mVideoEncoderInfo.getHeightAlignment());
        return this.mSupportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int i6, int i7) {
        if (this.mExtraSupportedSizes.isEmpty() || !this.mExtraSupportedSizes.contains(new Size(i6, i7))) {
            return this.mSupportedWidths.contains((Range<Integer>) Integer.valueOf(i6)) && this.mSupportedHeights.contains((Range<Integer>) Integer.valueOf(i7)) && i6 % this.mVideoEncoderInfo.getWidthAlignment() == 0 && i7 % this.mVideoEncoderInfo.getHeightAlignment() == 0;
        }
        return true;
    }

    VideoEncoderInfoWrapper(@NonNull VideoEncoderInfo videoEncoderInfo, @Nullable Size size) {
        HashSet hashSet = new HashSet();
        this.mExtraSupportedSizes = hashSet;
        this.mVideoEncoderInfo = videoEncoderInfo;
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        this.mSupportedWidths = Range.create(Integer.valueOf(widthAlignment), Integer.valueOf(((int) Math.ceil(4096.0d / widthAlignment)) * widthAlignment));
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        this.mSupportedHeights = Range.create(Integer.valueOf(heightAlignment), Integer.valueOf(((int) Math.ceil(2160.0d / heightAlignment)) * heightAlignment));
        if (size != null) {
            hashSet.add(size);
        }
        hashSet.addAll(MediaCodecInfoReportIncorrectInfoQuirk.getExtraSupportedSizes());
    }
}
