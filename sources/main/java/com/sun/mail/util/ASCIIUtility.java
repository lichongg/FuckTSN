package com.sun.mail.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ASCIIUtility {
    public static byte[] getBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            bArr[i6] = (byte) charArray[i6];
        }
        return bArr;
    }

    public static int parseInt(byte[] bArr, int i6, int i7, int i8) throws NumberFormatException {
        int i9;
        int i10;
        boolean z5;
        if (bArr == null) {
            throw new NumberFormatException("null");
        }
        if (i7 <= i6) {
            throw new NumberFormatException("illegal number");
        }
        int i11 = 0;
        if (bArr[i6] == 45) {
            i10 = i6 + 1;
            i9 = Integer.MIN_VALUE;
            z5 = true;
        } else {
            i9 = -2147483647;
            i10 = i6;
            z5 = false;
        }
        int i12 = i9 / i8;
        if (i10 < i7) {
            int i13 = i10 + 1;
            int digit = Character.digit((char) bArr[i10], i8);
            if (digit < 0) {
                throw new NumberFormatException("illegal number: " + toString(bArr, i6, i7));
            }
            i11 = -digit;
            i10 = i13;
        }
        while (i10 < i7) {
            int i14 = i10 + 1;
            int digit2 = Character.digit((char) bArr[i10], i8);
            if (digit2 < 0) {
                throw new NumberFormatException("illegal number");
            }
            if (i11 < i12) {
                throw new NumberFormatException("illegal number");
            }
            int i15 = i11 * i8;
            if (i15 < i9 + digit2) {
                throw new NumberFormatException("illegal number");
            }
            i11 = i15 - digit2;
            i10 = i14;
        }
        if (!z5) {
            return -i11;
        }
        if (i10 > i6 + 1) {
            return i11;
        }
        throw new NumberFormatException("illegal number");
    }

    public static long parseLong(byte[] bArr, int i6, int i7, int i8) throws NumberFormatException {
        long j6;
        int i9;
        boolean z5;
        long j7;
        if (bArr == null) {
            throw new NumberFormatException("null");
        }
        if (i7 <= i6) {
            throw new NumberFormatException("illegal number");
        }
        int i10 = 1;
        if (bArr[i6] == 45) {
            i9 = i6 + 1;
            j6 = Long.MIN_VALUE;
            z5 = true;
        } else {
            j6 = -9223372036854775807L;
            i9 = i6;
            z5 = false;
        }
        long j8 = i8;
        long j9 = j6 / j8;
        if (i9 < i7) {
            int i11 = i9 + 1;
            int digit = Character.digit((char) bArr[i9], i8);
            if (digit < 0) {
                throw new NumberFormatException("illegal number: " + toString(bArr, i6, i7));
            }
            j7 = -digit;
            i9 = i11;
        } else {
            j7 = 0;
        }
        while (i9 < i7) {
            int i12 = i9 + 1;
            int digit2 = Character.digit((char) bArr[i9], i8);
            if (digit2 < 0) {
                throw new NumberFormatException("illegal number");
            }
            if (j7 < j9) {
                throw new NumberFormatException("illegal number");
            }
            long j10 = j7 * j8;
            long j11 = j6;
            long j12 = digit2;
            if (j10 < j11 + j12) {
                throw new NumberFormatException("illegal number");
            }
            j7 = j10 - j12;
            i9 = i12;
            j6 = j11;
            i10 = 1;
        }
        if (!z5) {
            return -j7;
        }
        if (i9 > i6 + i10) {
            return j7;
        }
        throw new NumberFormatException("illegal number");
    }

    public static String toString(byte[] bArr, int i6, int i7) {
        int i8 = i7 - i6;
        char[] cArr = new char[i8];
        int i9 = 0;
        while (i9 < i8) {
            cArr[i9] = (char) (bArr[i6] & 255);
            i9++;
            i6++;
        }
        return new String(cArr);
    }

    private ASCIIUtility() {
    }

    public static String toString(ByteArrayInputStream byteArrayInputStream) {
        int available = byteArrayInputStream.available();
        char[] cArr = new char[available];
        byte[] bArr = new byte[available];
        byteArrayInputStream.read(bArr, 0, available);
        for (int i6 = 0; i6 < available; i6++) {
            cArr[i6] = (char) (bArr[i6] & 255);
        }
        return new String(cArr);
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr2, 0, 1024);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static int parseInt(byte[] bArr, int i6, int i7) throws NumberFormatException {
        return parseInt(bArr, i6, i7, 10);
    }

    public static long parseLong(byte[] bArr, int i6, int i7) throws NumberFormatException {
        return parseLong(bArr, i6, i7, 10);
    }
}
