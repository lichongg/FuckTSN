package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private volatile boolean mOnePixelShiftEnabled;
    private volatile boolean mOutputImageRotationEnabled;

    @IntRange(from = 0, to = 359)
    private volatile int mPrevBufferRotationDegrees;

    @Nullable
    @GuardedBy("mAnalyzerLock")
    private SafeCloseImageReaderProxy mProcessedImageReaderProxy;

    @Nullable
    @GuardedBy("mAnalyzerLock")
    private ImageWriter mProcessedImageWriter;

    @Nullable
    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mRGBConvertedBuffer;

    @IntRange(from = 0, to = 359)
    private volatile int mRelativeRotation;

    @GuardedBy("mAnalyzerLock")
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;

    @Nullable
    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mURotatedBuffer;

    @GuardedBy("mAnalyzerLock")
    private Executor mUserExecutor;

    @Nullable
    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mVRotatedBuffer;

    @Nullable
    @GuardedBy("mAnalyzerLock")
    @VisibleForTesting
    ByteBuffer mYRotatedBuffer;
    private volatile int mOutputImageFormat = 1;

    @GuardedBy("mAnalyzerLock")
    private Rect mOriginalViewPortCropRect = new Rect();

    @GuardedBy("mAnalyzerLock")
    private Rect mUpdatedViewPortCropRect = new Rect();

    @GuardedBy("mAnalyzerLock")
    private Matrix mOriginalSensorToBufferTransformMatrix = new Matrix();

    @GuardedBy("mAnalyzerLock")
    private Matrix mUpdatedSensorToBufferTransformMatrix = new Matrix();
    private final Object mAnalyzerLock = new Object();
    protected boolean mIsAttached = true;

    @Nullable
    abstract ImageProxy acquireImage(@NonNull ImageReaderProxy imageReaderProxy);

    void attach() {
        this.mIsAttached = true;
    }

    abstract void clearCache();

    void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    abstract void onValidImageAvailable(@NonNull ImageProxy imageProxy);

    public static /* synthetic */ void a(ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, ImageProxy imageProxy, Matrix matrix, ImageProxy imageProxy2, Rect rect, ImageAnalysis.Analyzer analyzer, CallbackToFutureAdapter.Completer completer) {
        if (!imageAnalysisAbstractAnalyzer.mIsAttached) {
            completer.setException(new OperationCanceledException("ImageAnalysis is detached"));
            return;
        }
        SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy2, ImmutableImageInfo.create(imageProxy.getImageInfo().getTagBundle(), imageProxy.getImageInfo().getTimestamp(), imageAnalysisAbstractAnalyzer.mOutputImageRotationEnabled ? 0 : imageAnalysisAbstractAnalyzer.mRelativeRotation, matrix));
        if (!rect.isEmpty()) {
            settableImageProxy.setCropRect(rect);
        }
        analyzer.analyze(settableImageProxy);
        completer.set(null);
    }

    @GuardedBy("mAnalyzerLock")
    private void createHelperBuffer(@NonNull ImageProxy imageProxy) {
        if (this.mOutputImageFormat != 1) {
            if (this.mOutputImageFormat == 2 && this.mRGBConvertedBuffer == null) {
                this.mRGBConvertedBuffer = ByteBuffer.allocateDirect(imageProxy.getWidth() * imageProxy.getHeight() * 4);
                return;
            }
            return;
        }
        if (this.mYRotatedBuffer == null) {
            this.mYRotatedBuffer = ByteBuffer.allocateDirect(imageProxy.getWidth() * imageProxy.getHeight());
        }
        this.mYRotatedBuffer.position(0);
        if (this.mURotatedBuffer == null) {
            this.mURotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getWidth() * imageProxy.getHeight()) / 4);
        }
        this.mURotatedBuffer.position(0);
        if (this.mVRotatedBuffer == null) {
            this.mVRotatedBuffer = ByteBuffer.allocateDirect((imageProxy.getWidth() * imageProxy.getHeight()) / 4);
        }
        this.mVRotatedBuffer.position(0);
    }

    @NonNull
    private static SafeCloseImageReaderProxy createImageReaderProxy(int i6, int i7, int i8, int i9, int i10) {
        boolean z5 = i8 == 90 || i8 == 270;
        int i11 = z5 ? i7 : i6;
        if (!z5) {
            i6 = i7;
        }
        return new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(i11, i6, i9, i10));
    }

    @NonNull
    @VisibleForTesting
    static Matrix getAdditionalTransformMatrixAppliedByProcessor(int i6, int i7, int i8, int i9, @IntRange(from = 0, to = 359) int i10) {
        Matrix matrix = new Matrix();
        if (i10 > 0) {
            matrix.setRectToRect(new RectF(0.0f, 0.0f, i6, i7), TransformUtils.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
            matrix.postRotate(i10);
            matrix.postConcat(TransformUtils.getNormalizedToBuffer(new RectF(0.0f, 0.0f, i8, i9)));
        }
        return matrix;
    }

    @NonNull
    static Rect getUpdatedCropRect(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    @GuardedBy("mAnalyzerLock")
    private void recalculateTransformMatrixAndCropRect(int i6, int i7, int i8, int i9) {
        Matrix additionalTransformMatrixAppliedByProcessor = getAdditionalTransformMatrixAppliedByProcessor(i6, i7, i8, i9, this.mRelativeRotation);
        this.mUpdatedViewPortCropRect = getUpdatedCropRect(this.mOriginalViewPortCropRect, additionalTransformMatrixAppliedByProcessor);
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, additionalTransformMatrixAppliedByProcessor);
    }

    @GuardedBy("mAnalyzerLock")
    private void recreateImageReaderProxy(@NonNull ImageProxy imageProxy, @IntRange(from = 0, to = 359) int i6) {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mProcessedImageReaderProxy;
        if (safeCloseImageReaderProxy == null) {
            return;
        }
        safeCloseImageReaderProxy.safeClose();
        this.mProcessedImageReaderProxy = createImageReaderProxy(imageProxy.getWidth(), imageProxy.getHeight(), i6, this.mProcessedImageReaderProxy.getImageFormat(), this.mProcessedImageReaderProxy.getMaxImages());
        if (Build.VERSION.SDK_INT < 23 || this.mOutputImageFormat != 1) {
            return;
        }
        ImageWriter imageWriter = this.mProcessedImageWriter;
        if (imageWriter != null) {
            ImageWriterCompat.close(imageWriter);
        }
        this.mProcessedImageWriter = ImageWriterCompat.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.google.common.util.concurrent.ListenableFuture<java.lang.Void> analyzeImage(@androidx.annotation.NonNull final androidx.camera.core.ImageProxy r17) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageAnalysisAbstractAnalyzer.analyzeImage(androidx.camera.core.ImageProxy):com.google.common.util.concurrent.ListenableFuture");
    }

    void setAnalyzer(@Nullable Executor executor, @Nullable ImageAnalysis.Analyzer analyzer) {
        if (analyzer == null) {
            clearCache();
        }
        synchronized (this.mAnalyzerLock) {
            this.mSubscribedAnalyzer = analyzer;
            this.mUserExecutor = executor;
        }
    }

    void setOnePixelShiftEnabled(boolean z5) {
        this.mOnePixelShiftEnabled = z5;
    }

    void setOutputImageFormat(int i6) {
        this.mOutputImageFormat = i6;
    }

    void setOutputImageRotationEnabled(boolean z5) {
        this.mOutputImageRotationEnabled = z5;
    }

    void setProcessedImageReaderProxy(@NonNull SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        synchronized (this.mAnalyzerLock) {
            this.mProcessedImageReaderProxy = safeCloseImageReaderProxy;
        }
    }

    void setRelativeRotation(int i6) {
        this.mRelativeRotation = i6;
    }

    void setSensorToBufferTransformMatrix(@NonNull Matrix matrix) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalSensorToBufferTransformMatrix = matrix;
            this.mUpdatedSensorToBufferTransformMatrix = new Matrix(this.mOriginalSensorToBufferTransformMatrix);
        }
    }

    void setViewPortCropRect(@NonNull Rect rect) {
        synchronized (this.mAnalyzerLock) {
            this.mOriginalViewPortCropRect = rect;
            this.mUpdatedViewPortCropRect = new Rect(this.mOriginalViewPortCropRect);
        }
    }

    ImageAnalysisAbstractAnalyzer() {
    }

    public static /* synthetic */ Object b(final ImageAnalysisAbstractAnalyzer imageAnalysisAbstractAnalyzer, Executor executor, final ImageProxy imageProxy, final Matrix matrix, final ImageProxy imageProxy2, final Rect rect, final ImageAnalysis.Analyzer analyzer, final CallbackToFutureAdapter.Completer completer) {
        imageAnalysisAbstractAnalyzer.getClass();
        executor.execute(new Runnable() { // from class: androidx.camera.core.q
            @Override // java.lang.Runnable
            public final void run() {
                ImageAnalysisAbstractAnalyzer.a(ImageAnalysisAbstractAnalyzer.this, imageProxy, matrix, imageProxy2, rect, analyzer, completer);
            }
        });
        return "analyzeImage";
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(@NonNull ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireImage = acquireImage(imageReaderProxy);
            if (acquireImage != null) {
                onValidImageAvailable(acquireImage);
            }
        } catch (IllegalStateException e6) {
            Logger.e(TAG, "Failed to acquire image.", e6);
        }
    }
}
