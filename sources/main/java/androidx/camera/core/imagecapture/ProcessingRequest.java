package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
class ProcessingRequest {

    @NonNull
    private final TakePictureCallback mCallback;

    @NonNull
    final ListenableFuture<Void> mCaptureFuture;

    @NonNull
    private final Rect mCropRect;
    private final int mJpegQuality;

    @Nullable
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final int mRotationDegrees;

    @NonNull
    private final Matrix mSensorToBufferTransform;

    @NonNull
    private final List<Integer> mStageIds = new ArrayList();

    @NonNull
    private final String mTagBundleKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public void onFinalResult(@NonNull ImageCapture.OutputFileResults outputFileResults) {
        this.mCallback.onFinalResult(outputFileResults);
    }

    @NonNull
    ListenableFuture<Void> getCaptureFuture() {
        return this.mCaptureFuture;
    }

    @NonNull
    Rect getCropRect() {
        return this.mCropRect;
    }

    int getJpegQuality() {
        return this.mJpegQuality;
    }

    @Nullable
    ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.mOutputFileOptions;
    }

    int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @NonNull
    Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    @NonNull
    List<Integer> getStageIds() {
        return this.mStageIds;
    }

    @NonNull
    String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    boolean isAborted() {
        return this.mCallback.isAborted();
    }

    @MainThread
    void onCaptureFailure(@NonNull ImageCaptureException imageCaptureException) {
        this.mCallback.onCaptureFailure(imageCaptureException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public void onFinalResult(@NonNull ImageProxy imageProxy) {
        this.mCallback.onFinalResult(imageProxy);
    }

    @MainThread
    void onImageCaptured() {
        this.mCallback.onImageCaptured();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public void onProcessFailure(@NonNull ImageCaptureException imageCaptureException) {
        this.mCallback.onProcessFailure(imageCaptureException);
    }

    ProcessingRequest(@NonNull CaptureBundle captureBundle, @Nullable ImageCapture.OutputFileOptions outputFileOptions, @NonNull Rect rect, int i6, int i7, @NonNull Matrix matrix, @NonNull TakePictureCallback takePictureCallback, @NonNull ListenableFuture<Void> listenableFuture) {
        this.mOutputFileOptions = outputFileOptions;
        this.mJpegQuality = i7;
        this.mRotationDegrees = i6;
        this.mCropRect = rect;
        this.mSensorToBufferTransform = matrix;
        this.mCallback = takePictureCallback;
        this.mTagBundleKey = String.valueOf(captureBundle.hashCode());
        List<CaptureStage> captureStages = captureBundle.getCaptureStages();
        Objects.requireNonNull(captureStages);
        Iterator<CaptureStage> it = captureStages.iterator();
        while (it.hasNext()) {
            this.mStageIds.add(Integer.valueOf(it.next().getId()));
        }
        this.mCaptureFuture = listenableFuture;
    }

    boolean isInMemoryCapture() {
        if (getOutputFileOptions() == null) {
            return true;
        }
        return false;
    }
}
