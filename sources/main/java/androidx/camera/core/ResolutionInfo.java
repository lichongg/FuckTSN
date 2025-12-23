package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.AutoValue_ResolutionInfo_ResolutionInfoInternal;
import com.google.auto.value.AutoValue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ResolutionInfo {
    private final ResolutionInfoInternal mResolutionInfoInternal;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class ResolutionInfoInternal {
        @NonNull
        abstract Rect getCropRect();

        @NonNull
        abstract Size getResolution();

        abstract int getRotationDegrees();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @AutoValue.Builder
        static abstract class Builder {
            @NonNull
            abstract ResolutionInfoInternal build();

            @NonNull
            abstract Builder setCropRect(@NonNull Rect rect);

            @NonNull
            abstract Builder setResolution(@NonNull Size size);

            @NonNull
            abstract Builder setRotationDegrees(int i6);

            Builder() {
            }
        }

        ResolutionInfoInternal() {
        }
    }

    public boolean equals(@Nullable Object obj) {
        return this.mResolutionInfoInternal.equals(obj);
    }

    @NonNull
    public Rect getCropRect() {
        return this.mResolutionInfoInternal.getCropRect();
    }

    @NonNull
    public Size getResolution() {
        return this.mResolutionInfoInternal.getResolution();
    }

    public int getRotationDegrees() {
        return this.mResolutionInfoInternal.getRotationDegrees();
    }

    public int hashCode() {
        return this.mResolutionInfoInternal.hashCode();
    }

    @NonNull
    public String toString() {
        return this.mResolutionInfoInternal.toString();
    }

    public ResolutionInfo(@NonNull Size size, @NonNull Rect rect, int i6) {
        this.mResolutionInfoInternal = new AutoValue_ResolutionInfo_ResolutionInfoInternal.Builder().setResolution(size).setCropRect(rect).setRotationDegrees(i6).build();
    }
}
