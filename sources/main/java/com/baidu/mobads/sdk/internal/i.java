package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import okio.Utf8;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f11037a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, 101, 116, 113, 83, 79};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f11038b = new byte[128];

    private static boolean d(String str) {
        if (str == null) {
            return true;
        }
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (!a((byte) str.charAt(i6))) {
                return true;
            }
        }
        return false;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i6 = 0;
        int i7 = 0;
        while (i6 < bytes.length) {
            byte[] bArr2 = f11037a;
            bArr[i7] = bArr2[(bytes[i6] & 252) >> 2];
            int i8 = i6 + 1;
            bArr[i7 + 1] = bArr2[((bytes[i6] & 3) << 4) + ((bytes[i8] & 240) >> 4)];
            int i9 = (bytes[i8] & 15) << 2;
            int i10 = i6 + 2;
            bArr[i7 + 2] = bArr2[i9 + ((bytes[i10] & 192) >> 6)];
            bArr[i7 + 3] = bArr2[bytes[i10] & Utf8.REPLACEMENT_BYTE];
            i6 += 3;
            i7 += 4;
        }
        return new String(bArr);
    }

    static {
        int i6 = 0;
        while (true) {
            byte[] bArr = f11037a;
            if (i6 >= bArr.length) {
                return;
            }
            f11038b[bArr[i6]] = (byte) i6;
            i6++;
        }
    }

    public static String b(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(c(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] c(String str) {
        byte[] bArr;
        if (d(str) || str == null || str.length() < 4) {
            return null;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
        } else if (str.charAt(str.length() - 1) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(str.length() / 4) * 3];
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < str.length() - 4) {
            byte[] bArr2 = f11038b;
            byte b6 = bArr2[str.charAt(i6)];
            byte b7 = bArr2[str.charAt(i6 + 1)];
            byte b8 = bArr2[str.charAt(i6 + 2)];
            byte b9 = bArr2[str.charAt(i6 + 3)];
            bArr[i7] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[i7 + 1] = (byte) ((b7 << 4) | (b8 >> 2));
            bArr[i7 + 2] = (byte) (b9 | (b8 << 6));
            i6 += 4;
            i7 += 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            byte[] bArr3 = f11038b;
            bArr[bArr.length - 1] = (byte) ((bArr3[str.charAt(str.length() - 3)] >> 4) | (bArr3[str.charAt(str.length() - 4)] << 2));
            return bArr;
        }
        if (str.charAt(str.length() - 1) == '$') {
            byte[] bArr4 = f11038b;
            byte b10 = bArr4[str.charAt(str.length() - 4)];
            byte b11 = bArr4[str.charAt(str.length() - 3)];
            byte b12 = bArr4[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b10 << 2) | (b11 >> 4));
            bArr[bArr.length - 1] = (byte) ((b12 >> 2) | (b11 << 4));
            return bArr;
        }
        byte[] bArr5 = f11038b;
        byte b13 = bArr5[str.charAt(str.length() - 4)];
        byte b14 = bArr5[str.charAt(str.length() - 3)];
        byte b15 = bArr5[str.charAt(str.length() - 2)];
        byte b16 = bArr5[str.charAt(str.length() - 1)];
        bArr[bArr.length - 3] = (byte) ((b13 << 2) | (b14 >> 4));
        bArr[bArr.length - 2] = (byte) ((b14 << 4) | (b15 >> 2));
        bArr[bArr.length - 1] = (byte) (b16 | (b15 << 6));
        return bArr;
    }

    private static boolean a(byte b6) {
        if (b6 == 36) {
            return true;
        }
        return b6 >= 0 && b6 < 128 && f11038b[b6] != -1;
    }
}
