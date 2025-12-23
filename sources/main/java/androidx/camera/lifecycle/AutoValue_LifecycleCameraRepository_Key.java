package androidx.camera.lifecycle;

import androidx.annotation.NonNull;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_LifecycleCameraRepository_Key extends LifecycleCameraRepository.Key {
    private final CameraUseCaseAdapter.CameraId cameraId;
    private final LifecycleOwner lifecycleOwner;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LifecycleCameraRepository.Key) {
            LifecycleCameraRepository.Key key = (LifecycleCameraRepository.Key) obj;
            if (this.lifecycleOwner.equals(key.getLifecycleOwner()) && this.cameraId.equals(key.getCameraId())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public CameraUseCaseAdapter.CameraId getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.lifecycle.LifecycleCameraRepository.Key
    @NonNull
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public int hashCode() {
        return ((this.lifecycleOwner.hashCode() ^ 1000003) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        return "Key{lifecycleOwner=" + this.lifecycleOwner + ", cameraId=" + this.cameraId + "}";
    }

    AutoValue_LifecycleCameraRepository_Key(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        if (lifecycleOwner != null) {
            this.lifecycleOwner = lifecycleOwner;
            if (cameraId != null) {
                this.cameraId = cameraId;
                return;
            }
            throw new NullPointerException("Null cameraId");
        }
        throw new NullPointerException("Null lifecycleOwner");
    }
}
