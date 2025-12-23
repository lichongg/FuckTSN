package org.slf4j.helpers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.Marker;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h implements org.slf4j.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f51751a;

    /* renamed from: b, reason: collision with root package name */
    private volatile org.slf4j.c f51752b;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f51753c;

    /* renamed from: d, reason: collision with root package name */
    private Method f51754d;

    /* renamed from: e, reason: collision with root package name */
    private org.slf4j.event.b f51755e;

    /* renamed from: f, reason: collision with root package name */
    private Queue<org.slf4j.event.d> f51756f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f51757g;

    @Override // org.slf4j.c
    public void debug(String str) {
        b().debug(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f51751a.equals(((h) obj).f51751a);
    }

    @Override // org.slf4j.c
    public void error(String str) {
        b().error(str);
    }

    @Override // org.slf4j.c
    public void info(String str) {
        b().info(str);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled() {
        return b().isDebugEnabled();
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled() {
        return b().isErrorEnabled();
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled() {
        return b().isInfoEnabled();
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled() {
        return b().isTraceEnabled();
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled() {
        return b().isWarnEnabled();
    }

    @Override // org.slf4j.c
    public void trace(String str) {
        b().trace(str);
    }

    @Override // org.slf4j.c
    public void warn(String str) {
        b().warn(str);
    }

    private org.slf4j.c c() {
        if (this.f51755e == null) {
            this.f51755e = new org.slf4j.event.b(this, this.f51756f);
        }
        return this.f51755e;
    }

    org.slf4j.c b() {
        return this.f51752b != null ? this.f51752b : this.f51757g ? NOPLogger.NOP_LOGGER : c();
    }

    public boolean d() {
        Boolean bool = this.f51753c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f51754d = this.f51752b.getClass().getMethod("log", org.slf4j.event.c.class);
            this.f51753c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f51753c = Boolean.FALSE;
        }
        return this.f51753c.booleanValue();
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj) {
        b().debug(str, obj);
    }

    public boolean e() {
        return this.f51752b instanceof NOPLogger;
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj) {
        b().error(str, obj);
    }

    public boolean f() {
        return this.f51752b == null;
    }

    @Override // org.slf4j.c
    public String getName() {
        return this.f51751a;
    }

    public void h(org.slf4j.c cVar) {
        this.f51752b = cVar;
    }

    public int hashCode() {
        return this.f51751a.hashCode();
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj) {
        b().info(str, obj);
    }

    @Override // org.slf4j.c
    public boolean isDebugEnabled(Marker marker) {
        return b().isDebugEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isErrorEnabled(Marker marker) {
        return b().isErrorEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isInfoEnabled(Marker marker) {
        return b().isInfoEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isTraceEnabled(Marker marker) {
        return b().isTraceEnabled(marker);
    }

    @Override // org.slf4j.c
    public boolean isWarnEnabled(Marker marker) {
        return b().isWarnEnabled(marker);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj) {
        b().trace(str, obj);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj) {
        b().warn(str, obj);
    }

    public h(String str, Queue<org.slf4j.event.d> queue, boolean z5) {
        this.f51751a = str;
        this.f51756f = queue;
        this.f51757g = z5;
    }

    @Override // org.slf4j.c
    public void debug(String str, Object obj, Object obj2) {
        b().debug(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void error(String str, Object obj, Object obj2) {
        b().error(str, obj, obj2);
    }

    public void g(org.slf4j.event.c cVar) {
        if (d()) {
            try {
                this.f51754d.invoke(this.f51752b, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    @Override // org.slf4j.c
    public void info(String str, Object obj, Object obj2) {
        b().info(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object obj, Object obj2) {
        b().trace(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object obj, Object obj2) {
        b().warn(str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void debug(String str, Object... objArr) {
        b().debug(str, objArr);
    }

    @Override // org.slf4j.c
    public void error(String str, Object... objArr) {
        b().error(str, objArr);
    }

    @Override // org.slf4j.c
    public void info(String str, Object... objArr) {
        b().info(str, objArr);
    }

    @Override // org.slf4j.c
    public void trace(String str, Object... objArr) {
        b().trace(str, objArr);
    }

    @Override // org.slf4j.c
    public void warn(String str, Object... objArr) {
        b().warn(str, objArr);
    }

    @Override // org.slf4j.c
    public void debug(String str, Throwable th) {
        b().debug(str, th);
    }

    @Override // org.slf4j.c
    public void error(String str, Throwable th) {
        b().error(str, th);
    }

    @Override // org.slf4j.c
    public void info(String str, Throwable th) {
        b().info(str, th);
    }

    @Override // org.slf4j.c
    public void trace(String str, Throwable th) {
        b().trace(str, th);
    }

    @Override // org.slf4j.c
    public void warn(String str, Throwable th) {
        b().warn(str, th);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str) {
        b().debug(marker, str);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str) {
        b().error(marker, str);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str) {
        b().info(marker, str);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str) {
        b().trace(marker, str);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str) {
        b().warn(marker, str);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object obj) {
        b().debug(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object obj) {
        b().error(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object obj) {
        b().info(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object obj) {
        b().trace(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object obj) {
        b().warn(marker, str, obj);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        b().debug(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object obj, Object obj2) {
        b().error(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object obj, Object obj2) {
        b().info(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        b().trace(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        b().warn(marker, str, obj, obj2);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Object... objArr) {
        b().debug(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Object... objArr) {
        b().error(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Object... objArr) {
        b().info(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Object... objArr) {
        b().trace(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Object... objArr) {
        b().warn(marker, str, objArr);
    }

    @Override // org.slf4j.c
    public void debug(Marker marker, String str, Throwable th) {
        b().debug(marker, str, th);
    }

    @Override // org.slf4j.c
    public void error(Marker marker, String str, Throwable th) {
        b().error(marker, str, th);
    }

    @Override // org.slf4j.c
    public void info(Marker marker, String str, Throwable th) {
        b().info(marker, str, th);
    }

    @Override // org.slf4j.c
    public void trace(Marker marker, String str, Throwable th) {
        b().trace(marker, str, th);
    }

    @Override // org.slf4j.c
    public void warn(Marker marker, String str, Throwable th) {
        b().warn(marker, str, th);
    }
}
