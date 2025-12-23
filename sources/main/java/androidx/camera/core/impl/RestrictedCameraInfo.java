package androidx.camera.core.impl;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ZoomState;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class RestrictedCameraInfo extends ForwardingCameraInfo {
    private final CameraInfoInternal mCameraInfo;
    private final RestrictedCameraControl mRestrictedCameraControl;

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    @NonNull
    public ExposureState getExposureState() {
        return !this.mRestrictedCameraControl.isOperationSupported(7) ? new ExposureState() { // from class: androidx.camera.core.impl.RestrictedCameraInfo.1
            @Override // androidx.camera.core.ExposureState
            public int getExposureCompensationIndex() {
                return 0;
            }

            @Override // androidx.camera.core.ExposureState
            public boolean isExposureCompensationSupported() {
                return false;
            }

            @Override // androidx.camera.core.ExposureState
            @NonNull
            public Range<Integer> getExposureCompensationRange() {
                return new Range<>(0, 0);
            }

            @Override // androidx.camera.core.ExposureState
            @NonNull
            public Rational getExposureCompensationStep() {
                return Rational.ZERO;
            }
        } : this.mCameraInfo.getExposureState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.impl.CameraInfoInternal
    @NonNull
    public CameraInfoInternal getImplementation() {
        return this.mCameraInfo;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    @NonNull
    public LiveData<Integer> getTorchState() {
        return !this.mRestrictedCameraControl.isOperationSupported(6) ? new MutableLiveData(0) : this.mCameraInfo.getTorchState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    @NonNull
    public LiveData<ZoomState> getZoomState() {
        return !this.mRestrictedCameraControl.isOperationSupported(0) ? new MutableLiveData(ImmutableZoomState.create(1.0f, 1.0f, 1.0f, 0.0f)) : this.mCameraInfo.getZoomState();
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public boolean hasFlashUnit() {
        if (this.mRestrictedCameraControl.isOperationSupported(5)) {
            return this.mCameraInfo.hasFlashUnit();
        }
        return false;
    }

    @Override // androidx.camera.core.impl.ForwardingCameraInfo, androidx.camera.core.CameraInfo
    public boolean isFocusMeteringSupported(@NonNull FocusMeteringAction focusMeteringAction) {
        if (this.mRestrictedCameraControl.getModifiedFocusMeteringAction(focusMeteringAction) == null) {
            return false;
        }
        return this.mCameraInfo.isFocusMeteringSupported(focusMeteringAction);
    }

    public RestrictedCameraInfo(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull RestrictedCameraControl restrictedCameraControl) {
        super(cameraInfoInternal);
        this.mCameraInfo = cameraInfoInternal;
        this.mRestrictedCameraControl = restrictedCameraControl;
    }
}
