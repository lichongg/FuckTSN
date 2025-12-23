package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_CaptureNode_Out extends CaptureNode.Out {
    private final Edge<ImageProxy> imageEdge;
    private final int inputFormat;
    private final int outputFormat;
    private final Edge<ProcessingRequest> requestEdge;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CaptureNode.Out) {
            CaptureNode.Out out = (CaptureNode.Out) obj;
            if (this.imageEdge.equals(out.getImageEdge()) && this.requestEdge.equals(out.getRequestEdge()) && this.inputFormat == out.getInputFormat() && this.outputFormat == out.getOutputFormat()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    Edge<ImageProxy> getImageEdge() {
        return this.imageEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    public int hashCode() {
        return ((((((this.imageEdge.hashCode() ^ 1000003) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat;
    }

    public String toString() {
        return "Out{imageEdge=" + this.imageEdge + ", requestEdge=" + this.requestEdge + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + "}";
    }

    AutoValue_CaptureNode_Out(Edge<ImageProxy> edge, Edge<ProcessingRequest> edge2, int i6, int i7) {
        if (edge != null) {
            this.imageEdge = edge;
            if (edge2 != null) {
                this.requestEdge = edge2;
                this.inputFormat = i6;
                this.outputFormat = i7;
                return;
            }
            throw new NullPointerException("Null requestEdge");
        }
        throw new NullPointerException("Null imageEdge");
    }
}
