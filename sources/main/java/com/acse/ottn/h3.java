package com.acse.ottn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class h3 implements Cloneable {

    /* renamed from: k, reason: collision with root package name */
    public static final m4 f4598k = new s1();

    /* renamed from: l, reason: collision with root package name */
    public static final m4 f4599l = new c1();

    /* renamed from: m, reason: collision with root package name */
    public static Class[] f4600m;

    /* renamed from: n, reason: collision with root package name */
    public static Class[] f4601n;

    /* renamed from: o, reason: collision with root package name */
    public static Class[] f4602o;

    /* renamed from: p, reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f4603p;

    /* renamed from: q, reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f4604q;

    /* renamed from: a, reason: collision with root package name */
    public String f4605a;

    /* renamed from: b, reason: collision with root package name */
    public g3 f4606b;

    /* renamed from: c, reason: collision with root package name */
    public Method f4607c;

    /* renamed from: d, reason: collision with root package name */
    public Method f4608d;

    /* renamed from: e, reason: collision with root package name */
    public Class f4609e;

    /* renamed from: f, reason: collision with root package name */
    public x1 f4610f;

    /* renamed from: g, reason: collision with root package name */
    public final ReentrantReadWriteLock f4611g;

    /* renamed from: h, reason: collision with root package name */
    public final Object[] f4612h;

    /* renamed from: i, reason: collision with root package name */
    public m4 f4613i;

    /* renamed from: j, reason: collision with root package name */
    public Object f4614j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends h3 {

        /* renamed from: r, reason: collision with root package name */
        public f1 f4615r;

        /* renamed from: s, reason: collision with root package name */
        public e1 f4616s;

        /* renamed from: t, reason: collision with root package name */
        public float f4617t;

        public b(String str, e1 e1Var) {
            super(str, (a) null);
            this.f4609e = Float.TYPE;
            this.f4610f = e1Var;
            this.f4616s = e1Var;
        }

        @Override // com.acse.ottn.h3
        public Object b() {
            return Float.valueOf(this.f4617t);
        }

        @Override // com.acse.ottn.h3
        public void a(float... fArr) {
            super.a(fArr);
            this.f4616s = (e1) this.f4610f;
        }

        @Override // com.acse.ottn.h3
        public void b(Class cls) {
            if (this.f4606b != null) {
                return;
            }
            super.b(cls);
        }

        @Override // com.acse.ottn.h3
        /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b clone() {
            b bVar = (b) super.clone();
            bVar.f4616s = (e1) bVar.f4610f;
            return bVar;
        }

        @Override // com.acse.ottn.h3
        public void a(float f6) {
            this.f4617t = this.f4616s.b(f6);
        }

        public b(g3 g3Var, e1 e1Var) {
            super(g3Var, (a) null);
            this.f4609e = Float.TYPE;
            this.f4610f = e1Var;
            this.f4616s = e1Var;
            if (g3Var instanceof f1) {
                this.f4615r = (f1) this.f4606b;
            }
        }

        @Override // com.acse.ottn.h3
        public void a(Object obj) {
            f1 f1Var = this.f4615r;
            if (f1Var != null) {
                f1Var.a((f1) obj, this.f4617t);
                return;
            }
            g3 g3Var = this.f4606b;
            if (g3Var != null) {
                g3Var.a(obj, Float.valueOf(this.f4617t));
                return;
            }
            if (this.f4607c != null) {
                try {
                    this.f4612h[0] = Float.valueOf(this.f4617t);
                    this.f4607c.invoke(obj, this.f4612h);
                } catch (IllegalAccessException e6) {
                    e6.toString();
                } catch (InvocationTargetException e7) {
                    e7.toString();
                }
            }
        }

        public b(String str, float... fArr) {
            super(str, (a) null);
            a(fArr);
        }

        public b(g3 g3Var, float... fArr) {
            super(g3Var, (a) null);
            a(fArr);
            if (g3Var instanceof f1) {
                this.f4615r = (f1) this.f4606b;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends h3 {

        /* renamed from: r, reason: collision with root package name */
        public u1 f4618r;

        /* renamed from: s, reason: collision with root package name */
        public t1 f4619s;

        /* renamed from: t, reason: collision with root package name */
        public int f4620t;

        public c(String str, t1 t1Var) {
            super(str, (a) null);
            this.f4609e = Integer.TYPE;
            this.f4610f = t1Var;
            this.f4619s = t1Var;
        }

        @Override // com.acse.ottn.h3
        public Object b() {
            return Integer.valueOf(this.f4620t);
        }

        @Override // com.acse.ottn.h3
        public void a(int... iArr) {
            super.a(iArr);
            this.f4619s = (t1) this.f4610f;
        }

        @Override // com.acse.ottn.h3
        public void b(Class cls) {
            if (this.f4606b != null) {
                return;
            }
            super.b(cls);
        }

        @Override // com.acse.ottn.h3
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public c clone() {
            c cVar = (c) super.clone();
            cVar.f4619s = (t1) cVar.f4610f;
            return cVar;
        }

        @Override // com.acse.ottn.h3
        public void a(float f6) {
            this.f4620t = this.f4619s.b(f6);
        }

        public c(g3 g3Var, t1 t1Var) {
            super(g3Var, (a) null);
            this.f4609e = Integer.TYPE;
            this.f4610f = t1Var;
            this.f4619s = t1Var;
            if (g3Var instanceof u1) {
                this.f4618r = (u1) this.f4606b;
            }
        }

        @Override // com.acse.ottn.h3
        public void a(Object obj) {
            u1 u1Var = this.f4618r;
            if (u1Var != null) {
                u1Var.a((u1) obj, this.f4620t);
                return;
            }
            g3 g3Var = this.f4606b;
            if (g3Var != null) {
                g3Var.a(obj, Integer.valueOf(this.f4620t));
                return;
            }
            if (this.f4607c != null) {
                try {
                    this.f4612h[0] = Integer.valueOf(this.f4620t);
                    this.f4607c.invoke(obj, this.f4612h);
                } catch (IllegalAccessException e6) {
                    e6.toString();
                } catch (InvocationTargetException e7) {
                    e7.toString();
                }
            }
        }

        public c(String str, int... iArr) {
            super(str, (a) null);
            a(iArr);
        }

        public c(g3 g3Var, int... iArr) {
            super(g3Var, (a) null);
            a(iArr);
            if (g3Var instanceof u1) {
                this.f4618r = (u1) this.f4606b;
            }
        }
    }

    public /* synthetic */ h3(g3 g3Var, a aVar) {
        this(g3Var);
    }

    public static h3 a(String str, int... iArr) {
        return new c(str, iArr);
    }

    public void b(Class cls) {
        this.f4607c = a(cls, f4603p, l3.f4738h, this.f4609e);
    }

    public void c(Object obj) {
        g3 g3Var = this.f4606b;
        if (g3Var != null) {
            try {
                g3Var.a(obj);
                Iterator<w1> it = this.f4610f.f5481e.iterator();
                while (it.hasNext()) {
                    w1 next = it.next();
                    if (!next.f()) {
                        next.a(this.f4606b.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                this.f4606b.a();
                Objects.toString(obj);
                this.f4606b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f4607c == null) {
            b((Class) cls);
        }
        Iterator<w1> it2 = this.f4610f.f5481e.iterator();
        while (it2.hasNext()) {
            w1 next2 = it2.next();
            if (!next2.f()) {
                if (this.f4608d == null) {
                    a((Class) cls);
                }
                try {
                    next2.a(this.f4608d.invoke(obj, null));
                } catch (IllegalAccessException e6) {
                    e6.toString();
                } catch (InvocationTargetException e7) {
                    e7.toString();
                }
            }
        }
    }

    public void d(Object obj) {
        a(obj, this.f4610f.f5481e.get(0));
    }

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        f4600m = new Class[]{cls, Float.class, cls2, cls3, Double.class, Integer.class};
        f4601n = new Class[]{cls3, Integer.class, cls, cls2, Float.class, Double.class};
        f4602o = new Class[]{cls2, Double.class, cls, cls3, Float.class, Integer.class};
        f4603p = new HashMap<>();
        f4604q = new HashMap<>();
    }

    public /* synthetic */ h3(String str, a aVar) {
        this(str);
    }

    public static h3 a(g3<?, Integer> g3Var, int... iArr) {
        return new c(g3Var, iArr);
    }

    public void b(Object obj) {
        a(obj, this.f4610f.f5481e.get(r0.size() - 1));
    }

    public void d() {
        if (this.f4613i == null) {
            Class cls = this.f4609e;
            this.f4613i = cls == Integer.class ? f4598k : cls == Float.class ? f4599l : null;
        }
        m4 m4Var = this.f4613i;
        if (m4Var != null) {
            this.f4610f.a(m4Var);
        }
    }

    public String toString() {
        return this.f4605a + ": " + this.f4610f.toString();
    }

    public h3(String str) {
        this.f4607c = null;
        this.f4608d = null;
        this.f4610f = null;
        this.f4611g = new ReentrantReadWriteLock();
        this.f4612h = new Object[1];
        this.f4605a = str;
    }

    public static h3 a(String str, float... fArr) {
        return new b(str, fArr);
    }

    public Object b() {
        return this.f4614j;
    }

    public static h3 a(g3<?, Float> g3Var, float... fArr) {
        return new b(g3Var, fArr);
    }

    public static h3 a(String str, m4 m4Var, Object... objArr) {
        h3 h3Var = new h3(str);
        h3Var.a(objArr);
        h3Var.a(m4Var);
        return h3Var;
    }

    public static <V> h3 a(g3 g3Var, m4<V> m4Var, V... vArr) {
        h3 h3Var = new h3(g3Var);
        h3Var.a((Object[]) vArr);
        h3Var.a((m4) m4Var);
        return h3Var;
    }

    public h3(g3 g3Var) {
        this.f4607c = null;
        this.f4608d = null;
        this.f4610f = null;
        this.f4611g = new ReentrantReadWriteLock();
        this.f4612h = new Object[1];
        this.f4606b = g3Var;
        if (g3Var != null) {
            this.f4605a = g3Var.a();
        }
    }

    public static h3 a(String str, w1... w1VarArr) {
        x1 a6 = x1.a(w1VarArr);
        if (a6 instanceof t1) {
            return new c(str, (t1) a6);
        }
        if (a6 instanceof e1) {
            return new b(str, (e1) a6);
        }
        h3 h3Var = new h3(str);
        h3Var.f4610f = a6;
        h3Var.f4609e = w1VarArr[0].d();
        return h3Var;
    }

    public String c() {
        return this.f4605a;
    }

    public static h3 a(g3 g3Var, w1... w1VarArr) {
        x1 a6 = x1.a(w1VarArr);
        if (a6 instanceof t1) {
            return new c(g3Var, (t1) a6);
        }
        if (a6 instanceof e1) {
            return new b(g3Var, (e1) a6);
        }
        h3 h3Var = new h3(g3Var);
        h3Var.f4610f = a6;
        h3Var.f4609e = w1VarArr[0].d();
        return h3Var;
    }

    public void a(int... iArr) {
        this.f4609e = Integer.TYPE;
        this.f4610f = x1.a(iArr);
    }

    public void a(float... fArr) {
        this.f4609e = Float.TYPE;
        this.f4610f = x1.a(fArr);
    }

    public void a(w1... w1VarArr) {
        int length = w1VarArr.length;
        w1[] w1VarArr2 = new w1[Math.max(length, 2)];
        this.f4609e = w1VarArr[0].d();
        for (int i6 = 0; i6 < length; i6++) {
            w1VarArr2[i6] = w1VarArr[i6];
        }
        this.f4610f = new x1(w1VarArr2);
    }

    public void a(Object... objArr) {
        this.f4609e = objArr[0].getClass();
        this.f4610f = x1.a(objArr);
    }

    public final Method a(Class cls, String str, Class cls2) {
        Class<?>[] clsArr;
        String a6 = a(str, this.f4605a);
        Method method = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a6, null);
            } catch (NoSuchMethodException e6) {
                try {
                    method = cls.getDeclaredMethod(a6, null);
                    method.setAccessible(true);
                    return method;
                } catch (NoSuchMethodException unused) {
                    e6.toString();
                    return method;
                }
            }
        }
        if (this.f4609e.equals(Float.class)) {
            clsArr = f4600m;
        } else if (this.f4609e.equals(Integer.class)) {
            clsArr = f4601n;
        } else if (this.f4609e.equals(Double.class)) {
            clsArr = f4602o;
        } else {
            clsArr = new Class[]{this.f4609e};
        }
        for (Class<?> cls3 : clsArr) {
            Class<?>[] clsArr2 = {cls3};
            try {
                try {
                    Method method2 = cls.getMethod(a6, clsArr2);
                    this.f4609e = cls3;
                    return method2;
                } catch (NoSuchMethodException unused2) {
                }
            } catch (NoSuchMethodException unused3) {
                method = cls.getDeclaredMethod(a6, clsArr2);
                method.setAccessible(true);
                this.f4609e = cls3;
                return method;
            }
        }
        Objects.toString(this.f4609e);
        return method;
    }

    public final Method a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.f4611g.writeLock().lock();
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? hashMap2.get(this.f4605a) : null;
            if (method == null) {
                method = a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f4605a, method);
            }
            this.f4611g.writeLock().unlock();
            return method;
        } catch (Throwable th) {
            this.f4611g.writeLock().unlock();
            throw th;
        }
    }

    public final void a(Class cls) {
        this.f4608d = a(cls, f4604q, l3.f4736f, null);
    }

    public final void a(Object obj, w1 w1Var) {
        g3 g3Var = this.f4606b;
        if (g3Var != null) {
            w1Var.a(g3Var.a(obj));
        }
        try {
            if (this.f4608d == null) {
                a((Class) obj.getClass());
            }
            w1Var.a(this.f4608d.invoke(obj, null));
        } catch (IllegalAccessException e6) {
            e6.toString();
        } catch (InvocationTargetException e7) {
            e7.toString();
        }
    }

    @Override // 
    /* renamed from: a */
    public h3 clone() {
        try {
            h3 h3Var = (h3) super.clone();
            h3Var.f4605a = this.f4605a;
            h3Var.f4606b = this.f4606b;
            h3Var.f4610f = this.f4610f.clone();
            h3Var.f4613i = this.f4613i;
            return h3Var;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void a(Object obj) {
        g3 g3Var = this.f4606b;
        if (g3Var != null) {
            g3Var.a(obj, b());
        }
        if (this.f4607c != null) {
            try {
                this.f4612h[0] = b();
                this.f4607c.invoke(obj, this.f4612h);
            } catch (IllegalAccessException e6) {
                e6.toString();
            } catch (InvocationTargetException e7) {
                e7.toString();
            }
        }
    }

    public void a(m4 m4Var) {
        this.f4613i = m4Var;
        this.f4610f.a(m4Var);
    }

    public void a(float f6) {
        this.f4614j = this.f4610f.a(f6);
    }

    public void a(String str) {
        this.f4605a = str;
    }

    public void a(g3 g3Var) {
        this.f4606b = g3Var;
    }

    public static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
    }
}
