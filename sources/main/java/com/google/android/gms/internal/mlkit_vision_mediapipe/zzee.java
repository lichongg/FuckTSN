package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzee {
    static {
        new zzed();
    }

    public static byte[] zza(InputStream inputStream) throws IOException {
        int i6;
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int highestOneBit = Integer.highestOneBit(0);
        int min = Math.min(8192, Math.max(128, highestOneBit + highestOneBit));
        int i7 = 0;
        while (i7 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i7);
            byte[] bArr = new byte[min2];
            arrayDeque.add(bArr);
            int i8 = 0;
            while (i8 < min2) {
                int read = inputStream.read(bArr, i8, min2 - i8);
                if (read == -1) {
                    return zzb(arrayDeque, i7);
                }
                i8 += read;
                i7 += read;
            }
            if (min < 4096) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            long j6 = min * i6;
            if (j6 > 2147483647L) {
                min = Integer.MAX_VALUE;
            } else if (j6 < -2147483648L) {
                min = Integer.MIN_VALUE;
            } else {
                min = (int) j6;
            }
        }
        if (inputStream.read() == -1) {
            return zzb(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zzb(Queue queue, int i6) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i6) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i6);
        int i7 = i6 - length;
        while (i7 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(i7, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i6 - i7, min);
            i7 -= min;
        }
        return copyOf;
    }
}
