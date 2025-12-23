package com.bytedance.sdk.openadsdk.api.plugin.xt;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements HostnameVerifier {

    /* renamed from: j, reason: collision with root package name */
    public static final j f27598j = new j();
    private static final Pattern xt = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private boolean j(String str, X509Certificate x509Certificate) {
        return j(str) ? xt(str, x509Certificate) : cw(str, x509Certificate);
    }

    private boolean xt(String str, X509Certificate x509Certificate) {
        List<String> j6 = j(x509Certificate, 7);
        int size = j6.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (str.equalsIgnoreCase(j6.get(i6))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return j(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private boolean cw(String str, X509Certificate x509Certificate) {
        String j6;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> j7 = j(x509Certificate, 2);
        int size = j7.size();
        int i6 = 0;
        boolean z5 = false;
        while (i6 < size) {
            if (j(lowerCase, j7.get(i6))) {
                return true;
            }
            i6++;
            z5 = true;
        }
        if (z5 || (j6 = new xt(x509Certificate.getSubjectX500Principal()).j("cn")) == null) {
            return false;
        }
        return j(lowerCase, j6);
    }

    private j() {
    }

    private static boolean j(String str) {
        return xt.matcher(str).matches();
    }

    private static List<String> j(X509Certificate x509Certificate, int i6) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.EMPTY_LIST;
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i6 && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.EMPTY_LIST;
        }
    }

    private boolean j(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
