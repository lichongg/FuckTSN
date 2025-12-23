package cn.jiguang.bd;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.bi.h;
import cn.jiguang.bz.j;
import cn.jiguang.bz.l;
import cn.jiguang.bz.n;
import cn.jiguang.bz.o;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.m.c;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.bi;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    public static final String f2010e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f2011f;

    /* renamed from: g, reason: collision with root package name */
    public static String f2012g;

    /* renamed from: h, reason: collision with root package name */
    public static String f2013h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f2014i;

    /* renamed from: o, reason: collision with root package name */
    private static LinkedList<String> f2020o;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f2021p;

    /* renamed from: q, reason: collision with root package name */
    private static Map<String, Long> f2022q;

    /* renamed from: j, reason: collision with root package name */
    private static final String f2015j = l.b(new byte[]{62, 82, 38, 113, 19, 93, 73, 85, 84, 2, 23, 92, HttpConstants.COLON, 34, 40, 115, 19, 47, 78, 84, 32, 3, 19, 40, 57, 83, 32, 114, 23, 93, 49, 82});

    /* renamed from: k, reason: collision with root package name */
    private static String f2016k = "";

    /* renamed from: l, reason: collision with root package name */
    private static String f2017l = "/v3/report";

    /* renamed from: a, reason: collision with root package name */
    public static final String f2006a = l.b(new byte[]{BinaryMemcacheOpcodes.SASL_AUTH, 1, 16, 43, 56, 37, BinaryMemcacheOpcodes.SASL_AUTH, 4, 16, HttpConstants.COMMA, 56, 32, BinaryMemcacheOpcodes.SASL_AUTH, 7, 16, BinaryMemcacheOpcodes.SASL_AUTH});

    /* renamed from: b, reason: collision with root package name */
    public static final String f2007b = l.b(new byte[]{120, 95, 80, 43, 56, 37, BinaryMemcacheOpcodes.SASL_AUTH, 4, 16, HttpConstants.COMMA, 56, 32, 112, 96, 75, 56});

    /* renamed from: c, reason: collision with root package name */
    public static JSONObject f2008c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f2009d = true;

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f2018m = new ConcurrentHashMap<>();

    /* renamed from: n, reason: collision with root package name */
    private static Handler f2019n = new Handler(b());

    private static class a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        public Context f2025a;

        /* renamed from: b, reason: collision with root package name */
        public String f2026b;

        /* renamed from: c, reason: collision with root package name */
        public String f2027c;

        /* renamed from: d, reason: collision with root package name */
        public JSONObject f2028d;

        /* renamed from: e, reason: collision with root package name */
        public File f2029e;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2031g = false;

        /* renamed from: f, reason: collision with root package name */
        public long f2030f = SystemClock.elapsedRealtime();

        @Override // cn.jiguang.by.b
        public synchronized void a() {
            a aVar;
            if (this.f2031g) {
                cn.jiguang.bb.f.c("ReportUtils", "task id is : " + this.f2026b + " running save file is End");
                return;
            }
            this.f2031g = true;
            File a6 = d.a(this.f2025a, this.f2027c, this.f2028d, true);
            this.f2029e = a6;
            if (a6 != null && (aVar = (a) f.f2018m.get(this.f2026b)) != null) {
                aVar.f2029e = this.f2029e;
                f.f2018m.replace(this.f2026b, aVar);
            }
        }

        public synchronized void b() {
            try {
                cn.jiguang.bb.f.c("ReportUtils", "onTaskSuccess task id is : " + this.f2026b);
                this.f2031g = true;
                File file = this.f2029e;
                if (file != null) {
                    j.b(file);
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized void c() {
            cn.jiguang.bb.f.c("ReportUtils", "onTaskFailed task id is : " + this.f2026b);
            a();
            d();
        }

        private void d() {
            File file = this.f2029e;
            if (file != null) {
                d.a(file);
            }
        }

        public a(Context context, String str, String str2, JSONObject jSONObject) {
            this.f2025a = context;
            this.f2026b = str;
            this.f2027c = str2;
            this.f2028d = jSONObject;
        }
    }

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack) {
        return a(context, set, jSONObject, file, reportCallBack, "");
    }

    private static Looper b() {
        HandlerThread handlerThread = new HandlerThread("jg_timer") { // from class: cn.jiguang.bd.f.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        return handlerThread.getLooper();
    }

    public static String c(String str) {
        try {
            return v.b(str, cn.jiguang.bz.g.b(), cn.jiguang.bz.g.f2736b);
        } catch (Throwable unused) {
            cn.jiguang.bb.f.l("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static void d() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Map.Entry<String, Long>> it = f2022q.entrySet().iterator();
            while (it.hasNext()) {
                if (currentTimeMillis - it.next().getValue().longValue() > TTAdConstant.AD_MAX_EVENT_TIME) {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.d("ReportUtils", "clean expired failed urls error", th);
        }
    }

    static {
        String b6 = l.b(new byte[]{123, 98, 112, 68, 83, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f2010e = b6;
        String b7 = l.b(new byte[]{106, 124, 119, 101, 67, 13, 112, 120, 96, 39, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2011f = b7;
        f2012g = "";
        f2013h = "";
        LinkedList<String> linkedList = new LinkedList<>();
        f2020o = linkedList;
        linkedList.clear();
        f2020o.add(b6);
        f2020o.add(b7);
        f2021p = false;
        f2014i = true;
        f2022q = new HashMap();
    }

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack, String str) {
        int i6;
        Object obj;
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    if (!o.c()) {
                        cn.jiguang.bb.f.i("ReportUtils", "no network, give up upload");
                        a(str, false);
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    }
                    if (!cn.jiguang.bq.b.a().a(context)) {
                        cn.jiguang.bb.f.i("NetDataMonitorManager", "report sdk limit");
                        a(str, false);
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    }
                    Pair<byte[], Integer> a6 = a(jSONObject.toString(), true, 2);
                    if (a6 != null && (obj = a6.first) != null && ((byte[]) obj).length != 0) {
                        byte[] bArr = (byte[]) obj;
                        int intValue = ((Integer) a6.second).intValue();
                        cn.jiguang.bb.f.c("ReportUtils", "will upload length=" + bArr.length);
                        if (a(context, set, bArr.length, cn.jiguang.bg.c.d(context))) {
                            h.a().a(context, h.a().a(context, jSONObject, bArr, intValue, file, set, reportCallBack, str));
                            return 1;
                        }
                        i6 = a(context, bArr, intValue, set);
                        if (i6 == 0) {
                            try {
                                cn.jiguang.bb.f.c("ReportUtils", "http upload success json=" + n.a(jSONObject));
                                if (TextUtils.isEmpty(str)) {
                                    j.b(file);
                                } else {
                                    a(str, true);
                                }
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    cn.jiguang.bb.f.i("ReportUtils", "upload failed, error:" + th);
                                    a(str, false);
                                    if (TextUtils.isEmpty(str)) {
                                        d.a(file);
                                    }
                                    if (reportCallBack != null) {
                                        reportCallBack.onFinish(-1);
                                    }
                                    return -1;
                                } finally {
                                    if (i6 != 1) {
                                        if (i6 == 0) {
                                            a(str, true);
                                        } else {
                                            a(str, false);
                                        }
                                        if (TextUtils.isEmpty(str)) {
                                            d.a(file);
                                        }
                                        if (reportCallBack != null) {
                                            reportCallBack.onFinish(i6);
                                        }
                                    }
                                }
                            }
                        }
                        return i6;
                    }
                    cn.jiguang.bb.f.i("ReportUtils", "package body failed, give up upload");
                    a(str, false);
                    if (TextUtils.isEmpty(str)) {
                        d.a(file);
                    }
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                }
            } catch (Throwable th2) {
                th = th2;
                i6 = 0;
            }
        }
        cn.jiguang.bb.f.i("ReportUtils", "upload content is empty, do nothing");
        a(str, false);
        if (TextUtils.isEmpty(str)) {
            d.a(file);
        }
        if (reportCallBack != null) {
            reportCallBack.onFinish(-1);
        }
        return -1;
    }

    public static String b(String str) {
        try {
            return v.b(str, cn.jiguang.bz.g.a(), cn.jiguang.bz.g.f2735a);
        } catch (Throwable unused) {
            cn.jiguang.bb.f.l("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static LinkedList<String> c() {
        return f2020o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, JSONArray jSONArray, Set<String> set) {
        Context context2;
        Set<String> set2;
        try {
            String a6 = cn.jiguang.bd.a.b().b(context).a(set);
            JSONObject a7 = a(context);
            boolean z5 = a7 != null;
            StringBuilder sb = new StringBuilder();
            String str = File.separator;
            sb.append(str);
            sb.append(a6);
            sb.append(str);
            sb.append(z5 ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            Integer num = null;
            while (it.hasNext()) {
                try {
                    JSONObject a8 = a(it.next(), a7);
                    if (z5) {
                        String uuid = UUID.randomUUID().toString();
                        a(sb2, a8, uuid);
                        context2 = context;
                        set2 = set;
                        try {
                            num = Integer.valueOf(a(context2, set2, a8, null, null, uuid));
                        } catch (Throwable th) {
                            th = th;
                            cn.jiguang.bb.f.c("ReportUtils", "buildReport [for item]", th);
                            context = context2;
                            set = set2;
                        }
                    } else {
                        context2 = context;
                        set2 = set;
                        d.a(context2, sb2, a8, false);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    context2 = context;
                    set2 = set;
                }
                context = context2;
                set = set2;
            }
            Context context3 = context;
            if (num == null || num.intValue() != 0) {
                return;
            }
            d.b(context3);
        } catch (Throwable th3) {
            cn.jiguang.bb.f.l("ReportUtils", "report exception:" + th3);
        }
    }

    private static int a(Context context, byte[] bArr, int i6, Set<String> set) {
        String str;
        Set<String> set2 = set;
        LinkedHashSet<String> a6 = a(context, set2);
        if (a6 == null || a6.isEmpty()) {
            cn.jiguang.bb.f.i("ReportUtils", "can't get url, give up upload");
            return -2;
        }
        if (c(set2)) {
            cn.jiguang.bb.f.c("ReportUtils", "types=" + set2 + " support tcp report only");
            return -2;
        }
        String str2 = " type=" + set2;
        for (String str3 : a6) {
            if (TextUtils.isEmpty(str3)) {
                cn.jiguang.bb.f.i("ReportUtils", "can't get url, give up upload");
            } else if (Build.VERSION.SDK_INT < 28 || str3.startsWith(c.a.f3100d)) {
                String str4 = str3.endsWith(f2017l) ? str3 : str3 + f2017l;
                cn.jiguang.bb.f.c("ReportUtils", "upload" + str2 + " to url:" + str4);
                g a7 = b.a(context, str4, bArr, i6, 3, 1, set2);
                int a8 = a7.a();
                if (a8 == -3) {
                    d.a(context, cn.jiguang.d.a.e(context));
                    return -2;
                }
                if (a8 == -1) {
                    str = "upload" + str2 + " error:" + a7.b();
                } else {
                    if (a8 == 0) {
                        return 0;
                    }
                    str = "upload" + str2 + " failed";
                }
                cn.jiguang.bb.f.c("ReportUtils", str);
                a(str3);
                set2 = set;
            } else {
                cn.jiguang.bb.f.i("ReportUtils", "won't use http at device since 28");
            }
        }
        return -1;
    }

    private static String b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("type");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<String> c(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                String b6 = b(jSONArray.optJSONObject(i6));
                if (b6 == null) {
                    b6 = "";
                }
                hashSet.add(b6);
            }
        }
        return hashSet;
    }

    private static Pair<byte[], Integer> a(String str, boolean z5, int i6) {
        String str2;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z5) {
                try {
                    bytes = y.a(bytes);
                } catch (IOException unused) {
                    return null;
                }
            }
            int a6 = v.a();
            String a7 = v.a(a6);
            if (i6 == 1) {
                str2 = f2006a;
            } else {
                if (i6 != 2) {
                    return null;
                }
                str2 = f2007b;
            }
            return new Pair<>(v.a(bytes, a7, str2, true), Integer.valueOf(a6));
        } catch (UnsupportedEncodingException | Exception unused2) {
            return null;
        }
    }

    public static LinkedHashSet<String> b(Context context, Set<String> set) {
        StringBuilder sb;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        LinkedList<String> c6 = c();
        if (JCoreManager.isTestEnv() && c6 != null) {
            linkedHashSet.addAll(c6);
            return linkedHashSet;
        }
        Set<String> b6 = cn.jiguang.bd.a.b().c(context).b(set);
        if (b6 != null) {
            for (String str : b6) {
                if (!TextUtils.isEmpty(str)) {
                    linkedHashSet.add(str);
                }
            }
        }
        String str2 = c.a.f3100d;
        Iterator<String> it = c6.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                linkedHashSet.add(str2 + next);
            }
        }
        String str3 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.a(true));
        if (!TextUtils.isEmpty(str3)) {
            for (String str4 : str3.split(",")) {
                if (!w.f(str4)) {
                    if (!w.g(str4)) {
                        sb = new StringBuilder();
                    } else if (!f2014i) {
                        sb = new StringBuilder();
                    }
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                } else if (f2014i) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                }
            }
        }
        LinkedHashSet<String> a6 = y.a(context, linkedHashSet);
        cn.jiguang.bb.f.c("ReportUtils", "types=" + set + " find after urls=" + a6);
        return a6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #2 {all -> 0x002e, blocks: (B:3:0x0001, B:8:0x0039, B:10:0x003f, B:5:0x0020, B:7:0x0024, B:16:0x0030, B:18:0x0034), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray c(java.lang.Object r3) {
        /*
            r0 = 0
            boolean r1 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L20
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Le
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Le
            goto L39
        Le:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L38
            r1.<init>()     // Catch: java.lang.Throwable -> L38
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L38
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L38
            org.json.JSONArray r3 = r1.put(r2)     // Catch: java.lang.Throwable -> L38
            r1 = r3
            goto L39
        L20:
            boolean r1 = r3 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L30
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L2e
            r1.<init>()     // Catch: java.lang.Throwable -> L2e
            org.json.JSONArray r1 = r1.put(r3)     // Catch: java.lang.Throwable -> L2e
            goto L39
        L2e:
            r3 = move-exception
            goto L46
        L30:
            boolean r1 = r3 instanceof org.json.JSONArray     // Catch: java.lang.Throwable -> L2e
            if (r1 == 0) goto L38
            r1 = r3
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch: java.lang.Throwable -> L2e
            goto L39
        L38:
            r1 = r0
        L39:
            org.json.JSONArray r3 = b(r1)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L5c
            int r1 = r3.length()     // Catch: java.lang.Throwable -> L2e
            if (r1 <= 0) goto L5c
            return r3
        L46:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adapt JSONArray e:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r1 = "ReportUtils"
            cn.jiguang.bb.f.i(r1, r3)
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bd.f.c(java.lang.Object):org.json.JSONArray");
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, false);
    }

    private static JSONArray b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null && optJSONObject.length() > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, JSONArray jSONArray, Set<String> set) {
        try {
            String a6 = cn.jiguang.bd.a.b().b(context).a(set);
            JSONObject a7 = a(context);
            boolean z5 = a7 != null;
            StringBuilder sb = new StringBuilder();
            String str = File.separator;
            sb.append(str);
            sb.append(a6);
            sb.append(str);
            sb.append(z5 ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            Integer num = null;
            while (it.hasNext()) {
                try {
                    JSONObject a8 = a(it.next(), a7);
                    File a9 = d.a(context, sb2, a8, z5);
                    if (z5) {
                        num = Integer.valueOf(a(context, set, a8, a9, null));
                    }
                } catch (Throwable th) {
                    cn.jiguang.bb.f.c("ReportUtils", "buildReport [for item]", th);
                }
            }
            if (num == null || num.intValue() != 0) {
                return;
            }
            d.b(context);
        } catch (Throwable th2) {
            cn.jiguang.bb.f.l("ReportUtils", "report exception:" + th2);
        }
    }

    public static String a(Context context, String str, String str2, boolean z5) {
        String e6;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue();
        if (longValue == 0) {
            cn.jiguang.bb.f.c("ReportUtils", " miss uid,generate report token failed");
            return null;
        }
        if (z5) {
            e6 = f2015j;
        } else {
            String str3 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.E());
            if (TextUtils.isEmpty(str3)) {
                str3 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.F());
            }
            e6 = w.e(str3);
        }
        String l6 = w.l(longValue + e6 + str);
        if (w.a(l6)) {
            return null;
        }
        try {
            return Base64.encodeToString((longValue + ":" + l6 + ":" + str2).getBytes(), 10);
        } catch (Exception unused) {
            cn.jiguang.bb.f.l("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static boolean c(Set<String> set) {
        return set.contains("sdk_jid") && set.size() == 1;
    }

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i6, int i7) {
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            if (jSONArray.length() == 1) {
                arrayList.add(jSONArray);
                return arrayList;
            }
            JSONArray jSONArray2 = new JSONArray();
            int i8 = 0;
            int i9 = 0;
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject optJSONObject = jSONArray.optJSONObject(length);
                try {
                    int b6 = n.b(optJSONObject);
                    if (b6 != 0) {
                        int i10 = i8 + b6;
                        if (i10 > i7) {
                            break;
                        }
                        int i11 = i9 + b6;
                        if (i11 > i6) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            try {
                                jSONArray3.put(optJSONObject);
                                jSONArray2 = jSONArray3;
                            } catch (Throwable th) {
                                th = th;
                                jSONArray2 = jSONArray3;
                                cn.jiguang.bb.f.i("ReportUtils", "partition exception:" + th);
                            }
                        } else {
                            jSONArray2.put(optJSONObject);
                            b6 = i11;
                        }
                        i9 = b6;
                        i8 = i10;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(jSONArray2);
            }
        }
        return arrayList;
    }

    private static void b(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject a6 = a(context);
                    if (a6 == null) {
                        cn.jiguang.bb.f.l("ReportUtils", "wrap data failed");
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-1);
                            return;
                        }
                        return;
                    }
                    String b6 = b(jSONObject);
                    JSONObject a7 = a(new JSONArray().put(jSONObject), a6);
                    HashSet hashSet = new HashSet();
                    hashSet.add(b6);
                    if (a(context, hashSet, a7, null, reportCallBack) != 0) {
                        return;
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.l("ReportUtils", "reportWithoutStore exception:" + th);
                return;
            }
        }
        d.b(context);
    }

    public static LinkedHashSet<String> a(Context context, Set<String> set) {
        return a(b(context, set));
    }

    private static boolean b(Object obj) {
        return obj instanceof String ? ((String) obj).length() > 2 : obj instanceof JSONObject ? ((JSONObject) obj).length() > 0 : (obj instanceof JSONArray) && b((JSONArray) obj).length() > 0;
    }

    private static LinkedHashSet<String> a(LinkedHashSet<String> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return linkedHashSet;
        }
        d();
        LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>();
        Iterator<String> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!f2022q.containsKey(next)) {
                linkedHashSet2.add(next);
            }
        }
        if (linkedHashSet2.isEmpty()) {
            cn.jiguang.bb.f.c("ReportUtils", "all urls are in blacklist, return original urls");
            return linkedHashSet;
        }
        cn.jiguang.bb.f.c("ReportUtils", "removed " + (linkedHashSet.size() - linkedHashSet2.size()) + " failed urls from " + linkedHashSet.size() + " total urls");
        return linkedHashSet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Set<String> set) {
        if (set == null) {
            return false;
        }
        return set.contains(PushSA.REPORT_ACTIVE_LAUNCH) || set.contains(PushSA.REPORT_ACTIVE_TERMINATE) || set.contains("sdk_type") || set.contains("android_notification_state") || set.contains("operate_event");
    }

    public static Set<String> a(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : c(jSONObject.optJSONArray("content"));
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "a");
            long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue();
            if (longValue == 0) {
                cn.jiguang.bb.f.i("ReportUtils", "miss uid when wrap container info");
                return null;
            }
            jSONObject.put("uid", longValue);
            String e6 = cn.jiguang.d.a.e(context);
            if (w.a(e6)) {
                cn.jiguang.bb.f.l("ReportUtils", "miss app_key when wrap container info");
                return null;
            }
            jSONObject.put("app_key", e6);
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
            jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f1444b);
            String h6 = cn.jiguang.d.a.h(context);
            if (w.a(h6)) {
                cn.jiguang.bb.f.j("ReportUtils", "miss channel when wrap container info,but continue report...");
            } else {
                jSONObject.put("channel", h6);
            }
            String a6 = cn.jiguang.c.b.a(context);
            if (TextUtils.isEmpty(a6)) {
                cn.jiguang.bb.f.j("ReportUtils", "miss app version when wrap container info,but continue report...");
            } else {
                jSONObject.put("app_version", a6);
            }
            String c6 = o.c(context);
            if (TextUtils.isEmpty(c6)) {
                c6 = o.a(context);
            }
            if (!TextUtils.isEmpty(c6)) {
                jSONObject.put(bi.T, c6);
            }
            jSONObject.put("g_sdk_type", cn.jiguang.bi.b.a().a(context));
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReportUtils", "wrapContainerInfo exception:" + th);
            return null;
        }
    }

    private static JSONObject a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", jSONArray);
        } catch (JSONException unused) {
        }
        n.a(jSONObject2, jSONObject);
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r4, int r5, org.json.JSONObject r6, byte[] r7, int r8, java.io.File r9, java.util.Set<java.lang.String> r10, cn.jiguang.api.ReportCallBack r11, java.lang.String r12) {
        /*
            r6 = 0
            r0 = 1
            java.lang.String r1 = "ReportUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r2.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = "onTcpReportResult, types="
            r2.append(r3)     // Catch: java.lang.Throwable -> L47
            r2.append(r10)     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = " code="
            r2.append(r3)     // Catch: java.lang.Throwable -> L47
            r2.append(r5)     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = " id="
            r2.append(r3)     // Catch: java.lang.Throwable -> L47
            r2.append(r12)     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = " ,store:"
            r2.append(r3)     // Catch: java.lang.Throwable -> L47
            r2.append(r9)     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L47
            cn.jiguang.bb.f.c(r1, r2)     // Catch: java.lang.Throwable -> L47
            r1 = -3
            if (r5 == r1) goto L67
            if (r5 == 0) goto L57
            int r5 = a(r4, r7, r8, r10)     // Catch: java.lang.Throwable -> L47
            if (r5 != 0) goto L50
            boolean r7 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L47
            boolean r7 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L47
            if (r7 == 0) goto L49
            cn.jiguang.bz.j.b(r9)     // Catch: java.lang.Throwable -> L47
            goto L4c
        L47:
            goto L8b
        L49:
            a(r12, r0)     // Catch: java.lang.Throwable -> L47
        L4c:
            cn.jiguang.bd.d.b(r4)     // Catch: java.lang.Throwable -> L47
            goto L73
        L50:
            a(r12, r6)     // Catch: java.lang.Throwable -> L47
        L53:
            cn.jiguang.bd.d.a(r0)     // Catch: java.lang.Throwable -> L47
            goto L73
        L57:
            boolean r7 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L47
            boolean r7 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L47
            if (r7 == 0) goto L63
            cn.jiguang.bz.j.b(r9)     // Catch: java.lang.Throwable -> L47
            goto L4c
        L63:
            a(r12, r0)     // Catch: java.lang.Throwable -> L47
            goto L4c
        L67:
            java.lang.String r7 = cn.jiguang.d.a.e(r4)     // Catch: java.lang.Throwable -> L47
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> L47
            cn.jiguang.bd.d.a(r4, r7)     // Catch: java.lang.Throwable -> L47
            goto L53
        L73:
            if (r5 != 0) goto L79
            a(r12, r0)
            goto L7c
        L79:
            a(r12, r6)
        L7c:
            if (r11 == 0) goto L81
            r11.onFinish(r5)
        L81:
            boolean r4 = android.text.TextUtils.isEmpty(r12)
            if (r4 == 0) goto La2
            cn.jiguang.bd.d.a(r9)
            return
        L8b:
            if (r5 != 0) goto L91
            a(r12, r0)
            goto L94
        L91:
            a(r12, r6)
        L94:
            if (r11 == 0) goto L99
            r11.onFinish(r5)
        L99:
            boolean r4 = android.text.TextUtils.isEmpty(r12)
            if (r4 == 0) goto La2
            cn.jiguang.bd.d.a(r9)
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bd.f.a(android.content.Context, int, org.json.JSONObject, byte[], int, java.io.File, java.util.Set, cn.jiguang.api.ReportCallBack, java.lang.String):void");
    }

    public static void a(final Context context, final Object obj) {
        try {
            if (b(obj)) {
                cn.jiguang.by.d.a("UPLOAD_REPORT", new cn.jiguang.by.b("ReportUtils#report") { // from class: cn.jiguang.bd.f.1
                    @Override // cn.jiguang.by.b
                    public void a() {
                        try {
                            JSONArray c6 = f.c(obj);
                            if (c6 != null) {
                                Set c7 = f.c(c6);
                                if (f.b((Set<String>) c7)) {
                                    f.c(context, c6, c7);
                                    return;
                                } else {
                                    f.d(context, c6, c7);
                                    return;
                                }
                            }
                            cn.jiguang.bb.f.c("ReportUtils", "data" + obj + " is empty");
                        } catch (Throwable unused) {
                        }
                    }
                });
            } else {
                cn.jiguang.bb.f.c("ReportUtils", "data is invalid or empty");
                d.b(context);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReportUtils", "report e:" + th);
        }
    }

    public static void a(Context context, String str, Object obj) {
        try {
            cn.jiguang.bb.f.c("ReportUtils", "going to report data at push service");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("sdk_type", str);
            }
            if (b(obj)) {
                bundle.putString("report_data", obj.toString());
            }
            cn.jiguang.a.a.a(context, "a1", bundle);
        } catch (Throwable th) {
            try {
                cn.jiguang.bb.f.d("ReportUtils", "reportAtPushService", th);
            } catch (Throwable th2) {
                cn.jiguang.bb.f.d("ReportUtils", "reportAtPushService", th2);
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        b(context, jSONObject, reportCallBack);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f2022q.put(str, Long.valueOf(System.currentTimeMillis()));
        cn.jiguang.bb.f.c("ReportUtils", "add failed http url to blacklist: " + str);
    }

    private static void a(String str, JSONObject jSONObject, String str2) {
        Context a6 = cn.jiguang.bz.d.a(null);
        if (a6 == null) {
            return;
        }
        try {
            a aVar = new a(a6, str2, str, jSONObject);
            f2018m.put(aVar.f2026b, aVar);
            f2019n.postDelayed(aVar, 500L);
        } catch (Throwable unused) {
        }
    }

    private static void a(String str, boolean z5) {
        a aVar;
        if (TextUtils.isEmpty(str) || (aVar = f2018m.get(str)) == null) {
            return;
        }
        f2019n.removeCallbacks(aVar);
        if (z5) {
            aVar.b();
        } else {
            aVar.c();
        }
        f2018m.remove(aVar.f2026b);
    }

    private static boolean a(Context context, Set<String> set, int i6, boolean z5) {
        return f2009d && ((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.l())).booleanValue() && i6 < (z5 ? 30650 : 30680) && set != null && !set.contains("crash_log") && !set.contains("operate_event");
    }
}
