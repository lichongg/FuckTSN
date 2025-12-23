package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ShowFirstParty
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class Hex {
    private static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final char[] zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @NonNull
    @KeepForSdk
    public static String bytesToStringLowercase(@NonNull byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i6 = 0;
        for (byte b6 : bArr) {
            char[] cArr2 = zzb;
            cArr[i6] = cArr2[(b6 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b6 & 15];
            i6 += 2;
        }
        return new String(cArr);
    }

    @NonNull
    @KeepForSdk
    public static String bytesToStringUppercase(@NonNull byte[] bArr) {
        return bytesToStringUppercase(bArr, false);
    }

    @NonNull
    @KeepForSdk
    public static String bytesToStringUppercase(@NonNull byte[] bArr, boolean z5) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i6 = 0; i6 < length && (!z5 || i6 != length - 1 || (bArr[i6] & 255) != 0); i6++) {
            char[] cArr = zza;
            sb.append(cArr[(bArr[i6] & 240) >>> 4]);
            sb.append(cArr[bArr[i6] & 15]);
        }
        return sb.toString();
    }

    @NonNull
    @KeepForSdk
    public static byte[] stringToBytes(@NonNull String str) throws IllegalArgumentException {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[length / 2];
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 2;
                bArr[i6 / 2] = (byte) Integer.parseInt(str.substring(i6, i7), 16);
                i6 = i7;
            }
            return bArr;
        }
        throw new IllegalArgumentException("Hex string has odd number of characters");
    }
}
