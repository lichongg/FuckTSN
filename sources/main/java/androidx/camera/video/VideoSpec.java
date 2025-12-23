package androidx.camera.video;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AutoValue_VideoSpec;
import com.google.auto.value.AutoValue;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class VideoSpec {

    @NonNull
    public static final QualitySelector QUALITY_SELECTOR_AUTO;

    @NonNull
    public static final Range<Integer> FRAME_RATE_RANGE_AUTO = new Range<>(0, Integer.MAX_VALUE);

    @NonNull
    public static final Range<Integer> BITRATE_RANGE_AUTO = new Range<>(0, Integer.MAX_VALUE);

    abstract int getAspectRatio();

    @NonNull
    public abstract Range<Integer> getBitrate();

    @NonNull
    public abstract Range<Integer> getFrameRate();

    @NonNull
    public abstract QualitySelector getQualitySelector();

    @NonNull
    public abstract Builder toBuilder();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue.Builder
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder {
        @NonNull
        public abstract VideoSpec build();

        @NonNull
        abstract Builder setAspectRatio(int i6);

        @NonNull
        public abstract Builder setBitrate(@NonNull Range<Integer> range);

        @NonNull
        public abstract Builder setFrameRate(@NonNull Range<Integer> range);

        @NonNull
        public abstract Builder setQualitySelector(@NonNull QualitySelector qualitySelector);

        Builder() {
        }
    }

    static {
        Quality quality = Quality.FHD;
        QUALITY_SELECTOR_AUTO = QualitySelector.fromOrderedList(Arrays.asList(quality, Quality.HD, Quality.SD), FallbackStrategy.higherQualityOrLowerThan(quality));
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_VideoSpec.Builder().setQualitySelector(QUALITY_SELECTOR_AUTO).setFrameRate(FRAME_RATE_RANGE_AUTO).setBitrate(BITRATE_RANGE_AUTO).setAspectRatio(-1);
    }

    VideoSpec() {
    }
}
