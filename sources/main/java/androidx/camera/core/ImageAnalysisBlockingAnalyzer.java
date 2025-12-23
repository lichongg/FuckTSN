package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class ImageAnalysisBlockingAnalyzer extends ImageAnalysisAbstractAnalyzer {
    ImageAnalysisBlockingAnalyzer() {
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    @Nullable
    ImageProxy acquireImage(@NonNull ImageReaderProxy imageReaderProxy) {
        return imageReaderProxy.acquireNextImage();
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    void onValidImageAvailable(@NonNull final ImageProxy imageProxy) {
        Futures.addCallback(analyzeImage(imageProxy), new FutureCallback<Void>() { // from class: androidx.camera.core.ImageAnalysisBlockingAnalyzer.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r12) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                imageProxy.close();
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.ImageAnalysisAbstractAnalyzer
    void clearCache() {
    }
}
