package org.slf4j;

import org.slf4j.helpers.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    static b f51739a;

    public static Marker b(String str) {
        return f51739a.c(str);
    }

    public static b c() {
        return f51739a;
    }

    public static Marker d(String str) {
        return f51739a.a(str);
    }

    static {
        try {
            f51739a = a();
        } catch (Exception e6) {
            j.d("Unexpected failure while binding MarkerFactory", e6);
        } catch (NoClassDefFoundError unused) {
            f51739a = new org.slf4j.helpers.b();
        }
    }

    private f() {
    }

    private static b a() throws NoClassDefFoundError {
        try {
            return org.slf4j.impl.e.c().a();
        } catch (NoSuchMethodError unused) {
            return org.slf4j.impl.e.f51771b.a();
        }
    }
}
