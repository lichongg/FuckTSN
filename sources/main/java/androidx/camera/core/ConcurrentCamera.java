package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ConcurrentCamera {

    @NonNull
    private List<Camera> mCameras;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class SingleCameraConfig {

        @NonNull
        private CameraSelector mCameraSelector;

        @NonNull
        private LifecycleOwner mLifecycleOwner;

        @NonNull
        private UseCaseGroup mUseCaseGroup;

        @NonNull
        public CameraSelector getCameraSelector() {
            return this.mCameraSelector;
        }

        @NonNull
        public LifecycleOwner getLifecycleOwner() {
            return this.mLifecycleOwner;
        }

        @NonNull
        public UseCaseGroup getUseCaseGroup() {
            return this.mUseCaseGroup;
        }

        public SingleCameraConfig(@NonNull CameraSelector cameraSelector, @NonNull UseCaseGroup useCaseGroup, @NonNull LifecycleOwner lifecycleOwner) {
            this.mCameraSelector = cameraSelector;
            this.mUseCaseGroup = useCaseGroup;
            this.mLifecycleOwner = lifecycleOwner;
        }
    }

    @NonNull
    public List<Camera> getCameras() {
        return this.mCameras;
    }

    public ConcurrentCamera(@NonNull List<Camera> list) {
        this.mCameras = list;
    }
}
