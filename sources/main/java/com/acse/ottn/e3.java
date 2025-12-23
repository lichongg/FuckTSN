package com.acse.ottn;

import android.content.Context;
import com.baidu.mobads.sdk.internal.by;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e3 {

    /* renamed from: a, reason: collision with root package name */
    public char[] f4511a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String a(long j6) {
        float f6;
        String str;
        if (j6 >= 1000) {
            f6 = j6 / 1000;
            if (f6 >= 1000.0f) {
                f6 /= 1000.0f;
                str = "GHz";
            } else {
                str = "MHz";
            }
            if (f6 >= 1000.0f) {
                f6 /= 1000.0f;
                str = "THz";
            }
        } else {
            f6 = j6;
            str = "KHz";
        }
        return new DecimalFormat("#0.0").format(f6) + str;
    }

    public String b(long j6) {
        float f6;
        String str;
        if (j6 >= 1000) {
            f6 = j6 / 1000;
            if (f6 >= 1000.0f) {
                f6 /= 1000.0f;
                str = "MB";
            } else {
                str = "KB";
            }
            if (f6 >= 1000.0f) {
                f6 /= 1000.0f;
                str = "GB";
            }
        } else {
            f6 = j6;
            str = "B";
        }
        return new DecimalFormat("#0.0").format(f6) + str;
    }

    public static String c(String str) {
        if (str != null && str.length() != 0) {
            try {
                String str2 = "";
                for (byte b6 : MessageDigest.getInstance(by.f10823a).digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b6 & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str2 = str2 + hexString;
                }
                return str2.toLowerCase();
            } catch (NoSuchAlgorithmException e6) {
                e6.printStackTrace();
            }
        }
        return "";
    }

    public static boolean a(Context context, String str) {
        return context != null && context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public String b(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception unused) {
            System.out.getClass();
            return null;
        }
    }

    public static void a(String str) {
        c2.d("PgyerAnalytics", str);
    }

    public String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i6 = 0; i6 < bArr.length; i6++) {
            sb.append(this.f4511a[(bArr[i6] & 240) >>> 4]);
            sb.append(this.f4511a[bArr[i6] & 15]);
        }
        return sb.toString();
    }
}
