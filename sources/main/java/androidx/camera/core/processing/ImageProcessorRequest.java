package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.ImageProxy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ImageProcessorRequest implements ImageProcessor.Request {

    @NonNull
    private final ImageProxy mImageProxy;
    private final int mOutputFormat;

    @Override // androidx.camera.core.ImageProcessor.Request
    @NonNull
    public ImageProxy getInputImage() {
        return this.mImageProxy;
    }

    @Override // androidx.camera.core.ImageProcessor.Request
    public int getOutputFormat() {
        return this.mOutputFormat;
    }

    public ImageProcessorRequest(@NonNull ImageProxy imageProxy, int i6) {
        this.mImageProxy = imageProxy;
        this.mOutputFormat = i6;
    }
}
