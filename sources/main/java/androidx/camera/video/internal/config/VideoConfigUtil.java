package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoMimeInfo;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderDataSpace;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class VideoConfigUtil {
    private static final Map<String, Map<Integer, VideoEncoderDataSpace>> MIME_TO_DATA_SPACE_MAP;
    private static final String TAG = "VideoConfigUtil";

    static {
        HashMap hashMap = new HashMap();
        MIME_TO_DATA_SPACE_MAP = hashMap;
        HashMap hashMap2 = new HashMap();
        VideoEncoderDataSpace videoEncoderDataSpace = VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
        hashMap2.put(1, videoEncoderDataSpace);
        VideoEncoderDataSpace videoEncoderDataSpace2 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG;
        hashMap2.put(2, videoEncoderDataSpace2);
        VideoEncoderDataSpace videoEncoderDataSpace3 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ;
        hashMap2.put(4096, videoEncoderDataSpace3);
        hashMap2.put(8192, videoEncoderDataSpace3);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(1, videoEncoderDataSpace);
        hashMap3.put(2, videoEncoderDataSpace2);
        hashMap3.put(4096, videoEncoderDataSpace3);
        hashMap3.put(8192, videoEncoderDataSpace3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(1, videoEncoderDataSpace);
        hashMap4.put(4, videoEncoderDataSpace2);
        hashMap4.put(4096, videoEncoderDataSpace3);
        hashMap4.put(16384, videoEncoderDataSpace3);
        hashMap4.put(2, videoEncoderDataSpace);
        hashMap4.put(8, videoEncoderDataSpace2);
        hashMap4.put(8192, videoEncoderDataSpace3);
        hashMap4.put(32768, videoEncoderDataSpace3);
        HashMap hashMap5 = new HashMap();
        hashMap5.put(256, videoEncoderDataSpace2);
        hashMap5.put(512, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT709);
        hashMap.put("video/hevc", hashMap2);
        hashMap.put("video/av01", hashMap3);
        hashMap.put("video/x-vnd.on2.vp9", hashMap4);
        hashMap.put("video/dolby-vision", hashMap5);
    }

    @NonNull
    public static VideoEncoderDataSpace mimeAndProfileToEncoderDataSpace(@NonNull String str, int i6) {
        VideoEncoderDataSpace videoEncoderDataSpace;
        Map<Integer, VideoEncoderDataSpace> map = MIME_TO_DATA_SPACE_MAP.get(str);
        if (map != null && (videoEncoderDataSpace = map.get(Integer.valueOf(i6))) != null) {
            return videoEncoderDataSpace;
        }
        Logger.w(TAG, String.format("Unsupported mime type %s or profile level %d. Data space is unspecified.", str, Integer.valueOf(i6)));
        return VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
    }

    static int scaleAndClampBitrate(int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, @NonNull Range<Integer> range) {
        char c6;
        String str;
        int doubleValue = (int) (i6 * new Rational(i7, i8).doubleValue() * new Rational(i9, i10).doubleValue() * new Rational(i11, i12).doubleValue() * new Rational(i13, i14).doubleValue());
        if (Logger.isDebugEnabled(TAG)) {
            c6 = 1;
            str = String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(doubleValue));
        } else {
            c6 = 1;
            str = "";
        }
        if (!VideoSpec.BITRATE_RANGE_AUTO.equals(range)) {
            Integer clamp = range.clamp(Integer.valueOf(doubleValue));
            int intValue = clamp.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                Object[] objArr = new Object[2];
                objArr[0] = range;
                objArr[c6] = clamp;
                sb.append(String.format("\nClamped to range %s -> %dbps", objArr));
                str = sb.toString();
            }
            doubleValue = intValue;
        }
        Logger.d(TAG, str);
        return doubleValue;
    }

    private VideoConfigUtil() {
    }

    @NonNull
    private static String getDynamicRangeDefaultMime(@NonNull DynamicRange dynamicRange) {
        int encoding = dynamicRange.getEncoding();
        if (encoding != 1) {
            if (encoding != 3 && encoding != 4 && encoding != 5) {
                if (encoding == 6) {
                    return "video/dolby-vision";
                }
                throw new UnsupportedOperationException("Unsupported dynamic range: " + dynamicRange + "\nNo supported default mime type available.");
            }
            return "video/hevc";
        }
        return "video/avc";
    }

    @NonNull
    public static VideoEncoderConfig resolveVideoEncoderConfig(@NonNull VideoMimeInfo videoMimeInfo, @NonNull Timebase timebase, @NonNull VideoSpec videoSpec, @NonNull Size size, @NonNull DynamicRange dynamicRange, @NonNull Range<Integer> range) {
        Supplier videoEncoderConfigDefaultResolver;
        EncoderProfilesProxy.VideoProfileProxy compatibleVideoProfile = videoMimeInfo.getCompatibleVideoProfile();
        if (compatibleVideoProfile != null) {
            videoEncoderConfigDefaultResolver = new VideoEncoderConfigVideoProfileResolver(videoMimeInfo.getMimeType(), timebase, videoSpec, size, compatibleVideoProfile, dynamicRange, range);
        } else {
            videoEncoderConfigDefaultResolver = new VideoEncoderConfigDefaultResolver(videoMimeInfo.getMimeType(), timebase, videoSpec, size, dynamicRange, range);
        }
        return (VideoEncoderConfig) videoEncoderConfigDefaultResolver.get();
    }

    @NonNull
    public static VideoMimeInfo resolveVideoMimeInfo(@NonNull MediaSpec mediaSpec, @NonNull DynamicRange dynamicRange, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        Preconditions.checkState(dynamicRange.isFullySpecified(), "Dynamic range must be a fully specified dynamic range [provided dynamic range: " + dynamicRange + "]");
        String outputFormatToVideoMime = MediaSpec.outputFormatToVideoMime(mediaSpec.getOutputFormat());
        if (videoValidatedEncoderProfilesProxy != null) {
            Set<Integer> dynamicRangeToVideoProfileHdrFormats = DynamicRangeUtil.dynamicRangeToVideoProfileHdrFormats(dynamicRange);
            Set<Integer> dynamicRangeToVideoProfileBitDepth = DynamicRangeUtil.dynamicRangeToVideoProfileBitDepth(dynamicRange);
            Iterator<EncoderProfilesProxy.VideoProfileProxy> it = videoValidatedEncoderProfilesProxy.getVideoProfiles().iterator();
            while (it.hasNext()) {
                videoProfileProxy = it.next();
                if (dynamicRangeToVideoProfileHdrFormats.contains(Integer.valueOf(videoProfileProxy.getHdrFormat())) && dynamicRangeToVideoProfileBitDepth.contains(Integer.valueOf(videoProfileProxy.getBitDepth()))) {
                    String mediaType = videoProfileProxy.getMediaType();
                    if (Objects.equals(outputFormatToVideoMime, mediaType)) {
                        Logger.d(TAG, "MediaSpec video mime matches EncoderProfiles. Using EncoderProfiles to derive VIDEO settings [mime type: " + outputFormatToVideoMime + "]");
                    } else if (mediaSpec.getOutputFormat() == -1) {
                        Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + outputFormatToVideoMime + ", dynamic range: " + dynamicRange + "]");
                    }
                    outputFormatToVideoMime = mediaType;
                    break;
                }
            }
        }
        videoProfileProxy = null;
        if (videoProfileProxy == null) {
            if (mediaSpec.getOutputFormat() == -1) {
                outputFormatToVideoMime = getDynamicRangeDefaultMime(dynamicRange);
            }
            if (videoValidatedEncoderProfilesProxy == null) {
                Logger.d(TAG, "No EncoderProfiles present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + outputFormatToVideoMime + ", dynamic range: " + dynamicRange + "]");
            } else {
                Logger.d(TAG, "No video EncoderProfile is compatible with requested output format and dynamic range. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + outputFormatToVideoMime + ", dynamic range: " + dynamicRange + "]");
            }
        }
        VideoMimeInfo.Builder builder = VideoMimeInfo.builder(outputFormatToVideoMime);
        if (videoProfileProxy != null) {
            builder.setCompatibleVideoProfile(videoProfileProxy);
        }
        return builder.build();
    }
}
