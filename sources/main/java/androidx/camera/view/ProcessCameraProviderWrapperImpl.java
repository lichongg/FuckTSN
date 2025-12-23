package androidx.camera.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
class ProcessCameraProviderWrapperImpl implements ProcessCameraProviderWrapper {
    private final ProcessCameraProvider mProcessCameraProvider;

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    @NonNull
    public Camera bindToLifecycle(@NonNull LifecycleOwner lifecycleOwner, @NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup) {
        return this.mProcessCameraProvider.bindToLifecycle(lifecycleOwner, cameraSelector, useCaseGroup);
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public boolean hasCamera(@NonNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        return this.mProcessCameraProvider.hasCamera(cameraSelector);
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    @NonNull
    @VisibleForTesting
    public ListenableFuture<Void> shutdown() {
        return this.mProcessCameraProvider.shutdown();
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public void unbind(@NonNull UseCase... useCaseArr) {
        this.mProcessCameraProvider.unbind(useCaseArr);
    }

    @Override // androidx.camera.view.ProcessCameraProviderWrapper
    public void unbindAll() {
        this.mProcessCameraProvider.unbindAll();
    }

    ProcessCameraProviderWrapperImpl(ProcessCameraProvider processCameraProvider) {
        this.mProcessCameraProvider = processCameraProvider;
    }
}
