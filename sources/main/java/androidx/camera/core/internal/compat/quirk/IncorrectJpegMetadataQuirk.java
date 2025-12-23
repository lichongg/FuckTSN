package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public final class IncorrectJpegMetadataQuirk implements Quirk {
    private static final Set<String> SAMSUNG_DEVICES = new HashSet(Arrays.asList("A24"));

    private boolean canParseSosMarker(@NonNull byte[] bArr) {
        byte b6;
        int i6 = 2;
        while (i6 + 4 <= bArr.length && (b6 = bArr[i6]) == -1) {
            if (b6 == -1 && bArr[i6 + 1] == -38) {
                return true;
            }
            i6 += (((bArr[i6 + 2] & 255) << 8) | (bArr[i6 + 3] & 255)) + 2;
        }
        return false;
    }

    private int findSecondFfd8Position(@NonNull byte[] bArr) {
        int i6 = 2;
        while (true) {
            int i7 = i6 + 1;
            if (i7 > bArr.length) {
                return -1;
            }
            if (bArr[i6] == -1 && bArr[i7] == -40) {
                return i6;
            }
            i6 = i7;
        }
    }

    private static boolean isSamsungProblematicDevice() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && SAMSUNG_DEVICES.contains(Build.DEVICE.toUpperCase(Locale.US));
    }

    static boolean load() {
        return isSamsungProblematicDevice();
    }

    @NonNull
    public byte[] jpegImageToJpegByteArray(@NonNull ImageProxy imageProxy) {
        int i6 = 0;
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        if (!canParseSosMarker(bArr) && (i6 = findSecondFfd8Position(bArr)) == -1) {
            return bArr;
        }
        return Arrays.copyOfRange(bArr, i6, buffer.limit());
    }
}
