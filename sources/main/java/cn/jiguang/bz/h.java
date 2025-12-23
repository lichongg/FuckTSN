package cn.jiguang.bz;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.util.UUID;

/* loaded from: D:\Downloads\app\classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static int f2740a = 1;

    public static String a(Context context) {
        int i6;
        String b6 = b(context);
        if (w.h(b6)) {
            i6 = 3;
        } else {
            b6 = b(context, b6);
            if (w.h(b6)) {
                i6 = 1;
            } else {
                b6 = d(context);
                if (!w.h(b6)) {
                    String d6 = Build.VERSION.SDK_INT < 23 ? a.a().d(context, b6) : "";
                    String o5 = a.a().o(context);
                    String uuid = UUID.randomUUID().toString();
                    long currentTimeMillis = System.currentTimeMillis();
                    String d7 = w.d(d6 + o5 + uuid + currentTimeMillis);
                    if (TextUtils.isEmpty(d7)) {
                        d7 = uuid;
                    }
                    f2740a = 0;
                    new cn.jiguang.bn.c().b(d6).c(o5).d(uuid).a(currentTimeMillis).a(d7).a(context);
                    c(context, d7);
                    return d7;
                }
                i6 = 2;
            }
        }
        f2740a = i6;
        c(context, b6);
        return b6;
    }

    public static String b(Context context) {
        String str = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.b());
        if (!TextUtils.isEmpty(str)) {
            return v.b(str, cn.jiguang.a.a.f1451i);
        }
        String str2 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.a());
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    private static void c(Context context) {
        if (q.a(context, "android.permission.WRITE_SETTINGS")) {
            try {
                Settings.System.putString(context.getContentResolver(), "dig", "");
            } catch (Throwable unused) {
            }
        }
        if (!JConstants.isAndroidQ(context, true, "not write deviceId to SD") && q.a(context, com.kuaishou.weapon.p0.g.f36050j)) {
            try {
                String g6 = a.g(context);
                if (!TextUtils.isEmpty(g6)) {
                    j.b(new File(g6 + ".push_deviceid"));
                }
            } catch (Throwable unused2) {
            }
        }
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.a().a((cn.jiguang.e.a<String>) null)});
    }

    private static String d(Context context) {
        if (!JConstants.isAndroidQ(context, true, "do not get deviceId from SD") && q.a(context, com.kuaishou.weapon.p0.g.f36049i)) {
            String f6 = f(context, ".p");
            if (!TextUtils.isEmpty(f6)) {
                return v.b(f6, cn.jiguang.a.a.f1451i);
            }
            String f7 = f(context, ".push_deviceid");
            if (!TextUtils.isEmpty(f7)) {
                return f7;
            }
        }
        return null;
    }

    private static String e(Context context, String str) {
        if (JConstants.isAndroidQ(context, true, "not write deviceId to SD")) {
            return str;
        }
        if (!q.a(context, com.kuaishou.weapon.p0.g.f36050j)) {
            return null;
        }
        try {
            String g6 = a.g(context);
            if (TextUtils.isEmpty(g6)) {
                cn.jiguang.bb.f.l("DeviceIdUtils", "can't get sdcard data path");
                return null;
            }
            j.b(new File(g6 + ".p"), str);
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(Context context, String str, String str2) {
        try {
            return Settings.System.getString(context.getContentResolver(), str2);
        } catch (Throwable unused) {
            cn.jiguang.bb.f.l("DeviceIdUtils", "Can not read from settings");
            return str;
        }
    }

    private static String b(Context context, String str) {
        if (!q.a(context, "android.permission.WRITE_SETTINGS")) {
            return null;
        }
        String a6 = a(context, str, "dig_n");
        if (!TextUtils.isEmpty(a6)) {
            return v.b(a6, cn.jiguang.a.a.f1451i);
        }
        String a7 = a(context, str, "dig");
        if (TextUtils.isEmpty(a7)) {
            return null;
        }
        return a7;
    }

    private static void c(Context context, String str) {
        a(context, str, false);
    }

    private static String d(Context context, String str) {
        if (!q.a(context, "android.permission.WRITE_SETTINGS")) {
            return null;
        }
        try {
            if (Settings.System.putString(context.getContentResolver(), "dig_n", str)) {
                return str;
            }
            return null;
        } catch (Throwable unused) {
            cn.jiguang.bb.f.l("DeviceIdUtils", "Can not write settings");
            return null;
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, str, true);
    }

    private static String f(Context context, String str) {
        String g6 = a.g(context);
        if (!TextUtils.isEmpty(g6)) {
            String c6 = j.c(new File(g6 + str));
            if (c6 != null) {
                int indexOf = c6.indexOf(com.snail.antifake.deviceid.e.f37542d);
                if (indexOf < 0) {
                    return c6.trim();
                }
                return c6.substring(0, indexOf).trim();
            }
            return null;
        }
        cn.jiguang.bb.f.l("DeviceIdUtils", "can't get sdcard data path");
        return null;
    }

    private static void a(Context context, String str, boolean z5) {
        int i6;
        int i7;
        String a6 = v.a(str, cn.jiguang.a.a.f1451i);
        if (z5 || (i7 = f2740a) == 1 || i7 == 0) {
            d(context, a6);
        }
        if (z5 || (i6 = f2740a) == 2 || i6 == 0) {
            e(context, a6);
        }
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.b().a((cn.jiguang.e.a<String>) a6)});
        c(context);
    }
}
