package com.qq.e.comm.managers.plugin;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class c {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f36777c = {82, 83, 65, 47, 69, 67, 66, 47, 80, 75, 67, 83, 49, 80, 97, 100, 100, 105, 110, 103};

    /* renamed from: a, reason: collision with root package name */
    private PublicKey f36778a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f36779b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final c f36780a = new c(null);
    }

    private c() {
        boolean z5;
        try {
            this.f36778a = b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB");
            z5 = true;
        } catch (Throwable unused) {
            z5 = false;
        }
        this.f36779b = z5;
    }

    private String a(String str) {
        if (this.f36778a == null) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        try {
            Cipher cipher = Cipher.getInstance(new String(f36777c, "UTF-8"));
            cipher.init(2, this.f36778a);
            return new String(cipher.doFinal(decode), "UTF-8").trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    private PublicKey b(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static c a() {
        return b.f36780a;
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (this.f36779b) {
            return str2.equals(a(str));
        }
        return true;
    }

    public boolean a(String str, File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return a(str, d.a(file));
    }
}
