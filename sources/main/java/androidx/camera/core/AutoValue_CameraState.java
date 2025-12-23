package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_CameraState extends CameraState {
    private final CameraState.StateError error;
    private final CameraState.Type type;

    public boolean equals(Object obj) {
        CameraState.StateError stateError;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CameraState) {
            CameraState cameraState = (CameraState) obj;
            if (this.type.equals(cameraState.getType()) && ((stateError = this.error) != null ? stateError.equals(cameraState.getError()) : cameraState.getError() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.CameraState
    @Nullable
    public CameraState.StateError getError() {
        return this.error;
    }

    @Override // androidx.camera.core.CameraState
    @NonNull
    public CameraState.Type getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        CameraState.StateError stateError = this.error;
        return hashCode ^ (stateError == null ? 0 : stateError.hashCode());
    }

    public String toString() {
        return "CameraState{type=" + this.type + ", error=" + this.error + "}";
    }

    AutoValue_CameraState(CameraState.Type type, @Nullable CameraState.StateError stateError) {
        if (type != null) {
            this.type = type;
            this.error = stateError;
            return;
        }
        throw new NullPointerException("Null type");
    }
}
