package androidx.camera.camera2.interop;

import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
@ExperimentalCamera2Interop
/* loaded from: D:\Downloads\app\classes.dex */
public final class Camera2CameraControl {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String TAG_KEY = "Camera2CameraControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    CallbackToFutureAdapter.Completer<Void> mCompleter;
    final Executor mExecutor;
    private boolean mIsActive = false;
    private boolean mPendingUpdate = false;
    final Object mLock = new Object();

    @GuardedBy("mLock")
    private Camera2ImplConfig.Builder mBuilder = new Camera2ImplConfig.Builder();
    private final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.interop.f
        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
            return Camera2CameraControl.e(Camera2CameraControl.this, totalCaptureResult);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void updateConfig(CallbackToFutureAdapter.Completer<Void> completer) {
        this.mPendingUpdate = true;
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mCompleter;
        if (completer2 == null) {
            completer2 = null;
        }
        this.mCompleter = completer;
        if (this.mIsActive) {
            updateSession();
        }
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    private void addCaptureRequestOptionsInternal(@NonNull CaptureRequestOptions captureRequestOptions) {
        synchronized (this.mLock) {
            try {
                for (Config.Option option : captureRequestOptions.listOptions()) {
                    this.mBuilder.getMutableConfig().insertOption(option, captureRequestOptions.retrieveOption(option));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ Object c(final Camera2CameraControl camera2CameraControl, final CallbackToFutureAdapter.Completer completer) {
        camera2CameraControl.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.interop.b
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.updateConfig(completer);
            }
        });
        return "addCaptureRequestOptions";
    }

    private void clearCaptureRequestOptionsInternal() {
        synchronized (this.mLock) {
            this.mBuilder = new Camera2ImplConfig.Builder();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ boolean e(androidx.camera.camera2.interop.Camera2CameraControl r2, android.hardware.camera2.TotalCaptureResult r3) {
        /*
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r2.mCompleter
            r1 = 0
            if (r0 == 0) goto L32
            android.hardware.camera2.CaptureRequest r3 = r3.getRequest()
            java.lang.Object r3 = r3.getTag()
            boolean r0 = r3 instanceof androidx.camera.core.impl.TagBundle
            if (r0 == 0) goto L32
            androidx.camera.core.impl.TagBundle r3 = (androidx.camera.core.impl.TagBundle) r3
            java.lang.String r0 = "Camera2CameraControl"
            java.lang.Object r3 = r3.getTag(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L32
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r0 = r2.mCompleter
            int r0 = r0.hashCode()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            androidx.concurrent.futures.CallbackToFutureAdapter$Completer<java.lang.Void> r3 = r2.mCompleter
            r2.mCompleter = r1
            goto L33
        L32:
            r3 = r1
        L33:
            if (r3 == 0) goto L38
            r3.set(r1)
        L38:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.interop.Camera2CameraControl.e(androidx.camera.camera2.interop.Camera2CameraControl, android.hardware.camera2.TotalCaptureResult):boolean");
    }

    public static /* synthetic */ Object f(final Camera2CameraControl camera2CameraControl, final CallbackToFutureAdapter.Completer completer) {
        camera2CameraControl.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.interop.d
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.updateConfig(completer);
            }
        });
        return "setCaptureRequestOptions";
    }

    @NonNull
    public static Camera2CameraControl from(@NonNull CameraControl cameraControl) {
        CameraControlInternal implementation = ((CameraControlInternal) cameraControl).getImplementation();
        Preconditions.checkArgument(implementation instanceof Camera2CameraControlImpl, "CameraControl doesn't contain Camera2 implementation.");
        return ((Camera2CameraControlImpl) implementation).getCamera2CameraControl();
    }

    public static /* synthetic */ Object h(final Camera2CameraControl camera2CameraControl, final CallbackToFutureAdapter.Completer completer) {
        camera2CameraControl.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.interop.h
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.updateConfig(completer);
            }
        });
        return "clearCaptureRequestOptions";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setActiveInternal(boolean z5) {
        if (this.mIsActive == z5) {
            return;
        }
        this.mIsActive = z5;
        if (z5) {
            if (this.mPendingUpdate) {
                updateSession();
            }
        } else {
            CallbackToFutureAdapter.Completer<Void> completer = this.mCompleter;
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("The camera control has became inactive."));
                this.mCompleter = null;
            }
        }
    }

    private void updateSession() {
        this.mCamera2CameraControlImpl.updateSessionConfig();
        this.mPendingUpdate = false;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2ImplConfig getCamera2ImplConfig() {
        Camera2ImplConfig build;
        synchronized (this.mLock) {
            try {
                if (this.mCompleter != null) {
                    this.mBuilder.getMutableConfig().insertOption(Camera2ImplConfig.CAPTURE_REQUEST_TAG_OPTION, Integer.valueOf(this.mCompleter.hashCode()));
                }
                build = this.mBuilder.build();
            } catch (Throwable th) {
                throw th;
            }
        }
        return build;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControlImpl.CaptureResultListener getCaptureRequestListener() {
        return this.mCaptureResultListener;
    }

    @NonNull
    public CaptureRequestOptions getCaptureRequestOptions() {
        CaptureRequestOptions build;
        synchronized (this.mLock) {
            build = CaptureRequestOptions.Builder.from(this.mBuilder.build()).build();
        }
        return build;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActive(final boolean z5) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.interop.c
            @Override // java.lang.Runnable
            public final void run() {
                Camera2CameraControl.this.setActiveInternal(z5);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Camera2CameraControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
    }

    @NonNull
    public ListenableFuture<Void> addCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.interop.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraControl.c(Camera2CameraControl.this, completer);
            }
        }));
    }

    @NonNull
    public ListenableFuture<Void> clearCaptureRequestOptions() {
        clearCaptureRequestOptionsInternal();
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.interop.g
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraControl.h(Camera2CameraControl.this, completer);
            }
        }));
    }

    @NonNull
    public ListenableFuture<Void> setCaptureRequestOptions(@NonNull CaptureRequestOptions captureRequestOptions) {
        clearCaptureRequestOptionsInternal();
        addCaptureRequestOptionsInternal(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.interop.e
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return Camera2CameraControl.f(Camera2CameraControl.this, completer);
            }
        }));
    }
}
