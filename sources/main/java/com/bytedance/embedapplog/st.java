package com.bytedance.embedapplog;

import com.baidu.mobads.sdk.internal.by;
import java.security.MessageDigest;

/* loaded from: D:\Downloads\app\classes3.dex */
public class st {

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f24053j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String j(byte[] bArr) {
        if (bArr != null) {
            return j(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String xt(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                    messageDigest.update(bArr);
                    return j(messageDigest.digest());
                }
            } catch (Exception unused) {
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
                    char[] cArr2 = f24053j;
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
}
