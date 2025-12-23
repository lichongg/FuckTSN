package androidx.camera.video.internal.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.Quality;
import androidx.camera.video.internal.compat.quirk.VideoQualityQuirk;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class QualityValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final Map<Integer, Quality> CAMCORDER_TO_VIDEO_QUALITY_MAP;

    @NonNull
    private final CameraInfoInternal mCameraInfo;

    @NonNull
    private final EncoderProfilesProvider mProvider;

    @NonNull
    private final Quirks mQuirks;

    static {
        HashMap hashMap = new HashMap();
        CAMCORDER_TO_VIDEO_QUALITY_MAP = hashMap;
        hashMap.put(1, Quality.HIGHEST);
        hashMap.put(8, Quality.UHD);
        hashMap.put(6, Quality.FHD);
        hashMap.put(5, Quality.HD);
        hashMap.put(4, Quality.SD);
        hashMap.put(0, Quality.LOWEST);
    }

    private boolean isDeviceValidQuality(int i6) {
        Quality quality = CAMCORDER_TO_VIDEO_QUALITY_MAP.get(Integer.valueOf(i6));
        if (quality == null) {
            return true;
        }
        for (VideoQualityQuirk videoQualityQuirk : this.mQuirks.getAll(VideoQualityQuirk.class)) {
            if (videoQualityQuirk != null && videoQualityQuirk.isProblematicVideoQuality(this.mCameraInfo, quality) && !videoQualityQuirk.workaroundBySurfaceProcessing()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i6) {
        return this.mProvider.hasProfile(i6) && isDeviceValidQuality(i6);
    }

    public QualityValidatedEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull CameraInfoInternal cameraInfoInternal, @NonNull Quirks quirks) {
        this.mProvider = encoderProfilesProvider;
        this.mCameraInfo = cameraInfoInternal;
        this.mQuirks = quirks;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i6) {
        if (!hasProfile(i6)) {
            return null;
        }
        return this.mProvider.getAll(i6);
    }
}
