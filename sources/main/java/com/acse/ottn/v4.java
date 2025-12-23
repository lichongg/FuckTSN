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
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class v4 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5389a = "acse_VivoUtils";

    /* renamed from: c, reason: collision with root package name */
    public static TimerTask f5391c;

    /* renamed from: b, reason: collision with root package name */
    public static Long f5390b = 0L;

    /* renamed from: d, reason: collision with root package name */
    public static AccessibilityNodeInfo f5392d = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5393a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5394b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            v4.f(this.f5393a);
            try {
                if (com.acse.ottn.b.c().g(this.f5393a, this.f5394b) == null) {
                    if (v4.f5392d != null) {
                        com.acse.ottn.b.c().b(v4.f5392d);
                    }
                } else {
                    TimerTask timerTask = v4.f5391c;
                    if (timerTask != null) {
                        timerTask.cancel();
                        v4.f5391c = null;
                    }
                }
            } catch (Exception e6) {
                c2.a(v4.f5389a, "e =" + e6.getMessage());
            }
        }

        public a(AccessibilityService accessibilityService, String str) {
            this.f5393a = accessibilityService;
            this.f5394b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            v4.f5391c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5395a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5396b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f5397c;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            v4.f(this.f5395a);
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5395a, this.f5396b);
                if (g6 == null) {
                    if (v4.f5392d != null) {
                        com.acse.ottn.b.c().b(v4.f5392d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = v4.f5391c;
                if (timerTask != null) {
                    timerTask.cancel();
                    v4.f5391c = null;
                }
                c2.a(v4.f5389a, "找到了 =" + this.f5396b);
                if (g6.getParent() != null) {
                    com.acse.ottn.b.c().a(s0.a().b(2000));
                    v4.d(this.f5395a, com.acse.ottn.b.c().g(this.f5395a, this.f5396b).getParent().getParent(), false);
                    if (this.f5397c) {
                        c2.a(v4.f5389a, "电池");
                        k0.b(true);
                    }
                    com.acse.ottn.b.c().a(s0.a().b(500));
                    com.acse.ottn.b.c().e(this.f5395a);
                }
            } catch (Exception e6) {
                c2.a(v4.f5389a, "clickSoftList e =" + e6.getMessage());
            }
        }

        public b(AccessibilityService accessibilityService, String str, boolean z5) {
            this.f5395a = accessibilityService;
            this.f5396b = str;
            this.f5397c = z5;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            v4.f5391c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5398a;

        public c(AccessibilityService accessibilityService) {
            this.f5398a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            v4.a(this.f5398a, System.currentTimeMillis());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5399a;

        public d(AccessibilityService accessibilityService) {
            this.f5399a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            v4.a(this.f5399a, System.currentTimeMillis());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5400a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5401b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            v4.f(this.f5400a);
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5400a, this.f5401b);
                if (g6 == null) {
                    if (v4.f5392d != null) {
                        com.acse.ottn.b.c().b(v4.f5392d);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = v4.f5391c;
                if (timerTask != null) {
                    timerTask.cancel();
                    v4.f5391c = null;
                }
                c2.a(v4.f5389a, "buttery find");
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().a(s0.a().b(200));
                AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(this.f5400a, "允许后台高耗电");
                if (g7 != null) {
                    c2.a(v4.f5389a, "buttery info is not null");
                    com.acse.ottn.b.c().g(g7);
                    k0.c(true);
                } else {
                    c2.a(v4.f5389a, "buttery info is null");
                    if (g6.getParent() != null) {
                        c2.a(v4.f5389a, "buttery start");
                        for (int i6 = 0; i6 < g6.getParent().getChildCount(); i6++) {
                            if (g6.getParent().getChild(i6) != null && "android.widget.Switch".equals(g6.getParent().getChild(i6).getClassName())) {
                                c2.a(v4.f5389a, "find buttery Switch");
                                if (!g6.getParent().getChild(i6).isChecked()) {
                                    Rect rect = new Rect();
                                    g6.getParent().getChild(i6).getBoundsInScreen(rect);
                                    int i7 = rect.right;
                                    int i8 = rect.left;
                                    int i9 = ((i7 - i8) / 2) + i8;
                                    int i10 = rect.bottom;
                                    int i11 = rect.top;
                                    int i12 = ((i10 - i11) / 2) + i11;
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        com.acse.ottn.b.c().a(this.f5400a, i9, i12);
                                    }
                                }
                            }
                        }
                    }
                }
                c2.a(v4.f5389a, "backgroundHightBattery comeBack");
                com.acse.ottn.b.c().a(s0.a().b(100));
                com.acse.ottn.b.c().e(this.f5400a);
                com.acse.ottn.b.c().a(s0.a().b(100));
                com.acse.ottn.b.c().e(this.f5400a);
                com.acse.ottn.b.c().a(s0.a().b(100));
                com.acse.ottn.b.c().e(this.f5400a);
            } catch (Exception e6) {
                c2.a(v4.f5389a, "backgroundHightBattery e =" + e6.getMessage());
            }
        }

        public e(AccessibilityService accessibilityService, String str) {
            this.f5400a = accessibilityService;
            this.f5401b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            v4.f5391c = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5402a;

        public f(AccessibilityService accessibilityService) {
            this.f5402a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5402a, "自启动");
            if (g6 != null && g6.getParent() != null) {
                c2.a(v4.f5389a, "find auto start");
                if (!v4.c(this.f5402a, g6.getParent(), true)) {
                    v4.c(this.f5402a, g6.getParent().getParent(), false);
                }
                k0.b(true);
                return;
            }
            c2.a(v4.f5389a, "not find auto start");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5403a;

        public g(AccessibilityService accessibilityService) {
            this.f5403a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean canDrawOverlays;
            if (Build.VERSION.SDK_INT >= 23) {
                canDrawOverlays = Settings.canDrawOverlays(this.f5403a);
                if (canDrawOverlays) {
                    com.acse.ottn.b.c().a(s0.a().b(200));
                    com.acse.ottn.b.c().e(this.f5403a);
                    return;
                }
            }
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f5403a, "悬浮窗");
            if (g6 != null && g6.getParent() != null) {
                c2.a(v4.f5389a, "find flow window");
                if (!v4.c(this.f5403a, g6.getParent(), true)) {
                    v4.c(this.f5403a, g6.getParent().getParent(), false);
                }
            }
            com.acse.ottn.b.c().a(s0.a().b(200));
            com.acse.ottn.b.c().e(this.f5403a);
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "允许显示在其他应用的上层");
        if (g6 != null || g6.getParent() == null) {
            for (int i6 = 0; i6 < g6.getParent().getChildCount(); i6++) {
                if (g6.getParent().getChild(i6) != null && "android.widget.Switch".equals(g6.getParent().getChild(i6).getClassName())) {
                    com.acse.ottn.b.c().g(g6.getParent().getChild(i6));
                    com.acse.ottn.b.c().e(accessibilityService);
                    return;
                }
            }
        }
    }

    public static void d(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().a(s0.a().b(200));
        AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "后台耗电管理");
        AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(accessibilityService, "后台高耗电");
        if (j6 != null) {
            c2.a(f5389a, "clickServiceBackgroundHight info is not null");
            if (j3.a() != null) {
                j3.a().a("battery_white", Boolean.TRUE);
            }
            com.acse.ottn.b.c().g(j6);
            new Handler(Looper.getMainLooper()).postDelayed(new c(accessibilityService), 1000L);
            return;
        }
        if (j7 != null) {
            c2.a(f5389a, "clickServiceBackgroundHight info2 is not null");
            if (j3.a() != null) {
                c2.a(f5389a, "clickServiceBackgroundHight QuickPreference is not null");
                j3.a().a("battery_white", Boolean.TRUE);
            }
            com.acse.ottn.b.c().g(j7);
            new Handler(Looper.getMainLooper()).postDelayed(new d(accessibilityService), 1000L);
        }
    }

    public static void b(Activity activity) {
        if (j3.a() != null) {
            j3.a().a("battery_white", Boolean.TRUE);
        }
        if ("".equals(k0.f4687w)) {
            return;
        }
        try {
            String a6 = j3.a().a("flow_window_state", "1");
            if (!j4.b().equals("vivo") || a6.equals("2")) {
                Intent intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity");
                intent.putExtra("packagename", k0.f4687w);
                intent.putExtra("tabId", "1");
                activity.startActivityForResult(intent, 10013);
                return;
            }
            j3.a().b("flow_window_state", "2");
            Intent intent2 = new Intent();
            intent2.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent2.putExtra("packagename", k0.f4687w);
            intent2.putExtra("tabId", "1");
            activity.startActivityForResult(intent2, 10013);
        } catch (Exception unused) {
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, k0.f4687w, null));
            activity.startActivityForResult(intent3, 10013);
        }
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        c2.a(f5389a, "findAppName 开始");
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            c2.a(f5389a, "findAppName null");
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        b(rootInActiveWindow);
    }

    public static void e(AccessibilityService accessibilityService) {
        String b6 = j1.c().b();
        com.acse.ottn.b.c().a(500L);
        if (com.acse.ottn.b.c().h(accessibilityService, b6) != null) {
            AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "今日不再提醒");
            if (j6 != null) {
                com.acse.ottn.b.c().g(j6);
            }
            c2.a(f5389a, "findAppName 存在=" + b6);
            AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(accessibilityService, "始终打开");
            c2.a(f5389a, "findAppName 存在始终打开");
            if (h6 != null) {
                Rect rect = new Rect();
                h6.getBoundsInScreen(rect);
                int i6 = rect.right;
                int i7 = rect.left;
                int i8 = ((i6 - i7) / 2) + i7;
                int i9 = rect.bottom;
                int i10 = rect.top;
                int i11 = ((i9 - i10) / 2) + i10;
                if (Build.VERSION.SDK_INT >= 24) {
                    c2.a(f5389a, "findAppName x=" + i8 + "     y=" + i11);
                    com.acse.ottn.b.c().a(accessibilityService, i8, i11);
                    return;
                }
                return;
            }
            AccessibilityNodeInfo h7 = com.acse.ottn.b.c().h(accessibilityService, "30天内允许");
            c2.a(f5389a, "findAppName 存在始终打开");
            if (h7 != null) {
                Rect rect2 = new Rect();
                h7.getBoundsInScreen(rect2);
                int i12 = rect2.right;
                int i13 = rect2.left;
                int i14 = ((i12 - i13) / 2) + i13;
                int i15 = rect2.bottom;
                int i16 = rect2.top;
                int i17 = ((i15 - i16) / 2) + i16;
                if (Build.VERSION.SDK_INT >= 24) {
                    c2.a(f5389a, "findAppName x=" + i14 + "     y=" + i17);
                    com.acse.ottn.b.c().a(accessibilityService, i14, i17);
                    return;
                }
                return;
            }
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(accessibilityService, "始终允许");
            if (j7 != null) {
                c2.a(f5389a, "findAppName 始终允许");
                com.acse.ottn.b.c().g(j7);
                return;
            }
            AccessibilityNodeInfo j8 = com.acse.ottn.b.c().j(accessibilityService, "允许");
            if (j8 != null) {
                c2.a(f5389a, "findAppName 允许");
                com.acse.ottn.b.c().g(j8);
                return;
            }
            AccessibilityNodeInfo j9 = com.acse.ottn.b.c().j(accessibilityService, "始终允许打开");
            if (j9 != null) {
                c2.a(f5389a, "findAppName 始终允许打开");
                com.acse.ottn.b.c().g(j9);
            }
            AccessibilityNodeInfo j10 = com.acse.ottn.b.c().j(accessibilityService, "打开");
            if (j10 != null) {
                c2.a(f5389a, "findAppName 打开");
                com.acse.ottn.b.c().g(j10);
            }
            com.acse.ottn.b.c().i(accessibilityService, "允许");
            return;
        }
        c2.a(f5389a, "findAppName 不存在=" + b6);
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow);
    }

    public static void h(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().g(com.acse.ottn.b.c().a(accessibilityService, "权限", true));
        com.acse.ottn.b.c().a(s0.a().b(500));
        AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a(accessibilityService, "自启动", true);
        if (a6 != null) {
            com.acse.ottn.b.c().g(a6);
        }
    }

    @RequiresApi(api = 16)
    public static void i(AccessibilityService accessibilityService) {
        String b6 = j1.c().b();
        c2.a(f5389a, b6);
        f5391c = m0.a().b(s0.a().b(20000), s0.a().b(100), new a(accessibilityService, b6));
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
            c2.b(f5389a, Log.getStackTraceString(e6));
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.accessibilityservice.AccessibilityService r4, android.view.accessibility.AccessibilityNodeInfo r5, boolean r6) {
        /*
            r0 = 0
            r1 = 0
        L2:
            int r2 = r5.getChildCount()
            if (r1 >= r2) goto Lc7
            android.view.accessibility.AccessibilityNodeInfo r2 = r5.getChild(r1)
            if (r2 == 0) goto Lc3
            android.view.accessibility.AccessibilityNodeInfo r2 = r5.getChild(r1)
            java.lang.CharSequence r2 = r2.getClassName()
            java.lang.String r3 = "android.widget.Switch"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L2e
            android.view.accessibility.AccessibilityNodeInfo r2 = r5.getChild(r1)
            java.lang.CharSequence r2 = r2.getClassName()
            java.lang.String r3 = "android.widget.SeekBar"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto Lc3
        L2e:
            java.lang.String r2 = "find auto Switch"
            java.lang.String r3 = "acse_VivoUtils"
            com.acse.ottn.c2.a(r3, r2)
            android.view.accessibility.AccessibilityNodeInfo r2 = r5.getChild(r1)
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto Lbe
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.view.accessibility.AccessibilityNodeInfo r5 = r5.getChild(r1)
            r5.getBoundsInScreen(r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "left="
            r5.append(r1)
            int r1 = r0.left
            r5.append(r1)
            java.lang.String r1 = "   right="
            r5.append(r1)
            int r1 = r0.right
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.acse.ottn.c2.a(r3, r5)
            int r5 = com.acse.ottn.j4.c(r4)
            int r1 = r0.right
            if (r1 <= r5) goto L7b
            int r6 = r0.left
            int r1 = r1 - r6
            int r1 = r1 / 2
            int r1 = r1 + r6
        L79:
            int r1 = r1 - r5
            goto L89
        L7b:
            if (r6 == 0) goto L84
            int r5 = r0.left
            int r1 = r1 - r5
            int r1 = r1 / 2
            int r1 = r1 + r5
            goto L89
        L84:
            int r5 = r0.left
            int r5 = r5 / 2
            goto L79
        L89:
            int r5 = r0.bottom
            int r6 = r0.top
            int r5 = r5 - r6
            int r5 = r5 / 2
            int r5 = r5 + r6
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            if (r6 < r0) goto Lbc
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "start  click Switch x="
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "  y="
            r6.append(r0)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            com.acse.ottn.c2.a(r3, r6)
            com.acse.ottn.b r6 = com.acse.ottn.b.c()
            int r1 = r1 + (-30)
            r6.a(r4, r1, r5)
        Lbc:
            r4 = 1
            return r4
        Lbe:
            java.lang.String r2 = "start is open"
            com.acse.ottn.c2.a(r3, r2)
        Lc3:
            int r1 = r1 + 1
            goto L2
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.v4.c(android.accessibilityservice.AccessibilityService, android.view.accessibility.AccessibilityNodeInfo, boolean):boolean");
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

    public static boolean d(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, boolean z5) {
        int i6;
        for (int i7 = 0; i7 < accessibilityNodeInfo.getChildCount(); i7++) {
            if (accessibilityNodeInfo.getChild(i7) != null && ("android.widget.Switch".equals(accessibilityNodeInfo.getChild(i7).getClassName()) || "android.widget.SeekBar".equals(accessibilityNodeInfo.getChild(i7).getClassName()))) {
                c2.a(f5389a, "find auto Switch");
                if (!accessibilityNodeInfo.getChild(i7).isChecked()) {
                    Rect rect = new Rect();
                    accessibilityNodeInfo.getChild(i7).getBoundsInScreen(rect);
                    c2.a(f5389a, "left=" + rect.left + "   right=" + rect.right);
                    c2.a(f5389a, "top=" + rect.top + "   bottom=" + rect.bottom);
                    int i8 = rect.bottom;
                    int i9 = rect.top;
                    int i10 = ((i8 - i9) / 2) + i9;
                    if (z5) {
                        int i11 = rect.right;
                        int i12 = rect.left;
                        i6 = ((i11 - i12) / 2) + i12;
                    } else {
                        i6 = (rect.right - rect.left) - 50;
                    }
                    if (Build.VERSION.SDK_INT < 24) {
                        return true;
                    }
                    c2.a(f5389a, "start  click Switch x=" + i6 + "  y=" + i10);
                    com.acse.ottn.b.c().a(accessibilityService, i6, i10);
                    return true;
                }
                c2.a(f5389a, "start is open");
            }
        }
        return false;
    }

    public static void a(Activity activity) {
        try {
            if (j3.a() != null) {
                j3 a6 = j3.a();
                Boolean bool = Boolean.TRUE;
                a6.a("background_battery_hignt", bool);
                j3.a().a("battery_white", bool);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.powersaving", "com.iqoo.powersaving.PowerSavingManagerActivity"));
            activity.startActivityForResult(intent, 10014);
        } catch (Exception e6) {
            c2.a(f5389a, e6.getMessage());
            k0.c(true);
        }
    }

    public static void b(AccessibilityService accessibilityService) {
        new Handler(Looper.getMainLooper()).postDelayed(new f(accessibilityService), 200L);
        new Handler(Looper.getMainLooper()).postDelayed(new g(accessibilityService), 500L);
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                if (accessibilityNodeInfo.getChild(i6) != null) {
                    c2.a(f5389a, "info.getChild(i)=" + accessibilityNodeInfo.getChild(i6).toString());
                    if (accessibilityNodeInfo.getText() != null) {
                        c2.c("findAppName-->", "找到标题title= in.getClassName()=" + accessibilityNodeInfo.getText().toString().trim());
                    }
                    if (accessibilityNodeInfo.getContentDescription() != null) {
                        c2.c("findAppName-->", "找到标题title= in.getContentDescription()=" + accessibilityNodeInfo.getContentDescription().toString().trim());
                    }
                } else if (accessibilityNodeInfo.getChild(i6) != null) {
                    b(accessibilityNodeInfo.getChild(i6));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                if (accessibilityNodeInfo.getChild(i6) != null && ("android.widget.ListView".equals(accessibilityNodeInfo.getChild(i6).getClassName()) || "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i6).getClassName()))) {
                    f5392d = accessibilityNodeInfo.getChild(i6);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        a(accessibilityNodeInfo.getChild(i6));
                    }
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z5) {
        f5391c = m0.a().b(s0.a().b(15000), s0.a().b(500), new b(accessibilityService, j1.c().b(), z5));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j6) {
        j3.a().a("battery_white", Boolean.FALSE);
        if (j6 - f5390b.longValue() < 5000) {
            c2.a(f5389a, "间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            c2.a(f5389a, "间隔 time=" + f5390b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5390b.longValue()));
            return;
        }
        c2.a(f5389a, "无间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        c2.a(f5389a, "无间隔 time=" + f5390b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5390b.longValue()));
        f5390b = Long.valueOf(j6);
        c2.a(f5389a, "buttery backgroundHightBattery");
        f5391c = m0.a().b(s0.a().b(5000), s0.a().b(150), new e(accessibilityService, j1.c().b()));
    }
}
