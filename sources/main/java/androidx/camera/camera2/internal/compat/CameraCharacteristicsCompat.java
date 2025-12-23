package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class CameraCharacteristicsCompat {

    @NonNull
    private final CameraCharacteristicsCompatImpl mCameraCharacteristicsImpl;

    @NonNull
    private final String mCameraId;

    @NonNull
    @GuardedBy("this")
    private final Map<CameraCharacteristics.Key<?>, Object> mValuesCache = new HashMap();

    @Nullable
    private StreamConfigurationMapCompat mStreamConfigurationMapCompat = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CameraCharacteristicsCompatImpl {
        @Nullable
        <T> T get(@NonNull CameraCharacteristics.Key<T> key);

        @NonNull
        Set<String> getPhysicalCameraIds();

        @NonNull
        CameraCharacteristics unwrap();
    }

    private boolean isKeyNonCacheable(@NonNull CameraCharacteristics.Key<?> key) {
        return key.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    @NonNull
    @VisibleForTesting
    public static CameraCharacteristicsCompat toCameraCharacteristicsCompat(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull String str) {
        return new CameraCharacteristicsCompat(cameraCharacteristics, str);
    }

    @NonNull
    public Set<String> getPhysicalCameraIds() {
        return this.mCameraCharacteristicsImpl.getPhysicalCameraIds();
    }

    @NonNull
    public StreamConfigurationMapCompat getStreamConfigurationMapCompat() {
        if (this.mStreamConfigurationMapCompat == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
                this.mStreamConfigurationMapCompat = StreamConfigurationMapCompat.toStreamConfigurationMapCompat(streamConfigurationMap, new OutputSizesCorrector(this.mCameraId));
            } catch (AssertionError e6) {
                throw new IllegalArgumentException(e6.getMessage());
            }
        }
        return this.mStreamConfigurationMapCompat;
    }

    @NonNull
    public CameraCharacteristics toCameraCharacteristics() {
        return this.mCameraCharacteristicsImpl.unwrap();
    }

    private CameraCharacteristicsCompat(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mCameraCharacteristicsImpl = new CameraCharacteristicsApi28Impl(cameraCharacteristics);
        } else {
            this.mCameraCharacteristicsImpl = new CameraCharacteristicsBaseImpl(cameraCharacteristics);
        }
        this.mCameraId = str;
    }

    @Nullable
    public <T> T get(@NonNull CameraCharacteristics.Key<T> key) {
        if (isKeyNonCacheable(key)) {
            return (T) this.mCameraCharacteristicsImpl.get(key);
        }
        synchronized (this) {
            try {
                T t5 = (T) this.mValuesCache.get(key);
                if (t5 != null) {
                    return t5;
                }
                T t6 = (T) this.mCameraCharacteristicsImpl.get(key);
                if (t6 != null) {
                    this.mValuesCache.put(key, t6);
                }
                return t6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
