package com.bxkj.student.v2.ui.sports.safe;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import t.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.v2.ui.sports.safe.a$a, reason: collision with other inner class name */
    class C0295a implements b.a {
        @Override // t.b.a
        public void a() {
            j.c("requestQueryAllPackages->onSucceed");
        }

        @Override // t.b.a
        public void b(@NonNull String[] strings) {
            j.c("requestQueryAllPackages->onRejectAndNoAsk");
        }

        @Override // t.b.a
        public void c(@NonNull String[] strings) {
            j.c("requestQueryAllPackages->onReject");
        }

        C0295a() {
        }
    }

    public static List<String> c(Context context) {
        List<String> d6 = d(context, false);
        ArrayList arrayList = new ArrayList();
        for (String str : d6) {
            if (!f(context, str) && e(context, str, "android.permission.ACCESS_MOCK_LOCATION")) {
                arrayList.add(b(context, str));
            }
        }
        return arrayList;
    }

    public static List<String> d(Context context, boolean includeSystem) {
        ComponentName componentName;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        HashSet hashSet = new HashSet();
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = activityManager.getRunningAppProcesses().iterator();
            while (it.hasNext()) {
                hashSet.addAll(Arrays.asList(it.next().pkgList));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            Iterator<ActivityManager.RunningTaskInfo> it2 = activityManager.getRunningTasks(1000).iterator();
            while (it2.hasNext()) {
                componentName = it2.next().topActivity;
                hashSet.add(componentName.getPackageName());
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            Iterator<ActivityManager.RunningServiceInfo> it3 = activityManager.getRunningServices(1000).iterator();
            while (it3.hasNext()) {
                hashSet.add(it3.next().service.getPackageName());
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        return new ArrayList(hashSet);
    }

    public static void g(FragmentActivity activity) {
        if (Build.VERSION.SDK_INT >= 30) {
            new t.b(activity).c("android.permission.QUERY_ALL_PACKAGES", "android.permission.GET_INSTALLED_APPS").d(new C0295a());
        }
    }

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        int i6 = 0;
        for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
            try {
                String[] strArr = packageManager.getPackageInfo(applicationInfo.packageName, 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str : strArr) {
                        if (str.equals("android.permission.ACCESS_MOCK_LOCATION") && !applicationInfo.packageName.equals(context.getPackageName())) {
                            i6++;
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e6) {
                j.e("Got exception " + e6.getMessage(), new Object[0]);
            }
        }
        if (i6 <= 0) {
            return false;
        }
        return true;
    }

    public static String b(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128)).toString();
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return packageName;
        }
    }

    public static boolean e(Context context, String app, String permission) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(app, 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (str.equals(permission)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
        }
        return false;
    }

    public static boolean f(Context context, String app) {
        try {
            if ((context.getPackageManager().getPackageInfo(app, 0).applicationInfo.flags & 1) == 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return false;
        }
    }
}
