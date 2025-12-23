package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.StateObservable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_StateObservable_ErrorWrapper extends StateObservable.ErrorWrapper {
    private final Throwable error;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StateObservable.ErrorWrapper) {
            return this.error.equals(((StateObservable.ErrorWrapper) obj).getError());
        }
        return false;
    }

    @Override // androidx.camera.core.impl.StateObservable.ErrorWrapper
    @NonNull
    public Throwable getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.error + "}";
    }

    AutoValue_StateObservable_ErrorWrapper(Throwable th) {
        if (th != null) {
            this.error = th;
            return;
        }
        throw new NullPointerException("Null error");
    }
}
