package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public final class HexDumpUtils {
    @Nullable
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i6, int i7, boolean z5) {
        int length;
        if (bArr == null || (length = bArr.length) == 0 || i6 < 0 || i7 <= 0 || i6 + i7 > length) {
            return null;
        }
        StringBuilder sb = new StringBuilder((z5 ? 75 : 57) * ((i7 + 15) / 16));
        int i8 = i7;
        int i9 = 0;
        int i10 = 0;
        while (i8 > 0) {
            if (i9 == 0) {
                if (i7 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i6)));
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i6)));
                }
                i10 = i6;
            } else if (i9 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i6] & 255)));
            i8--;
            i9++;
            if (z5 && (i9 == 16 || i8 == 0)) {
                int i11 = 16 - i9;
                if (i11 > 0) {
                    for (int i12 = 0; i12 < i11; i12++) {
                        sb.append("   ");
                    }
                }
                if (i11 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i13 = 0; i13 < i9; i13++) {
                    char c6 = (char) bArr[i10 + i13];
                    if (c6 < ' ' || c6 > '~') {
                        c6 = '.';
                    }
                    sb.append(c6);
                }
            }
            if (i9 == 16 || i8 == 0) {
                sb.append('\n');
                i9 = 0;
            }
            i6++;
        }
        return sb.toString();
    }
}
