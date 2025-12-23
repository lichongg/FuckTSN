package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(30)
/* loaded from: D:\Downloads\app\classes.dex */
class CameraManagerCompatApi30Impl extends CameraManagerCompatApi29Impl {
    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    @NonNull
    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        try {
            return this.mCameraManager.getConcurrentCameraIds();
        } catch (CameraAccessException e6) {
            throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e6);
        }
    }

    CameraManagerCompatApi30Impl(@NonNull Context context) {
        super(context);
    }
}
