package cn.jiguang.dy;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.az.e;
import cn.jiguang.az.g;
import cn.jiguang.az.i;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, String> f2916a = new ConcurrentHashMap();

    /* renamed from: cn.jiguang.dy.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f2917a = new b(null);
    }

    /* renamed from: cn.jiguang.dy.b$b, reason: collision with other inner class name */
    public interface InterfaceC0041b {
        boolean a(File file);
    }

    private b() {
    }

    public static b a() {
        return a.f2917a;
    }

    public Integer b() {
        return null;
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Object a(Context context, int i6, int i7, Object obj) {
        String str;
        String a6;
        int i8;
        char c6;
        char c7;
        Context context2;
        c a7;
        cn.jiguang.aw.a aVar;
        StringBuilder sb;
        String str2;
        int i9 = -1;
        try {
            i9 = cn.jiguang.av.c.a().a(context, i6);
            cn.jiguang.ay.b.b("JDB", "context:" + context + ",pluginId:" + i6 + ",type:" + i7 + ",o:" + obj);
            str = e.f1849e;
            a6 = i.a("K9Ow/j0uADRPpP0ZrnpQ3A==", str);
        } catch (Throwable th) {
            th = th;
            cn.jiguang.ay.b.e("JDB", "d failed " + th.getMessage());
            Throwable th2 = th;
            c.a().a(context, i6, i9, cn.jiguang.aw.a.f1790a, 2, "16 load failed , error :" + th2.getMessage());
            return null;
        }
        if (i7 != 0 && i7 != 1) {
            if (i7 == 2) {
                String a8 = cn.jiguang.av.a.a(i6, 0);
                String a9 = cn.jiguang.av.a.a(i6, 1);
                String a10 = cn.jiguang.av.a.a(i6, 2);
                cn.jiguang.ay.b.b("JDB", "impClass:" + a8 + ",forClass:" + a9 + ",forField:" + a10);
                try {
                    Object newInstance = ((Class) obj.getClass().getMethod(a6, String.class).invoke(obj, a8)).newInstance();
                    Class<?> cls = Class.forName(a9);
                    Field declaredField = cls.getDeclaredField(a10);
                    declaredField.setAccessible(true);
                    declaredField.set(cls, newInstance);
                    str2 = a10;
                } catch (Throwable th3) {
                    th = th3;
                    str2 = a10;
                }
                try {
                    c.a().a(context, i6, i9, cn.jiguang.aw.a.f1790a, 1, null);
                } catch (Throwable th4) {
                    th = th4;
                    cn.jiguang.ay.b.e("JDB", "d e:" + th);
                    Throwable th5 = th;
                    a7 = c.a();
                    aVar = cn.jiguang.aw.a.f1790a;
                    sb = new StringBuilder();
                    sb.append("15 load impClass:");
                    sb.append(a8);
                    sb.append(",forClass:");
                    sb.append(a9);
                    sb.append(",forField:");
                    sb.append(str2);
                    sb.append(", error :");
                    sb.append(th5.getMessage());
                    a7.a(context, i6, i9, aVar, 2, sb.toString());
                    return null;
                }
            }
            return null;
        }
        Map<String, String> c8 = c(context, i6);
        if (c8 != null && !c8.isEmpty()) {
            String str3 = c8.get("p");
            String str4 = c8.get("o");
            String str5 = c8.get(t.f36143d);
            if (i7 == 0) {
                try {
                    i8 = 1;
                    c6 = 2;
                    c7 = 0;
                    context2 = context;
                    c.a().a(context2, i6, i9, cn.jiguang.aw.a.f1794e, 0, null);
                } catch (Throwable th6) {
                    th = th6;
                    cn.jiguang.ay.b.e("JDB", "d failed " + th.getMessage());
                    Throwable th22 = th;
                    c.a().a(context, i6, i9, cn.jiguang.aw.a.f1790a, 2, "16 load failed , error :" + th22.getMessage());
                    return null;
                }
            } else {
                i8 = 1;
                c6 = 2;
                c7 = 0;
                context2 = context;
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                String a11 = i.a("Vd1zcNfZVmpqw+2NKX98sOf8ivTVMeqdIaqCpaA/CRg=", str);
                Object invoke = Context.class.getMethod(i.a("STVo4dDOk4G2wtqJZNmnGg==", str), null).invoke(context2, null);
                if (i7 == 0) {
                    try {
                        Class<?> cls2 = Class.forName(i.a("Zaqi7qnhpEu8dzobKmLDqlzxa1KuKDP47tarZAn48u8=", str));
                        Class<?> cls3 = Class.forName(a11);
                        Class<?>[] clsArr = new Class[4];
                        clsArr[c7] = String.class;
                        clsArr[i8] = String.class;
                        clsArr[c6] = String.class;
                        clsArr[3] = cls3;
                        Constructor<?> constructor = cls2.getConstructor(clsArr);
                        Object[] objArr = new Object[4];
                        objArr[c7] = str3;
                        objArr[i8] = str4;
                        objArr[c6] = str5;
                        objArr[3] = invoke;
                        Object newInstance2 = constructor.newInstance(objArr);
                        if (newInstance2 != null) {
                            return newInstance2;
                        }
                        try {
                            c.a().a(context2, i6, i9, cn.jiguang.aw.a.f1794e, 2, "create DexClassLoader failed");
                            return newInstance2;
                        } catch (Throwable th7) {
                            th = th7;
                            cn.jiguang.ay.b.e("JDB", "d failed " + th.getMessage());
                            Throwable th222 = th;
                            c.a().a(context, i6, i9, cn.jiguang.aw.a.f1790a, 2, "16 load failed , error :" + th222.getMessage());
                            return null;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } else {
                    String a12 = cn.jiguang.av.a.a(i6, 3);
                    cn.jiguang.ay.b.b("JDB", "diy c l:" + a12);
                    try {
                        Class<?> cls4 = obj.getClass();
                        Class<?>[] clsArr2 = new Class[i8];
                        clsArr2[c7] = String.class;
                        Method method = cls4.getMethod(a6, clsArr2);
                        Object[] objArr2 = new Object[i8];
                        objArr2[c7] = a12;
                        Class cls5 = (Class) method.invoke(obj, objArr2);
                        Class<?> cls6 = Class.forName(a11);
                        Class<?>[] clsArr3 = new Class[4];
                        clsArr3[c7] = String.class;
                        clsArr3[i8] = String.class;
                        clsArr3[c6] = String.class;
                        clsArr3[3] = cls6;
                        Constructor constructor2 = cls5.getConstructor(clsArr3);
                        Object[] objArr3 = new Object[4];
                        objArr3[c7] = str3;
                        objArr3[i8] = str4;
                        objArr3[c6] = str5;
                        objArr3[3] = invoke;
                        Object newInstance3 = constructor2.newInstance(objArr3);
                        try {
                            if (!TextUtils.isEmpty(str3)) {
                                if (f2916a.containsKey(Integer.valueOf(i6))) {
                                    f2916a.remove(Integer.valueOf(i6));
                                }
                                File file = new File(str3);
                                if (file.exists()) {
                                    file.delete();
                                    cn.jiguang.ay.b.b("JDB", "d d file success:" + file.getAbsolutePath());
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        c.a().a(context, i6, i9, cn.jiguang.aw.a.f1794e, 1, null);
                        return newInstance3;
                    } catch (Throwable th9) {
                        cn.jiguang.ay.b.e("JDB", "d " + i7 + " e:" + th9);
                        a7 = c.a();
                        aVar = cn.jiguang.aw.a.f1794e;
                        sb = new StringBuilder();
                        sb.append("create custom classLoader failed , error :");
                        sb.append(th9.getMessage());
                    }
                }
            }
            c.a().a(context, i6, i9, cn.jiguang.aw.a.f1794e, 2, "parameter empty");
        }
        return null;
        a7.a(context, i6, i9, aVar, 2, sb.toString());
        return null;
    }

    public static String b(Context context, cn.jiguang.aw.c cVar) {
        String absolutePath = cn.jiguang.av.b.b(context, cVar.f1831s, cVar.f1825m, cVar.f1827o).getAbsolutePath();
        cn.jiguang.ay.b.b("JDB", "l:" + absolutePath);
        return absolutePath;
    }

    public static String a(Context context, cn.jiguang.aw.c cVar) {
        String absolutePath = cn.jiguang.av.b.c(context, cVar.f1831s, cVar.f1825m, cVar.f1827o).getAbsolutePath();
        cn.jiguang.ay.b.b("JDB", "o:" + absolutePath);
        return absolutePath;
    }

    public static Map<String, String> c(Context context, int i6) {
        c a6;
        int i7;
        String str;
        int a7 = cn.jiguang.av.c.a().a(context, i6);
        c a8 = c.a();
        cn.jiguang.aw.a aVar = cn.jiguang.aw.a.f1791b;
        a8.a(context, i6, a7, aVar, 0, null);
        cn.jiguang.aw.c b6 = cn.jiguang.av.a.b(context, i6);
        if (b6 == null) {
            a6 = c.a();
            i7 = 2;
            str = "pluginInfo is null";
        } else {
            a7 = b6.f1827o;
            c.a().a(context, i6, a7, aVar, 1, null);
            c a9 = c.a();
            aVar = cn.jiguang.aw.a.f1792c;
            a9.a(context, i6, a7, aVar, 0, null);
            if (!a(context, b6, i6)) {
                a6 = c.a();
                i7 = 2;
                str = "checkLocalVcode failed";
            } else {
                String a10 = a(context, b6, true);
                if (TextUtils.isEmpty(a10)) {
                    return null;
                }
                String a11 = a(context, b6);
                String b7 = b(context, b6);
                HashMap hashMap = new HashMap();
                hashMap.put("p", a10);
                hashMap.put("o", a11);
                hashMap.put(t.f36143d, b7);
                return hashMap;
            }
        }
        a6.a(context, i6, a7, aVar, i7, str);
        return null;
    }

    public void b(Context context, int i6) {
        try {
            cn.jiguang.aw.c b6 = cn.jiguang.av.a.b(context, i6);
            if (b6 != null) {
                cn.jiguang.av.a.a(context, b6);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(Context context, cn.jiguang.aw.c cVar, boolean z5) {
        String str;
        File a6 = cn.jiguang.av.a.a(context, cVar, true);
        if (a6 != null) {
            str = a6.getAbsolutePath();
            cn.jiguang.ay.b.b("JDB", "p:" + str);
            if (z5) {
                c.a().a(context, cVar.f1825m, cVar.f1827o, cn.jiguang.aw.a.f1792c, 1, null);
            }
        } else {
            if (z5) {
                c.a().a(context, cVar.f1825m, cVar.f1827o, cn.jiguang.aw.a.f1792c, 2, "Plugin file validate check failed");
            }
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                if (f2916a.get(Integer.valueOf(cVar.f1825m)) != null) {
                    String str2 = f2916a.get(Integer.valueOf(cVar.f1825m));
                    if (new File(str2).exists()) {
                        return str2;
                    }
                }
            } catch (Throwable unused) {
            }
            c a7 = c.a();
            int i6 = cVar.f1825m;
            int i7 = cVar.f1827o;
            cn.jiguang.aw.a aVar = cn.jiguang.aw.a.f1793d;
            a7.a(context, i6, i7, aVar, 0, null);
            File a8 = cn.jiguang.av.b.a(context, new File(str), cVar.f1825m, cVar.f1827o, e.f1848d);
            if (a8 == null || !a8.exists()) {
                cn.jiguang.ay.b.b("JDB", "d failed,clear p");
                cn.jiguang.av.a.a(context, cVar);
                str = "";
            } else {
                str = a8.getAbsolutePath();
                try {
                    f2916a.put(Integer.valueOf(cVar.f1825m), str);
                    if (z5) {
                        c.a().a(context, cVar.f1825m, cVar.f1827o, aVar, 1, null);
                    }
                } catch (Throwable th) {
                    if (z5) {
                        c.a().a(context, cVar.f1825m, cVar.f1827o, cn.jiguang.aw.a.f1793d, 2, "11 add pluginCache error:" + th.getMessage());
                    }
                }
            }
        }
        cn.jiguang.ay.b.b("JDB", "end p:" + str);
        return str;
    }

    public void b(Context context, int i6, String str) {
        cn.jiguang.ay.b.b("JDB", "updateImmediately start - pluinType: " + i6 + ", updateUrl: " + str);
        if (g.b(context)) {
            cn.jiguang.av.c.a().a(context, i6, str);
            return;
        }
        cn.jiguang.ay.b.e("JDB", "updateImmediately failed - not in service process, pluinType: " + i6);
    }

    public void a(Context context, int i6, String str) {
        cn.jiguang.ay.b.b("JDB", "up :" + i6);
        a(context, i6, str, (InterfaceC0041b) null);
    }

    public void a(Context context, int i6, String str, InterfaceC0041b interfaceC0041b) {
        if (g.b(context)) {
            cn.jiguang.av.c.a().a(context, i6, str, interfaceC0041b);
            if (i6 == 1) {
                c.a().a(context);
            }
        }
    }

    public boolean a(Context context, int i6) {
        try {
            int a6 = cn.jiguang.av.c.a().a(context, i6);
            c a7 = c.a();
            cn.jiguang.aw.a aVar = cn.jiguang.aw.a.f1790a;
            a7.a(context, i6, a6, aVar, 0, null);
            if (context == null) {
                cn.jiguang.ay.b.g("JDB", "context is null");
                c.a().a(context, i6, a6, aVar, 2, "1 context is null");
                return false;
            }
            Object a8 = a(context, i6, 0, (Object) null);
            if (a8 == null) {
                c.a().a(context, i6, a6, aVar, 2, "baseCL failed");
                return false;
            }
            Object a9 = a(context, i6, 1, a8);
            if (a9 == null) {
                c.a().a(context, i6, a6, aVar, 2, "diyCL failed");
                return false;
            }
            a(context, i6, 2, a9);
            return true;
        } catch (Throwable th) {
            cn.jiguang.ay.b.a("JDB", "lP:" + th.getMessage(), th);
            return false;
        }
    }

    private static boolean a(Context context, cn.jiguang.aw.c cVar, int i6) {
        String a6 = cn.jiguang.av.a.a(i6, 4);
        if (TextUtils.isEmpty(a6)) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(a6);
            cn.jiguang.ay.b.b("JDB", "p c vc:" + parseInt + ",p vc:" + cVar.f1827o);
            if (parseInt < cVar.f1827o) {
                return true;
            }
            cn.jiguang.av.a.a(context, cVar);
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
