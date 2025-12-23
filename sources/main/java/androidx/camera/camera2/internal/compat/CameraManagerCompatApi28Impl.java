package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(28)
/* loaded from: D:\Downloads\app\classes.dex */
class CameraManagerCompatApi28Impl extends CameraManagerCompatBaseImpl {
    CameraManagerCompatApi28Impl(@NonNull Context context) {
        super(context, null);
    }

    static CameraManagerCompatApi28Impl create(@NonNull Context context) {
        return new CameraManagerCompatApi28Impl(context);
    }

    private boolean isDndFailCase(@NonNull Throwable th) {
        return Build.VERSION.SDK_INT == 28 && isDndRuntimeException(th);
    }

    private void throwDndException(@NonNull Throwable th) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(10001, th);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @RequiresPermission("android.permission.CAMERA")
    public void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.mCameraManager.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e6) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e6);
        } catch (IllegalArgumentException e7) {
        } catch (SecurityException e8) {
            throw e8;
        } catch (RuntimeException e9) {
            if (isDndFailCase(e9)) {
                throwDndException(e9);
            }
            throw e9;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void registerAvailabilityCallback(@NonNull Executor executor, @NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mCameraManager.registerAvailabilityCallback(executor, availabilityCallback);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void unregisterAvailabilityCallback(@NonNull CameraManager.AvailabilityCallback availabilityCallback) {
        this.mCameraManager.unregisterAvailabilityCallback(availabilityCallback);
    }

    private static boolean isDndRuntimeException(@NonNull Throwable th) {
        StackTraceElement[] stackTrace;
        if (!th.getClass().equals(RuntimeException.class) || (stackTrace = th.getStackTrace()) == null || stackTrace.length < 0) {
            return false;
        }
        return "_enableShutterSound".equals(stackTrace[0].getMethodName());
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public CameraCharacteristics getCameraCharacteristics(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return super.getCameraCharacteristics(str);
        } catch (RuntimeException e6) {
            if (isDndFailCase(e6)) {
                throwDndException(e6);
            }
            throw e6;
        }
    }
}
