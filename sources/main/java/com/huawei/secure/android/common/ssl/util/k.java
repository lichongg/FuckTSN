package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    private static final String f35244b = "X509CertificateUtil";

    /* renamed from: c, reason: collision with root package name */
    public static final String f35245c = "hmsrootcas.bks";

    /* renamed from: d, reason: collision with root package name */
    public static final String f35246d = "";

    /* renamed from: e, reason: collision with root package name */
    public static final String f35247e = "bks";

    /* renamed from: f, reason: collision with root package name */
    public static final String f35248f = "052root";

    /* renamed from: g, reason: collision with root package name */
    private static final String f35249g = "hmsincas.bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f35250h = "huawei cbg application integration ca";

    /* renamed from: a, reason: collision with root package name */
    private Context f35251a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate b(String str, String str2) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(f35247e);
                inputStream = this.f35251a.getAssets().open(str);
            } catch (IOException e6) {
                e = e6;
                inputStream = null;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            } catch (KeyStoreException e7) {
                e = e7;
                inputStream = null;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                inputStream = null;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            } catch (CertificateException e9) {
                e = e9;
                inputStream = null;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                g.g(inputStream2);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                str = inputStream;
            } catch (IOException e10) {
                e = e10;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            } catch (KeyStoreException e11) {
                e = e11;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e12) {
                e = e12;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            } catch (CertificateException e13) {
                e = e13;
                h.d(f35244b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                g.g(str);
                return x509Certificate;
            }
            g.g(str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = str;
            g.g(inputStream2);
            throw th;
        }
    }

    public X509Certificate a() {
        return b(f35249g, f35250h);
    }

    public X509Certificate c() {
        return b("hmsrootcas.bks", f35248f);
    }

    public k(Context context) {
        this.f35251a = context;
    }
}
