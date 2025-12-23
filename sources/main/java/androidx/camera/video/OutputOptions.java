package androidx.camera.video;

import android.location.Location;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class OutputOptions {
    public static final int DURATION_UNLIMITED = 0;
    public static final int FILE_SIZE_UNLIMITED = 0;
    private final OutputOptionsInternal mOutputOptionsInternal;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class Builder<T extends OutputOptions, B> {
        final OutputOptionsInternal.Builder<?> mRootInternalBuilder;

        @NonNull
        abstract T build();

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public B setDurationLimitMillis(@IntRange(from = 0) long j6) {
            Preconditions.checkArgument(j6 >= 0, "The specified duration limit can't be negative.");
            this.mRootInternalBuilder.setDurationLimitMillis(j6);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public B setFileSizeLimit(@IntRange(from = 0) long j6) {
            Preconditions.checkArgument(j6 >= 0, "The specified file size limit can't be negative.");
            this.mRootInternalBuilder.setFileSizeLimit(j6);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NonNull
        public B setLocation(@Nullable Location location) {
            if (location != null) {
                boolean z5 = false;
                Preconditions.checkArgument(location.getLatitude() >= -90.0d && location.getLatitude() <= 90.0d, "Latitude must be in the range [-90, 90]");
                if (location.getLongitude() >= -180.0d && location.getLongitude() <= 180.0d) {
                    z5 = true;
                }
                Preconditions.checkArgument(z5, "Longitude must be in the range [-180, 180]");
            }
            this.mRootInternalBuilder.setLocation(location);
            return this;
        }

        Builder(@NonNull OutputOptionsInternal.Builder<?> builder) {
            this.mRootInternalBuilder = builder;
            builder.setFileSizeLimit(0L);
            builder.setDurationLimitMillis(0L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class OutputOptionsInternal {
        @IntRange(from = 0)
        abstract long getDurationLimitMillis();

        @IntRange(from = 0)
        abstract long getFileSizeLimit();

        @Nullable
        abstract Location getLocation();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static abstract class Builder<B> {
            @NonNull
            abstract OutputOptionsInternal build();

            @NonNull
            abstract B setDurationLimitMillis(@IntRange(from = 0) long j6);

            @NonNull
            abstract B setFileSizeLimit(@IntRange(from = 0) long j6);

            @NonNull
            abstract B setLocation(@Nullable Location location);

            Builder() {
            }
        }

        OutputOptionsInternal() {
        }
    }

    @IntRange(from = 0)
    public long getDurationLimitMillis() {
        return this.mOutputOptionsInternal.getDurationLimitMillis();
    }

    @IntRange(from = 0)
    public long getFileSizeLimit() {
        return this.mOutputOptionsInternal.getFileSizeLimit();
    }

    @Nullable
    public Location getLocation() {
        return this.mOutputOptionsInternal.getLocation();
    }

    OutputOptions(@NonNull OutputOptionsInternal outputOptionsInternal) {
        this.mOutputOptionsInternal = outputOptionsInternal;
    }
}
