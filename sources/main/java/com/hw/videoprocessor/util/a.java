package com.hw.videoprocessor.util;

import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static void b(byte[] bArr) {
        float length = 1.0f / (bArr.length / 2.0f);
        float f6 = 0.0f;
        for (int i6 = 0; i6 < bArr.length; i6 += 2) {
            int i7 = i6 + 1;
            int i8 = (int) (((short) ((bArr[i6] & 255) | ((bArr[i7] & 255) << 8))) * f6);
            if (i8 > 32767) {
                i8 = 32767;
            } else if (i8 < -32768) {
                i8 = -32768;
            }
            bArr[i6] = (byte) (i8 & 255);
            bArr[i7] = (byte) ((i8 >>> 8) & 255);
            f6 += length;
        }
    }

    private static void c(byte[] bArr) {
        float f6 = 1.0f;
        float length = 1.0f / (bArr.length / 2.0f);
        for (int i6 = 0; i6 < bArr.length; i6 += 2) {
            int i7 = i6 + 1;
            int i8 = (int) (((short) ((bArr[i6] & 255) | ((bArr[i7] & 255) << 8))) * f6);
            if (i8 > 32767) {
                i8 = 32767;
            } else if (i8 < -32768) {
                i8 = -32768;
            }
            bArr[i6] = (byte) (i8 & 255);
            bArr[i7] = (byte) ((i8 >>> 8) & 255);
            f6 -= length;
        }
    }

    public static void a(String str, int i6, int i7, float f6, float f7) throws IOException {
        float f8 = ((i6 * 16) / 8) * i7;
        int i8 = (int) (f6 * f8);
        int i9 = (int) (f8 * f7);
        byte[] bArr = new byte[i8];
        byte[] bArr2 = new byte[i9];
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        randomAccessFile.read(bArr, 0, i8);
        long j6 = i9;
        randomAccessFile.seek((int) (randomAccessFile.length() - j6));
        randomAccessFile.read(bArr2, 0, i9);
        b(bArr);
        c(bArr2);
        randomAccessFile.seek(0L);
        randomAccessFile.write(bArr, 0, i8);
        randomAccessFile.seek((int) (randomAccessFile.length() - j6));
        randomAccessFile.write(bArr2, 0, i9);
        randomAccessFile.close();
    }
}
