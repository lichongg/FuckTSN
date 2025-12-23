package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
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
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.HelpShopAppUtil;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.qq.e.comm.constants.ErrorCode;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class u3 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5369a = "acse_SamsungUtils";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f5370b;

    /* renamed from: c, reason: collision with root package name */
    public static TimerTask f5371c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5372a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5373b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            boolean canDrawOverlays;
            c2.a("samon-->", "openMiuiFlowWindowPermission倒计时");
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5372a, this.f5373b);
                if (g6 != null) {
                    TimerTask timerTask = u3.f5371c;
                    if (timerTask != null) {
                        timerTask.cancel();
                        u3.f5371c = null;
                    }
                    c2.a(u3.f5369a, "找到了");
                    j3.a().a("battery_white", Boolean.TRUE);
                    if (Build.VERSION.SDK_INT >= 23) {
                        canDrawOverlays = Settings.canDrawOverlays(HelpShopAppUtil.getContext());
                        if (canDrawOverlays) {
                            return;
                        }
                        com.acse.ottn.b.c().g(g6);
                        com.acse.ottn.b.c().a(s0.a().b(200));
                        com.acse.ottn.b.c().e(this.f5372a);
                    }
                }
            } catch (Exception e6) {
                c2.a(u3.f5369a, "e =" + e6.getMessage());
            }
        }

        public a(AccessibilityService accessibilityService, String str) {
            this.f5372a = accessibilityService;
            this.f5373b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            if (u3.f5371c != null) {
                u3.f5371c = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5374a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5375b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            c2.a("samon-->", "clickHouTaiShowPage倒计时 =" + this.f5374a);
            try {
                if (this.f5374a == null) {
                    return;
                }
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5375b, this.f5374a);
                if (g6 == null) {
                    c2.a("samonp-->", "appNodeInfo is null");
                    if (HelpShopAppUtil.getContext() != null && Build.VERSION.SDK_INT >= 24) {
                        com.acse.ottn.b.c().a(this.f5375b, j4.c(HelpShopAppUtil.getContext()) / 3, ((j4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (j4.c(HelpShopAppUtil.getContext()) / 3) + 100, j4.b(HelpShopAppUtil.getContext()) / 3, 500);
                        return;
                    }
                    return;
                }
                c2.a("samonp-->", "appNodeInfo is not null");
                TimerTask timerTask = u3.f5371c;
                if (timerTask != null) {
                    timerTask.cancel();
                    u3.f5371c = null;
                }
                c2.a(u3.f5369a, "找到了");
                com.acse.ottn.b.c().g(g6);
                j3.a().a("battery_white", Boolean.FALSE);
                com.acse.ottn.b.c().a(s0.a().b(500));
                AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f5375b, "始终允许");
                AccessibilityNodeInfo j8 = com.acse.ottn.b.c().j(this.f5375b, "允许");
                if (j7 != null) {
                    c2.a("samonp-->", "appinfo is not null");
                    com.acse.ottn.b.c().g(j7);
                    com.acse.ottn.b.c().a(s0.a().b(200));
                    com.acse.ottn.b.c().e(this.f5375b);
                } else if (j8 != null) {
                    com.acse.ottn.b.c().g(j8);
                    com.acse.ottn.b.c().a(s0.a().b(200));
                    com.acse.ottn.b.c().e(this.f5375b);
                    c2.a("samonp-->", "appinfo1 is not null");
                }
                if (j3.a().a("is_pengpai")) {
                    com.acse.ottn.b.c().e(this.f5375b);
                    com.acse.ottn.b.c().a(s0.a().b(100));
                    com.acse.ottn.b.c().e(this.f5375b);
                }
            } catch (Exception e6) {
                c2.a(u3.f5369a, "e =" + e6.getMessage());
            }
        }

        public b(String str, AccessibilityService accessibilityService) {
            this.f5374a = str;
            this.f5375b = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            u3.f5371c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f5376a;

        public c(AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f5376a = accessibilityNodeInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.acse.ottn.b.c().g(this.f5376a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5377a;

        public d(AccessibilityService accessibilityService) {
            this.f5377a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.acse.ottn.b.c().e(this.f5377a);
        }
    }

    public static int a() {
        String a6 = n3.a("ro.miui.ui.version.name");
        if (a6 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(a6.substring(1));
        } catch (Exception e6) {
            c2.b(f5369a, "get miui version code error, version : " + a6);
            c2.b(f5369a, Log.getStackTraceString(e6));
            return -1;
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
            c2.b(f5369a, "intent is not available!");
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
            c2.b(f5369a, "Intent is not available!");
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
            c2.b(f5369a, "Intent is not available!");
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
            c2.b(f5369a, "Intent is not available!");
            return;
        }
        try {
            activity.startActivityForResult(intent2, i6);
        } catch (Exception unused2) {
            k0.b(true);
        }
    }

    public static boolean a(Context context) {
        return a(context, 24);
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
            c2.b(f5369a, Log.getStackTraceString(e6));
            return false;
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().a(200L);
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "允许显示在其他应用的上层");
        if (g6 == null) {
            AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "显示在其他应用的上层");
            AccessibilityNodeInfo g8 = com.acse.ottn.b.c().g(accessibilityService, "允许此应用显示在您当前使用的其他应用的上层。此应用将能得知您点按的位置或更改屏幕上显示的内容。");
            Rect rect = new Rect();
            g7.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            g8.getBoundsInScreen(rect2);
            int i6 = rect.right / 2;
            int i7 = rect2.top;
            int i8 = rect.bottom;
            int i9 = ((i7 - i8) / 2) + i8;
            if (Build.VERSION.SDK_INT >= 24) {
                com.acse.ottn.b.c().a(accessibilityService, i6, i9);
                c2.a(f5369a, "点击了");
            }
        } else {
            com.acse.ottn.b.c().g(g6);
        }
        com.acse.ottn.b.c().a(300L);
        com.acse.ottn.b.c().e(accessibilityService);
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.c().e(accessibilityService);
        }
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "允许系统唤醒");
        AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "允许被其他应用唤醒");
        int i6 = 0;
        if (g6 != null && g6.getParent() != null) {
            int i7 = 0;
            while (true) {
                if (i7 >= g6.getParent().getChildCount()) {
                    break;
                }
                if (g6.getParent().getChild(i7) == null || !"android.widget.CheckBox".equals(g6.getParent().getChild(i7).getClassName())) {
                    i7++;
                } else if (!g6.getParent().getChild(i7).isChecked()) {
                    com.acse.ottn.b.c().g(g6);
                }
            }
        }
        if (g7 != null && g7.getParent() != null) {
            while (true) {
                if (i6 >= g7.getParent().getChildCount()) {
                    break;
                }
                if (g7.getParent().getChild(i6) == null || !"android.widget.CheckBox".equals(g7.getParent().getChild(i6).getClassName())) {
                    i6++;
                } else if (!g7.getParent().getChild(i6).isChecked()) {
                    com.acse.ottn.b.c().g(g7);
                }
            }
        }
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(s0.a().b(200));
        com.acse.ottn.b.c().e(accessibilityService);
        k0.c(true);
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

    public static void a(Activity activity, int i6) {
        int a6 = a();
        if (a6 == 5) {
            b(activity, i6);
            return;
        }
        if (a6 == 6) {
            c(activity, i6);
            return;
        }
        if (a6 == 7) {
            d(activity, i6);
            return;
        }
        if (a6 == 8) {
            e(activity, i6);
            return;
        }
        c2.b(f5369a, "this is a special MIUI rom version, its version code " + a6);
    }

    public static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        String b6 = j1.c().b();
        c2.a(f5369a, b6);
        com.acse.ottn.b.c().a(s0.a().b(200));
        f5371c = m0.a().b(s0.a().b(KSImageLoader.InnerImageLoadingListener.MAX_DURATION), s0.a().b(600), new a(accessibilityService, b6));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService) {
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

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
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
        TimerTask timerTask = f5371c;
        if (timerTask != null) {
            timerTask.cancel();
            f5371c = null;
        }
        String e6 = j3.a().e("OpenPermissionName");
        c2.a("samonp-->", "找到了悬浮窗=" + e6);
        if (e6.equals("定位")) {
            return;
        }
        f5371c = m0.a().b(s0.a().b(ErrorCode.UNKNOWN_ERROR), s0.a().b(600), new b(e6, accessibilityService));
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

    public static void c(Activity activity) {
        a(activity);
    }

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, str);
        if (g6 == null || g6.getParent() == null) {
            return;
        }
        for (int i6 = 0; i6 < g6.getParent().getChildCount(); i6++) {
            if (g6.getParent().getChild(i6) != null && "android.widget.CheckBox".equals(g6.getParent().getChild(i6).getClassName())) {
                c2.a("samon-->", "android.widget.CheckBox=" + g6.getParent().getChild(i6).toString());
                if (g6.getParent().getChild(i6).isChecked()) {
                    return;
                }
                com.acse.ottn.b.c().g(g6.getParent().getChild(i6));
                com.acse.ottn.b.c().a(s0.a().b(100));
                AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(ShopHelperService.mService, "确定");
                AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(ShopHelperService.mService, "知道了");
                if (j6 != null) {
                    com.acse.ottn.b.c().a(s0.a().b(200));
                    com.acse.ottn.b.c().g(j6);
                    com.acse.ottn.b.c().a(s0.a().b(500));
                    com.acse.ottn.b.c().e(accessibilityService);
                } else if (j7 != null) {
                    new Handler(Looper.getMainLooper()).postDelayed(new c(j7), 100L);
                    new Handler(Looper.getMainLooper()).postDelayed(new d(accessibilityService), 500L);
                }
                k0.c(true);
                return;
            }
        }
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
}
