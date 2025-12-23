package cn.jiguang.d;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.analytics.page.ActivityLifecycle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bb.d;
import cn.jiguang.bb.e;
import cn.jiguang.bb.f;
import cn.jiguang.bz.h;
import cn.jiguang.bz.q;
import cn.jiguang.bz.v;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.m.c;
import cn.jpush.android.local.JPushConstants;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static ActivityLifecycle f2901a = new ActivityLifecycle();

    public static ActivityLifecycle a() {
        return f2901a;
    }

    public static Object b() {
        return ActionManager.getActionMap();
    }

    public static int c() {
        try {
            Map<Integer, Bundle> d6 = cn.jiguang.bi.b.a().d();
            f.c("JBridgeHelper", "map is " + d6.toString());
            if (!d6.containsKey(2)) {
                return 0;
            }
            String string = d6.get(2).getString("code");
            if (TextUtils.isDigitsOnly(string)) {
                return Integer.parseInt(string);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(TextUtils.equals(str, "app_list") ? "it" : "itime", b.b(context));
            jSONObject.put("type", str);
            String str2 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.P());
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("account_id", str2);
            }
            return jSONObject;
        } catch (JSONException e6) {
            f.i("JBridgeHelper", "fillBase exception:" + e6);
            return jSONObject;
        }
    }

    public static String b(Context context) {
        return (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.C());
    }

    public static String c(Context context) {
        return (String) cn.jiguang.e.b.b(context, cn.jiguang.e.a.O());
    }

    public static boolean l(Context context) {
        f.c("JBridgeHelper", "canShowLbsPermissionDialog");
        Boolean bool = (Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ae());
        if (bool != null && !bool.booleanValue()) {
            f.d("JBridgeHelper", "lbs disable");
            return false;
        }
        long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ad())).longValue();
        long longValue2 = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ab())).longValue();
        f.c("JBridgeHelper", "lbs permission dialog shield, firstInit=" + longValue2 + ", delay=" + longValue);
        if (longValue2 > 0) {
            return longValue <= 0 || System.currentTimeMillis() > longValue2 + longValue;
        }
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ab().a((cn.jiguang.e.a<Long>) Long.valueOf(System.currentTimeMillis()))});
        return longValue <= 0;
    }

    public static boolean p(Context context) {
        if (!JConstants.isAndroidQ(context, true, "canGetLbsInBackGround") || cn.jiguang.be.b.f2036b.get() || q.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return true;
        }
        f.j("JBridgeHelper", "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION");
        return false;
    }

    public static void a(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        f2901a.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static String b(String str) {
        return v.a(str, c.a.f3106j);
    }

    public static String c(String str) {
        return v.b(str, c.a.f3106j);
    }

    public static String d(Context context) {
        return (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.P());
    }

    public static String e(Context context) {
        return cn.jiguang.ba.a.a(context);
    }

    public static long f(Context context) {
        return ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.B())).longValue();
    }

    public static long g(Context context) {
        return ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.D())).longValue();
    }

    public static String h(Context context) {
        return cn.jiguang.ba.a.c(context);
    }

    public static String i(Context context) {
        return h.b(context);
    }

    public static String j(Context context) {
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.E());
        if (TextUtils.isEmpty(str)) {
            return (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.F());
        }
        return str;
    }

    public static int k(Context context) {
        return ((Integer) cn.jiguang.e.b.a(context, cn.jiguang.e.a.G())).intValue();
    }

    public static String m(Context context) {
        Object a6 = cn.jiguang.bi.b.a().a(context, JPushConstants.SDK_TYPE, KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        if (a6 instanceof String) {
            return (String) a6;
        }
        return null;
    }

    public static Integer n(Context context) {
        Object a6 = cn.jiguang.bi.b.a().a(context, JPushConstants.SDK_TYPE, 30006);
        if (a6 instanceof Integer) {
            return (Integer) a6;
        }
        return null;
    }

    public static String o(Context context) {
        String l6 = cn.jiguang.bz.a.l(context);
        if (!TextUtils.isEmpty(l6)) {
            StringBuilder sb = new StringBuilder();
            sb.append(l6);
            String str = File.separator;
            sb.append(str);
            sb.append("Android");
            sb.append(str);
            sb.append("data");
            return sb.toString();
        }
        return "";
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            a(context, true);
        }
    }

    public static void b(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        f2901a.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, JConstants.SDK_TYPE, 14, null, null, obj);
    }

    public static void a(Context context, JSONObject jSONObject) {
        a(context, jSONObject, false);
    }

    public static void a(Context context, JSONObject jSONObject, boolean z5) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optJSONObject != null) {
                int optInt = optJSONObject.optInt("log_enable");
                int optInt2 = optJSONObject.optInt("log_print");
                int optInt3 = optJSONObject.optInt("upload_enable");
                if (z5) {
                    int optInt4 = optJSONObject.optInt("server_upload_state", 1);
                    cn.jiguang.e.c.b(context, optInt4);
                    f.c("JBridgeHelper", "server_upload_state: " + optInt4 + ", sp state: " + cn.jiguang.e.c.e(context));
                }
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aA().a((cn.jiguang.e.a<Integer>) Integer.valueOf(optInt))});
                JConstants.CMD_TO_PRINT_ALL_LOG = optInt2 == 1;
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aB().a((cn.jiguang.e.a<Integer>) Integer.valueOf(optInt2))});
                int optInt5 = optJSONObject.optInt("expire");
                if (optInt5 <= 0) {
                    optInt5 = 7;
                }
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aC().a((cn.jiguang.e.a<Long>) Long.valueOf(cn.jiguang.bz.f.a(optInt5)))});
                f.c("JBridgeHelper", "dealCommandInternalDebug: content: " + optJSONObject + ", fromCmd: " + z5);
                if (optInt == 1) {
                    cn.jiguang.a.a.f1449g = true;
                    cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aD().a((cn.jiguang.e.a<Integer>) Integer.valueOf(Math.max(optJSONObject.optInt("delay_upload"), 10)))});
                    if (optInt3 == 1) {
                        cn.jiguang.bb.b.a(context);
                    }
                    if (!z5 || cn.jiguang.e.c.e(context) != 1) {
                        return;
                    } else {
                        f.c("JBridgeHelper", "dealCommandInternalDebug: server cmd upload log to server");
                    }
                } else {
                    cn.jiguang.a.a.f1449g = false;
                    if (!d.c(context)) {
                        return;
                    }
                    if (!cn.jiguang.e.c.d(context)) {
                        cn.jiguang.by.d.a("FUTURE_TASK", new cn.jiguang.by.b() { // from class: cn.jiguang.d.a.1
                            @Override // cn.jiguang.by.b
                            public void a() {
                                e.a();
                            }
                        });
                        return;
                    }
                }
                cn.jiguang.bb.b.b(context);
            }
        } catch (Throwable th) {
            f.l("JBridgeHelper", "dealCommandInternalDebug failed: " + th.getMessage());
        }
    }

    public static synchronized void a(Context context, boolean z5) {
        String str;
        String str2;
        synchronized (a.class) {
            try {
            } finally {
            }
            if (JConstants.isInstrumentationHookFailed) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                String packageName = origApplicationContext.getPackageName();
                String a6 = z5 ? cn.jiguang.bz.a.a(origApplicationContext) : packageName;
                if (TextUtils.isEmpty(a6) || !TextUtils.equals(packageName, a6)) {
                    str = "JBridgeHelper";
                    str2 = "need not registerActivityLifecycleCallbacks in other process :" + a6;
                } else {
                    try {
                        JConstants.isInstrumentationHookFailed = false;
                        ((Application) origApplicationContext).registerActivityLifecycleCallbacks(f2901a);
                        f.c("JBridgeHelper", "registerActivityLifecycleCallbacks in main process,packageName:" + packageName + ",currentProcessName:" + a6);
                    } catch (Throwable th) {
                        f.j("JBridgeHelper", "initPageLifecycle throwable=" + th);
                    }
                }
            } else {
                str = "JBridgeHelper";
                str2 = "need not registerActivityLifecycleCallbacks";
            }
            f.c(str, str2);
        }
    }

    public static void a(String str, String str2) {
        ActionManager.addAction(str, str2);
    }

    public static boolean a(String str) {
        return cn.jiguang.bi.b.a().a(str);
    }
}
