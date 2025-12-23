package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.acse.ottn.service.ShopHelperService;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.comm.constants.ErrorCode;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a2 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4041a = "LocationManager";

    /* renamed from: b, reason: collision with root package name */
    public static volatile a2 f4042b;

    /* renamed from: c, reason: collision with root package name */
    public static Long f4043c = 0L;

    /* renamed from: d, reason: collision with root package name */
    public static TimerTask f4044d = null;

    /* renamed from: e, reason: collision with root package name */
    public static AccessibilityNodeInfo f4045e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4046a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4047b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4046a, this.f4047b);
                if (g6 != null) {
                    if (a2.f4044d != null) {
                        a2.f4044d.cancel();
                        TimerTask unused = a2.f4044d = null;
                    }
                    com.acse.ottn.b.c().g(g6);
                    if (j3.a() != null) {
                        j3 a6 = j3.a();
                        Boolean bool = Boolean.TRUE;
                        a6.a("battery_white", bool);
                        j3.a().a("location_permission", bool);
                    }
                }
            } catch (Throwable th) {
                c2.a(a2.f4041a, "e =" + th.getMessage());
            }
        }

        public a(AccessibilityService accessibilityService, String str) {
            this.f4046a = accessibilityService;
            this.f4047b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            TimerTask unused = a2.f4044d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4048a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f4049b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4048a, "位置信息");
            if (g6 == null) {
                com.acse.ottn.b.c().b(this.f4049b);
                return;
            }
            if (a2.f4044d != null) {
                a2.f4044d.cancel();
                TimerTask unused = a2.f4044d = null;
            }
            com.acse.ottn.b.c().g(g6);
            if (j3.a() != null) {
                j3 a6 = j3.a();
                Boolean bool = Boolean.TRUE;
                a6.a("battery_white", bool);
                j3.a().a("location_permission", bool);
            }
        }

        public b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f4048a = accessibilityService;
            this.f4049b = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(a2.f4041a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4050a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4051b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo c6 = a2.c(this.f4050a.getRootInActiveWindow());
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4050a, this.f4051b);
            if (g6 == null) {
                if (c6 != null) {
                    com.acse.ottn.b.c().b(c6);
                    return;
                }
                return;
            }
            if (a2.f4044d != null) {
                a2.f4044d.cancel();
                TimerTask unused = a2.f4044d = null;
            }
            if ("honor".equals(j4.b()) || "tianyi".equals(j4.b())) {
                com.acse.ottn.b.c().g(g6);
                a2.l(this.f4050a);
            } else {
                j3.a().a("battery_white", Boolean.TRUE);
                com.acse.ottn.b.c().g(g6);
            }
        }

        public c(AccessibilityService accessibilityService, String str) {
            this.f4050a = accessibilityService;
            this.f4051b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(a2.f4041a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4052a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4053b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                if (this.f4052a == null) {
                    return;
                }
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4053b, this.f4052a);
                if (g6 == null) {
                    a2.i(this.f4053b);
                    if (a2.f4045e != null) {
                        com.acse.ottn.b.c().b(a2.f4045e);
                        return;
                    }
                    return;
                }
                if (a2.f4044d != null) {
                    a2.f4044d.cancel();
                    TimerTask unused = a2.f4044d = null;
                }
                c2.a(a2.f4041a, "找到了定位");
                com.acse.ottn.b.c().g(g6);
                com.acse.ottn.b.c().a(s0.a().b(200));
                AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(this.f4053b, "始终允许");
                AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a(this.f4053b, "允许", true);
                if (g7 != null) {
                    com.acse.ottn.b.c().g(g7);
                    a2.b(this.f4053b, 1);
                } else if (a6 != null) {
                    com.acse.ottn.b.c().g(a6);
                    a2.b(this.f4053b, 1);
                }
            } catch (Throwable th) {
                c2.a(a2.f4041a, "e =" + th.getMessage());
            }
        }

        public d(String str, AccessibilityService accessibilityService) {
            this.f4052a = str;
            this.f4053b = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            TimerTask unused = a2.f4044d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4054a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            if (com.acse.ottn.b.c().h(this.f4054a, "定位") == null) {
                c2.a(a2.f4041a, "滑动1 ");
                if (Build.VERSION.SDK_INT >= 24) {
                    com.acse.ottn.b c6 = com.acse.ottn.b.c();
                    AccessibilityService accessibilityService = this.f4054a;
                    c6.a(accessibilityService, j4.c(accessibilityService) / 3, ((j4.b(this.f4054a) * 2) / 3) + 300, (j4.c(this.f4054a) / 3) + 100, j4.b(this.f4054a) / 3, 500);
                    return;
                }
                return;
            }
            com.acse.ottn.b.c().i(this.f4054a, "定位");
            com.acse.ottn.b.c().a(500L);
            AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(this.f4054a, "始终允许");
            if (h6 != null) {
                if (a2.f4044d != null) {
                    a2.f4044d.cancel();
                    TimerTask unused = a2.f4044d = null;
                }
                c2.a(a2.f4041a, "clickVivoLocation appNodeInfo is not null");
                com.acse.ottn.b.c().g(h6);
                if (Build.VERSION.SDK_INT >= 35) {
                    a2.b(this.f4054a, 2);
                    return;
                } else {
                    a2.b(this.f4054a, 1);
                    return;
                }
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 < 35) {
                c2.a(a2.f4041a, "clickVivoLocation appNodeInfo is null");
                c2.a(a2.f4041a, "滑动2");
                if (i6 >= 24) {
                    com.acse.ottn.b c7 = com.acse.ottn.b.c();
                    AccessibilityService accessibilityService2 = this.f4054a;
                    c7.a(accessibilityService2, j4.c(accessibilityService2) / 3, ((j4.b(this.f4054a) * 2) / 3) + 300, (j4.c(this.f4054a) / 3) + 100, j4.b(this.f4054a) / 3, 500);
                    return;
                }
                return;
            }
            if (a2.f4044d != null) {
                a2.f4044d.cancel();
                TimerTask unused2 = a2.f4044d = null;
            }
            com.acse.ottn.b.c().a(500L);
            int c8 = j4.c(this.f4054a);
            int b6 = j4.b(this.f4054a);
            StringBuilder sb = new StringBuilder();
            sb.append("current x=");
            int i7 = c8 / 2;
            sb.append(i7);
            sb.append("   current y=");
            int i8 = ((b6 / 3) * 9) / 10;
            sb.append(i8);
            c2.a(a2.f4041a, sb.toString());
            com.acse.ottn.b.c().a(this.f4054a, i7, i8);
            a2.b(this.f4054a, 2);
        }

        public e(AccessibilityService accessibilityService) {
            this.f4054a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            TimerTask unused = a2.f4044d = null;
        }
    }

    public static a2 c() {
        if (f4042b == null) {
            synchronized (a2.class) {
                try {
                    if (f4042b == null) {
                        f4042b = new a2();
                    }
                } finally {
                }
            }
        }
        return f4042b;
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityService accessibilityService, boolean z5) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        com.acse.ottn.b.c().a(s0.a().b(200));
        if (z5) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            f(accessibilityService);
        }
    }

    public static void d(AccessibilityService accessibilityService) {
        c2.a(f4041a, "clickSamsungNeverLocation");
        com.acse.ottn.b.c().a(200L);
        AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(accessibilityService, "始终允许");
        if (h6 != null) {
            c2.a(f4041a, "找了始终允许");
            com.acse.ottn.b.c().g(h6);
            b(accessibilityService, 1);
        }
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        TimerTask timerTask = f4044d;
        if (timerTask != null) {
            timerTask.cancel();
            f4044d = null;
        }
        f4044d = m0.a().b(s0.a().b(ErrorCode.UNKNOWN_ERROR), s0.a().b(100), new a(accessibilityService, j3.a().e("OpenPermissionName")));
    }

    public static void g(AccessibilityService accessibilityService) {
        c2.a(f4041a, "clickVivoLocation");
        TimerTask timerTask = f4044d;
        if (timerTask != null) {
            timerTask.cancel();
            f4044d = null;
        }
        f4044d = m0.a().b(s0.a().b(12000), s0.a().b(1000), new e(accessibilityService));
    }

    @SuppressLint({"NewApi"})
    public static void j(AccessibilityService accessibilityService) {
        c2.a(f4041a, "getPacketw");
        b(accessibilityService.getRootInActiveWindow());
    }

    public static void m(AccessibilityService accessibilityService) {
        c2.a(f4041a, "startOppoLocation");
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "位置信息");
        j(accessibilityService);
        if (g6 == null) {
            c2.a(f4041a, "startOppoLocation start");
            AccessibilityNodeInfo j6 = com.acse.ottn.b.c().j(accessibilityService, "始终允许");
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(accessibilityService, "允许");
            if (j6 != null) {
                c2.a(f4041a, "startOppoLocation nodeInfo1 is not null");
                com.acse.ottn.b.c().g(j6);
                com.acse.ottn.b.c().a(300L);
                if (!"oneplus".equals(j4.b())) {
                    b(accessibilityService, 2);
                    return;
                } else {
                    j3.a().a("battery_white", Boolean.FALSE);
                    b(accessibilityService, 3);
                    return;
                }
            }
            if (j7 != null) {
                c2.a(f4041a, "startOppoLocation nodeInfo2 is not null");
                com.acse.ottn.b.c().g(j7);
                com.acse.ottn.b.c().a(300L);
                b(accessibilityService, 2);
                return;
            }
            c2.a(f4041a, "click oppo x y");
            AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
            Rect rect = new Rect();
            rootInActiveWindow.getBoundsInParent(rect);
            int i6 = rect.right;
            int i7 = rect.bottom;
            int i8 = i6 / 2;
            int i9 = (i7 / 2) - (i7 / 8);
            c2.a(f4041a, "x=" + i6 + "   y=" + i7 + "   x1 =" + i8 + "   y1=" + i9);
            if (Build.VERSION.SDK_INT >= 24) {
                com.acse.ottn.b.c().a(accessibilityService, i8, i9);
            }
            b(accessibilityService, 3);
            return;
        }
        c2.a(f4041a, "startOppoLocation nodeInfo is not null");
        com.acse.ottn.b.c().g(g6);
        com.acse.ottn.b.c().a(500L);
        AccessibilityNodeInfo j8 = com.acse.ottn.b.c().j(ShopHelperService.mService, "始终允许");
        AccessibilityNodeInfo j9 = com.acse.ottn.b.c().j(accessibilityService, "允许");
        if (j8 != null) {
            c2.a(f4041a, "startOppoLocation nodeInfo1 is not null");
            com.acse.ottn.b.c().g(j8);
            com.acse.ottn.b.c().a(300L);
            if ("oneplus".equals(j4.b())) {
                b(accessibilityService, 3);
            } else {
                b(accessibilityService, 2);
            }
        } else if (j9 != null) {
            c2.a(f4041a, "startOppoLocation nodeInfo2 is not null");
            com.acse.ottn.b.c().g(j9);
            com.acse.ottn.b.c().a(300L);
            b(accessibilityService, 2);
        } else if (Build.VERSION.SDK_INT >= 35) {
            c2.a(f4041a, "current oppo android version 15");
            TimerTask timerTask = f4044d;
            if (timerTask != null) {
                timerTask.cancel();
                f4044d = null;
            }
            com.acse.ottn.b.c().a(500L);
            int c6 = j4.c(accessibilityService);
            int b6 = j4.b(accessibilityService);
            StringBuilder sb = new StringBuilder();
            sb.append("current x=");
            int i10 = c6 / 2;
            sb.append(i10);
            sb.append("   current y=");
            int i11 = b6 / 3;
            sb.append(i11);
            c2.a(f4041a, sb.toString());
            com.acse.ottn.b.c().a(accessibilityService, i10, (i11 * 11) / 10);
            b(accessibilityService, 3);
        }
        if (Build.VERSION.SDK_INT != 34) {
            c2.a(f4041a, "open location is faile");
            j3.a().a("battery_white", Boolean.FALSE);
            return;
        }
        c2.a(f4041a, "current oppo android version 14");
        TimerTask timerTask2 = f4044d;
        if (timerTask2 != null) {
            timerTask2.cancel();
            f4044d = null;
        }
        int c7 = j4.c(accessibilityService);
        int b7 = j4.b(accessibilityService);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("current x=");
        int i12 = c7 / 2;
        sb2.append(i12);
        sb2.append("   current y=");
        int i13 = b7 / 2;
        int i14 = i13 + 100;
        sb2.append(i14);
        c2.a(f4041a, sb2.toString());
        com.acse.ottn.b.c().a(accessibilityService, i12, i13 - (b7 / 10));
        com.acse.ottn.b.c().a(500L);
        if (!b2.a().a(accessibilityService)) {
            com.acse.ottn.b.c().a(accessibilityService, i12, i14);
        }
        j3.a().a("battery_white", Boolean.FALSE);
        b(accessibilityService, 3);
    }

    public static void f(AccessibilityService accessibilityService) {
        f4044d = m0.a().b(s0.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType), s0.a().b(100), new c(accessibilityService, j1.c().b()));
    }

    @RequiresApi(api = 16)
    public static void h(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "位置");
        if (g6 != null) {
            com.acse.ottn.b.c().g(g6);
            com.acse.ottn.b.c().a(100L);
            j3 a6 = j3.a();
            Boolean bool = Boolean.TRUE;
            a6.a("battery_white", bool);
            j3.a().a("is_pengpai", bool);
            a(accessibilityService, System.currentTimeMillis());
            return;
        }
        TimerTask timerTask = f4044d;
        if (timerTask != null) {
            timerTask.cancel();
            f4044d = null;
        }
        f4044d = m0.a().b(s0.a().b(2000), s0.a().b(300), new d(j3.a().e("OpenPermissionName"), accessibilityService));
    }

    @SuppressLint({"NewApi"})
    public static void i(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void k(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, "权限管理");
        AccessibilityNodeInfo g7 = com.acse.ottn.b.c().g(accessibilityService, "应用权限");
        AccessibilityNodeInfo g8 = com.acse.ottn.b.c().g(accessibilityService, "权限");
        if (g6 != null) {
            c2.a(f4041a, "openOppoLocationManage nodeInfo is not null");
            j3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(g6);
            com.acse.ottn.b.c().a(300L);
            return;
        }
        if (g7 != null) {
            c2.a(f4041a, "openOppoLocationManage nodeInfo1 is not null");
            j3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(g7);
            com.acse.ottn.b.c().a(300L);
            return;
        }
        if (g8 != null) {
            c2.a(f4041a, "openOppoLocationManage nodeInfo2 is not null");
            j3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(g8);
            com.acse.ottn.b.c().a(300L);
        }
    }

    public static void l(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(accessibilityService, "始终允许");
        if (h6 != null) {
            com.acse.ottn.b.c().a(500L);
            com.acse.ottn.b.c().g(h6);
            AccessibilityNodeInfo h7 = com.acse.ottn.b.c().h(accessibilityService, "确定");
            if (h7 != null) {
                com.acse.ottn.b.c().g(h7);
            }
            b(accessibilityService, 4);
        }
    }

    public static void a(AccessibilityService accessibilityService, boolean z5) {
        try {
            b(accessibilityService, z5);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            f4044d = m0.a().b(s0.a().b(3000), s0.a().b(300), new b(accessibilityService, null));
        }
    }

    public static void b(AccessibilityService accessibilityService, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            com.acse.ottn.b.c().a(s0.a().b(200));
            j3.a().a("battery_white", Boolean.FALSE);
            com.acse.ottn.b.c().e(accessibilityService);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            if (accessibilityNodeInfo.getChild(i6) != null) {
                if ("androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getClassName())) {
                    f4045e = accessibilityNodeInfo;
                    return;
                }
                a(accessibilityNodeInfo.getChild(i6));
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static AccessibilityNodeInfo c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            if (accessibilityNodeInfo.getChild(i6) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i6).getClassName()) && accessibilityNodeInfo.getChild(i6).isScrollable()) {
                return accessibilityNodeInfo.getChild(i6);
            }
            if (accessibilityNodeInfo.getChild(i6) != null) {
                c(accessibilityNodeInfo.getChild(i6));
            }
        }
        return null;
    }

    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a(accessibilityService, "始终允许", true);
        if (a6 != null) {
            com.acse.ottn.b.c().g(a6);
            b(accessibilityService, 4);
        }
    }

    public static void a(AccessibilityService accessibilityService, long j6) {
        if (j6 - f4043c.longValue() < 1000) {
            c2.a(f4041a, "间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            c2.a(f4041a, "间隔 time=" + f4043c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f4043c.longValue()));
            return;
        }
        c2.a(f4041a, "无间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        c2.a(f4041a, "无间隔 time=" + f4043c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f4043c.longValue()));
        f4043c = Long.valueOf(j6);
        com.acse.ottn.b.c().a(200L);
        AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(accessibilityService, "始终允许");
        if (h6 != null) {
            com.acse.ottn.b.c().g(h6);
            b(accessibilityService, 2);
        }
    }

    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfo != null) {
                for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        b(accessibilityNodeInfo.getChild(i6));
                    }
                }
                return;
            }
            return;
        }
        c2.a(f4041a, "recycle1 =" + accessibilityNodeInfo.toString());
        if (accessibilityNodeInfo.getText() != null) {
            c2.a(f4041a, "recycle2 =" + accessibilityNodeInfo.getText().toString());
        }
        if (accessibilityNodeInfo.getContentDescription() != null) {
            c2.a(f4041a, "getContentDescription=" + accessibilityNodeInfo.getContentDescription().toString().trim());
        }
    }

    public static void c(AccessibilityService accessibilityService) {
        com.acse.ottn.b.c().a(100L);
        AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(accessibilityService, "仅在使用该应用时允许");
        if (h6 != null) {
            com.acse.ottn.b.c().g(h6);
        }
    }
}
