package com.beizi.fusion.d.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.l3;
import com.beizi.fusion.tool.aa;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private a f13372a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str);
    }

    public static boolean b() {
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public void a(Context context) {
        String a6;
        a aVar;
        try {
            aa.c("BeiZis", "init oaid " + e());
            if ("ASUS".equals(e().toUpperCase())) {
                b(context);
            } else if (b()) {
                b(context);
            } else if ("LENOVO".equals(e().toUpperCase())) {
                new d(context).a(this.f13372a);
            } else if ("MOTOLORA".equals(e().toUpperCase())) {
                new d(context).a(this.f13372a);
            } else {
                if (!"MEIZU".equals(e().toUpperCase())) {
                    if ("NUBIA".equals(e().toUpperCase())) {
                        a6 = new f(context).a();
                    } else if (a()) {
                        b(context);
                    } else if ("SAMSUNG".equals(e().toUpperCase())) {
                        b(context);
                    } else if ("VIVO".equals(e().toUpperCase())) {
                        a6 = new j(context).a();
                    } else if ("XIAOMI".equals(e().toUpperCase())) {
                        a6 = new k(context).a();
                    } else if ("BLACKSHARK".equals(e().toUpperCase())) {
                        a6 = new k(context).a();
                    } else if ("ONEPLUS".equals(e().toUpperCase())) {
                        b(context);
                    } else if ("ZTE".equals(e().toUpperCase())) {
                        b(context);
                    } else {
                        if (!"FERRMEOS".equals(e().toUpperCase()) && !c()) {
                            if ("SSUI".equals(e().toUpperCase()) || d()) {
                                b(context);
                            }
                        }
                        b(context);
                    }
                    aVar = this.f13372a;
                    if (aVar != null || a6 == null) {
                    }
                    aVar.a(a6);
                    return;
                }
                new e(context).a(this.f13372a);
            }
            a6 = null;
            aVar = this.f13372a;
            if (aVar != null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean c() {
        String a6 = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(a6) && a6.equalsIgnoreCase("FREEMEOS");
    }

    public boolean d() {
        String a6 = a("ro.ssui.product");
        return (TextUtils.isEmpty(a6) || a6.equalsIgnoreCase("unknown")) ? false : true;
    }

    public b(a aVar) {
        this.f13372a = aVar;
    }

    private void b(final Context context) {
        new Thread(new Runnable() { // from class: com.beizi.fusion.d.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    return;
                }
                try {
                    if ("ASUS".equals(b.this.e().toUpperCase())) {
                        new com.beizi.fusion.d.a.a(context).a(b.this.f13372a);
                        return;
                    }
                    if (b.b()) {
                        new c(context).a(b.this.f13372a);
                        return;
                    }
                    if (b.a()) {
                        new h(context).a(b.this.f13372a);
                        return;
                    }
                    if ("ONEPLUS".equals(b.this.e().toUpperCase())) {
                        new g(context).a(b.this.f13372a);
                        return;
                    }
                    if ("ZTE".equals(b.this.e().toUpperCase())) {
                        new l(context).a(b.this.f13372a);
                        return;
                    }
                    if (!"FERRMEOS".equals(b.this.e().toUpperCase()) && !b.this.c()) {
                        if (!"SSUI".equals(b.this.e().toUpperCase()) && !b.this.d()) {
                            if ("SAMSUNG".equals(b.this.e().toUpperCase())) {
                                new i(context).a(b.this.f13372a);
                                return;
                            }
                            return;
                        }
                        new l(context).a(b.this.f13372a);
                        return;
                    }
                    new l(context).a(b.this.f13372a);
                } catch (Throwable unused) {
                    aa.c("BeiZis", "getIDFromNewThead exception");
                }
            }
        }).start();
    }

    public static boolean a() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(a("ro.build.version.opporom", ""));
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e6) {
            aa.c("BeiZis", "System property invoke error: " + e6);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(l3.f4736f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }
}
