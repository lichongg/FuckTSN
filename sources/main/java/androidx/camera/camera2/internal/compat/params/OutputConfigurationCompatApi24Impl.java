package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(24)
/* loaded from: D:\Downloads\app\classes.dex */
class OutputConfigurationCompatApi24Impl extends OutputConfigurationCompatBaseImpl {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class OutputConfigurationParamsApi24 {
        long mDynamicRangeProfile = 1;
        boolean mIsShared;

        @NonNull
        final OutputConfiguration mOutputConfiguration;

        @Nullable
        String mPhysicalCameraId;

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi24)) {
                return false;
            }
            OutputConfigurationParamsApi24 outputConfigurationParamsApi24 = (OutputConfigurationParamsApi24) obj;
            return Objects.equals(this.mOutputConfiguration, outputConfigurationParamsApi24.mOutputConfiguration) && this.mIsShared == outputConfigurationParamsApi24.mIsShared && this.mDynamicRangeProfile == outputConfigurationParamsApi24.mDynamicRangeProfile && Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi24.mPhysicalCameraId);
        }

        public int hashCode() {
            int hashCode = this.mOutputConfiguration.hashCode() ^ 31;
            int i6 = (this.mIsShared ? 1 : 0) ^ ((hashCode << 5) - hashCode);
            int i7 = (i6 << 5) - i6;
            String str = this.mPhysicalCameraId;
            int hashCode2 = (str == null ? 0 : str.hashCode()) ^ i7;
            return e.a(this.mDynamicRangeProfile) ^ ((hashCode2 << 5) - hashCode2);
        }

        OutputConfigurationParamsApi24(@NonNull OutputConfiguration outputConfiguration) {
            this.mOutputConfiguration = outputConfiguration;
        }
    }

    OutputConfigurationCompatApi24Impl(@NonNull Surface surface) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(surface)));
    }

    OutputConfigurationCompatApi24Impl(int i6, @NonNull Surface surface) {
        this(new OutputConfigurationParamsApi24(new OutputConfiguration(i6, surface)));
    }

    @RequiresApi(24)
    static OutputConfigurationCompatApi24Impl wrap(@NonNull OutputConfiguration outputConfiguration) {
        return new OutputConfigurationCompatApi24Impl(new OutputConfigurationParamsApi24(outputConfiguration));
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi24) this.mObject).mIsShared = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @NonNull
    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationParamsApi24);
        return ((OutputConfigurationParamsApi24) this.mObject).mOutputConfiguration;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl
    boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi24) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long j6) {
        ((OutputConfigurationParamsApi24) this.mObject).mDynamicRangeProfile = j6;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(@Nullable String str) {
        ((OutputConfigurationParamsApi24) this.mObject).mPhysicalCameraId = str;
    }

    OutputConfigurationCompatApi24Impl(@NonNull Object obj) {
        super(obj);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public Surface getSurface() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurface();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return ((OutputConfiguration) getOutputConfiguration()).getSurfaceGroupId();
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl, androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @NonNull
    public List<Surface> getSurfaces() {
        return Collections.singletonList(getSurface());
    }
}
