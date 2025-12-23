package androidx.camera.video.internal.workaround;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.compat.quirk.MediaFormatMustNotUseFrameRateToFindEncoderQuirk;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.core.util.Preconditions;
import com.snail.antifake.deviceid.e;
import java.io.IOException;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class EncoderFinder {
    private static final String TAG = "EncoderFinder";
    private final boolean mShouldRemoveKeyFrameRate;

    @Nullable
    private String findEncoderWithNearestCompatibleBitrate(@NonNull MediaFormat mediaFormat, @NonNull MediaCodecInfo[] mediaCodecInfoArr) {
        int i6;
        Integer num;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        int i7;
        String string = mediaFormat.getString(IMediaFormat.KEY_MIME);
        Integer num2 = null;
        if (string == null) {
            Logger.w(TAG, "MediaFormat does not contain mime info.");
            return null;
        }
        int length = mediaCodecInfoArr.length;
        while (i6 < length) {
            MediaCodecInfo mediaCodecInfo = mediaCodecInfoArr[i6];
            if (mediaCodecInfo.isEncoder()) {
                try {
                    capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    Preconditions.checkArgument(capabilitiesForType != null, "MIME type is not supported");
                    if (mediaFormat.containsKey("bitrate")) {
                        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                        Preconditions.checkArgument(videoCapabilities != null, "Not video codec");
                        num = Integer.valueOf(mediaFormat.getInteger("bitrate"));
                        try {
                            i7 = videoCapabilities.getBitrateRange().clamp(num).intValue();
                            mediaFormat.setInteger("bitrate", i7);
                        } catch (IllegalArgumentException unused) {
                            i6 = num == null ? i6 + 1 : 0;
                            mediaFormat.setInteger("bitrate", num.intValue());
                        } catch (Throwable th) {
                            th = th;
                            num2 = num;
                            if (num2 != null) {
                                mediaFormat.setInteger("bitrate", num2.intValue());
                            }
                            throw th;
                        }
                    } else {
                        i7 = -1;
                        num = null;
                    }
                } catch (IllegalArgumentException unused2) {
                    num = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (capabilitiesForType.isFormatSupported(mediaFormat)) {
                    Logger.w(TAG, String.format("No encoder found that supports requested bitrate. Adjusting bitrate to nearest supported bitrate [requested: %dbps, nearest: %dbps]", num, Integer.valueOf(i7)));
                    String name = mediaCodecInfo.getName();
                    if (num != null) {
                        mediaFormat.setInteger("bitrate", num.intValue());
                    }
                    return name;
                }
                if (num == null) {
                }
                mediaFormat.setInteger("bitrate", num.intValue());
            }
        }
        return null;
    }

    private boolean shouldCreateCodecByType(@NonNull MediaFormat mediaFormat) {
        MediaCodecInfoReportIncorrectInfoQuirk mediaCodecInfoReportIncorrectInfoQuirk = (MediaCodecInfoReportIncorrectInfoQuirk) DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class);
        if (mediaCodecInfoReportIncorrectInfoQuirk == null) {
            return false;
        }
        return mediaCodecInfoReportIncorrectInfoQuirk.isUnSupportMediaCodecInfo(mediaFormat);
    }

    @NonNull
    public MediaCodec findEncoder(@NonNull MediaFormat mediaFormat) throws InvalidConfigException {
        MediaCodecList mediaCodecList = new MediaCodecList(1);
        String findEncoderForFormat = findEncoderForFormat(mediaFormat, mediaCodecList);
        try {
            if (!TextUtils.isEmpty(findEncoderForFormat)) {
                return MediaCodec.createByCodecName(findEncoderForFormat);
            }
            String string = mediaFormat.getString(IMediaFormat.KEY_MIME);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(string);
            Logger.w(TAG, String.format("No encoder found that supports requested MediaFormat %s. Create encoder by MIME type. Dump codec info:\n%s", mediaFormat, DebugUtils.dumpCodecCapabilities(string, createEncoderByType, mediaFormat)));
            return createEncoderByType;
        } catch (IOException e6) {
            e = e6;
            throw new InvalidConfigException("Encoder cannot created: " + findEncoderForFormat + ", isMediaFormatInQuirk: " + shouldCreateCodecByType(mediaFormat) + e.f37542d + DebugUtils.dumpMediaCodecListForFormat(mediaCodecList, mediaFormat), e);
        } catch (IllegalArgumentException e7) {
            e = e7;
            throw new InvalidConfigException("Encoder cannot created: " + findEncoderForFormat + ", isMediaFormatInQuirk: " + shouldCreateCodecByType(mediaFormat) + e.f37542d + DebugUtils.dumpMediaCodecListForFormat(mediaCodecList, mediaFormat), e);
        } catch (NullPointerException e8) {
            e = e8;
            throw new InvalidConfigException("Encoder cannot created: " + findEncoderForFormat + ", isMediaFormatInQuirk: " + shouldCreateCodecByType(mediaFormat) + e.f37542d + DebugUtils.dumpMediaCodecListForFormat(mediaCodecList, mediaFormat), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String findEncoderForFormat(@androidx.annotation.NonNull android.media.MediaFormat r7, @androidx.annotation.NonNull android.media.MediaCodecList r8) {
        /*
            r6 = this;
            java.lang.String r0 = "aac-profile"
            java.lang.String r1 = "frame-rate"
            r2 = 0
            boolean r3 = r6.mShouldRemoveKeyFrameRate     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L22
            boolean r3 = r7.containsKey(r1)     // Catch: java.lang.Throwable -> L1f
            if (r3 == 0) goto L22
            int r3 = r7.getInteger(r1)     // Catch: java.lang.Throwable -> L1f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L1f
            r7.setString(r1, r2)     // Catch: java.lang.Throwable -> L1b
            goto L23
        L1b:
            r8 = move-exception
            r4 = r2
        L1d:
            r2 = r3
            goto L5f
        L1f:
            r8 = move-exception
            r4 = r2
            goto L5f
        L22:
            r3 = r2
        L23:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1b
            r5 = 23
            if (r4 > r5) goto L3e
            boolean r4 = r7.containsKey(r0)     // Catch: java.lang.Throwable -> L1b
            if (r4 == 0) goto L3e
            int r4 = r7.getInteger(r0)     // Catch: java.lang.Throwable -> L1b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L1b
            r7.setString(r0, r2)     // Catch: java.lang.Throwable -> L3c
            r2 = r4
            goto L3e
        L3c:
            r8 = move-exception
            goto L1d
        L3e:
            java.lang.String r4 = r8.findEncoderForFormat(r7)     // Catch: java.lang.Throwable -> L1b
            if (r4 != 0) goto L4c
            android.media.MediaCodecInfo[] r8 = r8.getCodecInfos()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = r6.findEncoderWithNearestCompatibleBitrate(r7, r8)     // Catch: java.lang.Throwable -> L1b
        L4c:
            if (r3 == 0) goto L55
            int r8 = r3.intValue()
            r7.setInteger(r1, r8)
        L55:
            if (r2 == 0) goto L5e
            int r8 = r2.intValue()
            r7.setInteger(r0, r8)
        L5e:
            return r4
        L5f:
            if (r2 == 0) goto L68
            int r2 = r2.intValue()
            r7.setInteger(r1, r2)
        L68:
            if (r4 == 0) goto L71
            int r1 = r4.intValue()
            r7.setInteger(r0, r1)
        L71:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.workaround.EncoderFinder.findEncoderForFormat(android.media.MediaFormat, android.media.MediaCodecList):java.lang.String");
    }

    public EncoderFinder() {
        boolean z5;
        if (((MediaFormatMustNotUseFrameRateToFindEncoderQuirk) DeviceQuirks.get(MediaFormatMustNotUseFrameRateToFindEncoderQuirk.class)) != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mShouldRemoveKeyFrameRate = z5;
    }
}
