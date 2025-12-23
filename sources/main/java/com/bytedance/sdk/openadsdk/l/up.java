package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.az;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements az {
    private static boolean xt(Context context, TelephonyManager telephonyManager) {
        int checkSelfPermission;
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29) {
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f36043c);
            if (checkSelfPermission == 0) {
                try {
                    int j6 = j();
                    if (j6 == -1) {
                        serviceState = telephonyManager.getServiceState();
                    } else {
                        Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(j6));
                    }
                    return j(serviceState);
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.utils.az
    public boolean j(Context context, TelephonyManager telephonyManager) {
        return xt(context, telephonyManager);
    }

    private static int j() {
        int defaultDataSubscriptionId;
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        return defaultDataSubscriptionId;
    }

    private static boolean j(ServiceState serviceState) {
        try {
            Method method = serviceState.getClass().getMethod("getNrState", null);
            if (method != null) {
                method.setAccessible(true);
                int intValue = ((Integer) method.invoke(serviceState, null)).intValue();
                return intValue == 3 || intValue == 2;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
