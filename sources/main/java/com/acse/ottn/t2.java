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
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.acse.ottn.service.ShopHelperService;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.tencent.connect.common.Constants;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class t2 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5313a = "NubiaUtils";

    /* renamed from: b, reason: collision with root package name */
    public static TimerTask f5314b;

    /* renamed from: c, reason: collision with root package name */
    public static AccessibilityNodeInfo f5315c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f5316a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5317b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5316a, this.f5317b);
                if (g6 == null) {
                    t2.f(this.f5316a);
                    if (t2.f5315c == null) {
                        return;
                    }
                    com.acse.ottn.b.c().b(t2.f5315c);
                    return;
                }
                TimerTask timerTask = t2.f5314b;
                if (timerTask != null) {
                    timerTask.cancel();
                    t2.f5314b = null;
                }
                c2.a(t2.f5313a, "找到了");
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().e(this.f5316a);
            } catch (Exception e6) {
                c2.a(t2.f5313a, "e =" + e6.getMessage());
            }
        }

        public a(ShopHelperService shopHelperService, String str) {
            this.f5316a = shopHelperService;
            this.f5317b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            t2.f5314b = null;
            c2.a(t2.f5313a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f5318a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5319b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5318a, this.f5319b);
                if (g6 == null) {
                    t2.f(this.f5318a);
                    if (t2.f5315c == null) {
                        return;
                    }
                    com.acse.ottn.b.c().b(t2.f5315c);
                    return;
                }
                TimerTask timerTask = t2.f5314b;
                if (timerTask != null) {
                    timerTask.cancel();
                    t2.f5314b = null;
                }
                c2.a(t2.f5313a, "找到了");
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().e(this.f5318a);
            } catch (Exception e6) {
                c2.a(t2.f5313a, "e =" + e6.getMessage());
            }
        }

        public b(ShopHelperService shopHelperService, String str) {
            this.f5318a = shopHelperService;
            this.f5319b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            t2.f5314b = null;
            c2.a(t2.f5313a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f5320a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5320a, "允许完全后台行为");
            AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(this.f5320a, "允许后台运行");
            AccessibilityNodeInfo g8 = com.acse.ottn.b.c().g(this.f5320a, "允许应用自启动");
            if (g8 != null && g8.getParent() != null) {
                TimerTask timerTask = t2.f5314b;
                if (timerTask != null) {
                    timerTask.cancel();
                    t2.f5314b = null;
                }
                for (int i6 = 0; i6 < g8.getParent().getChildCount(); i6++) {
                    if (g8.getParent().getChild(i6) != null && "android.widget.Switch".equals(g8.getParent().getChild(i6).getClassName()) && !g8.getParent().getChild(i6).isChecked()) {
                        com.acse.ottn.b.c().g(g8);
                    }
                }
            }
            if (g6 == null || g6.getParent() == null) {
                if (g7 != null) {
                    TimerTask timerTask2 = t2.f5314b;
                    if (timerTask2 != null) {
                        timerTask2.cancel();
                        t2.f5314b = null;
                    }
                    com.acse.ottn.b.c().g(g7);
                    t2.c(this.f5320a);
                    return;
                }
                return;
            }
            TimerTask timerTask3 = t2.f5314b;
            if (timerTask3 != null) {
                timerTask3.cancel();
                t2.f5314b = null;
            }
            for (int i7 = 0; i7 < g6.getParent().getChildCount(); i7++) {
                if ("android.widget.Switch".equals(g6.getParent().getChild(i7).getClassName()) && !g6.getParent().getChild(i7).isChecked()) {
                    com.acse.ottn.b.c().g(g6);
                }
            }
            t2.c(this.f5320a);
        }

        public c(ShopHelperService shopHelperService) {
            this.f5320a = shopHelperService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            TimerTask timerTask = t2.f5314b;
            if (timerTask != null) {
                timerTask.cancel();
                t2.f5314b = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopHelperService f5321a;

        @Override // com.acse.ottn.m0.d
        @RequiresApi(api = 16)
        public void a(long j6) {
            AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a((AccessibilityService) this.f5321a, "允许", true);
            if (a6 != null) {
                TimerTask timerTask = t2.f5314b;
                if (timerTask != null) {
                    timerTask.cancel();
                    t2.f5314b = null;
                }
                com.acse.ottn.b.c().g(a6);
                k0.b(true);
                com.acse.ottn.b.c().e(this.f5321a);
                com.acse.ottn.b.c().e(this.f5321a);
            }
        }

        public d(ShopHelperService shopHelperService) {
            this.f5321a = shopHelperService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            TimerTask timerTask = t2.f5314b;
            if (timerTask != null) {
                timerTask.cancel();
                t2.f5314b = null;
            }
            k0.b(true);
            com.acse.ottn.b.c().e(this.f5321a);
            com.acse.ottn.b.c().e(this.f5321a);
        }
    }

    public static boolean a(Context context) {
        return a(context, 24);
    }

    public static void c(ShopHelperService shopHelperService) {
        f5314b = m0.a().b(1000, 100, new d(shopHelperService));
    }

    @RequiresApi(api = 16)
    public static void d(ShopHelperService shopHelperService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(shopHelperService, "耗电管理");
        AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(shopHelperService, "耗电保护");
        if (g6 == null && g7 == null) {
            return;
        }
        if (j3.a() != null) {
            j3.a().a("battery_white", Boolean.TRUE);
        }
        if (g6 != null) {
            com.acse.ottn.b.c().g(g6);
        } else {
            com.acse.ottn.b.c().g(g7);
        }
        f5314b = m0.a().b(1500, 200, new c(shopHelperService));
    }

    @RequiresApi(api = 16)
    public static void e(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.c().a()) {
            c2.a(f5313a, "悬浮窗权限已开启");
            return;
        }
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(shopHelperService, "允许显示在其他应用的上层");
        if (g6 != null) {
            com.acse.ottn.b.c().g(g6);
            com.acse.ottn.b.c().e(shopHelperService);
            if (Build.VERSION.SDK_INT >= 30) {
                com.acse.ottn.b.c().e(shopHelperService);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(ShopHelperService shopHelperService) {
        a(shopHelperService.getRootInActiveWindow());
    }

    public static void g(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.c().a()) {
            c2.a(f5313a, "悬浮窗权限已开启");
        } else {
            f5314b = m0.a().b(20000, 100, new b(shopHelperService, j1.c().b()));
        }
    }

    @RequiresApi(api = 16)
    public static void h(ShopHelperService shopHelperService) {
        if (com.acse.ottn.b.c().a()) {
            c2.a(f5313a, "悬浮窗权限已开启");
        } else {
            f5314b = m0.a().b(20000, 100, new a(shopHelperService, j1.c().b()));
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i6) {
        if ("".equals(k0.f4687w)) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            Class cls = Integer.TYPE;
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i6), Integer.valueOf(Binder.getCallingUid()), k0.f4687w)).intValue() == 0;
        } catch (Exception e6) {
            c2.b(f5313a, Log.getStackTraceString(e6));
            return false;
        }
    }

    public static void a(Activity activity, int i6) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public static void a(Activity activity) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, k0.f4687w);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10013);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, k0.f4687w, null));
                activity.startActivityForResult(intent2, 10013);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra(Constants.PARAM_PKG_NAME, k0.f4687w);
            intent.putExtra("app_name", j1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivityForResult(intent, 10013);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                if ("android.support.v7.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i6).getClassName())) {
                    f5315c = accessibilityNodeInfo.getChild(i6);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        a(accessibilityNodeInfo.getChild(i6));
                    }
                }
            }
        }
    }
}
