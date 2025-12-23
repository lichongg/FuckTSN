package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class RestrictedCameraControl extends ForwardingCameraControl {
    public static final int AE_REGION = 3;
    public static final int AF_REGION = 2;
    public static final int AUTO_FOCUS = 1;
    public static final int AWB_REGION = 4;
    public static final int EXPOSURE_COMPENSATION = 7;
    public static final int FLASH = 5;
    public static final int TORCH = 6;
    public static final int ZOOM = 0;
    private final CameraControlInternal mCameraControl;

    @Nullable
    @CameraOperation
    private volatile Set<Integer> mRestrictedCameraOperations;
    private volatile boolean mUseRestrictedCameraOperations;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public @interface CameraOperation {
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> enableTorch(boolean z5) {
        return !isOperationSupported(6) ? Futures.immediateFailedFuture(new IllegalStateException("Torch is not supported")) : this.mCameraControl.enableTorch(z5);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Integer> setExposureCompensationIndex(int i6) {
        return !isOperationSupported(7) ? Futures.immediateFailedFuture(new IllegalStateException("ExposureCompensation is not supported")) : this.mCameraControl.setExposureCompensationIndex(i6);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> setLinearZoom(float f6) {
        return !isOperationSupported(0) ? Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported")) : this.mCameraControl.setLinearZoom(f6);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> setZoomRatio(float f6) {
        return !isOperationSupported(0) ? Futures.immediateFailedFuture(new IllegalStateException("Zoom is not supported")) : this.mCameraControl.setZoomRatio(f6);
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControl.cancelFocusAndMetering();
    }

    public void enableRestrictedOperations(boolean z5, @Nullable @CameraOperation Set<Integer> set) {
        this.mUseRestrictedCameraOperations = z5;
        this.mRestrictedCameraOperations = set;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.impl.CameraControlInternal
    @NonNull
    public CameraControlInternal getImplementation() {
        return this.mCameraControl;
    }

    @Nullable
    FocusMeteringAction getModifiedFocusMeteringAction(@NonNull FocusMeteringAction focusMeteringAction) {
        boolean z5;
        FocusMeteringAction.Builder builder = new FocusMeteringAction.Builder(focusMeteringAction);
        boolean z6 = true;
        if (focusMeteringAction.getMeteringPointsAf().isEmpty() || isOperationSupported(1, 2)) {
            z5 = false;
        } else {
            builder.removePoints(1);
            z5 = true;
        }
        if (!focusMeteringAction.getMeteringPointsAe().isEmpty() && !isOperationSupported(3)) {
            builder.removePoints(2);
            z5 = true;
        }
        if (focusMeteringAction.getMeteringPointsAwb().isEmpty() || isOperationSupported(4)) {
            z6 = z5;
        } else {
            builder.removePoints(4);
        }
        if (!z6) {
            return focusMeteringAction;
        }
        FocusMeteringAction build = builder.build();
        if (build.getMeteringPointsAf().isEmpty() && build.getMeteringPointsAe().isEmpty() && build.getMeteringPointsAwb().isEmpty()) {
            return null;
        }
        return builder.build();
    }

    boolean isOperationSupported(@NonNull @CameraOperation int... iArr) {
        if (!this.mUseRestrictedCameraOperations || this.mRestrictedCameraOperations == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i6 : iArr) {
            arrayList.add(Integer.valueOf(i6));
        }
        return this.mRestrictedCameraOperations.containsAll(arrayList);
    }

    public RestrictedCameraControl(@NonNull CameraControlInternal cameraControlInternal) {
        super(cameraControlInternal);
        this.mUseRestrictedCameraOperations = false;
        this.mCameraControl = cameraControlInternal;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraControl, androidx.camera.core.CameraControl
    @NonNull
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction) {
        FocusMeteringAction modifiedFocusMeteringAction = getModifiedFocusMeteringAction(focusMeteringAction);
        if (modifiedFocusMeteringAction == null) {
            return Futures.immediateFailedFuture(new IllegalStateException("FocusMetering is not supported"));
        }
        return this.mCameraControl.startFocusAndMetering(modifiedFocusMeteringAction);
    }
}
