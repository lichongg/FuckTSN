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
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35230a = "CertificateUtil";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public static X509Certificate a(Context context) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                KeyStore keyStore = KeyStore.getInstance(k.f35247e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
                try {
                    inputStream.reset();
                    keyStore.load(inputStream, "".toCharArray());
                    x509Certificate = (X509Certificate) keyStore.getCertificate(k.f35248f);
                    context = inputStream;
                } catch (IOException e6) {
                    e = e6;
                    h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    g.g(context);
                    return x509Certificate;
                } catch (RuntimeException e7) {
                    e = e7;
                    h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    g.g(context);
                    return x509Certificate;
                } catch (KeyStoreException e8) {
                    e = e8;
                    h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    g.g(context);
                    return x509Certificate;
                } catch (NoSuchAlgorithmException e9) {
                    e = e9;
                    h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    g.g(context);
                    return x509Certificate;
                } catch (CertificateException e10) {
                    e = e10;
                    h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                    context = inputStream;
                    g.g(context);
                    return x509Certificate;
                }
            } catch (IOException e11) {
                e = e11;
                inputStream = null;
                h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                g.g(context);
                return x509Certificate;
            } catch (RuntimeException e12) {
                e = e12;
                inputStream = null;
                h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                g.g(context);
                return x509Certificate;
            } catch (KeyStoreException e13) {
                e = e13;
                inputStream = null;
                h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                g.g(context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e14) {
                e = e14;
                inputStream = null;
                h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                g.g(context);
                return x509Certificate;
            } catch (CertificateException e15) {
                e = e15;
                inputStream = null;
                h.d(f35230a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                g.g(context);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                g.g(inputStream2);
                throw th;
            }
            g.g(context);
            return x509Certificate;
        } catch (Throwable th2) {
            inputStream2 = context;
            th = th2;
            g.g(inputStream2);
            throw th;
        }
    }

    private b() {
    }
}
