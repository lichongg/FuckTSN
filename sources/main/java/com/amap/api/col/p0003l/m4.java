package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.by;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m4 {
    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(q4.u("ETUQ1"));
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            String A = q4.A(messageDigest.digest());
                            try {
                                fileInputStream.close();
                                return A;
                            } catch (IOException e6) {
                                r5.e(e6, by.f10823a, "gfm");
                                return A;
                            }
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            r5.e(th, by.f10823a, "gfm");
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e7) {
                                    r5.e(e7, by.f10823a, "gfm");
                                }
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String b(byte[] bArr) {
        return q4.A(c(bArr, q4.u("ETUQ1")));
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return q4.A(f(str));
    }

    private static byte[] h(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(q4.u("ETUQ1"));
        messageDigest.update(q4.o(str));
        return messageDigest.digest();
    }

    public static byte[] c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            r5.e(th, by.f10823a, "gmb");
            return null;
        }
    }

    public static String e(String str) {
        return q4.D(g(str));
    }

    private static byte[] f(String str) {
        try {
            return h(str);
        } catch (Throwable th) {
            r5.e(th, by.f10823a, "gmb");
            return new byte[0];
        }
    }

    private static byte[] g(String str) {
        try {
            return h(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }
}
