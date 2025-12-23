package org.hamcrest.core;

import org.hamcrest.Factory;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class l<T> extends org.hamcrest.b<T> {
    @Factory
    public static org.hamcrest.j<Object> f() {
        return new l();
    }

    @Factory
    public static <T> org.hamcrest.j<T> g(Class<T> cls) {
        return new l();
    }

    @Override // org.hamcrest.j
    public boolean c(Object obj) {
        return obj == null;
    }

    @Override // org.hamcrest.l
    public void describeTo(org.hamcrest.g gVar) {
        gVar.b("null");
    }

    @Factory
    public static org.hamcrest.j<Object> d() {
        return k.e(f());
    }

    @Factory
    public static <T> org.hamcrest.j<T> e(Class<T> cls) {
        return k.e(g(cls));
    }
}
