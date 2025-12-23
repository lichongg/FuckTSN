package com.bxkj.student.run.app.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import com.bxkj.base.BaseApp;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: c, reason: collision with root package name */
    protected static final int f20229c = 98;

    /* renamed from: d, reason: collision with root package name */
    protected static final int f20230d = 99;

    /* renamed from: e, reason: collision with root package name */
    protected static final int f20231e = 100;

    /* renamed from: f, reason: collision with root package name */
    protected static final int f20232f = 101;

    /* renamed from: g, reason: collision with root package name */
    protected static final int f20233g = 102;

    /* renamed from: h, reason: collision with root package name */
    protected static final int f20234h = 103;

    /* renamed from: i, reason: collision with root package name */
    protected static final int f20235i = 104;

    /* renamed from: j, reason: collision with root package name */
    protected static final int f20236j = 105;

    /* renamed from: k, reason: collision with root package name */
    protected static final int f20237k = 106;

    /* renamed from: l, reason: collision with root package name */
    protected static final int f20238l = 107;

    /* renamed from: m, reason: collision with root package name */
    protected static final int f20239m = 108;

    /* renamed from: n, reason: collision with root package name */
    protected static final int f20240n = 109;

    /* renamed from: o, reason: collision with root package name */
    protected static final int f20241o = 110;

    /* renamed from: p, reason: collision with root package name */
    protected static final int f20242p = 111;

    /* renamed from: q, reason: collision with root package name */
    protected static final int f20243q = 112;

    /* renamed from: r, reason: collision with root package name */
    protected static final int f20244r = 113;

    /* renamed from: s, reason: collision with root package name */
    protected static final int f20245s = 114;

    /* renamed from: t, reason: collision with root package name */
    protected static final int f20246t = 115;

    /* renamed from: u, reason: collision with root package name */
    protected static final int f20247u = 116;

    /* renamed from: v, reason: collision with root package name */
    protected static final int f20248v = 117;

    /* renamed from: w, reason: collision with root package name */
    protected static List<j> f20249w;

    /* renamed from: x, reason: collision with root package name */
    protected static String f20250x;

    /* renamed from: a, reason: collision with root package name */
    protected Intent f20251a;

    /* renamed from: b, reason: collision with root package name */
    protected int f20252b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20254b;

        a(final Activity val$a) {
            this.f20254b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20254b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20256b;

        b(final Activity val$a) {
            this.f20256b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20256b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20258b;

        c(final Activity val$a) {
            this.f20258b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20258b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20260b;

        d(final Activity val$a) {
            this.f20260b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20260b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20262b;

        e(final Activity val$a) {
            this.f20262b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20262b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20264b;

        f(final Activity val$a) {
            this.f20264b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20264b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20266b;

        g(final Activity val$a) {
            this.f20266b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20266b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20268b;

        h(final Activity val$a) {
            this.f20268b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20268b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20270b;

        i(final Activity val$a) {
            this.f20270b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20270b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.run.app.utils.j$j, reason: collision with other inner class name */
    class DialogInterfaceOnClickListenerC0270j implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20272b;

        DialogInterfaceOnClickListenerC0270j(final Activity val$a) {
            this.f20272b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20272b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20274b;

        k(final Activity val$a) {
            this.f20274b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20274b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20276b;

        l(final Activity val$a) {
            this.f20276b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20276b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class m implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20278b;

        m(final Activity val$a) {
            this.f20278b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20278b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class n implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20280b;

        n(final Activity val$a) {
            this.f20280b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20280b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class o implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f20282b;

        o(final Activity val$a) {
            this.f20282b = val$a;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface d6, int w5) {
            j.this.e(this.f20282b);
        }
    }

    public static String b() {
        if (f20250x == null) {
            try {
                PackageManager packageManager = BaseApp.c().getPackageManager();
                f20250x = packageManager.getApplicationLabel(packageManager.getApplicationInfo(BaseApp.c().getPackageName(), 0)).toString();
            } catch (PackageManager.NameNotFoundException e6) {
                e6.printStackTrace();
                f20250x = BaseApp.c().getPackageName();
            }
        }
        return f20250x;
    }

    public static List<j> c() {
        boolean isIgnoringBatteryOptimizations;
        if (f20249w == null) {
            f20249w = new ArrayList();
            if (Build.VERSION.SDK_INT >= 24) {
                isIgnoringBatteryOptimizations = ((PowerManager) BaseApp.c().getSystemService("power")).isIgnoringBatteryOptimizations(BaseApp.c().getPackageName());
                if (!isIgnoringBatteryOptimizations) {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse("package:" + BaseApp.c().getPackageName()));
                    f20249w.add(new j(intent, 98));
                }
            }
            Intent intent2 = new Intent();
            intent2.setAction("huawei.intent.action.HSM_BOOTAPP_MANAGER");
            f20249w.add(new j(intent2, 99));
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
            f20249w.add(new j(intent3, 100));
            Intent intent4 = new Intent();
            intent4.setAction("miui.intent.action.OP_AUTO_START");
            intent4.addCategory("android.intent.category.DEFAULT");
            f20249w.add(new j(intent4, 101));
            Intent intent5 = new Intent();
            intent5.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
            intent5.putExtra(bi.f40972o, BaseApp.c().getPackageName());
            intent5.putExtra("package_label", b());
            f20249w.add(new j(intent5, 102));
            Intent launchIntentForPackage = BaseApp.c().getPackageManager().getLaunchIntentForPackage("com.samsung.android.sm");
            if (launchIntentForPackage != null) {
                f20249w.add(new j(launchIntentForPackage, 103));
            }
            Intent intent6 = new Intent();
            intent6.setComponent(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.battery.BatteryActivity"));
            f20249w.add(new j(intent6, 107));
            Intent intent7 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent7.addCategory("android.intent.category.DEFAULT");
            intent7.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, BaseApp.c().getPackageName());
            f20249w.add(new j(intent7, 104));
            Intent intent8 = new Intent();
            intent8.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.powerui.PowerAppPermissionActivity"));
            f20249w.add(new j(intent8, 105));
            Intent intent9 = new Intent();
            intent9.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
            f20249w.add(new j(intent9, 106));
            Intent intent10 = new Intent();
            intent10.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
            f20249w.add(new j(intent10, 108));
            Intent intent11 = new Intent();
            intent11.setComponent(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
            f20249w.add(new j(intent11, 109));
            Intent intent12 = new Intent();
            intent12.setComponent(new ComponentName("com.gionee.softmanager", "com.gionee.softmanager.MainActivity"));
            f20249w.add(new j(intent12, 110));
            Intent intent13 = new Intent();
            intent13.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
            f20249w.add(new j(intent13, 111));
            Intent intent14 = new Intent();
            intent14.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"));
            f20249w.add(new j(intent14, 112));
            Intent intent15 = new Intent();
            intent15.setComponent(new ComponentName("com.yulong.android.security", "com.yulong.android.seccenter.tabbarmain"));
            f20249w.add(new j(intent15, 113));
            Intent intent16 = new Intent();
            intent16.setComponent(new ComponentName("com.lenovo.security", "com.lenovo.security.purebackground.PureBackgroundActivity"));
            f20249w.add(new j(intent16, 114));
            Intent intent17 = new Intent();
            intent17.setComponent(new ComponentName("com.lenovo.powersetting", "com.lenovo.powersetting.ui.Settings$HighPowerApplicationsActivity"));
            f20249w.add(new j(intent17, 115));
            Intent intent18 = new Intent();
            intent18.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.autorun.AppAutoRunManager"));
            f20249w.add(new j(intent18, 116));
            Intent intent19 = new Intent();
            intent19.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.setting.ClearAppSettingsActivity"));
            f20249w.add(new j(intent19, 117));
        }
        return f20249w;
    }

    public static void d(Activity a6) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        a6.startActivity(intent);
    }

    @NonNull
    public static List<j> f(final Activity a6, String reason) {
        boolean isIgnoringBatteryOptimizations;
        ArrayList arrayList = new ArrayList();
        if (reason == null) {
            reason = "核心服务的持续运行";
        }
        for (j jVar : c()) {
            if (jVar.a()) {
                switch (jVar.f20252b) {
                    case 98:
                        if (Build.VERSION.SDK_INT >= 24) {
                            isIgnoringBatteryOptimizations = ((PowerManager) a6.getSystemService("power")).isIgnoringBatteryOptimizations(a6.getPackageName());
                            if (isIgnoringBatteryOptimizations) {
                                break;
                            } else {
                                new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要忽略 " + b() + " 的电池优化").setMessage(reason + "需要 " + b() + " 加入到电池优化的忽略名单。\n\n请点击『确定』，在弹出的『忽略电池优化』对话框中，选择『是』。").setPositiveButton("确定", jVar.new g(a6)).show();
                                arrayList.add(jVar);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 99:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 自动启动").setMessage(reason + "需要允许 " + b() + " 的自动启动。\n\n请点击『确定』，在弹出的『自启管理』中，将 " + b() + " 对应的开关打开。").setPositiveButton("确定", jVar.new h(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 100:
                    case 117:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle(b() + " 需要加入锁屏清理白名单").setMessage(reason + "需要 " + b() + " 加入到锁屏清理白名单。\n\n请点击『确定』，在弹出的『锁屏清理』列表中，将 " + b() + " 对应的开关打开。").setPositiveButton("确定", jVar.new i(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 101:
                    case 106:
                    case 108:
                    case 111:
                    case 116:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 的自启动").setMessage(reason + "需要 " + b() + " 加入到自启动白名单。\n\n请点击『确定』，在弹出的『自启动管理』中，将 " + b() + " 对应的开关打开。").setPositiveButton("确定", jVar.new o(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 102:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要关闭 " + b() + " 的神隐模式").setMessage(reason + "需要关闭 " + b() + " 的神隐模式。\n\n请点击『确定』，在弹出的 " + b() + " 神隐模式设置中，选择『无限制』").setPositiveButton("确定", jVar.new DialogInterfaceOnClickListenerC0270j(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 103:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 的自启动").setMessage(reason + "需要 " + b() + " 在屏幕关闭时继续运行。\n\n请点击『确定』，在弹出的『智能管理器』中，点击『内存』，选择『自启动应用程序』选项卡，将 " + b() + " 对应的开关打开。").setPositiveButton("确定", jVar.new k(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 104:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 保持后台运行").setMessage(reason + "需要允许 " + b() + " 保持后台运行。\n\n请点击『确定』，在弹出的应用信息界面中，将『后台管理』选项更改为『保持后台运行』。").setPositiveButton("确定", jVar.new m(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 105:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle(b() + " 需要在待机时保持运行").setMessage(reason + "需要 " + b() + " 在待机时保持运行。\n\n请点击『确定』，在弹出的『待机耗电管理』中，将 " + b() + " 对应的开关打开。").setPositiveButton("确定", jVar.new n(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 107:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 的自启动").setMessage(reason + "需要 " + b() + " 在屏幕关闭时继续运行。\n\n请点击『确定』，在弹出的『电池』页面中，点击『未监视的应用程序』->『添加应用程序』，勾选 " + b() + "，然后点击『完成』。").setPositiveButton("确定", jVar.new l(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 109:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 的后台运行").setMessage(reason + "需要允许 " + b() + " 在后台高耗电时运行。\n\n请点击『确定』，在弹出的『后台高耗电』中，将 " + b() + " 对应的开关打开。").setPositiveButton("确定", jVar.new b(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 110:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle(b() + " 需要加入应用自启和绿色后台白名单").setMessage(reason + "需要允许 " + b() + " 的自启动和后台运行。\n\n请点击『确定』，在弹出的『系统管家』中，分别找到『应用管理』->『应用自启』和『绿色后台』->『清理白名单』，将 " + b() + " 添加到白名单。").setPositiveButton("确定", jVar.new c(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 112:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要禁止 " + b() + " 被自动清理").setMessage(reason + "需要禁止 " + b() + " 被自动清理。\n\n请点击『确定』，在弹出的『应用保护』中，将 " + b() + " 对应的开关关闭。").setPositiveButton("确定", jVar.new d(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 113:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 的自启动").setMessage(reason + "需要允许 " + b() + " 的自启动。\n\n请点击『确定』，在弹出的『酷管家』中，找到『软件管理』->『自启动管理』，取消勾选 " + b() + "，将 " + b() + " 的状态改为『已允许』。").setPositiveButton("确定", jVar.new a(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 114:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要允许 " + b() + " 的后台运行").setMessage(reason + "需要允许 " + b() + " 的后台自启、后台 GPS 和后台运行。\n\n请点击『确定』，在弹出的『后台管理』中，分别找到『后台自启』、『后台 GPS』和『后台运行』，将 " + b() + " 对应的开关打开。").setPositiveButton("确定", jVar.new e(a6)).show();
                        arrayList.add(jVar);
                        break;
                    case 115:
                        new AlertDialog.Builder(a6).setCancelable(false).setTitle("需要关闭 " + b() + " 的后台耗电优化").setMessage(reason + "需要关闭 " + b() + " 的后台耗电优化。\n\n请点击『确定』，在弹出的『后台耗电优化』中，将 " + b() + " 对应的开关关闭。").setPositiveButton("确定", jVar.new f(a6)).show();
                        arrayList.add(jVar);
                        break;
                }
            }
        }
        return arrayList;
    }

    protected void e(Activity activityContext) {
        try {
            activityContext.startActivity(this.f20251a);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    protected j(Intent intent, int type) {
        this.f20251a = intent;
        this.f20252b = type;
    }

    protected boolean a() {
        List<ResolveInfo> queryIntentActivities = BaseApp.c().getPackageManager().queryIntentActivities(this.f20251a, 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            return true;
        }
        return false;
    }
}
