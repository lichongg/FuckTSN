package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(29)
/* loaded from: D:\Downloads\app\classes.dex */
class CameraManagerCompatApi29Impl extends CameraManagerCompatApi28Impl {
    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl, androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public CameraCharacteristics getCameraCharacteristics(@NonNull String str) throws CameraAccessExceptionCompat {
        try {
            return this.mCameraManager.getCameraCharacteristics(str);
        } catch (CameraAccessException e6) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e6);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl, androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @RequiresPermission("android.permission.CAMERA")
    public void openCamera(@NonNull String str, @NonNull Executor executor, @NonNull CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        try {
            this.mCameraManager.openCamera(str, executor, stateCallback);
        } catch (CameraAccessException e6) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e6);
        }
    }

    CameraManagerCompatApi29Impl(@NonNull Context context) {
        super(context);
    }
}
