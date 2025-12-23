package com.baidu.liantian.b;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f10377a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String a(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = new String(str);
        } catch (Throwable unused) {
        }
        try {
            return d(MessageDigest.getInstance(by.f10823a).digest(str2.getBytes()));
        } catch (Throwable unused2) {
            str3 = str2;
            e.a();
            return str3;
        }
    }

    public static byte[] c(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return MessageDigest.getInstance(by.f10823a).digest(bArr);
            } catch (Throwable unused) {
                e.a();
            }
        }
        return null;
    }

    public static String b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                String upperCase = Integer.toHexString(b6 & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e6) {
            throw new RuntimeException(e6);
        }
    }

    private static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 : bArr) {
            if (i6 < 0) {
                i6 += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f10377a;
            sb.append(strArr[i6 / 16]);
            sb.append(strArr[i6 % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    private static String e(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i6 = 0; i6 < bArr.length; i6++) {
            byte b6 = bArr[i6];
            int i7 = i6 * 2;
            cArr2[i7] = cArr[(b6 >>> 4) & 15];
            cArr2[i7 + 1] = cArr[b6 & 15];
        }
        return new String(cArr2);
    }

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return d(MessageDigest.getInstance(by.f10823a).digest(bArr));
            } catch (Throwable unused) {
                e.a();
            }
        }
        return null;
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        String e6 = e(messageDigest.digest());
                        try {
                            fileInputStream.close();
                            return e6;
                        } catch (IOException unused) {
                            e.a();
                            return e6;
                        }
                    }
                }
            } catch (Throwable unused2) {
                try {
                    e.a();
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
        }
    }
}
