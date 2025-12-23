package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class OutputConfigurationCompat {
    public static final int STREAM_USE_CASE_NONE = -1;
    public static final int SURFACE_GROUP_ID_NONE = -1;
    private final OutputConfigurationCompatImpl mImpl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface OutputConfigurationCompatImpl {
        void addSurface(@NonNull Surface surface);

        void enableSurfaceSharing();

        long getDynamicRangeProfile();

        int getMaxSharedSurfaceCount();

        @Nullable
        Object getOutputConfiguration();

        @Nullable
        String getPhysicalCameraId();

        long getStreamUseCase();

        @Nullable
        Surface getSurface();

        int getSurfaceGroupId();

        List<Surface> getSurfaces();

        void removeSurface(@NonNull Surface surface);

        void setDynamicRangeProfile(long j6);

        void setPhysicalCameraId(@Nullable String str);

        void setStreamUseCase(long j6);
    }

    public OutputConfigurationCompat(@NonNull Surface surface) {
        this(-1, surface);
    }

    @Nullable
    public static OutputConfigurationCompat wrap(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        int i6 = Build.VERSION.SDK_INT;
        OutputConfigurationCompatImpl wrap = i6 >= 33 ? OutputConfigurationCompatApi33Impl.wrap(d.a(obj)) : i6 >= 28 ? OutputConfigurationCompatApi28Impl.wrap(d.a(obj)) : i6 >= 26 ? OutputConfigurationCompatApi26Impl.wrap(d.a(obj)) : i6 >= 24 ? OutputConfigurationCompatApi24Impl.wrap(d.a(obj)) : null;
        if (wrap == null) {
            return null;
        }
        return new OutputConfigurationCompat(wrap);
    }

    public OutputConfigurationCompat(int i6, @NonNull Surface surface) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 33) {
            this.mImpl = new OutputConfigurationCompatApi33Impl(i6, surface);
            return;
        }
        if (i7 >= 28) {
            this.mImpl = new OutputConfigurationCompatApi28Impl(i6, surface);
            return;
        }
        if (i7 >= 26) {
            this.mImpl = new OutputConfigurationCompatApi26Impl(i6, surface);
        } else if (i7 >= 24) {
            this.mImpl = new OutputConfigurationCompatApi24Impl(i6, surface);
        } else {
            this.mImpl = new OutputConfigurationCompatBaseImpl(surface);
        }
    }

    public void addSurface(@NonNull Surface surface) {
        this.mImpl.addSurface(surface);
    }

    public void enableSurfaceSharing() {
        this.mImpl.enableSurfaceSharing();
    }

    public boolean equals(Object obj) {
        if (obj instanceof OutputConfigurationCompat) {
            return this.mImpl.equals(((OutputConfigurationCompat) obj).mImpl);
        }
        return false;
    }

    public long getDynamicRangeProfile() {
        return this.mImpl.getDynamicRangeProfile();
    }

    public int getMaxSharedSurfaceCount() {
        return this.mImpl.getMaxSharedSurfaceCount();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getPhysicalCameraId() {
        return this.mImpl.getPhysicalCameraId();
    }

    public long getStreamUseCase() {
        return this.mImpl.getStreamUseCase();
    }

    @Nullable
    public Surface getSurface() {
        return this.mImpl.getSurface();
    }

    public int getSurfaceGroupId() {
        return this.mImpl.getSurfaceGroupId();
    }

    @NonNull
    public List<Surface> getSurfaces() {
        return this.mImpl.getSurfaces();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public void removeSurface(@NonNull Surface surface) {
        this.mImpl.removeSurface(surface);
    }

    public void setDynamicRangeProfile(long j6) {
        this.mImpl.setDynamicRangeProfile(j6);
    }

    public void setPhysicalCameraId(@Nullable String str) {
        this.mImpl.setPhysicalCameraId(str);
    }

    public void setStreamUseCase(long j6) {
        this.mImpl.setStreamUseCase(j6);
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getOutputConfiguration();
    }

    @RequiresApi(26)
    public <T> OutputConfigurationCompat(@NonNull Size size, @NonNull Class<T> cls) {
        OutputConfiguration newOutputConfiguration = ApiCompat.Api26Impl.newOutputConfiguration(size, cls);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33) {
            this.mImpl = OutputConfigurationCompatApi33Impl.wrap(newOutputConfiguration);
        } else if (i6 >= 28) {
            this.mImpl = OutputConfigurationCompatApi28Impl.wrap(newOutputConfiguration);
        } else {
            this.mImpl = OutputConfigurationCompatApi26Impl.wrap(newOutputConfiguration);
        }
    }

    private OutputConfigurationCompat(@NonNull OutputConfigurationCompatImpl outputConfigurationCompatImpl) {
        this.mImpl = outputConfigurationCompatImpl;
    }
}
