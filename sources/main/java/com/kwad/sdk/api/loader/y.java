package com.kwad.sdk.api.loader;

import com.baidu.mobads.sdk.internal.by;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class y {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v9 */
    static String getFileMD5(File file) {
        Throwable th;
        ?? r7;
        Exception e6;
        DigestInputStream digestInputStream;
        MessageDigest messageDigest;
        try {
            try {
                messageDigest = MessageDigest.getInstance(by.f10823a);
                digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
            } catch (Exception e7) {
                e6 = e7;
                digestInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r7 = 0;
                b(r7);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b6 : digest) {
                    int i6 = b6 & 255;
                    if (i6 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i6));
                }
                String sb2 = sb.toString();
                b(digestInputStream);
                return sb2;
            } catch (Exception e8) {
                e6 = e8;
                e6.printStackTrace();
                b(digestInputStream);
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
            r7 = file;
            b(r7);
            throw th;
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
