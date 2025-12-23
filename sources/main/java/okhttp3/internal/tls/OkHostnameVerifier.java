package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import okhttp3.internal._HostnamesCommonKt;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nOkHostnameVerifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,224:1\n1761#2,3:225\n1761#2,3:228\n*S KotlinDebug\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n*L\n69#1:225,3\n80#1:228,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes4.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;

    @NotNull
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) {
        String asciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(asciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        g0.p(host, "host");
        g0.p(session, "session");
        if (!isAscii(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            g0.n(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(host, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate certificate) {
        g0.p(certificate, "certificate");
        return f0.I4(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
    }

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (isAscii(str)) {
            Locale US = Locale.US;
            g0.o(US, "US");
            String lowerCase = str.toLowerCase(US);
            g0.o(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        return str;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i6) {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return f0.J();
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && g0.g(list.get(0), Integer.valueOf(i6)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return f0.J();
        }
    }

    private final boolean isAscii(String str) {
        if (str.length() != ((int) Utf8.size$default(str, 0, 0, 3, null))) {
            return false;
        }
        return true;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) {
        String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if ((subjectAltNames instanceof Collection) && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (g0.g(canonicalHost, _HostnamesCommonKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final boolean verify(@NotNull String host, @NotNull X509Certificate certificate) {
        g0.p(host, "host");
        g0.p(certificate, "certificate");
        return _HostnamesCommonKt.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        if (str != null && str.length() != 0 && !u.H2(str, ".", false, 2, null) && !u.Z1(str, "..", false, 2, null) && str2 != null && str2.length() != 0 && !u.H2(str2, ".", false, 2, null) && !u.Z1(str2, "..", false, 2, null)) {
            if (!u.Z1(str, ".", false, 2, null)) {
                str = str + '.';
            }
            String str3 = str;
            if (!u.Z1(str2, ".", false, 2, null)) {
                str2 = str2 + '.';
            }
            String asciiToLowercase = asciiToLowercase(str2);
            if (!u.l3(asciiToLowercase, "*", false, 2, null)) {
                return g0.g(str3, asciiToLowercase);
            }
            if (!u.H2(asciiToLowercase, "*.", false, 2, null) || u.G3(asciiToLowercase, '*', 1, false, 4, null) != -1 || str3.length() < asciiToLowercase.length() || g0.g("*.", asciiToLowercase)) {
                return false;
            }
            String substring = asciiToLowercase.substring(1);
            g0.o(substring, "substring(...)");
            if (!u.Z1(str3, substring, false, 2, null)) {
                return false;
            }
            int length = str3.length() - substring.length();
            return length <= 0 || u.V3(str3, '.', length + (-1), false, 4, null) == -1;
        }
        return false;
    }
}
