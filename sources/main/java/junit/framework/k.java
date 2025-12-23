package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k implements f {

    /* renamed from: a, reason: collision with root package name */
    private String f43492a;

    /* renamed from: b, reason: collision with root package name */
    private Vector<f> f43493b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f43494b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(str);
            this.f43494b = str2;
        }

        @Override // junit.framework.g
        protected void S() {
            g.J(this.f43494b);
        }
    }

    public k() {
        this.f43493b = new Vector<>(10);
    }

    public static Constructor<?> j(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(null);
        }
    }

    private void f(Class<?> cls) {
        this.f43492a = cls.getName();
        try {
            j(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                b(s("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; f.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                for (Method method : org.junit.internal.f.a(cls2)) {
                    d(method, arrayList, cls);
                }
            }
            if (this.f43493b.size() == 0) {
                b(s("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            b(s("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public static f g(Class<?> cls, String str) {
        Object newInstance;
        try {
            Constructor<?> j6 = j(cls);
            try {
                if (j6.getParameterTypes().length == 0) {
                    newInstance = j6.newInstance(null);
                    if (newInstance instanceof g) {
                        ((g) newInstance).T(str);
                    }
                } else {
                    newInstance = j6.newInstance(str);
                }
                return (f) newInstance;
            } catch (IllegalAccessException e6) {
                return s("Cannot access test case: " + str + " (" + h(e6) + ")");
            } catch (InstantiationException e7) {
                return s("Cannot instantiate test case: " + str + " (" + h(e7) + ")");
            } catch (InvocationTargetException e8) {
                return s("Exception in constructor: " + str + " (" + h(e8.getTargetException()) + ")");
            }
        } catch (NoSuchMethodException unused) {
            return s("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    private static String h(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private f p(Class<?> cls) {
        if (g.class.isAssignableFrom(cls)) {
            return new k(cls.asSubclass(g.class));
        }
        return s(cls.getCanonicalName() + " does not extend TestCase");
    }

    public static f s(String str) {
        return new a("warning", str);
    }

    @Override // junit.framework.f
    public void a(j jVar) {
        Iterator<f> it = this.f43493b.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (jVar.n()) {
                return;
            } else {
                m(next, jVar);
            }
        }
    }

    public void b(f fVar) {
        this.f43493b.add(fVar);
    }

    @Override // junit.framework.f
    public int c() {
        Iterator<f> it = this.f43493b.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            i6 += it.next().c();
        }
        return i6;
    }

    public void e(Class<? extends g> cls) {
        b(new k(cls));
    }

    public String i() {
        return this.f43492a;
    }

    public void n(String str) {
        this.f43492a = str;
    }

    public f o(int i6) {
        return this.f43493b.get(i6);
    }

    public int q() {
        return this.f43493b.size();
    }

    public Enumeration<f> r() {
        return this.f43493b.elements();
    }

    public k(Class<?> cls) {
        this.f43493b = new Vector<>(10);
        f(cls);
    }

    private void d(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (!list.contains(name)) {
            if (!k(method)) {
                if (l(method)) {
                    b(s("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
                    return;
                }
                return;
            }
            list.add(name);
            b(g(cls, name));
        }
    }

    private boolean k(Method method) {
        if (l(method) && Modifier.isPublic(method.getModifiers())) {
            return true;
        }
        return false;
    }

    private boolean l(Method method) {
        if (method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE)) {
            return true;
        }
        return false;
    }

    public void m(f fVar, j jVar) {
        fVar.a(jVar);
    }

    public String toString() {
        if (i() != null) {
            return i();
        }
        return super.toString();
    }

    public k(Class<? extends g> cls, String str) {
        this(cls);
        n(str);
    }

    public k(String str) {
        this.f43493b = new Vector<>(10);
        n(str);
    }

    public k(Class<?>... clsArr) {
        this.f43493b = new Vector<>(10);
        for (Class<?> cls : clsArr) {
            b(p(cls));
        }
    }

    public k(Class<? extends g>[] clsArr, String str) {
        this(clsArr);
        n(str);
    }
}
