package b2;

import a2.e;
import a2.f;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import d2.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1027a = "RSASignKS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1028b = "AndroidKeyStore";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1029c = "SHA256withRSA/PSS";

    /* renamed from: d, reason: collision with root package name */
    private static final String f1030d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f1031e = 2048;

    /* renamed from: f, reason: collision with root package name */
    private static final int f1032f = 3072;

    private static boolean b(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f1028b);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e6) {
            g.d(f1027a, "IOException: " + e6.getMessage());
            return false;
        } catch (KeyStoreException e7) {
            g.d(f1027a, "KeyStoreException: " + e7.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1027a, "NoSuchAlgorithmException: " + e8.getMessage());
            return false;
        } catch (UnrecoverableKeyException e9) {
            g.d(f1027a, "UnrecoverableKeyException: " + e9.getMessage());
            return false;
        } catch (CertificateException e10) {
            g.d(f1027a, "CertificateException: " + e10.getMessage());
            return false;
        }
    }

    private static byte[] d(String str, byte[] bArr, boolean z5) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            g.d(f1027a, "alias or content is null");
            return bArr2;
        }
        if (!f()) {
            g.d(f1027a, "sdk version is too low");
            return bArr2;
        }
        KeyStore.Entry e6 = e(str, z5);
        if (!(e6 instanceof KeyStore.PrivateKeyEntry)) {
            g.d(f1027a, "Not an instance of a PrivateKeyEntry");
            return bArr2;
        }
        try {
            Signature signature = Signature.getInstance(f1029c);
            signature.initSign(((KeyStore.PrivateKeyEntry) e6).getPrivateKey());
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidKeyException e7) {
            g.d(f1027a, "InvalidKeyException: " + e7.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1027a, "NoSuchAlgorithmException: " + e8.getMessage());
            return bArr2;
        } catch (SignatureException e9) {
            g.d(f1027a, "SignatureException: " + e9.getMessage());
            return bArr2;
        } catch (Exception e10) {
            g.d(f1027a, "Exception: " + e10.getMessage());
            return bArr2;
        }
    }

    @Deprecated
    public static byte[] h(String str, byte[] bArr) {
        return d(str, bArr, false);
    }

    public static byte[] j(String str, byte[] bArr) {
        return d(str, bArr, true);
    }

    @Deprecated
    public static boolean k(String str, String str2, String str3) {
        try {
            return l(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e6) {
            e6.getMessage();
            return false;
        } catch (Exception e7) {
            g.d(f1027a, "base64 decode Exception" + e7.getMessage());
            return false;
        }
    }

    @Deprecated
    public static boolean l(String str, byte[] bArr, byte[] bArr2) {
        return c(str, bArr, bArr2, false);
    }

    public static boolean m(String str, String str2, String str3) {
        try {
            return n(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e6) {
            e6.getMessage();
            return false;
        } catch (Exception e7) {
            g.d(f1027a, "base64 decode Exception" + e7.getMessage());
            return false;
        }
    }

    public static boolean n(String str, byte[] bArr, byte[] bArr2) {
        return c(str, bArr, bArr2, true);
    }

    private static synchronized KeyPair a(String str, boolean z5) {
        KeyGenParameterSpec.Builder digests;
        KeyGenParameterSpec.Builder signaturePaddings;
        KeyGenParameterSpec.Builder keySize;
        KeyGenParameterSpec build;
        KeyGenParameterSpec.Builder digests2;
        KeyGenParameterSpec.Builder signaturePaddings2;
        KeyGenParameterSpec.Builder keySize2;
        KeyGenParameterSpec build2;
        synchronized (d.class) {
            KeyPair keyPair = null;
            if (b(str)) {
                g.d(f1027a, "Key pair exits");
                return null;
            }
            try {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", f1028b);
                    if (z5) {
                        f.a();
                        digests = e.a(str, 12).setDigests("SHA-256", "SHA-512");
                        signaturePaddings = digests.setSignaturePaddings("PSS");
                        keySize = signaturePaddings.setKeySize(f1032f);
                        build = keySize.build();
                        keyPairGenerator.initialize(build);
                    } else {
                        f.a();
                        digests2 = e.a(str, 12).setDigests("SHA-256", "SHA-512");
                        signaturePaddings2 = digests2.setSignaturePaddings("PSS");
                        keySize2 = signaturePaddings2.setKeySize(2048);
                        build2 = keySize2.build();
                        keyPairGenerator.initialize(build2);
                    }
                    keyPair = keyPairGenerator.generateKeyPair();
                } catch (NoSuchAlgorithmException e6) {
                    g.d(f1027a, "NoSuchAlgorithmException: " + e6.getMessage());
                } catch (NoSuchProviderException e7) {
                    g.d(f1027a, "NoSuchProviderException: " + e7.getMessage());
                }
            } catch (InvalidAlgorithmParameterException e8) {
                g.d(f1027a, "InvalidAlgorithmParameterException: " + e8.getMessage());
            }
            return keyPair;
        }
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @Deprecated
    public static String g(String str, String str2) {
        try {
            return Base64.encodeToString(h(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e6) {
            e6.getMessage();
            return "";
        }
    }

    public static String i(String str, String str2) {
        try {
            return Base64.encodeToString(j(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e6) {
            e6.getMessage();
            return "";
        }
    }

    private static boolean c(String str, byte[] bArr, byte[] bArr2, boolean z5) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr2 != null) {
            if (!f()) {
                g.d(f1027a, "sdk version is too low");
                return false;
            }
            KeyStore.Entry e6 = e(str, z5);
            if (!(e6 instanceof KeyStore.PrivateKeyEntry)) {
                g.d(f1027a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature signature = Signature.getInstance(f1029c);
                signature.initVerify(((KeyStore.PrivateKeyEntry) e6).getCertificate());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException e7) {
                g.d(f1027a, "InvalidKeyException: " + e7.getMessage());
                return false;
            } catch (NoSuchAlgorithmException e8) {
                g.d(f1027a, "NoSuchAlgorithmException: " + e8.getMessage());
                return false;
            } catch (SignatureException e9) {
                g.d(f1027a, "SignatureException: " + e9.getMessage());
                return false;
            } catch (Exception e10) {
                g.d(f1027a, "Exception: " + e10.getMessage());
                return false;
            }
        }
        g.d(f1027a, "alias or content or sign value is null");
        return false;
    }

    private static KeyStore.Entry e(String str, boolean z5) {
        if (!b(str)) {
            a(str, z5);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(f1028b);
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (IOException e6) {
            g.d(f1027a, "IOException: " + e6.getMessage());
            return null;
        } catch (KeyStoreException e7) {
            g.d(f1027a, "KeyStoreException: " + e7.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1027a, "NoSuchAlgorithmException: " + e8.getMessage());
            return null;
        } catch (UnrecoverableEntryException e9) {
            g.d(f1027a, "UnrecoverableEntryException: " + e9.getMessage());
            return null;
        } catch (CertificateException e10) {
            g.d(f1027a, "CertificateException: " + e10.getMessage());
            return null;
        }
    }
}
