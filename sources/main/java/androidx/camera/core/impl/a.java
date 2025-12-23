package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.ExifData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final /* synthetic */ class a {
    @NonNull
    public static CaptureResult a(CameraCaptureResult cameraCaptureResult) {
        return CameraCaptureResult.EmptyCameraCaptureResult.create().getCaptureResult();
    }

    public static void b(CameraCaptureResult cameraCaptureResult, @NonNull ExifData.Builder builder) {
        builder.setFlashState(cameraCaptureResult.getFlashState());
    }
}
