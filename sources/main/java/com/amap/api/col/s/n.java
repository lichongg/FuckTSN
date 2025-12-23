package com.amap.api.col.s;

import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    private static volatile n f8254b;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, o> f8255a = new HashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8256a = true;

        /* renamed from: b, reason: collision with root package name */
        private long f8257b = 86400;

        /* renamed from: c, reason: collision with root package name */
        private int f8258c = 10;

        /* renamed from: d, reason: collision with root package name */
        private double f8259d = 0.0d;

        public final void a(double d6) {
            this.f8259d = d6;
        }

        public final void b(int i6) {
            this.f8258c = i6;
        }

        public final void c(long j6) {
            this.f8257b = j6;
        }

        public final void d(boolean z5) {
            this.f8256a = z5;
        }

        public final boolean e() {
            return this.f8256a;
        }

        public final long f() {
            return this.f8257b;
        }

        public final int g() {
            return this.f8258c;
        }

        public final double h() {
            return this.f8259d;
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        String f8260a;

        /* renamed from: b, reason: collision with root package name */
        Object f8261b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                String str = this.f8260a;
                if (str == null) {
                    return bVar.f8260a == null && this.f8261b == bVar.f8261b;
                }
                if (str.equals(bVar.f8260a) && this.f8261b == bVar.f8261b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f8260a;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            Object obj = this.f8261b;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }

        b() {
        }
    }

    public final c a(b bVar) {
        c a6;
        if (bVar == null) {
            return null;
        }
        for (o oVar : this.f8255a.values()) {
            if (oVar != null && (a6 = oVar.a(bVar)) != null) {
                return a6;
            }
        }
        return null;
    }

    public final synchronized o c(String str) {
        return this.f8255a.get(str);
    }

    public final synchronized void g(String str, o oVar) {
        this.f8255a.put(str, oVar);
    }

    public final boolean h(b bVar) {
        if (bVar == null) {
            return false;
        }
        for (o oVar : this.f8255a.values()) {
            if (oVar != null && oVar.j(bVar)) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        Object f8262a;

        /* renamed from: b, reason: collision with root package name */
        boolean f8263b;

        public c(Object obj, boolean z5) {
            this.f8262a = obj;
            this.f8263b = z5;
        }
    }

    public static n b() {
        if (f8254b == null) {
            synchronized (n.class) {
                try {
                    if (f8254b == null) {
                        f8254b = new n();
                    }
                } finally {
                }
            }
        }
        return f8254b;
    }

    public final void d(a aVar) {
        if (aVar == null) {
            return;
        }
        for (o oVar : this.f8255a.values()) {
            if (oVar != null) {
                oVar.c(aVar);
            }
        }
    }

    public final void e(b bVar, Object obj) {
        for (o oVar : this.f8255a.values()) {
            if (oVar != null) {
                oVar.d(bVar, obj);
            }
        }
    }

    public final void f(String str, a aVar) {
        o oVar;
        if (str == null || aVar == null || (oVar = this.f8255a.get(str)) == null) {
            return;
        }
        oVar.c(aVar);
    }
}
