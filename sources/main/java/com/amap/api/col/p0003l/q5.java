package com.amap.api.col.p0003l;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class q5 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile gv f6982a;

    /* renamed from: b, reason: collision with root package name */
    private static Properties f6983b = f();

    private static String h(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static gv a() {
        if (f6982a == null) {
            synchronized (q5.class) {
                try {
                    if (f6982a == null) {
                        gv b6 = b(Build.MANUFACTURER);
                        if ("".equals(b6.a())) {
                            Iterator it = Arrays.asList(gv.MIUI.a(), gv.Flyme.a(), gv.RH.a(), gv.ColorOS.a(), gv.FuntouchOS.a(), gv.SmartisanOS.a(), gv.AmigoOS.a(), gv.Sense.a(), gv.LG.a(), gv.Google.a(), gv.NubiaUI.a()).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    b6 = gv.Other;
                                    break;
                                }
                                gv b7 = b((String) it.next());
                                if (!"".equals(b7.a())) {
                                    b6 = b7;
                                    break;
                                }
                            }
                        }
                        f6982a = b6;
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                } finally {
                }
            }
        }
        return f6982a;
    }

    private static gv b(String str) {
        if (str == null || str.length() <= 0) {
            return gv.Other;
        }
        gv gvVar = gv.MIUI;
        if (!str.equals(gvVar.a())) {
            gv gvVar2 = gv.Flyme;
            if (!str.equals(gvVar2.a())) {
                gv gvVar3 = gv.RH;
                if (!str.equals(gvVar3.a())) {
                    gv gvVar4 = gv.ColorOS;
                    if (!str.equals(gvVar4.a())) {
                        gv gvVar5 = gv.FuntouchOS;
                        if (!str.equals(gvVar5.a())) {
                            gv gvVar6 = gv.SmartisanOS;
                            if (!str.equals(gvVar6.a())) {
                                gv gvVar7 = gv.AmigoOS;
                                if (!str.equals(gvVar7.a())) {
                                    gv gvVar8 = gv.EUI;
                                    if (!str.equals(gvVar8.a())) {
                                        gv gvVar9 = gv.Sense;
                                        if (!str.equals(gvVar9.a())) {
                                            gv gvVar10 = gv.LG;
                                            if (!str.equals(gvVar10.a())) {
                                                gv gvVar11 = gv.Google;
                                                if (!str.equals(gvVar11.a())) {
                                                    gv gvVar12 = gv.NubiaUI;
                                                    if (str.equals(gvVar12.a()) && r(gvVar12)) {
                                                        return gvVar12;
                                                    }
                                                } else if (q(gvVar11)) {
                                                    return gvVar11;
                                                }
                                            } else if (p(gvVar10)) {
                                                return gvVar10;
                                            }
                                        } else if (o(gvVar9)) {
                                            return gvVar9;
                                        }
                                    } else if (n(gvVar8)) {
                                        return gvVar8;
                                    }
                                } else if (m(gvVar7)) {
                                    return gvVar7;
                                }
                            } else if (l(gvVar6)) {
                                return gvVar6;
                            }
                        } else if (k(gvVar5)) {
                            return gvVar5;
                        }
                    } else if (j(gvVar4)) {
                        return gvVar4;
                    }
                } else if (i(gvVar3)) {
                    return gvVar3;
                }
            } else if (g(gvVar2)) {
                return gvVar2;
            }
        } else if (d(gvVar)) {
            return gvVar;
        }
        return gv.Other;
    }

    private static void c(gv gvVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                gvVar.a(group);
                gvVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private static boolean d(gv gvVar) {
        if (TextUtils.isEmpty(e("ro.miui.ui.version.name"))) {
            return false;
        }
        String e6 = e("ro.build.version.incremental");
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static String e(String str) {
        String property = f6983b.getProperty("[" + str + "]", null);
        return TextUtils.isEmpty(property) ? h(str) : property.replace("[", "").replace("]", "");
    }

    private static Properties f() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
            return properties;
        } catch (Exception e6) {
            e6.printStackTrace();
            return properties;
        }
    }

    private static boolean g(gv gvVar) {
        String e6 = e("ro.flyme.published");
        String e7 = e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(e6) && TextUtils.isEmpty(e7)) {
            return false;
        }
        String e8 = e("ro.build.display.id");
        c(gvVar, e8);
        gvVar.b(e8);
        return true;
    }

    private static boolean i(gv gvVar) {
        String e6 = e("ro.build.version.emui");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean j(gv gvVar) {
        String e6 = e("ro.build.version.opporom");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean k(gv gvVar) {
        String e6 = e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean l(gv gvVar) {
        String e6 = e("ro.smartisan.version");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean m(gv gvVar) {
        String e6 = e("ro.build.display.id");
        if (TextUtils.isEmpty(e6) || !e6.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean n(gv gvVar) {
        String e6 = e("ro.letv.release.version");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean o(gv gvVar) {
        String e6 = e("ro.build.sense.version");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean p(gv gvVar) {
        String e6 = e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static boolean q(gv gvVar) {
        if (!"android-google".equals(e("ro.com.google.clientidbase"))) {
            return false;
        }
        String e6 = e("ro.build.version.release");
        gvVar.a(Build.VERSION.SDK_INT);
        gvVar.b(e6);
        return true;
    }

    private static boolean r(gv gvVar) {
        String e6 = e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(e6)) {
            return false;
        }
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private q5() {
    }
}
