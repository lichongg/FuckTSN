package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener, TakePictureRequest.RetryControl {
    private static final String TAG = "TakePictureManager";

    @Nullable
    private RequestWithCallback mCapturingRequest;
    final ImageCaptureControl mImageCaptureControl;
    ImagePipeline mImagePipeline;
    private final List<RequestWithCallback> mIncompleteRequests;

    @VisibleForTesting
    final Deque<TakePictureRequest> mNewRequests = new ArrayDeque();
    boolean mPaused = false;

    public static /* synthetic */ void a(TakePictureManager takePictureManager) {
        takePictureManager.mCapturingRequest = null;
        takePictureManager.issueNextRequest();
    }

    @NonNull
    @VisibleForTesting
    public ImagePipeline getImagePipeline() {
        return this.mImagePipeline;
    }

    @VisibleForTesting
    List<RequestWithCallback> getIncompleteRequests() {
        return this.mIncompleteRequests;
    }

    @VisibleForTesting
    boolean hasCapturingRequest() {
        return this.mCapturingRequest != null;
    }

    @MainThread
    public TakePictureManager(@NonNull ImageCaptureControl imageCaptureControl) {
        Threads.checkMainThread();
        this.mImageCaptureControl = imageCaptureControl;
        this.mIncompleteRequests = new ArrayList();
    }

    @MainThread
    private ListenableFuture<Void> submitCameraRequest(@NonNull final CameraRequest cameraRequest) {
        Threads.checkMainThread();
        this.mImageCaptureControl.lockFlashMode();
        ListenableFuture<Void> submitStillCaptureRequests = this.mImageCaptureControl.submitStillCaptureRequests(cameraRequest.getCaptureConfigs());
        Futures.addCallback(submitStillCaptureRequests, new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.TakePictureManager.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                if (cameraRequest.isAborted()) {
                    return;
                }
                if (th instanceof ImageCaptureException) {
                    TakePictureManager.this.mImagePipeline.notifyCaptureError((ImageCaptureException) th);
                } else {
                    TakePictureManager.this.mImagePipeline.notifyCaptureError(new ImageCaptureException(2, "Failed to submit capture request", th));
                }
                TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r12) {
                TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
            }
        }, CameraXExecutors.mainThreadExecutor());
        return submitStillCaptureRequests;
    }

    private void trackCurrentRequests(@NonNull final RequestWithCallback requestWithCallback) {
        Preconditions.checkState(!hasCapturingRequest());
        this.mCapturingRequest = requestWithCallback;
        requestWithCallback.getCaptureFuture().addListener(new Runnable() { // from class: androidx.camera.core.imagecapture.o
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureManager.a(TakePictureManager.this);
            }
        }, CameraXExecutors.directExecutor());
        this.mIncompleteRequests.add(requestWithCallback);
        requestWithCallback.getCompleteFuture().addListener(new Runnable() { // from class: androidx.camera.core.imagecapture.p
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureManager.this.mIncompleteRequests.remove(requestWithCallback);
            }
        }, CameraXExecutors.directExecutor());
    }

    @MainThread
    public void abortRequests() {
        Threads.checkMainThread();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", null);
        Iterator<TakePictureRequest> it = this.mNewRequests.iterator();
        while (it.hasNext()) {
            it.next().onError(imageCaptureException);
        }
        this.mNewRequests.clear();
        Iterator it2 = new ArrayList(this.mIncompleteRequests).iterator();
        while (it2.hasNext()) {
            ((RequestWithCallback) it2.next()).abortAndSendErrorToApp(imageCaptureException);
        }
    }

    @MainThread
    void issueNextRequest() {
        TakePictureRequest poll;
        Threads.checkMainThread();
        if (hasCapturingRequest() || this.mPaused || this.mImagePipeline.getCapacity() == 0 || (poll = this.mNewRequests.poll()) == null) {
            return;
        }
        RequestWithCallback requestWithCallback = new RequestWithCallback(poll, this);
        trackCurrentRequests(requestWithCallback);
        Pair<CameraRequest, ProcessingRequest> createRequests = this.mImagePipeline.createRequests(poll, requestWithCallback, requestWithCallback.getCaptureFuture());
        CameraRequest cameraRequest = createRequests.first;
        Objects.requireNonNull(cameraRequest);
        ProcessingRequest processingRequest = createRequests.second;
        Objects.requireNonNull(processingRequest);
        this.mImagePipeline.submitProcessingRequest(processingRequest);
        requestWithCallback.setCaptureRequestFuture(submitCameraRequest(cameraRequest));
    }

    @MainThread
    public void offerRequest(@NonNull TakePictureRequest takePictureRequest) {
        Threads.checkMainThread();
        this.mNewRequests.offer(takePictureRequest);
        issueNextRequest();
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(@NonNull ImageProxy imageProxy) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.q
            @Override // java.lang.Runnable
            public final void run() {
                TakePictureManager.this.issueNextRequest();
            }
        });
    }

    @MainThread
    public void pause() {
        Threads.checkMainThread();
        this.mPaused = true;
        RequestWithCallback requestWithCallback = this.mCapturingRequest;
        if (requestWithCallback != null) {
            requestWithCallback.abortSilentlyAndRetry();
        }
    }

    @MainThread
    public void resume() {
        Threads.checkMainThread();
        this.mPaused = false;
        issueNextRequest();
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest.RetryControl
    @MainThread
    public void retryRequest(@NonNull TakePictureRequest takePictureRequest) {
        Threads.checkMainThread();
        Logger.d(TAG, "Add a new request for retrying.");
        this.mNewRequests.addFirst(takePictureRequest);
        issueNextRequest();
    }

    @MainThread
    public void setImagePipeline(@NonNull ImagePipeline imagePipeline) {
        Threads.checkMainThread();
        this.mImagePipeline = imagePipeline;
        imagePipeline.setOnImageCloseListener(this);
    }
}
