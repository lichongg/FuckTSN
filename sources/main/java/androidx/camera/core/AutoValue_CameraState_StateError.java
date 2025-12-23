package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.camera.core.CameraState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_CameraState_StateError extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    public boolean equals(Object obj) {
        Throwable th;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CameraState.StateError) {
            CameraState.StateError stateError = (CameraState.StateError) obj;
            if (this.code == stateError.getCode() && ((th = this.cause) != null ? th.equals(stateError.getCause()) : stateError.getCause() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.CameraState.StateError
    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public int getCode() {
        return this.code;
    }

    public int hashCode() {
        int i6 = (this.code ^ 1000003) * 1000003;
        Throwable th = this.cause;
        return i6 ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    }

    AutoValue_CameraState_StateError(int i6, @Nullable Throwable th) {
        this.code = i6;
        this.cause = th;
    }
}
