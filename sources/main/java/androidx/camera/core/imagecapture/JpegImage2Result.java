package androidx.camera.core.imagecapture;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class JpegImage2Result implements Operation<Packet<ImageProxy>, ImageProxy> {
    @Override // androidx.camera.core.processing.Operation
    @NonNull
    public ImageProxy apply(@NonNull Packet<ImageProxy> packet) throws ImageCaptureException {
        ImageProxy data = packet.getData();
        SettableImageProxy settableImageProxy = new SettableImageProxy(data, packet.getSize(), ImmutableImageInfo.create(data.getImageInfo().getTagBundle(), data.getImageInfo().getTimestamp(), packet.getRotationDegrees(), packet.getSensorToBufferTransform()));
        settableImageProxy.setCropRect(packet.getCropRect());
        return settableImageProxy;
    }
}
