package androidx.camera.core.processing;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_SurfaceProcessorNode_OutConfig extends SurfaceProcessorNode.OutConfig {
    private final Rect cropRect;
    private final int format;
    private final boolean mirroring;
    private final int rotationDegrees;
    private final Size size;
    private final int targets;
    private final UUID uuid;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceProcessorNode.OutConfig) {
            SurfaceProcessorNode.OutConfig outConfig = (SurfaceProcessorNode.OutConfig) obj;
            if (this.uuid.equals(outConfig.getUuid()) && this.targets == outConfig.getTargets() && this.format == outConfig.getFormat() && this.cropRect.equals(outConfig.getCropRect()) && this.size.equals(outConfig.getSize()) && this.rotationDegrees == outConfig.getRotationDegrees() && this.mirroring == outConfig.getMirroring()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    @NonNull
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    public int getFormat() {
        return this.format;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    public boolean getMirroring() {
        return this.mirroring;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    @NonNull
    public Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    public int getTargets() {
        return this.targets;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.OutConfig
    @NonNull
    UUID getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return ((((((((((((this.uuid.hashCode() ^ 1000003) * 1000003) ^ this.targets) * 1000003) ^ this.format) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.size.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ (this.mirroring ? 1231 : 1237);
    }

    public String toString() {
        return "OutConfig{uuid=" + this.uuid + ", targets=" + this.targets + ", format=" + this.format + ", cropRect=" + this.cropRect + ", size=" + this.size + ", rotationDegrees=" + this.rotationDegrees + ", mirroring=" + this.mirroring + "}";
    }

    AutoValue_SurfaceProcessorNode_OutConfig(UUID uuid, int i6, int i7, Rect rect, Size size, int i8, boolean z5) {
        if (uuid != null) {
            this.uuid = uuid;
            this.targets = i6;
            this.format = i7;
            if (rect != null) {
                this.cropRect = rect;
                if (size != null) {
                    this.size = size;
                    this.rotationDegrees = i8;
                    this.mirroring = z5;
                    return;
                }
                throw new NullPointerException("Null size");
            }
            throw new NullPointerException("Null cropRect");
        }
        throw new NullPointerException("Null uuid");
    }
}
