package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class al {
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getFileMD5Digest(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance(com.baidu.mobads.sdk.internal.by.f10823a);
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
                        String hexString = toHexString(messageDigest.digest());
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

    public static String toHexString(byte[] bArr, int i6, int i7) {
        ax.checkNotNull(bArr);
        if (i7 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i8 = i7 * 2;
        char[] cArr = new char[i8];
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            byte b6 = bArr[i10];
            int i11 = i9 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i9] = cArr2[(b6 & 255) >> 4];
            i9 += 2;
            cArr[i11] = cArr2[b6 & 15];
        }
        return new String(cArr, 0, i8);
    }

    public static String md5ForByte(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.baidu.mobads.sdk.internal.by.f10823a);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = digest[i6];
                if (i7 < 0) {
                    i7 += 256;
                }
                if (i7 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i7));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String sha1(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return toHexString(digest, 0, digest.length);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return "";
        }
    }

    @NonNull
    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return md5ForByte(str.getBytes());
    }

    public static String toHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b6 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b6)));
        }
        return stringBuffer.toString();
    }

    public static String getFileMD5Digest(String str) {
        return getFileMD5Digest(new File(str));
    }
}
