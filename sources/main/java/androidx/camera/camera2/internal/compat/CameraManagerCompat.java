package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.ApiCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class CameraManagerCompat {

    @GuardedBy("mCameraCharacteristicsMap")
    private final Map<String, CameraCharacteristicsCompat> mCameraCharacteristicsMap = new ArrayMap(4);
    private final CameraManagerCompatImpl mImpl;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        private final Executor mExecutor;
        final CameraManager.AvailabilityCallback mWrappedCallback;
        private final Object mLock = new Object();

        @GuardedBy("mLock")
        private boolean mDisabled = false;

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        @RequiresApi(29)
        public void onCameraAccessPrioritiesChanged() {
            synchronized (this.mLock) {
                try {
                    if (!this.mDisabled) {
                        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.y
                            @Override // java.lang.Runnable
                            public final void run() {
                                ApiCompat.Api29Impl.onCameraAccessPrioritiesChanged(CameraManagerCompat.AvailabilityCallbackExecutorWrapper.this.mWrappedCallback);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(@NonNull final String str) {
            synchronized (this.mLock) {
                try {
                    if (!this.mDisabled) {
                        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.x
                            @Override // java.lang.Runnable
                            public final void run() {
                                CameraManagerCompat.AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAvailable(str);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(@NonNull final String str) {
            synchronized (this.mLock) {
                try {
                    if (!this.mDisabled) {
                        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.z
                            @Override // java.lang.Runnable
                            public final void run() {
                                CameraManagerCompat.AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraUnavailable(str);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void setDisabled() {
            synchronized (this.mLock) {
                this.mDisabled = true;
            }
        }

        AvailabilityCallbackExecutorWrapper(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = availabilityCallback;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CameraManagerCompatImpl {
        @NonNull
        CameraCharacteristics getCameraCharacteristics(@NonNull String str) throws CameraAccessExceptionCompat;

        @NonNull
        String[] getCameraIdList() throws CameraAccessExceptionCompat;

        @NonNull
        CameraManager getCameraManager();

        @NonNull
        Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat;

        @RequiresPermission("android.permission.CAMERA")
        void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat;

        void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback);

        void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback);
    }

    @NonNull
    public static CameraManagerCompat from(@NonNull Context context) {
        return from(context, MainThreadAsyncHandler.getInstance());
    }

    @NonNull
    public static CameraManagerCompat from(@NonNull Context context, @NonNull Handler handler) {
        return new CameraManagerCompat(a0.a(context, handler));
    }

    @NonNull
    public CameraCharacteristicsCompat getCameraCharacteristicsCompat(@NonNull String str) throws CameraAccessExceptionCompat {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        synchronized (this.mCameraCharacteristicsMap) {
            cameraCharacteristicsCompat = this.mCameraCharacteristicsMap.get(str);
            if (cameraCharacteristicsCompat == null) {
                try {
                    cameraCharacteristicsCompat = CameraCharacteristicsCompat.toCameraCharacteristicsCompat(this.mImpl.getCameraCharacteristics(str), str);
                    this.mCameraCharacteristicsMap.put(str, cameraCharacteristicsCompat);
                } catch (AssertionError e6) {
                    throw new CameraAccessExceptionCompat(10002, e6.getMessage(), e6);
                }
            }
        }
        return cameraCharacteristicsCompat;
    }

    @NonNull
    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        return this.mImpl.getCameraIdList();
    }

    @NonNull
    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        return this.mImpl.getConcurrentCameraIds();
    }

    @RequiresPermission("android.permission.CAMERA")
    public void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        this.mImpl.openCamera(str, executor, stateCallback);
    }

    public void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.unregisterAvailabilityCallback(availabilityCallback);
    }

    @NonNull
    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }

    private CameraManagerCompat(CameraManagerCompatImpl cameraManagerCompatImpl) {
        this.mImpl = cameraManagerCompatImpl;
    }

    @NonNull
    @VisibleForTesting
    public static CameraManagerCompat from(@NonNull CameraManagerCompatImpl cameraManagerCompatImpl) {
        return new CameraManagerCompat(cameraManagerCompatImpl);
    }
}
