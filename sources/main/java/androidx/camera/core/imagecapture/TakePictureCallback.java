package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
interface TakePictureCallback {
    boolean isAborted();

    @MainThread
    void onCaptureFailure(@NonNull ImageCaptureException imageCaptureException);

    @MainThread
    void onFinalResult(@NonNull ImageCapture.OutputFileResults outputFileResults);

    @MainThread
    void onFinalResult(@NonNull ImageProxy imageProxy);

    @MainThread
    void onImageCaptured();

    @MainThread
    void onProcessFailure(@NonNull ImageCaptureException imageCaptureException);
}
