package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_CaptureNode_In extends CaptureNode.In {
    private final Edge<ImageCaptureException> errorEdge;
    private final ImageReaderProxyProvider imageReaderProxyProvider;
    private final int inputFormat;
    private final int outputFormat;
    private final Edge<ProcessingRequest> requestEdge;
    private final Size size;
    private final boolean virtualCamera;

    public boolean equals(Object obj) {
        ImageReaderProxyProvider imageReaderProxyProvider;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CaptureNode.In) {
            CaptureNode.In in = (CaptureNode.In) obj;
            if (this.size.equals(in.getSize()) && this.inputFormat == in.getInputFormat() && this.outputFormat == in.getOutputFormat() && this.virtualCamera == in.isVirtualCamera() && ((imageReaderProxyProvider = this.imageReaderProxyProvider) != null ? imageReaderProxyProvider.equals(in.getImageReaderProxyProvider()) : in.getImageReaderProxyProvider() == null) && this.requestEdge.equals(in.getRequestEdge()) && this.errorEdge.equals(in.getErrorEdge())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    @NonNull
    Edge<ImageCaptureException> getErrorEdge() {
        return this.errorEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    @Nullable
    ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.imageReaderProxyProvider;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    int getInputFormat() {
        return this.inputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    int getOutputFormat() {
        return this.outputFormat;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    @NonNull
    Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    Size getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode = (((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.inputFormat) * 1000003) ^ this.outputFormat) * 1000003) ^ (this.virtualCamera ? 1231 : 1237)) * 1000003;
        ImageReaderProxyProvider imageReaderProxyProvider = this.imageReaderProxyProvider;
        return ((((hashCode ^ (imageReaderProxyProvider == null ? 0 : imageReaderProxyProvider.hashCode())) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.errorEdge.hashCode();
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    boolean isVirtualCamera() {
        return this.virtualCamera;
    }

    public String toString() {
        return "In{size=" + this.size + ", inputFormat=" + this.inputFormat + ", outputFormat=" + this.outputFormat + ", virtualCamera=" + this.virtualCamera + ", imageReaderProxyProvider=" + this.imageReaderProxyProvider + ", requestEdge=" + this.requestEdge + ", errorEdge=" + this.errorEdge + "}";
    }

    AutoValue_CaptureNode_In(Size size, int i6, int i7, boolean z5, @Nullable ImageReaderProxyProvider imageReaderProxyProvider, Edge<ProcessingRequest> edge, Edge<ImageCaptureException> edge2) {
        if (size != null) {
            this.size = size;
            this.inputFormat = i6;
            this.outputFormat = i7;
            this.virtualCamera = z5;
            this.imageReaderProxyProvider = imageReaderProxyProvider;
            if (edge != null) {
                this.requestEdge = edge;
                if (edge2 != null) {
                    this.errorEdge = edge2;
                    return;
                }
                throw new NullPointerException("Null errorEdge");
            }
            throw new NullPointerException("Null requestEdge");
        }
        throw new NullPointerException("Null size");
    }
}
