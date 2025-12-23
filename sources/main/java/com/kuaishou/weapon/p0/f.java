package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f36040a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String a(byte b6) {
        int i6 = b6;
        if (b6 < 0) {
            i6 = b6 + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f36040a;
        sb.append(strArr[i6 / 16]);
        sb.append(strArr[i6 % 16]);
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return a(MessageDigest.getInstance(com.baidu.mobads.sdk.internal.by.f10823a).digest(bArr));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static byte[] d(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return MessageDigest.getInstance(com.baidu.mobads.sdk.internal.by.f10823a).digest(bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String c(byte[] bArr) {
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
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b6 : bArr) {
            stringBuffer.append(a(b6));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = new String(str);
            try {
                return a(MessageDigest.getInstance(com.baidu.mobads.sdk.internal.by.f10823a).digest(str2.getBytes()));
            } catch (Throwable unused) {
                return str2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(com.baidu.mobads.sdk.internal.by.f10823a);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String c6 = c(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    return c6;
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
            }
        }
        return null;
    }
}
