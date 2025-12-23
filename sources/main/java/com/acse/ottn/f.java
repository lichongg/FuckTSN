package com.acse.ottn;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ObjectStreamException;
import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4513a = "AES/ECB/PKCS5Padding";

    /* renamed from: b, reason: collision with root package name */
    public static f f4514b;

    public static f a() {
        if (f4514b == null) {
            synchronized (f.class) {
                try {
                    if (f4514b == null) {
                        f4514b = new f();
                    }
                } finally {
                }
            }
        }
        return f4514b;
    }

    public final Object b() throws ObjectStreamException {
        return f4514b;
    }

    public static byte[] c(String str, String str2) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance(f4513a);
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    public String b(String str, boolean z5) {
        String a6 = k0.a(z5);
        if (TextUtils.isEmpty(a6)) {
            return str;
        }
        try {
            return b(str, a6);
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public String a(String str, boolean z5) {
        String a6 = k0.a(z5);
        if (TextUtils.isEmpty(a6)) {
            return str;
        }
        try {
            return a(str, a6);
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public String b(String str, String str2) throws Exception {
        return a(c(str, str2));
    }

    public static String a(byte[] bArr, int i6) {
        return new BigInteger(1, bArr).toString(i6);
    }

    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    public static byte[] a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static String a(byte[] bArr, String str) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance(f4513a);
        cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"));
        return new String(cipher.doFinal(bArr));
    }

    public String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(a(jSONObject.getString("content")), str2);
        } catch (Exception e6) {
            e6.printStackTrace();
            return "";
        }
    }
}
