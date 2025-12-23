package cn.jiguang.x;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import cn.jiguang.ab.c;
import cn.jiguang.bb.f;
import cn.jiguang.q.d;
import cn.jiguang.z.b;
import com.amap.api.services.core.AMapException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile JSONObject f3312a;

    /* renamed from: b, reason: collision with root package name */
    private static String f3313b;

    /* renamed from: c, reason: collision with root package name */
    private static String f3314c;

    /* renamed from: d, reason: collision with root package name */
    private static String f3315d;

    /* renamed from: e, reason: collision with root package name */
    private static String f3316e;

    /* renamed from: f, reason: collision with root package name */
    private static String f3317f;

    /* renamed from: g, reason: collision with root package name */
    private static String f3318g;

    /* renamed from: h, reason: collision with root package name */
    private static String f3319h;

    /* renamed from: i, reason: collision with root package name */
    private static String f3320i;

    /* renamed from: j, reason: collision with root package name */
    private static String f3321j;

    /* renamed from: k, reason: collision with root package name */
    private static String f3322k;

    /* renamed from: cn.jiguang.x.a$a, reason: collision with other inner class name */
    static class CallableC0051a implements Callable<JSONObject> {

        /* renamed from: a, reason: collision with root package name */
        private Context f3328a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f3329b;

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject call() {
            JSONObject jSONObject = new JSONObject();
            try {
                String B = cn.jiguang.bz.a.a().B(this.f3328a);
                if (!TextUtils.isEmpty(B)) {
                    f.c("IdHelper", "start getAllIds by local");
                    String b6 = a.b(this.f3328a, B, this.f3329b);
                    if (!TextUtils.isEmpty(b6)) {
                        jSONObject = new JSONObject(b6);
                    }
                }
                String b7 = a.b(this.f3328a, this.f3329b);
                if (!TextUtils.isEmpty(b7)) {
                    jSONObject.put("jgad", b7);
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        }

        public CallableC0051a(Context context, boolean z5) {
            this.f3328a = context;
            this.f3329b = z5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context) {
        String c6;
        if (c()) {
            f.i("IdHelper", "not get id in main thread");
            return "";
        }
        try {
            c6 = cn.jiguang.d.a.c("+Fc+/S0DV5xukan0E/9N4RvXQpEI8h8+6y3k9NAvwjLhqIYeN+juscczCl6Sq6PxwLAq9CdDlLtmxsbD83akRg==");
        } catch (Throwable th) {
            f.i("IdHelper", "google getAdvertisingIdInfo Exception: " + th.toString());
        }
        if (TextUtils.isEmpty(c6)) {
            return "";
        }
        Intent intent = new Intent(c6);
        String c7 = cn.jiguang.d.a.c("+Fc+/S0DV5xukan0E/9N4VArQdi8pEVBp8UquAC8VbE=");
        if (TextUtils.isEmpty(c7)) {
            return "";
        }
        intent.setPackage(c7);
        b bVar = new b();
        if (context.bindService(intent, bVar, 1)) {
            try {
                if (bVar.f3335a) {
                    f.i("IdHelper", "google service repeat bind");
                    return "";
                }
                String a6 = new cn.jiguang.z.a(bVar.f3336b.take()).a();
                f.c("IdHelper", "google ad id:" + a6);
                return a6;
            } catch (Throwable th2) {
                try {
                    f.i("IdHelper", "get google Ids by service error: " + th2.getMessage());
                    context.unbindService(bVar);
                } finally {
                    context.unbindService(bVar);
                }
            }
        } else {
            f.i("IdHelper", "google service bind failed");
        }
        return "";
    }

    private static boolean c() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            f.i("IdHelper", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    private static String d(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            str = f3315d;
        } catch (Throwable th) {
            f.i("IdHelper", "hw getAdvertisingIdInfo Exception: " + th.toString());
        }
        if (str != null) {
            return str;
        }
        String c6 = cn.jiguang.d.a.c("CV+BUnOM9r9hBWkUu5oSnA==");
        if (TextUtils.isEmpty(c6)) {
            return "";
        }
        f3315d = "";
        String c7 = cn.jiguang.d.a.c("axDZqud6H+CDQBXA/yBXOiEPy9gW6px8eLENPXdBlBHSZeanEgWxhi72s58AM6wZ");
        if (TextUtils.isEmpty(c7)) {
            return "";
        }
        Intent intent = new Intent(c7);
        intent.setPackage(c6);
        cn.jiguang.aa.b bVar = new cn.jiguang.aa.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (bindService) {
            try {
                String a6 = new cn.jiguang.aa.a(bVar.f1464a.take()).a();
                f.c("IdHelper", "hw ids-o:" + a6);
                f3315d = a6;
            } catch (Throwable th2) {
                try {
                    f.i("IdHelper", "hw get Ids-oa error: " + th2.getMessage());
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                } finally {
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                }
            }
        } else {
            f.i("IdHelper", "hw service bind failed");
        }
        return "";
    }

    private static String e(Context context) {
        String str;
        try {
            str = f3316e;
        } catch (Exception e6) {
            f.i("IdHelper", "zui getAdvertisingIdInfo Exception: " + e6.toString());
        }
        if (str != null) {
            return str;
        }
        String c6 = cn.jiguang.d.a.c("Mpy0fkBSw1N+kug2cBPj2YJ2JkldBoT0Hj8EbMwXMGU=");
        if (TextUtils.isEmpty(c6)) {
            return "";
        }
        f3316e = "";
        String c7 = cn.jiguang.d.a.c("Mpy0fkBSw1N+kug2cBPj2dTFEwqSue3aUHyxqBhF0BWQuC1TiTYwRmpXbBFYowSK");
        if (TextUtils.isEmpty(c7)) {
            return "";
        }
        Intent intent = new Intent(c7);
        intent.setPackage(c6);
        cn.jiguang.ai.b bVar = new cn.jiguang.ai.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (bindService) {
            try {
                String a6 = new cn.jiguang.ai.a(bVar.f1517a.take()).a();
                f.c("IdHelper", "zui ids-oa:" + a6);
                f3316e = a6;
            } catch (Throwable th) {
                try {
                    f.i("IdHelper", "get zui ids-oa error: " + th.getMessage());
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                } finally {
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                }
            }
        } else {
            f.i("IdHelper", "zui service bind failed");
        }
        return "";
    }

    private static String f(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a6 = new cn.jiguang.ac.b(context).a();
            if (!TextUtils.isEmpty(a6)) {
                jSONObject.put("joad", a6);
            }
        } catch (JSONException e6) {
            f.i("IdHelper", "getNubiaIds err: " + e6.getMessage());
        }
        return jSONObject.toString();
    }

    private static String g(Context context) {
        String str;
        try {
            str = f3317f;
        } catch (Exception e6) {
            f.i("IdHelper", "sumsung getAdvertisingIdInfo Exception: " + e6.toString());
        }
        if (str != null) {
            return str;
        }
        String c6 = cn.jiguang.d.a.c("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVtSyGK74B1pfv+DoniV/u8H");
        if (TextUtils.isEmpty(c6)) {
            return "";
        }
        f3317f = "";
        String c7 = cn.jiguang.d.a.c("NZZdxIY39aBpJdeuRJ0VLp5xPlLZJqfiSSPak26ACVsaSg3goTgfCOA0dOFWjVLPc7dVv4XHGL0Dk7MQTYMVQw==");
        if (TextUtils.isEmpty(c7)) {
            return "";
        }
        Intent intent = new Intent();
        intent.setClassName(c6, c7);
        cn.jiguang.ae.b bVar = new cn.jiguang.ae.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (bindService) {
            try {
                String a6 = new cn.jiguang.ae.a(bVar.f1491a.take()).a(context);
                f.c("IdHelper", "sumsuang ids-oa:" + a6);
                f3317f = a6;
            } catch (Throwable th) {
                try {
                    f.i("IdHelper", "get sumsung Ids-oa error: " + th.getMessage());
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                } finally {
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                }
            }
        } else {
            f.i("IdHelper", "sumsung service bind failed");
        }
        return "";
    }

    private static String h(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String a6 = new c(context).a();
            if (!TextUtils.isEmpty(a6)) {
                jSONObject.put("joad", a6);
            }
        } catch (JSONException e6) {
            f.i("IdHelper", "getVivoIds err: " + e6.getMessage());
        }
        return jSONObject.toString();
    }

    private static String i(Context context) {
        String str;
        try {
            str = f3318g;
        } catch (Exception e6) {
            f.i("IdHelper", "oppo getAdvertisingIdInfo Exception: " + e6.toString());
        }
        if (str != null) {
            return str;
        }
        String c6 = cn.jiguang.d.a.c("qFFOesfckPwVmbfqzGl5oG9IMWwJa4PjDfKEUokUsrU=");
        if (TextUtils.isEmpty(c6)) {
            return "";
        }
        f3318g = "";
        String c7 = cn.jiguang.d.a.c("qFFOesfckPwVmbfqzGl5oOMkBF5tSSPHMYAiT/owwSwoCrUg5HXoJRYDJrCupV3K");
        if (TextUtils.isEmpty(c7)) {
            return "";
        }
        Intent intent = new Intent(c7);
        intent.setPackage(c6);
        String c8 = cn.jiguang.d.a.c("/3gurUKcGzqF8/YMsL45D9RvCsSd5y5lQDTuvU2S5vtG2aMIkkluUNr+NKF2loi0");
        if (TextUtils.isEmpty(c8)) {
            return "";
        }
        intent.setAction(c8);
        cn.jiguang.ad.b bVar = new cn.jiguang.ad.b();
        boolean bindService = context.bindService(intent, bVar, 1);
        if (bindService) {
            try {
                String a6 = new cn.jiguang.ad.a(bVar.f1488a.take()).a(context);
                f.c("IdHelper", "oppo ids-oa: " + a6);
                f3318g = a6;
            } catch (Throwable th) {
                try {
                    f.i("IdHelper", "get oppo ids-oa error: " + th.getMessage());
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                } finally {
                    if (bindService) {
                        context.unbindService(bVar);
                    }
                }
            }
        } else {
            f.i("IdHelper", "oppo service bind failed");
        }
        return "";
    }

    private static String j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            cn.jiguang.af.c cVar = new cn.jiguang.af.c(context);
            cVar.a("");
            String a6 = cVar.a();
            if (!TextUtils.isEmpty(a6)) {
                jSONObject.put("joad", a6);
            }
        } catch (JSONException e6) {
            f.i("IdHelper", "getVivoIds err: " + e6.getMessage());
        }
        return jSONObject.toString();
    }

    private static String k(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        try {
            str = f3319h;
        } catch (Exception e6) {
            f.i("IdHelper", "asus getAdvertisingIdInfo Exception: " + e6.toString());
        }
        if (str != null) {
            return str;
        }
        f3319h = "";
        String c6 = cn.jiguang.d.a.c("AVy8x+cBVze9OKJHZKioHyNDBGqtEllVM4dvG69zMJc=");
        if (TextUtils.isEmpty(c6)) {
            return "";
        }
        Intent intent = new Intent(c6);
        String c7 = cn.jiguang.d.a.c("8lAhWp7NB89J3VIJU4lIGQtLf0YkfPcfFvWDnnGUuiQ=");
        if (TextUtils.isEmpty(c7)) {
            return "";
        }
        String c8 = cn.jiguang.d.a.c("8lAhWp7NB89J3VIJU4lIGQnPwmB8zgbENyN+gUA8dpRI7pO4GGAXufB+HCPmLRg7bL9N6o9V3Rxxk98J3lyy6g==");
        if (TextUtils.isEmpty(c8)) {
            return "";
        }
        ComponentName componentName = new ComponentName(c7, c8);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        f.f("IdHelper", "start to bind did service.");
        cn.jiguang.y.b bVar = new cn.jiguang.y.b();
        boolean bindService = context.bindService(intent2, bVar, 1);
        if (bindService) {
            try {
                String a6 = new cn.jiguang.y.a(bVar.f3332a.take()).a();
                f.c("IdHelper", "asus ids-oa; " + a6);
                f3319h = a6;
            } catch (Throwable th) {
                try {
                    f.i("IdHelper", "get asus ids-oa error: " + th.getMessage());
                    if (bindService) {
                        f.f("IdHelper", "start to unbind did service");
                        context.unbindService(bVar);
                    }
                } finally {
                    if (bindService) {
                        f.f("IdHelper", "start to unbind did service");
                        context.unbindService(bVar);
                    }
                }
            }
        }
        return "";
    }

    private static String m(Context context) {
        if (f3320i == null) {
            String a6 = new cn.jiguang.ah.b(context).a();
            f3320i = a6;
            f3320i = TextUtils.isEmpty(a6) ? "" : f3320i;
        }
        return f3320i;
    }

    private static String n(Context context) {
        if (f3321j == null) {
            String a6 = new cn.jiguang.ah.b(context).a();
            f3321j = a6;
            f3321j = TextUtils.isEmpty(a6) ? "" : f3321j;
        }
        return f3321j;
    }

    private static String o(Context context) {
        if (f3322k == null) {
            String a6 = new cn.jiguang.ah.b(context).a();
            f3322k = a6;
            f3322k = TextUtils.isEmpty(a6) ? "" : f3322k;
        }
        return f3322k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Context context, String str) {
        String o5;
        try {
        } catch (Throwable th) {
            f.i("IdHelper", "getIdsByLocal failed:" + th.getMessage());
        }
        if (c()) {
            f.i("IdHelper", "not get id in main thread");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        String c6 = cn.jiguang.d.a.c("KACzk43fXSu6fNDY3NHiRg==");
        String c7 = cn.jiguang.d.a.c("1uhzqUdzasJ2ZR3KEL+MzQ==");
        if ((TextUtils.isEmpty(c6) || !str.toLowerCase().equals(c6)) && (TextUtils.isEmpty(c7) || !str.toLowerCase().equals(c7))) {
            String c8 = cn.jiguang.d.a.c("abElWL6JFOA3DmtpsVXe5g==");
            String c9 = cn.jiguang.d.a.c("qqDQS9ZdTx8AkhCp5nUUmQ==");
            if ((!TextUtils.isEmpty(c8) && str.toLowerCase().equals(c8)) || (!TextUtils.isEmpty(c9) && str.toLowerCase().equals(c9))) {
                return l(context);
            }
            String c10 = cn.jiguang.d.a.c("ZCUqO8ru60AnJTvdxNftwg==");
            if (!TextUtils.isEmpty(c10) && str.toLowerCase().equals(c10)) {
                return j(context);
            }
            String c11 = cn.jiguang.d.a.c("Sqo/G40afBQEk/ThxiHCDA==");
            if (TextUtils.isEmpty(c11) || !str.toLowerCase().equals(c11)) {
                String c12 = cn.jiguang.d.a.c("Fl44OKc45ZSCqG4pxdgAdA==");
                if (TextUtils.isEmpty(c12) || !str.toLowerCase().equals(c12)) {
                    String c13 = cn.jiguang.d.a.c("v4ibuvMAw0xxYGyCW947bw==");
                    String c14 = cn.jiguang.d.a.c("lJTl9z+ZycJlu+D6qavE9g==");
                    if ((!TextUtils.isEmpty(c13) && str.toLowerCase().equals(c13)) || (!TextUtils.isEmpty(c14) && str.toLowerCase().equals(c14))) {
                        return h(context);
                    }
                    String c15 = cn.jiguang.d.a.c("7UUoz3VX0wN8BuYNQ77o2g==");
                    if (!TextUtils.isEmpty(c15) && str.toLowerCase().equals(c15)) {
                        return f(context);
                    }
                    String c16 = cn.jiguang.d.a.c("NftKgs8fjwuVYJ3VslncvA==");
                    String c17 = cn.jiguang.d.a.c("Wq1559o9+HHChTmry59Bkg==");
                    if ((TextUtils.isEmpty(c16) || !str.toLowerCase().equals(c16)) && (TextUtils.isEmpty(c17) || !str.toLowerCase().equals(c17))) {
                        String c18 = cn.jiguang.d.a.c("fmTCWm9ViPlyzM8H0bOrgw==");
                        if (TextUtils.isEmpty(c18) || !str.toLowerCase().equals(c18)) {
                            String c19 = cn.jiguang.d.a.c("bbyVCf9F4jMXWPUAeT3frw==");
                            if (TextUtils.isEmpty(c19) || !str.toLowerCase().equals(c19)) {
                                String c20 = cn.jiguang.d.a.c("0kbg5dLQpyr1z+M/7Qkp7A==");
                                if ((TextUtils.isEmpty(c20) || !str.toLowerCase().equals(c20)) && !cn.jiguang.ah.a.a()) {
                                    String c21 = cn.jiguang.d.a.c("7kOXkVyi2CnACIIN3msOQg==");
                                    if ((TextUtils.isEmpty(c21) || !str.toLowerCase().equals(c21)) && !cn.jiguang.ah.a.b()) {
                                        f.i("IdHelper", "not supported this device: " + str);
                                        return "";
                                    }
                                    o5 = o(context);
                                    if (TextUtils.isEmpty(o5)) {
                                        return "";
                                    }
                                } else {
                                    o5 = n(context);
                                    if (TextUtils.isEmpty(o5)) {
                                        return "";
                                    }
                                }
                            } else {
                                o5 = m(context);
                                if (TextUtils.isEmpty(o5)) {
                                    return "";
                                }
                            }
                        } else {
                            o5 = k(context);
                            if (TextUtils.isEmpty(o5)) {
                                return "";
                            }
                        }
                    } else {
                        o5 = e(context);
                        if (TextUtils.isEmpty(o5)) {
                            return "";
                        }
                    }
                } else {
                    o5 = g(context);
                    if (TextUtils.isEmpty(o5)) {
                        return "";
                    }
                }
            } else {
                o5 = i(context);
                if (TextUtils.isEmpty(o5)) {
                    return "";
                }
            }
        } else {
            o5 = d(context);
            if (TextUtils.isEmpty(o5)) {
                return "";
            }
        }
        jSONObject.put("joad", o5);
        return jSONObject.toString();
    }

    private static String l(Context context) {
        return cn.jiguang.ag.a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(final Context context, final String str, final boolean z5) {
        try {
            f.c("IdHelper", "[getIds] useMethod：" + z5);
            Object a6 = d.a(context, 1900, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.x.a.1
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return z5 ? a.b(context, str) : "";
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f3313b = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.f3313b;
                }
            });
            if (a6 instanceof String) {
                f3313b = (String) a6;
            }
        } catch (Throwable unused) {
        }
        return f3313b;
    }

    public static JSONObject a(Context context) {
        return a(context, true);
    }

    public static String b(final Context context, final boolean z5) {
        try {
            f.c("IdHelper", "[getGoogleAdid] useMethod：" + z5);
            Object a6 = d.a(context, AMapException.CODE_AMAP_CLIENT_INVALID_PARAMETER, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.x.a.2
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    return z5 ? a.c(context) : "";
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = a.f3314c = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return a.f3314c;
                }
            });
            if (a6 instanceof String) {
                f3314c = (String) a6;
            }
        } catch (Throwable th) {
            f3314c = "";
            f.i("IdHelper", "getGoogleAdid failed:" + th.getMessage());
        }
        return f3314c;
    }

    public static JSONObject a(Context context, boolean z5) {
        try {
            f.c("IdHelper", "[getAllIds] useMethod：" + z5);
        } catch (Throwable th) {
            f.i("IdHelper", "[getAllIds] failed：" + th.getMessage());
        }
        if (f3312a != null) {
            f.c("IdHelper", "[getAllIds] local idsJSON：" + f3312a);
            return f3312a;
        }
        FutureTask futureTask = new FutureTask(new CallableC0051a(context, z5));
        cn.jiguang.be.b.e(futureTask);
        JSONObject jSONObject = (JSONObject) futureTask.get(2L, TimeUnit.SECONDS);
        f3312a = jSONObject.toString().equals("{}") ? null : jSONObject;
        f.c("IdHelper", "[getAllIds] allIds：" + jSONObject);
        f.c("IdHelper", "[getAllIds] idsJSON：" + f3312a);
        return f3312a;
    }
}
