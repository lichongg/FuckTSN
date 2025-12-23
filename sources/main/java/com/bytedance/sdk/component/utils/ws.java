package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ws {
    public static void j(az azVar) {
        ch.j(azVar);
    }

    public static boolean j(Context context) {
        return cw(context) != 0;
    }

    public static String ae(Context context) {
        int cw = cw(context);
        if (cw != 2) {
            if (cw != 3) {
                if (cw != 4) {
                    if (cw != 5) {
                        if (cw != 6) {
                            return "mobile";
                        }
                        return "5g";
                    }
                    return "4g";
                }
                return "wifi";
            }
            return "3g";
        }
        return "2g";
    }

    public static int cw(Context context) {
        return ch.j(context, 60000L);
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE);
    }

    public static boolean m(Context context) {
        if (cw(context) == 6) {
            return true;
        }
        return false;
    }

    public static boolean r(Context context) {
        if (cw(context) == 4) {
            return true;
        }
        return false;
    }

    public static boolean up(Context context) {
        if (cw(context) == 5) {
            return true;
        }
        return false;
    }

    public static int xt(Context context) {
        int cw = cw(context);
        if (cw != 1) {
            if (cw == 4) {
                return 1;
            }
            if (cw == 5) {
                return 4;
            }
            if (cw == 6) {
                return 6;
            }
            return cw;
        }
        return 0;
    }
}
