package r1;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f51981a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f51982b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    private static String b(String str, String str2) {
        String str3;
        String str4;
        try {
        } catch (UnsupportedEncodingException unused) {
            str3 = f51981a;
            str4 = "encrypt UnsupportedEncodingException";
        }
        try {
            return c(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException unused2) {
            str3 = f51981a;
            str4 = "encrypt NoSuchAlgorithmException";
            Logger.w(str3, str4);
            return null;
        }
    }

    public static String a(String str) {
        return b(str, "SHA-256");
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            String hexString = Integer.toHexString(b6 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i6 = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i7 = 0; i7 < str.length(); i7++) {
            String str2 = str.charAt(i7) + "";
            if (f51982b.matcher(str2).matches()) {
                if (i6 % 2 == 0) {
                    str2 = "*";
                }
                i6++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }
}
