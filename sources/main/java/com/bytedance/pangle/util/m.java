package com.bytedance.pangle.util;

import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class m {

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f25545j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String j(String str) {
        return j(str.getBytes());
    }

    private static String xt(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length << 1];
        int i6 = 0;
        for (byte b6 : bArr) {
            int i7 = i6 + 1;
            char[] cArr2 = f25545j;
            cArr[i6] = cArr2[(b6 >>> 4) & 15];
            i6 += 2;
            cArr[i7] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    public static String j(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                messageDigest.update(bArr);
                return xt(messageDigest.digest());
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String j(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 8192);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return xt(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
