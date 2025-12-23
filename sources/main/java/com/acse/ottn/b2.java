package com.acse.ottn;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import com.acse.ottn.util.HelpShopAppUtil;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.common.SocializeConstants;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b2 {

    /* renamed from: c, reason: collision with root package name */
    public static b2 f4241c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f4242d = "acse_LocationRequsesPermissionUtil";

    /* renamed from: a, reason: collision with root package name */
    public LocationManager f4243a;

    /* renamed from: b, reason: collision with root package name */
    public LocationListener f4244b = new b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b2 b2Var = b2.this;
            LocationManager locationManager = b2Var.f4243a;
            if (locationManager != null) {
                locationManager.removeUpdates(b2Var.f4244b);
                b2.this.f4243a = null;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(@NonNull Location location) {
            b2 b2Var = b2.this;
            LocationManager locationManager = b2Var.f4243a;
            if (locationManager != null) {
                locationManager.removeUpdates(b2Var.f4244b);
                b2.this.f4243a = null;
            }
            String a6 = b2.this.a(location.getLongitude());
            String a7 = b2.this.a(location.getLatitude());
            j3.a().b("longitude", a7);
            j3.a().b("latitude", a6);
            c2.a("liuqiang-->", a7 + Logger.f33116c + a6);
            l4.a().b(6, "获取到定位", " lat + lon=" + a6 + a7);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(@NonNull String str) {
            l4.a().b(6, "获取到定位", "定位结束");
            c2.a("liuqiang-->", "定位结束");
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(@NonNull String str) {
            l4.a().b(6, "获取到定位", "定位完成");
            c2.a("liuqiang-->", "定位完成");
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i6, Bundle bundle) {
            l4.a().b(6, "获取到定位", "位置变化");
            c2.a("liuqiang-->", "位置变化");
        }
    }

    public final Object b() throws ObjectStreamException {
        return f4241c;
    }

    public void c(Context context) {
        int checkSelfPermission;
        int checkSelfPermission2;
        if (Build.VERSION.SDK_INT >= 23) {
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36048h);
            if (checkSelfPermission == 0) {
                checkSelfPermission2 = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36047g);
                if (checkSelfPermission2 == 0) {
                    return;
                }
            }
            ActivityCompat.requestPermissions((Activity) context, new String[]{com.kuaishou.weapon.p0.g.f36047g, com.kuaishou.weapon.p0.g.f36048h}, 1000);
        }
    }

    public boolean b(Context context) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        checkSelfPermission = context.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION");
        return checkSelfPermission == 0;
    }

    public void d(Activity activity) {
        Intent intent = new Intent();
        try {
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.HWSettings"));
            activity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final void g(Activity activity) {
        if ("".equals(k0.f4687w)) {
            return;
        }
        Intent intent = new Intent();
        j3 a6 = j3.a();
        Boolean bool = Boolean.TRUE;
        a6.a("location_permission", bool);
        j3.a().a("battery_white", bool);
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, k0.f4687w);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10010);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, k0.f4687w, null));
                activity.startActivityForResult(intent2, 10010);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra(Constants.PARAM_PKG_NAME, k0.f4687w);
            intent.putExtra("app_name", j1.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivityForResult(intent, 10010);
        }
    }

    public final void h(Activity activity) {
        j3 a6 = j3.a();
        Boolean bool = Boolean.TRUE;
        a6.a("battery_white", bool);
        j3.a().b("location_permission_state", "2");
        try {
            j3.a().a("location_permission", bool);
            Intent intent = new Intent();
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.putExtra("packagename", k0.f4687w);
            intent.putExtra("tabId", "1");
            activity.startActivityForResult(intent, 10010);
        } catch (Exception unused) {
            j3.a().a("location_permission", Boolean.FALSE);
        }
    }

    public static b2 a() {
        if (f4241c == null) {
            synchronized (b2.class) {
                try {
                    if (f4241c == null) {
                        f4241c = new b2();
                    }
                } finally {
                }
            }
        }
        return f4241c;
    }

    public static void e(Activity activity) {
        ComponentName unflattenFromString;
        j3.a().b("OpenPermissionName", "权限管理");
        j3 a6 = j3.a();
        Boolean bool = Boolean.TRUE;
        a6.a("battery_white", bool);
        j3.a().a("location_permission", bool);
        int i6 = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        try {
            try {
                if (i6 >= 28) {
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
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
            activity.startActivityForResult(intent, 10010);
        }
    }

    public void f(Activity activity) {
        String b6 = j4.b();
        if (j1.c().e()) {
            e(activity);
            return;
        }
        if ("vivo".equals(b6)) {
            h(activity);
            return;
        }
        if (!"oppo".equals(b6) && !"realme".equals(b6)) {
            if (!"xiaomi".equals(b6) && !"redmi".equals(b6) && !"blackshark".equals(b6)) {
                if ("oneplus".equals(b6)) {
                    g(activity);
                    return;
                }
                int c6 = j3.a().c("location_permission_size");
                if (c6 == 1) {
                    j3.a().a("location_permission_size", 2);
                    a().c(activity);
                } else if (c6 == 2) {
                    j3.a().a("location_permission_size", 3);
                }
                a().b(activity);
                return;
            }
            i(activity);
            return;
        }
        g(activity);
    }

    public final void i(Activity activity) {
        j3 a6 = j3.a();
        Boolean bool = Boolean.TRUE;
        a6.a("location_permission", bool);
        j3.a().a("battery_white", bool);
        j3.a().b("location_permission_state", "2");
        try {
            if (!j4.b().equals("xiaomi") && !j4.b().equals("redmi") && !j4.b().equals("blackshark")) {
                return;
            }
            j3.a().b("OpenPermissionName", "定位");
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", activity.getPackageName());
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            activity.startActivityForResult(intent, 10010);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent2.setData(Uri.parse("package:" + activity.getPackageName()));
            j3.a().a("battery_white", Boolean.TRUE);
            activity.startActivityForResult(intent2, 10010);
        }
    }

    public void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            j3.a().b("location_permission_state", "2");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1000);
        }
    }

    public void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            j3.a().b("location_permission_state", "1");
            ActivityCompat.requestPermissions(activity, new String[]{com.kuaishou.weapon.p0.g.f36047g, com.kuaishou.weapon.p0.g.f36048h}, PointerIconCompat.TYPE_ZOOM_IN);
        }
    }

    public void c() {
        String str;
        if (HelpShopAppUtil.getContext() != null && a("request_startLocation", 10000)) {
            l4.a().b(4, "开始定位", " 0000");
            c2.a("liuqiang-->", "开始定位=");
            this.f4243a = (LocationManager) HelpShopAppUtil.getContext().getSystemService(SocializeConstants.KEY_LOCATION);
            boolean z5 = ContextCompat.checkSelfPermission(HelpShopAppUtil.getContext(), com.kuaishou.weapon.p0.g.f36047g) == 0;
            boolean z6 = ContextCompat.checkSelfPermission(HelpShopAppUtil.getContext(), com.kuaishou.weapon.p0.g.f36048h) == 0;
            if (z5) {
                str = "1";
            } else if (z6) {
                str = "2";
            } else {
                str = "3";
            }
            j3.a().b("location_state", str);
            if (z5 || z6) {
                this.f4243a.requestLocationUpdates("network", 0L, 0.0f, this.f4244b);
                new Handler().postDelayed(new a(), 5000L);
            }
        }
    }

    public boolean a(Context context) {
        int checkSelfPermission;
        int checkSelfPermission2;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36048h);
        if (checkSelfPermission != 0) {
            return false;
        }
        checkSelfPermission2 = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36047g);
        return checkSelfPermission2 == 0;
    }

    public void a(Activity activity) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT >= 23) {
            checkSelfPermission = activity.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION");
            if (checkSelfPermission == 0) {
                return;
            }
            j3.a().a("battery_white", Boolean.TRUE);
            j3.a().b("location_permission_state", "2");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 10019);
        }
    }

    public final boolean a(String str, int i6) {
        if (i6 == 0) {
            i6 = 500;
        }
        long d6 = j3.a().d("coupon_" + str);
        c2.a(f4242d, "controlCouponShow appPageName =" + str + "-----" + (System.currentTimeMillis() - d6));
        if (System.currentTimeMillis() - d6 < i6) {
            c2.a(f4242d, "controlCouponShow return false ");
            return false;
        }
        j3.a().a("coupon_" + str, System.currentTimeMillis());
        c2.a(f4242d, "controlCouponShow return true");
        return true;
    }

    public final String a(double d6) {
        String str;
        double abs = Math.abs(d6);
        String replace = String.valueOf(Double.valueOf(abs)).replace(".", "");
        if (abs >= 100.0d) {
            str = "3";
        } else if (abs < 10.0d) {
            str = abs > 1.0d ? "1" : "0";
        } else {
            str = "2";
        }
        if (d6 > 0.0d) {
            return "1" + str + replace;
        }
        return "0" + str + replace;
    }
}
