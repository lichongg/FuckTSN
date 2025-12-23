package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class LifecycleCameraController extends CameraController {
    private static final String TAG = "CamLifecycleController";

    @Nullable
    private LifecycleOwner mLifecycleOwner;

    public LifecycleCameraController(@NonNull Context context) {
        super(context);
    }

    @VisibleForTesting
    LifecycleCameraController(@NonNull Context context, @NonNull ListenableFuture<ProcessCameraProviderWrapper> listenableFuture) {
        super(context, listenableFuture);
    }

    @VisibleForTesting
    void shutDownForTests() {
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.shutdown();
        }
    }

    @Override // androidx.camera.view.CameraController
    @Nullable
    @RequiresPermission("android.permission.CAMERA")
    Camera startCamera() {
        UseCaseGroup createUseCaseGroup;
        if (this.mLifecycleOwner == null || this.mCameraProvider == null || (createUseCaseGroup = createUseCaseGroup()) == null) {
            return null;
        }
        try {
            return this.mCameraProvider.bindToLifecycle(this.mLifecycleOwner, this.mCameraSelector, createUseCaseGroup);
        } catch (IllegalArgumentException e6) {
            throw new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", e6);
        }
    }

    @SuppressLint({"MissingPermission"})
    @MainThread
    public void bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner) {
        Threads.checkMainThread();
        this.mLifecycleOwner = lifecycleOwner;
        startCameraAndTrackStates();
    }

    @MainThread
    public void unbind() {
        Threads.checkMainThread();
        this.mLifecycleOwner = null;
        this.mCamera = null;
        ProcessCameraProviderWrapper processCameraProviderWrapper = this.mCameraProvider;
        if (processCameraProviderWrapper != null) {
            processCameraProviderWrapper.unbindAll();
        }
    }
}
