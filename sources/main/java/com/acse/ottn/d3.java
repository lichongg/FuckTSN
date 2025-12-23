package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.tencent.connect.common.Constants;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d3 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4428a = "OppoUtils";

    /* renamed from: c, reason: collision with root package name */
    public static TimerTask f4430c;

    /* renamed from: b, reason: collision with root package name */
    public static Long f4429b = 0L;

    /* renamed from: d, reason: collision with root package name */
    public static AccessibilityNodeInfo f4431d = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4432a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4433b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4432a, this.f4433b);
                if (g6 == null) {
                    d3.g(this.f4432a);
                    if (d3.f4431d != null) {
                        com.acse.ottn.b.c().b(d3.f4431d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = d3.f4430c;
                if (timerTask != null) {
                    timerTask.cancel();
                    d3.f4430c = null;
                }
                c2.a(d3.f4428a, "找到了");
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().e(this.f4432a);
            } catch (Throwable th) {
                c2.a(d3.f4428a, "e =" + th.getMessage());
            }
        }

        public a(AccessibilityService accessibilityService, String str) {
            this.f4432a = accessibilityService;
            this.f4433b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            d3.f4430c = null;
            c2.a(d3.f4428a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4434a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4435b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            c2.a("samon-->", "openAndroidElevenOppoFlowWindowPermission  倒计时");
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4434a, this.f4435b);
                if (g6 == null) {
                    d3.g(this.f4434a);
                    if (d3.f4431d != null) {
                        com.acse.ottn.b.c().b(d3.f4431d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = d3.f4430c;
                if (timerTask != null) {
                    timerTask.cancel();
                    d3.f4430c = null;
                }
                c2.a(d3.f4428a, "找到了");
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().e(this.f4434a);
            } catch (Throwable th) {
                c2.a(d3.f4428a, "e =" + th.getMessage());
            }
        }

        public b(AccessibilityService accessibilityService, String str) {
            this.f4434a = accessibilityService;
            this.f4435b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            d3.f4430c = null;
            c2.a(d3.f4428a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4436a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4437b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            c2.a("samon-->", "openAndroid12OppoFlowWindowPermission  倒计时");
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4436a, this.f4437b);
                if (g6 == null) {
                    d3.g(this.f4436a);
                    if (d3.f4431d != null) {
                        com.acse.ottn.b.c().b(d3.f4431d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = d3.f4430c;
                if (timerTask != null) {
                    timerTask.cancel();
                    d3.f4430c = null;
                    c2.a(d3.f4428a, "取消倒计时");
                }
                c2.a(d3.f4428a, "找到了");
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().a(s0.a().b(500));
                c2.a(d3.f4428a, "点击1=" + System.currentTimeMillis());
                AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(this.f4436a, "允许");
                if (g7 != null) {
                    c2.a(d3.f4428a, "点击2=" + System.currentTimeMillis());
                    com.acse.ottn.b.c().g(g7);
                    com.acse.ottn.b.c().e(this.f4436a);
                    com.acse.ottn.b.c().e(this.f4436a);
                }
            } catch (Throwable th) {
                c2.a(d3.f4428a, "e =" + th.getMessage());
            }
        }

        public c(AccessibilityService accessibilityService, String str) {
            this.f4436a = accessibilityService;
            this.f4437b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            d3.f4430c = null;
            c2.a(d3.f4428a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4438a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            c2.a(d3.f4428a, "openOppenBatteryButton  倒计时");
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f4438a, "允许应用后台行为");
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4438a, "允许应用自启动");
            AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(this.f4438a, "允许完全后台行为");
            AccessibilityNodeInfo g8 = com.acse.ottn.b.c().g(this.f4438a, "允许后台运行");
            AccessibilityNodeInfo g9 = com.acse.ottn.b.c().g(this.f4438a, "完全允许后台行为");
            if (j7 != null) {
                com.acse.ottn.b.c().g(j7);
                com.acse.ottn.b.c().a(100L);
                d3.c(this.f4438a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f4438a);
                c2.a(d3.f4428a, "openOppenBatteryButton  1111");
                return;
            }
            int i6 = 0;
            if (g6 != null && g6.getParent() != null) {
                c2.a(d3.f4428a, "openOppenBatteryButton  6666");
                c2.a(d3.f4428a, "infochild is not null");
                com.acse.ottn.b.c().a(200L);
                for (int i7 = 0; i7 < g6.getParent().getChildCount(); i7++) {
                    if (g6.getParent().getChild(i7) != null && "android.widget.Switch".equals(g6.getParent().getChild(i7).getClassName())) {
                        c2.a(d3.f4428a, "infochild android.widget.Switch");
                        if (!g6.getParent().getChild(i7).isChecked()) {
                            c2.a(d3.f4428a, "点击infochild");
                            com.acse.ottn.b.c().g(g6);
                        }
                    }
                }
            }
            if (g7 != null && g7.getParent() != null) {
                c2.a(d3.f4428a, "openOppenBatteryButton  2222");
                c2.a(d3.f4428a, "nodeInfochild is not null");
                com.acse.ottn.b.c().a(100L);
                while (i6 < g7.getParent().getChildCount()) {
                    if (g7.getParent().getChild(i6) != null && "android.widget.Switch".equals(g7.getParent().getChild(i6).getClassName())) {
                        c2.a(d3.f4428a, "nodeInfochild android.widget.Switch");
                        if (!g7.getParent().getChild(i6).isChecked()) {
                            c2.a(d3.f4428a, "点击nodeInfochild = ");
                            com.acse.ottn.b.c().g(g7);
                        }
                    }
                    i6++;
                }
                TimerTask timerTask = d3.f4430c;
                if (timerTask != null) {
                    timerTask.cancel();
                    d3.f4430c = null;
                }
                d3.c(this.f4438a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f4438a);
                return;
            }
            if (g8 == null || g8.getParent() == null) {
                if (g9 != null) {
                    com.acse.ottn.b.c().g(g9);
                    d3.c(this.f4438a);
                    com.acse.ottn.b.c().a(300L);
                    com.acse.ottn.b.c().e(this.f4438a);
                    return;
                }
                return;
            }
            c2.a(d3.f4428a, "openOppenBatteryButton  3333");
            TimerTask timerTask2 = d3.f4430c;
            if (timerTask2 != null) {
                timerTask2.cancel();
                d3.f4430c = null;
            }
            c2.a(d3.f4428a, "nodeInfochild1 is not null");
            com.acse.ottn.b.c().a(100L);
            boolean z5 = false;
            while (i6 < g8.getParent().getChildCount()) {
                if (g8.getParent().getChild(i6) != null && "android.widget.Switch".equals(g8.getParent().getChild(i6).getClassName())) {
                    c2.a(d3.f4428a, "nodeInfochild1 android.widget.Switch");
                    if (!g8.getParent().getChild(i6).isChecked()) {
                        c2.a(d3.f4428a, "点击nodeInfochild1");
                        com.acse.ottn.b.c().g(g8);
                    }
                    z5 = true;
                }
                i6++;
            }
            c2.a(d3.f4428a, "openOppenBatteryButton  4444");
            if (!z5) {
                com.acse.ottn.b.c().g(g8);
            }
            d3.c(this.f4438a);
        }

        public d(AccessibilityService accessibilityService) {
            this.f4438a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(d3.f4428a, "openOppenBatteryButton  5555");
            TimerTask timerTask = d3.f4430c;
            if (timerTask != null) {
                timerTask.cancel();
                d3.f4430c = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4439a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.acse.ottn.b.c().e(e.this.f4439a);
            }
        }

        @Override // com.acse.ottn.m0.d
        @RequiresApi(api = 16)
        public void a(long j6) {
            c2.a("samon-->", "backClick  倒计时");
            AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a(this.f4439a, "允许", true);
            AccessibilityNodeInfo a7 = com.acse.ottn.b.c().a(this.f4439a, "通知管理", true);
            if (a6 == null || a7 != null) {
                return;
            }
            TimerTask timerTask = d3.f4430c;
            if (timerTask != null) {
                timerTask.cancel();
                d3.f4430c = null;
            }
            com.acse.ottn.b.c().g(a6);
            k0.b(true);
            com.acse.ottn.b.c().e(this.f4439a);
        }

        public e(AccessibilityService accessibilityService) {
            this.f4439a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            TimerTask timerTask = d3.f4430c;
            if (timerTask != null) {
                timerTask.cancel();
                d3.f4430c = null;
            }
            c2.a("samon-->", "backClick  onFinish");
            k0.b(true);
            com.acse.ottn.b.c().e(this.f4439a);
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 200L);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4441a;

        @Override // com.acse.ottn.m0.d
        public void a() {
        }

        public f(AccessibilityService accessibilityService) {
            this.f4441a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        @RequiresApi(api = 16)
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4441a, "应用");
                if (g6 == null) {
                    d3.g(this.f4441a);
                    if (d3.f4431d != null) {
                        com.acse.ottn.b.c().b(d3.f4431d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = d3.f4430c;
                if (timerTask != null) {
                    timerTask.cancel();
                    d3.f4430c = null;
                }
                c2.a(d3.f4428a, "找到了");
                j3.a().a("battery_white", Boolean.TRUE);
                com.acse.ottn.b.c().g(g6);
            } catch (Throwable th) {
                c2.a(d3.f4428a, "e =" + th.getMessage());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4442a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4443b;

        @Override // com.acse.ottn.m0.d
        public void a() {
        }

        public g(AccessibilityService accessibilityService, String str) {
            this.f4442a = accessibilityService;
            this.f4443b = str;
        }

        @Override // com.acse.ottn.m0.d
        @RequiresApi(api = 16)
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4442a, this.f4443b);
                if (g6 == null) {
                    d3.g(this.f4442a);
                    if (d3.f4431d != null) {
                        com.acse.ottn.b.c().b(d3.f4431d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = d3.f4430c;
                if (timerTask != null) {
                    timerTask.cancel();
                    d3.f4430c = null;
                }
                c2.a(d3.f4428a, "找到了");
                com.acse.ottn.b.c().g(g6);
                j3.a().a("oppo_35_autostart", Boolean.TRUE);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f4442a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f4442a);
                com.acse.ottn.b.c().a(100L);
                com.acse.ottn.b.c().e(this.f4442a);
            } catch (Throwable th) {
                c2.a(d3.f4428a, "e =" + th.getMessage());
            }
        }
    }

    public static boolean a(Context context) {
        return a(context, 24);
    }

    public static void c(AccessibilityService accessibilityService) {
        f4430c = m0.a().b(s0.a().b(400), s0.a().b(200), new e(accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "耗电管理");
        AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "耗电保护");
        if (g6 == null && g7 == null) {
            a3.a(accessibilityService);
            return;
        }
        if (g6 != null) {
            c2.a(f4428a, "nodeInfo is null");
            com.acse.ottn.b.c().g(g6);
        } else {
            com.acse.ottn.b.c().g(g7);
        }
        j3.a().a("battery_white", Boolean.TRUE);
        com.acse.ottn.b.c().a(500L);
        a(accessibilityService, System.currentTimeMillis());
        j3.a().a("battery_white");
    }

    public static void e(AccessibilityService accessibilityService) {
        if (com.acse.ottn.b.c().h(accessibilityService, j1.c().b()) != null) {
            AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "始终允许打开");
            if (j6 != null) {
                com.acse.ottn.b.c().g(j6);
                return;
            }
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(accessibilityService, "打开");
            if (j7 != null) {
                com.acse.ottn.b.c().g(j7);
            }
        }
    }

    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "自启动");
        if (g6 != null) {
            com.acse.ottn.b.c().g(g6);
            com.acse.ottn.b.c().a(300L);
            f4430c = m0.a().b(s0.a().b(10000), s0.a().b(400), new g(accessibilityService, j1.c().b()));
        }
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    public static void h(AccessibilityService accessibilityService) {
        f4430c = m0.a().b(s0.a().b(20000), s0.a().b(100), new c(accessibilityService, j1.c().b()));
    }

    public static void i(AccessibilityService accessibilityService) {
        f4430c = m0.a().b(s0.a().b(20000), s0.a().b(100), new b(accessibilityService, j1.c().b()));
    }

    @RequiresApi(api = 16)
    public static void j(AccessibilityService accessibilityService) {
        f4430c = m0.a().b(s0.a().b(20000), s0.a().b(100), new a(accessibilityService, j1.c().b()));
    }

    public static void k(AccessibilityService accessibilityService) {
        f4430c = m0.a().b(s0.a().b(3000), s0.a().b(500), new f(accessibilityService));
    }

    @TargetApi(19)
    public static boolean a(Context context, int i6) {
        if ("".equals(k0.f4687w)) {
            return false;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i6), Integer.valueOf(Binder.getCallingUid()), k0.f4687w)).intValue() == 0;
        } catch (Throwable th) {
            c2.b(f4428a, Log.getStackTraceString(th));
            return false;
        }
    }

    public static void a(Activity activity, int i6) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i6);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(AccessibilityService accessibilityService, long j6) {
        j3.a().a("battery_white", Boolean.FALSE);
        if (j6 - f4429b.longValue() < 1000) {
            c2.a(f4428a, "间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            c2.a(f4428a, "间隔 time=" + f4429b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f4429b.longValue()));
            return;
        }
        c2.a(f4428a, "无间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        c2.a(f4428a, "无间隔 time=" + f4429b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f4429b.longValue()));
        f4429b = Long.valueOf(j6);
        f4430c = m0.a().b(s0.a().b(1500), s0.a().b(500), new d(accessibilityService));
    }

    public static void a(Activity activity) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        j3.a().a("open_battery_white", Boolean.TRUE);
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, k0.f4687w);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, k0.f4687w, null));
                activity.startActivity(intent2);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra(Constants.PARAM_PKG_NAME, k0.f4687w);
            intent.putExtra("app_name", j1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivity(intent);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                if (accessibilityNodeInfo.getChild(i6) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i6).getClassName())) {
                    f4431d = accessibilityNodeInfo.getChild(i6);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        a(accessibilityNodeInfo.getChild(i6));
                    }
                }
            }
        }
    }

    public static void a(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, str);
        if (g6 != null) {
            com.acse.ottn.b.c().g(g6);
        }
    }
}
