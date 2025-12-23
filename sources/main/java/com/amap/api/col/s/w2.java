package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w2 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f8591a = new ConcurrentHashMap<>(8);

    /* renamed from: b, reason: collision with root package name */
    public static volatile List<String> f8592b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f8593c = new ConcurrentHashMap<>(8);

    /* renamed from: d, reason: collision with root package name */
    private static Random f8594d = new Random();

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f8595e = new ConcurrentHashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    private static List<g3> f8596f = Collections.synchronizedList(new ArrayList(16));

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f8597a;

        /* renamed from: b, reason: collision with root package name */
        int f8598b;

        /* renamed from: c, reason: collision with root package name */
        double f8599c;

        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        b3 f8600a;

        /* renamed from: b, reason: collision with root package name */
        long f8601b;

        private b() {
        }

        /* synthetic */ b(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        Map<String, List<a>> f8602a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, String> f8603b;

        private c() {
            this.f8602a = new HashMap(8);
            this.f8603b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f8602a.equals(cVar.f8602a) && this.f8603b.equals(cVar.f8603b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f8602a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f8603b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ c(byte b6) {
            this();
        }
    }

    private static boolean l(a aVar) {
        if (aVar == null || aVar.f8599c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f8597a) && aVar.f8598b > 0) {
            long timeInMillis = currentTimeMillis - j1.h(aVar.f8597a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.f8598b * 1000) {
                if (aVar.f8599c == 0.0d) {
                    return true;
                }
                if (f8594d == null) {
                    f8594d = new Random();
                }
                f8594d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f8594d.nextDouble() > aVar.f8599c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f8602a;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                Iterator<Map.Entry<String, List<a>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (n(it.next().getValue())) {
                        k(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                String path = Uri.parse(str).getPath();
                if (map.containsKey(path) && n(map.get(path))) {
                    k(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean n(List<a> list) {
        if (list != null && list.size() > 0) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x001f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static java.util.List<com.amap.api.col.s.g3> q() {
        /*
            r0 = 0
            java.util.List<com.amap.api.col.s.g3> r1 = com.amap.api.col.s.w2.f8596f     // Catch: java.lang.Throwable -> L2b
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L2b
            java.util.List<com.amap.api.col.s.g3> r2 = com.amap.api.col.s.w2.f8596f     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L26
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L21
            if (r2 <= 0) goto L26
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L21
            r2.<init>()     // Catch: java.lang.Throwable -> L21
            java.util.List<com.amap.api.col.s.g3> r0 = com.amap.api.col.s.w2.f8596f     // Catch: java.lang.Throwable -> L1f
            r2.addAll(r0)     // Catch: java.lang.Throwable -> L1f
            java.util.List<com.amap.api.col.s.g3> r0 = com.amap.api.col.s.w2.f8596f     // Catch: java.lang.Throwable -> L1f
            r0.clear()     // Catch: java.lang.Throwable -> L1f
            r0 = r2
            goto L26
        L1f:
            r0 = move-exception
            goto L28
        L21:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
            goto L28
        L26:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L21
            return r0
        L28:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            throw r0     // Catch: java.lang.Throwable -> L2a
        L2a:
            r0 = r2
        L2b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.w2.q():java.util.List");
    }

    public static synchronized String a(String str, String str2) throws bv {
        synchronized (w2.class) {
            try {
                try {
                    try {
                        System.currentTimeMillis();
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                            Context context = y0.f8713g;
                            try {
                                if (f8592b == null) {
                                    f8592b = Collections.synchronizedList(new ArrayList(8));
                                }
                                if (context != null && !f8592b.contains(str2)) {
                                    f8592b.add(str2);
                                    String d6 = j2.d(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                    if (!TextUtils.isEmpty(d6)) {
                                        h(str2, new JSONObject(d6));
                                    }
                                }
                            } catch (Throwable th) {
                                d2.e(th, "hlUtil", "llhl");
                            }
                            if (f8591a != null && f8591a.size() > 0) {
                                if (!f8591a.containsKey(str2)) {
                                    return str;
                                }
                                c cVar = f8591a.get(str2);
                                if (cVar == null) {
                                    return str;
                                }
                                if (m(str, cVar, str2)) {
                                    throw new bv("服务QPS超限");
                                }
                                return p(str, cVar, str2);
                            }
                            return str;
                        }
                        return str;
                    } catch (bv e6) {
                        throw e6;
                    }
                } catch (Throwable th2) {
                    d2.e(th2, "hlUtil", "pcr");
                    return str;
                }
            } finally {
            }
        }
    }

    public static void b() {
        try {
            Context context = y0.f8713g;
            if (context == null) {
                return;
            }
            h3.e(q(), context);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void c(i1 i1Var, JSONObject jSONObject) {
        synchronized (w2.class) {
            if (i1Var == null) {
                return;
            }
            try {
                String d6 = i1Var.d();
                if (TextUtils.isEmpty(d6)) {
                    return;
                }
                if (jSONObject == null) {
                    e(d6);
                }
                if (!y0.u(jSONObject.optString("able", null), false)) {
                    e(d6);
                } else {
                    j2.e(y0.f8713g, "Yb3Blbl9odHRwX2NvbnRyb2w", d6, jSONObject.toString());
                    h(d6, jSONObject);
                }
            } catch (Throwable th) {
                d2.e(th, "hlUtil", "par");
            }
        }
    }

    private static void d(c cVar, JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            byte b6 = 0;
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("api");
                    if (!TextUtils.isEmpty(optString)) {
                        if (!optString.startsWith("/")) {
                            optString = "/".concat(optString);
                        }
                        if (optString.endsWith("/")) {
                            optString = optString.substring(0, optString.length() - 1);
                        }
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i7);
                            if (optJSONObject2 != null) {
                                a aVar = new a(b6);
                                aVar.f8597a = optJSONObject2.optString("begin");
                                aVar.f8598b = optJSONObject2.optInt("duration");
                                aVar.f8599c = optJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.f8602a = hashMap;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void e(String str) {
        synchronized (w2.class) {
            try {
                if (f8591a.containsKey(str)) {
                    f8591a.remove(str);
                }
                SharedPreferences.Editor c6 = j2.c(y0.f8713g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                j2.g(c6, str);
                j2.f(c6);
            } catch (Throwable th) {
                d2.e(th, "hlUtil", "rc");
            }
        }
    }

    private static void f(String str, c cVar) {
        try {
            if (f8591a == null) {
                f8591a = new ConcurrentHashMap<>(8);
            }
            f8591a.put(str, cVar);
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "ucr");
        }
    }

    private static void g(String str, String str2, String str3) {
        try {
            Context context = y0.f8713g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f8595e == null) {
                    f8595e = new ConcurrentHashMap<>(8);
                }
                synchronized (f8595e) {
                    try {
                        if (f8595e.containsKey(str2)) {
                            return;
                        }
                        f8595e.put(str2, str3);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("type", s1.f8437l);
                        jSONObject.put(CommonNetImpl.NAME, str);
                        jSONObject.put("version", s1.a(str));
                        jSONObject.put("hostname", str2 + "#" + str3);
                        String jSONObject2 = jSONObject.toString();
                        if (TextUtils.isEmpty(jSONObject2)) {
                            return;
                        }
                        g3 g3Var = new g3(context, "core", "2.0", "O005");
                        g3Var.a(jSONObject2);
                        h3.d(g3Var, context);
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            d(cVar, jSONObject);
            r(cVar, jSONObject);
            if (cVar.f8603b == null && cVar.f8602a == null) {
                e(str);
            } else {
                f(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(URL url, b3 b3Var) {
        List<String> list;
        try {
            if (f8593c == null) {
                f8593c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = b3Var.f7877b;
            if (map != null && map.containsKey("nb") && (list = b3Var.f7877b.get("nb")) != null && list.size() > 0) {
                byte b6 = 0;
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                b bVar = new b(b6);
                bVar.f8600a = b3Var;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.f8601b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f8593c.put(Constants.JumpUrlConstants.SRC_TYPE_APP, bVar);
                } else {
                    if (parseInt != 2 || url == null) {
                        return;
                    }
                    f8593c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z5, String str) {
        try {
            Context context = y0.f8713g;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z5) {
                    jSONObject.put("type", s1.f8434i);
                } else {
                    jSONObject.put("type", s1.f8433h);
                }
                jSONObject.put(CommonNetImpl.NAME, str);
                jSONObject.put("version", s1.a(str));
                String jSONObject2 = jSONObject.toString();
                g3 g3Var = new g3(context, "core", "2.0", "O005");
                g3Var.a(jSONObject2);
                h3.d(g3Var, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void k(boolean z5, String str, String str2, int i6) {
        try {
            Context context = y0.f8713g;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String a6 = s1.a(str);
                if (z5) {
                    jSONObject.put("type", s1.f8436k);
                } else {
                    jSONObject.put("type", s1.f8435j);
                }
                jSONObject.put(CommonNetImpl.NAME, str);
                jSONObject.put("version", a6);
                jSONObject.put(ContentProviderManager.PROVIDER_URI, Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i6);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                g3 g3Var = new g3(context, "core", "2.0", "O005");
                g3Var.a(jSONObject2);
                if (f8596f == null) {
                    f8596f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f8596f) {
                    try {
                        f8596f.add(g3Var);
                        if (f8596f.size() >= 15) {
                            b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static b3 o(String str, String str2) {
        Uri parse;
        if (f8593c == null) {
            return null;
        }
        if (f8593c.containsKey(Constants.JumpUrlConstants.SRC_TYPE_APP)) {
            b bVar = f8593c.get(Constants.JumpUrlConstants.SRC_TYPE_APP);
            if (SystemClock.elapsedRealtime() <= bVar.f8601b) {
                b3 b3Var = bVar.f8600a;
                if (b3Var != null) {
                    b3Var.f7880e = false;
                }
                k(true, str2, str, 1);
                return b3Var;
            }
            f8593c.remove(Constants.JumpUrlConstants.SRC_TYPE_APP);
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f8593c.containsKey(path)) {
                b bVar2 = f8593c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f8601b) {
                    b3 b3Var2 = bVar2.f8600a;
                    if (b3Var2 != null) {
                        b3Var2.f7880e = false;
                    }
                    k(true, str2, str, 2);
                    return b3Var2;
                }
                f8593c.remove(path);
            }
        }
        return null;
    }

    private static String p(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f8603b;
            if (map != null && map.size() > 0) {
                Uri parse = Uri.parse(str);
                String authority = parse.getAuthority();
                if (map.containsKey(authority)) {
                    String str3 = map.get(authority);
                    str = parse.buildUpon().authority(str3).toString();
                    g(str2, authority, str3);
                    return str;
                }
            }
            return str;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "pdr");
            return str;
        }
    }

    private static void r(c cVar, JSONObject jSONObject) {
        JSONArray names;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject == null || (names = optJSONObject.names()) == null) {
                return;
            }
            HashMap hashMap = new HashMap(8);
            int length = names.length();
            for (int i6 = 0; i6 < length; i6++) {
                String optString = names.optString(i6);
                hashMap.put(optString, optJSONObject.optString(optString));
            }
            cVar.f8603b = hashMap;
        } catch (Throwable th) {
            d2.e(th, "hlUtil", "pdr");
        }
    }
}
