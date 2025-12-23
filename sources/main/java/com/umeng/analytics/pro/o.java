package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static Context f41368a = null;

    /* renamed from: l, reason: collision with root package name */
    private static final String f41369l = "first_activate_time";

    /* renamed from: m, reason: collision with root package name */
    private static final String f41370m = "ana_is_f";

    /* renamed from: n, reason: collision with root package name */
    private static final String f41371n = "thtstart";

    /* renamed from: o, reason: collision with root package name */
    private static final String f41372o = "dstk_last_time";

    /* renamed from: p, reason: collision with root package name */
    private static final String f41373p = "dstk_cnt";

    /* renamed from: q, reason: collision with root package name */
    private static final String f41374q = "gkvc";

    /* renamed from: r, reason: collision with root package name */
    private static final String f41375r = "ekvc";

    /* renamed from: t, reason: collision with root package name */
    private static final String f41376t = "-1";

    /* renamed from: x, reason: collision with root package name */
    private static final String f41377x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y, reason: collision with root package name */
    private static Class<?> f41378y;

    /* renamed from: z, reason: collision with root package name */
    private static Method f41379z;

    /* renamed from: b, reason: collision with root package name */
    private c f41380b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f41381c;

    /* renamed from: d, reason: collision with root package name */
    private String f41382d;

    /* renamed from: e, reason: collision with root package name */
    private String f41383e;

    /* renamed from: f, reason: collision with root package name */
    private int f41384f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f41385g;

    /* renamed from: h, reason: collision with root package name */
    private final int f41386h;

    /* renamed from: i, reason: collision with root package name */
    private int f41387i;

    /* renamed from: j, reason: collision with root package name */
    private int f41388j;

    /* renamed from: k, reason: collision with root package name */
    private long f41389k;

    /* renamed from: s, reason: collision with root package name */
    private final long f41390s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f41391u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f41392v;

    /* renamed from: w, reason: collision with root package name */
    private Object f41393w;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.o$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static final int A = 8209;
        public static final int B = 8210;
        public static final int C = 8211;
        public static final int D = 8212;
        public static final int E = 8213;
        public static final int F = 8214;
        public static final int G = 8215;

        /* renamed from: a, reason: collision with root package name */
        public static final int f41394a = 4097;

        /* renamed from: b, reason: collision with root package name */
        public static final int f41395b = 4098;

        /* renamed from: c, reason: collision with root package name */
        public static final int f41396c = 4099;

        /* renamed from: d, reason: collision with root package name */
        public static final int f41397d = 4100;

        /* renamed from: e, reason: collision with root package name */
        public static final int f41398e = 4101;

        /* renamed from: f, reason: collision with root package name */
        public static final int f41399f = 4102;

        /* renamed from: g, reason: collision with root package name */
        public static final int f41400g = 4103;

        /* renamed from: h, reason: collision with root package name */
        public static final int f41401h = 4104;

        /* renamed from: i, reason: collision with root package name */
        public static final int f41402i = 4105;

        /* renamed from: j, reason: collision with root package name */
        public static final int f41403j = 4106;

        /* renamed from: k, reason: collision with root package name */
        public static final int f41404k = 4352;

        /* renamed from: l, reason: collision with root package name */
        public static final int f41405l = 4353;

        /* renamed from: m, reason: collision with root package name */
        public static final int f41406m = 4354;

        /* renamed from: n, reason: collision with root package name */
        public static final int f41407n = 4355;

        /* renamed from: o, reason: collision with root package name */
        public static final int f41408o = 4356;

        /* renamed from: p, reason: collision with root package name */
        public static final int f41409p = 4357;

        /* renamed from: q, reason: collision with root package name */
        public static final int f41410q = 4358;

        /* renamed from: r, reason: collision with root package name */
        public static final int f41411r = 8193;

        /* renamed from: s, reason: collision with root package name */
        public static final int f41412s = 8194;

        /* renamed from: t, reason: collision with root package name */
        public static final int f41413t = 8195;

        /* renamed from: u, reason: collision with root package name */
        public static final int f41414u = 8196;

        /* renamed from: v, reason: collision with root package name */
        public static final int f41415v = 8197;

        /* renamed from: w, reason: collision with root package name */
        public static final int f41416w = 8199;

        /* renamed from: x, reason: collision with root package name */
        public static final int f41417x = 8200;

        /* renamed from: y, reason: collision with root package name */
        public static final int f41418y = 8201;

        /* renamed from: z, reason: collision with root package name */
        public static final int f41419z = 8208;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final o f41420a = new o(null);

        private b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, Object> f41427a;

        /* renamed from: b, reason: collision with root package name */
        private String f41428b;

        /* renamed from: c, reason: collision with root package name */
        private String f41429c;

        /* renamed from: d, reason: collision with root package name */
        private long f41430d;

        private d() {
            this.f41427a = null;
            this.f41428b = null;
            this.f41429c = null;
            this.f41430d = 0L;
        }

        public Map<String, Object> a() {
            return this.f41427a;
        }

        public String b() {
            return this.f41429c;
        }

        public String c() {
            return this.f41428b;
        }

        public long d() {
            return this.f41430d;
        }

        public d(String str, Map<String, Object> map, String str2, long j6) {
            this.f41427a = map;
            this.f41428b = str;
            this.f41430d = j6;
            this.f41429c = str2;
        }
    }

    /* synthetic */ o(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static o a(Context context) {
        if (f41368a == null && context != null) {
            f41368a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return b.f41420a;
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f41389k, this.f41387i)) {
                    return;
                } else {
                    this.f41387i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f41389k, this.f41388j)) {
                    return;
                } else {
                    this.f41388j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f41385g == null) {
                    this.f41385g = new JSONArray();
                }
                this.f41385g.put(jSONObject);
                i.a(f41368a).a(this.f41385g);
                this.f41385g = new JSONArray();
                return;
            }
            if (this.f41385g.length() >= this.f41384f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                i.a(f41368a).a(this.f41385g);
                this.f41385g = new JSONArray();
            }
            if (this.f41389k == 0) {
                this.f41389k = System.currentTimeMillis();
            }
            this.f41385g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(com.umeng.analytics.pro.d.f41195n)) {
                    i.a(f41368a).a(true, false);
                }
                i.a(f41368a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject2.has(com.umeng.analytics.pro.d.f41195n) && (optJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.d.f41195n).optJSONObject(0)) != null) {
                    String optString = optJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(optString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        i.a(f41368a).b(optString);
                    }
                }
            }
            i.a(f41368a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            Context context = f41368a;
            UMWorkDispatch.sendEvent(context, a.f41405l, CoreProtocol.getInstance(context), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(f41377x);
            f41378y = cls;
            Method declaredMethod = cls.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                f41379z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void o() {
        try {
            this.f41387i = 0;
            this.f41388j = 0;
            this.f41389k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f41368a).edit().putLong(f41372o, System.currentTimeMillis()).putInt(f41373p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    public void b() {
    }

    public void c() {
        b(f41368a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f41385g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                i.a(f41368a).a(this.f41385g);
                this.f41385g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f41368a).edit().putLong(f41371n, this.f41389k).putInt(f41374q, this.f41387i).putInt(f41375r, this.f41388j).commit();
        } catch (Throwable unused) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private ReportPolicy.ReportStrategy f41421a = null;

        /* renamed from: b, reason: collision with root package name */
        private int f41422b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f41423c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f41424d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f41425e = -1;

        /* renamed from: f, reason: collision with root package name */
        private ABTest f41426f;

        public void a() {
            try {
                int[] a6 = a(-1, -1);
                this.f41422b = a6[0];
                this.f41423c = a6[1];
            } catch (Throwable unused) {
            }
        }

        protected void b() {
            Defcon service = Defcon.getService(o.f41368a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f41421a;
                this.f41421a = ((reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid()) ? this.f41421a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(o.f41368a), service);
            } else {
                int i6 = 0;
                boolean z5 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f41368a, "integrated_test", "-1")).intValue() == 1;
                if (UMConfigure.isDebugLog() && z5 && !MLog.DEBUG) {
                    UMLog.mutlInfo(j.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z5) {
                    this.f41421a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(o.f41368a));
                } else if (this.f41426f.isInTest() && "RPT".equals(this.f41426f.getTestName())) {
                    if (this.f41426f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f41368a, "test_report_interval", "-1")).intValue() != -1) {
                            i6 = a(90000);
                        } else {
                            i6 = this.f41423c;
                            if (i6 <= 0) {
                                i6 = this.f41425e;
                            }
                        }
                    }
                    this.f41421a = b(this.f41426f.getTestPolicy(), i6);
                } else {
                    int i7 = this.f41424d;
                    int i8 = this.f41425e;
                    int i9 = this.f41422b;
                    if (i9 != -1) {
                        i8 = this.f41423c;
                        i7 = i9;
                    }
                    this.f41421a = b(i7, i8);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.f41421a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(j.I, 3, "", null, null);
                        return;
                    }
                    if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(j.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(j.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(j.M, 3, "", new String[]{"@"}, strArr);
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public c() {
            this.f41426f = null;
            this.f41426f = ABTest.getService(o.f41368a);
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f41421a;
        }

        public int[] a(int i6, int i7) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f41368a, "report_policy", "-1")).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f41368a, "report_interval", "-1")).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i6, i7};
            }
            if (6 == intValue) {
                if (intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) {
                    intValue2 = 90;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
            if (11 == intValue) {
                if (intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) {
                    intValue2 = 15;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
            return new int[]{i6, i7};
        }

        public int a(int i6) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.f41368a, "test_report_interval", "-1")).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i6 : intValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i6, int i7) {
            if (i6 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f41421a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i6 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f41421a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i6 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f41421a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(o.f41368a));
            }
            if (i6 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f41421a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(o.f41368a);
            }
            if (i6 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f41421a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i7);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(o.f41368a), i7);
            }
            if (i6 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f41421a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(o.f41368a));
            }
            if (i6 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f41421a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f41421a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i7);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i7);
            return reportQuasiRealtime;
        }
    }

    private o() {
        this.f41380b = null;
        this.f41381c = null;
        this.f41382d = null;
        this.f41383e = null;
        this.f41384f = 10;
        this.f41385g = new JSONArray();
        this.f41386h = 5000;
        this.f41387i = 0;
        this.f41388j = 0;
        this.f41389k = 0L;
        this.f41390s = 28800000L;
        this.f41391u = false;
        this.f41392v = false;
        this.f41393w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41368a);
            this.f41389k = sharedPreferences.getLong(f41371n, 0L);
            this.f41387i = sharedPreferences.getInt(f41374q, 0);
            this.f41388j = sharedPreferences.getInt(f41375r, 0);
            this.f41380b = new c();
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject f6;
        if (i.a(UMGlobalContext.getAppContext(f41368a)).c() || (f6 = i.a(UMGlobalContext.getAppContext(f41368a)).f()) == null) {
            return;
        }
        String optString = f6.optString("__av");
        String optString2 = f6.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f41368a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f41368a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(com.umeng.analytics.pro.d.f41195n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    i.a(f41368a).i();
                    i.a(f41368a).h();
                    i.a(f41368a).b(true, false);
                    i.a(f41368a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(com.umeng.analytics.pro.d.f41195n)) {
                    i.a(f41368a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(com.umeng.analytics.pro.d.Z)) {
                    i.a(f41368a).h();
                }
                if (optJSONObject.has("error")) {
                    i.a(f41368a).i();
                }
            }
            i.a(f41368a).a();
        } catch (Exception unused) {
        }
    }

    private void i() {
        JSONObject b6 = b(UMEnvelopeBuild.maxDataSpace(f41368a));
        if (b6 == null || b6.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) b6.opt("header");
        JSONObject jSONObject2 = (JSONObject) b6.opt("content");
        if (f41368a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f41368a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(buildEnvelopeWithExtHeader);
            }
            b((Object) buildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a6 = a(UMEnvelopeBuild.maxDataSpace(f41368a));
        if (a6 == null || a6.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) a6.opt("header");
        JSONObject jSONObject2 = (JSONObject) a6.opt("content");
        Context context = f41368a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(buildEnvelopeWithExtHeader);
        }
        a((Object) buildEnvelopeWithExtHeader);
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f41368a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f41190i), verticalType);
            String str = "9.6.5";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f41368a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.6.5");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f41368a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f41368a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41368a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f41368a, com.umeng.analytics.pro.d.at, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.av), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.av), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f41368a, com.umeng.analytics.pro.d.au, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aw), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aw), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.an), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f41370m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f41193l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f41194m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f41193l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f41194m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f41368a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    private String m() {
        String str = "0";
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f41368a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f41382d)) {
                return this.f41382d;
            }
            if (this.f41381c == null) {
                this.f41381c = PreferenceWrapper.getDefault(f41368a);
            }
            String string = this.f41381c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(f41368a);
            if (TextUtils.isEmpty(string)) {
                this.f41381c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
            } else {
                str = this.f41381c.getString("cur_version", "");
                if (appVersionName.equals(str)) {
                    str = string;
                } else {
                    this.f41381c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                }
            }
            this.f41382d = str;
            return str;
        }
        str = str2;
        this.f41382d = str;
        return str;
    }

    private String n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f41368a, "ud_da", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f41383e)) {
                    return this.f41383e;
                }
                if (this.f41381c == null) {
                    this.f41381c = PreferenceWrapper.getDefault(f41368a);
                }
                String string = this.f41381c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f41381c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.f41381c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.f41383e = str;
        return str;
    }

    private void q() {
        if (this.f41385g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i6 = 0; i6 < this.f41385g.length(); i6++) {
                try {
                    JSONObject jSONObject = this.f41385g.getJSONObject(i6);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String optString = jSONObject.optString("__i");
                        String str = "-1";
                        if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                            String b6 = u.a().b();
                            if (!TextUtils.isEmpty(b6)) {
                                str = b6;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f41385g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = f41368a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(f41369l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f41369l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f41368a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f41370m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    static {
        h();
    }

    private JSONObject k() {
        JSONObject l6 = l();
        if (l6 != null) {
            try {
                l6.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return l6;
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(u.a().b())) {
                b(f41368a);
            }
            if (this.f41385g.length() <= 0) {
                return false;
            }
            for (int i6 = 0; i6 < this.f41385g.length(); i6++) {
                JSONObject optJSONObject = this.f41385g.optJSONObject(i6);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || "-1".equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!i.a(f41368a).e()) {
                JSONObject g6 = i.a(f41368a).g();
                if (g6 != null) {
                    String optString = g6.optString("__av");
                    String optString2 = g6.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f41368a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f41368a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f41368a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f41368a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f41368a != null) {
            synchronized (this.f41393w) {
                try {
                    if (this.f41391u) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                        Context context = f41368a;
                        UMWorkDispatch.sendEvent(context, a.f41405l, CoreProtocol.getInstance(context), null);
                    }
                } finally {
                }
            }
            synchronized (this.f41393w) {
                try {
                    if (this.f41392v) {
                        Context context2 = f41368a;
                        UMWorkDispatch.sendEvent(context2, a.f41406m, CoreProtocol.getInstance(context2), null);
                    }
                } finally {
                }
            }
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            i.a(f41368a).a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        String str;
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    str = "channel";
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                } else {
                    str = "channel";
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.Z)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.Z, jSONObject4.getJSONArray(com.umeng.analytics.pro.d.Z));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.f41195n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.f41195n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i6);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(com.umeng.analytics.pro.d.f41202u)) {
                                jSONObject5.remove(com.umeng.analytics.pro.d.f41202u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.f41195n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.I)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.I));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            } else {
                str = "channel";
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a(str))) {
                    jSONObject3.put(str, jSONObject2.getString(com.umeng.commonsdk.statistics.b.a(str)));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public JSONObject b(long j6) {
        if (TextUtils.isEmpty(y.a().d(UMGlobalContext.getAppContext(f41368a)))) {
            return null;
        }
        JSONObject b6 = i.a(UMGlobalContext.getAppContext(f41368a)).b(false);
        String[] a6 = com.umeng.analytics.c.a(f41368a);
        if (a6 != null && !TextUtils.isEmpty(a6[0]) && !TextUtils.isEmpty(a6[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.d.M, a6[0]);
                jSONObject.put(com.umeng.analytics.pro.d.N, a6[1]);
                if (jSONObject.length() > 0) {
                    b6.put(com.umeng.analytics.pro.d.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a7 = r.a().a(f41368a);
        if (b6.length() == 1 && b6.optJSONObject(com.umeng.analytics.pro.d.L) != null && a7 != 3) {
            return null;
        }
        r.a().b(b6, f41368a);
        if (b6.length() <= 0 && a7 != 3) {
            return null;
        }
        JSONObject k6 = k();
        if (k6 != null) {
            b(k6);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (a7 == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (b6.length() > 0) {
                jSONObject3.put("analytics", b6);
            }
            if (k6 != null && k6.length() > 0) {
                jSONObject2.put("header", k6);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j6);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z5) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f41380b == null) {
            this.f41380b = new c();
        }
        this.f41380b.a();
        ReportPolicy.ReportStrategy c6 = this.f41380b.c();
        boolean shouldSendMessage = c6.shouldSendMessage(z5);
        if (shouldSendMessage) {
            if (((c6 instanceof ReportPolicy.ReportByInterval) || (c6 instanceof ReportPolicy.DebugPolicy) || (c6 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c6 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + c6.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = f41378y;
        if (cls == null || (method = f41379z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(com.umeng.analytics.pro.d.f41195n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.f41195n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i6);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.f41195n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj, int i6) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i6 != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                h.a(f41368a);
                com.umeng.commonsdk.utils.c.c(f41368a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                if (i6 != 4358) {
                    switch (i6) {
                        case 4097:
                            if (UMUtils.isMainProgress(f41368a)) {
                                if (obj != null) {
                                    e(obj);
                                }
                                if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                                    return;
                                }
                                a(false);
                                return;
                            }
                            UMProcessDBHelper.getInstance(f41368a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f41368a), new JSONArray().put(obj));
                            return;
                        case 4098:
                            if (obj != null) {
                                e(obj);
                            }
                            if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        case 4099:
                            v.a(f41368a);
                            return;
                        case 4100:
                            l.c(f41368a);
                            return;
                        case a.f41398e /* 4101 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                            a((Object) null, true);
                            g(obj);
                            return;
                        case a.f41399f /* 4102 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                            a((Object) null, true);
                            f(obj);
                            return;
                        case a.f41400g /* 4103 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                            u.a().a(f41368a, obj);
                            synchronized (this.f41393w) {
                                this.f41392v = true;
                            }
                            return;
                        case a.f41401h /* 4104 */:
                            u.a().c(f41368a, obj);
                            return;
                        case a.f41402i /* 4105 */:
                            d();
                            return;
                        case a.f41403j /* 4106 */:
                            h(obj);
                            return;
                        default:
                            switch (i6) {
                                case a.f41404k /* 4352 */:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                    u.a().b(f41368a, obj);
                                    synchronized (this.f41393w) {
                                        this.f41391u = true;
                                    }
                                    return;
                                case a.f41405l /* 4353 */:
                                    a(obj, true);
                                    return;
                                case a.f41406m /* 4354 */:
                                    c();
                                    return;
                                case a.f41407n /* 4355 */:
                                    if (!UMUtils.isMainProgress(f41368a)) {
                                        UMProcessDBHelper.getInstance(f41368a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f41368a), new JSONArray().put(obj));
                                        return;
                                    } else {
                                        if (obj != null) {
                                            e(obj);
                                            d();
                                            return;
                                        }
                                        return;
                                    }
                                case a.f41408o /* 4356 */:
                                    if (obj == null || f41378y == null || f41379z == null) {
                                        return;
                                    }
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                    String str = "";
                                    String str2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has("uid") && jSONObject.has(com.umeng.analytics.pro.d.M)) {
                                            str = jSONObject.getString(com.umeng.analytics.pro.d.M);
                                            str2 = jSONObject.getString("uid");
                                        }
                                        a(str2, str);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i6) {
                                        case a.f41413t /* 8195 */:
                                            com.umeng.analytics.b.a().a(obj);
                                            return;
                                        case a.f41414u /* 8196 */:
                                            com.umeng.analytics.b.a().m();
                                            return;
                                        case a.f41415v /* 8197 */:
                                            com.umeng.analytics.b.a().k();
                                            return;
                                        default:
                                            switch (i6) {
                                                case a.f41416w /* 8199 */:
                                                case a.f41417x /* 8200 */:
                                                    com.umeng.analytics.b.a().b(obj);
                                                    return;
                                                case a.f41418y /* 8201 */:
                                                    com.umeng.analytics.b.a().b((Object) null);
                                                    return;
                                                default:
                                                    switch (i6) {
                                                        case a.f41419z /* 8208 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                            Context context = f41368a;
                                                            UMWorkDispatch.sendEvent(context, a.A, CoreProtocol.getInstance(context), null);
                                                            Context context2 = f41368a;
                                                            UMWorkDispatch.sendEvent(context2, a.f41406m, CoreProtocol.getInstance(context2), null);
                                                            return;
                                                        case a.A /* 8209 */:
                                                            a(obj, false);
                                                            return;
                                                        case a.B /* 8210 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                            if (UMUtils.isMainProgress(f41368a) && !(this.f41380b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                a(true);
                                                                return;
                                                            }
                                                            return;
                                                        default:
                                                            switch (i6) {
                                                                case a.E /* 8213 */:
                                                                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                        if (DeviceConfig.getGlobleActivity(f41368a) != null) {
                                                                            u.b(f41368a);
                                                                        }
                                                                        Context context3 = f41368a;
                                                                        UMWorkDispatch.sendEventEx(context3, a.E, CoreProtocol.getInstance(context3), null, 5000L);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.F /* 8214 */:
                                                                    if (obj != null && (obj instanceof JSONObject)) {
                                                                        String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                        String optString2 = ((JSONObject) obj).optString(AnalyticsConfig.RTD_PERIOD);
                                                                        String optString3 = ((JSONObject) obj).optString(AnalyticsConfig.DEBUG_KEY);
                                                                        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                            return;
                                                                        }
                                                                        Context context4 = f41368a;
                                                                        String str3 = AnalyticsConfig.RTD_SP_FILE;
                                                                        com.umeng.common.b.a(context4, str3, AnalyticsConfig.RTD_START_TIME, optString);
                                                                        com.umeng.common.b.a(f41368a, str3, AnalyticsConfig.RTD_PERIOD, optString2);
                                                                        com.umeng.common.b.a(f41368a, str3, AnalyticsConfig.DEBUG_KEY, optString3);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.G /* 8215 */:
                                                                    com.umeng.common.b.a(f41368a, AnalyticsConfig.RTD_SP_FILE);
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                if (obj != null && (obj instanceof JSONObject)) {
                    String optString4 = ((JSONObject) obj).optString(com.umeng.analytics.pro.d.S);
                    Object opt = ((JSONObject) obj).opt("pv");
                    if (TextUtils.isEmpty(optString4)) {
                        return;
                    }
                    String[] a6 = com.umeng.analytics.c.a(f41368a);
                    if (a6 != null && !TextUtils.isEmpty(a6[0]) && !TextUtils.isEmpty(a6[1])) {
                        if (com.umeng.analytics.pro.d.O.equals(optString4)) {
                            com.umeng.analytics.c.a((String) opt);
                            return;
                        } else if (com.umeng.analytics.pro.d.P.equals(optString4)) {
                            com.umeng.analytics.c.b((String) opt);
                            return;
                        } else {
                            com.umeng.analytics.c.a(optString4, opt);
                            return;
                        }
                    }
                    MLog.e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f41368a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(com.umeng.analytics.pro.d.M);
                String string2 = jSONObject.getString("uid");
                long j6 = jSONObject.getLong("ts");
                String[] a6 = com.umeng.analytics.c.a(f41368a);
                if (a6 != null && string.equals(a6[0]) && string2.equals(a6[1])) {
                    return;
                }
                u.a().a(f41368a, j6);
                String c6 = y.a().c(f41368a);
                boolean b6 = u.a().b(f41368a, j6, false);
                com.umeng.analytics.c.a(f41368a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c6);
                u.a().a(f41368a, j6, true);
                if (b6) {
                    u.a().b(f41368a, j6);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long j6 = 0;
        try {
            Context context = f41368a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j7 = sharedPreferences.getLong(f41369l, 0L);
            if (j7 != 0) {
                return j7;
            }
            try {
                j6 = System.currentTimeMillis();
                sharedPreferences.edit().putLong(f41369l, j6).commit();
                return j6;
            } catch (Throwable unused) {
                return j7;
            }
        } catch (Throwable unused2) {
            return j6;
        }
    }

    public void c(Object obj) {
        b(f41368a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j6 = jSONObject.getLong("ts");
                b(f41368a);
                d();
                String[] a6 = com.umeng.analytics.c.a(f41368a);
                if (a6 == null || TextUtils.isEmpty(a6[0]) || TextUtils.isEmpty(a6[1])) {
                    return;
                }
                u.a().a(f41368a, j6);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + y.a().c(f41368a));
                boolean b6 = u.a().b(f41368a, j6, false);
                com.umeng.analytics.c.b(f41368a);
                u.a().a(f41368a, j6, true);
                if (b6) {
                    u.a().b(f41368a, j6);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j6) {
        try {
            if (q.a(jSONObject) <= j6) {
                return jSONObject;
            }
            jSONObject = null;
            i.a(f41368a).a(true, false);
            i.a(f41368a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z5) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = i.a(f41368a).a(z5);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    boolean has = jSONObject.has(com.umeng.analytics.pro.d.f41195n);
                    jSONObject = jSONObject;
                    if (has) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(com.umeng.analytics.pro.d.f41195n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i6 = 0;
                        while (i6 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i6);
                            JSONArray optJSONArray = jSONObject2.optJSONArray(com.umeng.analytics.pro.d.f41201t);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(com.umeng.analytics.pro.d.f41202u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(com.umeng.analytics.pro.d.f41201t, optJSONArray2);
                                jSONObject2.remove(com.umeng.analytics.pro.d.f41202u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i7));
                                }
                                for (int i8 = 0; i8 < optJSONArray2.length(); i8++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i8));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.d.f41205x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject2.put(com.umeng.analytics.pro.d.f41201t, jSONArray5);
                                jSONObject2.remove(com.umeng.analytics.pro.d.f41202u);
                            }
                            if (jSONObject2.has(com.umeng.analytics.pro.d.f41201t)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.analytics.pro.d.f41201t);
                                int i9 = 0;
                                while (i9 < optJSONArray3.length()) {
                                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i9);
                                    if (jSONObject3.has(com.umeng.analytics.pro.d.f41205x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(com.umeng.analytics.pro.d.f41205x));
                                        jSONObject3.remove(com.umeng.analytics.pro.d.f41205x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i9++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.d.f41201t, optJSONArray3);
                                jSONObject2.put(com.umeng.analytics.pro.d.f41207z, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(com.umeng.analytics.pro.d.f41207z, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i6++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(com.umeng.analytics.pro.d.f41195n, jSONArray4);
                        jSONObject = jSONObject;
                    }
                } catch (Exception e6) {
                    MLog.e("merge pages error");
                    e6.printStackTrace();
                    jSONObject = jSONObject;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f41368a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] a6 = com.umeng.analytics.c.a(f41368a);
            if (a6 != null && !TextUtils.isEmpty(a6[0]) && !TextUtils.isEmpty(a6[1])) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(com.umeng.analytics.pro.d.M, a6[0]);
                jSONObject4.put(com.umeng.analytics.pro.d.N, a6[1]);
                if (jSONObject4.length() > 0) {
                    JSONObject jSONObject5 = new JSONObject();
                    String a7 = com.umeng.analytics.c.a();
                    if (a7 != null) {
                        jSONObject5.put(com.umeng.analytics.pro.d.O, a7);
                    }
                    String b6 = com.umeng.analytics.c.b();
                    if (b6 != null) {
                        jSONObject5.put(com.umeng.analytics.pro.d.P, b6);
                    }
                    Map<String, Object> c6 = com.umeng.analytics.c.c(f41368a);
                    if (c6 != null && c6.size() > 0) {
                        for (String str : c6.keySet()) {
                            jSONObject5.put(str, c6.get(str));
                        }
                    }
                    if (jSONObject5.length() > 0) {
                        jSONObject4.put("up", jSONObject5);
                    }
                    jSONObject.put(com.umeng.analytics.pro.d.L, jSONObject4);
                }
            }
            if (ABTest.getService(f41368a).isInTest()) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(ABTest.getService(f41368a).getTestName(), ABTest.getService(f41368a).getGroupInfo());
                jSONObject.put(com.umeng.analytics.pro.d.K, jSONObject6);
            }
            r.a().a(jSONObject, f41368a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z5) {
        if (this.f41380b == null) {
            this.f41380b = new c();
        }
        ReportPolicy.ReportStrategy c6 = this.f41380b.c();
        if (!(c6 instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z5) {
            return ((ReportPolicy.DefconPolicy) c6).shouldSendMessageByInstant();
        }
        return c6.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 == jSONObject.getInt("exception")) {
                            return;
                        }
                        f(jSONObject);
                        return;
                    }
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            i.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z5) {
        if (c(z5)) {
            if (!(this.f41380b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f41368a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z5) {
                if (UMEnvelopeBuild.isOnline(f41368a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(f41368a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i7);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i6++;
                }
            } catch (Throwable unused) {
            }
        }
        return i6 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            try {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i7);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && a(optJSONArray2)) {
                        i6++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i6 >= length;
    }

    public JSONObject a(long j6) {
        if (TextUtils.isEmpty(y.a().d(f41368a))) {
            return null;
        }
        JSONObject b6 = b(false);
        int a6 = r.a().a(f41368a);
        if (b6.length() > 0) {
            if (b6.length() == 1) {
                if (b6.optJSONObject(com.umeng.analytics.pro.d.L) != null && a6 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b6.optString("userlevel")) && a6 != 3) {
                    return null;
                }
            } else if (b6.length() == 2 && b6.optJSONObject(com.umeng.analytics.pro.d.L) != null && !TextUtils.isEmpty(b6.optString("userlevel")) && a6 != 3) {
                return null;
            }
            String optString = b6.optString(com.umeng.analytics.pro.d.f41195n);
            String optString2 = b6.optString(com.umeng.analytics.pro.d.Z);
            String optString3 = b6.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b6)) {
                return null;
            }
        } else if (a6 != 3) {
            return null;
        }
        JSONObject l6 = l();
        if (l6 != null) {
            c(l6);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a6 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b6.length() > 0) {
                jSONObject2.put("analytics", b6);
            }
            if (l6 != null && l6.length() > 0) {
                jSONObject.put("header", l6);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j6);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j6) {
        try {
            if (q.a(jSONObject) <= j6) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.d.aH, q.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return q.a(f41368a, j6, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j6, int i6) {
        if (j6 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j6 <= 28800000) {
            return i6 < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 == jSONObject.getInt("exception")) {
                            return;
                        }
                        g(jSONObject);
                        return;
                    }
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z5) {
        if (z5) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f41368a) && d(true)) {
            i();
        }
    }
}
