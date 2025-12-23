package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class au {
    private static Map<String, Integer> baa;
    private static Set<String> bab;
    private static Method bac;

    public static boolean dk(Context context) {
        int i6;
        try {
            i6 = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i6 = 0;
        }
        return i6 == 1;
    }

    static {
        HashSet hashSet = new HashSet();
        bab = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        bab.add("android.permission.WRITE_SETTINGS");
        bab.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int at(Context context, String str) {
        int au;
        if (baa == null) {
            h(y.cN(context));
        }
        if (bab.contains(str) && (au = au(context, str)) != -2) {
            return au;
        }
        int av = av(context, str);
        if (av == -2) {
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable unused) {
            }
        }
        return av;
    }

    private static int av(Context context, String str) {
        if (baa == null || str == null || !baa.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = baa.get(str);
            if (num == null) {
                return -2;
            }
            if (bac == null) {
                Class cls = Integer.TYPE;
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class);
                bac = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) bac.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
            return 0;
        }
    }

    private static void h(String[] strArr) {
        if (strArr == null) {
            return;
        }
        baa = new HashMap();
        for (String str : strArr) {
            try {
                Integer num = (Integer) z.c(AppOpsManager.class, "OP_" + hg(str));
                if (num.intValue() >= 0) {
                    baa.put(str, num);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String hg(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int au(Context context, String str) {
        char c6;
        boolean canWrite;
        boolean canDrawOverlays;
        str.getClass();
        switch (str.hashCode()) {
            case -2078357533:
                if (str.equals("android.permission.WRITE_SETTINGS")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -1561629405:
                if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case 1777263169:
                if (str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        switch (c6) {
            case 0:
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        canWrite = Settings.System.canWrite(context);
                        if (!canWrite) {
                            return -1;
                        }
                        return 0;
                    } catch (Throwable unused) {
                        return -2;
                    }
                }
                return -2;
            case 1:
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        canDrawOverlays = Settings.canDrawOverlays(context);
                        if (!canDrawOverlays) {
                            return -1;
                        }
                        return 0;
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        return -2;
                    }
                }
                return -2;
            case 2:
                if (Build.VERSION.SDK_INT >= 26) {
                    if (!y.cM(context)) {
                        return -1;
                    }
                    return 0;
                }
                return -2;
            default:
                return -2;
        }
    }
}
