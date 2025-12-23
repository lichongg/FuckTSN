package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class CameraCaptureCallback {
    public void onCaptureCancelled() {
    }

    public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
    }

    public void onCaptureFailed(@NonNull CameraCaptureFailure cameraCaptureFailure) {
    }
}
