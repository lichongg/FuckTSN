package com.kwad.sdk.core.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static byte[] compress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                compress(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] decompress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                decompress(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            byteArrayInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return transform(bArr, bArr2, 1);
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        return transform(str.getBytes(UTF_8), bArr, 2);
    }

    private static byte[] transform(byte[] bArr, byte[] bArr2, int i6) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance(com.acse.ottn.f.f4513a);
            cipher.init(i6, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    private static void compress(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read != -1) {
                        gZIPOutputStream2.write(bArr, 0, read);
                    } else {
                        gZIPOutputStream2.finish();
                        gZIPOutputStream2.flush();
                        com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void decompress(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream2);
            throw th;
        }
    }
}
