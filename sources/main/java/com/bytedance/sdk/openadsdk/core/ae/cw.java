package com.bytedance.sdk.openadsdk.core.ae;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.wq;
import org.json.JSONObject;
import s0.a;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static a f27949j;

    public static void cw(String str, String str2) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.r(str, str2);
    }

    public static void j(xt xtVar) {
        if (r() == null) {
            return;
        }
        j.j(xtVar);
    }

    private static a r() {
        if (f27949j == null) {
            f27949j = wq.j().up();
        }
        return f27949j;
    }

    public static void xt(String str, String str2) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.cw(str, str2);
    }

    public static void cw() {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.xt();
    }

    public static void j() {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.j();
    }

    public static void xt(String str, String str2, Throwable th) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.xt(str, str2, th);
    }

    public static void r(String str, String str2) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.up(str, str2);
    }

    public static void j(int i6) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.j(i6);
    }

    public static void xt() {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.cw();
    }

    public static void j(String str, String str2) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.xt(str, str2);
    }

    public static void j(String str, String str2, Throwable th) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.j(str, str2, th);
    }

    public static void j(String str, Throwable th) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.xt(str, th);
    }

    public static boolean j(Context context, JSONObject jSONObject) {
        a r5 = r();
        if (r5 == null) {
            return false;
        }
        r5.a(context, jSONObject);
        return true;
    }

    public static void j(Context context, String str, String str2) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.j(context, str, str2);
    }

    public static void j(String str) {
        a r5 = r();
        if (r5 == null) {
            return;
        }
        r5.j(str);
    }
}
