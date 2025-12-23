package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ForwardingCameraControl implements CameraControlInternal {
    private final CameraControlInternal mCameraControlInternal;

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(@NonNull Config config) {
        this.mCameraControlInternal.addInteropConfig(config);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addZslConfig(@NonNull SessionConfig.Builder builder) {
        this.mCameraControlInternal.addZslConfig(builder);
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControlInternal.cancelFocusAndMetering();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
        this.mCameraControlInternal.clearInteropConfig();
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> enableTorch(boolean z5) {
        return this.mCameraControlInternal.enableTorch(z5);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public int getFlashMode() {
        return this.mCameraControlInternal.getFlashMode();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public CameraControlInternal getImplementation() {
        return this.mCameraControlInternal.getImplementation();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public Config getInteropConfig() {
        return this.mCameraControlInternal.getInteropConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public Rect getSensorRect() {
        return this.mCameraControlInternal.getSensorRect();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public SessionConfig getSessionConfig() {
        return this.mCameraControlInternal.getSessionConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isZslDisabledByByUserCaseConfig() {
        return this.mCameraControlInternal.isZslDisabledByByUserCaseConfig();
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Integer> setExposureCompensationIndex(int i6) {
        return this.mCameraControlInternal.setExposureCompensationIndex(i6);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int i6) {
        this.mCameraControlInternal.setFlashMode(i6);
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> setLinearZoom(float f6) {
        return this.mCameraControlInternal.setLinearZoom(f6);
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> setZoomRatio(float f6) {
        return this.mCameraControlInternal.setZoomRatio(f6);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setZslDisabledByUserCaseConfig(boolean z5) {
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(z5);
    }

    @Override // androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
        return this.mCameraControlInternal.startFocusAndMetering(focusMeteringAction);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public ListenableFuture<List<Void>> submitStillCaptureRequests(@NonNull List<CaptureConfig> list, int i6, int i7) {
        return this.mCameraControlInternal.submitStillCaptureRequests(list, i6, i7);
    }

    public ForwardingCameraControl(@NonNull CameraControlInternal cameraControlInternal) {
        this.mCameraControlInternal = cameraControlInternal;
    }
}
