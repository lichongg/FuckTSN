package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
final class JpegBytes2CroppedBitmap implements Operation<Packet<byte[]>, Packet<Bitmap>> {
    @NonNull
    private Bitmap createCroppedBitmap(@NonNull byte[] bArr, @NonNull Rect rect) throws ImageCaptureException {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (IOException e6) {
            throw new ImageCaptureException(1, "Failed to decode JPEG.", e6);
        }
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    public Packet<Bitmap> apply(@NonNull Packet<byte[]> packet) throws ImageCaptureException {
        Rect cropRect = packet.getCropRect();
        Bitmap createCroppedBitmap = createCroppedBitmap(packet.getData(), cropRect);
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        return Packet.of(createCroppedBitmap, exif, new Rect(0, 0, createCroppedBitmap.getWidth(), createCroppedBitmap.getHeight()), packet.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(packet.getSensorToBufferTransform(), cropRect), packet.getCameraCaptureResult());
    }

    JpegBytes2CroppedBitmap() {
    }
}
