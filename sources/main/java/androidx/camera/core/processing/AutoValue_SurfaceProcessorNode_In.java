package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_SurfaceProcessorNode_In extends SurfaceProcessorNode.In {
    private final List<SurfaceProcessorNode.OutConfig> outConfigs;
    private final SurfaceEdge surfaceEdge;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceProcessorNode.In) {
            SurfaceProcessorNode.In in = (SurfaceProcessorNode.In) obj;
            if (this.surfaceEdge.equals(in.getSurfaceEdge()) && this.outConfigs.equals(in.getOutConfigs())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.In
    @NonNull
    public List<SurfaceProcessorNode.OutConfig> getOutConfigs() {
        return this.outConfigs;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.In
    @NonNull
    public SurfaceEdge getSurfaceEdge() {
        return this.surfaceEdge;
    }

    public int hashCode() {
        return ((this.surfaceEdge.hashCode() ^ 1000003) * 1000003) ^ this.outConfigs.hashCode();
    }

    public String toString() {
        return "In{surfaceEdge=" + this.surfaceEdge + ", outConfigs=" + this.outConfigs + "}";
    }

    AutoValue_SurfaceProcessorNode_In(SurfaceEdge surfaceEdge, List<SurfaceProcessorNode.OutConfig> list) {
        if (surfaceEdge != null) {
            this.surfaceEdge = surfaceEdge;
            if (list != null) {
                this.outConfigs = list;
                return;
            }
            throw new NullPointerException("Null outConfigs");
        }
        throw new NullPointerException("Null surfaceEdge");
    }
}
