package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static final byte[] aVH = gy("IHDR");
    public static final byte[] aVI = gy("PLTE");
    public static final byte[] aVJ = gy("IDAT");
    public static final byte[] aVK = gy("IEND");
    private static byte[] aVL = new byte[4096];
    public static Pattern aVM = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static byte[] b(byte[] bArr, int i6, int i7, boolean z5) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream3;
        InflaterInputStream inflaterInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i6, i7);
            try {
                InflaterInputStream inflaterInputStream2 = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        g(inflaterInputStream2, byteArrayOutputStream2);
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        return byteArray;
                    } catch (Exception unused) {
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream3);
                        return new byte[0];
                    } catch (Throwable th) {
                        th = th;
                        inflaterInputStream = inflaterInputStream2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
                        com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    byteArrayOutputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception unused3) {
                byteArrayOutputStream3 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception unused4) {
            byteArrayOutputStream3 = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
    }

    public static boolean gA(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean gB(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static boolean gz(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static String i(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aVq);
    }

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static String c(byte[] bArr, int i6, int i7) {
        return new String(bArr, i6, i7, com.kwad.sdk.pngencrypt.n.aVp);
    }

    public static String d(byte[] bArr, int i6, int i7) {
        return new String(bArr, i6, i7, com.kwad.sdk.pngencrypt.n.aVq);
    }

    private static void g(InputStream inputStream, OutputStream outputStream) {
        synchronized (aVL) {
            while (true) {
                try {
                    int read = inputStream.read(aVL);
                    if (read > 0) {
                        outputStream.write(aVL, 0, read);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static byte[] gy(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.aVp);
    }

    public static String h(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.aVp);
    }

    public static String i(byte[] bArr, int i6) {
        return (bArr == null || bArr.length < 8) ? "?" : c(bArr, 4, 4);
    }
}
