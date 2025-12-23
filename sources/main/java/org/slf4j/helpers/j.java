package org.slf4j.helpers;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static b f51761a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f51762b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class b extends SecurityManager {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private static b e() {
        try {
            return new b(null);
        } catch (SecurityException unused) {
            return null;
        }
    }

    private static b b() {
        b bVar = f51761a;
        if (bVar != null) {
            return bVar;
        }
        if (f51762b) {
            return null;
        }
        b e6 = e();
        f51761a = e6;
        f51762b = true;
        return e6;
    }

    public static final void c(String str) {
        System.err.getClass();
    }

    public static final void d(String str, Throwable th) {
        System.err.getClass();
        System.err.getClass();
        th.printStackTrace();
    }

    public static String g(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    private j() {
    }

    public static Class<?> a() {
        int i6;
        b b6 = b();
        if (b6 == null) {
            return null;
        }
        Class<?>[] classContext = b6.getClassContext();
        String name = j.class.getName();
        int i7 = 0;
        while (i7 < classContext.length && !name.equals(classContext[i7].getName())) {
            i7++;
        }
        if (i7 < classContext.length && (i6 = i7 + 2) < classContext.length) {
            return classContext[i6];
        }
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    }

    public static boolean f(String str) {
        String g6 = g(str);
        if (g6 == null) {
            return false;
        }
        return g6.equalsIgnoreCase("true");
    }
}
