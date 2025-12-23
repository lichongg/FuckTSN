package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class at {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i6 = 0; i6 < bArr.length; i6++) {
                bArr[i6] = (byte) ((bArr[i6] ^ bArr2[i6 % bArr2.length]) ^ (i6 & 255));
            }
        }
        return bArr;
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = null;
        try {
            GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream2.read(bArr2);
                    if (read == -1) {
                        ap.a(gZIPInputStream2);
                        return;
                    }
                    outputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream = gZIPInputStream2;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "unGzip error: " + th.getMessage());
                } finally {
                    ap.a(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream2.write(bArr);
                ap.a(gZIPOutputStream2);
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "gzip error: " + th.getMessage());
                } finally {
                    ap.a(gZIPOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
