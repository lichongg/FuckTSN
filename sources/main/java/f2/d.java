package f2;

import com.huawei.secure.android.common.ssl.util.h;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f43015a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f43016b;

    public static int e(String str) {
        int i6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            if (str.charAt(i7) == '.') {
                i6++;
            }
        }
        return i6;
    }

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", TKDownloadReason.KSAD_TK_NET, "or", "org"};
        f43016b = strArr;
        Arrays.sort(strArr);
    }

    public static final void b(String str, String[] strArr, String[] strArr2, boolean z5) throws SSLException {
        String str2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (linkedList.isEmpty()) {
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        StringBuffer stringBuffer = new StringBuffer();
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        Iterator it = linkedList.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
            stringBuffer.append(" <");
            stringBuffer.append(lowerCase2);
            stringBuffer.append(v0.f47962f);
            if (it.hasNext()) {
                stringBuffer.append(" OR");
            }
            if (!lowerCase2.startsWith("*.") || lowerCase2.indexOf(46, 2) == -1 || !c(lowerCase2) || g(str)) {
                z6 = lowerCase.equals(lowerCase2);
            } else {
                boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                z6 = (endsWith && z5) ? e(lowerCase) == e(lowerCase2) : endsWith;
            }
            if (z6) {
                break;
            }
        }
        if (z6) {
            return;
        }
        throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
    }

    public static String[] d(X509Certificate x509Certificate) {
        List<String> e6 = new c(x509Certificate.getSubjectX500Principal()).e("cn");
        if (e6.isEmpty()) {
            return null;
        }
        String[] strArr = new String[e6.size()];
        e6.toArray(strArr);
        return strArr;
    }

    public static String[] f(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e6) {
            h.c("", "Error parsing certificate.", e6);
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    private static boolean g(String str) {
        return f43015a.matcher(str).matches();
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z5) throws SSLException {
        String[] d6 = d(x509Certificate);
        String[] f6 = f(x509Certificate);
        h.b("", "cn is : " + Arrays.toString(d6));
        h.b("", "san is : " + Arrays.toString(f6));
        b(str, d6, f6, z5);
    }

    public static boolean c(String str) {
        int length = str.length();
        if (length >= 7 && length <= 9) {
            int i6 = length - 3;
            if (str.charAt(i6) == '.') {
                if (Arrays.binarySearch(f43016b, str.substring(2, i6)) < 0) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}
