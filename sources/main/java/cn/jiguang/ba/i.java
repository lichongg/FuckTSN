package cn.jiguang.ba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bz.w;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1938a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f1939b;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f1940c;

    /* renamed from: d, reason: collision with root package name */
    private static long f1941d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f1942e;

    /* renamed from: f, reason: collision with root package name */
    private static LinkedList<String> f1943f;

    private static class a extends cn.jiguang.by.b {

        /* renamed from: a, reason: collision with root package name */
        private Context f1944a;

        private int a(Context context) {
            String a6;
            String str;
            try {
                a6 = cn.jiguang.ba.a.a(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(a6)) {
                cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "request bannedConfig failed because can't get appKey");
                return -1;
            }
            w.a(context, i.f1943f);
            Iterator it = i.f1943f.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                JSONObject jSONObject = new JSONObject();
                ActionManager.getInstance();
                if (!ActionManager.wrapSdkTypeVersionInfo(jSONObject)) {
                    cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "request bannedConfig wrapSdkTypeVersionInfo is false");
                    return -1;
                }
                if (jSONObject.length() > 0) {
                    jSONObject.put("appkey", a6);
                    jSONObject.put("platform", FaceEnvironment.OS);
                }
                cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "request url: " + str2 + ", param json:" + jSONObject.toString());
                if (TextUtils.isEmpty(str2)) {
                    cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "can't get url, give up upload");
                    return -1;
                }
                Context context2 = context;
                cn.jiguang.bd.g a7 = cn.jiguang.bd.b.a(str2, jSONObject.toString(), context2, false, 3, 3);
                int a8 = a7.a();
                String b6 = a7.b();
                cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "code: " + a8 + ", responseBody:" + b6);
                int a9 = a7.a();
                if (a9 == -3) {
                    return -2;
                }
                if (a9 != 3006) {
                    if (a9 == -1) {
                        str = "upload" + jSONObject.toString() + " error:" + a7.b();
                    } else {
                        if (a9 == 0) {
                            if (TextUtils.isEmpty(b6)) {
                                return 0;
                            }
                            i.b(context2, new JSONObject(b6));
                            return 0;
                        }
                        str = "upload" + jSONObject.toString() + " failed";
                    }
                    cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", str);
                } else {
                    Boolean unused2 = i.f1942e = null;
                }
                context = context2;
            }
            return -1;
        }

        @Override // cn.jiguang.by.b
        public void a() {
            cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "start request sdk limit config");
            int a6 = a(this.f1944a);
            if (a6 != 0) {
                cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "request limit config failed, code: " + a6);
            }
        }

        a(Context context) {
            this.f1944a = context;
            this.f2653h = "JLimitConfig";
        }
    }

    public static int b() {
        return !TextUtils.isEmpty(cn.jiguang.a.a.f1446d) ? 1 : 0;
    }

    public static Integer c() {
        return null;
    }

    static {
        String b6 = cn.jiguang.bz.l.b(new byte[]{121, 68, 84, 105, 123, HttpConstants.COMMA, 62, Ascii.US, 67, 118, 102, 112, 120, 87, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 103, 1, 15, 111, 109, 100, 98, 89, 79, 119, 37, 117, 121, 85, 67, 114});
        f1938a = b6;
        String b7 = cn.jiguang.bz.l.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 83, 79, 119, 110, Byte.MAX_VALUE, 118, 29, 73, 105, 126, 32, Utf8.REPLACEMENT_BYTE, 90, 80, 108, 123, 126, Utf8.REPLACEMENT_BYTE, 83, 78, 54, 126, 39, 62, 70, 69, 107, 123, Byte.MAX_VALUE, 126, 94, 13, 122, 96, 115, 114, 91});
        f1939b = b7;
        f1940c = new AtomicBoolean(false);
        f1941d = 0L;
        f1942e = null;
        LinkedList<String> linkedList = new LinkedList<>();
        f1943f = linkedList;
        linkedList.clear();
        f1943f.add(b6);
        f1943f.add(b7);
    }

    public static void b(Context context) {
        if (context == null) {
            cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "updateImmediately failed: context is null");
            return;
        }
        boolean z5 = f1942e != null || System.currentTimeMillis() <= f1941d;
        cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "updateImmediately: needReset=" + z5 + ", gIsConfigRequested=" + f1942e + ", gNextReqTime=" + f1941d);
        if (z5) {
            cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "Reset request status and continue update");
            f1942e = null;
            f1941d = 0L;
            a(context, f1940c.get(), f1941d);
        }
        a();
    }

    private static boolean c(Context context) {
        try {
            String string = context.getSharedPreferences("cn.jiguang.prefs", 0).getString("sdk_limit_status", "");
            cn.jiguang.bb.f.f("JSDKDeveloperIdLimitHelper", "local sdk limit config: " + string);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                boolean parseBoolean = Boolean.parseBoolean(split[0]);
                long parseLong = Long.parseLong(split[1]);
                cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "local limit config, isLimit: " + parseBoolean + ", nextReqTime: " + parseLong);
                f1941d = parseLong;
                f1940c = new AtomicBoolean(parseBoolean);
                return true;
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "read config json from cache failed !! error:" + th);
        }
        return false;
    }

    private static void a(Context context, boolean z5, long j6) {
        b(context, z5, j6);
        f1941d = j6;
        if (f1940c.get() != z5) {
            cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "sdk limit status changed, update status, sdkLimit: " + z5);
            if (!z5) {
                f1940c = new AtomicBoolean(z5);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("sdk_banned", z5);
            JCoreManager.onEvent(context, "", 81, null, bundle, new Object[0]);
        }
        if (z5) {
            cn.jiguang.bb.f.d("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk type is " + b());
            cn.jiguang.bb.f.l("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk, but it is limited now. If you want to enable it, please contact us.");
        }
        f1940c = new AtomicBoolean(z5);
        cn.jiguang.bb.f.f("JSDKDeveloperIdLimitHelper", "sdk limit status, limit: " + z5 + ", nextTime: " + f1941d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean z5 = true;
            if (jSONObject.optInt("code") != 1) {
                z5 = false;
            }
            long optLong = jSONObject.optLong("nexttime", 43200L);
            cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "from server sdk limit status: " + z5 + ", next request time: " + optLong);
            if (optLong <= 0) {
                optLong = 0;
            }
            if (optLong >= 86400) {
                optLong = 86400;
            }
            a(context, z5, System.currentTimeMillis() + (optLong * 1000));
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "parse sdk limit config failed, " + th.getMessage());
        }
    }

    public static boolean a() {
        Context a6;
        try {
            a6 = cn.jiguang.bz.d.a(null);
        } catch (Throwable th) {
            cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "isSDKLimit error:" + th);
        }
        if (a6 != null && cn.jiguang.bz.b.a() && cn.jiguang.bq.b.a().a(a6)) {
            if (TextUtils.isEmpty(cn.jiguang.ba.a.a(a6))) {
                return f1940c.get();
            }
            if (cn.jiguang.a.a.f1445c == JConstants.SDK_VERSION_INT && f1942e == null) {
                if (ActionManager.wrapSdkTypeVersionInfo(new JSONObject())) {
                    return a(a6);
                }
                f1942e = Boolean.TRUE;
            }
            return f1940c.get();
        }
        return false;
    }

    private static void b(Context context, boolean z5, long j6) {
        try {
            String str = z5 + "," + j6;
            cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "save sdk limit status: " + str);
            context.getSharedPreferences("cn.jiguang.prefs", 0).edit().putString("sdk_limit_status", str).apply();
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JSDKDeveloperIdLimitHelper", "[saveSdkLimitStatus] parse json error, " + th.getMessage());
        }
    }

    public static boolean a(int i6) {
        return i6 == 1 || i6 == 4 || i6 == 5 || i6 == 3;
    }

    public static synchronized boolean a(Context context) {
        synchronized (i.class) {
            if (f1942e != null) {
                return f1940c.get();
            }
            f1942e = Boolean.TRUE;
            c(context);
            if (System.currentTimeMillis() > f1941d) {
                cn.jiguang.by.d.a("FUTURE_TASK", new a(context), 0, false);
            } else {
                if (f1940c.get()) {
                    cn.jiguang.bb.f.d("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk type is " + b());
                    cn.jiguang.bb.f.l("JSDKDeveloperIdLimitHelper", "[key-step]You use the special sdk, but it is limited now. If you want to enable it, please contact us.");
                }
                cn.jiguang.bb.f.c("JSDKDeveloperIdLimitHelper", "request sdk limit config not time up, not request");
            }
            return f1940c.get();
        }
    }
}
