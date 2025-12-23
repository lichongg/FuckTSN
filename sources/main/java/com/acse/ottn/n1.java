package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.m0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.comm.constants.ErrorCode;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4903a = "acse_HuaweiUtils";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4904b = true;

    /* renamed from: d, reason: collision with root package name */
    public static TimerTask f4906d;

    /* renamed from: c, reason: collision with root package name */
    public static Long f4905c = 0L;

    /* renamed from: e, reason: collision with root package name */
    public static AccessibilityNodeInfo f4907e = null;

    /* renamed from: f, reason: collision with root package name */
    public static AccessibilityNodeInfo f4908f = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4909a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f4910b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.n1$a$a, reason: collision with other inner class name */
        public class RunnableC0082a implements Runnable {
            public RunnableC0082a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean canDrawOverlays;
                canDrawOverlays = Settings.canDrawOverlays(a.this.f4909a);
                if (canDrawOverlays) {
                    com.acse.ottn.b.c().e(a.this.f4909a);
                    if (a.this.f4910b) {
                        com.acse.ottn.b.c().e(a.this.f4909a);
                    }
                }
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4909a, "在其他应用上层显示");
                if (g6 != null || j4.t()) {
                    if (g6 == null || g6.getParent() == null) {
                        return;
                    }
                    TimerTask timerTask = n1.f4906d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        n1.f4906d = null;
                    }
                    for (int i6 = 0; i6 < g6.getParent().getChildCount(); i6++) {
                        if (g6.getParent().getChild(i6) != null && "android.widget.Switch".equals(g6.getParent().getChild(i6).getClassName())) {
                            com.acse.ottn.b.c().g(g6.getParent().getChild(i6));
                            com.acse.ottn.b.c().e(this.f4909a);
                            if (this.f4910b) {
                                com.acse.ottn.b.c().e(this.f4909a);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                c2.a(n1.f4903a, "找到  在其他应用上层显示");
                if (g6 == null) {
                    g6 = com.acse.ottn.b.c().f(this.f4909a, "android:id/summary");
                }
                if (g6 == null || g6.getParent().getParent() == null) {
                    return;
                }
                TimerTask timerTask2 = n1.f4906d;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                    n1.f4906d = null;
                }
                Rect rect = new Rect();
                g6.getBoundsInScreen(rect);
                Rect rect2 = new Rect();
                g6.getBoundsInParent(rect2);
                n1.f(this.f4909a);
                int c6 = j4.c(HelpShopAppUtil.getContext());
                int i7 = (rect.top - (rect2.bottom / 2)) - 30;
                int i8 = c6 - 80;
                if (Build.VERSION.SDK_INT >= 24) {
                    com.acse.ottn.b.c().a(this.f4909a, i8, i7);
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0082a(), 300L);
                }
            } catch (Throwable th) {
                c2.a(n1.f4903a, "e =" + th.getMessage());
            }
        }

        public a(AccessibilityService accessibilityService, boolean z5) {
            this.f4909a = accessibilityService;
            this.f4910b = z5;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n1.f4906d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4912a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4913b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f4912a, this.f4913b);
            if (j7 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.acse.ottn.b.c().a(this.f4912a, j4.c(HelpShopAppUtil.getContext()) / 3, ((j4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (j4.c(HelpShopAppUtil.getContext()) / 3) + 100, j4.b(HelpShopAppUtil.getContext()) / 3, 300);
                    return;
                }
                return;
            }
            c2.a("samon-->111=", "333");
            n1.d(j7);
            TimerTask timerTask = n1.f4906d;
            if (timerTask != null) {
                timerTask.cancel();
                n1.f4906d = null;
            }
            com.acse.ottn.b.c().e(this.f4912a);
            com.acse.ottn.b.c().a(200L);
            com.acse.ottn.b.c().e(this.f4912a);
            com.acse.ottn.b.c().a(200L);
            com.acse.ottn.b.c().e(this.f4912a);
        }

        public b(AccessibilityService accessibilityService, String str) {
            this.f4912a = accessibilityService;
            this.f4913b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n1.f4906d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4914a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4915b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4914a, this.f4915b);
                if (g6 != null) {
                    TimerTask timerTask = n1.f4906d;
                    if (timerTask != null) {
                        timerTask.cancel();
                        n1.f4906d = null;
                    }
                    com.acse.ottn.b.c().g(g6);
                    if (j3.a() != null) {
                        c2.a(n1.f4903a, "set battery_white is true");
                        j3.a().a("battery_white", Boolean.TRUE);
                    }
                }
            } catch (Throwable th) {
                c2.a(n1.f4903a, "e =" + th.getMessage());
            }
        }

        public c(AccessibilityService accessibilityService, String str) {
            this.f4914a = accessibilityService;
            this.f4915b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n1.f4906d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4916a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4917b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            c2.a(n1.f4903a, "openHonorFlowWindowPermission start");
            n1.e(this.f4916a);
            try {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4916a, this.f4917b);
                if (g6 == null) {
                    if (n1.f4907e != null) {
                        c2.a(n1.f4903a, "openHonorFlowWindowPermission ScrollForward");
                        com.acse.ottn.b.c().b(n1.f4907e);
                        return;
                    }
                    return;
                }
                TimerTask timerTask = n1.f4906d;
                if (timerTask != null) {
                    timerTask.cancel();
                    n1.f4906d = null;
                    c2.a(n1.f4903a, "openHonorFlowWindowPermission find name");
                    com.acse.ottn.b.c().g(g6);
                    com.acse.ottn.b.c().a(500L);
                    n1.a(this.f4916a, System.currentTimeMillis(), true);
                }
            } catch (Throwable th) {
                c2.a(n1.f4903a, "e =" + th.getMessage());
            }
        }

        public d(AccessibilityService accessibilityService, String str) {
            this.f4916a = accessibilityService;
            this.f4917b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n1.f4906d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4918a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4919b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f4920c;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            n1.f(this.f4918a.getRootInActiveWindow());
            if (n1.f4908f != null) {
                AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4918a, this.f4919b);
                if (g6 == null) {
                    com.acse.ottn.b.c().b(n1.f4908f);
                    return;
                }
                TimerTask timerTask = n1.f4906d;
                if (timerTask != null) {
                    timerTask.cancel();
                    n1.f4906d = null;
                }
                n1.g(g6);
                n1.a(this.f4918a, this.f4920c);
            }
        }

        public e(AccessibilityService accessibilityService, String str, boolean z5) {
            this.f4918a = accessibilityService;
            this.f4919b = str;
            this.f4920c = z5;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(n1.f4903a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4921a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            if (com.acse.ottn.b.c().g(this.f4921a, "手动管理") != null) {
                TimerTask timerTask = n1.f4906d;
                if (timerTask != null) {
                    timerTask.cancel();
                    n1.f4906d = null;
                }
                n1.b("允许自启动", this.f4921a);
                n1.b("允许后台活动", this.f4921a);
                k0.b(true);
                com.acse.ottn.b.c().e(this.f4921a);
                com.acse.ottn.b.c().e(this.f4921a);
                com.acse.ottn.b.c().e(this.f4921a);
                if ("honor".equals(j4.b()) && Build.VERSION.SDK_INT >= 36) {
                    com.acse.ottn.b.c().e(this.f4921a);
                }
                if (j3.a() != null) {
                    j3.a().a("battery_white", Boolean.FALSE);
                }
            }
        }

        public f(AccessibilityService accessibilityService) {
            this.f4921a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(n1.f4903a, "结束了");
            n1.f4906d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4922a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f4923b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(this.f4922a, "后台弹窗");
            if (g6 == null) {
                com.acse.ottn.b.c().b(this.f4923b);
                return;
            }
            TimerTask timerTask = n1.f4906d;
            if (timerTask != null) {
                timerTask.cancel();
                n1.f4906d = null;
            }
            com.acse.ottn.b.c().g(g6);
            if (j3.a() != null) {
                j3.a().a("battery_white", Boolean.TRUE);
            }
        }

        public g(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f4922a = accessibilityService;
            this.f4923b = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(n1.f4903a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4924a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f4925b;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo i6 = n1.i(this.f4924a.getRootInActiveWindow());
            if (com.acse.ottn.b.c().g(this.f4924a, this.f4925b) == null) {
                if (i6 != null) {
                    com.acse.ottn.b.c().b(i6);
                    return;
                }
                return;
            }
            TimerTask timerTask = n1.f4906d;
            if (timerTask != null) {
                timerTask.cancel();
                n1.f4906d = null;
            }
            n1.b(this.f4925b, this.f4924a);
            k0.c(true);
            com.acse.ottn.b.c().e(this.f4924a);
            com.acse.ottn.b.c().e(this.f4924a);
            com.acse.ottn.b.c().e(this.f4924a);
        }

        public h(AccessibilityService accessibilityService, String str) {
            this.f4924a = accessibilityService;
            this.f4925b = str;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            c2.a(n1.f4903a, "结束了");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4926a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f4926a, "应用");
            if (j7 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.acse.ottn.b.c().a(this.f4926a, j4.c(HelpShopAppUtil.getContext()) / 3, ((j4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (j4.c(HelpShopAppUtil.getContext()) / 3) + 100, j4.b(HelpShopAppUtil.getContext()) / 3, 300);
                    return;
                }
                return;
            }
            c2.a("samon-->111=", "333");
            j3.a().a("battery_white", Boolean.TRUE);
            com.acse.ottn.b.c().g(j7);
            TimerTask timerTask = n1.f4906d;
            if (timerTask != null) {
                timerTask.cancel();
                n1.f4906d = null;
            }
        }

        public i(AccessibilityService accessibilityService) {
            this.f4926a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n1.f4906d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class j implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4927a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            AccessibilityNodeInfo j7 = com.acse.ottn.b.c().j(this.f4927a, "跟踪管理");
            if (j7 == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    com.acse.ottn.b.c().a(this.f4927a, j4.c(HelpShopAppUtil.getContext()) / 3, ((j4.b(HelpShopAppUtil.getContext()) * 2) / 3) + 300, (j4.c(HelpShopAppUtil.getContext()) / 3) + 100, j4.b(HelpShopAppUtil.getContext()) / 3, 300);
                    return;
                }
                return;
            }
            c2.a("samon-->111=", "333");
            com.acse.ottn.b.c().g(j7);
            j3.a().a("oaid_permission", Boolean.TRUE);
            TimerTask timerTask = n1.f4906d;
            if (timerTask != null) {
                timerTask.cancel();
                n1.f4906d = null;
            }
        }

        public j(AccessibilityService accessibilityService) {
            this.f4927a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            n1.f4906d = null;
        }
    }

    @SuppressLint({"NewApi"})
    public static void d(AccessibilityService accessibilityService, boolean z5) {
        f4908f = null;
        f(accessibilityService, z5);
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService) {
        h(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        j(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getParent() == null) {
            return;
        }
        for (int i6 = 0; i6 < accessibilityNodeInfo.getParent().getChildCount(); i6++) {
            if (accessibilityNodeInfo.getParent().getChild(i6) != null && "android.widget.Switch".equals(accessibilityNodeInfo.getParent().getChild(i6).getClassName())) {
                if (accessibilityNodeInfo.getParent().getChild(i6).isChecked()) {
                    com.acse.ottn.b.c().g(accessibilityNodeInfo.getParent().getChild(i6));
                    return;
                }
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    public static void h(AccessibilityService accessibilityService) {
        c2.a(f4903a, "openHonorFlowWindowPermission");
        f4906d = m0.a().b(s0.a().b(10000), s0.a().b(200), new d(accessibilityService, j1.c().b()));
    }

    @SuppressLint({"NewApi"})
    public static AccessibilityNodeInfo i(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return null;
        }
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            if (accessibilityNodeInfo.getChild(i6) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i6).getClassName()) && accessibilityNodeInfo.getChild(i6).isScrollable()) {
                return accessibilityNodeInfo.getChild(i6);
            }
            if (accessibilityNodeInfo.getChild(i6) != null) {
                i(accessibilityNodeInfo.getChild(i6));
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static void j(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        j(accessibilityNodeInfo.getChild(i6));
                    }
                }
                return;
            }
            return;
        }
        String charSequence = accessibilityNodeInfo.getClassName().toString();
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int c6 = j4.c(HelpShopAppUtil.getContext());
        if (accessibilityNodeInfo.getText() != null) {
            c2.a(f4903a, accessibilityNodeInfo.getText().toString() + "      info.getBoundsInScreen=" + rect.toString());
            return;
        }
        if (accessibilityNodeInfo.getClassName() != null) {
            c2.a(f4903a, "--------------------");
            c2.a(f4903a, "width=" + c6);
            c2.a(f4903a, charSequence + "info.getBoundsInScreen=" + rect.toString());
        }
    }

    public static void k(AccessibilityService accessibilityService) {
        f4907e = null;
        f4906d = m0.a().b(s0.a().b(3000), s0.a().b(500), new i(accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        TimerTask timerTask = f4906d;
        if (timerTask != null) {
            timerTask.cancel();
            f4906d = null;
        }
        f4906d = m0.a().b(s0.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType), s0.a().b(100), new c(accessibilityService, j3.a().e("OpenPermissionName")));
    }

    public static void d(AccessibilityService accessibilityService) {
        f4906d = m0.a().b(s0.a().b(15000), s0.a().b(100), new h(accessibilityService, j1.c().b()));
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService, boolean z5) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        com.acse.ottn.b.c().a(s0.a().b(1000));
        if (z5) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            d(accessibilityService);
        }
    }

    public static void f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            if (accessibilityNodeInfo.getChild(i6) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i6).getClassName())) {
                c2.a(f4903a, "android.widget.ListView = " + accessibilityNodeInfo.getChild(i6).getChildCount());
                if (accessibilityNodeInfo.getChild(i6).getChildCount() > 0) {
                    f4908f = accessibilityNodeInfo.getChild(i6);
                }
            }
            if (accessibilityNodeInfo.getChild(i6) != null) {
                f(accessibilityNodeInfo.getChild(i6));
            }
        }
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService, boolean z5) {
        com.acse.ottn.b.c().a(s0.a().b(200));
        if (com.acse.ottn.b.c().h(accessibilityService, "应用启动管理") == null) {
            c2.a(f4903a, "clickOpenBatteryManage");
            return;
        }
        c2.a(f4903a, "找到");
        try {
            d(accessibilityService, z5);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void h(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                if (accessibilityNodeInfo.getChild(i6) != null) {
                    c2.a(f4903a, accessibilityNodeInfo.getChild(i6).toString());
                }
                if (accessibilityNodeInfo.getChild(i6) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i6).getClassName())) {
                    f4907e = accessibilityNodeInfo.getChild(i6);
                    return;
                } else {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        h(accessibilityNodeInfo.getChild(i6));
                    }
                }
            }
        }
    }

    public static boolean a(Context context) {
        return a(context, 24);
    }

    public static void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getParent() == null) {
            return;
        }
        AccessibilityNodeInfo a6 = com.acse.ottn.b.c().a(accessibilityNodeInfo.getParent(), "com.huawei.hms.ads:id/app_track_switch");
        c2.a("samon-->", a6.toString());
        if (a6.isChecked()) {
            return;
        }
        com.acse.ottn.b.c().g(a6);
    }

    public static void a(Activity activity, int i6) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (n3.f() == 3.1d) {
                activity.startActivityForResult(intent, i6);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e6) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            activity.startActivityForResult(intent2, i6);
            e6.printStackTrace();
            c2.b(f4903a, Log.getStackTraceString(e6));
        } catch (SecurityException e7) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            activity.startActivityForResult(intent3, i6);
            c2.b(f4903a, Log.getStackTraceString(e7));
        } catch (Exception e8) {
            c2.b(f4903a, Log.getStackTraceString(e8));
        }
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        e(accessibilityService.getRootInActiveWindow());
    }

    public static void i(AccessibilityService accessibilityService) {
        String b6 = j1.c().b();
        com.acse.ottn.b.c().a(1000L);
        f4906d = m0.a().b(s0.a().b(20000), s0.a().b(500), new b(accessibilityService, b6));
    }

    public static void c(AccessibilityService accessibilityService, boolean z5) {
        e(accessibilityService, z5);
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            c2.a("samon-->", accessibilityNodeInfo.toString());
        } else if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                e(accessibilityNodeInfo);
            }
        }
    }

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g6 = com.acse.ottn.b.c().g(accessibilityService, str);
        if (g6 == null || g6.getParent() == null) {
            return;
        }
        for (int i6 = 0; i6 < g6.getParent().getChildCount(); i6++) {
            c2.a("samon-->", g6.getParent().getClassName().toString());
            if (g6.getParent().getChild(i6) != null && "android.widget.Switch".equals(g6.getParent().getChild(i6).getClassName())) {
                if (g6.getParent().getChild(i6).isChecked()) {
                    return;
                }
                com.acse.ottn.b.c().g(g6.getParent().getChild(i6));
                return;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService, boolean z5) {
        c2.a(f4903a, "recycle 开始");
        f4906d = m0.a().b(s0.a().b(ErrorCode.UNKNOWN_ERROR), s0.a().b(100), new e(accessibilityService, j1.c().b(), z5));
    }

    public static void b(Activity activity) {
        Intent intent = new Intent();
        try {
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.HWSettings"));
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void j(AccessibilityService accessibilityService) {
        f4907e = null;
        f4906d = m0.a().b(s0.a().b(2000), s0.a().b(500), new j(accessibilityService));
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
            c2.b(f4903a, Log.getStackTraceString(e6));
            return false;
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j6, boolean z5) {
        if (j6 - f4905c.longValue() < 1000) {
            c2.a(f4903a, "间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            c2.a(f4903a, "间隔 time=" + f4905c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f4905c.longValue()));
            return;
        }
        c2.a(f4903a, "无间隔 t=" + j6 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        c2.a(f4903a, "无间隔 time=" + f4905c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f4905c.longValue()));
        TimerTask timerTask = f4906d;
        if (timerTask != null) {
            timerTask.cancel();
            f4906d = null;
        }
        f4905c = Long.valueOf(j6);
        f4906d = m0.a().b(s0.a().b(2000), s0.a().b(400), new a(accessibilityService, z5));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z5) {
        f4906d = m0.a().b(s0.a().b(ErrorCode.UNKNOWN_ERROR), s0.a().b(100), new f(accessibilityService));
    }

    public static void a(Activity activity) {
        ComponentName unflattenFromString;
        if (j3.a().e("OpenPermissionName").equals("权限管理")) {
            j3.a().a("background_battery_hignt", Boolean.TRUE);
        }
        int i6 = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        try {
            if (i6 >= 36) {
                unflattenFromString = new ComponentName("com.android.settings", "com.android.settings.HWSettings");
            } else if (i6 >= 28) {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
            } else if (i6 >= 26) {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity");
            } else if (i6 >= 23) {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
            } else {
                unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity");
            }
            intent.setComponent(unflattenFromString);
            activity.startActivity(intent);
        } catch (Exception e6) {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                c2.b(f4903a, e6.getMessage().toString());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        if (accessibilityNodeInfo != null) {
            int i6 = 0;
            while (true) {
                if (i6 >= accessibilityNodeInfo.getChildCount()) {
                    accessibilityNodeInfo2 = null;
                    break;
                }
                if (accessibilityNodeInfo.getChild(i6) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i6).getClassName()) && accessibilityNodeInfo.getChild(i6).getChildCount() > 0) {
                    accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i6);
                    break;
                } else {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        a(accessibilityService, accessibilityNodeInfo.getChild(i6));
                    }
                    i6++;
                }
            }
            if (accessibilityNodeInfo2 == null) {
                return;
            }
            f4906d = m0.a().b(s0.a().b(3000), s0.a().b(100), new g(accessibilityService, accessibilityNodeInfo2));
        }
    }
}
