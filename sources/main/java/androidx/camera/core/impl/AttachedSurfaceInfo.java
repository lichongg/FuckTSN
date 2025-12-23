package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfigFactory;
import com.google.auto.value.AutoValue;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class AttachedSurfaceInfo {
    @NonNull
    public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

    @NonNull
    public abstract DynamicRange getDynamicRange();

    public abstract int getImageFormat();

    @Nullable
    public abstract Config getImplementationOptions();

    @NonNull
    public abstract Size getSize();

    @NonNull
    public abstract SurfaceConfig getSurfaceConfig();

    @Nullable
    public abstract Range<Integer> getTargetFrameRate();

    @NonNull
    public static AttachedSurfaceInfo create(@NonNull SurfaceConfig surfaceConfig, int i6, @NonNull Size size, @NonNull DynamicRange dynamicRange, @NonNull List<UseCaseConfigFactory.CaptureType> list, @Nullable Config config, @Nullable Range<Integer> range) {
        return new AutoValue_AttachedSurfaceInfo(surfaceConfig, i6, size, dynamicRange, list, config, range);
    }

    AttachedSurfaceInfo() {
    }

    @NonNull
    public StreamSpec toStreamSpec(@NonNull Config config) {
        StreamSpec.Builder implementationOptions = StreamSpec.builder(getSize()).setDynamicRange(getDynamicRange()).setImplementationOptions(config);
        if (getTargetFrameRate() != null) {
            implementationOptions.setExpectedFrameRateRange(getTargetFrameRate());
        }
        return implementationOptions.build();
    }
}
