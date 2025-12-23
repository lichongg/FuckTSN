package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(28)
/* loaded from: D:\Downloads\app\classes.dex */
class CameraDeviceCompatApi28Impl extends CameraDeviceCompatApi24Impl {
    CameraDeviceCompatApi28Impl(@NonNull CameraDevice cameraDevice) {
        super((CameraDevice) Preconditions.checkNotNull(cameraDevice), null);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatApi24Impl, androidx.camera.camera2.internal.compat.CameraDeviceCompatApi23Impl, androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(@NonNull SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessExceptionCompat {
        SessionConfiguration sessionConfiguration = (SessionConfiguration) sessionConfigurationCompat.unwrap();
        Preconditions.checkNotNull(sessionConfiguration);
        try {
            this.mCameraDevice.createCaptureSession(sessionConfiguration);
        } catch (CameraAccessException e6) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e6);
        }
    }
}
