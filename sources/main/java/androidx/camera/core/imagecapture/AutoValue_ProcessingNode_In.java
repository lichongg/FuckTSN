package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.processing.Edge;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_ProcessingNode_In extends ProcessingNode.In {
    private final Edge<ProcessingNode.InputPacket> edge;
    private final int inputFormat;
    private final int outputFormat;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProcessingNode.In) {
            ProcessingNode.In in = (ProcessingNode.In) obj;
            if (this.edge.equals(in.getEdge()) && this.inputFormat == in.getInputFormat() && this.outputFormat == in.getOutputFormat()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    Edge<ProcessingNode.InputPacket> getEdge() {
        return this.edge;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.ProcessingNode.In
    int getOutputFormat() {
        return this.outputFormat;
    }

    public int hashCode() {
        return ((((this.edge.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat;
    }

    public String toString() {
        return "In{edge=" + this.edge + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + "}";
    }

    AutoValue_ProcessingNode_In(Edge<ProcessingNode.InputPacket> edge, int i6, int i7) {
        if (edge != null) {
            this.edge = edge;
            this.inputFormat = i6;
            this.outputFormat = i7;
            return;
        }
        throw new NullPointerException("Null edge");
    }
}
