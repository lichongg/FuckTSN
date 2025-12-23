package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.internal.utils.SizeUtil;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class SurfaceConfig {
    public static final long DEFAULT_STREAM_USE_CASE_VALUE = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ConfigSize {
        VGA(0),
        s720p(1),
        PREVIEW(2),
        s1440p(3),
        RECORD(4),
        MAXIMUM(5),
        ULTRA_MAXIMUM(6),
        NOT_SUPPORT(7);

        final int mId;

        int getId() {
            return this.mId;
        }

        ConfigSize(int i6) {
            this.mId = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        RAW
    }

    @NonNull
    public static SurfaceConfig create(@NonNull ConfigType configType, @NonNull ConfigSize configSize) {
        return new AutoValue_SurfaceConfig(configType, configSize, 0L);
    }

    @NonNull
    public static ConfigType getConfigType(int i6) {
        return i6 == 35 ? ConfigType.YUV : i6 == 256 ? ConfigType.JPEG : i6 == 32 ? ConfigType.RAW : ConfigType.PRIV;
    }

    @NonNull
    public abstract ConfigSize getConfigSize();

    @NonNull
    public abstract ConfigType getConfigType();

    public abstract long getStreamUseCase();

    @NonNull
    public static SurfaceConfig create(@NonNull ConfigType configType, @NonNull ConfigSize configSize, long j6) {
        return new AutoValue_SurfaceConfig(configType, configSize, j6);
    }

    SurfaceConfig() {
    }

    @NonNull
    public static SurfaceConfig transformSurfaceConfig(int i6, int i7, @NonNull Size size, @NonNull SurfaceSizeDefinition surfaceSizeDefinition) {
        ConfigType configType = getConfigType(i7);
        ConfigSize configSize = ConfigSize.NOT_SUPPORT;
        int area = SizeUtil.getArea(size);
        if (i6 == 1) {
            if (area <= SizeUtil.getArea(surfaceSizeDefinition.getS720pSize(i7))) {
                configSize = ConfigSize.s720p;
            } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getS1440pSize(i7))) {
                configSize = ConfigSize.s1440p;
            }
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getAnalysisSize())) {
            configSize = ConfigSize.VGA;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getPreviewSize())) {
            configSize = ConfigSize.PREVIEW;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getRecordSize())) {
            configSize = ConfigSize.RECORD;
        } else if (area <= SizeUtil.getArea(surfaceSizeDefinition.getMaximumSize(i7))) {
            configSize = ConfigSize.MAXIMUM;
        } else {
            Size ultraMaximumSize = surfaceSizeDefinition.getUltraMaximumSize(i7);
            if (ultraMaximumSize != null && area <= SizeUtil.getArea(ultraMaximumSize)) {
                configSize = ConfigSize.ULTRA_MAXIMUM;
            }
        }
        return create(configType, configSize);
    }

    public final boolean isSupported(@NonNull SurfaceConfig surfaceConfig) {
        ConfigType configType = surfaceConfig.getConfigType();
        if (surfaceConfig.getConfigSize().getId() <= getConfigSize().getId() && configType == getConfigType()) {
            return true;
        }
        return false;
    }
}
