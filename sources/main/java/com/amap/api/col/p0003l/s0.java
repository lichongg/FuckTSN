package com.amap.api.col.p0003l;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s0 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile s0 f7201b;

    /* renamed from: c, reason: collision with root package name */
    private static e6 f7202c;

    /* renamed from: a, reason: collision with root package name */
    private Context f7203a;

    private synchronized void g(String str, int i6, long j6, long[] jArr, long[] jArr2) {
        if (l()) {
            f7202c.h(new o0(str, j6, i6, jArr[0], jArr2[0]), o0.a(str));
        }
    }

    public final synchronized n0 a(String str) {
        if (!l()) {
            return null;
        }
        List p5 = f7202c.p(q0.f(str), n0.class);
        if (p5.size() <= 0) {
            return null;
        }
        return (n0) p5.get(0);
    }

    public final synchronized void e(n0 n0Var) {
        if (l()) {
            f7202c.h(n0Var, q0.h(n0Var.j()));
            h(n0Var.e(), n0Var.k());
        }
    }

    public final synchronized List<String> j(String str) {
        ArrayList arrayList = new ArrayList();
        if (!l()) {
            return arrayList;
        }
        arrayList.addAll(d(f7202c.p(p0.b(str), p0.class)));
        return arrayList;
    }

    public final synchronized void k(n0 n0Var) {
        if (l()) {
            f7202c.j(q0.h(n0Var.j()), q0.class);
            f7202c.j(p0.b(n0Var.e()), p0.class);
            f7202c.j(o0.a(n0Var.e()), o0.class);
        }
    }

    public final synchronized void m(String str) {
        if (l()) {
            f7202c.j(q0.f(str), q0.class);
            f7202c.j(p0.b(str), p0.class);
            f7202c.j(o0.a(str), o0.class);
        }
    }

    public final synchronized String n(String str) {
        if (!l()) {
            return null;
        }
        List p5 = f7202c.p(q0.h(str), q0.class);
        return p5.size() > 0 ? ((q0) p5.get(0)).c() : null;
    }

    public static s0 b(Context context) {
        if (f7201b == null) {
            synchronized (s0.class) {
                try {
                    if (f7201b == null) {
                        f7201b = new s0(context);
                    }
                } finally {
                }
            }
        }
        return f7201b;
    }

    private static List<String> d(List<p0> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            Iterator<p0> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
        }
        return arrayList;
    }

    private static void h(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        String b6 = p0.b(str);
        if (f7202c.p(b6, p0.class).size() > 0) {
            f7202c.j(b6, p0.class);
        }
        String[] split = str2.split(";");
        ArrayList arrayList = new ArrayList();
        for (String str3 : split) {
            arrayList.add(new p0(str, str3));
        }
        f7202c.l(arrayList);
    }

    private static e6 i(Context context) {
        try {
            return new e6(context, r0.a());
        } catch (Throwable th) {
            v5.p(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean l() {
        if (f7202c == null) {
            f7202c = i(this.f7203a);
        }
        return f7202c != null;
    }

    public final ArrayList<n0> c() {
        ArrayList<n0> arrayList = new ArrayList<>();
        if (l()) {
            Iterator it = f7202c.p("", n0.class).iterator();
            while (it.hasNext()) {
                arrayList.add((n0) it.next());
            }
        }
        return arrayList;
    }

    private s0(Context context) {
        this.f7203a = context;
        f7202c = i(context);
    }

    public final void f(String str, int i6, long j6, long j7, long j8) {
        if (!l()) {
            return;
        }
        g(str, i6, j6, new long[]{j7, 0, 0, 0, 0}, new long[]{j8, 0, 0, 0, 0});
    }
}
