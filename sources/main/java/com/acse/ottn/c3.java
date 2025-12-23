package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;
import com.alibaba.fastjson.parser.JSONLexer;
import io.netty.util.internal.StringUtil;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c3 {

    /* renamed from: a, reason: collision with root package name */
    public static c3 f4315a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4316b = "OpenMobilePermissionUtil";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4317a;

        public a(AccessibilityService accessibilityService) {
            this.f4317a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            v4.b(this.f4317a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static c3 a() {
        if (f4315a == null) {
            synchronized (c3.class) {
                try {
                    if (f4315a == null) {
                        f4315a = new c3();
                    }
                } finally {
                }
            }
        }
        return f4315a;
    }

    public final Object f() throws ObjectStreamException {
        return f4315a;
    }

    public boolean b() {
        if (!"huawei".equals(j4.b()) && !"honor".equals(j4.b()) && !"tdtech".equals(j4.b()) && !"tyh612m".equals(j4.p())) {
            return false;
        }
        return true;
    }

    public boolean c() {
        if (!"huawei".equals(j4.b()) && !"honor".equals(j4.b()) && !"oppo".equals(j4.b()) && !"vivo".equals(j4.b()) && !"xiaomi".equals(j4.b()) && !"redmi".equals(j4.b()) && !"realme".equals(j4.b()) && !"oneplus".equals(j4.b()) && !"blackshark".equals(j4.b()) && !"samsung".equals(j4.b())) {
            return false;
        }
        return true;
    }

    public boolean d() {
        if (!e() && !c()) {
            return false;
        }
        return true;
    }

    public boolean e() {
        if ("tyh612m".equals(j4.p())) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public boolean a(AccessibilityService accessibilityService, String str) {
        if (j3.a() == null) {
            return false;
        }
        str.getClass();
        char c6 = 65535;
        switch (str.hashCode()) {
            case -1837416467:
                if (str.equals("com.iqoo.powersaving.fuelgauge.PowerRankActivity")) {
                    c6 = 0;
                    break;
                }
                break;
            case -1736638048:
                if (str.equals("com.oplusos.securitypermission.permission.PermissionGroupsActivity")) {
                    c6 = 1;
                    break;
                }
                break;
            case -1697916220:
                if (str.equals("com.android.packageinstaller.permission.ui.AppPermissionActivity")) {
                    c6 = 2;
                    break;
                }
                break;
            case -1510049100:
                if (str.equals("android.app.Dialog")) {
                    c6 = 3;
                    break;
                }
                break;
            case -1508581269:
                if (str.equals("com.huawei.securitycenter.permission.ui.activity.PermissionSettingActivity")) {
                    c6 = 4;
                    break;
                }
                break;
            case -1504769691:
                if (str.equals("com.iqoo.powersaving.PowerSavingManagerActivity")) {
                    c6 = 5;
                    break;
                }
                break;
            case -1473395485:
                if (str.equals("com.miui.permcenter.autostart.AutoStartDetailManagementActivity")) {
                    c6 = 6;
                    break;
                }
                break;
            case -1213771616:
                if (str.equals("com.huawei.security.permission.ui.activity.PermissionSettingActivity")) {
                    c6 = 7;
                    break;
                }
                break;
            case -1180184559:
                if (str.equals("com.android.settings.HWSettings")) {
                    c6 = '\b';
                    break;
                }
                break;
            case -1150447007:
                if (str.equals("com.oplus.powermanager.fuelgaue.PowerControlActivity")) {
                    c6 = '\t';
                    break;
                }
                break;
            case -1138471325:
                if (str.equals("com.coloros.powermanager.fuelgaue.PowerControlActivity")) {
                    c6 = '\n';
                    break;
                }
                break;
            case -888547196:
                if (str.equals("com.android.settings.SubSettings")) {
                    c6 = 11;
                    break;
                }
                break;
            case -801027931:
                if (str.equals("com.hihonor.securitycenter.permission.ui.activity.MainActivity")) {
                    c6 = '\f';
                    break;
                }
                break;
            case -638199557:
                if (str.equals("com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case -520510470:
                if (str.equals("com.oplus.settings.feature.homepage.OplusSettingsHomepageActivity")) {
                    c6 = 14;
                    break;
                }
                break;
            case -347181517:
                if (str.equals("com.vivo.permissionmanager.activity.SoftPermissionDetailActivity")) {
                    c6 = 15;
                    break;
                }
                break;
            case -102088186:
                if (str.equals("com.coloros.securitypermission.permission.PermissionGroupsActivity")) {
                    c6 = 16;
                    break;
                }
                break;
            case -3605999:
                if (str.equals("com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")) {
                    c6 = 17;
                    break;
                }
                break;
            case 335974848:
                if (str.equals("com.android.settings.Settings$AppAndNotificationDashboardActivity")) {
                    c6 = 18;
                    break;
                }
                break;
            case 362914745:
                if (str.equals("com.hihonor.systemmanager.appcontrol.activity.StartupAppControlActivity")) {
                    c6 = 19;
                    break;
                }
                break;
            case 366917116:
                if (str.equals("com.android.permissioncontroller.permission.ui.ManagePermissionsActivity")) {
                    c6 = 20;
                    break;
                }
                break;
            case 408505592:
                if (str.equals("com.huawei.security.permission.ui.activity.MainActivity")) {
                    c6 = 21;
                    break;
                }
                break;
            case 626548678:
                if (str.equals("com.android.settings.applications.InstalledAppDetailsTop")) {
                    c6 = 22;
                    break;
                }
                break;
            case 688371313:
                if (str.equals("com.oplus.settings.OplusSettingsActivity$AppSettingsActivity")) {
                    c6 = 23;
                    break;
                }
                break;
            case 695606089:
                if (str.equals("com.android.permissioncontroller.permission.ui.GrantPermissionsActivity")) {
                    c6 = 24;
                    break;
                }
                break;
            case 844891404:
                if (str.equals("com.miui.permcenter.permissions.PermissionAppsModifyActivity")) {
                    c6 = 25;
                    break;
                }
                break;
            case 1064378975:
                if (str.equals("com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity")) {
                    c6 = JSONLexer.EOI;
                    break;
                }
                break;
            case 1157708154:
                if (str.equals("com.oplusos.floatwindow.sysfloatwindow.FloatWindowListActivity")) {
                    c6 = 27;
                    break;
                }
                break;
            case 1356567262:
                if (str.equals("com.vivo.permissionmanager.activity.BgStartUpManagerActivity")) {
                    c6 = 28;
                    break;
                }
                break;
            case 1388125120:
                if (str.equals("com.android.settings.Settings$OverlaySettingsActivity")) {
                    c6 = 29;
                    break;
                }
                break;
            case 1535820958:
                if (str.equals("com.miui.permcenter.permissions.PermissionsEditorActivity")) {
                    c6 = 30;
                    break;
                }
                break;
            case 1570829571:
                if (str.equals("com.iqoo.powersaving.activity.ExcessivePowerManagerActivity")) {
                    c6 = 31;
                    break;
                }
                break;
            case 1577225874:
                if (str.equals("com.oplusos.securitypermission.permission.ui.handheld.PermissionAppsActivityNew")) {
                    c6 = ' ';
                    break;
                }
                break;
            case 1647376138:
                if (str.equals("com.vivo.permissionmanager.activity.FloatWindowManagerActivity")) {
                    c6 = '!';
                    break;
                }
                break;
            case 1664890045:
                if (str.equals("com.miui.appmanager.ApplicationsDetailsActivity")) {
                    c6 = '\"';
                    break;
                }
                break;
            case 1722840595:
                if (str.equals("com.hihonor.securitycenter.permission.ui.activity.PermissionSettingActivity")) {
                    c6 = '#';
                    break;
                }
                break;
            case 1784217206:
                if (str.equals("com.miui.permcenter.settings.OtherPermissionsActivity")) {
                    c6 = kotlin.text.v0.f47959c;
                    break;
                }
                break;
            case 1799810893:
                if (str.equals("com.huawei.securitycenter.permission.ui.activity.MainActivity")) {
                    c6 = '%';
                    break;
                }
                break;
            case 1916443872:
                if (str.equals("com.coloros.floatwindow.sysfloatwindow.FloatWindowListActivity")) {
                    c6 = kotlin.text.v0.f47960d;
                    break;
                }
                break;
            case 2095881023:
                if (str.equals("com.android.settings.Settings$AppDrawOverlaySettingsActivity")) {
                    c6 = '\'';
                    break;
                }
                break;
            case 2141154850:
                if (str.equals("com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity")) {
                    c6 = '(';
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 5:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                v4.d(accessibilityService);
                return true;
            case 1:
            case 16:
            case 20:
                if ("samsung".equals(j4.b())) {
                    if (!j3.a().a("battery_white_samsung")) {
                        return true;
                    }
                } else if (!j3.a().a("battery_white")) {
                    return true;
                }
                c2.a(f4316b, "oppo location");
                d.d().e(accessibilityService);
                j3 a6 = j3.a();
                Boolean bool = Boolean.FALSE;
                a6.a("battery_white", bool);
                j3.a().a("battery_white_samsung", bool);
                if (!"realme".equals(j4.b()) && !"oppo".equals(j4.b()) && !"oneplus".equals(j4.b())) {
                    if (!"huawei".equals(j4.b()) && !"honor".equals(j4.b())) {
                        if ("samsung".equals(j4.b())) {
                            c2.a(f4316b, "samsungoppo location");
                            d.d().e(accessibilityService);
                            j3.a().a("battery_white", bool);
                            a2.d(accessibilityService);
                        }
                    } else {
                        com.acse.ottn.b.c().a(200L);
                        a2.b(accessibilityService);
                    }
                } else {
                    com.acse.ottn.b.c().a(200L);
                    a2.m(accessibilityService);
                }
                return true;
            case 2:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                a2.l(accessibilityService);
                return true;
            case 3:
                if (j3.a().a("battery_white") && "samsung".equals(j4.b())) {
                    d.d().e(accessibilityService);
                    j3.a().a("battery_white", Boolean.FALSE);
                    com.acse.ottn.b.c().a(100L);
                    AccessibilityNodeInfo h6 = com.acse.ottn.b.c().h(accessibilityService, "允许");
                    if (h6 != null) {
                        com.acse.ottn.b.c().g(h6);
                    }
                }
                return true;
            case 4:
            case 7:
            case '#':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3 a7 = j3.a();
                Boolean bool2 = Boolean.FALSE;
                a7.a("battery_white", bool2);
                if (j3.a().a("location_permission")) {
                    j3.a().a("location_permission", bool2);
                    a2.a(accessibilityService, false);
                } else {
                    n1.c(accessibilityService, false);
                }
                return true;
            case 6:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                k2.i(accessibilityService);
                return true;
            case '\b':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                j3.a().a("battery_white", Boolean.FALSE);
                n1.k(accessibilityService);
                return false;
            case '\t':
            case '\n':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                d3.a(accessibilityService, System.currentTimeMillis());
                return true;
            case 11:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                if (("redmi".equals(j4.b()) || "xiaomi".equals(j4.b())) && Build.VERSION.SDK_INT >= 30) {
                    k2.e(accessibilityService);
                } else if ("oneplus".equals(j4.b()) || "oppo".equals(j4.b()) || "realme".equals(j4.b())) {
                    if (!com.acse.ottn.b.c().a()) {
                        a3.c(accessibilityService);
                    } else if (Build.VERSION.SDK_INT >= 35) {
                        d3.f(accessibilityService);
                    }
                }
                return true;
            case '\f':
            case 21:
            case '%':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3 a8 = j3.a();
                Boolean bool3 = Boolean.FALSE;
                a8.a("battery_white", bool3);
                if (j3.a().a("location_permission")) {
                    com.acse.ottn.b.c().a(100L);
                    j3.a().a("location_permission", bool3);
                    a2.a(accessibilityService, true);
                } else {
                    n1.c(accessibilityService, true);
                }
                return true;
            case '\r':
            case 17:
            case 19:
                c2.a(n1.f4903a, "find");
                if (!j3.a().a("battery_white")) {
                    c2.a(n1.f4903a, "battery_white is false");
                    return true;
                }
                c2.a(n1.f4903a, "battery_white is true =SystemUtil.getDeviceBrand()=" + j4.b());
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                if (b()) {
                    c2.a(n1.f4903a, "ok");
                    n1.b(accessibilityService, true);
                }
                return true;
            case 14:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                j3.a().a("battery_white", Boolean.FALSE);
                d3.k(accessibilityService);
                return true;
            case 15:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3 a9 = j3.a();
                Boolean bool4 = Boolean.FALSE;
                a9.a("battery_white", bool4);
                if (j3.a().a("location_permission")) {
                    j3.a().a("location_permission", bool4);
                    com.acse.ottn.b.c().a(200L);
                    a2.g(accessibilityService);
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new a(accessibilityService), 200L);
                }
                return true;
            case 18:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3 a10 = j3.a();
                Boolean bool5 = Boolean.FALSE;
                a10.a("battery_white", bool5);
                if (b()) {
                    if (j3.a().a("location_permission")) {
                        j3.a().a("location_permission", bool5);
                        a2.e(accessibilityService);
                    } else {
                        n1.c(accessibilityService);
                    }
                }
                return true;
            case 22:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3 a11 = j3.a();
                Boolean bool6 = Boolean.FALSE;
                a11.a("battery_white", bool6);
                if ("oppo".equals(j4.b()) || "realme".equals(j4.b()) || "oneplus".equals(j4.b())) {
                    if (j3.a().a("location_permission")) {
                        j3.a().a("location_permission", bool6);
                        com.acse.ottn.b.c().a(300L);
                        a2.k(accessibilityService);
                    } else {
                        d3.d(accessibilityService);
                    }
                }
                return true;
            case 23:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                if (Build.VERSION.SDK_INT >= 35) {
                    d3.f(accessibilityService);
                    break;
                }
                break;
            case 24:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                a2.c(accessibilityService);
                return true;
            case 25:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                a2.a(accessibilityService, System.currentTimeMillis());
                return true;
            case 26:
            case 31:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                c2.a(f4316b, "clickServiceBackgroundHight init");
                j3.a().a("battery_white", Boolean.FALSE);
                d.d().e(accessibilityService);
                com.acse.ottn.b.c().a(200L);
                v4.a(accessibilityService, System.currentTimeMillis());
                return true;
            case 27:
            case '&':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                if ((!"realme".equals(j4.b()) && !"oppo".equals(j4.b()) && !"oneplus".equals(j4.b())) || com.acse.ottn.b.c().f()) {
                    return true;
                }
                d3.i(accessibilityService);
                return true;
            case 28:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                v4.a(accessibilityService, true);
                return true;
            case 29:
                if (!j3.a().a("battery_white")) {
                    c2.a(f4316b, "settings.Settings$OverlaySettingsActivity is fasle");
                    return true;
                }
                c2.a(f4316b, "settings.Settings$OverlaySettingsActivity is fasle");
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                if (!"redmi".equals(j4.b()) && !"xiaomi".equals(j4.b()) && !"blackshark".equals(j4.b())) {
                    if ("oneplus".equals(j4.b())) {
                        c2.a(f4316b, "settings.Settings$OverlaySettingsActivity is oneplus");
                        com.acse.ottn.b.c().a(true);
                        a3.f(accessibilityService);
                        return true;
                    }
                    if ("samsung".equals(j4.b())) {
                        c2.a(f4316b, "settings.Settings$OverlaySettingsActivity is samsung");
                        com.acse.ottn.b.c().a(true);
                        u3.e(accessibilityService);
                        return true;
                    }
                    if (!"oppo".equals(j4.b()) && !"realme".equals(j4.b())) {
                        if (b()) {
                            c2.a(f4316b, "settings.Settings$OverlaySettingsActivity is huawei");
                            com.acse.ottn.b.c().a(true);
                            n1.h(accessibilityService);
                        }
                    } else if (Build.VERSION.SDK_INT >= 33) {
                        c2.a(f4316b, "settings.Settings$OverlaySettingsActivity is oppo");
                        com.acse.ottn.b.c().a(true);
                        a3.f(accessibilityService);
                    }
                    return true;
                }
                c2.a(f4316b, "settings.Settings$OverlaySettingsActivity is xiaomi");
                j3.a().a("battery_white", Boolean.TRUE);
                com.acse.ottn.b.c().a(true);
                k2.j(accessibilityService);
                return true;
            case 30:
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3 a12 = j3.a();
                Boolean bool7 = Boolean.FALSE;
                a12.a("battery_white", bool7);
                c2.a(f4316b, "clickHouTaiShowPage倒计时 =3" + j3.a().a("location_permission"));
                if (j3.a().a("location_permission")) {
                    j3.a().a("location_permission", bool7);
                    a2.h(accessibilityService);
                } else {
                    c2.a(f4316b, "clickHouTaiShowPage倒计时 =1");
                    k2.d(accessibilityService);
                }
                return true;
            case ' ':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                if ((!"realme".equals(j4.b()) && !"oppo".equals(j4.b()) && !"oneplus".equals(j4.b())) || com.acse.ottn.b.c().f()) {
                    return true;
                }
                d3.h(accessibilityService);
                return true;
            case '!':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                v4.a(accessibilityService, false);
                return true;
            case '\"':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                com.acse.ottn.b.c().a(300L);
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                k2.b("自启动", accessibilityService);
                return true;
            case '$':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                c2.a(f4316b, "clickHouTaiShowPage倒计时 =2");
                k2.d(accessibilityService);
                return true;
            case '\'':
                break;
            case '(':
                if (!j3.a().a("battery_white")) {
                    return true;
                }
                d.d().e(accessibilityService);
                j3.a().a("battery_white", Boolean.FALSE);
                if ((!"oppo".equals(j4.b()) && !"realme".equals(j4.b())) || com.acse.ottn.b.c().f()) {
                    return true;
                }
                d3.j(accessibilityService);
                return true;
            default:
                return false;
        }
        c2.a(f4316b, "current phone is " + j4.b());
        if (!j3.a().a("battery_white")) {
            return true;
        }
        d.d().e(accessibilityService);
        j3.a().a("battery_white", Boolean.FALSE);
        if (b()) {
            n1.a(accessibilityService, System.currentTimeMillis(), false);
        } else if ("vivo".equals(j4.b())) {
            v4.c(accessibilityService);
        } else if (!"redmi".equals(j4.b()) && !"xiaomi".equals(j4.b()) && !"blackshark".equals(j4.b())) {
            if ("oneplus".equals(j4.b())) {
                a3.c(accessibilityService);
            }
        } else {
            k2.e(accessibilityService);
        }
        return true;
    }

    public final void a(Service service) {
        new Handler(Looper.getMainLooper()).post(new b());
    }
}
