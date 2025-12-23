package androidx.camera.core.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class JpegMetadataCorrector {
    private final IncorrectJpegMetadataQuirk mQuirk;

    @NonNull
    public byte[] jpegImageToJpegByteArray(@NonNull ImageProxy imageProxy) {
        IncorrectJpegMetadataQuirk incorrectJpegMetadataQuirk = this.mQuirk;
        if (incorrectJpegMetadataQuirk != null) {
            return incorrectJpegMetadataQuirk.jpegImageToJpegByteArray(imageProxy);
        }
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return bArr;
    }

    public boolean needCorrectJpegMetadata() {
        return this.mQuirk != null;
    }

    public JpegMetadataCorrector(@NonNull Quirks quirks) {
        this.mQuirk = (IncorrectJpegMetadataQuirk) quirks.get(IncorrectJpegMetadataQuirk.class);
    }
}
