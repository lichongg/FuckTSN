package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.d;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b implements n, t {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* renamed from: a, reason: collision with root package name */
    private static Context f40768a = null;

    /* renamed from: h, reason: collision with root package name */
    private static final String f40769h = "sp_uapp";

    /* renamed from: i, reason: collision with root package name */
    private static final String f40770i = "prepp_uapp";

    /* renamed from: o, reason: collision with root package name */
    private static final int f40771o = 128;

    /* renamed from: p, reason: collision with root package name */
    private static final int f40772p = 256;

    /* renamed from: q, reason: collision with root package name */
    private static String f40773q = "";

    /* renamed from: r, reason: collision with root package name */
    private static String f40774r = "";

    /* renamed from: t, reason: collision with root package name */
    private static final String f40776t = "ekv_bl_ver";

    /* renamed from: w, reason: collision with root package name */
    private static final String f40778w = "ekv_wl_ver";

    /* renamed from: z, reason: collision with root package name */
    private static final String f40779z = "umsp_1";

    /* renamed from: b, reason: collision with root package name */
    private ISysListener f40780b;

    /* renamed from: c, reason: collision with root package name */
    private p f40781c;

    /* renamed from: d, reason: collision with root package name */
    private v f40782d;

    /* renamed from: e, reason: collision with root package name */
    private k f40783e;

    /* renamed from: f, reason: collision with root package name */
    private u f40784f;

    /* renamed from: g, reason: collision with root package name */
    private l f40785g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f40786j;

    /* renamed from: k, reason: collision with root package name */
    private volatile JSONObject f40787k;

    /* renamed from: l, reason: collision with root package name */
    private volatile JSONObject f40788l;

    /* renamed from: m, reason: collision with root package name */
    private volatile JSONObject f40789m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f40790n;

    /* renamed from: u, reason: collision with root package name */
    private com.umeng.analytics.filter.a f40791u;

    /* renamed from: x, reason: collision with root package name */
    private com.umeng.analytics.filter.b f40792x;

    /* renamed from: y, reason: collision with root package name */
    private m f40793y;

    /* renamed from: s, reason: collision with root package name */
    private static final String f40775s = d.ar;

    /* renamed from: v, reason: collision with root package name */
    private static final String f40777v = d.as;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f40794a = new b(null);

        private a() {
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f40794a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f40787k == null) {
                this.f40787k = new JSONObject();
            }
            if (this.f40788l == null) {
                this.f40788l = new JSONObject();
            }
            String string = sharedPreferences.getString(f40770i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f40789m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f40789m == null) {
                this.f40789m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.f40787k;
    }

    public JSONObject c() {
        return this.f40789m;
    }

    public JSONObject d() {
        return this.f40788l;
    }

    public void e() {
        this.f40788l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(f40768a)) {
            return f40773q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() {
        if (UMUtils.isMainProgress(f40768a)) {
            return f40774r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            Context context = f40768a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Context context2 = f40768a;
                UMWorkDispatch.sendEvent(context2, o.a.f41404k, CoreProtocol.getInstance(context2), Long.valueOf(currentTimeMillis));
                Context context3 = f40768a;
                UMWorkDispatch.sendEvent(context3, o.a.f41400g, CoreProtocol.getInstance(context3), Long.valueOf(currentTimeMillis));
            }
            ISysListener iSysListener = this.f40780b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void k() {
        Context context;
        try {
            context = f40768a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f40787k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f40768a).edit();
            edit.putString(f40769h, this.f40787k.toString());
            edit.commit();
        } else {
            this.f40787k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        Context context;
        try {
            context = f40768a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f40787k == null) {
            this.f40787k = new JSONObject();
        }
        return this.f40787k;
    }

    public synchronized void m() {
        try {
            Context context = f40768a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f40768a).edit();
                    edit.remove(f40769h);
                    edit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f40768a = StubApp.getOrigApplicationContext(appContext.getApplicationContext());
        }
    }

    private b() {
        this.f40781c = new p();
        this.f40782d = new v();
        this.f40783e = new k();
        this.f40784f = u.a();
        this.f40785g = null;
        this.f40786j = false;
        this.f40787k = null;
        this.f40788l = null;
        this.f40789m = null;
        this.f40790n = false;
        this.f40791u = null;
        this.f40792x = null;
        this.f40793y = null;
        this.f40781c.a(this);
    }

    private boolean e(String str) {
        if (this.f40791u.enabled() && this.f40791u.matchHit(str)) {
            return true;
        }
        if (!this.f40792x.enabled()) {
            return false;
        }
        if (!this.f40792x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (this.f40791u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a(f40775s, "ekv_bl_ver");
                this.f40791u = aVar;
                aVar.register(f40768a);
            }
            if (this.f40792x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b(f40777v, "ekv_wl_ver");
                this.f40792x = bVar;
                bVar.register(f40768a);
            }
            if (UMUtils.isMainProgress(f40768a)) {
                if (!this.f40786j) {
                    this.f40786j = true;
                    i(f40768a);
                }
                synchronized (this) {
                    try {
                        if (!this.f40790n) {
                            l a6 = l.a(context);
                            this.f40785g = a6;
                            if (a6.a()) {
                                this.f40790n = true;
                            }
                            this.f40793y = m.a();
                            try {
                                m.a(context);
                                this.f40793y.a(this);
                            } catch (Throwable unused) {
                            }
                        }
                    } finally {
                    }
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(j.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f40768a));
            }
        } catch (Throwable unused2) {
        }
    }

    void b(String str) {
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f40782d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:21:0x0040, B:23:0x0044, B:26:0x004e, B:28:0x0054, B:29:0x0061, B:39:0x004b), top: B:20:0x0040 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void c(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "\\|"
            if (r4 != 0) goto Lb
            java.lang.String r4 = com.umeng.analytics.pro.j.f41330p
            r1 = 0
            com.umeng.commonsdk.debug.UMLog.aq(r4, r1, r0)
            return
        Lb:
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION
            com.umeng.analytics.MobclickAgent$PageMode r2 = com.umeng.analytics.MobclickAgent.PageMode.AUTO
            if (r1 != r2) goto L13
            goto L82
        L13:
            android.content.Context r1 = com.umeng.analytics.b.f40768a
            if (r1 != 0) goto L21
            android.content.Context r1 = r4.getApplicationContext()
            android.content.Context r1 = com.stub.StubApp.getOrigApplicationContext(r1)
            com.umeng.analytics.b.f40768a = r1
        L21:
            android.content.Context r1 = com.umeng.analytics.b.f40768a
            boolean r1 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r1)
            if (r1 != 0) goto L2f
            java.lang.String r4 = "onPause can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e(r4)
            return
        L2f:
            boolean r1 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r1 == 0) goto L40
            boolean r1 = r4 instanceof android.app.Activity
            if (r1 == 0) goto L3a
            goto L40
        L3a:
            java.lang.String r1 = com.umeng.analytics.pro.j.f41331q
            r2 = 2
            com.umeng.commonsdk.debug.UMLog.aq(r1, r2, r0)
        L40:
            boolean r0 = r3.f40786j     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L4b
            boolean r0 = r3.f40790n     // Catch: java.lang.Throwable -> L49
            if (r0 != 0) goto L4e
            goto L4b
        L49:
            r0 = move-exception
            goto L65
        L4b:
            r3.a(r4)     // Catch: java.lang.Throwable -> L49
        L4e:
            com.umeng.analytics.MobclickAgent$PageMode r0 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION     // Catch: java.lang.Throwable -> L49
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.analytics.MobclickAgent.PageMode.LEGACY_MANUAL     // Catch: java.lang.Throwable -> L49
            if (r0 == r1) goto L61
            com.umeng.analytics.pro.k r0 = r3.f40783e     // Catch: java.lang.Throwable -> L49
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L49
            r0.b(r1)     // Catch: java.lang.Throwable -> L49
        L61:
            r3.i()     // Catch: java.lang.Throwable -> L49
            goto L6e
        L65:
            boolean r1 = com.umeng.commonsdk.statistics.common.MLog.DEBUG
            if (r1 == 0) goto L6e
            java.lang.String r1 = "Exception occurred in Mobclick.onRause(). "
            com.umeng.commonsdk.statistics.common.MLog.e(r1, r0)
        L6e:
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r0 == 0) goto L82
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L82
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            com.umeng.analytics.b.f40774r = r4
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.c(android.content.Context):void");
    }

    void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f40768a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            l lVar = this.f40785g;
            if (lVar != null) {
                lVar.c();
            }
            l.a(context, "onKillProcess");
            k kVar = this.f40783e;
            if (kVar != null) {
                kVar.b();
            }
            v vVar = this.f40782d;
            if (vVar != null) {
                vVar.b();
            }
            Context context2 = f40768a;
            if (context2 != null) {
                u uVar = this.f40784f;
                if (uVar != null) {
                    uVar.c(context2, Long.valueOf(System.currentTimeMillis()));
                }
                o.a(f40768a).d();
                v.a(f40768a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f40768a);
                }
                PreferenceWrapper.getDefault(f40768a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    void j() {
        try {
            Context context = f40768a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f40768a;
            UMWorkDispatch.sendEvent(context2, o.a.f41399f, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f40768a;
            UMWorkDispatch.sendEvent(context3, o.a.f41408o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.n
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(o.a.B)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f40768a;
                UMWorkDispatch.sendEvent(context, o.a.B, CoreProtocol.getInstance(context), null);
            }
        }
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        this.f40787k = new JSONObject();
        Context context2 = f40768a;
        UMWorkDispatch.sendEvent(context2, o.a.f41414u, CoreProtocol.getInstance(context2), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(j.ap, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        if (this.f40789m.length() > 0) {
            Context context2 = f40768a;
            UMWorkDispatch.sendEvent(context2, o.a.f41418y, CoreProtocol.getInstance(context2), null);
        }
        this.f40789m = new JSONObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:20:0x003e, B:22:0x0042, B:25:0x004c, B:27:0x0052, B:28:0x005f, B:30:0x0068, B:32:0x006c, B:37:0x0049), top: B:19:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(android.content.Context r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L8
            java.lang.String r4 = "unexpected null context in onResume"
            com.umeng.commonsdk.statistics.common.MLog.e(r4)
            return
        L8:
            com.umeng.analytics.MobclickAgent$PageMode r0 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.analytics.MobclickAgent.PageMode.AUTO
            if (r0 != r1) goto Lf
            goto L76
        Lf:
            android.content.Context r0 = com.umeng.analytics.b.f40768a
            if (r0 != 0) goto L1d
            android.content.Context r0 = r4.getApplicationContext()
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)
            com.umeng.analytics.b.f40768a = r0
        L1d:
            android.content.Context r0 = com.umeng.analytics.b.f40768a
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r0)
            if (r0 != 0) goto L2b
            java.lang.String r4 = "onResume can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e(r4)
            return
        L2b:
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r0 == 0) goto L3e
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L36
            goto L3e
        L36:
            java.lang.String r0 = com.umeng.analytics.pro.j.f41329o
            r1 = 2
            java.lang.String r2 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq(r0, r1, r2)
        L3e:
            boolean r0 = r3.f40786j     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L49
            boolean r0 = r3.f40790n     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L4c
            goto L49
        L47:
            r4 = move-exception
            goto L77
        L49:
            r3.a(r4)     // Catch: java.lang.Throwable -> L47
        L4c:
            com.umeng.analytics.MobclickAgent$PageMode r0 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION     // Catch: java.lang.Throwable -> L47
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.analytics.MobclickAgent.PageMode.LEGACY_MANUAL     // Catch: java.lang.Throwable -> L47
            if (r0 == r1) goto L5f
            com.umeng.analytics.pro.k r0 = r3.f40783e     // Catch: java.lang.Throwable -> L47
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L47
            r0.a(r1)     // Catch: java.lang.Throwable -> L47
        L5f:
            r3.h()     // Catch: java.lang.Throwable -> L47
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L76
            boolean r0 = r4 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L76
            java.lang.Class r4 = r4.getClass()     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L47
            com.umeng.analytics.b.f40773q = r4     // Catch: java.lang.Throwable -> L47
        L76:
            return
        L77:
            java.lang.String r0 = "Exception occurred in Mobclick.onResume(). "
            com.umeng.commonsdk.statistics.common.MLog.e(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.b(android.content.Context):void");
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return null;
        }
        if (!str.equals(f40779z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.f40787k != null) {
            if (this.f40787k.has(str)) {
                return this.f40787k.opt(str);
            }
        } else {
            this.f40787k = new JSONObject();
        }
        return null;
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(j.aq, 0, "\\|");
            return null;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        if (this.f40789m == null) {
            this.f40789m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f40789m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f40789m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            Context context = f40768a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = f40768a;
                UMWorkDispatch.sendEvent(context2, o.a.f41401h, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = f40768a;
                UMWorkDispatch.sendEvent(context3, 4100, CoreProtocol.getInstance(context3), null);
                Context context4 = f40768a;
                UMWorkDispatch.sendEvent(context4, 4099, CoreProtocol.getInstance(context4), null);
                Context context5 = f40768a;
                UMWorkDispatch.sendEvent(context5, o.a.f41402i, CoreProtocol.getInstance(context5), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f40780b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.an, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        if (this.f40789m == null) {
            this.f40789m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f40789m.has(str)) {
                this.f40789m.remove(str);
                Context context2 = f40768a;
                UMWorkDispatch.sendEvent(context2, o.a.f41417x, CoreProtocol.getInstance(context2), this.f40789m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean g(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length >= 0 && length < 256) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile value must be less than 256 bytes.");
        return false;
    }

    public synchronized void d(Context context, String str) {
        try {
        } finally {
        }
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return;
        }
        if (!str.equals(f40779z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.f40787k == null) {
            this.f40787k = new JSONObject();
        }
        if (this.f40787k.has(str)) {
            this.f40787k.remove(str);
            Context context2 = f40768a;
            UMWorkDispatch.sendEvent(context2, o.a.f41415v, CoreProtocol.getInstance(context2), str);
        }
    }

    void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f41340z, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        AnalyticsConfig.a(f40768a, str);
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(j.N, 0, "\\|");
                return;
            }
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f40768a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f40786j || !this.f40790n) {
                a(f40768a);
            }
            if (TextUtils.isEmpty(str)) {
                UMLog.aq(j.O, 0, "\\|");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(d.aK, str);
            a(f40768a, d.aJ, (Map<String, Object>) hashMap, -1L, false);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(String str) {
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f40782d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.f40787k != null) {
            return this.f40787k.toString();
        }
        this.f40787k = new JSONObject();
        return null;
    }

    private boolean c(String str, Object obj) {
        int i6;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i6 = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i6 = 0;
        }
        if (i6 > 128) {
            MLog.e("key length is " + i6 + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f40780b = iSysListener;
        }
    }

    public void a(Context context, int i6) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        AnalyticsConfig.a(f40768a, i6);
    }

    private void b(String str, Object obj) {
        try {
            if (this.f40787k == null) {
                this.f40787k = new JSONObject();
            }
            int i6 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i6 < strArr.length) {
                        String str2 = strArr[i6];
                        if (str2 != null && !HelperUtils.checkStrLen(str2, 256)) {
                            jSONArray.put(strArr[i6]);
                        }
                        i6++;
                    }
                    this.f40787k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i6 < jArr.length) {
                        jSONArray2.put(jArr[i6]);
                        i6++;
                    }
                    this.f40787k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i6 < iArr.length) {
                        jSONArray3.put(iArr[i6]);
                        i6++;
                    }
                    this.f40787k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i6 < fArr.length) {
                        jSONArray4.put(fArr[i6]);
                        i6++;
                    }
                    this.f40787k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i6 < dArr.length) {
                        jSONArray5.put(dArr[i6]);
                        i6++;
                    }
                    this.f40787k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i6 < sArr.length) {
                        jSONArray6.put((int) sArr[i6]);
                        i6++;
                    }
                    this.f40787k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i6 < list.size()) {
                    Object obj2 = list.get(i6);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i6));
                    }
                    i6++;
                }
                this.f40787k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f40787k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean f(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length < 128) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile key must be less than 128 bytes.");
        return false;
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f40768a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f40786j || !this.f40790n) {
                a(f40768a);
            }
            String str2 = "";
            if (this.f40787k == null) {
                this.f40787k = new JSONObject();
            } else {
                str2 = this.f40787k.toString();
            }
            s.a(f40768a).a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void c(String str) {
        if (g(str)) {
            a(d.O, (Object) str);
        }
    }

    public void d(String str) {
        if (g(str)) {
            a(d.P, (Object) str);
        }
    }

    void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f41337w, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.f41338x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (this.f40786j) {
                if (!this.f40790n) {
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(d.W, 2);
                jSONObject.put(d.X, str);
                jSONObject.put("__ii", this.f40784f.c());
                Context context2 = f40768a;
                UMWorkDispatch.sendEvent(context2, o.a.f41403j, CoreProtocol.getInstance(context2), jSONObject);
            }
            a(f40768a);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put(d.W, 2);
            jSONObject2.put(d.X, str);
            jSONObject2.put("__ii", this.f40784f.c());
            Context context22 = f40768a;
            UMWorkDispatch.sendEvent(context22, o.a.f41403j, CoreProtocol.getInstance(context22), jSONObject2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!UMUtils.isMainProgress(f40768a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (this.f40786j) {
                    if (!this.f40790n) {
                    }
                    a(f40768a, DataHelper.convertExceptionToString(th));
                    return;
                }
                a(f40768a);
                a(f40768a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e6) {
                if (MLog.DEBUG) {
                    MLog.e(e6);
                    return;
                }
                return;
            }
        }
        UMLog.aq(j.f41339y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j6, int i6) {
        if (context == null) {
            return;
        }
        try {
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f40786j || !this.f40790n) {
                a(f40768a);
            }
            if (e(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.f40787k == null) {
                this.f40787k = new JSONObject();
            } else {
                str3 = this.f40787k.toString();
            }
            s.a(f40768a).a(str, str2, j6, i6, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized void b(Object obj) {
        Context context;
        try {
            context = f40768a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f40768a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f40770i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(f40770i).commit();
        }
    }

    void a(Context context, String str, Map<String, Object> map, long j6) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(d.aL).contains(str)) {
                UMLog.aq(j.f41316b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(j.f41318d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(d.aL).contains(it.next().getKey())) {
                    UMLog.aq(j.f41319e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j6, false);
            return;
        }
        UMLog.aq(j.f41317c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j6, boolean z5) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f40768a == null) {
                f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (!this.f40786j || !this.f40790n) {
                a(f40768a);
            }
            if (e(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f40787k == null) {
                this.f40787k = new JSONObject();
            } else {
                str2 = this.f40787k.toString();
            }
            s.a(f40768a).a(str, map, j6, str2, z5);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.t
    public void a(Throwable th) {
        try {
            Context context = f40768a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                v vVar = this.f40782d;
                if (vVar != null) {
                    vVar.b();
                }
                l.a(f40768a, "onAppCrash");
                k kVar = this.f40783e;
                if (kVar != null) {
                    kVar.b();
                }
                l lVar = this.f40785g;
                if (lVar != null) {
                    lVar.c();
                }
                u uVar = this.f40784f;
                if (uVar != null) {
                    uVar.c(f40768a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(d.W, 1);
                    jSONObject.put(d.X, DataHelper.convertExceptionToString(th));
                    i.a(f40768a).a(this.f40784f.c(), jSONObject.toString(), 1);
                }
                o.a(f40768a).d();
                v.a(f40768a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(f40768a);
                }
                PreferenceWrapper.getDefault(f40768a).edit().commit();
            }
        } catch (Exception e6) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e6);
            }
        }
    }

    void a(String str, String str2) {
        try {
            Context context = f40768a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f40768a;
            UMWorkDispatch.sendEvent(context2, o.a.f41398e, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f40768a;
            UMWorkDispatch.sendEvent(context3, o.a.f41408o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    void a(boolean z5) {
        Context context = f40768a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z5;
        }
    }

    void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    void a(double d6, double d7) {
        Context context = f40768a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f40745a == null) {
            AnalyticsConfig.f40745a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f40745a;
        dArr[0] = d6;
        dArr[1] = d7;
    }

    void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f40768a, eScenarioType.toValue());
        }
        if (this.f40786j && this.f40790n) {
            return;
        }
        a(f40768a);
    }

    void a(long j6) {
        Context context = f40768a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j6;
            y.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i6 = 0;
        if (context == null) {
            UMLog.aq(j.af, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f40779z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.f40787k == null) {
                    this.f40787k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i6 < strArr.length) {
                            String str2 = strArr[i6];
                            if (str2 != null && HelperUtils.checkStrLen(str2, 256)) {
                                jSONArray.put(strArr[i6]);
                                i6++;
                            }
                            MLog.e("please check value, length is " + strArr[i6].length() + ", overlength 256!");
                            return;
                        }
                        this.f40787k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i6 < jArr.length) {
                            jSONArray2.put(jArr[i6]);
                            i6++;
                        }
                        this.f40787k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i6 < iArr.length) {
                            jSONArray3.put(iArr[i6]);
                            i6++;
                        }
                        this.f40787k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i6 < fArr.length) {
                            jSONArray4.put(fArr[i6]);
                            i6++;
                        }
                        this.f40787k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i6 < dArr.length) {
                            jSONArray5.put(dArr[i6]);
                            i6++;
                        }
                        this.f40787k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i6 < sArr.length) {
                            jSONArray6.put((int) sArr[i6]);
                            i6++;
                        }
                        this.f40787k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.f40787k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            Context context2 = f40768a;
            UMWorkDispatch.sendEvent(context2, o.a.f41413t, CoreProtocol.getInstance(context2), this.f40787k.toString());
            return;
        }
        UMLog.aq(j.ag, 0, "\\|");
    }

    public synchronized void a(Object obj) {
        Context context;
        try {
            context = f40768a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f40768a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f40769h, this.f40787k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } finally {
        }
        if (context == null) {
            UMLog.aq(j.aj, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        s.a(f40768a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.aq(j.al, 0, "\\|");
            return;
        }
        if (f40768a == null) {
            f40768a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (!UMUtils.isMainProgress(f40768a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f40786j || !this.f40790n) {
            a(f40768a);
        }
        if (this.f40789m == null) {
            this.f40789m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                jSONObject2 = new JSONObject(this.f40789m.toString());
            } catch (Exception unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (c(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.f40789m = jSONObject2;
            if (this.f40789m.length() > 0) {
                Context context2 = f40768a;
                UMWorkDispatch.sendEvent(context2, o.a.f41416w, CoreProtocol.getInstance(context2), this.f40789m.toString());
            }
            return;
        }
        UMLog.aq(j.am, 0, "\\|");
    }

    public void a(String str, Object obj) {
        if (f(str)) {
            if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                MLog.e("userProfile: Invalid value type, please check!");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(d.S, str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() > 0) {
                        str2 = str2.trim();
                    }
                    if (!g(str2)) {
                        return;
                    } else {
                        jSONObject.put("pv", str2);
                    }
                } else {
                    jSONObject.put("pv", obj);
                }
                Context context = f40768a;
                UMWorkDispatch.sendEvent(context, o.a.f41410q, CoreProtocol.getInstance(context), jSONObject);
            } catch (Throwable unused) {
            }
        }
    }
}
