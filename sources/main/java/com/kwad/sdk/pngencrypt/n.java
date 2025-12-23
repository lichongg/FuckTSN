package com.kwad.sdk.pngencrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class n {
    public static Charset aVp = Charset.forName(org.apache.commons.net.ftp.b.T);
    public static Charset aVq = Charset.forName("UTF-8");
    private static ThreadLocal<Boolean> aVr = new ThreadLocal<Boolean>() { // from class: com.kwad.sdk.pngencrypt.n.1
        private static Boolean Ou() {
            return Boolean.FALSE;
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Boolean initialValue() {
            return Ou();
        }
    };

    public static int e(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException unused) {
            return -1;
        }
    }

    public static int f(InputStream inputStream) {
        try {
            int read = inputStream.read();
            int read2 = inputStream.read();
            int read3 = inputStream.read();
            int read4 = inputStream.read();
            if (read != -1 && read2 != -1 && read3 != -1 && read4 != -1) {
                return (read << 24) | (read2 << 16) | ((read3 << 8) + read4);
            }
        } catch (IOException unused) {
        }
        return -1;
    }

    public static byte[] Ot() {
        return new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    static final int b(int i6, int i7, int i8) {
        int i9 = (i6 + i7) - i8;
        int i10 = i9 >= i6 ? i9 - i6 : i6 - i9;
        int i11 = i9 >= i7 ? i9 - i7 : i7 - i9;
        int i12 = i9 >= i8 ? i9 - i8 : i8 - i9;
        return (i10 > i11 || i10 > i12) ? i11 <= i12 ? i7 : i8 : i6;
    }

    public static int e(byte[] bArr, int i6) {
        return bArr[i6] & 255;
    }

    public static final int g(byte[] bArr, int i6) {
        return (bArr[i6 + 3] & 255) | ((bArr[i6] & 255) << 24) | ((bArr[i6 + 1] & 255) << 16) | ((bArr[i6 + 2] & 255) << 8);
    }

    public static int f(byte[] bArr, int i6) {
        return (bArr[i6 + 1] & 255) | ((bArr[i6] & 255) << 8);
    }
}
