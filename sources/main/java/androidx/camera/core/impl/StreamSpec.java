package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class StreamSpec {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = new Range<>(0, 0);

    @NonNull
    public abstract DynamicRange getDynamicRange();

    @NonNull
    public abstract Range<Integer> getExpectedFrameRateRange();

    @Nullable
    public abstract Config getImplementationOptions();

    @NonNull
    public abstract Size getResolution();

    @NonNull
    public abstract Builder toBuilder();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract StreamSpec build();

        @NonNull
        public abstract Builder setDynamicRange(@NonNull DynamicRange dynamicRange);

        @NonNull
        public abstract Builder setExpectedFrameRateRange(@NonNull Range<Integer> range);

        @NonNull
        public abstract Builder setImplementationOptions(@NonNull Config config);

        @NonNull
        public abstract Builder setResolution(@NonNull Size size);

        Builder() {
        }
    }

    @NonNull
    public static Builder builder(@NonNull Size size) {
        return new AutoValue_StreamSpec.Builder().setResolution(size).setExpectedFrameRateRange(FRAME_RATE_RANGE_UNSPECIFIED).setDynamicRange(DynamicRange.SDR);
    }
}
