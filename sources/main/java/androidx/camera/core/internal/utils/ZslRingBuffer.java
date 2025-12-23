package androidx.camera.core.internal.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;
import androidx.camera.core.internal.utils.RingBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class ZslRingBuffer extends ArrayRingBuffer<ImageProxy> {
    @Override // androidx.camera.core.internal.utils.ArrayRingBuffer, androidx.camera.core.internal.utils.RingBuffer
    public void enqueue(@NonNull ImageProxy imageProxy) {
        if (isValidZslFrame(imageProxy.getImageInfo())) {
            super.enqueue((ZslRingBuffer) imageProxy);
        } else {
            this.mOnRemoveCallback.onRemove(imageProxy);
        }
    }

    public ZslRingBuffer(int i6, @NonNull RingBuffer.OnRemoveCallback<ImageProxy> onRemoveCallback) {
        super(i6, onRemoveCallback);
    }

    private boolean isValidZslFrame(@NonNull ImageInfo imageInfo) {
        CameraCaptureResult retrieveCameraCaptureResult = CameraCaptureResults.retrieveCameraCaptureResult(imageInfo);
        if ((retrieveCameraCaptureResult.getAfState() != CameraCaptureMetaData.AfState.LOCKED_FOCUSED && retrieveCameraCaptureResult.getAfState() != CameraCaptureMetaData.AfState.PASSIVE_FOCUSED) || retrieveCameraCaptureResult.getAeState() != CameraCaptureMetaData.AeState.CONVERGED || retrieveCameraCaptureResult.getAwbState() != CameraCaptureMetaData.AwbState.CONVERGED) {
            return false;
        }
        return true;
    }
}
