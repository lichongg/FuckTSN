package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class SurfaceOutputImpl implements SurfaceOutput {
    private static final String TAG = "SurfaceOutputImpl";

    @Nullable
    private CameraInternal mCameraInternal;

    @NonNull
    private final ListenableFuture<Void> mCloseFuture;
    private CallbackToFutureAdapter.Completer<Void> mCloseFutureCompleter;

    @Nullable
    @GuardedBy("mLock")
    private Consumer<SurfaceOutput.Event> mEventListener;

    @Nullable
    @GuardedBy("mLock")
    private Executor mExecutor;
    private final int mFormat;
    private final Rect mInputCropRect;
    private final Size mInputSize;
    private final boolean mMirroring;
    private final int mRotationDegrees;

    @NonNull
    private Matrix mSensorToBufferTransform;

    @NonNull
    private final Size mSize;

    @NonNull
    private final Surface mSurface;
    private final int mTargets;
    private final Object mLock = new Object();

    @NonNull
    private final float[] mAdditionalTransform = new float[16];

    @NonNull
    private final float[] mInvertedTextureTransform = new float[16];

    @GuardedBy("mLock")
    private boolean mHasPendingCloseRequest = false;

    @GuardedBy("mLock")
    private boolean mIsClosed = false;

    public static /* synthetic */ Object a(SurfaceOutputImpl surfaceOutputImpl, CallbackToFutureAdapter.Completer completer) {
        surfaceOutputImpl.mCloseFutureCompleter = completer;
        return "SurfaceOutputImpl close future complete";
    }

    private void calculateAdditionalTransform() {
        android.opengl.Matrix.setIdentityM(this.mAdditionalTransform, 0);
        MatrixExt.preVerticalFlip(this.mAdditionalTransform, 0.5f);
        MatrixExt.preRotate(this.mAdditionalTransform, this.mRotationDegrees, 0.5f, 0.5f);
        if (this.mMirroring) {
            android.opengl.Matrix.translateM(this.mAdditionalTransform, 0, 1.0f, 0.0f, 0.0f);
            android.opengl.Matrix.scaleM(this.mAdditionalTransform, 0, -1.0f, 1.0f, 1.0f);
        }
        Matrix rectToRect = TransformUtils.getRectToRect(TransformUtils.sizeToRectF(this.mInputSize), TransformUtils.sizeToRectF(TransformUtils.rotateSize(this.mInputSize, this.mRotationDegrees)), this.mRotationDegrees, this.mMirroring);
        RectF rectF = new RectF(this.mInputCropRect);
        rectToRect.mapRect(rectF);
        float width = rectF.left / r0.getWidth();
        float height = ((r0.getHeight() - rectF.height()) - rectF.top) / r0.getHeight();
        float width2 = rectF.width() / r0.getWidth();
        float height2 = rectF.height() / r0.getHeight();
        android.opengl.Matrix.translateM(this.mAdditionalTransform, 0, width, height, 0.0f);
        android.opengl.Matrix.scaleM(this.mAdditionalTransform, 0, width2, height2, 1.0f);
        calculateInvertedTextureTransform();
        float[] fArr = this.mAdditionalTransform;
        android.opengl.Matrix.multiplyMM(fArr, 0, this.mInvertedTextureTransform, 0, fArr, 0);
    }

    private void calculateInvertedTextureTransform() {
        android.opengl.Matrix.setIdentityM(this.mInvertedTextureTransform, 0);
        MatrixExt.preVerticalFlip(this.mInvertedTextureTransform, 0.5f);
        CameraInternal cameraInternal = this.mCameraInternal;
        if (cameraInternal != null) {
            Preconditions.checkState(cameraInternal.getHasTransform(), "Camera has no transform.");
            MatrixExt.preRotate(this.mInvertedTextureTransform, this.mCameraInternal.getCameraInfo().getSensorRotationDegrees(), 0.5f, 0.5f);
            if (this.mCameraInternal.isFrontFacing()) {
                android.opengl.Matrix.translateM(this.mInvertedTextureTransform, 0, 1.0f, 0.0f, 0.0f);
                android.opengl.Matrix.scaleM(this.mInvertedTextureTransform, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        float[] fArr = this.mInvertedTextureTransform;
        android.opengl.Matrix.invertM(fArr, 0, fArr, 0);
    }

    @Override // androidx.camera.core.SurfaceOutput, java.io.Closeable, java.lang.AutoCloseable
    @AnyThread
    public void close() {
        synchronized (this.mLock) {
            try {
                if (!this.mIsClosed) {
                    this.mIsClosed = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mCloseFutureCompleter.set(null);
    }

    @VisibleForTesting
    public CameraInternal getCamera() {
        return this.mCameraInternal;
    }

    @NonNull
    public ListenableFuture<Void> getCloseFuture() {
        return this.mCloseFuture;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getFormat() {
        return this.mFormat;
    }

    @VisibleForTesting
    public Rect getInputCropRect() {
        return this.mInputCropRect;
    }

    @VisibleForTesting
    public Size getInputSize() {
        return this.mInputSize;
    }

    @VisibleForTesting
    public boolean getMirroring() {
        return this.mMirroring;
    }

    @VisibleForTesting
    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @Override // androidx.camera.core.SurfaceOutput
    @NonNull
    public Matrix getSensorToBufferTransform() {
        return new Matrix(this.mSensorToBufferTransform);
    }

    @Override // androidx.camera.core.SurfaceOutput
    @NonNull
    public Size getSize() {
        return this.mSize;
    }

    @Override // androidx.camera.core.SurfaceOutput
    @NonNull
    public Surface getSurface(@NonNull Executor executor, @NonNull Consumer<SurfaceOutput.Event> consumer) {
        boolean z5;
        synchronized (this.mLock) {
            this.mExecutor = executor;
            this.mEventListener = consumer;
            z5 = this.mHasPendingCloseRequest;
        }
        if (z5) {
            requestClose();
        }
        return this.mSurface;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getTargets() {
        return this.mTargets;
    }

    @VisibleForTesting
    public boolean isClosed() {
        boolean z5;
        synchronized (this.mLock) {
            z5 = this.mIsClosed;
        }
        return z5;
    }

    public void requestClose() {
        Executor executor;
        Consumer<SurfaceOutput.Event> consumer;
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (this.mLock) {
            try {
                if (this.mExecutor != null && (consumer = this.mEventListener) != null) {
                    if (!this.mIsClosed) {
                        atomicReference.set(consumer);
                        executor = this.mExecutor;
                        this.mHasPendingCloseRequest = false;
                    }
                    executor = null;
                }
                this.mHasPendingCloseRequest = true;
                executor = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (executor != null) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.core.processing.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SurfaceOutputImpl.b(SurfaceOutputImpl.this, atomicReference);
                    }
                });
            } catch (RejectedExecutionException e6) {
                Logger.d(TAG, "Processor executor closed. Close request not posted.", e6);
            }
        }
    }

    @Override // androidx.camera.core.SurfaceOutput
    @AnyThread
    public void updateTransformMatrix(@NonNull float[] fArr, @NonNull float[] fArr2) {
        android.opengl.Matrix.multiplyMM(fArr, 0, fArr2, 0, this.mAdditionalTransform, 0);
    }

    SurfaceOutputImpl(@NonNull Surface surface, int i6, int i7, @NonNull Size size, @NonNull Size size2, @NonNull Rect rect, int i8, boolean z5, @Nullable CameraInternal cameraInternal, @NonNull Matrix matrix) {
        this.mSurface = surface;
        this.mTargets = i6;
        this.mFormat = i7;
        this.mSize = size;
        this.mInputSize = size2;
        this.mInputCropRect = new Rect(rect);
        this.mMirroring = z5;
        this.mRotationDegrees = i8;
        this.mCameraInternal = cameraInternal;
        this.mSensorToBufferTransform = matrix;
        calculateAdditionalTransform();
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.b0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return SurfaceOutputImpl.a(SurfaceOutputImpl.this, completer);
            }
        });
    }

    public static /* synthetic */ void b(SurfaceOutputImpl surfaceOutputImpl, AtomicReference atomicReference) {
        surfaceOutputImpl.getClass();
        ((Consumer) atomicReference.get()).accept(SurfaceOutput.Event.of(0, surfaceOutputImpl));
    }
}
