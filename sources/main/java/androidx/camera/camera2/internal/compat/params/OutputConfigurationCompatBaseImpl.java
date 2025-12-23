package androidx.camera.camera2.internal.compat.params;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class OutputConfigurationCompatBaseImpl implements OutputConfigurationCompat.OutputConfigurationCompatImpl {
    static final String TAG = "OutputConfigCompat";
    final Object mObject;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    private static final class OutputConfigurationParamsApi21 {
        private static final String DETECT_SURFACE_TYPE_METHOD = "detectSurfaceType";
        private static final String GET_GENERATION_ID_METHOD = "getGenerationId";
        private static final String GET_SURFACE_SIZE_METHOD = "getSurfaceSize";
        private static final String LEGACY_CAMERA_DEVICE_CLASS = "android.hardware.camera2.legacy.LegacyCameraDevice";
        static final int MAX_SURFACES_COUNT = 1;
        final int mConfiguredFormat;
        final int mConfiguredGenerationId;
        final Size mConfiguredSize;

        @Nullable
        String mPhysicalCameraId;
        final List<Surface> mSurfaces;
        boolean mIsShared = false;
        long mDynamicRangeProfile = 1;

        @SuppressLint({"BlockedPrivateApi", "BanUncheckedReflection"})
        private static int getSurfaceFormat(@NonNull Surface surface) {
            try {
                Method declaredMethod = Class.forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(DETECT_SURFACE_TYPE_METHOD, Surface.class);
                if (Build.VERSION.SDK_INT < 22) {
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) declaredMethod.invoke(null, surface)).intValue();
            } catch (ClassNotFoundException e6) {
                e = e6;
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface format.", e);
                return 0;
            } catch (IllegalAccessException e7) {
                e = e7;
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface format.", e);
                return 0;
            } catch (NoSuchMethodException e8) {
                e = e8;
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface format.", e);
                return 0;
            } catch (InvocationTargetException e9) {
                e = e9;
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface format.", e);
                return 0;
            }
        }

        @SuppressLint({"BlockedPrivateApi", "BanUncheckedReflection"})
        private static Size getSurfaceSize(@NonNull Surface surface) {
            try {
                Method declaredMethod = Class.forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(GET_SURFACE_SIZE_METHOD, Surface.class);
                declaredMethod.setAccessible(true);
                return (Size) declaredMethod.invoke(null, surface);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e6) {
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface size.", e6);
                return null;
            }
        }

        @SuppressLint({"SoonBlockedPrivateApi", "BlockedPrivateApi", "BanUncheckedReflection"})
        private static int getSurfaceGenerationId(@NonNull Surface surface) {
            try {
                return ((Integer) Surface.class.getDeclaredMethod(GET_GENERATION_ID_METHOD, null).invoke(surface, null)).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e6) {
                Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface generation id.", e6);
                return -1;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OutputConfigurationParamsApi21)) {
                return false;
            }
            OutputConfigurationParamsApi21 outputConfigurationParamsApi21 = (OutputConfigurationParamsApi21) obj;
            if (!this.mConfiguredSize.equals(outputConfigurationParamsApi21.mConfiguredSize) || this.mConfiguredFormat != outputConfigurationParamsApi21.mConfiguredFormat || this.mConfiguredGenerationId != outputConfigurationParamsApi21.mConfiguredGenerationId || this.mIsShared != outputConfigurationParamsApi21.mIsShared || this.mDynamicRangeProfile != outputConfigurationParamsApi21.mDynamicRangeProfile || !Objects.equals(this.mPhysicalCameraId, outputConfigurationParamsApi21.mPhysicalCameraId)) {
                return false;
            }
            int min = Math.min(this.mSurfaces.size(), outputConfigurationParamsApi21.mSurfaces.size());
            for (int i6 = 0; i6 < min; i6++) {
                if (this.mSurfaces.get(i6) != outputConfigurationParamsApi21.mSurfaces.get(i6)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.mSurfaces.hashCode() ^ 31;
            int i6 = this.mConfiguredGenerationId ^ ((hashCode << 5) - hashCode);
            int hashCode2 = this.mConfiguredSize.hashCode() ^ ((i6 << 5) - i6);
            int i7 = this.mConfiguredFormat ^ ((hashCode2 << 5) - hashCode2);
            int i8 = (this.mIsShared ? 1 : 0) ^ ((i7 << 5) - i7);
            int i9 = (i8 << 5) - i8;
            String str = this.mPhysicalCameraId;
            int hashCode3 = (str == null ? 0 : str.hashCode()) ^ i9;
            return e.a(this.mDynamicRangeProfile) ^ ((hashCode3 << 5) - hashCode3);
        }

        OutputConfigurationParamsApi21(@NonNull Surface surface) {
            Preconditions.checkNotNull(surface, "Surface must not be null");
            this.mSurfaces = Collections.singletonList(surface);
            this.mConfiguredSize = getSurfaceSize(surface);
            this.mConfiguredFormat = getSurfaceFormat(surface);
            this.mConfiguredGenerationId = getSurfaceGenerationId(surface);
        }
    }

    OutputConfigurationCompatBaseImpl(@NonNull Surface surface) {
        this.mObject = new OutputConfigurationParamsApi21(surface);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return 1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public Object getOutputConfiguration() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return -1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void addSurface(@NonNull Surface surface) {
        Preconditions.checkNotNull(surface, "Surface must not be null");
        if (getSurface() == surface) {
            throw new IllegalStateException("Surface is already added!");
        }
        if (!isSurfaceSharingEnabled()) {
            throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
        }
        throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi21) this.mObject).mIsShared = true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof OutputConfigurationCompatBaseImpl) {
            return Objects.equals(this.mObject, ((OutputConfigurationCompatBaseImpl) obj).mObject);
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getStreamUseCase() {
        return -1L;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @Nullable
    public Surface getSurface() {
        List<Surface> list = ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    @NonNull
    public List<Surface> getSurfaces() {
        return ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi21) this.mObject).mIsShared;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long j6) {
        ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile = j6;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(@Nullable String str) {
        ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId = str;
    }

    OutputConfigurationCompatBaseImpl(@NonNull Object obj) {
        this.mObject = obj;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(@NonNull Surface surface) {
        if (getSurface() == surface) {
            throw new IllegalArgumentException("Cannot remove surface associated with this output configuration");
        }
        throw new IllegalArgumentException("Surface is not part of this output configuration");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setStreamUseCase(long j6) {
    }
}
