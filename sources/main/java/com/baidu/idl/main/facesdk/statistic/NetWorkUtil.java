package com.baidu.idl.main.facesdk.statistic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class NetWorkUtil {
    public static Integer getNetworkState(Context context) {
        NetworkInfo activeNetworkInfo;
        int i6 = 0;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            i6 = 1;
        } else if (type == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (subtype == 13 && !telephonyManager.isNetworkRoaming()) {
                i6 = 4;
            } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || (subtype == 15 && !telephonyManager.isNetworkRoaming())) {
                i6 = 3;
            } else if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || (subtype == 11 && !telephonyManager.isNetworkRoaming())) {
                i6 = 2;
            }
        } else if (type == 9) {
            i6 = 5;
        }
        return Integer.valueOf(i6);
    }
}
