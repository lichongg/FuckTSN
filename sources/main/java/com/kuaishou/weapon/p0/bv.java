package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: D:\Downloads\app\classes6.dex */
public class bv {
    public static int c(Context context) {
        int i6 = -1;
        try {
            int intExtra = d(context).getIntExtra("health", -1);
            i6 = 3;
            if (intExtra != 2) {
                if (intExtra == 3) {
                    return 4;
                }
                if (intExtra == 4) {
                    return 2;
                }
                if (intExtra != 5) {
                    return intExtra != 7 ? 6 : 1;
                }
                return 5;
            }
        } catch (Throwable unused) {
        }
        return i6;
    }

    private static Intent d(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public static String a(Context context) {
        int i6;
        try {
            if (d(context) != null) {
                i6 = (int) ((r3.getIntExtra("level", -1) / r3.getIntExtra("scale", -1)) * 100.0f);
            } else {
                i6 = 0;
            }
            return i6 + "%";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            int intExtra = d(context).getIntExtra("plugged", -1);
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra != 4) {
                        return "";
                    }
                    return "Wireless charger";
                }
                return "USB charger";
            }
            return "AC charger";
        } catch (Throwable unused) {
            return null;
        }
    }
}
