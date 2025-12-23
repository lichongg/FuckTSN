package androidx.camera.video.internal;

import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.x;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class BackupHdrProfileEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "BackupHdrProfileEncoderProfilesProvider";
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache = new HashMap();
    private final EncoderProfilesProvider mEncoderProfilesProvider;
    private final Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> mVideoProfileValidator;
    public static final Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> DEFAULT_VALIDATOR = new Function() { // from class: androidx.camera.video.internal.a
        @Override // androidx.arch.core.util.Function
        public final Object apply(Object obj) {
            EncoderProfilesProxy.VideoProfileProxy validateOrAdapt;
            validateOrAdapt = BackupHdrProfileEncoderProfilesProvider.validateOrAdapt((EncoderProfilesProxy.VideoProfileProxy) obj);
            return validateOrAdapt;
        }
    };
    private static final Timebase DEFAULT_TIME_BASE = Timebase.UPTIME;

    @Nullable
    private EncoderProfilesProxy appendBackupVideoProfile(@Nullable EncoderProfilesProxy encoderProfilesProxy, int i6, int i7) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        if (encoderProfilesProxy == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(encoderProfilesProxy.getVideoProfiles());
        Iterator<EncoderProfilesProxy.VideoProfileProxy> it = encoderProfilesProxy.getVideoProfiles().iterator();
        while (true) {
            if (!it.hasNext()) {
                videoProfileProxy = null;
                break;
            }
            videoProfileProxy = it.next();
            if (videoProfileProxy.getHdrFormat() == 0) {
                break;
            }
        }
        EncoderProfilesProxy.VideoProfileProxy apply = this.mVideoProfileValidator.apply(generateBackupProfile(videoProfileProxy, i6, i7));
        if (apply != null) {
            arrayList.add(apply);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    private static int deriveProfile(int i6) {
        if (i6 == 0) {
            return 1;
        }
        if (i6 == 1) {
            return 2;
        }
        if (i6 == 2) {
            return 4096;
        }
        if (i6 == 3) {
            return 8192;
        }
        if (i6 == 4) {
            return -1;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static EncoderProfilesProxy.VideoProfileProxy validateOrAdapt(@Nullable EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        if (videoProfileProxy == null) {
            return null;
        }
        VideoEncoderConfig videoEncoderConfig = toVideoEncoderConfig(videoProfileProxy);
        try {
            VideoEncoderInfoImpl from = VideoEncoderInfoImpl.from(videoEncoderConfig);
            int bitrate = videoEncoderConfig.getBitrate();
            int intValue = from.getSupportedBitrateRange().clamp(Integer.valueOf(bitrate)).intValue();
            return intValue == bitrate ? videoProfileProxy : modifyBitrate(videoProfileProxy, intValue);
        } catch (InvalidConfigException unused) {
            return null;
        }
    }

    private static int deriveCodec(int i6) {
        if (i6 == 0 || i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4) {
            return 5;
        }
        throw new IllegalArgumentException("Unexpected HDR format: " + i6);
    }

    @Nullable
    private static EncoderProfilesProxy.VideoProfileProxy generateBackupProfile(@Nullable EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i6, int i7) {
        if (videoProfileProxy == null) {
            return null;
        }
        int codec = videoProfileProxy.getCodec();
        String mediaType = videoProfileProxy.getMediaType();
        int profile = videoProfileProxy.getProfile();
        if (i6 != videoProfileProxy.getHdrFormat()) {
            codec = deriveCodec(i6);
            mediaType = deriveMediaType(codec);
            profile = deriveProfile(i6);
        }
        return EncoderProfilesProxy.VideoProfileProxy.create(codec, mediaType, scaleBitrate(videoProfileProxy.getBitrate(), i7, videoProfileProxy.getBitDepth()), videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), profile, i7, videoProfileProxy.getChromaSubsampling(), i6);
    }

    @Nullable
    private EncoderProfilesProxy getProfilesInternal(int i6) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(i6))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(i6));
        }
        if (!this.mEncoderProfilesProvider.hasProfile(i6)) {
            return null;
        }
        EncoderProfilesProxy appendBackupVideoProfile = appendBackupVideoProfile(this.mEncoderProfilesProvider.getAll(i6), 1, 10);
        this.mEncoderProfilesCache.put(Integer.valueOf(i6), appendBackupVideoProfile);
        return appendBackupVideoProfile;
    }

    private static int scaleBitrate(int i6, int i7, int i8) {
        if (i7 == i8) {
            return i6;
        }
        int doubleValue = (int) (i6 * new Rational(i7, i8).doubleValue());
        if (Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) = %d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(doubleValue)));
        }
        return doubleValue;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i6) {
        return this.mEncoderProfilesProvider.hasProfile(i6) && getProfilesInternal(i6) != null;
    }

    public BackupHdrProfileEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull Function<EncoderProfilesProxy.VideoProfileProxy, EncoderProfilesProxy.VideoProfileProxy> function) {
        this.mEncoderProfilesProvider = encoderProfilesProvider;
        this.mVideoProfileValidator = function;
    }

    @NonNull
    private static String deriveMediaType(int i6) {
        return x.c(i6);
    }

    @NonNull
    private static EncoderProfilesProxy.VideoProfileProxy modifyBitrate(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i6) {
        return EncoderProfilesProxy.VideoProfileProxy.create(videoProfileProxy.getCodec(), videoProfileProxy.getMediaType(), i6, videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), videoProfileProxy.getProfile(), videoProfileProxy.getBitDepth(), videoProfileProxy.getChromaSubsampling(), videoProfileProxy.getHdrFormat());
    }

    @NonNull
    @VisibleForTesting
    static VideoEncoderConfig toVideoEncoderConfig(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        return VideoEncoderConfig.builder().setMimeType(videoProfileProxy.getMediaType()).setProfile(videoProfileProxy.getProfile()).setResolution(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight())).setFrameRate(videoProfileProxy.getFrameRate()).setBitrate(videoProfileProxy.getBitrate()).setInputTimebase(DEFAULT_TIME_BASE).build();
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i6) {
        return getProfilesInternal(i6);
    }
}
