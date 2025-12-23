package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class WaitForRepeatingRequestStart {
    private final boolean mHasCaptureSessionStuckQuirk;
    private boolean mHasSubmittedRepeating;
    CallbackToFutureAdapter.Completer<Void> mStartStreamingCompleter;

    @NonNull
    private final ListenableFuture<Void> mStartStreamingFuture;
    private final Object mLock = new Object();
    private final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.1
        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i6) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.mStartStreamingCompleter;
            if (completer != null) {
                completer.setCancelled();
                WaitForRepeatingRequestStart.this.mStartStreamingCompleter = null;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j6, long j7) {
            CallbackToFutureAdapter.Completer<Void> completer = WaitForRepeatingRequestStart.this.mStartStreamingCompleter;
            if (completer != null) {
                completer.set(null);
                WaitForRepeatingRequestStart.this.mStartStreamingCompleter = null;
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @FunctionalInterface
    public interface OpenCaptureSession {
        @NonNull
        ListenableFuture<Void> run(@NonNull CameraDevice cameraDevice, @NonNull SessionConfigurationCompat sessionConfigurationCompat, @NonNull List<DeferrableSurface> list);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @FunctionalInterface
    public interface SingleRepeatingRequest {
        int run(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;
    }

    public static /* synthetic */ Object b(WaitForRepeatingRequestStart waitForRepeatingRequestStart, CallbackToFutureAdapter.Completer completer) {
        waitForRepeatingRequestStart.mStartStreamingCompleter = completer;
        return "WaitForRepeatingRequestStart[" + waitForRepeatingRequestStart + "]";
    }

    @NonNull
    public ListenableFuture<Void> getStartStreamFuture() {
        return Futures.nonCancellationPropagating(this.mStartStreamingFuture);
    }

    public void onSessionEnd() {
        synchronized (this.mLock) {
            try {
                if (shouldWaitRepeatingSubmit() && !this.mHasSubmittedRepeating) {
                    this.mStartStreamingFuture.cancel(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public ListenableFuture<Void> openCaptureSession(@NonNull final CameraDevice cameraDevice, @NonNull final SessionConfigurationCompat sessionConfigurationCompat, @NonNull final List<DeferrableSurface> list, @NonNull List<SynchronizedCaptureSession> list2, @NonNull final OpenCaptureSession openCaptureSession) {
        ArrayList arrayList = new ArrayList();
        Iterator<SynchronizedCaptureSession> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getOpeningBlocker());
        }
        return FutureChain.from(Futures.successfulAsList(arrayList)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.compat.workaround.c
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                ListenableFuture run;
                run = WaitForRepeatingRequestStart.OpenCaptureSession.this.run(cameraDevice, sessionConfigurationCompat, list);
                return run;
            }
        }, CameraXExecutors.directExecutor());
    }

    public int setSingleRepeatingRequest(@NonNull CaptureRequest captureRequest, @NonNull CameraCaptureSession.CaptureCallback captureCallback, @NonNull SingleRepeatingRequest singleRepeatingRequest) throws CameraAccessException {
        int run;
        synchronized (this.mLock) {
            try {
                if (shouldWaitRepeatingSubmit()) {
                    captureCallback = Camera2CaptureCallbacks.createComboCallback(this.mCaptureCallback, captureCallback);
                    this.mHasSubmittedRepeating = true;
                }
                run = singleRepeatingRequest.run(captureRequest, captureCallback);
            } catch (Throwable th) {
                throw th;
            }
        }
        return run;
    }

    public boolean shouldWaitRepeatingSubmit() {
        return this.mHasCaptureSessionStuckQuirk;
    }

    public WaitForRepeatingRequestStart(@NonNull Quirks quirks) {
        this.mHasCaptureSessionStuckQuirk = quirks.contains(CaptureSessionStuckQuirk.class);
        if (shouldWaitRepeatingSubmit()) {
            this.mStartStreamingFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.compat.workaround.b
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return WaitForRepeatingRequestStart.b(WaitForRepeatingRequestStart.this, completer);
                }
            });
        } else {
            this.mStartStreamingFuture = Futures.immediateFuture(null);
        }
    }
}
