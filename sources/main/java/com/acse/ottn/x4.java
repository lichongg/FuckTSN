package com.acse.ottn;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class x4 {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5501a = "isHuawei";

    /* renamed from: b, reason: collision with root package name */
    public static final String f5502b = "isXiaomi";

    /* renamed from: c, reason: collision with root package name */
    public static final String f5503c = "isOppo";

    /* renamed from: d, reason: collision with root package name */
    public static final String f5504d = "isVivo";

    /* renamed from: e, reason: collision with root package name */
    public static final String f5505e = "isMeizu";

    /* renamed from: f, reason: collision with root package name */
    public static final String f5506f = "isSamsung";

    /* renamed from: g, reason: collision with root package name */
    public static final String f5507g = "isLetv";

    /* renamed from: h, reason: collision with root package name */
    public static final String f5508h = "isSmartisan";

    /* renamed from: i, reason: collision with root package name */
    public static volatile x4 f5509i;

    public static x4 a() {
        if (f5509i == null) {
            synchronized (x4.class) {
                try {
                    if (f5509i == null) {
                        f5509i = new x4();
                    }
                } finally {
                }
            }
        }
        return f5509i;
    }

    public boolean b(String str) {
        boolean isIgnoringBatteryOptimizations;
        boolean isIgnoringBatteryOptimizations2;
        if ("".equals(str)) {
            return true;
        }
        if ("xiaomi".equals(j4.b()) || "redmi".equals(j4.b()) || "blackshark".equals(j4.b())) {
            return Build.VERSION.SDK_INT >= 36 ? j3.a().a("open_battery_white") : a(str);
        }
        if ("samsung".equals(j4.b())) {
            PowerManager powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
            if (powerManager != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    return false;
                }
                isIgnoringBatteryOptimizations2 = powerManager.isIgnoringBatteryOptimizations(str);
                return isIgnoringBatteryOptimizations2;
            }
        } else if ("oppo".equals(j4.b()) || "realme".equals(j4.b()) || "oneplus".equals(j4.b())) {
            boolean a6 = j3.a().a("open_battery_white");
            PowerManager powerManager2 = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
            if (powerManager2 != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    return a6;
                }
                isIgnoringBatteryOptimizations = powerManager2.isIgnoringBatteryOptimizations(str);
                return isIgnoringBatteryOptimizations || a6;
            }
        }
        return j3.a().a("open_battery_white");
    }

    @RequiresApi(api = 19)
    public boolean a(String str) {
        AppOpsManager appOpsManager = (AppOpsManager) HelpShopAppUtil.getContext().getSystemService("appops");
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, 10021, Integer.valueOf(Process.myUid()), str)).intValue() == 0;
        } catch (Exception unused) {
            return true;
        }
    }

    public void a(Activity activity, String str) {
        String b6 = j4.b();
        if (j3.a() != null) {
            j3.a().b(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, str);
            j3 a6 = j3.a();
            Boolean bool = Boolean.TRUE;
            a6.a("battery_white", bool);
            j3.a().a("open_battery_white", bool);
        }
        if (j1.c().e()) {
            if (!j3.a().a("open_battery_white_size")) {
                j3.a().a("open_battery_white_size", Boolean.TRUE);
                j3.a().a("open_battery_white", Boolean.FALSE);
            } else {
                l2.b().a("no_find_auto_start");
                j3.a().a("open_battery_white", Boolean.TRUE);
            }
            n1.a(activity);
            return;
        }
        if ("vivo".equals(b6)) {
            v4.b(activity);
            return;
        }
        if (!"oppo".equals(b6) && !"realme".equals(b6)) {
            if ("samsung".equals(b6)) {
                try {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse("package:" + str));
                    activity.startActivityForResult(intent, 10013);
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            }
            if (!"xiaomi".equals(b6) && !"redmi".equals(b6) && !"blackshark".equals(b6)) {
                if ("oneplus".equals(b6)) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456);
                    intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, str, null));
                    activity.startActivityForResult(intent2, 10013);
                    return;
                }
                c2.b("WhiteListPermission", "current phone is no open battery white");
                j3.a().a("open_battery_white", Boolean.TRUE);
                return;
            }
            if (j3.a() != null) {
                j3.a().b("OpenPermissionName", "后台弹出界面");
            }
            k2.b(activity);
            return;
        }
        d3.a(activity);
    }

    public boolean b() {
        PowerManager powerManager;
        if ("vivo".equals(j4.b())) {
            return j3.a().a("background_battery_hignt") || ((Build.VERSION.SDK_INT <= 23 || (powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power")) == null) ? false : powerManager.isIgnoringBatteryOptimizations(HelpShopAppUtil.getContext().getPackageName()));
        }
        return false;
    }
}
