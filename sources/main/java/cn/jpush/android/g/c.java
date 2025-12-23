package cn.jpush.android.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class c {
    public static boolean a(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        PackageInfo packageInfo;
        String str2;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 4);
            str2 = packageInfo.sharedUserId;
        } catch (PackageManager.NameNotFoundException unused) {
            serviceInfoArr = null;
        }
        if (!str2.equals("android.uid.system")) {
            cn.jpush.android.i.b.e("ConnectionFactory", str + " is not system app,sharedUserId:" + str2);
            return false;
        }
        serviceInfoArr = packageInfo.services;
        if (serviceInfoArr == null) {
            cn.jpush.android.i.b.a("ConnectionFactory", "not found service by:" + str);
            return false;
        }
        for (int i6 = 0; i6 < serviceInfoArr.length; i6++) {
            cn.jpush.android.i.b.a("ConnectionFactory", "serviceInfos:" + serviceInfoArr[i6].name);
            if ("cn.jpush.android.service.PushManagerService".equalsIgnoreCase(serviceInfoArr[i6].name)) {
                return true;
            }
        }
        return false;
    }
}
