package com.huawei.secure.android.common.encrypt.aes;

import d2.g;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35104a = "CipherUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f35105b = "AES/GCM/NoPadding";

    /* renamed from: c, reason: collision with root package name */
    private static final String f35106c = "AES/CBC/PKCS5Padding";

    /* renamed from: d, reason: collision with root package name */
    private static final String f35107d = "AES";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35108e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final int f35109f = 16;

    /* renamed from: g, reason: collision with root package name */
    private static final int f35110g = 12;

    /* renamed from: h, reason: collision with root package name */
    private static final int f35111h = 16;

    private static Cipher c(byte[] bArr, byte[] bArr2, int i6, String str) {
        if (bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !b.x()) {
            g.d(f35104a, "gcm encrypt param is not right");
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f35107d);
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(i6, secretKeySpec, f35105b.equals(str) ? b.w(bArr2) : new IvParameterSpec(bArr2));
            return cipher;
        } catch (GeneralSecurityException e6) {
            g.d(f35104a, "GCM encrypt data error" + e6.getMessage());
            return null;
        }
    }

    public static Cipher f(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 2);
    }

    public static Cipher h(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 1);
    }

    public static Cipher l(byte[] bArr, byte[] bArr2) {
        return d(bArr, bArr2, 2);
    }

    public static Cipher n(byte[] bArr, byte[] bArr2) {
        return d(bArr, bArr2, 1);
    }

    public static int r(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher == null || bArr == null) {
            g.d(f35104a, "getEncryptCOntent: cipher is null or content is null");
            return -1;
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length, bArr2);
        } catch (BadPaddingException unused) {
            g.d(f35104a, "getContent: BadPaddingException");
            return -1;
        } catch (IllegalBlockSizeException unused2) {
            g.d(f35104a, "getContent: IllegalBlockSizeException");
            return -1;
        } catch (ShortBufferException unused3) {
            g.d(f35104a, "getContent: ShortBufferException");
            return -1;
        }
    }

    private static int a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }

    private static Cipher b(byte[] bArr, byte[] bArr2, int i6) {
        return c(bArr, bArr2, i6, f35106c);
    }

    private static Cipher d(byte[] bArr, byte[] bArr2, int i6) {
        return c(bArr, bArr2, i6, f35105b);
    }

    public static Cipher g(byte[] bArr) {
        return h(bArr, d2.b.d(16));
    }

    public static int i(byte[] bArr, byte[] bArr2) {
        return j(bArr, bArr2, d2.b.d(16));
    }

    public static Cipher m(byte[] bArr) {
        byte[] d6 = d2.b.d(12);
        g.b(f35104a, "getEncryptCipher: iv is : " + d2.c.b(d6));
        return n(bArr, d6);
    }

    public static int o(byte[] bArr, byte[] bArr2) {
        return p(bArr, bArr2, d2.b.d(12));
    }

    public static int q(Cipher cipher, byte[] bArr, int i6, int i7, byte[] bArr2, int i8) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (cipher != null && bArr != null) {
            return cipher.doFinal(bArr, i6, i7, bArr2, i8);
        }
        g.d(f35104a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static byte[] s(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            g.d(f35104a, "getEncryptCOntent: cipher is null or content is null");
            return new byte[0];
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length);
        } catch (BadPaddingException unused) {
            g.d(f35104a, "getContent: BadPaddingException");
            return new byte[0];
        } catch (IllegalBlockSizeException unused2) {
            g.d(f35104a, "getContent: IllegalBlockSizeException");
            return new byte[0];
        }
    }

    public static Cipher e(byte[] bArr, Cipher cipher) {
        return f(bArr, cipher.getIV());
    }

    public static int j(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(h(bArr2, bArr3), bArr);
    }

    public static Cipher k(byte[] bArr, Cipher cipher) {
        return l(bArr, cipher.getIV());
    }

    public static int p(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(n(bArr2, bArr3), bArr);
    }
}
