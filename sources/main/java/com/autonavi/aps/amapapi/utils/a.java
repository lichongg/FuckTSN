package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.amap.api.col.p0003l.g4;
import com.amap.api.col.p0003l.g7;
import com.amap.api.col.p0003l.i7;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.v5;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f10215i = false;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f10216j = true;

    /* renamed from: k, reason: collision with root package name */
    private static int f10217k = 1000;

    /* renamed from: l, reason: collision with root package name */
    private static int f10218l = 200;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f10219m = false;

    /* renamed from: n, reason: collision with root package name */
    private static int f10220n = 20;

    /* renamed from: o, reason: collision with root package name */
    private static int f10221o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static volatile int f10222p = 0;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f10223q = true;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f10224r = false;

    /* renamed from: s, reason: collision with root package name */
    private static int f10225s = -1;

    /* renamed from: t, reason: collision with root package name */
    private static long f10226t;

    /* renamed from: u, reason: collision with root package name */
    private static ArrayList<String> f10227u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    private static ArrayList<String> f10228v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private static volatile boolean f10229w = false;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f10230x = true;

    /* renamed from: y, reason: collision with root package name */
    private static long f10231y = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f10232z = false;
    private static double A = 0.618d;
    private static boolean B = true;
    private static int C = 80;
    private static int D = 5;

    /* renamed from: a, reason: collision with root package name */
    static long f10207a = 3600000;
    private static boolean E = false;
    private static boolean F = true;
    private static boolean G = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile long f10208b = 0;

    /* renamed from: c, reason: collision with root package name */
    static boolean f10209c = false;
    private static boolean H = true;
    private static long I = -1;
    private static boolean J = true;
    private static int K = 1;
    private static boolean L = false;
    private static int M = 5;
    private static boolean N = false;
    private static String O = "CMjAzLjEwNy4xLjEvMTU0MDgxL2Q";
    private static long P = 0;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f10210d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f10211e = false;

    /* renamed from: f, reason: collision with root package name */
    public static int f10212f = 20480;

    /* renamed from: g, reason: collision with root package name */
    public static int f10213g = 10800000;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f10214h = false;

    public static void a(final Context context) {
        if (f10215i) {
            return;
        }
        f10215i = true;
        g4.i(context, b.c(), b.d(), new g4.b() { // from class: com.autonavi.aps.amapapi.utils.a.1
            @Override // com.amap.api.col.3l.g4.b
            public final void a(g4.c cVar) {
                a.a(context, cVar);
            }
        });
    }

    public static int b() {
        return f10218l;
    }

    public static int c() {
        if (f10222p < 0) {
            f10222p = 0;
        }
        return f10222p;
    }

    public static long d() {
        return f10231y;
    }

    public static boolean e() {
        return f10230x;
    }

    public static boolean f() {
        return f10232z;
    }

    public static double g() {
        return A;
    }

    public static boolean h() {
        return B;
    }

    public static int i() {
        return C;
    }

    private static void b(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("197");
            if (jSONObject2 != null) {
                boolean x5 = g4.x(jSONObject2.optString("able"), false);
                i.a(editor, "197a", x5);
                if (x5) {
                    i.a(editor, "197dv", jSONObject2.optString("sv", ""));
                    i.a(editor, "197tv", jSONObject2.optString("tv", ""));
                } else {
                    i.a(editor, "197dv", "");
                    i.a(editor, "197tv", "");
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13J");
            if (optJSONObject != null) {
                boolean x5 = g4.x(optJSONObject.optString("able"), true);
                B = x5;
                if (x5) {
                    C = optJSONObject.optInt("c", C);
                    D = optJSONObject.optInt(bi.aL, D);
                }
                i.a(editor, "13J_able", B);
                i.a(editor, "13J_c", C);
                i.a(editor, "13J_t", D);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataGpsGeoAble");
        }
    }

    private static void e(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean x5 = g4.x(jSONObject.optString("re"), false);
            f10209c = x5;
            i.a(editor, SocializeProtocolConstants.PROTOCOL_KEY_FR, x5);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "checkReLocationAble");
        }
    }

    private static void f(JSONObject jSONObject, SharedPreferences.Editor editor) {
        JSONArray optJSONArray;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15O");
            if (optJSONObject != null) {
                if (g4.x(optJSONObject.optString("able"), false) && ((optJSONArray = optJSONObject.optJSONArray("fl")) == null || optJSONArray.length() <= 0 || optJSONArray.toString().contains(Build.MANUFACTURER))) {
                    I = optJSONObject.optInt("iv", 30) * 1000;
                } else {
                    I = -1L;
                }
                i.a(editor, "awsi", I);
            }
        } catch (Throwable unused) {
        }
    }

    private static void g(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("17Y");
            if (jSONObject2 != null) {
                boolean x5 = g4.x(jSONObject2.optString("able"), false);
                f10210d = x5;
                i.a(editor, "17ya", x5);
                boolean x6 = g4.x(jSONObject2.optString("mup"), false);
                f10211e = x6;
                i.a(editor, "17ym", x6);
                int optInt = jSONObject2.optInt("max", 20);
                if (optInt > 0) {
                    i.a(editor, "17yx", optInt);
                    f10212f = optInt * 1024;
                }
                int optInt2 = jSONObject2.optInt("inv", 3);
                if (optInt2 > 0) {
                    i.a(editor, "17yi", optInt2);
                    f10213g = optInt2 * 3600000;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void h(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("15U");
            if (optJSONObject != null) {
                boolean x5 = g4.x(optJSONObject.optString("able"), true);
                int optInt = optJSONObject.optInt("yn", K);
                P = optJSONObject.optLong("sysTime", P);
                i.a(editor, "15ua", x5);
                i.a(editor, "15un", optInt);
                i.a(editor, "15ust", P);
            }
        } catch (Throwable unused) {
        }
    }

    private static void i(JSONObject jSONObject, SharedPreferences.Editor editor) {
        int parseInt;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("17J");
            if (optJSONObject != null) {
                boolean x5 = g4.x(optJSONObject.optString("able"), false);
                L = x5;
                i.a(editor, "ok9", x5);
                if (x5) {
                    String optString = optJSONObject.optString("auth");
                    String optString2 = optJSONObject.optString("ht");
                    O = optString2;
                    i.a(editor, "ok11", optString2);
                    g4.x(optString, false);
                    N = g4.x(optJSONObject.optString("nr"), false);
                    String optString3 = optJSONObject.optString("tm");
                    if (TextUtils.isEmpty(optString3) || (parseInt = Integer.parseInt(optString3)) <= 0 || parseInt >= 20) {
                        return;
                    }
                    M = parseInt;
                    i.a(editor, "ok10", parseInt);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static int j() {
        return D;
    }

    public static boolean k() {
        return F;
    }

    public static boolean l() {
        return G;
    }

    public static boolean m() {
        return f10209c;
    }

    public static boolean n() {
        return H;
    }

    public static long o() {
        return I;
    }

    public static boolean p() {
        return N;
    }

    public static boolean q() {
        return L;
    }

    public static String r() {
        return q4.u(O);
    }

    public static boolean s() {
        return J && K > 0;
    }

    public static int t() {
        return K;
    }

    public static long u() {
        return P;
    }

    public static boolean a() {
        return f10216j;
    }

    private static void c(JSONObject jSONObject, SharedPreferences.Editor editor) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("1A6");
            if (jSONObject2 != null) {
                boolean x5 = g4.x(jSONObject2.optString("ic"), false);
                i.a(editor, "1A6", x5);
                f10214h = x5;
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(g4.c cVar, SharedPreferences.Editor editor) {
        try {
            g4.c.a aVar = cVar.f6323g;
            if (aVar != null) {
                boolean z5 = aVar.f6326a;
                f10216j = z5;
                i.a(editor, "exception", z5);
                JSONObject jSONObject = aVar.f6328c;
                if (jSONObject != null) {
                    f10217k = jSONObject.optInt("fn", f10217k);
                    int optInt = jSONObject.optInt("mpn", f10218l);
                    f10218l = optInt;
                    if (optInt > 500) {
                        f10218l = 500;
                    }
                    if (f10218l < 30) {
                        f10218l = 30;
                    }
                    f10219m = g4.x(jSONObject.optString("igu"), false);
                    f10220n = jSONObject.optInt("ms", f10220n);
                    f10222p = jSONObject.optInt("rot", 0);
                    f10221o = jSONObject.optInt("pms", 0);
                }
                g7.c(f10217k, f10219m, f10220n, f10221o);
                i7.f(f10219m, f10221o);
                i.a(editor, "fn", f10217k);
                i.a(editor, "mpn", f10218l);
                i.a(editor, "igu", f10219m);
                i.a(editor, "ms", f10220n);
                i.a(editor, "rot", f10222p);
                i.a(editor, "pms", f10221o);
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataUploadException");
        }
    }

    public static void c(Context context) {
        try {
            p4 c6 = b.c();
            c6.c(f10216j);
            v5.g(context, c6);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        if (f10229w) {
            return;
        }
        f10229w = true;
        try {
            f10216j = i.a(context, "pref", "exception", f10216j);
            c(context);
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            f10217k = i.a(context, "pref", "fn", f10217k);
            f10218l = i.a(context, "pref", "mpn", f10218l);
            f10219m = i.a(context, "pref", "igu", f10219m);
            f10220n = i.a(context, "pref", "ms", f10220n);
            f10222p = i.a(context, "pref", "rot", 0);
            int a6 = i.a(context, "pref", "pms", 0);
            f10221o = a6;
            g7.c(f10217k, f10219m, f10220n, a6);
            i7.f(f10219m, f10221o);
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            f10230x = i.a(context, "pref", ConstantHelper.LOG_CATE, f10230x);
            f10231y = i.a(context, "pref", "ct", f10231y);
            f10232z = i.a(context, "pref", "11G_fa", f10232z);
            double doubleValue = Double.valueOf(i.a(context, "pref", "11G_ms", String.valueOf(A))).doubleValue();
            A = doubleValue;
            A = Math.max(0.2d, doubleValue);
        } catch (Throwable th3) {
            b.a(th3, "AuthUtil", "loadLastAbleState p3");
        }
        try {
            f10209c = i.a(context, "pref", SocializeProtocolConstants.PROTOCOL_KEY_FR, f10209c);
        } catch (Throwable th4) {
            b.a(th4, "AuthUtil", "loadLastAbleState p4");
        }
        try {
            H = i.a(context, "pref", "asw", H);
        } catch (Throwable th5) {
            b.a(th5, "AuthUtil", "loadLastAbleState p5");
        }
        try {
            I = i.a(context, "pref", "awsi", I);
        } catch (Throwable th6) {
            b.a(th6, "AuthUtil", "loadLastAbleState p6");
        }
        try {
            J = i.a(context, "pref", "15ua", J);
            K = i.a(context, "pref", "15un", K);
            P = i.a(context, "pref", "15ust", P);
        } catch (Throwable th7) {
            b.a(th7, "AuthUtil", "loadLastAbleState p7");
        }
        try {
            L = i.a(context, "pref", "ok9", L);
            M = i.a(context, "pref", "ok10", M);
            O = i.a(context, "pref", "ok11", O);
        } catch (Throwable th8) {
            b.a(th8, "AuthUtil", "loadLastAbleState p8");
        }
        try {
            f10210d = i.a(context, "pref", "17ya", false);
            f10211e = i.a(context, "pref", "17ym", false);
            f10213g = i.a(context, "pref", "17yi", 2) * 3600000;
            f10212f = i.a(context, "pref", "17yx", 100) * 1024;
        } catch (Throwable th9) {
            b.a(th9, "AuthUtil", "loadLastAbleState p9");
        }
        try {
            f10208b = j.b();
            f10207a = i.a(context, "pref", "13S_at", f10207a);
            F = i.a(context, "pref", "13S_nla", F);
            B = i.a(context, "pref", "13J_able", B);
            C = i.a(context, "pref", "13J_c", C);
            D = i.a(context, "pref", "13J_t", D);
        } catch (Throwable th10) {
            b.a(th10, "AuthUtil", "loadLastAbleState p10");
        }
        g4.D(context);
        try {
            String a7 = i.a(context, "pref", "13S_mlpl", (String) null);
            if (!TextUtils.isEmpty(a7)) {
                G = a(context, new JSONArray(q4.u(a7)));
            }
        } catch (Throwable th11) {
            b.a(th11, "AuthUtil", "loadLastAbleState p11");
        }
        try {
            boolean a8 = i.a(context, "pref", "197a", false);
            String a9 = i.a(context, "pref", "197dv", "");
            String a10 = i.a(context, "pref", "197tv", "");
            if (a8 && b.f10234a.equals(a9)) {
                for (String str : b.f10235b) {
                    if (str.equals(a10)) {
                        b.f10234a = a10;
                    }
                }
            }
        } catch (Throwable th12) {
            b.a(th12, "AuthUtil", "loadLastAbleState p12");
        }
        try {
            f10214h = i.a(context, "pref", "1A6", f10214h);
        } catch (Throwable th13) {
            b.a(th13, "AuthUtil", "loadSdkEnableConfig p13");
        }
    }

    private static void a(JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("11G");
            if (optJSONObject != null) {
                boolean x5 = g4.x(optJSONObject.optString("able"), true);
                f10230x = x5;
                if (x5) {
                    f10231y = optJSONObject.optInt("c", 300) * 1000;
                }
                f10232z = g4.x(optJSONObject.optString("fa"), false);
                A = Math.min(1.0d, Math.max(0.2d, optJSONObject.optDouble("ms", 0.618d)));
                i.a(editor, ConstantHelper.LOG_CATE, f10230x);
                i.a(editor, "ct", f10231y);
                i.a(editor, "11G_fa", f10232z);
                i.a(editor, "11G_ms", String.valueOf(A));
            }
        } catch (Throwable th) {
            b.a(th, "AuthUtil", "loadConfigDataCacheAble");
        }
    }

    static boolean a(Context context, g4.c cVar) {
        SharedPreferences.Editor editor;
        try {
            editor = i.a(context, "pref");
        } catch (Throwable unused) {
            editor = null;
        }
        try {
            a(cVar, editor);
            c(context);
            JSONObject jSONObject = cVar.f6322f;
            if (jSONObject == null) {
                if (editor != null) {
                    try {
                        i.a(editor);
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            }
            a(context, jSONObject, editor);
            a(jSONObject, editor);
            d(jSONObject, editor);
            f(jSONObject, editor);
            h(jSONObject, editor);
            g(jSONObject, editor);
            i(jSONObject, editor);
            b(jSONObject, editor);
            c(jSONObject, editor);
            if (editor != null) {
                try {
                    i.a(editor);
                } catch (Throwable unused3) {
                }
            }
            return true;
        } catch (Throwable unused4) {
            if (editor == null) {
                return false;
            }
            try {
                i.a(editor);
                return false;
            } catch (Throwable unused5) {
                return false;
            }
        }
    }

    public static boolean a(long j6) {
        if (!f10230x) {
            return false;
        }
        long a6 = j.a() - j6;
        long j7 = f10231y;
        return j7 < 0 || a6 < j7;
    }

    private static void a(Context context, JSONObject jSONObject, SharedPreferences.Editor editor) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("13S");
            if (optJSONObject != null) {
                try {
                    long optInt = optJSONObject.optInt("at", 123) * 60000;
                    f10207a = optInt;
                    i.a(editor, "13S_at", optInt);
                } catch (Throwable th) {
                    b.a(th, "AuthUtil", "requestSdkAuthInterval");
                }
                e(optJSONObject, editor);
                try {
                    boolean x5 = g4.x(optJSONObject.optString("nla"), true);
                    F = x5;
                    i.a(editor, "13S_nla", x5);
                } catch (Throwable unused) {
                }
                try {
                    boolean x6 = g4.x(optJSONObject.optString("asw"), true);
                    H = x6;
                    i.a(editor, "asw", x6);
                } catch (Throwable unused2) {
                }
                try {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("mlpl");
                    if (optJSONArray != null && optJSONArray.length() > 0 && context != null) {
                        i.a(editor, "13S_mlpl", q4.q(optJSONArray.toString()));
                        G = a(context, optJSONArray);
                    } else {
                        G = false;
                        i.a(editor, "13S_mlpl");
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th2) {
            b.a(th2, "AuthUtil", "loadConfigAbleStatus");
        }
    }

    private static boolean a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0 && context != null) {
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        if (j.b(context, jSONArray.getString(i6))) {
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
