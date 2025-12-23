package d2;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42977a = "EncryptUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f42978b = "RSA";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f42979c = true;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f42980d = true;

    /* JADX WARN: Removed duplicated region for block: B:19:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.SecureRandom a() {
        /*
            java.lang.String r0 = "generateSecureRandomNew "
            java.lang.String r1 = "EncryptUtil"
            d2.g.b(r1, r0)
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.NoSuchAlgorithmException -> L12
            r2 = 26
            if (r0 < r2) goto L17
            java.security.SecureRandom r0 = com.bytedance.sdk.component.tl.xt.m.a.a()     // Catch: java.security.NoSuchAlgorithmException -> L12
            goto L18
        L12:
            java.lang.String r0 = "getSecureRandomBytes: NoSuchAlgorithmException"
            d2.g.d(r1, r0)
        L17:
            r0 = 0
        L18:
            r2 = 0
            if (r0 != 0) goto L24
            java.lang.String r3 = "SHA1PRNG"
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r3)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            goto L24
        L22:
            r3 = move-exception
            goto L43
        L24:
            org.bouncycastle.crypto.engines.AESEngine r3 = new org.bouncycastle.crypto.engines.AESEngine     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r3.<init>()     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r4 = 32
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r0.nextBytes(r4)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r6 = 1
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r6 = 384(0x180, float:5.38E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = r5.setEntropyBitsRequired(r6)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r6 = 256(0x100, float:3.59E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandom r0 = r5.buildCTR(r3, r6, r4, r2)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            return r0
        L43:
            boolean r4 = d2.b.f42980d
            if (r4 == 0) goto L6c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "exception : "
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = " , you should implementation bcprov-jdk15on library"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            d2.g.d(r1, r3)
            d2.b.f42980d = r2
            goto L6c
        L67:
            java.lang.String r2 = "NoSuchAlgorithmException"
            d2.g.d(r1, r2)
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.b.a():java.security.SecureRandom");
    }

    public static SecureRandom c() {
        SecureRandom instanceStrong;
        if (f42979c) {
            return a();
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return SecureRandom.getInstance("SHA1PRNG");
            }
            instanceStrong = SecureRandom.getInstanceStrong();
            return instanceStrong;
        } catch (NoSuchAlgorithmException unused) {
            g.d(f42977a, "genSecureRandom: NoSuchAlgorithmException");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] d(int r3) {
        /*
            java.lang.String r0 = "EncryptUtil"
            boolean r1 = d2.b.f42979c
            if (r1 != 0) goto L4a
            byte[] r3 = new byte[r3]
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.NoSuchAlgorithmException -> L13
            r2 = 26
            if (r1 < r2) goto L18
            java.security.SecureRandom r1 = com.bytedance.sdk.component.tl.xt.m.a.a()     // Catch: java.security.NoSuchAlgorithmException -> L13
            goto L19
        L13:
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            d2.g.d(r0, r1)
        L18:
            r1 = 0
        L19:
            if (r1 != 0) goto L24
            java.lang.String r1 = "SHA1PRNG"
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstance(r1)     // Catch: java.lang.Exception -> L22 java.security.NoSuchAlgorithmException -> L41
            goto L24
        L22:
            r3 = move-exception
            goto L28
        L24:
            r1.nextBytes(r3)     // Catch: java.lang.Exception -> L22 java.security.NoSuchAlgorithmException -> L41
            return r3
        L28:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getSecureRandomBytes getInstance: exception : "
            r1.append(r2)
            java.lang.String r3 = r3.getMessage()
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            d2.g.d(r0, r3)
            goto L46
        L41:
            java.lang.String r3 = "getSecureRandomBytes getInstance: NoSuchAlgorithmException"
            d2.g.d(r0, r3)
        L46:
            r3 = 0
            byte[] r3 = new byte[r3]
            return r3
        L4a:
            byte[] r3 = b(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.b.d(int):byte[]");
    }

    public static PrivateKey f(String str) {
        try {
            try {
                return KeyFactory.getInstance(f42978b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e6) {
                g.d(f42977a, "load Key Exception:" + e6.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            g.d(f42977a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e7) {
            g.d(f42977a, "base64 decode Exception" + e7.getMessage());
            return null;
        }
    }

    public static RSAPublicKey g(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(f42978b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e6) {
                g.d(f42977a, "load Key Exception:" + e6.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            g.d(f42977a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e7) {
            g.d(f42977a, "base64 decode Exception" + e7.getMessage());
            return null;
        }
    }

    public static boolean h() {
        return f42979c;
    }

    public static void i(boolean z5) {
        g.e(f42977a, "setBouncycastleFlag: " + z5);
        f42979c = z5;
    }

    private static byte[] b(int i6) {
        SecureRandom a6 = a();
        if (a6 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i6];
        a6.nextBytes(bArr);
        return bArr;
    }

    public static String e(int i6) {
        return c.b(d(i6));
    }
}
