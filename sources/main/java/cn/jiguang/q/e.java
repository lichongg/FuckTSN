package cn.jiguang.q;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.bb.f;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, Pair<Long, Integer>> f3200a = new HashMap<>();

    public static abstract class a implements b {
        @Override // cn.jiguang.q.e.b
        public Object c() {
            return null;
        }
    }

    public interface b {
        Object a();

        void a(Object obj);

        Object b();

        Object c();
    }

    public static synchronized Object a(Context context, int i6, int i7, long j6, b bVar) {
        String str;
        String str2;
        Object obj;
        synchronized (e.class) {
            if (i7 <= 0) {
                i7 = Integer.MAX_VALUE;
            }
            if (j6 <= 0) {
                j6 = 3600000;
            }
            try {
                int d6 = cn.jiguang.g.a.a().d(i6);
                if (d6 != -1) {
                    if (d6 != 0) {
                        if (System.currentTimeMillis() - cn.jiguang.m.b.c(context, i6) < d6) {
                            obj = bVar.c();
                            if (a(obj)) {
                                obj = cn.jiguang.m.b.a(context, i6, true);
                            }
                        } else {
                            if (a(i6, i7, j6)) {
                                r2 = cn.jiguang.g.a.a().e(i6) ? bVar.b() : null;
                                if (a(r2)) {
                                    f.a(i6, "JMethodFreq", " origin api  get value is null, configID=" + i6);
                                }
                            }
                            if (!a(r2)) {
                                if (r2 instanceof String) {
                                    cn.jiguang.m.b.a(context, i6, (String) r2, true);
                                }
                                cn.jiguang.m.b.a(context, i6, System.currentTimeMillis());
                            }
                            obj = r2;
                        }
                        f.f("JMethodFreq", "get disk value is " + obj);
                    } else {
                        r2 = cn.jiguang.g.a.a().e(i6) ? bVar.b() : null;
                        f.f("JMethodFreq", "get method value is " + r2);
                        obj = r2;
                    }
                } else {
                    Object a6 = bVar.a();
                    if (a(a6) && a(i6, i7, j6)) {
                        if (cn.jiguang.g.a.a().e(i6)) {
                            a6 = bVar.b();
                        }
                        if (a(a6)) {
                            str = "JMethodFreq";
                            str2 = " origin api  get value is null, configID=" + i6;
                        } else {
                            bVar.a(a6);
                            obj = a6;
                            f.a(i6, "JMethodFreq", "get memory value is " + obj);
                        }
                    } else {
                        str = "JMethodFreq";
                        str2 = "configID =" + i6 + " , fre control,user memory";
                    }
                    f.a(i6, str, str2);
                    obj = a6;
                    f.a(i6, "JMethodFreq", "get memory value is " + obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public static synchronized Object a(Context context, int i6, int i7, b bVar) {
        Object a6;
        synchronized (e.class) {
            a6 = a(context, i6, i7, 0L, bVar);
        }
        return a6;
    }

    public static synchronized Object a(Context context, int i6, b bVar) {
        Object a6;
        synchronized (e.class) {
            a6 = a(context, i6, 0, bVar);
        }
        return a6;
    }

    private static boolean a(int i6, int i7, long j6) {
        int intValue;
        long currentTimeMillis = System.currentTimeMillis();
        int i8 = 0;
        if (f3200a.containsKey(Integer.valueOf(i6))) {
            Pair<Long, Integer> pair = f3200a.get(Integer.valueOf(i6));
            if (Math.abs(currentTimeMillis - ((Long) pair.first).longValue()) < j6 || (intValue = ((Integer) pair.second).intValue()) >= i7) {
                return false;
            }
            i8 = intValue;
        }
        f3200a.put(Integer.valueOf(i6), new Pair<>(Long.valueOf(currentTimeMillis), Integer.valueOf(i8 + 1)));
        return true;
    }

    public static boolean a(Object obj) {
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
