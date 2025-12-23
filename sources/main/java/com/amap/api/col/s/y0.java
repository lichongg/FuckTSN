package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.WorkRequest;
import com.amap.api.col.s.dz;
import com.amap.api.col.s.x2;
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
public final class y0 {
    private static volatile boolean D = false;

    /* renamed from: a, reason: collision with root package name */
    public static int f8707a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f8708b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f8709c = "6";

    /* renamed from: d, reason: collision with root package name */
    private static String f8710d = "4";

    /* renamed from: e, reason: collision with root package name */
    private static String f8711e = "9";

    /* renamed from: f, reason: collision with root package name */
    private static String f8712f = "8";

    /* renamed from: g, reason: collision with root package name */
    public static Context f8713g = null;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f8714h = true;

    /* renamed from: i, reason: collision with root package name */
    private static Vector<f> f8715i = new Vector<>();

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, Integer> f8716j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private static String f8717k = null;

    /* renamed from: l, reason: collision with root package name */
    private static long f8718l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static volatile boolean f8719m = false;

    /* renamed from: n, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, h> f8720n = new ConcurrentHashMap<>(8);

    /* renamed from: o, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, Long> f8721o = new ConcurrentHashMap<>(8);

    /* renamed from: p, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, e> f8722p = new ConcurrentHashMap<>(8);

    /* renamed from: q, reason: collision with root package name */
    private static boolean f8723q = false;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f8724r = false;

    /* renamed from: s, reason: collision with root package name */
    public static int f8725s = 5000;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f8726t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f8727u = false;

    /* renamed from: v, reason: collision with root package name */
    private static int f8728v = 3;

    /* renamed from: w, reason: collision with root package name */
    public static boolean f8729w = true;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f8730x = false;

    /* renamed from: y, reason: collision with root package name */
    private static int f8731y = 3;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f8732z = false;
    private static ConcurrentHashMap<String, Boolean> A = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Boolean> B = new ConcurrentHashMap<>();
    private static ArrayList<x2.a> C = new ArrayList<>();
    private static Queue<x2.c> E = new LinkedList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends z3 {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8733b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f8734c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f8735d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f8736e;

        a(String str, String str2, String str3, String str4) {
            this.f8733b = str;
            this.f8734c = str2;
            this.f8735d = str3;
            this.f8736e = str4;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            e eVar = (e) y0.f8722p.get(this.f8733b);
            if (eVar != null) {
                b bVar = eVar.f8757c;
                c b6 = y0.b(y0.f8713g, eVar.f8755a, eVar.f8756b, this.f8734c, this.f8735d, this.f8736e);
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
        public JSONObject f8737a;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public JSONObject f8738b;

        /* renamed from: c, reason: collision with root package name */
        public String f8739c;

        /* renamed from: d, reason: collision with root package name */
        public int f8740d = -1;

        /* renamed from: e, reason: collision with root package name */
        public long f8741e = 0;

        /* renamed from: f, reason: collision with root package name */
        public JSONObject f8742f;

        /* renamed from: g, reason: collision with root package name */
        public a f8743g;

        /* renamed from: h, reason: collision with root package name */
        public b f8744h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f8745i;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f8746a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f8747b;

            /* renamed from: c, reason: collision with root package name */
            public JSONObject f8748c;
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public boolean f8749a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends v2 {

        /* renamed from: p, reason: collision with root package name */
        private String f8750p;

        /* renamed from: q, reason: collision with root package name */
        private Map<String, String> f8751q;

        /* renamed from: r, reason: collision with root package name */
        private String f8752r;

        /* renamed from: s, reason: collision with root package name */
        private String f8753s;

        /* renamed from: t, reason: collision with root package name */
        private String f8754t;

        @Override // com.amap.api.col.s.v2
        public final byte[] L() {
            String K = c1.K(this.f8575m);
            if (!TextUtils.isEmpty(K)) {
                K = g1.a(new StringBuilder(K).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f8750p) ? "" : this.f8750p);
            hashMap.put("plattype", FaceEnvironment.OS);
            hashMap.put("ccver", "1");
            hashMap.put("product", this.f8576n.d());
            hashMap.put("version", this.f8576n.e());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", K);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f8751q;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f8751q);
            }
            hashMap.put("abitype", j1.d(this.f8575m));
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, this.f8576n.g());
            return j1.o(j1.f(hashMap));
        }

        @Override // com.amap.api.col.s.v2
        protected final String M() {
            return SocializeConstants.PROTOCOL_VERSON;
        }

        @Override // com.amap.api.col.s.f1, com.amap.api.col.s.dz
        public final String a() {
            return P("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f8753s);
        }

        @Override // com.amap.api.col.s.dz
        public final String h() {
            return P("https://restsdk.amap.com/v3/iasdkauth", this.f8752r);
        }

        @Override // com.amap.api.col.s.dz
        public final Map<String, String> p() {
            if (TextUtils.isEmpty(this.f8754t)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f8754t);
            return hashMap;
        }

        @Override // com.amap.api.col.s.dz
        protected final String r() {
            return !TextUtils.isEmpty(this.f8754t) ? this.f8754t : super.r();
        }

        d(Context context, i1 i1Var, String str, String str2, String str3, String str4) {
            super(context, i1Var);
            this.f8750p = str;
            this.f8751q = null;
            this.f8752r = str2;
            this.f8753s = str3;
            this.f8754t = str4;
            g(dz.c.HTTPS);
            e(dz.a.FIX);
        }

        private static String P(String str, String str2) {
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
        i1 f8755a;

        /* renamed from: b, reason: collision with root package name */
        String f8756b;

        /* renamed from: c, reason: collision with root package name */
        b f8757c;

        private e() {
        }

        /* synthetic */ e(byte b6) {
            this();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private String f8758a;

        /* renamed from: b, reason: collision with root package name */
        private String f8759b;

        /* renamed from: c, reason: collision with root package name */
        private AtomicInteger f8760c;

        public final int a() {
            AtomicInteger atomicInteger = this.f8760c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.f8759b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f8758a);
                jSONObject.put("f", this.f8759b);
                jSONObject.put("h", this.f8760c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }

        public f(String str, String str2, int i6) {
            this.f8758a = str;
            this.f8759b = str2;
            this.f8760c = new AtomicInteger(i6);
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
        public static boolean f8761a = true;

        /* renamed from: b, reason: collision with root package name */
        public static boolean f8762b = false;

        /* renamed from: c, reason: collision with root package name */
        public static boolean f8763c = true;

        /* renamed from: d, reason: collision with root package name */
        public static int f8764d;

        /* renamed from: e, reason: collision with root package name */
        public static boolean f8765e;

        /* renamed from: f, reason: collision with root package name */
        public static int f8766f;
    }

    public static boolean R(String str) {
        f c6;
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (f8726t && A.get(str) == null) {
                Context context = f8713g;
                if (context == null || (c6 = c(context, y(str, "a14"), "open_common")) == null) {
                    return true;
                }
                if (c6.a() < f8728v) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean T(String str) {
        f c6;
        try {
            if (!TextUtils.isEmpty(str) && f8730x && B.get(str) == null) {
                Context context = f8713g;
                if (context == null || (c6 = c(context, y(str, "a15"), "open_common")) == null) {
                    return true;
                }
                if (c6.a() < f8731y) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
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
    private static void h(android.content.Context r20, com.amap.api.col.s.i1 r21, java.lang.String r22, com.amap.api.col.s.y0.c r23, org.json.JSONObject r24) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.y0.h(android.content.Context, com.amap.api.col.s.i1, java.lang.String, com.amap.api.col.s.y0$c, org.json.JSONObject):void");
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public long f8767a;

        /* renamed from: b, reason: collision with root package name */
        public String f8768b;

        h(Long l6, String str) {
            this.f8767a = 0L;
            this.f8768b = "";
            this.f8767a = l6.longValue();
            this.f8768b = str;
        }
    }

    private static void A(Context context) {
        if (context == null) {
            return;
        }
        f8714h = j2.l(context, "open_common", "a2", true);
    }

    public static void B(x2.c cVar) {
        synchronized (C) {
            boolean z5 = false;
            for (int i6 = 0; i6 < C.size(); i6++) {
                try {
                    x2.a aVar = C.get(i6);
                    if (cVar.f8656c.equals(aVar.f8643b) && cVar.f8657d.equals(aVar.f8646e)) {
                        int i7 = cVar.f8666m;
                        int i8 = aVar.f8647f;
                        if (i7 == i8) {
                            z5 = true;
                            if (i8 == 1) {
                                aVar.f8650i = ((aVar.f8651j.get() * aVar.f8650i) + cVar.f8659f) / (aVar.f8651j.get() + 1);
                            }
                            aVar.f8651j.getAndIncrement();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z5) {
                C.add(new x2.a(cVar));
            }
            x2.i();
        }
    }

    public static synchronized void C(String str, boolean z5) {
        synchronized (y0.class) {
            o(str, z5, null, null, null);
        }
    }

    public static boolean D() {
        Integer num;
        Context context = f8713g;
        if (context == null) {
            return false;
        }
        String I = c1.I(context);
        return (TextUtils.isEmpty(I) || (num = f8716j.get(I.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void F() {
        try {
            f c6 = c(f8713g, "IPV6_CONFIG_NAME", "open_common");
            String c7 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
            if (!c7.equals(c6.f8759b)) {
                c6.c(c7);
                c6.f8760c.set(0);
            }
            c6.f8760c.incrementAndGet();
            j(f8713g, "IPV6_CONFIG_NAME", "open_common", c6);
        } catch (Throwable unused) {
        }
    }

    private static void G(Context context) {
        if (context == null) {
            return;
        }
        f8726t = j2.l(context, "open_common", "a13", true);
        f8729w = j2.l(context, "open_common", "a6", true);
        f8727u = j2.l(context, "open_common", "a7", false);
        f8725s = j2.a(context, "open_common", "a8", 5000);
        f8728v = j2.a(context, "open_common", "a9", 3);
        f8730x = j2.l(context, "open_common", "a10", false);
        f8731y = j2.a(context, "open_common", "a11", 3);
        f8732z = j2.l(context, "open_common", "a12", false);
    }

    public static void H(x2.c cVar) {
        if (cVar != null && f8732z) {
            synchronized (E) {
                E.offer(cVar);
                x2.i();
            }
        }
    }

    public static void I() {
        if (f8719m) {
            return;
        }
        try {
            Context context = f8713g;
            if (context == null) {
                return;
            }
            f8719m = true;
            e1.a().c(context);
            A(context);
            G(context);
            g.f8761a = j2.l(context, "open_common", "ucf", g.f8761a);
            g.f8762b = j2.l(context, "open_common", "fsv2", g.f8762b);
            g.f8763c = j2.l(context, "open_common", "usc", g.f8763c);
            g.f8764d = j2.a(context, "open_common", "umv", g.f8764d);
            g.f8765e = j2.l(context, "open_common", "ust", g.f8765e);
            g.f8766f = j2.a(context, "open_common", "ustv", g.f8766f);
        } catch (Throwable unused) {
        }
    }

    private static void J(Context context) {
        try {
            if (f8723q) {
                return;
            }
            s1.f8430e = j2.l(context, "open_common", "a4", true);
            s1.f8431f = j2.l(context, "open_common", "a5", true);
            f8723q = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized boolean K(String str) {
        synchronized (y0.class) {
            try {
            } finally {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (f8722p == null) {
                return false;
            }
            if (f8721o == null) {
                f8721o = new ConcurrentHashMap<>(8);
            }
            if (f8722p.containsKey(str) && !f8721o.containsKey(str)) {
                f8721o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static x2.a L() {
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
                x2.a clone = C.get(0).clone();
                D = true;
                return clone;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void M(Context context) {
        try {
            if (f8724r) {
                return;
            }
            l1.f8228d = u(j2.o(context, "open_common", "a16", ""), true);
            l1.f8226b = j2.b(context, "open_common", "a17", l1.f8225a);
            f8724r = true;
        } catch (Throwable unused) {
        }
    }

    public static synchronized void N(String str) {
        synchronized (y0.class) {
            if (f8721o == null) {
                return;
            }
            if (f8721o.containsKey(str)) {
                f8721o.remove(str);
            }
        }
    }

    public static synchronized h O(String str) {
        synchronized (y0.class) {
            try {
                if (f8720n == null) {
                    f8720n = new ConcurrentHashMap<>(8);
                }
                if (f8720n.containsKey(str)) {
                    return f8720n.get(str);
                }
            } finally {
                return new h(0L, "");
            }
            return new h(0L, "");
        }
    }

    public static x2.c P() {
        synchronized (E) {
            try {
                x2.c poll = E.poll();
                if (poll != null) {
                    return poll;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void S() {
        try {
            Context context = f8713g;
            if (context != null) {
                String I = c1.I(context);
                if (!TextUtils.isEmpty(f8717k) && !TextUtils.isEmpty(I) && f8717k.equals(I) && System.currentTimeMillis() - f8718l < 60000) {
                    return;
                }
                if (!TextUtils.isEmpty(I)) {
                    f8717k = I;
                }
            } else if (System.currentTimeMillis() - f8718l < 10000) {
                return;
            }
            f8718l = System.currentTimeMillis();
            f8716j.clear();
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
                            if (!v((Inet6Address) address)) {
                                i6 |= 2;
                            }
                        } else if (address instanceof Inet4Address) {
                            Inet4Address inet4Address = (Inet4Address) address;
                            if (!v(inet4Address) && !inet4Address.getHostAddress().startsWith(j1.t("FMTkyLjE2OC40My4"))) {
                                i6 |= 1;
                            }
                        }
                    }
                    if (i6 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            f8716j.put("WIFI", Integer.valueOf(i6));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            f8716j.put("MOBILE", Integer.valueOf(i6));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d2.e(th, "at", "ipstack");
        }
    }

    private static boolean U() {
        Integer num;
        Context context = f8713g;
        if (context == null) {
            return false;
        }
        String I = c1.I(context);
        return (TextUtils.isEmpty(I) || (num = f8716j.get(I.toUpperCase())) == null || num.intValue() != 2) ? false : true;
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

    private static synchronized f c(Context context, String str, String str2) {
        f fVar;
        synchronized (y0.class) {
            if (!TextUtils.isEmpty(str)) {
                for (int i6 = 0; i6 < f8715i.size(); i6++) {
                    fVar = f8715i.get(i6);
                    if (fVar != null && str.equals(fVar.f8758a)) {
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
            f d6 = f.d(j2.o(context, str2, str, ""));
            String c6 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
            if (d6 == null) {
                d6 = new f(str, c6, 0);
            }
            if (!c6.equals(d6.f8759b)) {
                d6.c(c6);
                d6.f8760c.set(0);
            }
            f8715i.add(d6);
            return d6;
        }
    }

    public static String d(String str) {
        e eVar;
        if (!f8722p.containsKey(str) || (eVar = f8722p.get(str)) == null) {
            return null;
        }
        return eVar.f8756b;
    }

    public static void e(Context context) {
        if (context != null) {
            f8713g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private static void f(Context context, i1 i1Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", i1Var.d());
        hashMap.put("amap_sdk_version", i1Var.f());
        String jSONObject = new JSONObject(hashMap).toString();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g3 g3Var = new g3(context, "core", "2.0", "O001");
            g3Var.a(jSONObject);
            h3.d(g3Var, context);
        } catch (bv unused) {
        }
    }

    public static synchronized void g(Context context, i1 i1Var, String str, b bVar) {
        synchronized (y0.class) {
            if (context == null || i1Var == null) {
                return;
            }
            try {
                if (f8713g == null) {
                    f8713g = StubApp.getOrigApplicationContext(context.getApplicationContext());
                }
                String d6 = i1Var.d();
                if (TextUtils.isEmpty(d6)) {
                    return;
                }
                k(i1Var);
                if (f8722p == null) {
                    f8722p = new ConcurrentHashMap<>(8);
                }
                if (f8721o == null) {
                    f8721o = new ConcurrentHashMap<>(8);
                }
                if (f8720n == null) {
                    f8720n = new ConcurrentHashMap<>(8);
                }
                if (!f8722p.containsKey(d6)) {
                    e eVar = new e((byte) 0);
                    eVar.f8755a = i1Var;
                    eVar.f8756b = str;
                    eVar.f8757c = bVar;
                    f8722p.put(d6, eVar);
                    f8720n.put(d6, new h(Long.valueOf(j2.b(f8713g, "open_common", d6, 0L)), j2.o(f8713g, "open_common", d6 + "lct-info", "")));
                    J(f8713g);
                    M(f8713g);
                }
            } catch (Throwable th) {
                d2.e(th, "at", "rglc");
            }
        }
    }

    private static void j(Context context, String str, String str2, f fVar) {
        if (fVar == null || TextUtils.isEmpty(fVar.f8758a)) {
            return;
        }
        String e6 = fVar.e();
        if (TextUtils.isEmpty(e6) || context == null) {
            return;
        }
        SharedPreferences.Editor c6 = j2.c(context, str2);
        c6.putString(str, e6);
        j2.f(c6);
    }

    private static void k(i1 i1Var) {
        if (i1Var != null) {
            try {
                if (TextUtils.isEmpty(i1Var.d())) {
                    return;
                }
                String f6 = i1Var.f();
                if (TextUtils.isEmpty(f6)) {
                    f6 = i1Var.e();
                }
                if (TextUtils.isEmpty(f6)) {
                    return;
                }
                s1.b(i1Var.d(), f6);
            } catch (Throwable unused) {
            }
        }
    }

    public static void l(x2.c cVar) {
        if (cVar == null || f8713g == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverip", cVar.f8656c);
        hashMap.put("hostname", cVar.f8658e);
        hashMap.put("path", cVar.f8657d);
        hashMap.put("csid", cVar.f8654a);
        hashMap.put("degrade", String.valueOf(cVar.f8655b.a()));
        hashMap.put("errorcode", String.valueOf(cVar.f8666m));
        hashMap.put("errorsubcode", String.valueOf(cVar.f8667n));
        hashMap.put("connecttime", String.valueOf(cVar.f8661h));
        hashMap.put("writetime", String.valueOf(cVar.f8662i));
        hashMap.put("readtime", String.valueOf(cVar.f8663j));
        hashMap.put("datasize", String.valueOf(cVar.f8665l));
        hashMap.put("totaltime", String.valueOf(cVar.f8659f));
        String jSONObject = new JSONObject(hashMap).toString();
        "--埋点--".concat(String.valueOf(jSONObject));
        x2.i();
        if (TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            g3 g3Var = new g3(f8713g, "core", "2.0", "O008");
            g3Var.a(jSONObject);
            h3.d(g3Var, f8713g);
        } catch (bv unused) {
        }
    }

    private static synchronized void m(String str, long j6, String str2) {
        synchronized (y0.class) {
            try {
                if (f8722p != null && f8722p.containsKey(str)) {
                    if (f8720n == null) {
                        f8720n = new ConcurrentHashMap<>(8);
                    }
                    f8720n.put(str, new h(Long.valueOf(j6), str2));
                    Context context = f8713g;
                    if (context != null) {
                        SharedPreferences.Editor c6 = j2.c(context, "open_common");
                        j2.i(c6, str, j6);
                        j2.j(c6, str + "lct-info", str2);
                        j2.f(c6);
                    }
                }
            } catch (Throwable th) {
                d2.e(th, "at", "ucut");
            }
        }
    }

    private static void n(String str, String str2) {
        f c6 = c(f8713g, str, str2);
        String c7 = j1.c(System.currentTimeMillis(), "yyyyMMdd");
        if (!c7.equals(c6.f8759b)) {
            c6.c(c7);
            c6.f8760c.set(0);
        }
        c6.f8760c.incrementAndGet();
        j(f8713g, str, str2, c6);
    }

    public static synchronized void o(String str, boolean z5, String str2, String str3, String str4) {
        synchronized (y0.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (f8721o == null) {
                    f8721o = new ConcurrentHashMap<>(8);
                }
                f8721o.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
                if (f8722p == null) {
                    return;
                }
                if (f8722p.containsKey(str)) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z5) {
                        w2.j(true, str);
                    }
                    y3.e().c(new a(str, str2, str3, str4));
                }
            } catch (Throwable th) {
                d2.e(th, "at", "lca");
            }
        }
    }

    public static void q(boolean z5, x2.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z5) {
                try {
                    Iterator<x2.a> it = C.iterator();
                    while (it.hasNext()) {
                        x2.a next = it.next();
                        if (next.f8643b.equals(aVar.f8643b) && next.f8646e.equals(aVar.f8646e) && next.f8647f == aVar.f8647f) {
                            if (next.f8651j == aVar.f8651j) {
                                it.remove();
                                x2.i();
                            } else {
                                next.f8651j.set(next.f8651j.get() - aVar.f8651j.get());
                                x2.i();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            D = false;
            Iterator<x2.a> it2 = C.iterator();
            x2.i();
            while (it2.hasNext()) {
                x2.a next2 = it2.next();
                String str = next2.f8646e;
                Objects.toString(next2.f8651j);
                x2.i();
            }
            x2.i();
        }
    }

    public static void r(boolean z5, String str) {
        try {
            "--markHostNameFailed---hostname=".concat(String.valueOf(str));
            x2.i();
            if (f8726t || z5) {
                if ((f8730x || !z5) && !TextUtils.isEmpty(str)) {
                    if (z5) {
                        if (B.get(str) != null) {
                            return;
                        }
                        B.put(str, Boolean.TRUE);
                        n(y(str, "a15"), "open_common");
                        return;
                    }
                    if (A.get(str) != null) {
                        return;
                    }
                    A.put(str, Boolean.TRUE);
                    n(y(str, "a14"), "open_common");
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean s() {
        f c6;
        if (f8713g != null) {
            S();
            if (!D()) {
                return false;
            }
            if (U()) {
                return true;
            }
        }
        return f8714h && (c6 = c(f8713g, "IPV6_CONFIG_NAME", "open_common")) != null && c6.a() < 5;
    }

    public static synchronized boolean t(String str, long j6) {
        synchronized (y0.class) {
            boolean z5 = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h O = O(str);
            long j7 = 0;
            if (j6 != (O != null ? O.f8767a : 0L)) {
                if (f8721o != null && f8721o.containsKey(str)) {
                    j7 = f8721o.get(str).longValue();
                }
                if (SystemClock.elapsedRealtime() - j7 > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    z5 = true;
                }
            }
            return z5;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:30|(1:32)(1:(14:54|(1:56)|57|(1:59)|60|(1:62)|63|(1:65)|34|35|(1:37)|39|40|(5:42|43|44|(1:46)(1:49)|47)))|33|34|35|(0)|39|40|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0238, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x023d, code lost:
    
        com.amap.api.col.s.d2.e(r0, "at", "lc");
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0231 A[Catch: all -> 0x0238, TRY_LEAVE, TryCatch #15 {all -> 0x0238, blocks: (B:35:0x022b, B:37:0x0231), top: B:34:0x022b, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0247 A[Catch: all -> 0x01e6, TRY_LEAVE, TryCatch #5 {all -> 0x01e6, blocks: (B:28:0x01d0, B:30:0x01db, B:32:0x01e2, B:40:0x0241, B:42:0x0247, B:52:0x023d, B:56:0x01f1, B:57:0x01f5, B:59:0x0204, B:60:0x020a, B:62:0x0212, B:63:0x0216, B:65:0x0226, B:35:0x022b, B:37:0x0231), top: B:27:0x01d0, inners: #15 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.amap.api.col.s.y0.c w(android.content.Context r22, com.amap.api.col.s.i1 r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.y0.w(android.content.Context, com.amap.api.col.s.i1, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.amap.api.col.s.y0$c");
    }

    public static i1 x(String str) {
        e eVar = f8722p.get(str);
        if (eVar != null) {
            return eVar.f8755a;
        }
        return null;
    }

    private static String z(List<String> list) {
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

    public static String E(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str + ";15K;16H;17I;1A4;17S;183";
        }
        return str;
    }

    public static c b(Context context, i1 i1Var, String str, String str2, String str3, String str4) {
        return w(context, i1Var, str, str2, str3, str4);
    }

    private static void i(Context context, i1 i1Var, Throwable th) {
        f(context, i1Var, th.getMessage());
    }

    public static void p(String str, boolean z5, boolean z6, boolean z7) {
        Object obj;
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str) && f8713g != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("downLevel", String.valueOf(z5));
            String str4 = "1";
            if (c1.D(f8713g) != 0) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("ant", obj);
            if (z7) {
                if (z5) {
                    str3 = f8711e;
                } else {
                    str3 = f8712f;
                }
                hashMap.put("type", str3);
            } else {
                if (z5) {
                    str2 = f8709c;
                } else {
                    str2 = f8710d;
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
                    g3 g3Var = new g3(f8713g, "core", "2.0", "O002");
                    g3Var.a(jSONObject);
                    h3.d(g3Var, f8713g);
                } catch (bv unused) {
                }
            }
        }
    }

    public static boolean u(String str, boolean z5) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        }
        return z5;
    }

    private static boolean v(InetAddress inetAddress) {
        if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !inetAddress.isAnyLocalAddress()) {
            return false;
        }
        return true;
    }

    private static String y(String str, String str2) {
        return str2 + "_" + g1.b(str.getBytes());
    }
}
