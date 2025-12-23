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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1021a = "RSAEncryptKS";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1022b = "AndroidKeyStore";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1023c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: d, reason: collision with root package name */
    private static final String f1024d = "";

    /* renamed from: e, reason: collision with root package name */
    private static final int f1025e = 2048;

    /* renamed from: f, reason: collision with root package name */
    private static final int f1026f = 3072;

    private static byte[] d(String str, byte[] bArr, boolean z5) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            g.d(f1021a, "alias or content is null");
            return bArr2;
        }
        if (!c()) {
            g.d(f1021a, "sdk version is too low");
            return bArr2;
        }
        PublicKey e6 = e(str, z5);
        if (e6 == null) {
            g.d(f1021a, "Public key is null");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f1023c);
            cipher.init(1, e6, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e7) {
            g.d(f1021a, "InvalidAlgorithmParameterException: " + e7.getMessage());
            return bArr2;
        } catch (InvalidKeyException e8) {
            g.d(f1021a, "InvalidKeyException: " + e8.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e9) {
            g.d(f1021a, "NoSuchAlgorithmException: " + e9.getMessage());
            return bArr2;
        } catch (BadPaddingException e10) {
            g.d(f1021a, "BadPaddingException: " + e10.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e11) {
            g.d(f1021a, "IllegalBlockSizeException: " + e11.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e12) {
            g.d(f1021a, "NoSuchPaddingException: " + e12.getMessage());
            return bArr2;
        } catch (Exception e13) {
            g.d(f1021a, "Exception: " + e13.getMessage());
            return bArr2;
        }
    }

    private static boolean f(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f1022b);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e6) {
            g.d(f1021a, "IOException: " + e6.getMessage());
            return false;
        } catch (KeyStoreException e7) {
            g.d(f1021a, "KeyStoreException: " + e7.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1021a, "NoSuchAlgorithmException: " + e8.getMessage());
            return false;
        } catch (UnrecoverableKeyException e9) {
            g.d(f1021a, "UnrecoverableKeyException: " + e9.getMessage());
            return false;
        } catch (CertificateException e10) {
            g.d(f1021a, "CertificateException: " + e10.getMessage());
            return false;
        } catch (Exception e11) {
            g.d(f1021a, "Exception: " + e11.getMessage());
            return false;
        }
    }

    private static Certificate g(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f1022b);
            keyStore.load(null);
            return keyStore.getCertificate(str);
        } catch (IOException e6) {
            g.d(f1021a, "IOException: " + e6.getMessage());
            return null;
        } catch (KeyStoreException e7) {
            g.d(f1021a, "KeyStoreException: " + e7.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1021a, "NoSuchAlgorithmException: " + e8.getMessage());
            return null;
        } catch (CertificateException e9) {
            g.d(f1021a, "CertificateException: " + e9.getMessage());
            return null;
        } catch (Exception e10) {
            g.d(f1021a, "Exception: " + e10.getMessage());
            return null;
        }
    }

    @Deprecated
    public static byte[] i(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            g.d(f1021a, "alias or encrypted content is null");
            return bArr2;
        }
        if (!c()) {
            g.d(f1021a, "sdk version is too low");
            return bArr2;
        }
        PrivateKey b6 = b(str);
        if (b6 == null) {
            g.d(f1021a, "Private key is null");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f1023c);
            cipher.init(2, b6, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e6) {
            g.d(f1021a, "InvalidAlgorithmParameterException: " + e6.getMessage());
            return bArr2;
        } catch (InvalidKeyException e7) {
            g.d(f1021a, "InvalidKeyException: " + e7.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1021a, "NoSuchAlgorithmException: " + e8.getMessage());
            return bArr2;
        } catch (BadPaddingException e9) {
            g.d(f1021a, "BadPaddingException: " + e9.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e10) {
            g.d(f1021a, "IllegalBlockSizeException: " + e10.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e11) {
            g.d(f1021a, "NoSuchPaddingException: " + e11.getMessage());
            return bArr2;
        } catch (Exception e12) {
            g.d(f1021a, "Exception: " + e12.getMessage());
            return bArr2;
        }
    }

    @Deprecated
    public static byte[] m(String str, byte[] bArr) {
        return d(str, bArr, false);
    }

    public static byte[] o(String str, byte[] bArr) {
        return d(str, bArr, true);
    }

    private static synchronized KeyPair a(String str, boolean z5) {
        KeyGenParameterSpec.Builder digests;
        KeyGenParameterSpec.Builder encryptionPaddings;
        KeyGenParameterSpec.Builder keySize;
        KeyGenParameterSpec build;
        KeyGenParameterSpec.Builder digests2;
        KeyGenParameterSpec.Builder encryptionPaddings2;
        KeyGenParameterSpec.Builder keySize2;
        KeyGenParameterSpec build2;
        synchronized (b.class) {
            KeyPair keyPair = null;
            if (f(str)) {
                g.d(f1021a, "Key pair exits");
                return null;
            }
            g.e(f1021a, "generate key pair.");
            try {
                try {
                    try {
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", f1022b);
                        if (z5) {
                            f.a();
                            digests = e.a(str, 2).setDigests("SHA-256", "SHA-512");
                            encryptionPaddings = digests.setEncryptionPaddings("OAEPPadding");
                            keySize = encryptionPaddings.setKeySize(f1026f);
                            build = keySize.build();
                            keyPairGenerator.initialize(build);
                        } else {
                            f.a();
                            digests2 = e.a(str, 2).setDigests("SHA-256", "SHA-512");
                            encryptionPaddings2 = digests2.setEncryptionPaddings("OAEPPadding");
                            keySize2 = encryptionPaddings2.setKeySize(2048);
                            build2 = keySize2.build();
                            keyPairGenerator.initialize(build2);
                        }
                        keyPair = keyPairGenerator.generateKeyPair();
                    } catch (InvalidAlgorithmParameterException e6) {
                        g.d(f1021a, "InvalidAlgorithmParameterException: " + e6.getMessage());
                    } catch (NoSuchProviderException e7) {
                        g.d(f1021a, "NoSuchProviderException: " + e7.getMessage());
                    }
                } catch (Exception e8) {
                    g.d(f1021a, "Exception: " + e8.getMessage());
                }
            } catch (NoSuchAlgorithmException e9) {
                g.d(f1021a, "NoSuchAlgorithmException: " + e9.getMessage());
            }
            return keyPair;
        }
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @Deprecated
    public static String h(String str, String str2) {
        try {
            return new String(i(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            g.d(f1021a, "UnsupportedEncodingException: " + e6.getMessage());
            return "";
        } catch (Exception e7) {
            g.d(f1021a, "Exception: " + e7.getMessage());
            return "";
        }
    }

    public static String j(String str, String str2) {
        try {
            return new String(k(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            g.d(f1021a, "UnsupportedEncodingException: " + e6.getMessage());
            return "";
        } catch (Exception e7) {
            g.d(f1021a, "Exception: " + e7.getMessage());
            return "";
        }
    }

    private static PrivateKey b(String str) {
        if (!f(str)) {
            return null;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(f1022b);
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey(str, null);
        } catch (IOException e6) {
            g.d(f1021a, "IOException: " + e6.getMessage());
            return null;
        } catch (KeyStoreException e7) {
            g.d(f1021a, "KeyStoreException: " + e7.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e8) {
            g.d(f1021a, "NoSuchAlgorithmException: " + e8.getMessage());
            return null;
        } catch (UnrecoverableKeyException e9) {
            g.d(f1021a, "UnrecoverableKeyException: " + e9.getMessage());
            return null;
        } catch (CertificateException e10) {
            g.d(f1021a, "CertificateException: " + e10.getMessage());
            return null;
        } catch (Exception e11) {
            g.d(f1021a, "Exception: " + e11.getMessage());
            return null;
        }
    }

    private static PublicKey e(String str, boolean z5) {
        if (!f(str)) {
            a(str, z5);
        }
        Certificate g6 = g(str);
        if (g6 != null) {
            return g6.getPublicKey();
        }
        return null;
    }

    public static byte[] k(String str, byte[] bArr) {
        return i(str, bArr);
    }

    @Deprecated
    public static String l(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                return Base64.encodeToString(m(str, str2.getBytes("UTF-8")), 0);
            } catch (UnsupportedEncodingException e6) {
                g.d(f1021a, "UnsupportedEncodingException: " + e6.getMessage());
                return "";
            }
        }
        return "";
    }

    public static String n(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                return Base64.encodeToString(o(str, str2.getBytes("UTF-8")), 0);
            } catch (UnsupportedEncodingException e6) {
                g.d(f1021a, "UnsupportedEncodingException: " + e6.getMessage());
                return "";
            }
        }
        return "";
    }
}
