package androidx.camera.core.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class InvalidJpegDataParser {
    private final boolean mHasQuirk;

    public int getValidDataLength(@NonNull byte[] bArr) {
        byte b6;
        if (!this.mHasQuirk) {
            return bArr.length;
        }
        int i6 = 2;
        while (i6 + 4 <= bArr.length && (b6 = bArr[i6]) == -1) {
            int i7 = i6 + 2;
            int i8 = ((bArr[i7] & 255) << 8) | (bArr[i6 + 3] & 255);
            if (b6 == -1 && bArr[i6 + 1] == -38) {
                while (true) {
                    int i9 = i7 + 2;
                    if (i9 > bArr.length) {
                        return bArr.length;
                    }
                    if (bArr[i7] == -1 && bArr[i7 + 1] == -39) {
                        return i9;
                    }
                    i7++;
                }
            } else {
                i6 += i8 + 2;
            }
        }
        return bArr.length;
    }

    public InvalidJpegDataParser() {
        boolean z5;
        if (DeviceQuirks.get(LargeJpegImageQuirk.class) != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mHasQuirk = z5;
    }
}
