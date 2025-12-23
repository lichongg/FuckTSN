package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a3 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4055a = "OnePlusUtils";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4056b;

    /* renamed from: c, reason: collision with root package name */
    public static TimerTask f4057c;

    /* renamed from: d, reason: collision with root package name */
    public static AccessibilityNodeInfo f4058d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4059a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4060b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4059a, this.f4060b);
                if (g6 == null) {
                    if (Build.VERSION.SDK_INT >= 24 && HelpShopAppUtil.getContext() != null) {
                        com.acse.ottn.b.c().a(this.f4059a, j4.c(HelpShopAppUtil.getContext()) / 3, ((j4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (j4.c(HelpShopAppUtil.getContext()) / 3) + 100, j4.b(HelpShopAppUtil.getContext()) / 3, 200);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = a3.f4057c;
                if (timerTask != null) {
                    timerTask.cancel();
                    a3.f4057c = null;
                }
                c2.a(a3.f4055a, "找到了");
                if (j3.a() != null) {
                    j3.a().a("battery_white", Boolean.TRUE);
                }
                com.acse.ottn.b.c().g(g6);
            } catch (Exception e6) {
                c2.a(a3.f4055a, "e =" + e6.getMessage());
            }
        }

        public a(AccessibilityService accessibilityService, String str) {
            this.f4059a = accessibilityService;
            this.f4060b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            a3.f4057c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4061a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4062b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4061a, "后台弹出界面");
                AccessibilityNodeInfo accessibilityNodeInfo = null;
                if (g6 == null) {
                    AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(this.f4061a, this.f4062b);
                    if (g7 == null || g7.getParent() == null || g7.getParent().getParent() == null || g7.getParent().getParent().getParent() == null) {
                        return;
                    }
                    for (int i6 = 0; i6 < g7.getParent().getParent().getParent().getChildCount(); i6++) {
                        if (g7.getParent().getParent().getParent().getChild(i6) != null && "androidx.recyclerview.widget.RecyclerView".equals(g7.getParent().getParent().getParent().getChild(i6).getClassName())) {
                            accessibilityNodeInfo = g7.getParent().getParent().getParent().getChild(i6);
                        }
                    }
                    com.acse.ottn.b.c().b(accessibilityNodeInfo);
                    return;
                }
                TimerTask timerTask = a3.f4057c;
                if (timerTask != null) {
                    timerTask.cancel();
                    a3.f4057c = null;
                }
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().a(s0.a().b(500));
                AccessibilityNodeInfo g8 = com.acse.ottn.b.c().g(this.f4061a, "始终允许");
                AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a(this.f4061a, "允许", true);
                if (g8 != null) {
                    com.acse.ottn.b.c().g(g8);
                    com.acse.ottn.b.c().a(s0.a().b(100));
                    com.acse.ottn.b.c().e(this.f4061a);
                } else if (a6 != null) {
                    com.acse.ottn.b.c().g(a6);
                    com.acse.ottn.b.c().a(s0.a().b(100));
                    com.acse.ottn.b.c().e(this.f4061a);
                }
            } catch (Exception e6) {
                c2.a(a3.f4055a, "e =" + e6.getMessage());
            }
        }

        public b(AccessibilityService accessibilityService, String str) {
            this.f4061a = accessibilityService;
            this.f4062b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            a3.f4057c = null;
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
            c2.b(f4055a, "get miui version code error, version : " + a6);
            c2.b(f4055a, Log.getStackTraceString(e6));
            return -1;
        }
    }

    public static void b(Activity activity, int i6) {
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
            c2.b(f4055a, "Intent is not available!");
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
            c2.b(f4055a, "Intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService) {
        c2.a("samon-->", "getdataPacket");
        a(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void d(AccessibilityService accessibilityService) {
        b(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void f(AccessibilityService accessibilityService) {
        String b6 = j1.c().b();
        c2.a(f4055a, b6);
        f4057c = m0.a().b(s0.a().b(20000), s0.a().b(500), new a(accessibilityService, b6));
    }

    public static boolean a(Context context) {
        return a(context, 24);
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
            c2.b(f4055a, Log.getStackTraceString(e6));
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                if (accessibilityNodeInfo.getChild(i6) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i6).getClassName())) {
                    f4058d = accessibilityNodeInfo.getChild(i6);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        b(accessibilityNodeInfo.getChild(i6));
                    }
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "允许显示在其他应用的上层");
        AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "授予悬浮窗权限");
        if (g6 != null) {
            com.acse.ottn.b.c().g(g6);
            com.acse.ottn.b.c().e(accessibilityService);
        } else if (g7 != null) {
            com.acse.ottn.b.c().g(g7);
            com.acse.ottn.b.c().e(accessibilityService);
        } else {
            AccessibilityNodeInfo g8 = com.acse.ottn.b.c().g(accessibilityService, "此权限允许应用在其他应用上层显示，可能会影响其他应用的显示");
            AccessibilityNodeInfo g9 = com.acse.ottn.b.c().g(accessibilityService, j1.c().b());
            if (g8 == null || g9 == null) {
                return;
            }
            Rect rect = new Rect();
            g8.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            g9.getBoundsInScreen(rect2);
            int i6 = rect.right / 2;
            int i7 = rect2.top;
            int i8 = rect.bottom;
            int i9 = ((i7 - i8) / 2) + i8;
            c2.a("samonp-->", "x= " + i6 + "   y = " + i9);
            if (Build.VERSION.SDK_INT >= 24) {
                com.acse.ottn.b.c().a(accessibilityService, i6, i9);
                c2.a(f4055a, "点击了");
                com.acse.ottn.b.c().a(500L);
                com.acse.ottn.b.c().e(accessibilityService);
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            com.acse.ottn.b.c().a(200L);
            com.acse.ottn.b.c().e(accessibilityService);
        }
    }

    public static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    public static void a(Activity activity, int i6) {
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
            c2.b(f4055a, "intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        f4057c = m0.a().b(s0.a().b(10000), s0.a().b(100), new b(accessibilityService, j1.c().b()));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "高级");
        if (g6 == null) {
            return;
        }
        com.acse.ottn.b.c().g(g6);
        com.acse.ottn.b.c().a(s0.a().b(200));
        AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "电池");
        if (g7 == null) {
            return;
        }
        k0.b(true);
        com.acse.ottn.b.c().g(g7);
        com.acse.ottn.b.c().a(s0.a().b(500));
        AccessibilityNodeInfo g8 = com.acse.ottn.b.c().g(accessibilityService, "不优化");
        if (g8 == null) {
            return;
        }
        com.acse.ottn.b.c().g(g8);
        com.acse.ottn.b.c().e(accessibilityService);
        com.acse.ottn.b.c().a(s0.a().b(100));
        com.acse.ottn.b.c().e(accessibilityService);
    }

    @RequiresApi(api = 16)
    public static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, str);
        if (g6 != null) {
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
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            c2.a("samon-->", accessibilityNodeInfo.toString());
            if ("android.widget.LinearLayout".equals(accessibilityNodeInfo.getClassName())) {
                com.acse.ottn.b.c().g(accessibilityNodeInfo);
                return;
            }
            return;
        }
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                a(accessibilityNodeInfo.getChild(i6));
            }
        }
    }
}
