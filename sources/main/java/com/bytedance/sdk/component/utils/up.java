package com.bytedance.sdk.component.utils;

import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f26901j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String j(byte[] bArr) {
        if (bArr != null) {
            return j(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String xt(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                    messageDigest.update(str.getBytes("UTF-8"));
                    return j(messageDigest.digest());
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String j(byte[] bArr, int i6, int i7) {
        if (bArr != null) {
            if (i6 >= 0 && i6 + i7 <= bArr.length) {
                int i8 = i7 * 2;
                char[] cArr = new char[i8];
                int i9 = 0;
                for (int i10 = 0; i10 < i7; i10++) {
                    byte b6 = bArr[i10 + i6];
                    int i11 = i9 + 1;
                    char[] cArr2 = f26901j;
                    cArr[i9] = cArr2[(b6 & 255) >> 4];
                    i9 += 2;
                    cArr[i11] = cArr2[b6 & 15];
                }
                return new String(cArr, 0, i8);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static byte[] j(String str) throws IllegalArgumentException {
        if (str != null && str.length() % 2 != 1) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            byte[] bArr = new byte[length / 2];
            for (int i6 = 0; i6 < length; i6 += 2) {
                bArr[i6 / 2] = (byte) ((Character.digit(charArray[i6], 16) << 4) + Character.digit(charArray[i6 + 1], 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("hexBinary needs to be even-length: ".concat(String.valueOf(str)));
    }

    public static String j(File file) {
        FileInputStream fileInputStream;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            if (messageDigest == null) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String j6 = j(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return j6;
            } catch (Throwable unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
        }
    }
}
