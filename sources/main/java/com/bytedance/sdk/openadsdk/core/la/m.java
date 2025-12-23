package com.bytedance.sdk.openadsdk.core.la;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    public static int j(Context context, boolean z5) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Throwable th) {
            vl.j(th);
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            if (type != 1) {
                return type == 0 ? 1 : 0;
            }
            if (com.bytedance.sdk.openadsdk.core.x.up.j().j(context, "android.permission.CHANGE_NETWORK_STATE") && z5) {
                return j(connectivityManager) ? 3 : 2;
            }
            return 2;
        }
        return 0;
    }

    private static boolean j(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", null);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, null)).booleanValue();
        } catch (Throwable th) {
            vl.r("transmit_TelephonyUtils", "isMobileEnabled error:" + th.getMessage());
            return false;
        }
    }

    public static boolean j(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null || 1 != telephonyManager.getSimState();
    }
}
