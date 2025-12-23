package com.kwad.sdk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bf {
    public static String ac(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        String hexString = al.toHexString(messageDigest.digest());
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        return hexString;
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return null;
        }
    }

    public static String hj(String str) {
        try {
            return al.toHexString(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return null;
        }
    }
}
