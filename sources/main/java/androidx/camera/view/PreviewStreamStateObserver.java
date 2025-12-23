package androidx.camera.view;

import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class PreviewStreamStateObserver implements Observable.Observer<CameraInternal.State> {
    private static final String TAG = "StreamStateObserver";
    private final CameraInfoInternal mCameraInfoInternal;
    ListenableFuture<Void> mFlowFuture;
    private boolean mHasStartedPreviewStreamFlow = false;

    @GuardedBy("this")
    private PreviewView.StreamState mPreviewStreamState;
    private final MutableLiveData<PreviewView.StreamState> mPreviewStreamStateLiveData;
    private final PreviewViewImplementation mPreviewViewImplementation;

    void updatePreviewStreamState(PreviewView.StreamState streamState) {
        synchronized (this) {
            try {
                if (this.mPreviewStreamState.equals(streamState)) {
                    return;
                }
                this.mPreviewStreamState = streamState;
                Logger.d(TAG, "Update Preview stream state to " + streamState);
                this.mPreviewStreamStateLiveData.postValue(streamState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void cancelFlow() {
        ListenableFuture<Void> listenableFuture = this.mFlowFuture;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.mFlowFuture = null;
        }
    }

    @MainThread
    private void startPreviewStreamStateFlow(final CameraInfo cameraInfo) {
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
        final ArrayList arrayList = new ArrayList();
        FutureChain transform = FutureChain.from(waitForCaptureResult(cameraInfo, arrayList)).transformAsync(new AsyncFunction() { // from class: androidx.camera.view.m
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture waitForNextFrame;
                waitForNextFrame = PreviewStreamStateObserver.this.mPreviewViewImplementation.waitForNextFrame();
                return waitForNextFrame;
            }
        }, CameraXExecutors.directExecutor()).transform(new Function() { // from class: androidx.camera.view.n
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PreviewStreamStateObserver.c(PreviewStreamStateObserver.this, (Void) obj);
            }
        }, CameraXExecutors.directExecutor());
        this.mFlowFuture = transform;
        Futures.addCallback(transform, new FutureCallback<Void>() { // from class: androidx.camera.view.PreviewStreamStateObserver.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                PreviewStreamStateObserver.this.mFlowFuture = null;
                if (arrayList.isEmpty()) {
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((CameraInfoInternal) cameraInfo).removeSessionCaptureCallback((CameraCaptureCallback) it.next());
                }
                arrayList.clear();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r22) {
                PreviewStreamStateObserver.this.mFlowFuture = null;
            }
        }, CameraXExecutors.directExecutor());
    }

    private ListenableFuture<Void> waitForCaptureResult(final CameraInfo cameraInfo, final List<CameraCaptureCallback> list) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.l
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return PreviewStreamStateObserver.a(PreviewStreamStateObserver.this, cameraInfo, list, completer);
            }
        });
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    @MainThread
    public void onNewData(@Nullable CameraInternal.State state) {
        if (state == CameraInternal.State.CLOSING || state == CameraInternal.State.CLOSED || state == CameraInternal.State.RELEASING || state == CameraInternal.State.RELEASED) {
            updatePreviewStreamState(PreviewView.StreamState.IDLE);
            if (this.mHasStartedPreviewStreamFlow) {
                this.mHasStartedPreviewStreamFlow = false;
                cancelFlow();
                return;
            }
            return;
        }
        if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.mHasStartedPreviewStreamFlow) {
            startPreviewStreamStateFlow(this.mCameraInfoInternal);
            this.mHasStartedPreviewStreamFlow = true;
        }
    }

    PreviewStreamStateObserver(CameraInfoInternal cameraInfoInternal, MutableLiveData<PreviewView.StreamState> mutableLiveData, PreviewViewImplementation previewViewImplementation) {
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mPreviewStreamStateLiveData = mutableLiveData;
        this.mPreviewViewImplementation = previewViewImplementation;
        synchronized (this) {
            this.mPreviewStreamState = mutableLiveData.getValue();
        }
    }

    public static /* synthetic */ Object a(PreviewStreamStateObserver previewStreamStateObserver, final CameraInfo cameraInfo, List list, final CallbackToFutureAdapter.Completer completer) {
        previewStreamStateObserver.getClass();
        CameraCaptureCallback cameraCaptureCallback = new CameraCaptureCallback() { // from class: androidx.camera.view.PreviewStreamStateObserver.2
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                completer.set(null);
                ((CameraInfoInternal) cameraInfo).removeSessionCaptureCallback(this);
            }
        };
        list.add(cameraCaptureCallback);
        ((CameraInfoInternal) cameraInfo).addSessionCaptureCallback(CameraXExecutors.directExecutor(), cameraCaptureCallback);
        return "waitForCaptureResult";
    }

    public static /* synthetic */ Void c(PreviewStreamStateObserver previewStreamStateObserver, Void r12) {
        previewStreamStateObserver.getClass();
        previewStreamStateObserver.updatePreviewStreamState(PreviewView.StreamState.STREAMING);
        return null;
    }

    void clear() {
        cancelFlow();
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    @MainThread
    public void onError(@NonNull Throwable th) {
        clear();
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
    }
}
