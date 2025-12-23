package com.huawei.secure.android.common.ssl;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class k implements X509TrustManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f35180c = "SX509TM";

    /* renamed from: d, reason: collision with root package name */
    public static final String f35181d = "hmsrootcas.bks";

    /* renamed from: e, reason: collision with root package name */
    private static final String f35182e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final String f35183f = "X509";

    /* renamed from: g, reason: collision with root package name */
    private static final String f35184g = "bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f35185h = "AndroidCAStore";

    /* renamed from: a, reason: collision with root package name */
    protected List<X509TrustManager> f35186a;

    /* renamed from: b, reason: collision with root package name */
    private X509Certificate[] f35187b;

    public k(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    public k(Context context, boolean z5) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.f35186a = new ArrayList();
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        com.huawei.secure.android.common.ssl.util.c.b(context);
        if (z5) {
            a();
        }
        b(context);
        if (this.f35186a.isEmpty()) {
            throw new CertificateException("X509TrustManager is empty");
        }
    }

    private void a() {
        com.huawei.secure.android.common.ssl.util.h.e(f35180c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance(f35185h);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f35183f);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f35186a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e6) {
            com.huawei.secure.android.common.ssl.util.h.d(f35180c, "loadSystemCA: exception : " + e6.getMessage());
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35180c, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x003c, code lost:
    
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r7) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "loadBksCA"
            java.lang.String r1 = "SX509TM"
            com.huawei.secure.android.common.ssl.util.h.e(r1, r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.io.InputStream r0 = com.huawei.secure.android.common.ssl.util.a.o(r7)
            if (r0 == 0) goto L3c
            java.lang.String r4 = "get bks not from assets"
            com.huawei.secure.android.common.ssl.util.h.e(r1, r4)     // Catch: java.io.IOException -> L1a java.security.cert.CertificateException -> L1c java.security.KeyStoreException -> L1e java.security.NoSuchAlgorithmException -> L20 java.lang.OutOfMemoryError -> L22
            r6.c(r0)     // Catch: java.io.IOException -> L1a java.security.cert.CertificateException -> L1c java.security.KeyStoreException -> L1e java.security.NoSuchAlgorithmException -> L20 java.lang.OutOfMemoryError -> L22
            goto L3c
        L1a:
            r0 = move-exception
            goto L23
        L1c:
            r0 = move-exception
            goto L23
        L1e:
            r0 = move-exception
            goto L23
        L20:
            r0 = move-exception
            goto L23
        L22:
            r0 = move-exception
        L23:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "loadBksCA: exception : "
            r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.huawei.secure.android.common.ssl.util.h.d(r1, r0)
            goto L3e
        L3c:
            if (r0 != 0) goto L50
        L3e:
            java.lang.String r0 = " get bks from assets "
            com.huawei.secure.android.common.ssl.util.h.e(r1, r0)
            android.content.res.AssetManager r7 = r7.getAssets()
            java.lang.String r0 = "hmsrootcas.bks"
            java.io.InputStream r7 = r7.open(r0)
            r6.c(r7)
        L50:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "loadBksCA: cost : "
            r7.append(r0)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r7.append(r4)
            java.lang.String r0 = " ms"
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.huawei.secure.android.common.ssl.util.h.b(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.k.b(android.content.Context):void");
    }

    private void c(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f35183f);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            for (TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                if (trustManager instanceof X509TrustManager) {
                    this.f35186a.add((X509TrustManager) trustManager);
                }
            }
        } finally {
            com.huawei.secure.android.common.ssl.util.g.g(inputStream);
        }
    }

    private void d(InputStream inputStream, String str) {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f35183f);
                KeyStore keyStore = KeyStore.getInstance("bks");
                keyStore.load(inputStream, str.toCharArray());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                for (TrustManager trustManager : trustManagers) {
                    if (trustManager instanceof X509TrustManager) {
                        this.f35186a.add((X509TrustManager) trustManager);
                    }
                }
                com.huawei.secure.android.common.ssl.util.g.g(inputStream);
            } catch (IOException | NegativeArraySizeException | OutOfMemoryError | KeyStoreException | NoSuchAlgorithmException | CertificateException e6) {
                com.huawei.secure.android.common.ssl.util.h.d(f35180c, "loadInputStream: exception : " + e6.getMessage());
            }
            com.huawei.secure.android.common.ssl.util.h.b(f35180c, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        } finally {
            com.huawei.secure.android.common.ssl.util.g.g(inputStream);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        com.huawei.secure.android.common.ssl.util.h.e(f35180c, "checkClientTrusted: ");
        Iterator<X509TrustManager> it = this.f35186a.iterator();
        while (it.hasNext()) {
            try {
                it.next().checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e6) {
                com.huawei.secure.android.common.ssl.util.h.d(f35180c, "checkServerTrusted CertificateException" + e6.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    public X509Certificate[] e() {
        return this.f35187b;
    }

    public List<X509TrustManager> f() {
        return this.f35186a;
    }

    public void g(X509Certificate[] x509CertificateArr) {
        this.f35187b = x509CertificateArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f35186a.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e6) {
            com.huawei.secure.android.common.ssl.util.h.d(f35180c, "getAcceptedIssuers exception : " + e6.getMessage());
            return new X509Certificate[0];
        }
    }

    public void h(List<X509TrustManager> list) {
        this.f35186a = list;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g(x509CertificateArr);
        com.huawei.secure.android.common.ssl.util.h.e(f35180c, "checkServerTrusted begin,size=" + x509CertificateArr.length + ",authType=" + str);
        long currentTimeMillis = System.currentTimeMillis();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            com.huawei.secure.android.common.ssl.util.h.b(f35180c, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            com.huawei.secure.android.common.ssl.util.h.b(f35180c, "IssuerDN :" + x509Certificate.getIssuerDN());
            com.huawei.secure.android.common.ssl.util.h.b(f35180c, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.f35186a.size();
        for (int i6 = 0; i6 < size; i6++) {
            try {
                com.huawei.secure.android.common.ssl.util.h.e(f35180c, "check server i=" + i6);
                X509TrustManager x509TrustManager = this.f35186a.get(i6);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    com.huawei.secure.android.common.ssl.util.h.e(f35180c, "client root ca size=" + acceptedIssuers.length);
                    for (X509Certificate x509Certificate2 : acceptedIssuers) {
                        com.huawei.secure.android.common.ssl.util.h.b(f35180c, "client root ca getIssuerDN :" + x509Certificate2.getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                com.huawei.secure.android.common.ssl.util.h.e(f35180c, "checkServerTrusted end, " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e6) {
                com.huawei.secure.android.common.ssl.util.h.d(f35180c, "checkServerTrusted error :" + e6.getMessage() + " , time : " + i6);
                if (i6 == size - 1) {
                    if (x509CertificateArr.length > 0) {
                        com.huawei.secure.android.common.ssl.util.h.d(f35180c, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e6;
                }
            }
        }
        com.huawei.secure.android.common.ssl.util.h.b(f35180c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public k(InputStream inputStream, String str) throws IllegalArgumentException {
        this.f35186a = new ArrayList();
        d(inputStream, str);
    }

    public k(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    public k(String str, boolean z5) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.f35186a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            d(fileInputStream, "");
            com.huawei.secure.android.common.ssl.util.g.g(fileInputStream);
            if (z5) {
                a();
            }
        } catch (Throwable th2) {
            th = th2;
            com.huawei.secure.android.common.ssl.util.g.g(fileInputStream);
            throw th;
        }
    }

    public k(InputStream inputStream, String str, boolean z5) throws IllegalArgumentException {
        this.f35186a = new ArrayList();
        if (z5) {
            a();
        }
        d(inputStream, str);
    }
}
