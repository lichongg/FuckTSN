package xyz.adscope.common.network.cookie;

import android.text.TextUtils;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CookieManager {

    /* renamed from: a, reason: collision with root package name */
    private CookieStore f56603a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.network.cookie.CookieManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CookiePathComparator implements Comparator<HttpCookie> {
        private CookiePathComparator() {
        }

        /* synthetic */ CookiePathComparator(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(HttpCookie httpCookie, HttpCookie httpCookie2) {
            if (httpCookie == httpCookie2) {
                return 0;
            }
            if (httpCookie == null) {
                return -1;
            }
            if (httpCookie2 == null) {
                return 1;
            }
            if (!httpCookie.getName().equals(httpCookie2.getName())) {
                return 0;
            }
            String b6 = CookieManager.b(httpCookie.getPath());
            String b7 = CookieManager.b(httpCookie2.getPath());
            if (b6.startsWith(b7)) {
                return -1;
            }
            return b7.startsWith(b6) ? 1 : 0;
        }
    }

    private static int a(URI uri) {
        int port = uri.getPort();
        return port == -1 ? b.f50155b.equals(uri.getScheme()) ? 443 : 80 : port;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        if (str.endsWith("/")) {
            return str;
        }
        return str + "/";
    }

    public CookieManager(CookieStore cookieStore) {
        this.f56603a = cookieStore;
    }

    public void add(URI uri, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            for (HttpCookie httpCookie : HttpCookie.parse(it.next())) {
                if (httpCookie.getPath() == null) {
                    httpCookie.setPath(b(uri.getPath()));
                } else if (!a(uri, httpCookie)) {
                }
                if (httpCookie.getDomain() == null) {
                    httpCookie.setDomain(uri.getHost());
                }
                String portlist = httpCookie.getPortlist();
                int a6 = a(uri);
                if (TextUtils.isEmpty(portlist) || a(portlist, a6)) {
                    this.f56603a.add(uri, httpCookie);
                }
            }
        }
    }

    public List<String> get(URI uri) {
        boolean equalsIgnoreCase = b.f50155b.equalsIgnoreCase(uri.getScheme());
        ArrayList arrayList = new ArrayList();
        for (HttpCookie httpCookie : this.f56603a.get(uri)) {
            if (a(uri, httpCookie) && (equalsIgnoreCase || !httpCookie.getSecure())) {
                String portlist = httpCookie.getPortlist();
                int a6 = a(uri);
                if (TextUtils.isEmpty(portlist) || a(portlist, a6)) {
                    arrayList.add(httpCookie);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(a(arrayList));
        return arrayList2;
    }

    private static boolean a(String str, int i6) {
        if (str.contains(",")) {
            String[] split = str.split(",");
            String num = Integer.toString(i6);
            for (String str2 : split) {
                if (str2.equals(num)) {
                    return true;
                }
            }
            return false;
        }
        return str.equalsIgnoreCase(Integer.toString(i6));
    }

    private static boolean a(URI uri, HttpCookie httpCookie) {
        return b(uri.getPath()).startsWith(b(httpCookie.getPath()));
    }

    private String a(List<HttpCookie> list) {
        Collections.sort(list, new CookiePathComparator(null));
        StringBuilder sb = new StringBuilder();
        int i6 = 1;
        for (HttpCookie httpCookie : list) {
            if (httpCookie.getVersion() < i6) {
                i6 = httpCookie.getVersion();
            }
        }
        if (i6 == 1) {
            sb.append("$Version=\"1\"; ");
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (i7 != 0) {
                sb.append("; ");
            }
            sb.append(list.get(i7).toString());
        }
        return sb.toString();
    }
}
