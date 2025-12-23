package com.amap.api.col.p0003l;

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
public final class v6 {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, c> f7476a = new ConcurrentHashMap<>(8);

    /* renamed from: b, reason: collision with root package name */
    public static volatile List<String> f7477b = Collections.synchronizedList(new ArrayList(8));

    /* renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, b> f7478c = new ConcurrentHashMap<>(8);

    /* renamed from: d, reason: collision with root package name */
    private static Random f7479d = new Random();

    /* renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, String> f7480e = new ConcurrentHashMap<>(8);

    /* renamed from: f, reason: collision with root package name */
    private static List<h7> f7481f = Collections.synchronizedList(new ArrayList(16));

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f7482a;

        /* renamed from: b, reason: collision with root package name */
        int f7483b;

        /* renamed from: c, reason: collision with root package name */
        double f7484c;

        private a() {
        }

        /* synthetic */ a(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        z6 f7485a;

        /* renamed from: b, reason: collision with root package name */
        long f7486b;

        private b() {
        }

        /* synthetic */ b(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        Map<String, List<a>> f7487a;

        /* renamed from: b, reason: collision with root package name */
        Map<String, String> f7488b;

        private c() {
            this.f7487a = new HashMap(8);
            this.f7488b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f7487a.equals(cVar.f7487a) && this.f7488b.equals(cVar.f7488b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f7487a;
            int hashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.f7488b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }

        /* synthetic */ c(byte b6) {
            this();
        }
    }

    private static boolean l(a aVar) {
        if (aVar == null || aVar.f7484c == 1.0d) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f7482a) && aVar.f7483b > 0) {
            long timeInMillis = currentTimeMillis - q4.h(aVar.f7482a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.f7483b * 1000) {
                if (aVar.f7484c == 0.0d) {
                    return true;
                }
                if (f7479d == null) {
                    f7479d = new Random();
                }
                f7479d.setSeed(UUID.randomUUID().hashCode() + currentTimeMillis);
                if (f7479d.nextDouble() > aVar.f7484c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(String str, c cVar, String str2) {
        Map<String, List<a>> map;
        try {
            map = cVar.f7487a;
        } catch (Throwable th) {
            r5.e(th, "hlUtil", "inb");
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
    public static java.util.List<com.amap.api.col.p0003l.h7> q() {
        /*
            r0 = 0
            java.util.List<com.amap.api.col.3l.h7> r1 = com.amap.api.col.p0003l.v6.f7481f     // Catch: java.lang.Throwable -> L2b
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L2b
            java.util.List<com.amap.api.col.3l.h7> r2 = com.amap.api.col.p0003l.v6.f7481f     // Catch: java.lang.Throwable -> L21
            if (r2 == 0) goto L26
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L21
            if (r2 <= 0) goto L26
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L21
            r2.<init>()     // Catch: java.lang.Throwable -> L21
            java.util.List<com.amap.api.col.3l.h7> r0 = com.amap.api.col.p0003l.v6.f7481f     // Catch: java.lang.Throwable -> L1f
            r2.addAll(r0)     // Catch: java.lang.Throwable -> L1f
            java.util.List<com.amap.api.col.3l.h7> r0 = com.amap.api.col.p0003l.v6.f7481f     // Catch: java.lang.Throwable -> L1f
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.v6.q():java.util.List");
    }

    public static synchronized String a(String str, String str2) throws fk {
        synchronized (v6.class) {
            try {
                try {
                    try {
                        System.currentTimeMillis();
                        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                            Context context = g4.f6293g;
                            try {
                                if (f7477b == null) {
                                    f7477b = Collections.synchronizedList(new ArrayList(8));
                                }
                                if (context != null && !f7477b.contains(str2)) {
                                    f7477b.add(str2);
                                    String d6 = g6.d(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                    if (!TextUtils.isEmpty(d6)) {
                                        h(str2, new JSONObject(d6));
                                    }
                                }
                            } catch (Throwable th) {
                                r5.e(th, "hlUtil", "llhl");
                            }
                            if (f7476a != null && f7476a.size() > 0) {
                                if (!f7476a.containsKey(str2)) {
                                    return str;
                                }
                                c cVar = f7476a.get(str2);
                                if (cVar == null) {
                                    return str;
                                }
                                if (m(str, cVar, str2)) {
                                    throw new fk("服务QPS超限");
                                }
                                return p(str, cVar, str2);
                            }
                            return str;
                        }
                        return str;
                    } catch (Throwable th2) {
                        r5.e(th2, "hlUtil", "pcr");
                        return str;
                    }
                } catch (fk e6) {
                    throw e6;
                }
            } finally {
            }
        }
    }

    public static void b() {
        try {
            Context context = g4.f6293g;
            if (context == null) {
                return;
            }
            i7.e(q(), context);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void c(p4 p4Var, JSONObject jSONObject) {
        synchronized (v6.class) {
            if (p4Var == null) {
                return;
            }
            try {
                String a6 = p4Var.a();
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
                if (jSONObject == null) {
                    e(a6);
                }
                if (!g4.x(jSONObject.optString("able", null), false)) {
                    e(a6);
                } else {
                    g6.e(g4.f6293g, "Yb3Blbl9odHRwX2NvbnRyb2w", a6, jSONObject.toString());
                    h(a6, jSONObject);
                }
            } catch (Throwable th) {
                r5.e(th, "hlUtil", "par");
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
                                aVar.f7482a = optJSONObject2.optString("begin");
                                aVar.f7483b = optJSONObject2.optInt("duration");
                                aVar.f7484c = optJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.f7487a = hashMap;
        } catch (Throwable th) {
            r5.e(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void e(String str) {
        synchronized (v6.class) {
            try {
                if (f7476a.containsKey(str)) {
                    f7476a.remove(str);
                }
                SharedPreferences.Editor c6 = g6.c(g4.f6293g, "Yb3Blbl9odHRwX2NvbnRyb2w");
                g6.g(c6, str);
                g6.f(c6);
            } catch (Throwable th) {
                r5.e(th, "hlUtil", "rc");
            }
        }
    }

    private static void f(String str, c cVar) {
        try {
            if (f7476a == null) {
                f7476a = new ConcurrentHashMap<>(8);
            }
            f7476a.put(str, cVar);
        } catch (Throwable th) {
            r5.e(th, "hlUtil", "ucr");
        }
    }

    private static void g(String str, String str2, String str3) {
        try {
            Context context = g4.f6293g;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f7480e == null) {
                    f7480e = new ConcurrentHashMap<>(8);
                }
                synchronized (f7480e) {
                    try {
                        if (f7480e.containsKey(str2)) {
                            return;
                        }
                        f7480e.put(str2, str3);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("type", f5.f6185l);
                        jSONObject.put(CommonNetImpl.NAME, str);
                        jSONObject.put("version", f5.a(str));
                        jSONObject.put("hostname", str2 + "#" + str3);
                        String jSONObject2 = jSONObject.toString();
                        if (TextUtils.isEmpty(jSONObject2)) {
                            return;
                        }
                        h7 h7Var = new h7(context, "core", "2.0", "O005");
                        h7Var.a(jSONObject2);
                        i7.d(h7Var, context);
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
            if (cVar.f7488b == null && cVar.f7487a == null) {
                e(str);
            } else {
                f(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(URL url, z6 z6Var) {
        List<String> list;
        try {
            if (f7478c == null) {
                f7478c = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = z6Var.f7801b;
            if (map != null && map.containsKey("nb") && (list = z6Var.f7801b.get("nb")) != null && list.size() > 0) {
                byte b6 = 0;
                String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = Integer.parseInt(split[0]);
                long parseInt2 = Integer.parseInt(split[1]);
                b bVar = new b(b6);
                bVar.f7485a = z6Var;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.f7486b = SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    f7478c.put(Constants.JumpUrlConstants.SRC_TYPE_APP, bVar);
                } else {
                    if (parseInt != 2 || url == null) {
                        return;
                    }
                    f7478c.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z5, String str) {
        try {
            Context context = g4.f6293g;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z5) {
                    jSONObject.put("type", f5.f6182i);
                } else {
                    jSONObject.put("type", f5.f6181h);
                }
                jSONObject.put(CommonNetImpl.NAME, str);
                jSONObject.put("version", f5.a(str));
                String jSONObject2 = jSONObject.toString();
                h7 h7Var = new h7(context, "core", "2.0", "O005");
                h7Var.a(jSONObject2);
                i7.d(h7Var, context);
            }
        } catch (Throwable unused) {
        }
    }

    private static void k(boolean z5, String str, String str2, int i6) {
        try {
            Context context = g4.f6293g;
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", System.currentTimeMillis());
                String a6 = f5.a(str);
                if (z5) {
                    jSONObject.put("type", f5.f6184k);
                } else {
                    jSONObject.put("type", f5.f6183j);
                }
                jSONObject.put(CommonNetImpl.NAME, str);
                jSONObject.put("version", a6);
                jSONObject.put(ContentProviderManager.PROVIDER_URI, Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i6);
                String jSONObject2 = jSONObject.toString();
                if (TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                h7 h7Var = new h7(context, "core", "2.0", "O005");
                h7Var.a(jSONObject2);
                if (f7481f == null) {
                    f7481f = Collections.synchronizedList(new ArrayList(16));
                }
                synchronized (f7481f) {
                    try {
                        f7481f.add(h7Var);
                        if (f7481f.size() >= 15) {
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

    public static z6 o(String str, String str2) {
        Uri parse;
        if (f7478c == null) {
            return null;
        }
        if (f7478c.containsKey(Constants.JumpUrlConstants.SRC_TYPE_APP)) {
            b bVar = f7478c.get(Constants.JumpUrlConstants.SRC_TYPE_APP);
            if (SystemClock.elapsedRealtime() <= bVar.f7486b) {
                z6 z6Var = bVar.f7485a;
                if (z6Var != null) {
                    z6Var.f7804e = false;
                }
                k(true, str2, str, 1);
                return z6Var;
            }
            f7478c.remove(Constants.JumpUrlConstants.SRC_TYPE_APP);
        } else if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null) {
            String path = parse.getPath();
            if (f7478c.containsKey(path)) {
                b bVar2 = f7478c.get(path);
                if (SystemClock.elapsedRealtime() <= bVar2.f7486b) {
                    z6 z6Var2 = bVar2.f7485a;
                    if (z6Var2 != null) {
                        z6Var2.f7804e = false;
                    }
                    k(true, str2, str, 2);
                    return z6Var2;
                }
                f7478c.remove(path);
            }
        }
        return null;
    }

    private static String p(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.f7488b;
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
            r5.e(th, "hlUtil", "pdr");
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
            cVar.f7488b = hashMap;
        } catch (Throwable th) {
            r5.e(th, "hlUtil", "pdr");
        }
    }
}
