package cn.jiguang.q;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import cn.jiguang.bb.f;
import com.kwad.library.solder.lib.ext.PluginError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<Integer> f3197a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<Integer> f3198b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static String f3199c;

    public static abstract class a implements b {
        @Override // cn.jiguang.q.d.b
        public Object b() {
            return null;
        }

        @Override // cn.jiguang.q.d.b
        public void b(Object obj) {
        }
    }

    public interface b {
        Object a();

        void a(Object obj);

        Object b();

        void b(Object obj);

        Object c();
    }

    public static synchronized Object a(Context context, int i6, long j6, long j7, b bVar) {
        Object a6;
        synchronized (d.class) {
            a6 = a(context, i6, j6, j7, true, false, true, true, false, false, true, bVar);
        }
        return a6;
    }

    public static synchronized Object b(Context context, int i6, long j6, long j7, b bVar) {
        Object a6;
        synchronized (d.class) {
            a6 = a(context, i6, j6, j7, true, false, true, false, false, false, true, bVar);
        }
        return a6;
    }

    static {
        f3197a.add(Integer.valueOf(PluginError.ERROR_UPD_EXTRACT));
        f3197a.add(Integer.valueOf(PluginError.ERROR_UPD_CAPACITY));
        f3197a.add(1012);
        f3197a.add(2000);
        f3197a.add(Integer.valueOf(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW));
        f3197a.add(3334);
        f3199c = "JMethodControl";
    }

    public static synchronized Object a(Context context, int i6, long j6, long j7, boolean z5, b bVar) {
        Object a6;
        synchronized (d.class) {
            a6 = a(context, i6, j6, j7, false, z5, true, true, false, false, true, bVar);
        }
        return a6;
    }

    public static synchronized Object b(Context context, int i6, boolean z5, boolean z6, b bVar) {
        Object a6;
        synchronized (d.class) {
            a6 = a(context, i6, 0L, 0L, true, false, false, z5, false, false, z6, bVar);
        }
        return a6;
    }

    private static synchronized Object a(Context context, int i6, long j6, long j7, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, b bVar) {
        boolean z12;
        String str;
        String str2;
        String str3;
        String str4;
        synchronized (d.class) {
            if (z6) {
                f.f(f3199c, "from cmd ,so get from api");
                return bVar.a();
            }
            if (bVar == null) {
                return null;
            }
            Object c6 = bVar.c();
            f.f(f3199c, "local memory result=" + c6 + " ,configId= " + i6);
            if (a(c6)) {
                c6 = bVar.b();
                f.f(f3199c, "local cache result=" + c6 + " ,configId= " + i6);
            }
            if (a(c6)) {
                z12 = z11;
                c6 = cn.jiguang.m.b.a(context, i6, z12);
                f.f(f3199c, "sp cache result=" + c6 + " ,configId= " + i6);
            } else {
                z12 = z11;
            }
            if (z9 && !z10) {
                f.f(f3199c, "result out of expire time,current result=" + c6);
                bVar.b(c6);
                if (z8 && !cn.jiguang.g.a.a().e(i6)) {
                    str3 = f3199c;
                    str4 = "not call use api. keep lastResult=" + c6 + " ,configId= " + i6;
                    f.f(str3, str4);
                    Object obj = c6;
                    a(context, i6, obj, z5, z12, bVar);
                    return obj;
                }
                c6 = bVar.a();
                str3 = f3199c;
                str4 = "need use api, result=" + c6 + " ,configId= " + i6;
                f.f(str3, str4);
                Object obj2 = c6;
                a(context, i6, obj2, z5, z12, bVar);
                return obj2;
            }
            if (z10) {
                f.f(f3199c, "is frequency, so use cache result=" + c6 + " ,configId= " + i6);
                return c6;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a(c6)) {
                if (Math.abs(currentTimeMillis - cn.jiguang.m.b.c(context, i6)) < j6 || f3198b.contains(Integer.valueOf(i6)) || (z8 && !cn.jiguang.g.a.a().e(i6))) {
                    f.f(f3199c, "return default result=" + c6);
                } else {
                    Object a6 = bVar.a();
                    if (f3197a.contains(Integer.valueOf(i6))) {
                        f3198b.add(Integer.valueOf(i6));
                    }
                    f.f(f3199c, "over interval time,  get api result=" + a6 + " ,configId= " + i6);
                    a(context, i6, a6, z5, z11, bVar);
                    c6 = a6;
                }
            } else {
                if (!z7) {
                    f.f(f3199c, "no need update,so use cache result=" + c6 + " ,configId= " + i6);
                    return c6;
                }
                if (Math.abs(currentTimeMillis - cn.jiguang.m.b.d(context, i6)) > j7) {
                    f.f(f3199c, "result out of expire time,current result=" + c6);
                    bVar.b(c6);
                    if (z8 && !cn.jiguang.g.a.a().e(i6)) {
                        str = f3199c;
                        str2 = "not call use api. keep lastResult=" + c6 + " ,configId= " + i6;
                        f.f(str, str2);
                        Object obj3 = c6;
                        a(context, i6, obj3, z5, z11, bVar);
                        c6 = obj3;
                    }
                    c6 = bVar.a();
                    str = f3199c;
                    str2 = "need use api, result=" + c6 + " ,configId= " + i6;
                    f.f(str, str2);
                    Object obj32 = c6;
                    a(context, i6, obj32, z5, z11, bVar);
                    c6 = obj32;
                } else {
                    bVar.a(c6);
                }
            }
            return c6;
        }
    }

    public static synchronized Object a(Context context, int i6, long j6, boolean z5, b bVar) {
        synchronized (d.class) {
            if (bVar == null) {
                return null;
            }
            try {
                Object c6 = bVar.c();
                f.f(f3199c, "local memory result=" + c6 + " ,configId= " + i6);
                if (a(c6)) {
                    c6 = bVar.b();
                    f.f(f3199c, "local cache result=" + c6 + " ,configId= " + i6);
                }
                if (a(c6)) {
                    c6 = cn.jiguang.m.b.a(context, i6, true);
                    f.f(f3199c, "sp cache result=" + c6 + " ,configId= " + i6);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (z5) {
                    if (Math.abs(currentTimeMillis - cn.jiguang.m.b.c(context, i6)) < j6 || f3198b.contains(Integer.valueOf(i6)) || !cn.jiguang.g.a.a().e(i6)) {
                        f.f(f3199c, "return default result=" + c6 + " ,configId= " + i6);
                    } else {
                        Object a6 = bVar.a();
                        if (f3197a.contains(Integer.valueOf(i6))) {
                            f3198b.add(Integer.valueOf(i6));
                        }
                        f.f(f3199c, "over interval time,  get api result=" + a6 + " ,configId= " + i6);
                        a(context, i6, a6, true, true, bVar);
                        c6 = a6;
                    }
                }
                return c6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized Object a(Context context, int i6, b bVar) {
        Object a6;
        synchronized (d.class) {
            a6 = a(context, i6, 0L, 0L, true, false, false, true, false, false, true, bVar);
        }
        return a6;
    }

    public static synchronized Object a(Context context, int i6, boolean z5, boolean z6, b bVar) {
        Object a6;
        synchronized (d.class) {
            a6 = a(context, i6, 0L, 0L, true, false, false, true, z5, z6, true, bVar);
        }
        return a6;
    }

    private static void a(Context context, int i6, Object obj, boolean z5, boolean z6, b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!a(obj)) {
            bVar.a(obj);
            if (z5) {
                cn.jiguang.m.b.a(context, i6, (String) obj, z6);
                cn.jiguang.m.b.b(context, i6, currentTimeMillis);
            }
        }
        cn.jiguang.m.b.a(context, i6, currentTimeMillis);
    }

    private static boolean a(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj);
        }
        if (obj instanceof List) {
            return ((List) obj).isEmpty();
        }
        return false;
    }
}
