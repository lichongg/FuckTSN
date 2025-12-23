package cn.jiguang.bi;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.bg.k;
import cn.jiguang.bz.o;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.File;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static int f2266d;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f2267a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<cn.jiguang.bg.g, Pair<Integer, cn.jiguang.bl.a>> f2268b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<cn.jiguang.bg.g, ConcurrentHashMap<Integer, c>> f2269c;

    /* renamed from: e, reason: collision with root package name */
    private Map<cn.jiguang.bg.g, Long> f2270e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, LinkedHashSet<cn.jiguang.bg.g>> f2271f;

    /* renamed from: cn.jiguang.bi.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h f2272a = new h(null);
    }

    static class b extends cn.jiguang.bm.a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f2273a;

        /* renamed from: d, reason: collision with root package name */
        private int f2274d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f2275e;

        /* renamed from: f, reason: collision with root package name */
        private int f2276f;

        b(Context context, int i6, Object obj) {
            this.f2273a = context;
            this.f2274d = i6;
            this.f2275e = obj;
        }

        b(Context context, Object obj) {
            this.f2273a = context;
            this.f2275e = obj;
        }

        @Override // cn.jiguang.bm.a
        public void a(Message message) {
            int i6 = message.what;
            if (i6 >= 60000) {
                if (this.f2275e instanceof cn.jiguang.bg.g) {
                    cn.jiguang.bb.f.c("TcpReporter", "time to idle=" + this.f2275e);
                    h.a().a(this.f2273a, (cn.jiguang.bg.g) this.f2275e, 0);
                    return;
                }
                return;
            }
            if (i6 >= 50000) {
                Object obj = this.f2275e;
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    cn.jiguang.bb.f.c("TcpReporter", "onTimeout=" + cVar);
                    h.a().a(cVar.f2283g, cVar.f2282f);
                    h.a().a(this.f2273a, cVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i6 = this.f2274d;
                if (i6 == 1) {
                    if (this.f2275e instanceof cn.jiguang.bg.g) {
                        h.a().a(this.f2273a, (cn.jiguang.bg.g) this.f2275e);
                        return;
                    }
                    return;
                }
                if (i6 == 2) {
                    if (this.f2275e instanceof cn.jiguang.bg.g) {
                        h.a().b(this.f2273a, (cn.jiguang.bg.g) this.f2275e);
                    }
                } else {
                    if (i6 != 3) {
                        return;
                    }
                    Object obj = this.f2275e;
                    if (obj instanceof c) {
                        c cVar = (c) obj;
                        cn.jiguang.bb.f.c("TcpReporter", "onResult, data=" + cVar + " code=" + this.f2276f);
                        cn.jiguang.bd.f.a(this.f2273a, this.f2276f, cVar.f2278b, cVar.f2279c, cVar.f2277a, cVar.f2280d, cVar.f2281e, cVar.f2286j, cVar.f2287k);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        int f2277a;

        /* renamed from: b, reason: collision with root package name */
        JSONObject f2278b;

        /* renamed from: c, reason: collision with root package name */
        byte[] f2279c;

        /* renamed from: d, reason: collision with root package name */
        File f2280d;

        /* renamed from: e, reason: collision with root package name */
        Set<String> f2281e;

        /* renamed from: f, reason: collision with root package name */
        int f2282f = -1;

        /* renamed from: g, reason: collision with root package name */
        cn.jiguang.bg.g f2283g;

        /* renamed from: h, reason: collision with root package name */
        LinkedHashSet<cn.jiguang.bg.g> f2284h;

        /* renamed from: i, reason: collision with root package name */
        boolean f2285i;

        /* renamed from: j, reason: collision with root package name */
        transient ReportCallBack f2286j;

        /* renamed from: k, reason: collision with root package name */
        transient String f2287k;

        public String toString() {
            return "TcpReportData{types=" + this.f2281e + ", seqId=" + this.f2282f + ", ipPort=" + this.f2283g + ", restUrls=" + this.f2284h + '}';
        }
    }

    private h() {
        this.f2267a = new AtomicBoolean(false);
        this.f2268b = new ConcurrentHashMap();
        this.f2269c = new ConcurrentHashMap();
        this.f2270e = new HashMap();
        this.f2271f = new HashMap();
    }

    private static synchronized int b() {
        int i6;
        synchronized (h.class) {
            i6 = (f2266d + 1) % 10000;
            f2266d = i6;
        }
        return i6;
    }

    private Set<cn.jiguang.bg.g> c(Context context, Set<String> set) {
        c(context);
        boolean a6 = a(context, set);
        String str = a6 ? "ssl" : PrerollVideoResponse.NORMAL;
        if (set != null && !set.isEmpty()) {
            Iterator<String> it = set.iterator();
            LinkedHashSet<cn.jiguang.bg.g> linkedHashSet = null;
            while (it.hasNext()) {
                LinkedHashSet<cn.jiguang.bg.g> linkedHashSet2 = this.f2271f.get(a(it.next(), a6));
                if (linkedHashSet2 != null && !linkedHashSet2.isEmpty()) {
                    if (linkedHashSet == null) {
                        linkedHashSet = linkedHashSet2;
                    } else {
                        linkedHashSet.retainAll(linkedHashSet2);
                    }
                    if (linkedHashSet.isEmpty()) {
                    }
                }
            }
            return linkedHashSet;
        }
        return this.f2271f.get(str);
    }

    public c a(Context context, JSONObject jSONObject, byte[] bArr, int i6, File file, Set<String> set, ReportCallBack reportCallBack, String str) {
        c cVar = new c();
        cVar.f2278b = jSONObject;
        cVar.f2277a = i6;
        cVar.f2279c = bArr;
        cVar.f2280d = file;
        cVar.f2281e = set;
        cVar.f2282f = b(context);
        cVar.f2286j = reportCallBack;
        cVar.f2287k = str;
        return cVar;
    }

    /* synthetic */ h(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c a(cn.jiguang.bg.g gVar, int i6) {
        ConcurrentHashMap<Integer, c> concurrentHashMap;
        if (gVar == null || (concurrentHashMap = this.f2269c.get(gVar)) == null) {
            return null;
        }
        c cVar = concurrentHashMap.get(Integer.valueOf(i6));
        concurrentHashMap.remove(Integer.valueOf(i6));
        return cVar;
    }

    public static synchronized int b(Context context) {
        int intValue;
        synchronized (h.class) {
            try {
                Integer num = (Integer) cn.jiguang.e.b.b(context, cn.jiguang.e.a.ap());
                if (num == null) {
                    num = Integer.valueOf(Math.abs(new SecureRandom().nextInt(10000)));
                }
                intValue = (num.intValue() + 1) % 10000;
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ap().a((cn.jiguang.e.a<Integer>) Integer.valueOf(intValue))});
            } catch (Throwable th) {
                throw th;
            }
        }
        return intValue;
    }

    private void c(Context context) {
        Map<String, LinkedHashSet<cn.jiguang.bg.g>> map = this.f2271f;
        if (map == null || map.isEmpty()) {
            String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ay());
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                a(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    private LinkedHashSet<cn.jiguang.bg.g> b(Context context, Set<String> set) {
        LinkedHashSet<cn.jiguang.bg.g> linkedHashSet = new LinkedHashSet<>();
        cn.jiguang.bg.g a6 = cn.jiguang.bg.g.a(cn.jiguang.bf.a.d());
        if (a6 == null || !a6.a()) {
            Set<cn.jiguang.bg.g> c6 = c(context, set);
            if (c6 != null) {
                for (cn.jiguang.bg.g gVar : c6) {
                    if (gVar != null && gVar.a()) {
                        linkedHashSet.add(gVar);
                    }
                }
            }
        } else {
            linkedHashSet.add(a6);
        }
        cn.jiguang.bb.f.c("TcpReporter", "tcp report find urls=" + linkedHashSet);
        try {
            Iterator<Map.Entry<cn.jiguang.bg.g, Long>> it = this.f2270e.entrySet().iterator();
            while (it.hasNext()) {
                if (System.currentTimeMillis() - it.next().getValue().longValue() > TTAdConstant.AD_MAX_EVENT_TIME) {
                    it.remove();
                }
            }
            Iterator<cn.jiguang.bg.g> it2 = this.f2270e.keySet().iterator();
            while (it2.hasNext()) {
                linkedHashSet.remove(it2.next());
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.d("TcpReporter", "remove black tcp urls err", th);
        }
        cn.jiguang.bb.f.c("TcpReporter", "tcp report find urls and remove black List Tcp Urls =" + linkedHashSet);
        return linkedHashSet;
    }

    public static h a() {
        return a.f2272a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, cn.jiguang.bg.g gVar) {
        cn.jiguang.bl.a aVar;
        Context context2;
        cn.jiguang.bg.g gVar2;
        cn.jiguang.bb.f.c("TcpReporter", "socket at " + gVar + " is connected, deal with waiting request");
        ConcurrentHashMap<Integer, c> concurrentHashMap = this.f2269c.get(gVar);
        Pair<Integer, cn.jiguang.bl.a> pair = this.f2268b.get(gVar);
        if (pair == null) {
            return;
        }
        if (concurrentHashMap != null && (aVar = (cn.jiguang.bl.a) pair.second) != null && aVar.b()) {
            for (c cVar : concurrentHashMap.values()) {
                if (cVar == null || cVar.f2285i) {
                    context2 = context;
                    gVar2 = gVar;
                } else {
                    context2 = context;
                    gVar2 = gVar;
                    a(context2, ((Integer) pair.first).intValue(), aVar, gVar2, cVar);
                }
                context = context2;
                gVar = gVar2;
            }
        }
        cn.jiguang.bm.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, new b(context, gVar));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private String a(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return z5 ? "ssl" : PrerollVideoResponse.NORMAL;
        }
        str.getClass();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals(PushSA.REPORT_ACTIVE_LAUNCH)) {
                    c6 = 0;
                    break;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1051289244:
                if (str.equals(com.umeng.analytics.pro.d.L)) {
                    c6 = 3;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals(PrerollVideoResponse.NORMAL)) {
                    c6 = 4;
                    break;
                }
                break;
            case -820729752:
                if (str.equals(PushSA.REPORT_ACTIVE_TERMINATE)) {
                    c6 = 5;
                    break;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    c6 = 6;
                    break;
                }
                break;
            case -295020531:
                if (str.equals("android_notification_state")) {
                    c6 = 7;
                    break;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 96275:
                if (str.equals("aa3")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 2986591:
                if (str.equals("aat3")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    c6 = 11;
                    break;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    c6 = 14;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 3:
            case 5:
                return com.umeng.analytics.pro.d.L;
            case 1:
            case '\f':
            case 14:
                return "account";
            case 2:
            case 6:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\r':
                return "awake";
            case 4:
                return z5 ? "ssl" : PrerollVideoResponse.NORMAL;
            case 7:
                return "android_notification_state";
            default:
                return !this.f2271f.containsKey(str) ? z5 ? "ssl" : PrerollVideoResponse.NORMAL : str;
        }
    }

    private void b(Context context, cn.jiguang.bg.g gVar, int i6) {
        if (gVar == null) {
            return;
        }
        try {
            InetAddress inetAddress = gVar.f2083c;
            new k(context).a(3, inetAddress != null ? inetAddress.getHostAddress() : gVar.f2081a, gVar.f2082b, cn.jiguang.d.b.b(context), 0L, i6);
        } catch (Throwable unused) {
        }
        this.f2270e.put(gVar, Long.valueOf(System.currentTimeMillis()));
    }

    public void a(Context context) {
        cn.jiguang.bb.f.c("TcpReporter", "closeSocket sockets:" + this.f2268b);
        Iterator<Map.Entry<cn.jiguang.bg.g, Pair<Integer, cn.jiguang.bl.a>>> it = this.f2268b.entrySet().iterator();
        while (it.hasNext()) {
            cn.jiguang.bg.g key = it.next().getKey();
            cn.jiguang.bb.f.c("TcpReporter", "closeSocket IpPort:" + key);
            a(context, key, -3);
        }
    }

    private void a(Context context, int i6, cn.jiguang.bl.a aVar, cn.jiguang.bg.g gVar, c cVar) {
        byte[] a6 = a(context, cVar.f2279c, cVar.f2277a, cVar.f2282f);
        if (a6 == null || a6.length == 0) {
            cn.jiguang.bb.f.c("TcpReporter", "package data failed, give up, data=" + cVar);
            a(context, cVar, -1);
            return;
        }
        cn.jiguang.bm.b.a().b(cVar.f2282f + SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 15000L, new b(context, cVar));
        cVar.f2285i = true;
        int a7 = aVar.a(a6);
        StringBuilder sb = new StringBuilder();
        sb.append("send tcp data, len=");
        sb.append(a6.length);
        sb.append(", data=");
        sb.append(cVar);
        sb.append(", use ssl: ");
        sb.append(aVar instanceof cn.jiguang.bl.b);
        sb.append(", send ");
        sb.append(a7 == 0 ? "succeed" : "failed");
        cn.jiguang.bb.f.c("TcpReporter", sb.toString());
        cn.jiguang.bq.b.a().b(aVar.f2343h + ":" + aVar.f2344i, cVar.f2281e.toString(), a6.length);
        cn.jiguang.bm.b.a().b(i6 + 60000, 31000L, new b(context, gVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.bg.g gVar) {
        cn.jiguang.bl.a aVar;
        if (gVar == null) {
            return;
        }
        try {
            Pair<Integer, cn.jiguang.bl.a> pair = this.f2268b.get(gVar);
            if (pair != null && (aVar = (cn.jiguang.bl.a) pair.second) != null && !aVar.b()) {
                String d6 = cn.jiguang.bq.c.a().d(gVar.f2081a, gVar.f2082b, aVar.f2342g);
                int a6 = aVar.a(gVar.f2081a, gVar.f2082b);
                cn.jiguang.bb.f.c("TcpReporter", "start tcp report socket(" + pair.first + "):" + gVar + ", code: " + a6);
                if (a6 != 0) {
                    a(context, gVar, 0);
                    cn.jiguang.bq.c.a().g(d6, a6);
                } else {
                    cn.jiguang.be.b.d(new b(context, 2, gVar));
                    cn.jiguang.bq.c.a().g(d6, 0);
                    b bVar = new b(context, gVar);
                    while (!this.f2267a.get()) {
                        try {
                            a(context, aVar.a(), gVar);
                            cn.jiguang.bm.b.a().b(((Integer) pair.first).intValue() + 60000, 31000L, bVar);
                        } catch (e e6) {
                            if (e6.f2231a != -997) {
                                cn.jiguang.bb.f.i("TcpReporter", "recv failed with error:" + e6);
                            }
                        }
                    }
                }
                a(context, gVar, 0);
                cn.jiguang.bb.f.i("TcpReporter", this.f2267a.get() ? "Break receiving by wantStop" : "disconnected");
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.b("TcpReporter", "socket exception", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jiguang.bg.g gVar, int i6) {
        int i7;
        StringBuilder sb;
        Pair<Integer, cn.jiguang.bl.a> remove = this.f2268b.remove(gVar);
        if (remove != null) {
            i7 = ((Integer) remove.first).intValue();
            y.a((Closeable) remove.second);
            cn.jiguang.bb.f.c("TcpReporter", "closeSocket final");
        } else {
            i7 = 0;
        }
        ConcurrentHashMap<Integer, c> remove2 = this.f2269c.remove(gVar);
        if (i6 == 0 && !o.c()) {
            i6 = -2;
        }
        if (remove2 == null || remove2.size() <= 0) {
            if (i7 > 0) {
                cn.jiguang.bb.f.c("TcpReporter", "socket(" + i7 + ") at " + gVar + " is disconnected, no task left");
                return;
            }
            return;
        }
        if (i6 == 0) {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i7);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, go on send waiting request");
        } else {
            sb = new StringBuilder();
            sb.append("socket(");
            sb.append(i7);
            sb.append(") at ");
            sb.append(gVar);
            sb.append(" is disconnected, finish waiting request, code=");
            sb.append(i6);
        }
        cn.jiguang.bb.f.c("TcpReporter", sb.toString());
        for (c cVar : remove2.values()) {
            if (cVar != null) {
                cn.jiguang.bm.b.a().b(cVar.f2282f + SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
                if (i6 == 0) {
                    a(context, cVar);
                } else {
                    b bVar = new b(context, 3, cVar);
                    bVar.f2276f = i6;
                    cn.jiguang.be.b.d(bVar);
                }
            }
        }
    }

    private synchronized void a(Context context, cn.jiguang.bg.g gVar, c cVar) {
        Throwable th;
        cn.jiguang.bl.a aVar;
        String str;
        try {
            try {
                Pair<Integer, cn.jiguang.bl.a> pair = this.f2268b.get(gVar);
                if (pair != null) {
                    try {
                        aVar = (cn.jiguang.bl.a) pair.second;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    aVar = null;
                }
                cn.jiguang.bl.a aVar2 = aVar;
                boolean a6 = a(context, cVar.f2281e);
                if (aVar2 == null) {
                    this.f2268b.put(gVar, new Pair<>(Integer.valueOf(b()), a6 ? new cn.jiguang.bl.b(30720, 19) : new cn.jiguang.bl.c(30720, 19)));
                    b bVar = new b(context, 1, gVar);
                    if (!a6 && cn.jiguang.bg.c.d(context)) {
                        str = "FUTURE_TASK";
                        cn.jiguang.by.d.a(str, bVar);
                    }
                    str = "ONCE_TASK";
                    cn.jiguang.by.d.a(str, bVar);
                } else if (aVar2.b()) {
                    a(context, ((Integer) pair.first).intValue(), aVar2, gVar, cVar);
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public void a(Context context, c cVar) {
        cn.jiguang.bg.g gVar;
        try {
            boolean z5 = cVar.f2284h == null;
            if (z5) {
                cn.jiguang.bm.b.a().a(context);
                cVar.f2284h = b(context, cVar.f2281e);
                cn.jiguang.bb.f.c("TcpReporter", "tcp report begin=" + cVar);
            }
            if (!o.c()) {
                a(context, cVar, -2);
                return;
            }
            LinkedHashSet<cn.jiguang.bg.g> linkedHashSet = cVar.f2284h;
            if (linkedHashSet != null && !linkedHashSet.isEmpty()) {
                Iterator<cn.jiguang.bg.g> it = this.f2268b.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        gVar = null;
                        break;
                    }
                    gVar = it.next();
                    if (cVar.f2284h.contains(gVar)) {
                        cn.jiguang.bb.f.c("TcpReporter", "use exist ipPort=" + gVar);
                        break;
                    }
                }
                if (gVar == null) {
                    try {
                        Iterator<cn.jiguang.bg.g> it2 = cVar.f2284h.iterator();
                        if (it2.hasNext()) {
                            gVar = it2.next();
                            cn.jiguang.bb.f.c("TcpReporter", "use next ipPort=" + gVar);
                        } else {
                            a(context, cVar, -1);
                            cn.jiguang.bb.f.c("TcpReporter", "use next no has ipPort ");
                            return;
                        }
                    } catch (Throwable th) {
                        a(context, cVar, -1);
                        cn.jiguang.bb.f.c("TcpReporter", "use next no has ipPort err:" + th.getMessage());
                        return;
                    }
                }
                cVar.f2283g = gVar;
                cVar.f2284h.remove(gVar);
                if (z5) {
                    cn.jiguang.bm.b.a().b(cVar.f2282f + SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH, 15000L, new b(context, cVar));
                }
                ConcurrentHashMap<Integer, c> concurrentHashMap = this.f2269c.get(gVar);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                    this.f2269c.put(gVar, concurrentHashMap);
                }
                cVar.f2285i = false;
                concurrentHashMap.put(Integer.valueOf(cVar.f2282f), cVar);
                a(context, gVar, cVar);
                return;
            }
            a(context, cVar, -1);
        } catch (Throwable th2) {
            cn.jiguang.bb.f.i("TcpReporter", "tcp upload e:" + th2);
        }
    }

    private void a(Context context, c cVar, int i6) {
        ConcurrentHashMap<Integer, c> concurrentHashMap;
        cn.jiguang.bg.g gVar = cVar.f2283g;
        if (gVar != null && (concurrentHashMap = this.f2269c.get(gVar)) != null) {
            concurrentHashMap.remove(Integer.valueOf(cVar.f2282f));
        }
        cn.jiguang.bm.b.a().b(cVar.f2282f + SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        b bVar = new b(context, 3, cVar);
        bVar.f2276f = i6;
        cn.jiguang.be.b.d(bVar);
    }

    private void a(Context context, ByteBuffer byteBuffer, cn.jiguang.bg.g gVar) {
        cn.jiguang.bq.b a6;
        String gVar2;
        int length;
        if (byteBuffer != null) {
            try {
                if (byteBuffer.array() != null) {
                    cn.jiguang.bb.f.c("TcpReporter", "Received bytes - len:" + byteBuffer.array().length + ", ipPort: " + gVar);
                    if (byteBuffer.array().length == 19) {
                        byte b6 = byteBuffer.get(2);
                        if (b6 != 1 && b6 != 0) {
                            cn.jiguang.bb.f.i("TcpReporter", "wrong version " + ((int) b6));
                            b(context, gVar, 2);
                            a(context, gVar, -1);
                            a6 = cn.jiguang.bq.b.a();
                            gVar2 = gVar.toString();
                            length = byteBuffer.array().length;
                        }
                        short s5 = byteBuffer.getShort(15);
                        short s6 = byteBuffer.getShort(17);
                        cn.jiguang.bb.f.c("TcpReporter", "onResult seqId=" + ((int) s5) + " code=" + ((int) s6));
                        cn.jiguang.bm.b.a().b(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH + s5);
                        c a7 = a(gVar, s5);
                        if (a7 != null) {
                            if (s6 == 0) {
                                cn.jiguang.bq.b.a().c(gVar.toString(), a7.f2281e.toString(), byteBuffer.array().length);
                                b bVar = new b(context, 3, a7);
                                bVar.f2276f = s6;
                                cn.jiguang.be.b.d(bVar);
                                return;
                            }
                            if (s6 == 401) {
                                a(context, gVar, s6);
                                return;
                            } else {
                                a(context, a7);
                                return;
                            }
                        }
                        return;
                    }
                    b(context, gVar, 1);
                    a(context, gVar, -1);
                    a6 = cn.jiguang.bq.b.a();
                    gVar2 = gVar.toString();
                    length = byteBuffer.array().length;
                    a6.c(gVar2, "unknown_receive", length);
                    return;
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.i("TcpReporter", "tcp reporter onReceive err:" + th);
                return;
            }
        }
        cn.jiguang.bb.f.i("TcpReporter", "onReceive buffer is null");
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (optJSONArray != null) {
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        cn.jiguang.bg.g a6 = cn.jiguang.bg.g.a(optJSONArray.getString(i6));
                        if (a6 != null && a6.a()) {
                            linkedHashSet.add(a6);
                        }
                    }
                }
                hashMap.put(next, linkedHashSet);
            }
            if (hashMap.isEmpty()) {
                return;
            }
            this.f2271f = hashMap;
        } catch (JSONException unused) {
        }
    }

    private boolean a(Context context, Set<String> set) {
        if (cn.jiguang.bg.c.d(context)) {
            return (set != null && set.contains("sdk_jid") && set.size() == 1) ? false : true;
        }
        return false;
    }

    private static byte[] a(Context context, long j6, byte[] bArr) {
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.E());
        if (TextUtils.isEmpty(str)) {
            str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.F());
        }
        byte[] c6 = w.c(j6 + w.e(str) + w.b(bArr));
        if (c6 == null) {
            return new byte[16];
        }
        if (c6.length == 16) {
            return c6;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(c6.length, 16));
        return bArr2;
    }

    private byte[] a(Context context, byte[] bArr, int i6, int i7) {
        if (bArr == null || bArr.length == 0 || bArr.length > 30683) {
            return null;
        }
        cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(bArr.length + 37);
        bVar.b(0);
        bVar.a(1);
        bVar.a(cn.jiguang.bi.b.a().b());
        long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue();
        bVar.b(longValue);
        bVar.a(a(context, longValue, bArr));
        bVar.a(i6);
        bVar.b(i7);
        bVar.a(bArr);
        bVar.b(bVar.a(), 0);
        return bVar.b();
    }
}
