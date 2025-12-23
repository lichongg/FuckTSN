package com.bytedance.sdk.component.tl.xt.cw;

import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.r;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private static up cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.bytedance.sdk.component.tl.xt.j.up(str);
    }

    private static boolean j(String str) {
        r r5;
        up cw = cw(str);
        if (cw == null || (r5 = cw.r()) == null) {
            return false;
        }
        return r5.j();
    }

    private static String xt(String str) {
        r r5;
        up cw = cw(str);
        if (cw == null || (r5 = cw.r()) == null) {
            return null;
        }
        return r5.xt();
    }

    public static void r(String str, up upVar) {
        if (upVar == null) {
            return;
        }
        j(null, str, upVar.up(), 100);
    }

    public static void cw(String str, up upVar) {
        if (upVar == null) {
            return;
        }
        j(null, str, upVar.up(), 6);
    }

    public static void cw(String str, String str2, up upVar) {
        if (upVar == null) {
            return;
        }
        j(str, str2, upVar.up(), 6);
    }

    public static void j(String str, up upVar) {
        if (upVar == null) {
            return;
        }
        j(null, str, upVar.up(), 4);
    }

    public static void xt(String str, up upVar) {
        if (upVar == null) {
            return;
        }
        j(null, str, upVar.up(), 5);
    }

    public static void j(String str, String str2, up upVar) {
        if (upVar == null) {
            return;
        }
        j(str, str2, upVar.up(), 4);
    }

    public static void xt(String str, String str2, up upVar) {
        if (upVar == null) {
            return;
        }
        j(str, str2, upVar.up(), 5);
    }

    public static void j(String str, String str2, String str3) {
        j(str, str2, str3, 4);
    }

    private static void j(String str, String str2, String str3, int i6) {
        try {
            if (j(str3) || i6 == 100) {
                String xt = xt(str3);
                if (xt == null) {
                    xt = "";
                }
                String str4 = xt + "log";
                if (!TextUtils.isEmpty(str)) {
                    str4 = str4 + str;
                }
                if (i6 == 4) {
                    vl.j(str4, str2);
                    return;
                }
                if (i6 == 5) {
                    vl.xt(str4, str2);
                } else if (i6 == 6 || i6 == 100) {
                    vl.r(str4, str2);
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }
}
