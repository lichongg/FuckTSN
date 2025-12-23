package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);

        private final boolean mHoldsCameraSlot;

        boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }

        State(boolean z5) {
            this.mHoldsCameraSlot = z5;
        }
    }

    void attachUseCases(@NonNull Collection<UseCase> collection);

    void close();

    void detachUseCases(@NonNull Collection<UseCase> collection);

    @Override // androidx.camera.core.Camera
    @NonNull
    CameraControl getCameraControl();

    @NonNull
    CameraControlInternal getCameraControlInternal();

    @Override // androidx.camera.core.Camera
    @NonNull
    CameraInfo getCameraInfo();

    @NonNull
    CameraInfoInternal getCameraInfoInternal();

    @Override // androidx.camera.core.Camera
    @NonNull
    LinkedHashSet<CameraInternal> getCameraInternals();

    @NonNull
    Observable<State> getCameraState();

    @Override // androidx.camera.core.Camera
    @NonNull
    CameraConfig getExtendedConfig();

    boolean getHasTransform();

    boolean isFrontFacing();

    void open();

    @NonNull
    ListenableFuture<Void> release();

    void setActiveResumingMode(boolean z5);

    @Override // androidx.camera.core.Camera
    void setExtendedConfig(@Nullable CameraConfig cameraConfig);
}
