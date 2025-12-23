package androidx.camera.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class SurfaceViewImplementation extends PreviewViewImplementation {
    private static final int SCREENSHOT_TIMEOUT_MILLIS = 100;
    private static final String TAG = "SurfaceViewImpl";
    final SurfaceRequestCallback mSurfaceRequestCallback;
    SurfaceView mSurfaceView;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    class SurfaceRequestCallback implements SurfaceHolder.Callback {

        @Nullable
        private Size mCurrentSurfaceSize;

        @Nullable
        private PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;

        @Nullable
        private SurfaceRequest mSurfaceRequest;

        @Nullable
        private SurfaceRequest mSurfaceRequestToBeInvalidated;

        @Nullable
        private Size mTargetSize;
        private boolean mWasSurfaceProvided = false;
        private boolean mNeedToInvalidate = false;

        SurfaceRequestCallback() {
        }

        public static /* synthetic */ void a(PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener, SurfaceRequest.Result result) {
            Logger.d(SurfaceViewImplementation.TAG, "Safe to release surface.");
            if (onSurfaceNotInUseListener != null) {
                onSurfaceNotInUseListener.onSurfaceNotInUse();
            }
        }

        private boolean canProvideSurface() {
            return (this.mWasSurfaceProvided || this.mSurfaceRequest == null || !Objects.equals(this.mTargetSize, this.mCurrentSurfaceSize)) ? false : true;
        }

        @UiThread
        private void cancelPreviousRequest() {
            if (this.mSurfaceRequest != null) {
                Logger.d(SurfaceViewImplementation.TAG, "Request canceled: " + this.mSurfaceRequest);
                this.mSurfaceRequest.willNotProvideSurface();
            }
        }

        @UiThread
        private void closeSurface() {
            if (this.mSurfaceRequest != null) {
                Logger.d(SurfaceViewImplementation.TAG, "Surface closed " + this.mSurfaceRequest);
                this.mSurfaceRequest.getDeferrableSurface().close();
            }
        }

        @UiThread
        private boolean tryToComplete() {
            Surface surface = SurfaceViewImplementation.this.mSurfaceView.getHolder().getSurface();
            if (!canProvideSurface()) {
                return false;
            }
            Logger.d(SurfaceViewImplementation.TAG, "Surface set on Preview.");
            final PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
            SurfaceRequest surfaceRequest = this.mSurfaceRequest;
            Objects.requireNonNull(surfaceRequest);
            surfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor(SurfaceViewImplementation.this.mSurfaceView.getContext()), new Consumer() { // from class: androidx.camera.view.z
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    SurfaceViewImplementation.SurfaceRequestCallback.a(PreviewViewImplementation.OnSurfaceNotInUseListener.this, (SurfaceRequest.Result) obj);
                }
            });
            this.mWasSurfaceProvided = true;
            SurfaceViewImplementation.this.onSurfaceProvided();
            return true;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface changed. Size: " + i7 + "x" + i8);
            this.mCurrentSurfaceSize = new Size(i7, i8);
            tryToComplete();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            SurfaceRequest surfaceRequest;
            Logger.d(SurfaceViewImplementation.TAG, "Surface created.");
            if (!this.mNeedToInvalidate || (surfaceRequest = this.mSurfaceRequestToBeInvalidated) == null) {
                return;
            }
            surfaceRequest.invalidate();
            this.mSurfaceRequestToBeInvalidated = null;
            this.mNeedToInvalidate = false;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
            Logger.d(SurfaceViewImplementation.TAG, "Surface destroyed.");
            if (this.mWasSurfaceProvided) {
                closeSurface();
            } else {
                cancelPreviousRequest();
            }
            this.mNeedToInvalidate = true;
            SurfaceRequest surfaceRequest = this.mSurfaceRequest;
            if (surfaceRequest != null) {
                this.mSurfaceRequestToBeInvalidated = surfaceRequest;
            }
            this.mWasSurfaceProvided = false;
            this.mSurfaceRequest = null;
            this.mOnSurfaceNotInUseListener = null;
            this.mCurrentSurfaceSize = null;
            this.mTargetSize = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @UiThread
        public void setSurfaceRequest(@NonNull SurfaceRequest surfaceRequest, @Nullable PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
            cancelPreviousRequest();
            if (this.mNeedToInvalidate) {
                this.mNeedToInvalidate = false;
                surfaceRequest.invalidate();
                return;
            }
            this.mSurfaceRequest = surfaceRequest;
            this.mOnSurfaceNotInUseListener = onSurfaceNotInUseListener;
            Size resolution = surfaceRequest.getResolution();
            this.mTargetSize = resolution;
            this.mWasSurfaceProvided = false;
            if (!tryToComplete()) {
                Logger.d(SurfaceViewImplementation.TAG, "Wait for new Surface creation.");
                SurfaceViewImplementation.this.mSurfaceView.getHolder().setFixedSize(resolution.getWidth(), resolution.getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.camera.view.PreviewViewImplementation
    @NonNull
    public ListenableFuture<Void> waitForNextFrame() {
        return Futures.immediateFuture(null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void pixelCopyRequest(@NonNull SurfaceView surfaceView, @NonNull Bitmap bitmap, @NonNull PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, @NonNull Handler handler) {
            PixelCopy.request(surfaceView, bitmap, onPixelCopyFinishedListener, handler);
        }
    }

    public static /* synthetic */ void b(Semaphore semaphore, int i6) {
        if (i6 == 0) {
            Logger.d(TAG, "PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
        } else {
            Logger.e(TAG, "PreviewView.SurfaceViewImplementation.getBitmap() failed with error " + i6);
        }
        semaphore.release();
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @Nullable
    View getPreview() {
        return this.mSurfaceView;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    @Nullable
    @RequiresApi(24)
    Bitmap getPreviewBitmap() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView == null || surfaceView.getHolder().getSurface() == null || !this.mSurfaceView.getHolder().getSurface().isValid()) {
            return null;
        }
        final Semaphore semaphore = new Semaphore(0);
        Bitmap createBitmap = Bitmap.createBitmap(this.mSurfaceView.getWidth(), this.mSurfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        HandlerThread handlerThread = new HandlerThread("pixelCopyRequest Thread");
        handlerThread.start();
        Api24Impl.pixelCopyRequest(this.mSurfaceView, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: androidx.camera.view.x
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i6) {
                SurfaceViewImplementation.b(semaphore, i6);
            }
        }, new Handler(handlerThread.getLooper()));
        try {
            if (!semaphore.tryAcquire(1, 100L, TimeUnit.MILLISECONDS)) {
                Logger.e(TAG, "Timed out while trying to acquire screenshot.");
            }
            return createBitmap;
        } catch (InterruptedException e6) {
            Logger.e(TAG, "Interrupted while trying to acquire screenshot.", e6);
            return createBitmap;
        } finally {
            handlerThread.quitSafely();
        }
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void initializePreview() {
        Preconditions.checkNotNull(this.mParent);
        Preconditions.checkNotNull(this.mResolution);
        SurfaceView surfaceView = new SurfaceView(this.mParent.getContext());
        this.mSurfaceView = surfaceView;
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mParent.removeAllViews();
        this.mParent.addView(this.mSurfaceView);
        this.mSurfaceView.getHolder().addCallback(this.mSurfaceRequestCallback);
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void onSurfaceRequested(@NonNull final SurfaceRequest surfaceRequest, @Nullable final PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        if (!shouldReusePreview(this.mSurfaceView, this.mResolution, surfaceRequest)) {
            this.mResolution = surfaceRequest.getResolution();
            initializePreview();
        }
        if (onSurfaceNotInUseListener != null) {
            surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(this.mSurfaceView.getContext()), new Runnable() { // from class: androidx.camera.view.v
                @Override // java.lang.Runnable
                public final void run() {
                    PreviewViewImplementation.OnSurfaceNotInUseListener.this.onSurfaceNotInUse();
                }
            });
        }
        this.mSurfaceView.post(new Runnable() { // from class: androidx.camera.view.w
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceViewImplementation.this.mSurfaceRequestCallback.setSurfaceRequest(surfaceRequest, onSurfaceNotInUseListener);
            }
        });
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void setFrameUpdateListener(@NonNull Executor executor, @NonNull PreviewView.OnFrameUpdateListener onFrameUpdateListener) {
        throw new IllegalArgumentException("SurfaceView doesn't support frame update listener");
    }

    SurfaceViewImplementation(@NonNull FrameLayout frameLayout, @NonNull PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
        this.mSurfaceRequestCallback = new SurfaceRequestCallback();
    }

    private static boolean shouldReusePreview(@Nullable SurfaceView surfaceView, @Nullable Size size, @NonNull SurfaceRequest surfaceRequest) {
        boolean equals = Objects.equals(size, surfaceRequest.getResolution());
        if (surfaceView != null && equals) {
            return true;
        }
        return false;
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void onAttachedToWindow() {
    }

    @Override // androidx.camera.view.PreviewViewImplementation
    void onDetachedFromWindow() {
    }
}
