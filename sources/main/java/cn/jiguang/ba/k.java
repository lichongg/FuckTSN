package cn.jiguang.ba;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.bz.w;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static String f1951a = "reg_finger_helper";

    /* renamed from: b, reason: collision with root package name */
    public static String f1952b = "dId";

    /* renamed from: c, reason: collision with root package name */
    public static String f1953c = "ud";

    /* renamed from: d, reason: collision with root package name */
    public static String f1954d = "j_p_d";

    /* renamed from: e, reason: collision with root package name */
    public static String f1955e = "rd";

    /* renamed from: f, reason: collision with root package name */
    private static long f1956f = 86400000;

    /* renamed from: g, reason: collision with root package name */
    private static Integer f1957g;

    public static int a(Context context) {
        if (f1957g == null) {
            f1957g = (Integer) cn.jiguang.e.b.a(context, cn.jiguang.e.a.M());
        }
        return f1957g.intValue();
    }

    public static void c(Context context) {
        try {
            boolean a6 = h.a();
            cn.jiguang.bb.f.c("RegFingerHelper", "regFinger is:" + a6);
            if (a6) {
                String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.L());
                String k6 = w.k(cn.jiguang.bz.a.a().w(context) + cn.jiguang.bz.a.a().x(context));
                cn.jiguang.bb.f.c("RegFingerHelper", "regFinger oldRule:" + str);
                cn.jiguang.bb.f.c("RegFingerHelper", "regFinger newRule:" + k6);
                if (TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(k6)) {
                        return;
                    }
                    cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.L().a((cn.jiguang.e.a<String>) k6)});
                    return;
                }
                if (TextUtils.isEmpty(k6) || str.equals(k6)) {
                    return;
                }
                cn.jiguang.bb.f.c("RegFingerHelper", "regFinger is re");
                cn.jiguang.e.b.a(context, "cn.jiguang.sdk.user.profile");
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.M().a((cn.jiguang.e.a<Integer>) 1)});
                f1957g = 1;
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.L().a((cn.jiguang.e.a<String>) k6)});
                cn.jiguang.m.b.a(context);
                cn.jiguang.bz.a.b();
                cn.jiguang.bz.j.d("bal.catch");
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.b().a((cn.jiguang.e.a<String>) null)});
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aj().a((cn.jiguang.e.a<String>) null)});
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ak().a((cn.jiguang.e.a<String>) null)});
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.az().a((cn.jiguang.e.a<String>) null)});
                cn.jiguang.bn.a.b(context);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.l("RegFingerHelper", "reg Fail: " + th);
        }
    }

    public static void a(Context context, String str) {
        try {
            cn.jiguang.bb.f.c("RegFingerHelper", "saveDataMain:" + str);
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(f1952b);
            long optLong = jSONObject.optLong(f1953c);
            String optString2 = jSONObject.optString(f1954d);
            String optString3 = jSONObject.optString(f1955e);
            cn.jiguang.be.b.a(context, optString);
            cn.jiguang.be.b.a(context, optLong, optString2, optString3);
            cn.jiguang.bb.f.c("RegFingerHelper", "saveDataMain end:" + str);
        } catch (JSONException e6) {
            cn.jiguang.bb.f.l("RegFingerHelper", "saveDataMain Fail: " + e6);
        }
    }

    public static void a(Context context, String str, long j6, String str2, String str3) {
        cn.jiguang.bb.f.c("RegFingerHelper", "sendDataMain:" + j6 + ",isNewFingerprint:" + f1957g);
        if (a(context) == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f1952b, str);
            jSONObject.put(f1953c, j6);
            jSONObject.put(f1954d, str2);
            jSONObject.put(f1955e, str3);
        } catch (JSONException e6) {
            cn.jiguang.bb.f.l("RegFingerHelper", "sendDataMain Fail: " + e6);
        }
        cn.jiguang.bb.f.c("RegFingerHelper", "sendDataMain:" + j6 + ",jsonObject:" + jSONObject);
        cn.jiguang.bz.a.b(context, f1951a, jSONObject.toString());
    }

    public static void b(Context context) {
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.M().a((cn.jiguang.e.a<Integer>) 0)});
        f1957g = 0;
    }
}
