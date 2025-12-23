package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.amap.api.col.p0003l.Cif;
import com.amap.api.col.p0003l.w6;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class g4 {
    private static volatile boolean D = false;

    /* renamed from: a, reason: collision with root package name */
    public static int f6287a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f6288b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f6289c = "6";

    /* renamed from: d, reason: collision with root package name */
    private static String f6290d = "4";

    /* renamed from: e, reason: collision with root package name */
    private static String f6291e = "9";

    /* renamed from: f, reason: collision with root package name */
    private static String f6292f = "8";

    /* renamed from: g, reason: collision with root package name */
    public static Context f6293g = null;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f6294h = true;

    /* renamed from: i, reason: collision with root package name */
    private static Vector<f> f6295i = new Vector<>();

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Integer> f6296j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static String f6297k = null;

    /* renamed from: l, reason: collision with root package name */
    private static long f6298l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static volatile boolean f6299m = false;

    /* renamed from: n, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, h> f6300n = new ConcurrentHashMap<>(8);

    /* renamed from: o, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f6301o = new ConcurrentHashMap<>(8);

    /* renamed from: p, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, e> f6302p = new ConcurrentHashMap<>(8);

    /* renamed from: q, reason: collision with root package name */
    private static boolean f6303q = false;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f6304r = false;

    /* renamed from: s, reason: collision with root package name */
    public static int f6305s = 5000;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f6306t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f6307u = false;

    /* renamed from: v, reason: collision with root package name */
    private static int f6308v = 3;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f6309w = true;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f6310x = false;

    /* renamed from: y, reason: collision with root package name */
    private static int f6311y = 3;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f6312z = false;
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static ArrayList<w6.a> C = new ArrayList<>();
    private static Queue<w6.c> E = new LinkedList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends b8 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f6313d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f6314e;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f6315g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f6316h;

        a(String str, String str2, String str3, String str4) {
            this.f6313d = str;
            this.f6314e = str2;
            this.f6315g = str3;
            this.f6316h = str4;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            e eVar = (e) g4.f6302p.get(this.f6313d);
            if (eVar != null) {
                b bVar = eVar.f6337c;
                c b6 = g4.b(g4.f6293g, eVar.f6335a, eVar.f6336b, this.f6314e, this.f6315g, this.f6316h);
                if (b6 != null && bVar != null) {
                    bVar.a(b6);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(c cVar);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        @Deprecated
        public JSONObject f6317a;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public JSONObject f6318b;

        /* renamed from: c, reason: collision with root package name */
        public String f6319c;

        /* renamed from: d, reason: collision with root package name */
        public int f6320d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f6321e = 0;

        /* renamed from: f, reason: collision with root package name */
        public JSONObject f6322f;

        /* renamed from: g, reason: collision with root package name */
        public a f6323g;

        /* renamed from: h, reason: collision with root package name */
        public b f6324h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f6325i;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f6326a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f6327b;

            /* renamed from: c, reason: collision with root package name */
            public JSONObject f6328c;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public boolean f6329a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends s6 {

        /* renamed from: r, reason: collision with root package name */
        private String f6330r;

        /* renamed from: s, reason: collision with root package name */
        private Map<String, String> f6331s;

        /* renamed from: t, reason: collision with root package name */
        private String f6332t;

        /* renamed from: u, reason: collision with root package name */
        private String f6333u;

        /* renamed from: v, reason: collision with root package name */
        private String f6334v;

        @Override // com.amap.api.col.p0003l.s6
        public final byte[] c() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.s6
        public final byte[] d() {
            String Z = i4.Z(((s6) this).f7245a);
            if (!TextUtils.isEmpty(Z)) {
                Z = m4.d(new StringBuilder(Z).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f6330r) ? "" : this.f6330r);
            hashMap.put("plattype", FaceEnvironment.OS);
            hashMap.put("ccver", "1");
            hashMap.put("product", ((s6) this).f7246b.a());
            hashMap.put("version", ((s6) this).f7246b.e());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", Z);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f6331s;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f6331s);
            }
            hashMap.put("abitype", q4.d(((s6) this).f7245a));
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, ((s6) this).f7246b.g());
            return q4.o(q4.f(hashMap));
        }

        @Override // com.amap.api.col.p0003l.s6
        protected final String e() {
            return SocializeConstants.PROTOCOL_VERSON;
        }

        @Override // com.amap.api.col.p0003l.Cif
        protected final String getIPDNSName() {
            return !TextUtils.isEmpty(this.f6334v) ? this.f6334v : super.getIPDNSName();
        }

        @Override // com.amap.api.col.p0003l.l4, com.amap.api.col.p0003l.Cif
        public final String getIPV6URL() {
            return m("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f6333u);
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f6334v)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f6334v);
            return hashMap;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return m("https://restsdk.amap.com/v3/iasdkauth", this.f6332t);
        }

        d(Context context, p4 p4Var, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, p4Var);
            this.f6330r = str;
            this.f6331s = map;
            this.f6332t = str2;
            this.f6333u = str3;
            this.f6334v = str4;
            setHttpProtocol(Cif.c.HTTPS);
            setDegradeAbility(Cif.a.FIX);
        }

        private static String m(String str, String str2) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString();
                }
                return str;
            } catch (Throwable unused) {
                return str;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        p4 f6335a;

        /* renamed from: b, reason: collision with root package name */
        String f6336b;

        /* renamed from: c, reason: collision with root package name */
        b f6337c;

        private e() {
        }

        /* synthetic */ e(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private String f6338a;

        /* renamed from: b, reason: collision with root package name */
        private String f6339b;

        /* renamed from: c, reason: collision with root package name */
        private AtomicInteger f6340c;

        public final int a() {
            AtomicInteger atomicInteger = this.f6340c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.f6339b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f6338a);
                jSONObject.put("f", this.f6339b);
                jSONObject.put("h", this.f6340c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }

        public f(String str, String str2, int i6) {
            this.f6338a = str;
            this.f6339b = str2;
            this.f6340c = new AtomicInteger(i6);
        }

        public static f d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new f(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public static boolean f6341a = true;

        /* renamed from: b, reason: collision with root package name */
        public static boolean f6342b = false;

        /* renamed from: c, reason: collision with root package name */
        public static boolean f6343c = true;

        /* renamed from: d, reason: collision with root package name */
        public static int f6344d;

        /* renamed from: e, reason: collision with root package name */
        public static boolean f6345e;

        /* renamed from: f, reason: collision with root package name */
        public static int f6346f;
    }

    public static boolean U(String str) {
        f e6;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f6306t && A.get(str) == null) {
                Context context = f6293g;
                if (context == null || (e6 = e(context, B(str, "a14"), "open_common")) == null) {
                    return true;
                }
                if (e6.a() < f6308v) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean W(String str) {
        f e6;
        try {
            if (!TextUtils.isEmpty(str) && f6310x && B.get(str) == null) {
                Context context = f6293g;
                if (context == null || (e6 = e(context, B(str, "a15"), "open_common")) == null) {
                    return true;
                }
                if (e6.a() < f6311y) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static c b(Context context, p4 p4Var, String str, String str2, String str3, String str4) {
        return d(context, p4Var, str, null, str2, str3, str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0309 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(android.content.Context r20, com.amap.api.col.p0003l.p4 r21, java.lang.String r22, com.amap.api.col.3l.g4.c r23, org.json.JSONObject r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.g4.j(android.content.Context, com.amap.api.col.3l.p4, java.lang.String, com.amap.api.col.3l.g4$c, org.json.JSONObject):void");
    }

    private static c z(Context context, p4 p4Var, String str, Map<String, String> map) {
        return d(context, p4Var, str, map, null, null, null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public long f6347a;

        /* renamed from: b, reason: collision with root package name */
        public String f6348b;

        h(Long l6, String str) {
            this.f6347a = 0L;
            this.f6348b = "";
            this.f6347a = l6.longValue();
            this.f6348b = str;
        }
    }

    public static p4 A(String str) {
        e eVar = f6302p.get(str);
        if (eVar != null) {
            return eVar.f6335a;
        }
        return null;
    }

    private static String C(List<String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            String str = list.get(0);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void D(Context context) {
        if (context == null) {
            return;
        }
        f6294h = g6.l(context, "open_common", "a2", true);
    }

    public static void E(w6.c cVar) {
        synchronized (C) {
            boolean z5 = false;
            for (int i6 = 0; i6 < C.size(); i6++) {
                try {
                    w6.a aVar = C.get(i6);
                    if (cVar.f7569c.equals(aVar.f7556b) && cVar.f7570d.equals(aVar.f7559e)) {
                        int i7 = cVar.f7579m;
                        int i8 = aVar.f7560f;
                        if (i7 == i8) {
                            z5 = true;
                            if (i8 == 1) {
                                aVar.f7563i = ((aVar.f7564j.get() * aVar.f7563i) + cVar.f7572f) / (aVar.f7564j.get() + 1);
                            }
                            aVar.f7564j.getAndIncrement();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z5) {
                C.add(new w6.a(cVar));
            }
            w6.s();
        }
    }

    public static synchronized void F(String str, boolean z5) {
        synchronized (g4.class) {
            r(str, z5, null, null, null);
        }
    }

    public static boolean G() {
        Integer num;
        Context context = f6293g;
        if (context == null) {
            return false;
        }
        String X = i4.X(context);
        return (TextUtils.isEmpty(X) || (num = f6296j.get(X.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    private static void I(Context context) {
        if (context == null) {
            return;
        }
        f6306t = g6.l(context, "open_common", "a13", true);
        f6309w = g6.l(context, "open_common", "a6", true);
        f6307u = g6.l(context, "open_common", "a7", false);
        f6305s = g6.a(context, "open_common", "a8", 5000);
        f6308v = g6.a(context, "open_common", "a9", 3);
        f6310x = g6.l(context, "open_common", "a10", false);
        f6311y = g6.a(context, "open_common", "a11", 3);
        f6312z = g6.l(context, "open_common", "a12", false);
    }

    public static void J(w6.c cVar) {
        if (cVar != null && f6312z) {
            synchronized (E) {
                E.offer(cVar);
                w6.s();
            }
        }
    }

    public static boolean K() {
        Integer num;
        Context context = f6293g;
        if (context == null) {
            return false;
        }
        String X = i4.X(context);
        return (TextUtils.isEmpty(X) || (num = f6296j.get(X.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void L() {
        try {
            f e6 = e(f6293g, "IPV6_CONFIG_NAME", "open_common");
            String c6 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
            if (!c6.equals(e6.f6339b)) {
                e6.c(c6);
                e6.f6340c.set(0);
            }
            e6.f6340c.incrementAndGet();
            m(f6293g, "IPV6_CONFIG_NAME", "open_common", e6);
        } catch (Throwable unused) {
        }
    }

    private static void M(Context context) {
        try {
            if (f6303q) {
                return;
            }
            f5.f6178e = g6.l(context, "open_common", "a4", true);
            f5.f6179f = g6.l(context, "open_common", "a5", true);
            f6303q = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized boolean N(String str) {
        synchronized (g4.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f6302p == null) {
                return false;
            }
            if (f6301o == null) {
                f6301o = new ConcurrentHashMap<>(8);
            }
            if (f6302p.containsKey(str) && !f6301o.containsKey(str)) {
                f6301o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static void O() {
        if (f6299m) {
            return;
        }
        try {
            Context context = f6293g;
            if (context == null) {
                return;
            }
            f6299m = true;
            k4.a().c(context);
            D(context);
            I(context);
            g.f6341a = g6.l(context, "open_common", "ucf", g.f6341a);
            g.f6342b = g6.l(context, "open_common", "fsv2", g.f6342b);
            g.f6343c = g6.l(context, "open_common", "usc", g.f6343c);
            g.f6344d = g6.a(context, "open_common", "umv", g.f6344d);
            g.f6345e = g6.l(context, "open_common", "ust", g.f6345e);
            g.f6346f = g6.a(context, "open_common", "ustv", g.f6346f);
        } catch (Throwable unused) {
        }
    }

    private static void P(Context context) {
        try {
            if (f6304r) {
                return;
            }
            s4.f7230d = x(g6.o(context, "open_common", "a16", ""), true);
            s4.f7228b = g6.b(context, "open_common", "a17", s4.f7227a);
            f6304r = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void Q(String str) {
        synchronized (g4.class) {
            if (f6301o == null) {
                return;
            }
            if (f6301o.containsKey(str)) {
                f6301o.remove(str);
            }
        }
    }

    public static synchronized h R(String str) {
        synchronized (g4.class) {
            try {
                if (f6300n == null) {
                    f6300n = new ConcurrentHashMap<>(8);
                }
                if (f6300n.containsKey(str)) {
                    return f6300n.get(str);
                }
            } finally {
                return new h(0L, "");
            }
            return new h(0L, "");
        }
    }

    public static w6.a S() {
        if (D) {
            return null;
        }
        synchronized (C) {
            try {
                if (D) {
                    return null;
                }
                Collections.sort(C);
                if (C.size() <= 0) {
                    return null;
                }
                w6.a clone = C.get(0).clone();
                D = true;
                return clone;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static w6.c T() {
        synchronized (E) {
            try {
                w6.c poll = E.poll();
                if (poll != null) {
                    return poll;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void X() {
        try {
            Context context = f6293g;
            if (context != null) {
                String X = i4.X(context);
                if (!TextUtils.isEmpty(f6297k) && !TextUtils.isEmpty(X) && f6297k.equals(X) && System.currentTimeMillis() - f6298l < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(X)) {
                    f6297k = X;
                }
            } else if (System.currentTimeMillis() - f6298l < 10000) {
                return;
            }
            f6298l = System.currentTimeMillis();
            f6296j.clear();
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    String displayName = networkInterface.getDisplayName();
                    Iterator<InterfaceAddress> it2 = networkInterface.getInterfaceAddresses().iterator();
                    int i6 = 0;
                    while (it2.hasNext()) {
                        InetAddress address = it2.next().getAddress();
                        if (address instanceof Inet6Address) {
                            if (!y((Inet6Address) address)) {
                                i6 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!y(inet4Address) && !inet4Address.getHostAddress().startsWith(q4.u("FMTkyLjE2OC40My4"))) {
                                i6 |= 1;
                            }
                        }
                    }
                    if (i6 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f6296j.put("WIFI", Integer.valueOf(i6));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f6296j.put("MOBILE", Integer.valueOf(i6));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            r5.e(th, "at", "ipstack");
        }
    }

    public static long a(List<String> list) {
        if (list == null) {
            return 0L;
        }
        try {
            if (list.size() <= 0) {
                return 0L;
            }
            String str = list.get(0);
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.valueOf(str).longValue();
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01ab  */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.3l.g4.c d(android.content.Context r22, com.amap.api.col.p0003l.p4 r23, java.lang.String r24, java.util.Map<java.lang.String, java.lang.String> r25, java.lang.String r26, java.lang.String r27, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.g4.d(android.content.Context, com.amap.api.col.3l.p4, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.3l.g4$c");
    }

    private static synchronized f e(Context context, String str, String str2) {
        f fVar;
        synchronized (g4.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i6 = 0; i6 < f6295i.size(); i6++) {
                    fVar = f6295i.get(i6);
                    if (fVar != null && str.equals(fVar.f6338a)) {
                        break;
                    }
                }
            }
            fVar = null;
            if (fVar != null) {
                return fVar;
            }
            if (context == null) {
                return null;
            }
            f d6 = f.d(g6.o(context, str2, str, ""));
            String c6 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
            if (d6 == null) {
                d6 = new f(str, c6, 0);
            }
            if (!c6.equals(d6.f6339b)) {
                d6.c(c6);
                d6.f6340c.set(0);
            }
            f6295i.add(d6);
            return d6;
        }
    }

    public static String f(String str) {
        e eVar;
        if (!f6302p.containsKey(str) || (eVar = f6302p.get(str)) == null) {
            return null;
        }
        return eVar.f6336b;
    }

    public static void g(Context context) {
        if (context != null) {
            f6293g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private static void h(Context context, p4 p4Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", p4Var.a());
        hashMap.put("amap_sdk_version", p4Var.f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            h7 h7Var = new h7(context, "core", "2.0", "O001");
            h7Var.a(jSONObject);
            i7.d(h7Var, context);
        } catch (fk unused) {
        }
    }

    public static synchronized void i(Context context, p4 p4Var, String str, b bVar) {
        synchronized (g4.class) {
            if (context == null || p4Var == null) {
                return;
            }
            try {
                if (f6293g == null) {
                    f6293g = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                String a6 = p4Var.a();
                if (TextUtils.isEmpty(a6)) {
                    return;
                }
                n(p4Var);
                if (f6302p == null) {
                    f6302p = new ConcurrentHashMap<>(8);
                }
                if (f6301o == null) {
                    f6301o = new ConcurrentHashMap<>(8);
                }
                if (f6300n == null) {
                    f6300n = new ConcurrentHashMap<>(8);
                }
                if (!f6302p.containsKey(a6)) {
                    e eVar = new e((byte) 0);
                    eVar.f6335a = p4Var;
                    eVar.f6336b = str;
                    eVar.f6337c = bVar;
                    f6302p.put(a6, eVar);
                    f6300n.put(a6, new h(Long.valueOf(g6.b(f6293g, "open_common", a6, 0L)), g6.o(f6293g, "open_common", a6 + "lct-info", "")));
                    M(f6293g);
                    P(f6293g);
                }
            } catch (Throwable th) {
                r5.e(th, "at", "rglc");
            }
        }
    }

    private static void m(Context context, String str, String str2, f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.f6338a)) {
            return;
        }
        String e6 = fVar.e();
        if (TextUtils.isEmpty(e6) || context == null) {
            return;
        }
        SharedPreferences.Editor c6 = g6.c(context, str2);
        c6.putString(str, e6);
        g6.f(c6);
    }

    private static void n(p4 p4Var) {
        if (p4Var != null) {
            try {
                if (TextUtils.isEmpty(p4Var.a())) {
                    return;
                }
                String f6 = p4Var.f();
                if (TextUtils.isEmpty(f6)) {
                    f6 = p4Var.e();
                }
                if (TextUtils.isEmpty(f6)) {
                    return;
                }
                f5.b(p4Var.a(), f6);
            } catch (Throwable unused) {
            }
        }
    }

    public static void o(w6.c cVar) {
        if (cVar == null || f6293g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.f7569c);
        hashMap.put("hostname", cVar.f7571e);
        hashMap.put("path", cVar.f7570d);
        hashMap.put("csid", cVar.f7567a);
        hashMap.put("degrade", String.valueOf(cVar.f7568b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.f7579m));
        hashMap.put("errorsubcode", String.valueOf(cVar.f7580n));
        hashMap.put("connecttime", String.valueOf(cVar.f7574h));
        hashMap.put("writetime", String.valueOf(cVar.f7575i));
        hashMap.put("readtime", String.valueOf(cVar.f7576j));
        hashMap.put("datasize", String.valueOf(cVar.f7578l));
        hashMap.put("totaltime", String.valueOf(cVar.f7572f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        w6.s();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            h7 h7Var = new h7(f6293g, "core", "2.0", "O008");
            h7Var.a(jSONObject);
            i7.d(h7Var, f6293g);
        } catch (fk unused) {
        }
    }

    private static synchronized void p(String str, long j6, String str2) {
        synchronized (g4.class) {
            try {
                if (f6302p != null && f6302p.containsKey(str)) {
                    if (f6300n == null) {
                        f6300n = new ConcurrentHashMap<>(8);
                    }
                    f6300n.put(str, new h(Long.valueOf(j6), str2));
                    Context context = f6293g;
                    if (context != null) {
                        SharedPreferences.Editor c6 = g6.c(context, "open_common");
                        g6.i(c6, str, j6);
                        g6.j(c6, str + "lct-info", str2);
                        g6.f(c6);
                    }
                }
            } catch (Throwable th) {
                r5.e(th, "at", "ucut");
            }
        }
    }

    private static void q(String str, String str2) {
        f e6 = e(f6293g, str, str2);
        String c6 = q4.c(System.currentTimeMillis(), "yyyyMMdd");
        if (!c6.equals(e6.f6339b)) {
            e6.c(c6);
            e6.f6340c.set(0);
        }
        e6.f6340c.incrementAndGet();
        m(f6293g, str, str2, e6);
    }

    public static synchronized void r(String str, boolean z5, String str2, String str3, String str4) {
        synchronized (g4.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f6301o == null) {
                    f6301o = new ConcurrentHashMap<>(8);
                }
                f6301o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f6302p == null) {
                    return;
                }
                if (f6302p.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z5) {
                        v6.j(true, str);
                    }
                    a8.h().b(new a(str, str2, str3, str4));
                }
            } catch (Throwable th) {
                r5.e(th, "at", "lca");
            }
        }
    }

    public static void t(boolean z5, w6.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z5) {
                try {
                    Iterator<w6.a> it = C.iterator();
                    while (it.hasNext()) {
                        w6.a next = it.next();
                        if (next.f7556b.equals(aVar.f7556b) && next.f7559e.equals(aVar.f7559e) && next.f7560f == aVar.f7560f) {
                            if (next.f7564j == aVar.f7564j) {
                                it.remove();
                                w6.s();
                            } else {
                                next.f7564j.set(next.f7564j.get() - aVar.f7564j.get());
                                w6.s();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            D = false;
            Iterator<w6.a> it2 = C.iterator();
            w6.s();
            while (it2.hasNext()) {
                w6.a next2 = it2.next();
                String str = next2.f7559e;
                Objects.toString(next2.f7564j);
                w6.s();
            }
            w6.s();
        }
    }

    public static void u(boolean z5, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            w6.s();
            if (f6306t || z5) {
                if ((f6310x || !z5) && !TextUtils.isEmpty(str)) {
                    if (z5) {
                        if (B.get(str) != null) {
                            return;
                        }
                        B.put(str, Boolean.TRUE);
                        q(B(str, "a15"), "open_common");
                        return;
                    }
                    if (A.get(str) != null) {
                        return;
                    }
                    A.put(str, Boolean.TRUE);
                    q(B(str, "a14"), "open_common");
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean v() {
        f e6;
        if (f6293g != null) {
            X();
            if (!K()) {
                return false;
            }
            if (G()) {
                return true;
            }
        }
        return f6294h && (e6 = e(f6293g, "IPV6_CONFIG_NAME", "open_common")) != null && e6.a() < 5;
    }

    public static synchronized boolean w(String str, long j6) {
        synchronized (g4.class) {
            boolean z5 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h R = R(str);
            long j7 = 0;
            if (j6 != (R != null ? R.f6347a : 0L)) {
                if (f6301o != null && f6301o.containsKey(str)) {
                    j7 = f6301o.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j7 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    z5 = true;
                }
            }
            return z5;
        }
    }

    private static String B(String str, String str2) {
        return str2 + "_" + m4.b(str.getBytes());
    }

    public static String H(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str + ";15K;16H;17I;1A4;17S;183";
        }
        return str;
    }

    public static c c(Context context, p4 p4Var, String str, Map<String, String> map) {
        return z(context, p4Var, str, map);
    }

    private static void k(Context context, p4 p4Var, Throwable th) {
        h(context, p4Var, th.getMessage());
    }

    public static void l(Context context, String str) {
        f4.b(context, str);
    }

    public static void s(String str, boolean z5, boolean z6, boolean z7) {
        Object obj;
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str) && f6293g != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("downLevel", String.valueOf(z5));
            String str4 = "1";
            if (i4.M(f6293g) != 0) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("ant", obj);
            if (z7) {
                if (z5) {
                    str3 = f6291e;
                } else {
                    str3 = f6292f;
                }
                hashMap.put("type", str3);
            } else {
                if (z5) {
                    str2 = f6289c;
                } else {
                    str2 = f6290d;
                }
                hashMap.put("type", str2);
            }
            if (z6) {
                str4 = "0";
            }
            hashMap.put(NotificationCompat.CATEGORY_STATUS, str4);
            String jSONObject = new JSONObject(hashMap).toString();
            if (!TextUtils.isEmpty(jSONObject)) {
                try {
                    h7 h7Var = new h7(f6293g, "core", "2.0", "O002");
                    h7Var.a(jSONObject);
                    i7.d(h7Var, f6293g);
                } catch (fk unused) {
                }
            }
        }
    }

    public static boolean x(String str, boolean z5) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        }
        return z5;
    }

    private static boolean y(InetAddress inetAddress) {
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !inetAddress.isAnyLocalAddress()) {
            return false;
        }
        return true;
    }
}
