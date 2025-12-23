package org.hamcrest.core;

import java.lang.reflect.Array;
import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i<T> extends org.hamcrest.b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f51292a;

    private static boolean d(Object obj, Object obj2) {
        for (int i6 = 0; i6 < Array.getLength(obj); i6++) {
            if (!g(Array.get(obj, i6), Array.get(obj2, i6))) {
                return false;
            }
        }
        return true;
    }

    private static boolean g(Object obj, Object obj2) {
        return obj == null ? obj2 == null : (obj2 == null || !i(obj)) ? obj.equals(obj2) : i(obj2) && f(obj, obj2);
    }

    @Factory
    public static <T> org.hamcrest.j<T> h(T t5) {
        return new i(t5);
    }

    @Override // org.hamcrest.j
    public boolean c(Object obj) {
        return g(obj, this.f51292a);
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.c(this.f51292a);
    }

    public i(T t5) {
        this.f51292a = t5;
    }

    private static boolean e(Object obj, Object obj2) {
        if (Array.getLength(obj) == Array.getLength(obj2)) {
            return true;
        }
        return false;
    }

    private static boolean f(Object obj, Object obj2) {
        if (e(obj, obj2) && d(obj, obj2)) {
            return true;
        }
        return false;
    }

    private static boolean i(Object obj) {
        return obj.getClass().isArray();
    }
}
