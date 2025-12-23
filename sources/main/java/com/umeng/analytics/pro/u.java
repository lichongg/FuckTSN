package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class u implements y.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f41448a = "session_start_time";

    /* renamed from: b, reason: collision with root package name */
    public static final String f41449b = "session_end_time";

    /* renamed from: c, reason: collision with root package name */
    public static final String f41450c = "session_id";

    /* renamed from: d, reason: collision with root package name */
    public static final String f41451d = "pre_session_id";

    /* renamed from: e, reason: collision with root package name */
    public static final String f41452e = "a_start_time";

    /* renamed from: f, reason: collision with root package name */
    public static final String f41453f = "a_end_time";

    /* renamed from: g, reason: collision with root package name */
    public static final String f41454g = "fg_count";

    /* renamed from: h, reason: collision with root package name */
    private static String f41455h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Context f41456i = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f41457j = false;

    /* renamed from: k, reason: collision with root package name */
    private static long f41458k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f41459l = true;

    /* renamed from: m, reason: collision with root package name */
    private static long f41460m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.u$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final u f41461a = new u(null);

        private a() {
        }
    }

    /* synthetic */ u(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static u a() {
        return a.f41461a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41456i);
        if (sharedPreferences != null) {
            long j6 = sharedPreferences.getLong(f41454g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f41454g, j6 + 1);
                edit.commit();
            }
        }
    }

    public void c(Context context, Object obj) {
        try {
            if (f41456i == null && context != null) {
                f41456i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f41452e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f41453f, longValue);
            edit.putLong(f41449b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f41454g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private String e(Context context) {
        if (f41456i == null && context != null) {
            f41456i = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        String d6 = y.a().d(f41456i);
        try {
            f(context);
            o.a(f41456i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d6;
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f41454g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public void a(Context context, long j6) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41456i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f41448a, j6);
        edit.commit();
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f41456i == null) {
                f41456i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41456i);
            if (sharedPreferences == null) {
                return;
            }
            f41458k = sharedPreferences.getLong(f41453f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f41458k);
            String string = sharedPreferences.getString(d.aF, "");
            String appVersionName = UMUtils.getAppVersionName(f41456i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f41448a, longValue);
                edit.commit();
                o.a(f41456i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + y.a().c(f41456i));
                f41457j = true;
                a(f41456i, longValue, true);
                return;
            }
            if (y.a().e(f41456i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f41457j = true;
                edit.putLong(f41448a, longValue);
                edit.commit();
                a(f41456i, longValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f41457j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f41456i == null && context != null) {
                f41456i = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41456i);
            if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                String string = sharedPreferences.getString(d.aF, "");
                String appVersionName = UMUtils.getAppVersionName(f41456i);
                if (TextUtils.isEmpty(string)) {
                    edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                    edit.putString(d.aF, appVersionName);
                    edit.commit();
                } else if (!string.equals(appVersionName)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                    int i6 = sharedPreferences.getInt("versioncode", 0);
                    String string2 = sharedPreferences.getString("pre_date", "");
                    String string3 = sharedPreferences.getString("pre_version", "");
                    String string4 = sharedPreferences.getString(d.aF, "");
                    edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                    edit.putString(d.aF, appVersionName);
                    edit.putString("vers_date", string2);
                    edit.putString("vers_pre_version", string3);
                    edit.putString("cur_version", string4);
                    edit.putInt("vers_code", i6);
                    edit.putString("vers_name", string);
                    edit.commit();
                    if (f41459l) {
                        f41459l = false;
                    }
                    if (f41457j) {
                        f41457j = false;
                        b(f41456i, longValue, true);
                        b(f41456i, longValue);
                        return;
                    }
                    return;
                }
                if (f41457j) {
                    f41457j = false;
                    if (f41459l) {
                        f41459l = false;
                    }
                    f41455h = e(context);
                    MLog.d("创建新会话: " + f41455h);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f41455h);
                    return;
                }
                f41455h = sharedPreferences.getString("session_id", null);
                edit.putLong(f41452e, longValue);
                edit.putLong(f41453f, 0L);
                edit.commit();
                MLog.d("延续上一个会话: " + f41455h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f41455h);
                if (f41459l) {
                    f41459l = false;
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                        Context context2 = f41456i;
                        UMWorkDispatch.sendEventEx(context2, o.a.E, CoreProtocol.getInstance(context2), null, 0L);
                    }
                }
                f(context);
                o.a(f41456i).a(false);
            }
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (f41455h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f41455h;
    }

    @Deprecated
    public String c() {
        return c(f41456i);
    }

    public boolean b(Context context, long j6, boolean z5) {
        String a6;
        long j7;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences != null && (a6 = y.a().a(f41456i)) != null) {
                long j8 = sharedPreferences.getLong(f41452e, 0L);
                long j9 = sharedPreferences.getLong(f41453f, 0L);
                if (j8 <= 0 || j9 != 0) {
                    return false;
                }
                try {
                    if (z5) {
                        j7 = f41458k;
                        if (j7 == 0) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j6);
                            j7 = j6;
                        } else {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f41458k);
                        }
                        c(f41456i, Long.valueOf(j7));
                    } else {
                        c(f41456i, Long.valueOf(j6));
                        j7 = j6;
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (z5) {
                        jSONObject.put(e.d.a.f41269g, j7);
                    } else {
                        jSONObject.put(e.d.a.f41269g, j6);
                    }
                    JSONObject b6 = com.umeng.analytics.b.a().b();
                    if (b6 != null && b6.length() > 0) {
                        jSONObject.put("__sp", b6);
                    }
                    JSONObject c6 = com.umeng.analytics.b.a().c();
                    if (c6 != null && c6.length() > 0) {
                        jSONObject.put("__pp", c6);
                    }
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f41460m);
                        jSONObject.put(e.d.a.f41270h, f41460m);
                        f41460m = 0L;
                    } else {
                        jSONObject.put(e.d.a.f41270h, 0L);
                    }
                    i.a(context).a(a6, jSONObject, i.a.END);
                    o.a(f41456i).e();
                } catch (Throwable unused) {
                }
                return true;
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public String a(Context context, long j6, boolean z5) {
        String b6 = y.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b6);
        if (TextUtils.isEmpty(b6)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j6);
            JSONObject b7 = com.umeng.analytics.b.a().b();
            if (b7 != null && b7.length() > 0) {
                jSONObject.put("__sp", b7);
            }
            JSONObject c6 = com.umeng.analytics.b.a().c();
            if (c6 != null && c6.length() > 0) {
                jSONObject.put("__pp", c6);
            }
            i.a(context).a(b6, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z5);
        } catch (Throwable unused) {
        }
        return b6;
    }

    public void b(Context context, long j6) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(f41456i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String b() {
        return f41455h;
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j6, long j7, long j8) {
        a(f41456i, str2, j6, j7, j8);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f41456i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j6, long j7, long j8) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j6);
    }

    private void a(Context context, String str, long j6, long j7, long j8) {
        if (TextUtils.isEmpty(f41455h)) {
            f41455h = y.a().a(f41456i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f41455h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.d.a.f41269g, j7);
            jSONObject.put(e.d.a.f41270h, j8);
            JSONObject b6 = com.umeng.analytics.b.a().b();
            if (b6 != null && b6.length() > 0) {
                jSONObject.put("__sp", b6);
            }
            JSONObject c6 = com.umeng.analytics.b.a().c();
            if (c6 != null && c6.length() > 0) {
                jSONObject.put("__pp", c6);
            }
            i.a(context).a(f41455h, jSONObject, i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j6);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                f41460m = j8;
                d(context);
                Context context2 = f41456i;
                UMWorkDispatch.sendEventEx(context2, o.a.E, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f41455h = str;
    }

    private void a(String str, long j6) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41456i);
        if (sharedPreferences == null) {
            return;
        }
        long j7 = sharedPreferences.getLong(f41449b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j6);
            jSONObject.put(e.d.a.f41269g, j7);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.C, location[0]);
                jSONObject2.put(d.D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(e.d.a.f41267e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i6 = f41456i.getApplicationInfo().uid;
            if (i6 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i6))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i6))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(d.H, longValue);
                jSONObject3.put(d.G, longValue2);
                jSONObject.put(e.d.a.f41266d, jSONObject3);
            }
            i.a(f41456i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(f41456i);
            l.c(f41456i);
        } catch (Throwable unused) {
        }
    }
}
