package com.huawei.secure.android.common.ssl;

import android.content.Context;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class o implements X509TrustManager {

    /* renamed from: c, reason: collision with root package name */
    private static final String f35209c = "WebViewX509TrustManger";

    /* renamed from: a, reason: collision with root package name */
    private X509Certificate f35210a;

    /* renamed from: b, reason: collision with root package name */
    private List<X509TrustManager> f35211b = new ArrayList();

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        com.huawei.secure.android.common.ssl.util.h.e(f35209c, "checkClientTrusted");
        if (this.f35211b.isEmpty()) {
            throw new CertificateException("checkClientTrusted CertificateException");
        }
        this.f35211b.get(0).checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        com.huawei.secure.android.common.ssl.util.h.e(f35209c, "checkServerTrusted");
        boolean z5 = false;
        for (int i6 = 0; i6 < x509CertificateArr.length; i6++) {
            com.huawei.secure.android.common.ssl.util.h.b(f35209c, "checkServerTrusted " + i6 + " : " + x509CertificateArr[i6].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i7 = 0; i7 < x509CertificateArr.length; i7++) {
            x509CertificateArr2[i7] = x509CertificateArr[(x509CertificateArr.length - 1) - i7];
        }
        CertificateException e6 = new CertificateException("CBG root CA CertificateException");
        try {
            z5 = com.huawei.secure.android.common.ssl.util.e.f(this.f35210a, x509CertificateArr2);
        } catch (InvalidKeyException e7) {
            com.huawei.secure.android.common.ssl.util.h.d(f35209c, "checkServerTrusted InvalidKeyException: " + e7.getMessage());
        } catch (NoSuchAlgorithmException e8) {
            com.huawei.secure.android.common.ssl.util.h.d(f35209c, "checkServerTrusted NoSuchAlgorithmException: " + e8.getMessage());
        } catch (NoSuchProviderException e9) {
            com.huawei.secure.android.common.ssl.util.h.d(f35209c, "checkServerTrusted NoSuchProviderException: " + e9.getMessage());
        } catch (SignatureException e10) {
            com.huawei.secure.android.common.ssl.util.h.d(f35209c, "checkServerTrusted SignatureException: " + e10.getMessage());
        } catch (CertificateException e11) {
            e6 = e11;
            com.huawei.secure.android.common.ssl.util.h.d(f35209c, "checkServerTrusted CertificateException: " + e6.getMessage());
        }
        if (!z5) {
            throw e6;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<X509TrustManager> it = this.f35211b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e6) {
            com.huawei.secure.android.common.ssl.util.h.d(f35209c, "getAcceptedIssuers exception : " + e6.getMessage());
            return new X509Certificate[0];
        }
    }

    public o(Context context) {
        if (context != null) {
            com.huawei.secure.android.common.ssl.util.c.b(context);
            X509Certificate c6 = new com.huawei.secure.android.common.ssl.util.k(context).c();
            this.f35210a = c6;
            if (c6 != null) {
                return;
            } else {
                throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
            }
        }
        throw new NullPointerException("WebViewX509TrustManger context is null");
    }
}
