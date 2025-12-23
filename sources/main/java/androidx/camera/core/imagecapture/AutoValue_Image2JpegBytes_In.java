package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.Image2JpegBytes;
import androidx.camera.core.processing.Packet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_Image2JpegBytes_In extends Image2JpegBytes.In {
    private final int jpegQuality;
    private final Packet<ImageProxy> packet;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Image2JpegBytes.In) {
            Image2JpegBytes.In in = (Image2JpegBytes.In) obj;
            if (this.packet.equals(in.getPacket()) && this.jpegQuality == in.getJpegQuality()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.In
    int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.Image2JpegBytes.In
    Packet<ImageProxy> getPacket() {
        return this.packet;
    }

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.jpegQuality;
    }

    public String toString() {
        return "In{packet=" + this.packet + ", jpegQuality=" + this.jpegQuality + "}";
    }

    AutoValue_Image2JpegBytes_In(Packet<ImageProxy> packet, int i6) {
        if (packet != null) {
            this.packet = packet;
            this.jpegQuality = i6;
            return;
        }
        throw new NullPointerException("Null packet");
    }
}
