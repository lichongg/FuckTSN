package com.amap.api.col.p0003l;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b7 {

    /* renamed from: d, reason: collision with root package name */
    private static b7 f5722d = null;

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f5723e = true;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Map<String, List<String>>> f5724a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<String>> f5725b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f5726c = new ArrayList();

    private synchronized boolean f(a aVar) {
        if (aVar != null) {
            try {
                if (aVar.f5729c.length() != 0) {
                    Map<String, List<String>> map = this.f5725b;
                    String str = aVar.f5727a;
                    if (str != null && this.f5724a.containsKey(str)) {
                        map = this.f5724a.get(aVar.f5727a);
                    }
                    List<String> list = this.f5726c;
                    boolean z5 = f5723e;
                    if (!z5 && map == null) {
                        throw new AssertionError();
                    }
                    String str2 = aVar.f5728b;
                    if (str2 != null && map.containsKey(str2)) {
                        list = map.get(aVar.f5728b);
                    }
                    if (!z5 && list == null) {
                        throw new AssertionError();
                    }
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (d(it.next(), aVar.f5729c)) {
                            return true;
                        }
                    }
                    return false;
                }
            } finally {
            }
        }
        return false;
    }

    public final boolean c(String str) {
        a a6;
        if (str == null || str.length() == 0 || (a6 = a(e(str))) == null) {
            return false;
        }
        return f(a6);
    }

    private static a a(a aVar) {
        if (aVar == null) {
            return null;
        }
        String str = aVar.f5729c;
        if (str != null && str.length() != 0) {
            while (true) {
                String str2 = aVar.f5729c;
                if (str2.charAt(str2.length() - 1) != '/') {
                    break;
                }
                String str3 = aVar.f5729c;
                aVar.f5729c = str3.substring(0, str3.length() - 1);
            }
            while (aVar.f5729c.charAt(0) == '/') {
                aVar.f5729c = aVar.f5729c.substring(1);
            }
        }
        return aVar;
    }

    public static synchronized b7 b() {
        b7 b7Var;
        synchronized (b7.class) {
            try {
                if (f5722d == null) {
                    f5722d = new b7();
                }
                b7Var = f5722d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return b7Var;
    }

    private static boolean d(String str, String str2) {
        String[] split = str.split("/");
        String[] split2 = str2.split("/");
        if (split2.length < split.length) {
            return false;
        }
        for (int i6 = 0; i6 < split.length; i6++) {
            if (!split[i6].equals("*") && !split[i6].equals(split2[i6])) {
                return false;
            }
        }
        return true;
    }

    private static a e(String str) {
        try {
            return new a(new URL(str));
        } catch (MalformedURLException unused) {
            String str2 = null;
            if (str.contains("://")) {
                return null;
            }
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            String[] split = str.split("/");
            int i6 = 0;
            if (split[0].contains(".")) {
                str2 = split[0];
                i6 = 1;
            }
            StringBuilder sb = new StringBuilder();
            while (i6 < split.length) {
                if (sb.length() > 0) {
                    sb.append("/");
                }
                sb.append(split[i6]);
                i6++;
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '/') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return new a(str2, sb.toString());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f5727a;

        /* renamed from: b, reason: collision with root package name */
        public String f5728b;

        /* renamed from: c, reason: collision with root package name */
        public String f5729c;

        public a(URL url) {
            this.f5727a = url.getProtocol();
            this.f5728b = url.getHost();
            this.f5729c = url.getPath();
        }

        public a(String str, String str2) {
            this.f5727a = null;
            this.f5728b = str;
            this.f5729c = str2;
        }
    }
}
