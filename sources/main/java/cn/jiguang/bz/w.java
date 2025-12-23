package cn.jiguang.bz;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.acse.ottn.l3;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f2791a = Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d{1,2})\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d{1,2})");

    /* renamed from: b, reason: collision with root package name */
    private static SimpleDateFormat f2792b = new SimpleDateFormat("HHH:mm:ss:SSS", Locale.ENGLISH);

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f2793c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f2794d;

    public static String a(String str, String str2) {
        try {
            if (f2793c == null) {
                f2793c = Class.forName("android.os.SystemProperties");
            }
            if (f2794d == null) {
                f2794d = f2793c.getMethod(l3.f4736f, String.class, String.class);
            }
            return (String) f2794d.invoke(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String b(String str) {
        return a(str) ? "" : Pattern.compile("[^\\w#$@\\-一-龥]+").matcher(str).replaceAll("");
    }

    public static String c(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance(v.f2786a).digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i6));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            cn.jiguang.bb.f.c("StringUtils", "Get SHash error");
            return "";
        }
    }

    public static String k(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(v.f2786a);
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

    public static String b(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance(v.f2787b).digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i6));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            cn.jiguang.bb.f.c("StringUtils", "Get SHash error");
            return "";
        }
    }

    public static byte[] c(String str) {
        try {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i6 = 0; i6 < charArray.length; i6++) {
                bArr[i6] = (byte) charArray[i6];
            }
            return MessageDigest.getInstance(v.f2786a).digest(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(v.f2786a);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i6 = 0; i6 < charArray.length; i6++) {
                bArr[i6] = (byte) charArray[i6];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                int i7 = b6 & 255;
                if (i7 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i7));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(v.f2786a).digest(str.getBytes("utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i6));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            cn.jiguang.bb.f.c("StringUtils", "Get hash error");
            return "";
        }
    }

    public static String m(String str) {
        return a(str, "");
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (String) jSONObject.get(next));
            }
        } catch (JSONException unused) {
        }
        return hashMap;
    }

    public static HashMap<String, Object> b(Bundle bundle) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (bundle != null) {
            try {
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(":");
        if (indexOf >= 0) {
            if (indexOf != str.lastIndexOf(":")) {
                return false;
            }
            str = str.substring(0, indexOf);
        }
        return f2791a.matcher(str).matches();
    }

    public static boolean g(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(":")) == -1 || str.lastIndexOf(":") == indexOf) {
            return false;
        }
        return true;
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("[\\x20-\\x7E]+").matcher(str).matches();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("([A-Fa-f0-9]{2}[-:]){5,}[A-Fa-f0-9]{2}").matcher(str).matches();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static byte[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            cn.jiguang.bb.f.m("StringUtils", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static String l(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return b(str.getBytes("utf-8"));
            } catch (Throwable unused) {
                return str;
            }
        }
        return str;
    }

    public static JSONObject a(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                try {
                    if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Boolean) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Long)) {
                        obj = obj instanceof Bundle ? a((Bundle) obj) : String.valueOf(obj);
                    }
                    jSONObject.put(str, obj);
                } catch (Exception unused) {
                }
            }
        }
        return jSONObject;
    }

    public static void a(Context context, List<String> list) {
        if (!b.e(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    private static void a(StringBuffer stringBuffer, byte b6) {
        stringBuffer.append("0123456789ABCDEF".charAt((b6 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b6 & 15));
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }
}
