package androidx.camera.core.processing;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.beizi.fusion.widget.TwistView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_DefaultSurfaceProcessor_PendingSnapshot extends DefaultSurfaceProcessor.PendingSnapshot {
    private final CallbackToFutureAdapter.Completer<Void> completer;
    private final int jpegQuality;
    private final int rotationDegrees;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DefaultSurfaceProcessor.PendingSnapshot) {
            DefaultSurfaceProcessor.PendingSnapshot pendingSnapshot = (DefaultSurfaceProcessor.PendingSnapshot) obj;
            if (this.jpegQuality == pendingSnapshot.getJpegQuality() && this.rotationDegrees == pendingSnapshot.getRotationDegrees() && this.completer.equals(pendingSnapshot.getCompleter())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.processing.DefaultSurfaceProcessor.PendingSnapshot
    @NonNull
    CallbackToFutureAdapter.Completer<Void> getCompleter() {
        return this.completer;
    }

    @Override // androidx.camera.core.processing.DefaultSurfaceProcessor.PendingSnapshot
    @IntRange(from = 0, to = TwistView.DELAY_TIME_TWIST)
    int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.processing.DefaultSurfaceProcessor.PendingSnapshot
    @IntRange(from = 0, to = 359)
    int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int hashCode() {
        return ((((this.jpegQuality ^ 1000003) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.completer.hashCode();
    }

    public String toString() {
        return "PendingSnapshot{jpegQuality=" + this.jpegQuality + ", rotationDegrees=" + this.rotationDegrees + ", completer=" + this.completer + "}";
    }

    AutoValue_DefaultSurfaceProcessor_PendingSnapshot(int i6, int i7, CallbackToFutureAdapter.Completer<Void> completer) {
        this.jpegQuality = i6;
        this.rotationDegrees = i7;
        if (completer != null) {
            this.completer = completer;
            return;
        }
        throw new NullPointerException("Null completer");
    }
}
