package androidx.camera.core.imagecapture;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.compat.workaround.JpegMetadataCorrector;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import com.google.auto.value.AutoValue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 21)
/* loaded from: D:\Downloads\app\classes.dex */
final class Image2JpegBytes implements Operation<In, Packet<byte[]>> {
    private final JpegMetadataCorrector mJpegMetadataCorrector;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class In {
        abstract int getJpegQuality();

        abstract Packet<ImageProxy> getPacket();

        @NonNull
        static In of(@NonNull Packet<ImageProxy> packet, int i6) {
            return new AutoValue_Image2JpegBytes_In(packet, i6);
        }

        In() {
        }
    }

    private static Exif extractExif(@NonNull byte[] bArr) throws ImageCaptureException {
        try {
            return Exif.createFromInputStream(new ByteArrayInputStream(bArr));
        } catch (IOException e6) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e6);
        }
    }

    @Override // androidx.camera.core.processing.Operation
    @NonNull
    public Packet<byte[]> apply(@NonNull In in) throws ImageCaptureException {
        Packet<byte[]> processYuvImage;
        try {
            int format = in.getPacket().getFormat();
            if (format == 35) {
                processYuvImage = processYuvImage(in);
            } else {
                if (format != 256) {
                    throw new IllegalArgumentException("Unexpected format: " + format);
                }
                processYuvImage = processJpegImage(in);
            }
            return processYuvImage;
        } finally {
            in.getPacket().getData().close();
        }
    }

    Image2JpegBytes(@NonNull Quirks quirks) {
        this.mJpegMetadataCorrector = new JpegMetadataCorrector(quirks);
    }

    private Packet<byte[]> processJpegImage(@NonNull In in) {
        Packet<ImageProxy> packet = in.getPacket();
        byte[] jpegImageToJpegByteArray = this.mJpegMetadataCorrector.jpegImageToJpegByteArray(packet.getData());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        return Packet.of(jpegImageToJpegByteArray, exif, 256, packet.getSize(), packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult());
    }

    private Packet<byte[]> processYuvImage(@NonNull In in) throws ImageCaptureException {
        Packet<ImageProxy> packet = in.getPacket();
        ImageProxy data = packet.getData();
        Rect cropRect = packet.getCropRect();
        try {
            byte[] yuvImageToJpegByteArray = ImageUtil.yuvImageToJpegByteArray(data, cropRect, in.getJpegQuality(), packet.getRotationDegrees());
            return Packet.of(yuvImageToJpegByteArray, extractExif(yuvImageToJpegByteArray), 256, new Size(cropRect.width(), cropRect.height()), new Rect(0, 0, cropRect.width(), cropRect.height()), packet.getRotationDegrees(), TransformUtils.updateSensorToBufferTransform(packet.getSensorToBufferTransform(), cropRect), packet.getCameraCaptureResult());
        } catch (ImageUtil.CodecFailedException e6) {
            throw new ImageCaptureException(1, "Failed to encode the image to JPEG.", e6);
        }
    }
}
