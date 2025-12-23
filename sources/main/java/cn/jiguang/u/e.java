package cn.jiguang.u;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import cn.jiguang.bz.w;
import cn.jiguang.q.d;
import com.acse.ottn.j4;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f3281a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f3282b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f3283c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f3284d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f3285e = "";

    /* renamed from: f, reason: collision with root package name */
    private static String f3286f = "";

    /* renamed from: g, reason: collision with root package name */
    private static String f3287g = "";

    /* renamed from: h, reason: collision with root package name */
    private static String f3288h = "";

    public static String a(final Context context) {
        try {
            Object b6 = cn.jiguang.q.d.b(context, PointerIconCompat.TYPE_ZOOM_OUT, 1800000L, 259200000L, new d.a() { // from class: cn.jiguang.u.e.1
                @Override // cn.jiguang.q.d.b
                public Object a() {
                    String B = cn.jiguang.bz.a.a().B(context);
                    if (TextUtils.isEmpty(B)) {
                        return "";
                    }
                    String lowerCase = B.toLowerCase();
                    if (lowerCase.contains("huawei")) {
                        return e.k();
                    }
                    if (lowerCase.contains("honor")) {
                        return e.i();
                    }
                    if (lowerCase.contains("xiaomi") || lowerCase.contains("blackshark")) {
                        return e.o();
                    }
                    if (lowerCase.contains("meizu")) {
                        return e.n();
                    }
                    if (lowerCase.contains("oppo") || lowerCase.contains("realme")) {
                        f.c("JRomVersionHelper", " getMethodValue getOppoVersion  ");
                        return e.m();
                    }
                    if (lowerCase.contains("vivo")) {
                        return e.l();
                    }
                    if (lowerCase.contains("oneplus")) {
                        return e.p();
                    }
                    return null;
                }

                @Override // cn.jiguang.q.d.b
                public void a(Object obj) {
                    if (obj instanceof String) {
                        String unused = e.f3281a = (String) obj;
                    }
                }

                @Override // cn.jiguang.q.d.b
                public Object c() {
                    return e.f3281a;
                }
            });
            if (b6 instanceof String) {
                f3281a = (String) b6;
            }
        } catch (Throwable unused) {
        }
        return f3281a;
    }

    private static String b(String str) {
        return w.m(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i() {
        if (!TextUtils.isEmpty(f3288h)) {
            return f3288h;
        }
        String b6 = b("ro.build.display.id");
        f3288h = b6;
        return b6;
    }

    private static boolean j() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return j4.f4664a.equalsIgnoreCase((String) cls.getMethod("getOsBrand", null).invoke(cls, null));
        } catch (Throwable th) {
            f.c("JRomVersionHelper", "isHarmonyOS throwable=" + th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k() {
        String str;
        if (!TextUtils.isEmpty(f3282b)) {
            return f3282b;
        }
        if (j()) {
            f3282b = b("hw_sc.build.platform.version");
        }
        if (TextUtils.isEmpty(f3282b)) {
            str = b("ro.build.version.emui");
        } else {
            str = "harmony_os_" + f3282b;
        }
        f3282b = str;
        return f3282b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l() {
        if (!TextUtils.isEmpty(f3284d)) {
            return f3284d;
        }
        String b6 = b("ro.vivo.os.build.display.id");
        f3284d = b6;
        return b6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String m() {
        if (!TextUtils.isEmpty(f3283c)) {
            return f3283c;
        }
        String b6 = b("ro.build.version.oplusrom");
        f3283c = b6;
        if (TextUtils.isEmpty(b6)) {
            f3283c = b("ro.build.version.opporom");
        }
        return f3283c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String n() {
        if (!TextUtils.isEmpty(f3287g)) {
            return f3287g;
        }
        String b6 = b("ro.build.display.id");
        f3287g = b6;
        return b6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String o() {
        if (!TextUtils.isEmpty(f3286f)) {
            return f3286f;
        }
        String b6 = b("ro.miui.ui.version.name");
        f3286f = b6;
        return b6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String p() {
        if (!TextUtils.isEmpty(f3285e)) {
            return f3285e;
        }
        String b6 = b("ro.rom.version");
        f3285e = b6;
        return b6;
    }
}
