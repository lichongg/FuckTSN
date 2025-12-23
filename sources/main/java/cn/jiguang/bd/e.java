package cn.jiguang.bd;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.bz.l;
import cn.jiguang.bz.o;
import cn.jiguang.bz.x;
import cn.jiguang.bz.y;
import cn.jiguang.internal.JConstants;
import cn.jiguang.m.c;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static a f1998a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile FutureTask<?> f1999b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f2000c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static final LinkedHashSet<String> f2001d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f2002e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f2003f;

    /* renamed from: g, reason: collision with root package name */
    private static final LinkedHashSet<String> f2004g;

    /* renamed from: cn.jiguang.bd.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f2005a;

        private a(Context context) {
            this.f2005a = context;
            this.f2653h = "SisTask";
        }

        /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
            this(context);
        }

        @Override // cn.jiguang.by.b
        public void a() {
            try {
                String c6 = e.c(this.f2005a);
                LinkedHashSet d6 = e.d(this.f2005a);
                d6.addAll(e.a());
                LinkedHashSet<String> a6 = y.a(this.f2005a, (LinkedHashSet<String>) d6);
                cn.jiguang.bb.f.c("ReportSis", "sis urls=" + a6.toString() + " post json=" + c6);
                if (!o.c()) {
                    cn.jiguang.bb.f.i("ReportSis", "give up sis, because network is not connected");
                    return;
                }
                Iterator<String> it = a6.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        if (Build.VERSION.SDK_INT >= 28 && !next.startsWith(c.a.f3100d)) {
                            cn.jiguang.bb.f.i("ReportSis", "won't use http at device since 28");
                        } else if (e.b(this.f2005a, next, c6)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    static {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        f2001d = linkedHashSet;
        String b6 = l.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 68, 83, 112, 123, 56, 123, SignedBytes.MAX_POWER_OF_TWO, 85, 106, 96, 56, 114, 94});
        f2002e = b6;
        String b7 = l.b(new byte[]{96, 98, 101, SignedBytes.MAX_POWER_OF_TWO, 83, BinaryMemcacheOpcodes.GATK, 39, 57, 101, 67, 73, 106, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f2003f = b7;
        linkedHashSet.add(b6);
        linkedHashSet.add(b7);
        f2004g = new LinkedHashSet<>();
    }

    public static LinkedHashSet<String> a() {
        if (JConstants.isTestEnv()) {
            LinkedHashSet<String> linkedHashSet = f2004g;
            if (!linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
        }
        return f2001d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str, String str2) {
        g a6 = b.a(str, str2, context, true, 3, 2);
        cn.jiguang.bb.f.c("ReportSis", "report sis code[" + a6.a() + "] from url=" + str + "\n body=" + a6.b());
        if (a6.a() != 0) {
            return false;
        }
        String b6 = a6.b();
        if (TextUtils.isEmpty(b6)) {
            return false;
        }
        try {
            cn.jiguang.bd.a.b().a(context, new JSONObject(b6).getJSONObject("ret"));
            return true;
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("ReportSis", "getUrls e:" + th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context) {
        long j6;
        Object a6;
        double d6;
        double d7;
        JSONObject jSONObject = new JSONObject();
        try {
            String e6 = cn.jiguang.d.a.e(context);
            long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue();
            int b6 = o.b(context);
            String a7 = x.a(context, false);
            jSONObject.put("type", b6);
            jSONObject.put("appkey", e6);
            jSONObject.put("sdkver", cn.jiguang.a.a.f1444b);
            jSONObject.put("platform", 0);
            j6 = 0;
            if (longValue != 0) {
                jSONObject.put("uid", longValue);
            }
            if (a7 != null) {
                jSONObject.put("opera", a7);
            }
            a6 = cn.jiguang.v.a.a(context, "get_loc_info", null);
            d6 = 200.0d;
        } catch (Throwable unused) {
        }
        if (a6 instanceof Bundle) {
            try {
                Bundle bundle = (Bundle) a6;
                double d8 = bundle.getDouble(com.umeng.analytics.pro.d.C);
                try {
                    d6 = bundle.getDouble("lot");
                    j6 = bundle.getLong("time");
                } catch (Throwable unused2) {
                }
                d7 = d6;
                d6 = d8;
            } catch (Throwable unused3) {
            }
            if (d6 > -90.0d && d6 < 90.0d && d7 > -180.0d && d7 < 180.0d) {
                jSONObject.put(com.umeng.analytics.pro.d.C, d6);
                jSONObject.put(com.umeng.analytics.pro.d.D, d7);
                jSONObject.put("time", j6);
            }
            return jSONObject.toString();
        }
        d7 = 200.0d;
        if (d6 > -90.0d) {
            jSONObject.put(com.umeng.analytics.pro.d.C, d6);
            jSONObject.put(com.umeng.analytics.pro.d.D, d7);
            jSONObject.put("time", j6);
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashSet<String> d(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.W());
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    linkedHashSet.add(jSONArray.optString(i6));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedHashSet;
    }

    public static void a(Context context, boolean z5) {
        String str;
        StringBuilder sb;
        AnonymousClass1 anonymousClass1 = null;
        if (f1998a == null) {
            f1998a = new a(context, anonymousClass1);
        }
        if (f1999b == null || f1999b.isCancelled() || f1999b.isDone()) {
            synchronized (f2000c) {
                if (f1999b == null || f1999b.isCancelled() || f1999b.isDone()) {
                    try {
                        f1999b = new FutureTask<>(f1998a, null);
                        cn.jiguang.by.d.a("FUTURE_TASK", f1999b);
                    } catch (Throwable th) {
                        cn.jiguang.bb.f.i("ReportSis", "new sis task e:" + th);
                    }
                }
            }
        }
        if (z5) {
            try {
                f1999b.get(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e6) {
                e = e6;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bb.f.i(str, sb.toString());
            } catch (ExecutionException e7) {
                e = e7;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bb.f.i(str, sb.toString());
            } catch (TimeoutException e8) {
                e = e8;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bb.f.i(str, sb.toString());
            } catch (Throwable th2) {
                e = th2;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bb.f.i(str, sb.toString());
            }
        }
    }
}
