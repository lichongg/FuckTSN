package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.ImageProcessorRequest;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
public class BitmapEffect implements Operation<Packet<Bitmap>, Packet<Bitmap>> {
    private final InternalImageProcessor mProcessor;

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    public Packet<Bitmap> apply(@NonNull Packet<Bitmap> packet) throws ImageCaptureException {
        ImageProxy outputImage = this.mProcessor.safeProcess(new ImageProcessorRequest(new RgbaImageProxy(packet), 1)).getOutputImage();
        Objects.requireNonNull(outputImage);
        Bitmap createBitmapFromPlane = ImageUtil.createBitmapFromPlane(outputImage.getPlanes(), outputImage.getWidth(), outputImage.getHeight());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        return Packet.of(createBitmapFromPlane, exif, packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult());
    }

    BitmapEffect(InternalImageProcessor internalImageProcessor) {
        this.mProcessor = internalImageProcessor;
    }
}
