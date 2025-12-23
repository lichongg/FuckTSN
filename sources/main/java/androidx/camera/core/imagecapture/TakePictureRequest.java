package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.internal.compat.workaround.CaptureFailedRetryEnabler;
import androidx.core.util.Preconditions;
import com.beizi.fusion.widget.TwistView;
import com.google.auto.value.AutoValue;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AutoValue
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class TakePictureRequest {
    private int mRemainingRetires = new CaptureFailedRetryEnabler().getRetryCount();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface RetryControl {
        void retryRequest(@NonNull TakePictureRequest takePictureRequest);
    }

    @NonNull
    public static TakePictureRequest of(@NonNull Executor executor, @Nullable ImageCapture.OnImageCapturedCallback onImageCapturedCallback, @Nullable ImageCapture.OnImageSavedCallback onImageSavedCallback, @Nullable ImageCapture.OutputFileOptions outputFileOptions, @NonNull Rect rect, @NonNull Matrix matrix, int i6, int i7, int i8, @NonNull List<CameraCaptureCallback> list) {
        Preconditions.checkArgument((onImageSavedCallback == null) == (outputFileOptions == null), "onDiskCallback and outputFileOptions should be both null or both non-null.");
        Preconditions.checkArgument((onImageCapturedCallback == null) ^ (onImageSavedCallback == null), "One and only one on-disk or in-memory callback should be present.");
        return new AutoValue_TakePictureRequest(executor, onImageCapturedCallback, onImageSavedCallback, outputFileOptions, rect, matrix, i6, i7, i8, list);
    }

    @NonNull
    abstract Executor getAppExecutor();

    abstract int getCaptureMode();

    @NonNull
    abstract Rect getCropRect();

    @Nullable
    abstract ImageCapture.OnImageCapturedCallback getInMemoryCallback();

    @IntRange(from = 1, to = TwistView.DELAY_TIME_TWIST)
    abstract int getJpegQuality();

    @Nullable
    abstract ImageCapture.OnImageSavedCallback getOnDiskCallback();

    @Nullable
    abstract ImageCapture.OutputFileOptions getOutputFileOptions();

    abstract int getRotationDegrees();

    @NonNull
    abstract Matrix getSensorToBufferTransform();

    @NonNull
    abstract List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks();

    void onResult(@Nullable final ImageCapture.OutputFileResults outputFileResults) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.s
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.b(TakePictureRequest.this, outputFileResults);
            }
        });
    }

    void onResult(@Nullable final ImageProxy imageProxy) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.r
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.c(TakePictureRequest.this, imageProxy);
            }
        });
    }

    public static /* synthetic */ void a(TakePictureRequest takePictureRequest, ImageCaptureException imageCaptureException) {
        boolean z5;
        boolean z6 = false;
        if (takePictureRequest.getInMemoryCallback() != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (takePictureRequest.getOnDiskCallback() != null) {
            z6 = true;
        }
        if (z5 && !z6) {
            ImageCapture.OnImageCapturedCallback inMemoryCallback = takePictureRequest.getInMemoryCallback();
            Objects.requireNonNull(inMemoryCallback);
            inMemoryCallback.onError(imageCaptureException);
        } else {
            if (z6 && !z5) {
                ImageCapture.OnImageSavedCallback onDiskCallback = takePictureRequest.getOnDiskCallback();
                Objects.requireNonNull(onDiskCallback);
                onDiskCallback.onError(imageCaptureException);
                return;
            }
            throw new IllegalStateException("One and only one callback is allowed.");
        }
    }

    public static /* synthetic */ void b(TakePictureRequest takePictureRequest, ImageCapture.OutputFileResults outputFileResults) {
        ImageCapture.OnImageSavedCallback onDiskCallback = takePictureRequest.getOnDiskCallback();
        Objects.requireNonNull(onDiskCallback);
        Objects.requireNonNull(outputFileResults);
        onDiskCallback.onImageSaved(outputFileResults);
    }

    public static /* synthetic */ void c(TakePictureRequest takePictureRequest, ImageProxy imageProxy) {
        ImageCapture.OnImageCapturedCallback inMemoryCallback = takePictureRequest.getInMemoryCallback();
        Objects.requireNonNull(inMemoryCallback);
        Objects.requireNonNull(imageProxy);
        inMemoryCallback.onCaptureSuccess(imageProxy);
    }

    @MainThread
    boolean decrementRetryCounter() {
        Threads.checkMainThread();
        int i6 = this.mRemainingRetires;
        if (i6 > 0) {
            this.mRemainingRetires = i6 - 1;
            return true;
        }
        return false;
    }

    @MainThread
    @VisibleForTesting
    int getRemainingRetries() {
        Threads.checkMainThread();
        return this.mRemainingRetires;
    }

    @MainThread
    void incrementRetryCounter() {
        Threads.checkMainThread();
        this.mRemainingRetires++;
    }

    void onError(@NonNull final ImageCaptureException imageCaptureException) {
        getAppExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.t
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureRequest.a(TakePictureRequest.this, imageCaptureException);
            }
        });
    }
}
