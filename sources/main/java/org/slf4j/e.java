package org.slf4j;

import java.io.Closeable;
import java.util.Map;
import org.slf4j.helpers.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    static final String f51717a = "http://www.slf4j.org/codes.html#null_MDCA";

    /* renamed from: b, reason: collision with root package name */
    static final String f51718b = "http://www.slf4j.org/codes.html#no_static_mdc_binder";

    /* renamed from: c, reason: collision with root package name */
    static j5.c f51719c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final String f51720a;

        /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        private b(String str) {
            this.f51720a = str;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            e.h(this.f51720a);
        }
    }

    public static void b() {
        j5.c cVar = f51719c;
        if (cVar == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        cVar.clear();
    }

    public static String c(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        j5.c cVar = f51719c;
        if (cVar != null) {
            return cVar.get(str);
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static Map<String, String> d() {
        j5.c cVar = f51719c;
        if (cVar != null) {
            return cVar.b();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static j5.c e() {
        return f51719c;
    }

    public static void f(String str, String str2) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        j5.c cVar = f51719c;
        if (cVar == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        cVar.a(str, str2);
    }

    public static void h(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("key parameter cannot be null");
        }
        j5.c cVar = f51719c;
        if (cVar == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        cVar.remove(str);
    }

    public static void i(Map<String, String> map) {
        j5.c cVar = f51719c;
        if (cVar == null) {
            throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
        cVar.c(map);
    }

    static {
        try {
            f51719c = a();
        } catch (Exception e6) {
            j.d("MDC binding unsuccessful.", e6);
        } catch (NoClassDefFoundError e7) {
            f51719c = new org.slf4j.helpers.f();
            String message = e7.getMessage();
            if (message != null && message.contains("StaticMDCBinder")) {
                j.c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                j.c("Defaulting to no-operation MDCAdapter implementation.");
                j.c("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
                return;
            }
            throw e7;
        }
    }

    private e() {
    }

    private static j5.c a() throws NoClassDefFoundError {
        try {
            return org.slf4j.impl.d.c().a();
        } catch (NoSuchMethodError unused) {
            return org.slf4j.impl.d.f51770a.a();
        }
    }

    public static b g(String str, String str2) throws IllegalArgumentException {
        f(str, str2);
        return new b(str, null);
    }
}
