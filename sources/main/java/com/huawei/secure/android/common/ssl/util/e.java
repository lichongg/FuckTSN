package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35232a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static final int f35233b = 5;

    public static boolean c(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean f(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal principal = null;
        int i6 = 0;
        while (i6 < x509CertificateArr.length) {
            X509Certificate x509Certificate2 = x509CertificateArr[i6];
            Principal issuerDN = x509Certificate2.getIssuerDN();
            Principal subjectDN = x509Certificate2.getSubjectDN();
            if (principal != null) {
                if (!issuerDN.equals(principal)) {
                    h.d(f35232a, "verify: principalIssuer not match");
                    return false;
                }
                x509CertificateArr[i6].verify(x509CertificateArr[i6 - 1].getPublicKey());
            }
            i6++;
            principal = subjectDN;
        }
        return e(x509Certificate, x509CertificateArr[0]) && j(x509CertificateArr) && c(x509Certificate) && h(x509CertificateArr);
    }

    public static boolean h(X509Certificate[] x509CertificateArr) {
        for (int i6 = 0; i6 < x509CertificateArr.length - 1; i6++) {
            if (!c(x509CertificateArr[i6])) {
                return false;
            }
        }
        return true;
    }

    public static X509Certificate b(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes()));
        } catch (CertificateException e6) {
            h.d(f35232a, "generateX509FromStr: CertificateException" + e6.getMessage());
            return null;
        }
    }

    public static boolean i(X509Certificate[] x509CertificateArr, X509CRL x509crl) {
        ArrayList arrayList = new ArrayList();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Certificate.getSerialNumber());
        }
        if (x509crl == null) {
            return true;
        }
        try {
            Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
            if (revokedCertificates == null || revokedCertificates.isEmpty()) {
                return true;
            }
            Iterator<? extends X509CRLEntry> it = revokedCertificates.iterator();
            while (it.hasNext()) {
                if (arrayList.contains(it.next().getSerialNumber())) {
                    h.d(f35232a, "verify: certificate revoked");
                    return false;
                }
            }
            return true;
        } catch (Exception e6) {
            h.d(f35232a, "verify: revoked verify exception : " + e6.getMessage());
            return false;
        }
    }

    public static boolean j(X509Certificate[] x509CertificateArr) {
        Date date = new Date();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            try {
                x509Certificate.checkValidity(date);
            } catch (CertificateExpiredException e6) {
                e = e6;
                h.d(f35232a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (CertificateNotYetValidException e7) {
                e = e7;
                h.d(f35232a, "verifyCertificateDate: exception : " + e.getMessage());
                return false;
            } catch (Exception e8) {
                h.d(f35232a, "verifyCertificateDate : exception : " + e8.getMessage());
                return false;
            }
        }
        return true;
    }

    public static X509Certificate a(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray != null) {
            try {
                return (X509Certificate) CertificateFactory.getInstance(com.huawei.hms.feature.dynamic.f.e.f33254b).generateCertificate(new ByteArrayInputStream(byteArray));
            } catch (CertificateException e6) {
                h.c(f35232a, "exception", e6);
                return null;
            }
        }
        return null;
    }

    public static boolean d(X509Certificate x509Certificate, String str) {
        if (!str.equals(x509Certificate.getSubjectDN().getName())) {
            h.d(f35232a, "verify: subject name is error");
            return false;
        }
        return true;
    }

    public static boolean e(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            if (j(new X509Certificate[]{x509Certificate, x509Certificate2})) {
                return true;
            }
            h.d(f35232a, "verify: date not right");
            return false;
        } catch (InvalidKeyException e6) {
            h.d(f35232a, "verify: publickey InvalidKeyException " + e6.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e7) {
            h.d(f35232a, "verify: publickey NoSuchAlgorithmException " + e7.getMessage());
            return false;
        } catch (NoSuchProviderException e8) {
            h.d(f35232a, "verify: publickey NoSuchProviderException " + e8.getMessage());
            return false;
        } catch (SignatureException e9) {
            h.d(f35232a, "verify: publickey SignatureException " + e9.getMessage());
            return false;
        } catch (CertificateException e10) {
            h.d(f35232a, "verify: publickey CertificateException " + e10.getMessage());
            return false;
        } catch (Exception e11) {
            h.d(f35232a, "verify: Exception " + e11.getMessage());
            return false;
        }
    }

    public static boolean g(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, X509CRL x509crl, String str) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        if (f(x509Certificate, x509CertificateArr) || i(x509CertificateArr, x509crl) || !d(x509CertificateArr[x509CertificateArr.length - 1], str) || !j(x509CertificateArr)) {
            return false;
        }
        return true;
    }
}
