package com.bytedance.pangle.res.j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class r {
    public static <T> T j(T t5) {
        t5.getClass();
        return t5;
    }

    public static void j(InputStream inputStream, byte[] bArr) throws IOException {
        j(inputStream, bArr, 0, bArr.length);
    }

    public static void j(InputStream inputStream, byte[] bArr, int i6, int i7) throws IOException {
        int xt = xt(inputStream, bArr, i6, i7);
        if (xt == i7) {
            return;
        }
        throw new EOFException("reached end of stream after reading " + xt + " bytes; " + i7 + " bytes expected");
    }

    public static int xt(InputStream inputStream, byte[] bArr, int i6, int i7) throws IOException {
        j(inputStream);
        j(bArr);
        int i8 = 0;
        if (i7 >= 0) {
            j(i6, i6 + i7, bArr.length);
            while (i8 < i7) {
                int read = inputStream.read(bArr, i6 + i8, i7 - i8);
                if (read == -1) {
                    break;
                }
                i8 += read;
            }
            return i8;
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", Integer.valueOf(i7)));
    }

    public static void j(int i6, int i7, int i8) {
        if (i6 < 0 || i7 < i6 || i7 > i8) {
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            sb.append(i7);
            sb.append(i8);
            throw new IndexOutOfBoundsException(sb.toString());
        }
    }
}
