package com.kwad.sdk.utils;

import androidx.annotation.RequiresApi;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class q {
    public static void a(File[] fileArr, String str) {
        a(fileArr, str, -1);
    }

    @RequiresApi(api = 19)
    public static byte[] j(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        bArr2 = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                        return bArr2;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        return bArr2;
    }

    private static void a(File[] fileArr, String str, int i6) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                try {
                    byte[] bArr = new byte[4096];
                    int i7 = 0;
                    while (i7 < fileArr.length) {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileArr[i7]), 4096);
                        try {
                            String absolutePath = fileArr[i7].getAbsolutePath();
                            zipOutputStream.putNextEntry(new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream2.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                } else {
                                    zipOutputStream.write(bArr, 0, read);
                                }
                            }
                            bufferedInputStream2.close();
                            i7++;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e6) {
                            e = e6;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Exception e8) {
            e = e8;
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(zipOutputStream);
    }
}
