package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.e3;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
class CaptureNode implements Node<In, Out> {

    @VisibleForTesting
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";

    @Nullable
    private In mInputEdge;

    @Nullable
    private Out mOutputEdge;

    @Nullable
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    @NonNull
    private final Set<Integer> mPendingStageIds = new HashSet();
    ProcessingRequest mCurrentRequest = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class In {

        @NonNull
        private CameraCaptureCallback mCameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.core.imagecapture.CaptureNode.In.1
        };

        @Nullable
        private DeferrableSurface mSurface;

        @NonNull
        abstract Edge<ImageCaptureException> getErrorEdge();

        @Nullable
        abstract ImageReaderProxyProvider getImageReaderProxyProvider();

        abstract int getInputFormat();

        abstract int getOutputFormat();

        @NonNull
        abstract Edge<ProcessingRequest> getRequestEdge();

        abstract Size getSize();

        abstract boolean isVirtualCamera();

        @NonNull
        static In of(Size size, int i6, int i7, boolean z5, @Nullable ImageReaderProxyProvider imageReaderProxyProvider) {
            return new AutoValue_CaptureNode_In(size, i6, i7, z5, imageReaderProxyProvider, new Edge(), new Edge());
        }

        @NonNull
        CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        @NonNull
        DeferrableSurface getSurface() {
            DeferrableSurface deferrableSurface = this.mSurface;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        void setCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        void setSurface(@NonNull Surface surface) {
            Preconditions.checkState(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface, getSize(), getInputFormat());
        }

        In() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class Out {
        abstract Edge<ImageProxy> getImageEdge();

        abstract int getInputFormat();

        abstract int getOutputFormat();

        abstract Edge<ProcessingRequest> getRequestEdge();

        static Out of(int i6, int i7) {
            return new AutoValue_CaptureNode_Out(new Edge(), new Edge(), i6, i7);
        }

        Out() {
        }
    }

    @NonNull
    private static ImageReaderProxy createImageReaderProxy(@Nullable ImageReaderProxyProvider imageReaderProxyProvider, int i6, int i7, int i8) {
        return imageReaderProxyProvider != null ? imageReaderProxyProvider.newInstance(i6, i7, i8, 4, 0L) : ImageReaderProxys.createIsolatedReader(i6, i7, i8, 4);
    }

    @NonNull
    @VisibleForTesting
    In getInputEdge() {
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        return in;
    }

    @NonNull
    @VisibleForTesting
    public SafeCloseImageReaderProxy getSafeCloseImageReaderProxy() {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        return safeCloseImageReaderProxy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.camera.core.processing.Node
    @NonNull
    public Out transform(@NonNull In in) {
        Consumer<ProcessingRequest> consumer;
        NoMetadataImageReader noMetadataImageReader;
        Preconditions.checkState(this.mInputEdge == null && this.mSafeCloseImageReaderProxy == null, "CaptureNode does not support recreation yet.");
        this.mInputEdge = in;
        Size size = in.getSize();
        int inputFormat = in.getInputFormat();
        if (in.isVirtualCamera() || in.getImageReaderProxyProvider() != null) {
            final NoMetadataImageReader noMetadataImageReader2 = new NoMetadataImageReader(createImageReaderProxy(in.getImageReaderProxyProvider(), size.getWidth(), size.getHeight(), inputFormat));
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.b
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    CaptureNode.b(CaptureNode.this, noMetadataImageReader2, (ProcessingRequest) obj);
                }
            };
            noMetadataImageReader = noMetadataImageReader2;
        } else {
            MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), inputFormat, 4);
            in.setCameraCaptureCallback(metadataImageReader.getCameraCaptureCallback());
            consumer = new Consumer() { // from class: androidx.camera.core.imagecapture.a
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    CaptureNode.this.onRequestAvailable((ProcessingRequest) obj);
                }
            };
            noMetadataImageReader = metadataImageReader;
        }
        Surface surface = noMetadataImageReader.getSurface();
        Objects.requireNonNull(surface);
        in.setSurface(surface);
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(noMetadataImageReader);
        noMetadataImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.imagecapture.c
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                CaptureNode.a(CaptureNode.this, imageReaderProxy);
            }
        }, CameraXExecutors.mainThreadExecutor());
        in.getRequestEdge().setListener(consumer);
        in.getErrorEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.d
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                CaptureNode.this.sendCaptureError((ImageCaptureException) obj);
            }
        });
        Out of = Out.of(in.getInputFormat(), in.getOutputFormat());
        this.mOutputEdge = of;
        return of;
    }

    CaptureNode() {
    }

    public static /* synthetic */ void a(CaptureNode captureNode, ImageReaderProxy imageReaderProxy) {
        captureNode.getClass();
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage != null) {
                captureNode.onImageProxyAvailable(acquireLatestImage);
            } else {
                captureNode.sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", null));
            }
        } catch (IllegalStateException e6) {
            captureNode.sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", e6));
        }
    }

    public static /* synthetic */ void b(CaptureNode captureNode, NoMetadataImageReader noMetadataImageReader, ProcessingRequest processingRequest) {
        captureNode.onRequestAvailable(processingRequest);
        noMetadataImageReader.acceptProcessingRequest(processingRequest);
    }

    private void matchAndPropagateImage(@NonNull ImageProxy imageProxy) {
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        Integer num = (Integer) tag;
        int intValue = num.intValue();
        Preconditions.checkState(this.mPendingStageIds.contains(num), "Received an unexpected stage id" + intValue);
        this.mPendingStageIds.remove(num);
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getImageEdge().accept(imageProxy);
        if (this.mPendingStageIds.isEmpty()) {
            ProcessingRequest processingRequest = this.mCurrentRequest;
            this.mCurrentRequest = null;
            processingRequest.onImageCaptured();
        }
    }

    private void releaseInputResources(@NonNull In in, @NonNull SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        in.getSurface().close();
        ListenableFuture<Void> terminationFuture = in.getSurface().getTerminationFuture();
        Objects.requireNonNull(safeCloseImageReaderProxy);
        terminationFuture.addListener(new e3(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
    }

    @MainThread
    public int getCapacity() {
        boolean z5;
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    @MainThread
    @VisibleForTesting
    void onImageProxyAvailable(@NonNull ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest == null) {
            Logger.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
            imageProxy.close();
            return;
        }
        matchAndPropagateImage(imageProxy);
    }

    @MainThread
    @VisibleForTesting
    void onRequestAvailable(@NonNull final ProcessingRequest processingRequest) {
        boolean z5;
        Threads.checkMainThread();
        boolean z6 = false;
        if (getCapacity() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "Too many acquire images. Close image to be able to process next.");
        if (this.mCurrentRequest == null || this.mPendingStageIds.isEmpty()) {
            z6 = true;
        }
        Preconditions.checkState(z6, "The previous request is not complete");
        this.mCurrentRequest = processingRequest;
        this.mPendingStageIds.addAll(processingRequest.getStageIds());
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getRequestEdge().accept(processingRequest);
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.CaptureNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r12) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest2 = processingRequest;
                CaptureNode captureNode = CaptureNode.this;
                if (processingRequest2 == captureNode.mCurrentRequest) {
                    captureNode.mCurrentRequest = null;
                }
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.processing.Node
    @MainThread
    public void release() {
        Threads.checkMainThread();
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        releaseInputResources(in, safeCloseImageReaderProxy);
    }

    @MainThread
    void sendCaptureError(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null) {
            processingRequest.onCaptureFailure(imageCaptureException);
        }
    }

    @MainThread
    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        boolean z5;
        Threads.checkMainThread();
        if (this.mSafeCloseImageReaderProxy != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }
}
