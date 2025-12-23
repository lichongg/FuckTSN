package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import com.beizi.fusion.widget.TwistView;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_TakePictureRequest extends TakePictureRequest {
    private final Executor appExecutor;
    private final int captureMode;
    private final Rect cropRect;
    private final ImageCapture.OnImageCapturedCallback inMemoryCallback;
    private final int jpegQuality;
    private final ImageCapture.OnImageSavedCallback onDiskCallback;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransform;
    private final List<CameraCaptureCallback> sessionConfigCameraCaptureCallbacks;

    public boolean equals(Object obj) {
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback;
        ImageCapture.OnImageSavedCallback onImageSavedCallback;
        ImageCapture.OutputFileOptions outputFileOptions;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TakePictureRequest) {
            TakePictureRequest takePictureRequest = (TakePictureRequest) obj;
            if (this.appExecutor.equals(takePictureRequest.getAppExecutor()) && ((onImageCapturedCallback = this.inMemoryCallback) != null ? onImageCapturedCallback.equals(takePictureRequest.getInMemoryCallback()) : takePictureRequest.getInMemoryCallback() == null) && ((onImageSavedCallback = this.onDiskCallback) != null ? onImageSavedCallback.equals(takePictureRequest.getOnDiskCallback()) : takePictureRequest.getOnDiskCallback() == null) && ((outputFileOptions = this.outputFileOptions) != null ? outputFileOptions.equals(takePictureRequest.getOutputFileOptions()) : takePictureRequest.getOutputFileOptions() == null) && this.cropRect.equals(takePictureRequest.getCropRect()) && this.sensorToBufferTransform.equals(takePictureRequest.getSensorToBufferTransform()) && this.rotationDegrees == takePictureRequest.getRotationDegrees() && this.jpegQuality == takePictureRequest.getJpegQuality() && this.captureMode == takePictureRequest.getCaptureMode() && this.sessionConfigCameraCaptureCallbacks.equals(takePictureRequest.getSessionConfigCameraCaptureCallbacks())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    Executor getAppExecutor() {
        return this.appExecutor;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    int getCaptureMode() {
        return this.captureMode;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @Nullable
    ImageCapture.OnImageCapturedCallback getInMemoryCallback() {
        return this.inMemoryCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @IntRange(from = 1, to = TwistView.DELAY_TIME_TWIST)
    int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @Nullable
    ImageCapture.OnImageSavedCallback getOnDiskCallback() {
        return this.onDiskCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @Nullable
    ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    @NonNull
    List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks() {
        return this.sessionConfigCameraCaptureCallbacks;
    }

    public int hashCode() {
        int hashCode = (this.appExecutor.hashCode() ^ 1000003) * 1000003;
        ImageCapture.OnImageCapturedCallback onImageCapturedCallback = this.inMemoryCallback;
        int hashCode2 = (hashCode ^ (onImageCapturedCallback == null ? 0 : onImageCapturedCallback.hashCode())) * 1000003;
        ImageCapture.OnImageSavedCallback onImageSavedCallback = this.onDiskCallback;
        int hashCode3 = (hashCode2 ^ (onImageSavedCallback == null ? 0 : onImageSavedCallback.hashCode())) * 1000003;
        ImageCapture.OutputFileOptions outputFileOptions = this.outputFileOptions;
        return ((((((((((((hashCode3 ^ (outputFileOptions != null ? outputFileOptions.hashCode() : 0)) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.jpegQuality) * 1000003) ^ this.captureMode) * 1000003) ^ this.sessionConfigCameraCaptureCallbacks.hashCode();
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.appExecutor + ", inMemoryCallback=" + this.inMemoryCallback + ", onDiskCallback=" + this.onDiskCallback + ", outputFileOptions=" + this.outputFileOptions + ", cropRect=" + this.cropRect + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", rotationDegrees=" + this.rotationDegrees + ", jpegQuality=" + this.jpegQuality + ", captureMode=" + this.captureMode + ", sessionConfigCameraCaptureCallbacks=" + this.sessionConfigCameraCaptureCallbacks + "}";
    }

    AutoValue_TakePictureRequest(Executor executor, @Nullable ImageCapture.OnImageCapturedCallback onImageCapturedCallback, @Nullable ImageCapture.OnImageSavedCallback onImageSavedCallback, @Nullable ImageCapture.OutputFileOptions outputFileOptions, Rect rect, Matrix matrix, int i6, int i7, int i8, List<CameraCaptureCallback> list) {
        if (executor != null) {
            this.appExecutor = executor;
            this.inMemoryCallback = onImageCapturedCallback;
            this.onDiskCallback = onImageSavedCallback;
            this.outputFileOptions = outputFileOptions;
            if (rect != null) {
                this.cropRect = rect;
                if (matrix != null) {
                    this.sensorToBufferTransform = matrix;
                    this.rotationDegrees = i6;
                    this.jpegQuality = i7;
                    this.captureMode = i8;
                    if (list != null) {
                        this.sessionConfigCameraCaptureCallbacks = list;
                        return;
                    }
                    throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
                }
                throw new NullPointerException("Null sensorToBufferTransform");
            }
            throw new NullPointerException("Null cropRect");
        }
        throw new NullPointerException("Null appExecutor");
    }
}
