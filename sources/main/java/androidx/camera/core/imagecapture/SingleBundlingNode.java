package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
class SingleBundlingNode implements BundlingNode {
    private ProcessingNode.In mOutputEdge;
    ProcessingRequest mPendingRequest;

    @Override // androidx.camera.core.processing.Node
    @NonNull
    public ProcessingNode.In transform(@NonNull CaptureNode.Out out) {
        out.getImageEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.m
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                SingleBundlingNode.this.matchImageWithRequest((ImageProxy) obj);
            }
        });
        out.getRequestEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.n
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                SingleBundlingNode.this.trackIncomingRequest((ProcessingRequest) obj);
            }
        });
        ProcessingNode.In of = ProcessingNode.In.of(out.getInputFormat(), out.getOutputFormat());
        this.mOutputEdge = of;
        return of;
    }

    SingleBundlingNode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void matchImageWithRequest(@NonNull ImageProxy imageProxy) {
        boolean z5;
        Threads.checkMainThread();
        boolean z6 = true;
        if (this.mPendingRequest != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mPendingRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        if (((Integer) tag).intValue() != this.mPendingRequest.getStageIds().get(0).intValue()) {
            z6 = false;
        }
        Preconditions.checkState(z6);
        this.mOutputEdge.getEdge().accept(ProcessingNode.InputPacket.of(this.mPendingRequest, imageProxy));
        this.mPendingRequest = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void trackIncomingRequest(@NonNull final ProcessingRequest processingRequest) {
        boolean z5;
        Threads.checkMainThread();
        boolean z6 = false;
        if (processingRequest.getStageIds().size() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5, "Cannot handle multi-image capture.");
        if (this.mPendingRequest == null) {
            z6 = true;
        }
        Preconditions.checkState(z6, "Already has an existing request.");
        this.mPendingRequest = processingRequest;
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.SingleBundlingNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r12) {
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest2 = processingRequest;
                SingleBundlingNode singleBundlingNode = SingleBundlingNode.this;
                if (processingRequest2 == singleBundlingNode.mPendingRequest) {
                    singleBundlingNode.mPendingRequest = null;
                }
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }
}
