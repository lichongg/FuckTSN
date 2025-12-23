package cn.jiguang.az;

import android.util.Base64;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.security.MessageDigest;
import java.util.regex.Pattern;

/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1871a = cn.jiguang.ax.a.b(new byte[]{BinaryMemcacheOpcodes.SASL_AUTH, 1, 18, 42, 60, BinaryMemcacheOpcodes.GATK, 39, 7, 24, 32, 73, 84, 82, 116, 101, 95});

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static String d(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(i.f1869c);
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b6 : bArr) {
            a(stringBuffer, b6);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b6) {
        String str = f1871a;
        stringBuffer.append(str.charAt((b6 >> 4) & 15));
        stringBuffer.append(str.charAt(b6 & 15));
    }

    public static String b(String str) {
        if (c(str)) {
            return "";
        }
        return Pattern.compile("[^\\w#$@\\-一-龥]+").matcher(str).replaceAll("");
    }
}
