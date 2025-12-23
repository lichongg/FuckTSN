package org.slf4j;

import com.baidu.idl.face.platform.FaceEnvironment;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.h;
import org.slf4j.helpers.i;
import org.slf4j.helpers.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static final String f51694a = "http://www.slf4j.org/codes.html";

    /* renamed from: b, reason: collision with root package name */
    static final String f51695b = "http://www.slf4j.org/codes.html#StaticLoggerBinder";

    /* renamed from: c, reason: collision with root package name */
    static final String f51696c = "http://www.slf4j.org/codes.html#multiple_bindings";

    /* renamed from: d, reason: collision with root package name */
    static final String f51697d = "http://www.slf4j.org/codes.html#null_LF";

    /* renamed from: e, reason: collision with root package name */
    static final String f51698e = "http://www.slf4j.org/codes.html#version_mismatch";

    /* renamed from: f, reason: collision with root package name */
    static final String f51699f = "http://www.slf4j.org/codes.html#substituteLogger";

    /* renamed from: g, reason: collision with root package name */
    static final String f51700g = "http://www.slf4j.org/codes.html#loggerNameMismatch";

    /* renamed from: h, reason: collision with root package name */
    static final String f51701h = "http://www.slf4j.org/codes.html#replay";

    /* renamed from: i, reason: collision with root package name */
    static final String f51702i = "http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: j, reason: collision with root package name */
    static final String f51703j = "org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* renamed from: k, reason: collision with root package name */
    static final int f51704k = 0;

    /* renamed from: l, reason: collision with root package name */
    static final int f51705l = 1;

    /* renamed from: m, reason: collision with root package name */
    static final int f51706m = 2;

    /* renamed from: n, reason: collision with root package name */
    static final int f51707n = 3;

    /* renamed from: o, reason: collision with root package name */
    static final int f51708o = 4;

    /* renamed from: p, reason: collision with root package name */
    static volatile int f51709p = 0;

    /* renamed from: t, reason: collision with root package name */
    static final String f51713t = "java.vendor.url";

    /* renamed from: q, reason: collision with root package name */
    static i f51710q = new i();

    /* renamed from: r, reason: collision with root package name */
    static org.slf4j.helpers.e f51711r = new org.slf4j.helpers.e();

    /* renamed from: s, reason: collision with root package name */
    static final String f51712s = "slf4j.detectLoggerNameMismatch";

    /* renamed from: u, reason: collision with root package name */
    static boolean f51714u = j.f(f51712s);

    /* renamed from: v, reason: collision with root package name */
    private static final String[] f51715v = {cn.bluemobi.dylan.photoview.a.f1297f, "1.7"};

    /* renamed from: w, reason: collision with root package name */
    private static String f51716w = "org/slf4j/impl/StaticLoggerBinder.class";

    static void e(Throwable th) {
        f51709p = 2;
        j.d("Failed to instantiate SLF4J LoggerFactory", th);
    }

    private static boolean m(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    static void t() {
        f51709p = 0;
    }

    private static void c(int i6) {
        j.c("A number (" + i6 + ") of logging calls during the initialization phase have been intercepted and are");
        j.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        j.c("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void d() {
        j.c("The following set of substitute loggers may have been accessed");
        j.c("during the initialization phase. Logging calls during this");
        j.c("phase were not honored. However, subsequent logging calls to these");
        j.c("loggers will work as normally expected.");
        j.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static Set<URL> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = d.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f51716w) : classLoader.getResources(f51716w);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
            return linkedHashSet;
        } catch (IOException e6) {
            j.d("Error getting resources from path", e6);
            return linkedHashSet;
        }
    }

    private static void g() {
        synchronized (f51710q) {
            try {
                f51710q.f();
                for (h hVar : f51710q.e()) {
                    hVar.h(j(hVar.getName()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a h() {
        if (f51709p == 0) {
            synchronized (d.class) {
                try {
                    if (f51709p == 0) {
                        f51709p = 1;
                        o();
                    }
                } finally {
                }
            }
        }
        int i6 = f51709p;
        if (i6 == 1) {
            return f51710q;
        }
        if (i6 == 2) {
            throw new IllegalStateException(f51703j);
        }
        if (i6 == 3) {
            return org.slf4j.impl.c.c().a();
        }
        if (i6 == 4) {
            return f51711r;
        }
        throw new IllegalStateException("Unreachable code");
    }

    private static boolean l() {
        String g6 = j.g(f51713t);
        if (g6 == null) {
            return false;
        }
        return g6.toLowerCase().contains(FaceEnvironment.OS);
    }

    private static void p() {
        LinkedBlockingQueue<org.slf4j.event.d> c6 = f51710q.c();
        int size = c6.size();
        ArrayList<org.slf4j.event.d> arrayList = new ArrayList(128);
        int i6 = 0;
        while (c6.drainTo(arrayList, 128) != 0) {
            for (org.slf4j.event.d dVar : arrayList) {
                q(dVar);
                int i7 = i6 + 1;
                if (i6 == 0) {
                    b(dVar, size);
                }
                i6 = i7;
            }
            arrayList.clear();
        }
    }

    private static void q(org.slf4j.event.d dVar) {
        if (dVar == null) {
            return;
        }
        h h6 = dVar.h();
        String name = h6.getName();
        if (h6.f()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (h6.e()) {
            return;
        }
        if (h6.d()) {
            h6.g(dVar);
        } else {
            j.c(name);
        }
    }

    private static void r(Set<URL> set) {
        if (set == null || !k(set)) {
            return;
        }
        j.c("Actual binding is of type [" + org.slf4j.impl.c.c().b() + "]");
    }

    private static final void u() {
        try {
            String str = org.slf4j.impl.c.f51767c;
            boolean z5 = false;
            for (String str2 : f51715v) {
                if (str.startsWith(str2)) {
                    z5 = true;
                }
            }
            if (z5) {
                return;
            }
            j.c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f51715v).toString());
            j.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            j.d("Unexpected problem occured during version sanity check", th);
        }
    }

    private d() {
    }

    private static final void a() {
        Set<URL> set;
        try {
            if (!l()) {
                set = f();
                s(set);
            } else {
                set = null;
            }
            org.slf4j.impl.c.c();
            f51709p = 3;
            r(set);
            g();
            p();
            f51710q.b();
        } catch (Exception e6) {
            e(e6);
            throw new IllegalStateException("Unexpected initialization failure", e6);
        } catch (NoClassDefFoundError e7) {
            if (m(e7.getMessage())) {
                f51709p = 4;
                j.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                j.c("Defaulting to no-operation (NOP) logger implementation");
                j.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            e(e7);
            throw e7;
        } catch (NoSuchMethodError e8) {
            String message = e8.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f51709p = 2;
                j.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                j.c("Your binding is version 1.5.5 or earlier.");
                j.c("Upgrade your binding to version 1.6.x.");
            }
            throw e8;
        }
    }

    private static void b(org.slf4j.event.d dVar, int i6) {
        if (dVar.h().d()) {
            c(i6);
        } else {
            if (dVar.h().e()) {
                return;
            }
            d();
        }
    }

    public static c i(Class<?> cls) {
        Class<?> a6;
        c j6 = j(cls.getName());
        if (f51714u && (a6 = j.a()) != null && n(cls, a6)) {
            j.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", j6.getName(), a6.getName()));
            j.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return j6;
    }

    public static c j(String str) {
        return h().a(str);
    }

    private static boolean k(Set<URL> set) {
        if (set.size() > 1) {
            return true;
        }
        return false;
    }

    private static boolean n(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static final void o() {
        a();
        if (f51709p == 3) {
            u();
        }
    }

    private static void s(Set<URL> set) {
        if (k(set)) {
            j.c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                j.c("Found binding in [" + it.next() + "]");
            }
            j.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
