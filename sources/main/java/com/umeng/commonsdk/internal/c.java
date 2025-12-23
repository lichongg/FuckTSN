package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements UMLogDataProtocol {

    /* renamed from: b, reason: collision with root package name */
    public static final String f41777b = "preInitInvokedFlag";

    /* renamed from: c, reason: collision with root package name */
    public static final String f41778c = "policyGrantInvokedFlag";

    /* renamed from: d, reason: collision with root package name */
    public static final String f41779d = "policyGrantResult";

    /* renamed from: f, reason: collision with root package name */
    private static int f41780f = 1;

    /* renamed from: e, reason: collision with root package name */
    private Context f41788e;

    /* renamed from: a, reason: collision with root package name */
    public static final String f41776a = au.b().b(au.f40912q);

    /* renamed from: g, reason: collision with root package name */
    private static Class<?> f41781g = null;

    /* renamed from: h, reason: collision with root package name */
    private static Method f41782h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Method f41783i = null;

    /* renamed from: j, reason: collision with root package name */
    private static Method f41784j = null;

    /* renamed from: k, reason: collision with root package name */
    private static volatile String f41785k = "";

    /* renamed from: l, reason: collision with root package name */
    private static volatile String f41786l = "";

    /* renamed from: m, reason: collision with root package name */
    private static boolean f41787m = false;

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(f41786l)) {
            return f41786l;
        }
        Class<?> cls = f41781g;
        if (cls == null || (method = f41782h) == null || f41784j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, null);
            if (invoke == null) {
                return "";
            }
            String str = (String) f41784j.invoke(invoke, null);
            try {
                f41786l = str;
                return str;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static void c() {
        try {
            f41781g = ZIDManager.class;
            Method declaredMethod = ZIDManager.class.getDeclaredMethod("getInstance", null);
            if (declaredMethod != null) {
                f41782h = declaredMethod;
            }
            Method declaredMethod2 = f41781g.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                f41783i = declaredMethod2;
            }
            Method declaredMethod3 = f41781g.getDeclaredMethod("getSDKVersion", null);
            if (declaredMethod3 != null) {
                f41784j = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bk a6 = bk.a(this.f41788e);
        bl a7 = a6.a(bm.f41038c);
        if (a7 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a7.f41030a;
                String str2 = a7.f41031b;
                JSONObject a8 = new com.umeng.commonsdk.statistics.b().a(StubApp.getOrigApplicationContext(this.f41788e.getApplicationContext()), new JSONObject(a7.f41032c), new JSONObject(a7.f41033d), a7.f41034e, str2, a7.f41035f);
                if (a8 == null || !a8.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a6.a(bm.f41038c, str);
                a6.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (f41787m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            f41787m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f41787m = true;
            a(this.f41788e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.f41788e.getSharedPreferences(h.f41959a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(h.f41960b, str);
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(c.this.f41788e, a.f41769w, b.a(c.this.f41788e).a(), null);
                }
            });
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f41787m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f41788e);
            f41780f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f41788e != null) {
                        UMWorkDispatch.sendEvent(c.this.f41788e, a.f41770x, b.a(c.this.f41788e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.f41788e, true);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j6) {
        return null;
    }

    private void g() {
        if (f41780f <= 0) {
            h();
            e(this.f41788e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f41788e)) {
            f(this.f41788e);
            UMInnerManager.sendInnerPackage(this.f41788e);
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.ar) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f41788e)) {
                Context context = this.f41788e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), null, 5000L);
            }
            Context context2 = this.f41788e;
            UMWorkDispatch.sendEvent(context2, o.a.f41419z, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f41788e;
            UMWorkDispatch.sendEvent(context3, a.f41766t, b.a(context3).a(), null);
        }
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(f41785k)) {
            return f41785k;
        }
        Class<?> cls = f41781g;
        if (cls == null || (method = f41782h) == null || f41783i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, null);
            if (invoke == null) {
                return "";
            }
            String str = (String) f41783i.invoke(invoke, this.f41788e);
            try {
                f41785k = str;
                return str;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02bf A[Catch: all -> 0x0428, TryCatch #0 {all -> 0x0428, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0112, B:53:0x0143, B:60:0x015b, B:62:0x017b, B:64:0x0181, B:65:0x0191, B:67:0x01bc, B:73:0x01c6, B:75:0x01ca, B:77:0x01e2, B:102:0x027b, B:104:0x0292, B:106:0x029d, B:109:0x02a4, B:111:0x02aa, B:113:0x02b5, B:117:0x02bf, B:119:0x02c5, B:121:0x02d0, B:123:0x02d6), top: B:19:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d6 A[Catch: all -> 0x0428, TRY_LEAVE, TryCatch #0 {all -> 0x0428, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0112, B:53:0x0143, B:60:0x015b, B:62:0x017b, B:64:0x0181, B:65:0x0191, B:67:0x01bc, B:73:0x01c6, B:75:0x01ca, B:77:0x01e2, B:102:0x027b, B:104:0x0292, B:106:0x029d, B:109:0x02a4, B:111:0x02aa, B:113:0x02b5, B:117:0x02bf, B:119:0x02c5, B:121:0x02d0, B:123:0x02d6), top: B:19:0x007b }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void workEvent(java.lang.Object r13, int r14) {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f41788e = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "umid", "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("umid"), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader == null || !buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("os"), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader == null || !buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a6 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a6.getDeclaredMethod("getInstance", null);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a6, null)) == null || (declaredMethod = a6.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, origApplicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void c(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.f41959a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(h.f41960b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f41960b, str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static void f(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bm.f41047l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static void a(final Context context, final boolean z5) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.f41959a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a6 = aw.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a6) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f41961c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(h.f41960b, a6);
                        edit2.commit();
                    }
                    if (z5) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L4
            goto L90
        L4:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = com.umeng.common.b.a(r11, r0, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L90
            java.lang.String r3 = "startTime"
            java.lang.String r3 = com.umeng.common.b.a(r11, r0, r3)
            java.lang.String r4 = "period"
            java.lang.String r0 = com.umeng.common.b.a(r11, r0, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L30
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L2f
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L2f
            goto L31
        L2f:
        L30:
            r3 = r5
        L31:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L41
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L40
            long r7 = r0.longValue()     // Catch: java.lang.Throwable -> L40
            goto L42
        L40:
        L41:
            r7 = r5
        L42:
            java.lang.String r0 = "MobclickRT"
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L86
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L4d
            goto L86
        L4d:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r3
            r3 = 60000(0xea60, double:2.9644E-319)
            long r7 = r7 * r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L6f
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
            boolean r11 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r11 == 0) goto L90
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L90
        L6f:
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r11.put(r1, r2)
            boolean r1 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r1 != 0) goto L90
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L90
        L86:
            java.lang.String r1 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a6 = aw.a(origApplicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a6);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }
}
